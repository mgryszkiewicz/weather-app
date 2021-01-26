import javax.swing.*;
import java.awt.*;

public class DailyWeather{
    public JPanel panel1 = new DailyWeatherPanel();
    public JPanel panel2 = new DailyWeatherPanel();
    public JPanel panel3 = new DailyWeatherPanel();
    public JPanel panel4 = new DailyWeatherPanel();
    public JPanel panel5 = new DailyWeatherPanel();
    public JPanel panel6 = new DailyWeatherPanel();
    public JPanel panel7 = new DailyWeatherPanel();
    public JPanel mainPanel;

    public DailyWeather() {
        JPanel[] panels = new JPanel[] {panel1, panel2, panel3, panel4, panel5, panel6, panel7};
        mainPanel = new JPanel();
        for(JPanel panel : panels) {
            panel = new DailyWeatherPanel().mainPanel;
            mainPanel.add(panel);
        }
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }
}
