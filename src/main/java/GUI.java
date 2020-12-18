import org.json.simple.JSONObject;

import javax.swing.*;
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

        JButton showWeather = new JButton("Show weather");
        showWeather.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Api api = new Api("0e082e7abe9c29697bec4d3e968c1e96");
                try {
                    JSONObject weather = api.getWeatherByCity(city, "standard", "pl");
                    location = weather.get("name").toString();
                    JSONObject weather_main = (JSONObject) weather.get("main");
                    temp = Double.parseDouble(weather_main.get("temp").toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                locationLabel.setText("Current location: " + location);
                temperatureLabel.setText("Current temperature: " + temp);
            }
        });

        final JTextField cityInput = new JTextField();
        cityInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = cityInput.getText();
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(showWeather);
        panel.add(locationLabel);
        panel.add(cityInput);
        panel.add(temperatureLabel);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Weather");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
//        JFrame f= new JFrame();//creating instance of JFrame
//        JLabel l1,l2;
//        l1 = new JLabel("Pada");
//        l1.setBounds(130,50,200, 40);
//        JButton b= new JButton("pokaz pogode");//creating instance of JButton
//        b.setBounds(130,100,100, 40);//x axis, y axis, width, height
//        f.add(l1);
//        f.add(b);//adding button in JFrame
//
//        f.setSize(400,500);//400 width and 500 height
//        f.setLayout(null);//using no layout managers
//        f.setVisible(true);//making the frame visible
    }
}
