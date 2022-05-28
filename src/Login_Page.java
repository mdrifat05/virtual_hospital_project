import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

interface login_System {
    void LoginMenu();
}

public class Login_Page extends JFrame implements login_System{
    public String ma, pa, mail, pass, p;
    private ImageIcon icon, Bg_banner;
    private Container c1;
    private JLabel log, Bg_level;
    private JTextField tfUser;
    private JPasswordField pf;
    private JButton fpButton, loginButton, signUpB;
    private Cursor cursor;
    private JComboBox cb;
    private JLabel userLabel, passLabel, utLabel, signUpL;
    private String[] userType = {"Patient", "Hospital", "Ambulance"};
    public int l = 0;
    public String line, line1, line2;
    int count = 0;


    public void LoginMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(626, 386); // frame size
        setLocationRelativeTo(null);// frame in the middle
        setResizable(false);// can't resize
        setTitle("Virtual hospital login page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("vh1.png"));// icon add
        this.setIconImage(icon.getImage());

        c1 = this.getContentPane();
        log = new JLabel();
        log.setText("Login");
        log.setBounds(30, 5, 100, 50);// set the text where ever you want
        c1.add(log);
        Font font = new Font("TIMES NEW ROMAN", Font.BOLD, 20);// change font
        log.setFont(font);

        //for account create label
        signUpL = new JLabel();
        signUpL.setText("Don't have an account?");
        signUpL.setBounds(35, 55, 135, 20);
        c1.add(signUpL);

        //for sign up button
        signUpB = new JButton("Sign Up");
        Font supB = new Font("Arial", Font.BOLD, 11);// change font
        signUpB.setFont(supB);
        signUpB.setCursor(cursor);
        signUpB.setBounds(175, 55, 80, 20);
        c1.add(signUpB);


        //text level for user name & pass
        userLabel = new JLabel();
        userLabel.setText("Email");
        userLabel.setBounds(35, 85, 150, 20);
        c1.add(userLabel);

        // user name text field
        tfUser = new JTextField();
        tfUser.setBounds(35, 107, 195, 25);
        c1.add(tfUser);

        //pass text Label
        passLabel = new JLabel();
        passLabel.setText("Password");
        passLabel.setBounds(35, 140, 100, 20);
        c1.add(passLabel);

        //password field
        pf = new JPasswordField();
        pf.setEchoChar('*');
        pf.setBounds(35, 162, 195, 25);
        c1.add(pf);

        //forgot pass button
        fpButton = new JButton("Forgot Password?");
        Font f = new Font("Arial", Font.BOLD, 12);// change font
        fpButton.setFont(f);
        fpButton.setCursor(cursor);
        fpButton.setBounds(35, 195, 138, 20);
        c1.add(fpButton);

        //for login button
        loginButton = new JButton("Login");
        Font flog = new Font("Arial", Font.BOLD, 13);// change font
        loginButton.setFont(flog);
        loginButton.setCursor(cursor);
        loginButton.setBounds(180, 195, 70, 20);
        c1.add(loginButton);

        //user type label
        utLabel = new JLabel();
        utLabel.setText("Select User Type");
        utLabel.setBounds(35, 230, 150, 20);
        c1.add(utLabel);
        Font ut = new Font("Arial", Font.BOLD, 12);// change font
        utLabel.setFont(ut);

        //Jcombo Box
        cb = new JComboBox(userType);
        cb.setBounds(35, 260, 100, 20);
        //cb.setEditable(true);
        cb.setCursor(cursor);
        c1.add(cb);

        //action listener for sing up and combo Box for patient
        signUpB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Patient")) {
                    dispose();
                    SignUp_forPatient sp = new SignUp_forPatient();
                    sp.SignUp_patient();
                    sp.setVisible(true);
                }

            }
        });

        //action listener for sing up and combo Box for Hospital
        signUpB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Hospital")) {
                    dispose();
                    SignUp_forHospital sh = new SignUp_forHospital();
                    sh.SignUp_hospital();
                    sh.setVisible(true);
                }

            }
        });

        //action listener for sing up and combo Box for Ambulance
        signUpB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Ambulance")) {
                    dispose();
                    SignUp_forAmbulance sa = new SignUp_forAmbulance();
                    sa.SignUp_ambulance();
                    sa.setVisible(true);
                }

            }
        });
        //action listener for sing up and combo Box for Pharmacy
        /*signUpB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Pharmacy")) {
                    dispose();
                    SignUp_forAmbulance sa = new SignUp_forAmbulance();
                    sa.setVisible(true);
                }

            }
        });*/
        //action listener for sing up and combo Box for Ambulance
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m, p;
                m = tfUser.getText();
                p = pf.getText();

                if (m.equals("admin") && p.equals("123")) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    dispose();
                    Admin_Page ap = new Admin_Page();
                    ap.admin();
                }
            }
        });

        //Forget Password
        fpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ForgotPassword f=new ForgotPassword();
                f.FPasswordMenu();
                f.setVisible(true);
            }
        });
        //user login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = cb.getSelectedItem();
                if (selected.toString().equals("Patient")) {

                    final String file = "E:\\virtual_hospital_project\\Patient\\Mail & passwords.txt";
                    try {
                        FileReader fReader = new FileReader(file);
                        BufferedReader fileBuff = new BufferedReader(fReader);
                        Scanner x = new Scanner(fileBuff);
                        while (x.hasNext()) {
                            mail = x.next();
                            pass = x.next();

                            ma = tfUser.getText();
                            pa = pf.getText();

                            if (ma.equals(mail) && pa.equals(pass)) {
                                FileWriter Eb = new FileWriter("E:\\virtual_hospital_project\\Patient\\Email.txt");
                                PrintWriter E = new PrintWriter(Eb);
                                E.println(mail);
                                E.close();

                                FileReader fw = new FileReader("E:\\virtual_hospital_project\\Patient\\" + ma + ".txt");
                                BufferedReader bw = new BufferedReader(fw);
                                Scanner s = new Scanner(bw);
                                line1 = s.next();
                                line2 = s.next();
                                line = line1 + " " + line2;
                                FileWriter f1 = new FileWriter("E:\\virtual_hospital_project\\Patient\\line.txt");
                                FileWriter f2 = new FileWriter("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
                                PrintWriter p1 = new PrintWriter(f1);
                                PrintWriter p2 = new PrintWriter(f2);
                                p2.println(ma);
                                p1.println(line);
                                p1.close();
                                p2.close();
                                count++;
                            }
                        }
                        fileBuff.close();
                        x.close();
                        if (count == 1) {
                            JOptionPane.showMessageDialog(null, "Login successful");
                            dispose();
                            User_HomePage uh = new User_HomePage();
                            uh.userMenu();
                            uh.setVisible(true);
                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Login Error!!");
                            tfUser.setText("");
                            pf.setText("");

                        }
                    } catch (Exception er) {
                    }
                }
                else if (selected.toString().equals("Hospital")) {

                    final String file1 = "E:\\virtual_hospital_project\\Hospital\\Mail & passwords.txt";
                    try {
                        FileReader fReader1 = new FileReader(file1);
                        BufferedReader fileBuff1 = new BufferedReader(fReader1);
                        Scanner x1 = new Scanner(fileBuff1);
                        while (x1.hasNext()) {
                            mail = x1.next();
                            pass = x1.next();

                            ma = tfUser.getText();
                            pa = pf.getText();

                            if (ma.equals(mail) && pa.equals(pass)) {
                                FileReader fw = new FileReader("E:\\virtual_hospital_project\\Hospital\\" + ma + ".txt");
                                BufferedReader bw = new BufferedReader(fw);
                                Scanner s = new Scanner(bw);
                                line1 = s.nextLine();
                                FileWriter f1 = new FileWriter("E:\\virtual_hospital_project\\Hospital\\line.txt");
                                PrintWriter p1 = new PrintWriter(f1);
                                p1.println(line1);
                                p1.close();
                                count++;
                            }
                        }
                        fileBuff1.close();
                        x1.close();
                        if (count == 1) {
                            JOptionPane.showMessageDialog(null, "Login successful");
                            dispose();
                            HospitalLogin_Page uh = new HospitalLogin_Page();
                            uh.userMenu();
                            uh.setVisible(true);
                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Login Error!!");
                            tfUser.setText("");
                            pf.setText("");

                        }
                    } catch (Exception er) {
                    }
                }
                else if (selected.toString().equals("Ambulance")) {

                    final String file1 = "E:\\virtual_hospital_project\\Ambulance\\Mail & passwords.txt";
                    try {
                        FileReader fReader1 = new FileReader(file1);
                        BufferedReader fileBuff1 = new BufferedReader(fReader1);
                        Scanner x1 = new Scanner(fileBuff1);
                        while (x1.hasNext()) {
                            mail = x1.next();
                            pass = x1.next();

                            ma = tfUser.getText();
                            pa = pf.getText();

                            if (ma.equals(mail) && pa.equals(pass)) {
                                FileReader fw = new FileReader("E:\\virtual_hospital_project\\Ambulance\\" + ma + ".txt");
                                BufferedReader bw = new BufferedReader(fw);
                                Scanner s = new Scanner(bw);
                                line1 = s.nextLine();
                                FileWriter f1 = new FileWriter("E:\\virtual_hospital_project\\Ambulance\\line.txt");
                                PrintWriter p1 = new PrintWriter(f1);
                                p1.println(mail);
                                p1.close();
                                count++;
                            }
                        }
                        fileBuff1.close();
                        x1.close();
                        if (count == 1) {
                            JOptionPane.showMessageDialog(null, "Login successful");
                            dispose();
                            Ambulance_HomePage uh = new Ambulance_HomePage();
                            uh.Ambulance_Menu();
                            uh.setVisible(true);
                        }
                        if (count != 1) {
                            JOptionPane.showMessageDialog(null, "Login Error!!");
                            tfUser.setText("");
                            pf.setText("");

                        }
                    } catch (Exception er) {
                    }
                }            }
        });

        Bg_banner = new ImageIcon(getClass().getResource("Bp.jpg")); // for background image add.
        Bg_level = new JLabel(Bg_banner);
        //Bg_level.setBounds(50,30,626,386);
        c1.add(Bg_level);
        pack();
    }

    public String t() throws IOException {

        return line;
    }
}


