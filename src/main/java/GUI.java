import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame f= new JFrame();//creating instance of JFrame
        JLabel l1,l2;
        l1 = new JLabel("Pada");
        l1.setBounds(130,50,200, 40);
        JButton b= new JButton("pokaz pogode");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height
        f.add(l1);
        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}
