import org.json.simple.JSONObject;
import org.hamcrest.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import sun.audio.*;

public class GUI {
    String city;
    double pressure;
    double temp;
    static JFrame frame = new JFrame();
    static CurrentWeather currentWeather = new CurrentWeather();
    static DailyWeather dailyWeather = new DailyWeather();
    static HourlyWeather hourlyWeather = new HourlyWeather();
    static Main_menu mainMenu = new Main_menu();
    static WeatherAnalizer weatherAnalizer = new WeatherAnalizer();


    public static void music() {

        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;
        try
        {
            BGM = new AudioStream(GUI.class.getResourceAsStream("/menuTheme.wav"));
//            MD = BGM.getData();
            AudioPlayer.player.start(BGM);
//            loop = new ContinuousAudioDataStream(MD);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        MGP.start(loop);
    }


    public GUI() {
    }

    public static void main(String[] args){
        music();
        new GUI();
        frame.setContentPane(mainMenu.mainPanel);
        frame.setPreferredSize(new Dimension(660, 520));
        frame.setMinimumSize(new Dimension(660, 520));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

