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
        GridBagConstraints c = new GridBagConstraints();
        final JFrame frame = new JFrame();//creating instance of JFrame
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.getContentPane().setLayout(new GridLayout());

        //initialization panels
        final JPanel main_menu = new JPanel();
       // main_menu.setLayout(new BoxLayout(main_menu, BoxLayout.PAGE_AXIS));
        main_menu.setLayout(new GridBagLayout());
        final JSplitPane display_panel = new JSplitPane();
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
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weighty = 0.3;
        c.gridy = 0;
        main_menu.add(titleLabel, c);

        String[] units = {
                "pl",
                "en",
        };

        JComboBox combobox_units= new JComboBox(units);
        Dimension size_combo_units = combobox_units.getPreferredSize();
        combobox_units.setMaximumSize(new Dimension(400, 50));
        combobox_units.setEditable(false);
        combobox_units.setSelectedIndex(0);
        combobox_units.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
            }
        });
        c.weightx = 0.5;
        c.weighty = 0.02;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        main_menu.add(combobox_units, c);



        //Combobox languages
        String[] languages = {
                "standard",
                "metric",
                "imperial",

        };
        JComboBox combobox_lang = new JComboBox(languages);
       // combobox_lang.setAlignmentX(Component.CENTER_ALIGNMENT);
        combobox_lang.setMaximumSize(new Dimension(400, 50));
        combobox_lang.setEditable(false);
        combobox_lang.setSelectedIndex(0);
        combobox_lang.setBounds(1, 1, 1, 1);
        combobox_lang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
            }
        });
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        main_menu.add(combobox_lang, c);

        JLabel text_miejscowosc = new JLabel("Podaj miejscowość:");
        text_miejscowosc.setMaximumSize(new Dimension(700, 40));
        c.weightx = 0.5;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        main_menu.add(text_miejscowosc, c);

        final JTextField cityInput = new JTextField();
        cityInput.setMaximumSize(new Dimension(400, 40));
        cityInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = cityInput.getText();
            }
        });
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        main_menu.add(cityInput, c);



        JButton zatwierdz_button = new JButton("Zatwierdz zmiany");
        Dimension size_zatwierdz = zatwierdz_button.getPreferredSize();
        zatwierdz_button.setBounds(40,100, size_zatwierdz.width,size_zatwierdz.height);
        zatwierdz_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        main_menu.add(zatwierdz_button, c);



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
        top_panel.add(temperatureLabel);


        panel_settings.setLayout(new BoxLayout(panel_settings, BoxLayout.PAGE_AXIS));

        zatwierdz_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove (main_menu);
                frame.add(display_panel);
                frame.setVisible(true);
            }
        });
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
