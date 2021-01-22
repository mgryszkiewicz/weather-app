import javax.swing.*;
import java.awt.*;

public class HourlyWeather {
    public JPanel mainPanel;
    public JPanel contentPanel;

    public HourlyWeather() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAutoscrolls(true);

        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0,0,480,470);
        contentPanel = new JPanel(null);
//        contentPanel.setPreferredSize(new Dimension(300, 300));
        contentPanel.add(scroll);

        for (int i = 0; i < 8; i ++) {
            JPanel panel = new HourlyWeatherPanel().mainPanel;
            mainPanel.add(panel);
        }
    }
}
