import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main_menu {
    public JPanel mainPanel;
    private JLabel titleImg;
    private JButton mainCurrentWeatherButton;
    private JButton mainDailyWeatherButton;
    private JButton mainHourlyWeatherButton;
    private JButton mainLanguageButton;
    private JPanel upperMainPanel;
    private JPanel lowerMainPanel;

    static JFrame frame = new JFrame("Main_menu");

    public Main_menu(){

        BufferedImage input_image_title = null;
        try {
            input_image_title = ImageIO.read(getClass().getResource("/titlePicture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert input_image_title != null;

        //Main current weather button action listener
        mainCurrentWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Main_menu().lowerMainPanel);
                frame.setVisible(true);
            }
        });

        //Main hourly weather button action listener
        mainHourlyWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Main_menu().mainPanel);
                frame.setVisible(true);
            }
        });

        //Main daily weather button action listener
        mainDailyWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Main_menu().mainPanel);
                frame.setVisible(true);
            }
        });
    }

    //Customize action listeners of buttons
    private void createUIComponents() {

    }


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

            //Declaring window

            System.setProperty(
                "Quaqua.design","lion"
            );

            UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
            //setting size of window
            frame.setPreferredSize(new Dimension(500, 500));
            frame.setMinimumSize(new Dimension(500, 500));

            //setting spawn point of window
            frame.setLocationRelativeTo(null);

            // Adding main panel to window
            frame.setContentPane(new Main_menu().mainPanel);
            frame.setVisible(true);
    }

}
