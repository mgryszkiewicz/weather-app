import org.json.simple.JSONObject;
import org.hamcrest.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GUI {
    String city;
    String location;
    double temp;


    public GUI() {
        //initialization frame
        JFrame frame = new JFrame();//creating instance of JFrame
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.getContentPane().setLayout(new GridLayout());

        //initialization panels
        JSplitPane main_panel = new JSplitPane();
        JPanel top_panel = new JPanel();
        JPanel panel_settings = new JPanel();

        //creating compontents
        final JLabel locationLabel = new JLabel("Current location: none");
        final JLabel temperatureLabel = new JLabel("Current temperature: none");

        JButton showWeather_current = new JButton("Show current weather");
        Dimension size = showWeather_current.getPreferredSize();
        showWeather_current.setBounds(40,100, size.width,size.height);

        JButton showWeather_tomorrow = new JButton("Show tomorrow weather");
        JButton showWeather_week = new JButton("Show week weather");

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
        cityInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = cityInput.getText();
            }
        });


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





        //panel settings
        main_panel.setOrientation(JSplitPane.VERTICAL_SPLIT);
        main_panel.setDividerLocation(200);
        main_panel.setTopComponent(top_panel);
        main_panel.setBottomComponent(panel_settings);

        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.PAGE_AXIS));
        top_panel.add(showWeather_current);
        top_panel.add(showWeather_tomorrow);
        top_panel.add(showWeather_week);
        top_panel.add(locationLabel);
        top_panel.add(cityInput);
        top_panel.add(temperatureLabel);



        panel_settings.setLayout(new BoxLayout(panel_settings, BoxLayout.PAGE_AXIS));
        panel_settings.add(combobox_lang);
        panel_settings.add(combobox_units);



        frame.add(main_panel);
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
        new GUI();
    }
}
