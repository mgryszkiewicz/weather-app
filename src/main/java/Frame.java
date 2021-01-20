import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame {
    private JPanel mainPanel;
    private JTextField city;
    private JComboBox unit;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JButton backButton;
    private JButton applyButton;
    static JFrame frame = new JFrame("Pogodynka");

    public Frame(){
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Frame().mainPanel);
            }
        });

    }

    public static void main (String[] args) {
        frame.setContentPane(new Frame().mainPanel);
        frame.setVisible(true);
        //spawnsize
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        //spawnpoint
        frame.setLocationRelativeTo(null);
    }
}