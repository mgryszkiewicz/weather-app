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
        JFrame frame = new JFrame();//creating instance of JFrame

        final JLabel locationLabel = new JLabel("Current location: none");
        final JLabel temperatureLabel = new JLabel("Current temperature: none");

        JButton showWeather_current = new JButton("Show current weather");
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


        //Combobox units
        String[] units = {
                "pl",
                "en",
        };
        JComboBox combobox_units= new JComboBox(units);
        combobox_units.setEditable(true);
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
        combobox_lang.setEditable(true);
        combobox_lang.setSelectedIndex(1);
        combobox_lang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
            }
            });



        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(showWeather_current);
        panel.add(combobox_lang);
        panel.add(combobox_units);
        panel.add(showWeather_tomorrow);
        panel.add(showWeather_week);
        panel.add(locationLabel);
        panel.add(cityInput);
        panel.add(temperatureLabel);


        frame.add(panel, BorderLayout.CENTER);
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
