import javax.swing.*;
import java.awt.*;

public class HourlyWeatherPanel{
    public JLabel weather_desc;
    public  JLabel weather_icon;
    public  JLabel time;
    public  JLabel temp;
    public  JLabel clouds;
    public JLabel rain;
    public  JLabel pressure;
    public  JLabel snow;
    public  JLabel humidity;
    public JPanel mainPanel;

    public HourlyWeatherPanel() {
        mainPanel.setPreferredSize(new Dimension(300, 1000));
    }
}
