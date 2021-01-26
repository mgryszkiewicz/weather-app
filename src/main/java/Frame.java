import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frame {
    public JPanel mainPanel;
    public JTextField city;
    public  JComboBox unit;
    public JPanel rightPanel;
    private JPanel leftPanel;
    private JButton backButton;
    public  JButton applyButton;
    public JSplitPane splitPanel;
    public static String cityName;
    public static String unitSelected = "metric";

    public Frame(){
        // przycisk Back służący do wracania do menu głównego
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.frame.setContentPane(new Main_menu().mainPanel);
                GUI.frame.setVisible(true);
            }
        });

        // przycisk Apply służący do zatwierdzenia wprowadzonych zmian i odświeżenia pogody
        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.weatherAnalizer.getCurrentWeather(Frame.cityName, Frame.unitSelected, Main_menu.language);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                updateCurrentWeather();
                updateDailyWeather();
                updateHourlyWeather();
            }
        });

        // pole tekstowe służące do przyjmowania nazwy miejscowości
        city.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cityName = city.getText();
            }
        });

        // combo box służący do przyjmowania rodzaju jednostek w których ma zostać wyświetlona pogoda
        unit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unitSelected = (String) unit.getSelectedItem();
            }
        });
    }

    private void updateCurrentWeather() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        URL url = null;
        try {
            url = new URL("http://openweathermap.org/img/wn/" + GUI.weatherAnalizer.currentWeather.weatherInfo.icoId.replace("n", "d") + "@2x.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            GUI.currentWeather.weather_icon.setIcon(new ImageIcon(ImageIO.read(url)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GUI.currentWeather.weather_desc.setText(GUI.weatherAnalizer.currentWeather.weatherInfo.description);
        //GUI.currentWeather.weather_icon.setIcon();
        //public  JLabel weather_icon;
        GUI.currentWeather.temp.setText(Double.toString(GUI.weatherAnalizer.currentWeather.temperature));
        GUI.currentWeather.feels_like.setText(Double.toString(GUI.weatherAnalizer.currentWeather.perceptibleTemperature));
        GUI.currentWeather.pressure.setText(Integer.toString(GUI.weatherAnalizer.currentWeather.pressure));
        GUI.currentWeather.humidity.setText(Integer.toString(GUI.weatherAnalizer.currentWeather.humidity));
        GUI.currentWeather.dew_point.setText(Double.toString(GUI.weatherAnalizer.currentWeather.dewTemperature));
        GUI.currentWeather.clouds.setText(Integer.toString(GUI.weatherAnalizer.currentWeather.cloudiness));
        GUI.currentWeather.visibility.setText(Integer.toString(GUI.weatherAnalizer.currentWeather.visibility));
        GUI.currentWeather.wind_speed.setText(Double.toString(GUI.weatherAnalizer.currentWeather.windSpeed));
        GUI.currentWeather.wind_deg.setText(Integer.toString(GUI.weatherAnalizer.currentWeather.windDeg));
        GUI.currentWeather.rain.setText(Double.toString(GUI.weatherAnalizer.currentWeather.rain + GUI.weatherAnalizer.currentWeather.snow));
        GUI.currentWeather.sunrise.setText(format.format(GUI.weatherAnalizer.currentWeather.sunriseTime));
        GUI.currentWeather.sunset.setText(format.format(GUI.weatherAnalizer.currentWeather.sunsetTime));
    }

    public void updateDailyWeather(){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM");
        for (int i = 0; i < 7; i++) {
            GUI.dailyWeather.panels[i].day.setText(format.format(GUI.weatherAnalizer.daysWeather[i].currentTime));
            GUI.dailyWeather.panels[i].temp_day.setText(Double.toString(GUI.weatherAnalizer.daysWeather[i].temperatureDay));
            GUI.dailyWeather.panels[i].weather_desc.setText(GUI.weatherAnalizer.daysWeather[i].weatherInfo.description);
            GUI.dailyWeather.panels[i].temp_night.setText(Double.toString(GUI.weatherAnalizer.daysWeather[i].perceptibleTemperatureNight));
            URL url = null;
            try {
                url = new URL("http://openweathermap.org/img/wn/" + GUI.weatherAnalizer.daysWeather[i].weatherInfo.icoId.replace("n", "d") + "@2x.png");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                GUI.dailyWeather.panels[i].weather_icon.setIcon(new ImageIcon(ImageIO.read(url)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateHourlyWeather(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        for (int i = 0; i <= 7; i++) {
            GUI.hourlyWeather.panels[i].temp.setText(Double.toString(GUI.weatherAnalizer.hoursWeather[i].temperature));
            GUI.hourlyWeather.panels[i].humidity.setText(Double.toString(GUI.weatherAnalizer.hoursWeather[i].humidity));
            GUI.hourlyWeather.panels[i].pressure.setText(Double.toString(GUI.weatherAnalizer.hoursWeather[i].pressure));
//            GUI.hourlyWeather.panels[i].rain.setText(Double.toString(GUI.weatherAnalizer.hoursWeather[i].rain));
            GUI.hourlyWeather.panels[i].rain.setText(Double.toString(GUI.weatherAnalizer.hoursWeather[i].snow + GUI.weatherAnalizer.hoursWeather[i].rain));
            GUI.hourlyWeather.panels[i].time.setText(format.format(GUI.weatherAnalizer.hoursWeather[i].currentTime));
            GUI.hourlyWeather.panels[i].weather_desc.setText(GUI.weatherAnalizer.hoursWeather[i].weatherInfo.description);
            URL url = null;
            try {
                url = new URL("http://openweathermap.org/img/wn/" + GUI.weatherAnalizer.hoursWeather[i].weatherInfo.icoId.replace("n", "d") + "@2x.png");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                GUI.hourlyWeather.panels[i].weather_icon.setIcon(new ImageIcon(ImageIO.read(url)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        BufferedImage titlePicture = null;
//        URL url = null;
//        try {
//            url = new URL("http://openweathermap.org/img/wn/10d@2x.png");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            titlePicture = ImageIO.read(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert titlePicture != null;
//        GUI.hourlyWeather.panels[0].weather_icon.setIcon(new ImageIcon(titlePicture));
    }
}