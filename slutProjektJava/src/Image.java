import javax.swing.*;
import java.awt.*;

public class Image extends JFrame {

    JButton b1;
    JLabel l1;


    public Image()
    {
        //setTitle("Background Color for JFrame");
        //setSize(400,400);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
    //setLayout(new BorderLayout());
    //setContentPane(new JLabel(new ImageIcon("akira.jpg")));
    //setLayout(new FlowLayout());
    l1=new JLabel("Here is a button");
    b1=new JButton("I am a button");
    //add(l1);
    //add(b1);
    // Just for refresh :) Not optional!
    //setSize(399,399);
    setSize(1200,800);
    setVisible(true);

}
}
