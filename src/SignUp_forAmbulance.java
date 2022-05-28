import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface ambulance {
    void SignUp_ambulance();
}

public class SignUp_forAmbulance extends JFrame implements ambulance{

    private Container cA;
    private ImageIcon imageA, Amb_Pic;
    private JLabel sign_label, SignHere_label, DriverName_label, drivingLicence_label, PhnNumber_label, Email_label, Password_label, HospitalName_label, Location_label;
    private JTextField driverName_TextF, drivingLicence_TextF, PhnNumber_TextF, Email_TextF, Password_TextF, HospitalName_TextF;
    private Cursor cur;
    private JTextArea Add_Area;
    private JCheckBox terms_CheckBox;
    private JButton Submit_Button, Reset_Button, Back_Button;
    private int n;

    File f=new File("E:\\virtual_hospital_project\\Ambulance");
    File path=new File("E:\\virtual_hospital_project\\Ambulance\\Serial");

    void createFolder1(){
        if(!f.exists()){
            f.mkdirs();
        }
        if(!path.exists()){
            path.mkdirs();
        }
    }

    public void SignUp_ambulance() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registration form for Hospital"); // title add
        imageA = new ImageIcon(getClass().getResource("/vh1.png"));
        this.setIconImage(imageA.getImage());
        cA = this.getContentPane();


        cur = new Cursor(cur.HAND_CURSOR);
        //Register label
        SignHere_label = new JLabel();
        SignHere_label.setText("Register Here");
        SignHere_label.setBounds(390, 10, 300, 30);
        cA.add(SignHere_label);
        Font ut = new Font("Helvetica", Font.BOLD, 20);// change font
        SignHere_label.setFont(ut);
        SignHere_label.setForeground(Color.black);
        cA.add(SignHere_label);

        //Driver Name label
        DriverName_label = new JLabel();
        DriverName_label.setText("Hospital Name :");
        DriverName_label.setBounds(45, 60, 140, 20);
        cA.add(DriverName_label);
        Font fn = new Font("Arial", Font.BOLD, 15);// change font
        DriverName_label.setFont(fn);
        DriverName_label.setForeground(Color.black);
        cA.add(DriverName_label);

        // Driver name text field
        driverName_TextF = new JTextField();
        driverName_TextF.setBounds(45, 80, 195, 25);
        cA.add(driverName_TextF);

        //Hospital Ambulance Name label
        HospitalName_label = new JLabel();
        HospitalName_label.setText("Driver Name :");
        HospitalName_label.setBounds(45, 120, 150, 20);
        cA.add(HospitalName_label);
        Font ln = new Font("Arial", Font.BOLD, 15);// change font
        HospitalName_label.setFont(ln);
        HospitalName_label.setForeground(Color.black);
        cA.add(HospitalName_label);

        // field
        HospitalName_TextF = new JTextField();
        HospitalName_TextF.setBounds(45, 140, 195, 25);
        cA.add(HospitalName_TextF);

        //Driving Licence label
        drivingLicence_label = new JLabel();
        drivingLicence_label.setText("Driving Licence Number :");
        drivingLicence_label.setBounds(45, 180, 200, 20);
        cA.add(drivingLicence_label);
        Font un = new Font("Arial", Font.BOLD, 15);// change font
        drivingLicence_label.setFont(ln);
        drivingLicence_label.setForeground(Color.black);
        cA.add(drivingLicence_label);

        //Driving Licence text field
        drivingLicence_TextF = new JTextField();
        drivingLicence_TextF.setBounds(45, 200, 195, 25);
        cA.add(drivingLicence_TextF);

        //Phone Number label
        PhnNumber_label = new JLabel();
        PhnNumber_label.setText("Phone Number :");
        PhnNumber_label.setBounds(45, 240, 140, 20);
        cA.add(PhnNumber_label);
        Font pn = new Font("Arial", Font.BOLD, 15);// change font
        PhnNumber_label.setFont(pn);
        PhnNumber_label.setForeground(Color.black);
        cA.add(PhnNumber_label);

        // Phone Number text field
        PhnNumber_TextF = new JTextField();
        PhnNumber_TextF.setBounds(45, 260, 195, 25);
        cA.add(PhnNumber_TextF);

        //Email label
        Email_label = new JLabel();
        Email_label.setText("Email :");
        Email_label.setBounds(45, 300, 100, 20);
        cA.add(Email_label);
        Font Em = new Font("Arial", Font.BOLD, 15);// change font
        Email_label.setFont(Em);
        Email_label.setForeground(Color.black);
        cA.add(Email_label);

        // Email text field
        Email_TextF = new JTextField();
        Email_TextF.setBounds(45, 320, 195, 25);
        cA.add(Email_TextF);

        // Password label
        Password_label = new JLabel();
        Password_label.setText("Password :");
        Password_label.setBounds(45, 360, 100, 20);
        cA.add(Password_label);
        Font pass = new Font("Arial", Font.BOLD, 15);// change font
        Password_label.setFont(pass);
        Password_label.setForeground(Color.black);
        cA.add(Password_label);

        // Password field
        Password_TextF = new JTextField();
        Password_TextF.setBounds(45, 380, 195, 25);
        cA.add(Password_TextF);

        //Location label
        Location_label = new JLabel("Location :");
        Location_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Location_label.setBounds(45, 420, 100, 20);
        cA.add(Location_label);
        Font add = new Font("Arial", Font.BOLD, 15);// change font
        Location_label.setFont(add);
        Location_label.setForeground(Color.black);
        cA.add(Location_label);

