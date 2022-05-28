import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*interface Ambulance{
    void Ambulance_Menu() throws FileNotFoundException;
}*/
public class Ambulance_HomePage extends JFrame {
    private Container ch;
    private Cursor curs1;
    private ImageIcon icon, UserImg, wall2Image;
    private JButton pickup, quit, user, Wallet;
    private JLabel need_Label, user_Label, blank_Label;
    private String q;

    public void Ambulance_Menu() throws FileNotFoundException {

        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Ambulance\\line.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.nextLine();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192, 192, 192));
        setResizable(false);// can't resize
        setTitle("Ambulance"); // title add
        //mouse cursor
        curs1 = new Cursor(curs1.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        ch = this.getContentPane();

        blank_Label = new JLabel();
        blank_Label.setText("                            ");
        ch.add(blank_Label);

        //creating hospital icon button
        UserImg = new ImageIcon("E:\\virtual_hospital_project\\src\\AMbulancee.png");
        user = new JButton(UserImg);
        user.setCursor(curs1);
        user.setBackground(new Color(255, 128, 0));
        user.setFocusable(false);
        ch.add(user);

        //user label
        user_Label = new JLabel();
        user_Label.setText("                    WELCOME," + q + "       ");
        user_Label.setForeground(Color.DARK_GRAY);
        user_Label.setBounds(100, 10, 300, 30);
        ch.add(user_Label);
        Font uf = new Font("Times new Roman", Font.BOLD, 22);
        user_Label.setFont(uf);

        //need label
        need_Label = new JLabel();
        need_Label.setText("          Choose Your Service              ");
        need_Label.setBounds(100, 10, 300, 30);
        ch.add(need_Label);
        Font ut = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        need_Label.setFont(ut);
        need_Label.setForeground(Color.DARK_GRAY);
        ch.add(need_Label);


        curs1 = new Cursor(curs1.HAND_CURSOR);


        //pickup button
        ImageIcon pickImage = new ImageIcon("E:\\virtual_hospital_project\\src\\pickup.png");
        pickup = new JButton(pickImage);
        pickup.setCursor(curs1);
        pickup.setBackground(new Color(153, 204, 255));
        pickup.setFocusable(false);

        //wallet button
        ImageIcon wall2Image = new ImageIcon("E:\\virtual_hospital_project\\src\\wallet2.png");
        Wallet = new JButton(wall2Image);
        Wallet.setCursor(curs1);
        Wallet.setBackground(new Color(153, 204, 255));
        Wallet.setFocusable(false);
        //quit button
        quit = new JButton("QUIT");
        quit.setCursor(curs1);
        quit.setBackground(new Color(255, 0, 0));
        quit.setFocusable(false);
        //adding in the frame

        setLayout(new FlowLayout(20, 40, 30));
        ch.add(pickup);
        ch.add(Wallet);
        ch.add(quit);

        //Pick up button
        pickup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Show_Pick_Up_Information a = new Show_Pick_Up_Information();
                    a.pickUpMenu();
                    a.setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //back_button
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_Page p = new Login_Page();
                p.LoginMenu();
                p.setVisible(true);
            }
        });

    }
}

