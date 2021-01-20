import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame {
    public JPanel mainPanel;
    private JTextField city;
    private JComboBox unit;
    public JPanel rightPanel;
    private JPanel leftPanel;
    private JButton backButton;
    private JButton applyButton;
    public JSplitPane splitPanel;

    public Frame(){
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.frame.setContentPane(new Main_menu().mainPanel);
                GUI.frame.setVisible(true);
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