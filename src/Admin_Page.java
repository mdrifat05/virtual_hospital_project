import javax.swing.*;
import java.awt.*;

interface Admin{
    void admin();
}
public class Admin_Page implements Admin{
    private ImageIcon ap, icon;
    private JLabel admin_label,panel_label;
    Cursor cursor;
    Container ca;
    public void admin(){
        JFrame fr = new JFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(550,650);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);// can't resize
        fr.setTitle("Admin panel");
        ca = fr.getContentPane();

        icon = new ImageIcon(getClass().getResource("vh1.png"));// icon add
        fr.setIconImage(icon.getImage());
        cursor = new Cursor(cursor.HAND_CURSOR);

        //panel_label = new JLabel("Admin Panel");
        //log.setBounds(30, 5, 100, 50);// set the text where ever you want
        //c1.add(log);
        //Font font = new Font("TIMES NEW ROMAN", Font.BOLD, 20);// change font
        //log.setFont(font);

        ap = new ImageIcon(getClass().getResource("admin.png")); // for background image add.
        admin_label = new JLabel(ap);
        ca.add(admin_label);
        fr.pack();
    }
}

