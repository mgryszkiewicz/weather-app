import javax.swing.*;
import java.awt.*;

public class HourlyWeatherPanel{
    private JLabel weather_desc;
    private JLabel weather_icon;
    private JLabel time;
    private JLabel temp;
    private JLabel clouds;
    private JLabel rain;
    private JLabel pressure;
    private JLabel snow;
    private JLabel humidity;
    public JPanel mainPanel;

    public HourlyWeatherPanel() {
        mainPanel.setPreferredSize(new Dimension(300, 1000));
    }
}
