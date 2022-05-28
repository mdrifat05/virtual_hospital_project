

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
import java.util.Scanner;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

interface Hospital{
    void userMenu() throws FileNotFoundException;
}

public class HospitalLogin_Page extends JFrame implements Hospital {
    private Container ch;
    private Cursor curs1;
    private ImageIcon icon, newImg, docImagee, UserImg, wallImage, AppImage;
    private JButton docAppo, wallet, user, quit, emergency, Appointment;
    private JLabel need_Label, user_Label, blank_Label;
    private String q;

    public void userMenu() throws FileNotFoundException {
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Hospital\\line.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.nextLine();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        //setBounds(50,30,626,386);
        getContentPane().setBackground(new Color(192, 192, 192));
        setResizable(false);// can't resize
        setTitle("Hospital Page"); // title add
        //mouse cursor
        curs1 = new Cursor(curs1.HAND_CURSOR);
        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        ch = this.getContentPane();

        //creating hospital icon button
        UserImg = new ImageIcon("E:\\virtual_hospital_project\\src\\hospitalPAGe.png");
        user = new JButton(UserImg);
        user.setCursor(curs1);
        user.setBackground(new Color(255, 128, 0));
        user.setFocusable(false);
        ch.add(user);

        //user label
        user_Label = new JLabel();
        user_Label.setText(q);
        user_Label.setForeground(Color.DARK_GRAY);
        user_Label.setBounds(100, 10, 300, 30);
        ch.add(user_Label);
        Font uf = new Font("Times new Roman", Font.BOLD, 22);
        user_Label.setFont(uf);

        //need label
        need_Label = new JLabel();
        need_Label.setText("        CHOOSE A SERVICE              ");
        need_Label.setBounds(100, 10, 300, 30);
        ch.add(need_Label);
        Font ut = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        need_Label.setFont(ut);
        need_Label.setForeground(Color.DARK_GRAY);
        ch.add(need_Label);
        curs1 = new Cursor(curs1.HAND_CURSOR);

        //doctor button
        ImageIcon docImage = new ImageIcon("E:\\virtual_hospital_project\\src\\doctor.png");
        docAppo = new JButton(docImage);
        docAppo.setCursor(curs1);
        docAppo.setBackground(new Color(153, 204, 255));
        docAppo.setFocusable(false);

        //Appointment Button
        ImageIcon AppImage = new ImageIcon("E:\\virtual_hospital_project\\src\\Appointment.png");
        Appointment = new JButton(AppImage);
        Appointment.setCursor(curs1);
        Appointment.setBackground(new Color(153, 204, 255));
        Appointment.setFocusable(false);

        //emergency button
        ImageIcon newImg = new ImageIcon("E:\\virtual_hospital_project\\src\\EMERGENCY.png");
        emergency = new JButton(newImg);
        emergency.setCursor(curs1);
        emergency.setBackground(new Color(153, 204, 255));
        emergency.setFocusable(false);

        //quit button
        quit = new JButton("QUIT");
        quit.setCursor(curs1);
        quit.setBackground(new Color(153, 0, 0));
        quit.setFocusable(false);

        //adding in the frame
        setLayout(new FlowLayout(20, 20, 30));
        ch.add(docAppo);
        ch.add(Appointment);
        ch.add(emergency);

        blank_Label = new JLabel();
        blank_Label.setText("                   ");
        ch.add(blank_Label);
        Font u = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 23);// change font
        blank_Label.setFont(u);


        blank_Label = new JLabel();
        blank_Label.setText("       ");
        ch.add(blank_Label);
        Font a = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        blank_Label.setFont(a);
        setLayout(new FlowLayout(20, 30, 50));
        ch.add(quit);

        //Appointment Action_listener
        Appointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Give_Appointment_Info g = new Give_Appointment_Info();
                try {
                    g.Appointment_Info();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                g.setVisible(true);
            }
        });

        //Back Button
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login_Page l = new Login_Page();
                l.LoginMenu();
                l.setVisible(true);
            }
        });

    }

}