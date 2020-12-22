import org.json.simple.JSONObject;
import org.hamcrest.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import sun.audio.*;

public class GUI {
    String city;
    String location;
    double temp;

    public static void music() {

        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;
        try
        {
            BGM = new AudioStream(new FileInputStream("./src/main/resources/menuTheme.wav"));
//            MD = BGM.getData();
            AudioPlayer.player.start(BGM);
//            loop = new ContinuousAudioDataStream(MD);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        MGP.start(loop);
    }


    public GUI() {
        //initialization frame
        JFrame frame = new JFrame();//creating instance of JFrame
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.getContentPane().setLayout(new GridLayout());

        //initialization panels
        JPanel main_menu = new JPanel();

        JSplitPane display_panel = new JSplitPane();
        JPanel top_panel = new JPanel();
        JPanel panel_settings = new JPanel();

        //initialization main_menu
        BufferedImage input_image_title = null;
        try {
            input_image_title = ImageIO.read(getClass().getResource("/titlePicture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert input_image_title != null;
//Resizing input image
//        BufferedImage title_picture = new BufferedImage(420,
//        39, input_image_title.getType());
//        Graphics2D g2d = title_picture.createGraphics();
//
//        g2d.drawImage(input_image_title, 0, 0, 420, 39, null);
//        g2d.dispose();

        final JLabel titleLabel = new JLabel(new ImageIcon(input_image_title));
        titleLabel.setBounds(10, 10, 10, 10);

        String[] units = {
                "pl",
                "en",
        };

        JComboBox combobox_units= new JComboBox(units);
        combobox_units.setEditable(false);
        combobox_units.setSelectedIndex(1);
        combobox_units.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
            }
        });

        //Combobox languages
        String[] languages = {
                "standard",
                "metric",
                "imperial",

        };
        JComboBox combobox_lang = new JComboBox(languages);
        combobox_lang.setEditable(false);
        combobox_lang.setSelectedIndex(1);
        combobox_lang.setBounds(1, 1, 1, 1);
        combobox_lang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
            }
        });


        main_menu.add(titleLabel);
        main_menu.add(combobox_lang);
        main_menu.add(combobox_units);


        //creating compontents
        final JLabel locationLabel = new JLabel("Current location: none");
        final JLabel temperatureLabel = new JLabel("Current temperature: none");

        JButton showWeather_current = new JButton("Show current weather");
        Dimension size_current = showWeather_current.getPreferredSize();
        showWeather_current.setBounds(40,100, size_current.width,size_current.height);

        JButton showWeather_tomorrow = new JButton("Show tomorrow weather");
        Dimension size_tomorrow = showWeather_current.getPreferredSize();
        showWeather_current.setBounds(40,100, size_tomorrow.width,size_tomorrow.height);


        JButton showWeather_week = new JButton("Show week weather");
        Dimension size_week = showWeather_current.getPreferredSize();
        showWeather_current.setBounds(40,100, size_week.width,size_week.height);



        showWeather_current.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
               // try {
                   // JSONObject weather = api.getWeatherByCity(city, "standard", "pl");
                   // location = weather.get("name").toString();
                   // JSONObject weather_main = (JSONObject) weather.get("main");
                   // temp = Double.parseDouble(weather_main.get("temp").toString());
               // } catch (IOException ioException) {
               //     ioException.printStackTrace();
                //}
               // locationLabel.setText("Current location: " + location);
                //temperatureLabel.setText("Current temperature: " + temp);
            }
        });

        final JTextField cityInput = new JTextField();
        cityInput.setMaximumSize(new Dimension(700, 40));
        cityInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = cityInput.getText();
            }
        });







        //panel settings
        display_panel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        display_panel.setDividerLocation(370);
        display_panel.setResizeWeight(1.0);
        display_panel.setLeftComponent(top_panel);
        display_panel.setRightComponent(panel_settings);
        display_panel.setOpaque(false);

        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.PAGE_AXIS));
        top_panel.setAlignmentX(0.1f);
        top_panel.add(showWeather_current);
        top_panel.add(showWeather_tomorrow);
        top_panel.add(showWeather_week);
        top_panel.add(locationLabel);
        top_panel.add(cityInput);
        top_panel.add(temperatureLabel);


        panel_settings.setLayout(new BoxLayout(panel_settings, BoxLayout.PAGE_AXIS));



        //frame.add(display_panel);
        frame.add(main_menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Weather");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.setProperty(
                "Quaqua.design","lion"
        );
        UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        music();
        new GUI();
    }
}
