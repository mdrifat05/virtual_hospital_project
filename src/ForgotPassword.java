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

import javax.swing.*;

interface Forgot {
    void FPasswordMenu();
}

public class ForgotPassword extends JFrame implements Forgot {

    private Cursor cursor;
    private ImageIcon icon, BG_Img;
    private JLabel bG_Label, email_Label, title_Label, utLabel;
    private JButton lFP_Button, back_Button;
    private JTextField email_TextF;
    private Container cu;
    private JComboBox cb;
    private String[] userType = {"Patient", "Hospital", "Ambulance"};
    private int count = 0;

    public void FPasswordMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 342); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192, 192, 192));
        //setBounds(50,30,626,386);
        setResizable(false);// can't resize
        setTitle("Forgot Password Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        cu = this.getContentPane();

        //Back button
        back_Button = new JButton("Back");
        Font bt = new Font("Arial", Font.BOLD, 13);// change font
        back_Button.setFont(bt);
        back_Button.setCursor(cursor);
        back_Button.setBackground(new Color(255, 255, 255));
        back_Button.setFocusable(false);
        back_Button.setBounds(10, 10, 80, 20);
        cu.add(back_Button);


        //Title label
        title_Label = new JLabel();
        title_Label.setText("LOOK FOR YOUR PASSWORD");
        title_Label.setBounds(50, 60, 1000, 35);
        cu.add(title_Label);
        Font ur = new Font("Arial", Font.BOLD, 20);// change font
        title_Label.setFont(ur);

        //Email label
        email_Label = new JLabel();
        email_Label.setText("Enter Your Email Address:");
        email_Label.setBounds(30, 140, 1000, 20);
        cu.add(email_Label);
        Font ut = new Font("Arial", Font.BOLD, 15);// change font
        email_Label.setFont(ut);

        // Email Text field
        email_TextF = new JTextField();
        email_TextF.setBounds(30, 177, 195, 30);
        cu.add(email_TextF);

        //Look for password button
        lFP_Button = new JButton("Show me Password");
        Font flog = new Font("Arial", Font.BOLD, 14);// change font
        lFP_Button.setFont(flog);
        lFP_Button.setCursor(cursor);
        lFP_Button.setBackground(new Color(192, 192, 192));
        lFP_Button.setFocusable(false);
        lFP_Button.setBounds(180, 250, 180, 22);
        cu.add(lFP_Button);

        //user type label
        utLabel = new JLabel();
        utLabel.setText("Select User Type");
        utLabel.setBounds(35, 227, 150, 20);
        cu.add(utLabel);
        Font uu = new Font("Arial", Font.BOLD, 12);// change font
        utLabel.setFont(uu);


        //Jcombo Box
        cb = new JComboBox(userType);
        cb.setBounds(35, 253, 100, 20);
        //cb.setEditable(true);
        cu.setCursor(cursor);
        cu.add(cb);


        lFP_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Patient")) {
                    String email, ma, pass;
                    final String file = "E:\\virtual_hospital_project\\Patient\\Mail & passwords.txt";
                    try {
                        FileReader fReader = new FileReader(file);
                        BufferedReader fileBuff = new BufferedReader(fReader);
                        Scanner x = new Scanner(fileBuff);
                        while (x.hasNext()) {
                            email = x.next();
                            pass = x.next();
                            ma = email_TextF.getText();
                            if (ma.equals(email)) {
                                JOptionPane.showMessageDialog(null, "Email : " + email + " \n" + "Password : " + pass);
                                count++;
                            }
                        }
                        fileBuff.close();
                        x.close();

                        if (count == 1) {


                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Invalid Email!!");
                            email_TextF.setText("");

                        }
                    } catch (Exception ee) {

                    }
                }
            }
        });

        lFP_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Hospital")) {
                    String email, ma, pass;
                    final String file = "E:\\virtual_hospital_project\\Hospital\\Mail & passwords.txt";
                    try {
                        FileReader fReader = new FileReader(file);
                        BufferedReader fileBuff = new BufferedReader(fReader);
                        Scanner x = new Scanner(fileBuff);
                        while (x.hasNext()) {
                            email = x.next();
                            pass = x.next();
                            ma = email_TextF.getText();
                            if (ma.equals(email)) {
                                JOptionPane.showMessageDialog(null, "Email : " + email + " \n" + "Password : " + pass);
                                count++;
                                email_TextF.setText("");
                            }
                        }
                        fileBuff.close();
                        x.close();

                        if (count == 1) {


                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Invalid Email!!");
                            email_TextF.setText("");

                        }
                    } catch (Exception ee) {

                    }
                }
            }
        });

        lFP_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Ambulance")) {
                    String email, ma, pass;
                    final String file = "E:\\virtual_hospital_project\\Ambulance\\Mail & passwords.txt";
                    try {
                        FileReader fReader = new FileReader(file);
                        BufferedReader fileBuff = new BufferedReader(fReader);
                        Scanner x = new Scanner(fileBuff);
                        while (x.hasNext()) {
                            email = x.next();
                            pass = x.next();
                            ma = email_TextF.getText();
                            if (ma.equals(email)) {
                                JOptionPane.showMessageDialog(null, "Email : " + email + " \n" + "Password : " + pass);
                                count++;
                                email_TextF.setText("");
                            }
                        }
                        fileBuff.close();
                        x.close();

                        if (count == 1) {


                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Invalid Email!!");
                            email_TextF.setText("");

                        }
                    } catch (Exception ee) {

                    }
                }
            }
        });

        //Back_button
        back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login_Page l = new Login_Page();
                l.LoginMenu();
                l.setVisible(true);
            }
        });

        BG_Img = new ImageIcon(getClass().getResource("ForgotPassword.jpg")); // for background image add.
        bG_Label = new JLabel(BG_Img);
        cu.add(bG_Label);
        this.pack();
    }

}
