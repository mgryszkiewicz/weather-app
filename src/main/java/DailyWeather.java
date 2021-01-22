import javax.swing.*;
import java.awt.*;

public class DailyWeather{
    private JPanel panel1;;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
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
