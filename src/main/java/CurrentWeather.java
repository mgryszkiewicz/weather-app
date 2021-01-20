import javax.swing.*;
import java.awt.*;

public class CurrentWeather {
    private JPanel mainPanel;
    private JLabel weatherDescription;
    private JLabel weatherIcon;
    private JLabel temp;
    private JLabel feels_like;
    private JLabel pressure;
    private JLabel humidity;
    private JLabel dew_point;
    private JLabel clouds;
    private JLabel visibility;
    private JLabel wind_speed;
    private JLabel wind_deg;
    private JLabel rain;
    private JLabel snow;
    private JLabel sunrise;
    private JLabel sunset;

    static JFrame frame = new JFrame("Pogodynka");

    public CurrentWeather(){

    }

    public static void main (String[] args) {
        frame.setContentPane(new CurrentWeather().mainPanel);
        frame.setVisible(true);
        //spawnsize
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        //spawnpoint
        frame.setLocationRelativeTo(null);
    }
}
