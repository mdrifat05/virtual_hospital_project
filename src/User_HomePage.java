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
import javax.swing.*;

interface UserHomePage{
    void userMenu() throws FileNotFoundException;
}
public class User_HomePage extends Login_Page implements UserHomePage{

    public String q;
    private Container cu;
    private Cursor cursor;
    private ImageIcon icon, UserImg, appoImg, hospImg, emerImg, covImg, ambuImg, pharmImg, walImg;
    private JButton user, appointment, hospital, emergency, covid, ambulance, pharmacy, wallet, quit;
    private JLabel need_Label, user_label, blank_Label;

    public void userMenu() throws FileNotFoundException {
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Patient\\line.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.next();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192, 192, 192));
        //setBounds(50,30,626,386);
        setResizable(false);// can't resize
        setTitle("Home Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        cu = this.getContentPane();


        //creating user icon button
        UserImg = new ImageIcon("E:\\virtual_hospital_project\\src\\User (1).png");
        user = new JButton(UserImg);
        user.setCursor(cursor);
        user.setBackground(new Color(255, 128, 0));
        user.setFocusable(false);
        cu.add(user);

        //user profile label
        user_label = new JLabel();
        user_label.setText("Hello," + q);
        user_label.setBounds(100, 10, 300, 30);
        cu.add(user_label);
        Font uf = new Font("Adobe Gothic Std B", Font.BOLD, 20);// change font
        user_label.setFont(uf);
        user_label.setForeground(Color.DARK_GRAY);
        cu.add(user_label);

        //need label
        need_Label = new JLabel();
        need_Label.setText("What are you looking for?              ");
        need_Label.setBounds(100, 10, 300, 30);
        cu.add(need_Label);
        Font ut = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        need_Label.setFont(ut);
        need_Label.setForeground(Color.DARK_GRAY);
        cu.add(need_Label);


        //Creating JButton with image

        appoImg = new ImageIcon("E:\\virtual_hospital_project\\src\\Appointment.png");
        emerImg = new ImageIcon("E:\\virtual_hospital_project\\src\\EMERGENCY.png");
        covImg = new ImageIcon("E:\\virtual_hospital_project\\src\\COVID.png");
        ambuImg = new ImageIcon("E:\\virtual_hospital_project\\src\\AMBULANCE.png");
        pharmImg = new ImageIcon("E:\\virtual_hospital_project\\src\\PHARMACYBUTTON.png");
        walImg = new ImageIcon("E:\\virtual_hospital_project\\src\\wallet.png");
        hospImg = new ImageIcon("E:\\virtual_hospital_project\\src\\Hospital.png");

        //appointment button
        appointment = new JButton(appoImg);
        appointment.setCursor(cursor);
        appointment.setBackground(new Color(153, 204, 255));
        appointment.setFocusable(false);

        //hospital button
        hospital = new JButton(hospImg);
        hospital.setCursor(cursor);
        hospital.setBackground(new Color(153, 204, 255));
        hospital.setFocusable(false);

        //emergency button
        emergency = new JButton(emerImg);
        emergency.setCursor(cursor);
        emergency.setBackground(new Color(153, 204, 255));
        emergency.setFocusable(false);


        //covid button
        covid = new JButton(covImg);
        covid.setCursor(cursor);
        covid.setBackground(new Color(153, 204, 255));
        covid.setFocusable(false);


        //ambulance button
        ambulance = new JButton(ambuImg);
        ambulance.setCursor(cursor);
        ambulance.setBackground(new Color(153, 204, 255));
        ambulance.setFocusable(false);


        //pharmacy button
        pharmacy = new JButton(pharmImg);
        pharmacy.setCursor(cursor);
        pharmacy.setBackground(new Color(153, 204, 255));
        pharmacy.setFocusable(false);


        //wallet button
        wallet = new JButton(walImg);
        wallet.setCursor(cursor);
        wallet.setBackground(new Color(153, 204, 255));
        wallet.setFocusable(false);

        //quit button
        quit = new JButton("QUIT");
        quit.setCursor(cursor);
        quit.setBackground(new Color(255, 0, 0));
        quit.setFocusable(false);


        //adding in the frame

        setLayout(new FlowLayout(15, 35, 25));
        cu.add(appointment);
        cu.add(hospital);
        cu.add(emergency);
        cu.add(covid);
        cu.add(ambulance);
        cu.add(pharmacy);


        //Blank label
        blank_Label = new JLabel();
        blank_Label.setText("                 ");
        cu.add(blank_Label);
        Font mt = new Font("Adobe Gothic Std B", Font.BOLD, 24);// change font
        blank_Label.setFont(mt);
        blank_Label.setForeground(Color.DARK_GRAY);
        cu.add(blank_Label);
        cu.add(wallet);

        //User_Button
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_ProfilePage u=new User_ProfilePage();
                try {
                    u.profileMenu();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                u.setVisible(true);
            }
        });


        //adding wallet Button
        wallet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_WalletHomePage hp =  new User_WalletHomePage();
                hp.walletMenu();
                hp.setVisible(true);
            }
        });

        //Appointment Button
        appointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Show_AppointmentInfo sh=new Show_AppointmentInfo();
                sh.Appointment_display();
                sh.setVisible(true);
            }
        });

        //Ambulance button
        ambulance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ambulance_PickUpPage a=new Ambulance_PickUpPage();
                try {
                    a.pickUpMenu();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                a.setVisible(true);
            }
        });

        //Emergency Button
        emergency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_EmergencyPage u=new User_EmergencyPage();
                u.emergencyMenu();
                u.setVisible(true);
            }
        });

        //Hospital Button
        hospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Unavailable_ServiceFrame u=new Unavailable_ServiceFrame();
                u.setVisible(true);
            }
        });

        //Covid-19 Button
        covid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Unavailable_ServiceFrame u=new Unavailable_ServiceFrame();
                u.setVisible(true);
            }
        });

        //Pharmacy Button
        pharmacy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Unavailable_ServiceFrame u=new Unavailable_ServiceFrame();
                u.setVisible(true);
            }
        });

        //Quit button
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login_Page l=new Login_Page();
                l.LoginMenu();
                l.setVisible(true);
            }
        });

        //Blank label
        blank_Label = new JLabel();
        blank_Label.setText("                 ");
        cu.add(blank_Label);
        Font at = new Font("Adobe Gothic Std B", Font.BOLD, 25);// change font
        blank_Label.setFont(at);
        blank_Label.setForeground(Color.DARK_GRAY);

        //adding quite Button
        cu.add(quit);

    }

}

