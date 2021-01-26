import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurrentWeather {
    public  JPanel mainPanel;
    public  JLabel weather_desc;
    public  JLabel weather_icon;
    public  JLabel temp;
    public  JLabel feels_like;
    public  JLabel pressure;
    public  JLabel humidity;
    public  JLabel dew_point;
    public  JLabel clouds;
    public  JLabel visibility;
    public  JLabel wind_speed;
    public  JLabel wind_deg;
    public  JLabel rain;
    public  JLabel snow;
    public  JLabel sunrise;
    public  JLabel sunset;
    public static class NewClass {
        public void putTextNow (JLabel label) {
            clouds.setText("OK!");
        }
    }
    public CurrentWeather(){
    }

//    public static void main (String[] args) {
//        GUI.frame.setContentPane(new CurrentWeather().mainPanel);
//        GUI.frame.setVisible(true);
//        //spawnsize
//        GUI.frame.setPreferredSize(new Dimension(500, 500));
//        GUI.frame.setMinimumSize(new Dimension(500, 500));
//        //spawnpoint
//        GUI.frame.setLocationRelativeTo(null);
//    }

    public void actionPerformed(ActionEvent e)
    {
        //weather_icon.setText(GUI.weatherAnalizer.currentWeather.weatherInfo.icoId);
        weather_desc.setText(GUI.weatherAnalizer.currentWeather.weatherInfo.description);
        temp.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.temperature));
        feels_like.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.perceptibleTemperature));
        pressure.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.pressure));
        humidity.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.humidity));
        dew_point.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.dewTemperature));
        clouds.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.cloudiness));
        visibility.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.visibility));
        wind_speed.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.windSpeed));
        wind_deg.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.windDeg));
        if (GUI.weatherAnalizer.currentWeather.isRaining) {
           rain.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.rain));
        }
        else{
            rain.setText(String.valueOf("-"));
        }
        if (GUI.weatherAnalizer.currentWeather.isSnowing) {
            snow.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.snow));
        }
        else{
            snow.setText(String.valueOf("-"));
        }
        sunrise.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.sunriseTime));
        sunset.setText(String.valueOf(GUI.weatherAnalizer.currentWeather.sunsetTime));
    }
}
