import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_menu{
    public JPanel mainPanel;
    private JLabel titleImg;
    private JButton mainCurrentWeatherButton;
    private JButton mainDailyWeatherButton;
    private JButton mainHourlyWeatherButton;
    private JButton mainLanguageButton;
    private JPanel upperMainPanel;
    private JPanel lowerMainPanel;
    public static String language = "pl";


    public Main_menu(){

        //Main current weather button action listener
        mainCurrentWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame frameCurrentWeather = new Frame();
                frameCurrentWeather.splitPanel.setRightComponent(GUI.currentWeather.mainPanel);
                GUI.frame.setContentPane(frameCurrentWeather.mainPanel);
                GUI.frame.setVisible(true);
            }
        });

        //Main hourly weather button action listener
        mainHourlyWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame frameCurrentWeather = new Frame();
                frameCurrentWeather.splitPanel.setRightComponent(GUI.hourlyWeather.contentPanel);
                GUI.frame.setContentPane(frameCurrentWeather.mainPanel);
                GUI.frame.setVisible(true);
            }
        });

        //Main daily weather button action listener
        mainDailyWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame frameCurrentWeather = new Frame();
                frameCurrentWeather.splitPanel.setRightComponent(GUI.dailyWeather.contentPanel);
                GUI.frame.setContentPane(frameCurrentWeather.mainPanel);
                GUI.frame.setVisible(true);
            }
        });

        mainLanguageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(language.equals("en")){
                    language = "pl";
                    mainLanguageButton.setText("English");
                }
                else{
                    language = "en";
                    mainLanguageButton.setText("Polski");
                }
                System.out.println(language);
            }
        });
    }

    //Customize action listeners of buttons
    private void createUIComponents() {

    }


//    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
//
//            //Declaring window
//
//            System.setProperty(
//                "Quaqua.design","lion"
//            );
//
//            UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//            //setting size of window
//            frame.setPreferredSize(new Dimension(500, 500));
//            frame.setMinimumSize(new Dimension(500, 500));
//
//            //setting spawn point of window
//            frame.setLocationRelativeTo(null);
//
//            // Adding main panel to window
//            frame.setContentPane(new Main_menu().mainPanel);
//            frame.setVisible(true);
//    }

}
