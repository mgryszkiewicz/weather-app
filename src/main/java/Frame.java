import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame {
    public JPanel mainPanel;
    public JTextField city;
    public  JComboBox unit;
    public JPanel rightPanel;
    private JPanel leftPanel;
    private JButton backButton;
    public  JButton applyButton;
    public JSplitPane splitPanel;
    public static String cityName;
    public static String unitSelected;

    public Frame(){
        // przycisk Back służący do wracania do menu głównego
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.frame.setContentPane(new Main_menu().mainPanel);
                GUI.frame.setVisible(true);
            }
        });

        // przycisk Apply służący do zatwierdzenia wprowadzonych zmian i odświeżenia pogody
        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.weatherAnalizer.getCurrentWeather(Frame.cityName, Frame.unitSelected, Main_menu.language);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        // pole tekstowe służące do przyjmowania nazwy miejscowości
        city.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cityName = city.getText();
            }
        });

        // combo box służący do przyjmowania rodzaju jednostek w których ma zostać wyświetlona pogoda
        unit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unitSelected = (String) unit.getSelectedItem();
            }
        });
    }

//    public static void main (String[] args) {
//        GUI.frame.setContentPane(new Frame().mainPanel);
//        GUI.frame.setVisible(true);
//        //spawnsize
//        GUI.frame.setPreferredSize(new Dimension(500, 500));
//        GUI.frame.setMinimumSize(new Dimension(500, 500));
//        //spawnpoint
//        GUI.frame.setLocationRelativeTo(null);
//    }
}