        // Location Text Area
        Add_Area = new JTextArea();
        Add_Area.setFont(new Font("Arial", Font.PLAIN, 15));
        Add_Area.setBounds(45, 440, 200, 75);
        Add_Area.setLineWrap(true);
        Add_Area.setWrapStyleWord(true);
        cA.add(Add_Area);

        // CheckBox for terms and Condition
        terms_CheckBox = new JCheckBox("Accept Terms And Conditions.");
        terms_CheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        terms_CheckBox.setBounds(38, 540, 235, 20);
        terms_CheckBox.setCursor(cur);
        cA.add(terms_CheckBox);

        //Submit Button
        Submit_Button = new JButton("Submit");
        Submit_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Submit_Button.setBounds(45, 590, 90, 20);
        Submit_Button.setCursor(cur);
        cA.add(Submit_Button);

        //Reset Button
        Reset_Button = new JButton("Reset");
        Reset_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Reset_Button.setBounds(170, 590, 90, 20);
        Reset_Button.setCursor(cur);
        cA.add(Reset_Button);

        //for Back Button
        Back_Button = new JButton("Back to login");
        Back_Button.setFont(new Font("Arial", Font.BOLD, 12));
        Back_Button.setBounds(5, 5, 120, 20);
        Back_Button.setCursor(cur);
        cA.add(Back_Button);

        //Back button action listener
        Back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login_Page frame = new Login_Page();
                frame.LoginMenu();
                frame.setVisible(true);
            }
        });
        //Submit Button ActionListener

        Submit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Submit_Button){
                    if (terms_CheckBox.isSelected()){
                        String Driver_Name,Driver_License,Driver_email,Driver_pass,Driver_phn,Driver_Hospital,Driver_Address;
                        createFolder1();
                        try {
                            FileReader fr = new FileReader(path + "\\Serial.txt");
                            System.out.println("file exists!");
                            BufferedReader br = new BufferedReader(fr);
                            String line;
                            while ((line = br.readLine()) != null) {
                                n = Integer.parseInt(line);
                                System.out.println(line);
                            }
                            //driverName_TextF, drivingLicence_TextF, PhnNumber_TextF, Email_TextF, Password_TextF, HospitalName_TextF
                            Driver_Name = driverName_TextF.getText();
                            Driver_License = drivingLicence_TextF.getText();
                            Driver_phn = PhnNumber_TextF.getText();
                            Driver_email=Email_TextF.getText();
                            Driver_pass=Password_TextF.getText();
                            Driver_Hospital=HospitalName_TextF.getText();
                            Driver_Address=Add_Area.getText();
                            try {
                                FileReader a = new FileReader(f+"\\"+Driver_email+".txt");
                                System.out.println("file exists!");
                            } catch (FileNotFoundException ex) {
                                try {
                                    FileWriter fw = new FileWriter(f+"\\"+Driver_email+".txt");
                                    System.out.println("File created");
                                    try {
                                        FileWriter fowl=new FileWriter(f+"\\"+Driver_email+".txt");
                                        PrintWriter pwl=new PrintWriter(fowl);
                                        pwl.println(Driver_Name);
                                        pwl.println(Driver_License);
                                        pwl.println(Driver_phn);
                                        pwl.println(Driver_email);
                                        pwl.println(Driver_pass);
                                        pwl.println(Driver_Hospital);
                                        pwl.println(Driver_Address);
                                        pwl.close();
                                        try {
                                            FileWriter fq=new FileWriter("E:\\virtual_hospital_project\\Ambulance\\List.txt",true);
                                            fq.write("" + Driver_Name + "   /" + Driver_Hospital + "   /" + Driver_Address + "   /" + Driver_email + "   /" + Driver_phn);
                                            fq.write(System.getProperty("line.separator"));
                                            fq.close();
                                        } catch (IOException ioException) {
                                            ioException.printStackTrace();
                                        }
                                        try {
                                            FileWriter Writer = new FileWriter("E:\\virtual_hospital_project\\Ambulance\\Mail & passwords.txt", true);
                                            Writer.write("" + Driver_email+ " " + Driver_pass);
                                            Writer.write(System.getProperty("line.separator"));
                                            Writer.close();
                                            JOptionPane.showMessageDialog(null, "Registration Successful");
                                            //setVisible(false);
                                        } catch (Exception er) {

                                            JOptionPane.showMessageDialog(null, "Error");
                                        }
                                    } catch (IOException ex1) {
                                        Logger.getLogger(SignUp_forAmbulance.class.getName()).log(Level.SEVERE, null, ex1);
                                    }
                                    n=n+1;
                                    FileWriter fow=new FileWriter(path+"\\Serial.txt");
                                    PrintWriter pw=new PrintWriter(fow);
                                    pw.println(n);
                                    pw.close();
                                } catch (IOException ex1) {
                                    Logger.getLogger(SignUp_forAmbulance.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        } catch (IOException ex) {
                            try {
                                FileWriter fw = new FileWriter(path+"\\Serial.txt");
                                System.out.println("File created");
                            } catch (IOException ex1) {
                                Logger.getLogger(SignUp_forAmbulance.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        }

                    }

                }
                dispose();
                Login_Page frame = new Login_Page();
                frame.LoginMenu();
                frame.setVisible(true);
            }
        });

        Amb_Pic = new ImageIcon(getClass().getResource("/Amb.jpg")); // for background image add.
        sign_label = new JLabel(Amb_Pic);
        //Bg_level.setBounds(50,30,626,386);
        cA.add(sign_label);
        pack();
    }
}

