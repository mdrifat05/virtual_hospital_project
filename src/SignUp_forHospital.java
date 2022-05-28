import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface hospital_ {
    public abstract void SignUp_hospital();
}

public class SignUp_forHospital extends JFrame implements hospital_ {
    private Container cH;
    private ImageIcon imageH, hos_pic;
    private Cursor cur;
    private JRadioButton private_Button, public_Button;
    private ButtonGroup classification_BG;
    private JTextArea Add_Area;
    private JCheckBox terms_CheckBox;
    private JButton Submit_Button, Reset_Button, Back_Button;

    private JLabel sign_label, SignHere_label, hospitalName_label, PhnNumber_label, Email_label, Beds_label, wards_label, Icu_label, Password_label, classification_label, Address_label;
    private JTextField hF, HospitalName_TextF, PhnNumber_TextF, Email_TextF, Beds_TextF, Wards_TextF, Icu_TextF, Password_TextF;

    private int n;

    File f = new File("E:\\virtual_hospital_project\\Hospital");
    File path = new File("E:\\virtual_hospital_project\\Hospital\\Serial");

    void createFolder1() {
        if (!f.exists()) {
            f.mkdirs();
        }
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    public void SignUp_hospital() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(705, 719);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registration form for Hospital"); // title add
        imageH = new ImageIcon(getClass().getResource("/vh1.png"));
        this.setIconImage(imageH.getImage());
        cH = this.getContentPane();

        cur = new Cursor(cur.HAND_CURSOR);
        //Register label
        SignHere_label = new JLabel();
        SignHere_label.setText("Register Here");
        SignHere_label.setBounds(320, 10, 300, 30);
        cH.add(SignHere_label);
        Font ut = new Font("Helvetica", Font.BOLD, 20);// change font
        SignHere_label.setFont(ut);
        SignHere_label.setForeground(Color.black);
        cH.add(SignHere_label);

        //Hospital Name label
        hospitalName_label = new JLabel();
        hospitalName_label.setText("Hospital Name :");
        hospitalName_label.setBounds(45, 70, 150, 20);
        cH.add(hospitalName_label);
        Font fn = new Font("Arial", Font.BOLD, 15);// change font
        hospitalName_label.setFont(fn);
        hospitalName_label.setForeground(Color.black);
        cH.add(hospitalName_label);

        //Hospital Name text field
        HospitalName_TextF = new JTextField();
        HospitalName_TextF.setBounds(45, 90, 195, 25);
        cH.add(HospitalName_TextF);

        //Phone Number label
        PhnNumber_label = new JLabel();
        PhnNumber_label.setText("Phone Number :");
        PhnNumber_label.setBounds(45, 130, 150, 20);
        cH.add(PhnNumber_label);
        Font ln = new Font("Arial", Font.BOLD, 15);// change font
        PhnNumber_label.setFont(ln);
        PhnNumber_label.setForeground(Color.black);
        cH.add(PhnNumber_label);

        //Phone Number text field
        PhnNumber_TextF = new JTextField();
        PhnNumber_TextF.setBounds(45, 150, 195, 25);
        cH.add(PhnNumber_TextF);

        //Email label
        Email_label = new JLabel();
        Email_label.setText("Email :");
        Email_label.setBounds(45, 190, 140, 20);
        cH.add(Email_label);
        Font pn = new Font("Arial", Font.BOLD, 15);// change font
        Email_label.setFont(pn);
        Email_label.setForeground(Color.black);
        cH.add(Email_label);

        //Email text field
        Email_TextF = new JTextField();
        Email_TextF.setBounds(45, 210, 195, 25);
        cH.add(Email_TextF);

        // Password label
        Password_label = new JLabel();
        Password_label.setText("Password :");
        Password_label.setBounds(45, 250, 100, 20);
        cH.add(Password_label);
        Font pass = new Font("Arial", Font.BOLD, 15);// change font
        Password_label.setFont(pass);
        Password_label.setForeground(Color.black);
        cH.add(Password_label);

        // Password field
        Password_TextF = new JTextField();
        Password_TextF.setBounds(45, 270, 195, 25);
        cH.add(Password_TextF);

        //Beds label
        Beds_label = new JLabel();
        Beds_label.setText("Total Beds No :");
        Beds_label.setBounds(45, 310, 200, 20);
        cH.add(Beds_label);
        Font Em = new Font("Arial", Font.BOLD, 15);// change font
        Beds_label.setFont(Em);
        Beds_label.setForeground(Color.black);
        cH.add(Beds_label);

        //Beds text field
        Beds_TextF = new JTextField();
        Beds_TextF.setBounds(180, 310, 35, 25);
        cH.add(Beds_TextF);

        //wards label
        wards_label = new JLabel();
        wards_label.setText("Total Wards No :");
        wards_label.setBounds(45, 340, 200, 20);
        cH.add(wards_label);
        Font wm = new Font("Arial", Font.BOLD, 15);// change font
        wards_label.setFont(Em);
        wards_label.setForeground(Color.black);
        cH.add(wards_label);

        //wards text field
        Wards_TextF = new JTextField();
        Wards_TextF.setBounds(180, 340, 35, 25);
        cH.add(Wards_TextF);

        //ICU label
        Icu_label = new JLabel();
        Icu_label.setText("Total ICU No :");
        Icu_label.setBounds(45, 370, 200, 20);
        cH.add(Icu_label);
        Font im = new Font("Arial", Font.BOLD, 15);// change font
        Icu_label.setFont(Em);
        Icu_label.setForeground(Color.black);
        cH.add(Icu_label);

        //ICU text field
        Icu_TextF = new JTextField();
        Icu_TextF.setBounds(180, 370, 35, 25);
        cH.add(Icu_TextF);


        //Classification label
        classification_label = new JLabel("Classification :");
        classification_label.setFont(new Font("Arial", Font.PLAIN, 20));
        classification_label.setBounds(45, 405, 150, 20);
        cH.add(classification_label);
        Font gl = new Font("Arial", Font.BOLD, 15);// change font
        classification_label.setFont(gl);
        classification_label.setForeground(Color.black);
        cH.add(classification_label);

        // For Public Hospital RadioButton
        public_Button = new JRadioButton("Public");
        public_Button.setFont(new Font("Arial", Font.PLAIN, 15));
        public_Button.setSelected(true);
        public_Button.setBounds(165, 405, 80, 20);
        cH.add(public_Button);

        // For Private Hospital RadioButton
        private_Button = new JRadioButton("Private");
        private_Button.setFont(new Font("Arial", Font.PLAIN, 15));
        private_Button.setBounds(250, 405, 77, 20);
        cH.add(private_Button);

        // For Button group
        classification_BG = new ButtonGroup();
        classification_BG.add(public_Button);
        classification_BG.add(private_Button);

        //Address label
        Address_label = new JLabel("Address :");
        Address_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Address_label.setBounds(45, 445, 100, 20);
        cH.add(Address_label);
        Font add = new Font("Arial", Font.BOLD, 15);// change font
        Address_label.setFont(add);
        Address_label.setForeground(Color.black);
        cH.add(Address_label);

        // Address Text Area
        Add_Area = new JTextArea();
        Add_Area.setFont(new Font("Arial", Font.PLAIN, 15));
        Add_Area.setBounds(125, 450, 200, 75);
        Add_Area.setLineWrap(true);
        Add_Area.setWrapStyleWord(true);
        cH.add(Add_Area);

        // CheckBox for terms and Condition
        terms_CheckBox = new JCheckBox("Accept Terms And Conditions.");
        terms_CheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        terms_CheckBox.setBounds(70, 550, 235, 20);
        terms_CheckBox.setCursor(cur);
        cH.add(terms_CheckBox);

        //Submit Button
        Submit_Button = new JButton("Submit");
        Submit_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Submit_Button.setBounds(60, 600, 90, 20);
        Submit_Button.setCursor(cur);
        //Submit_Button.addActionListener(this);
        cH.add(Submit_Button);

        //Reset Button
        Reset_Button = new JButton("Reset");
        Reset_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Reset_Button.setBounds(190, 600, 90, 20);
        Reset_Button.setCursor(cur);
        //Reset_Button.addActionListener(this);
        cH.add(Reset_Button);

        //for Back Button
        Back_Button = new JButton("Back to login");
        Back_Button.setFont(new Font("Arial", Font.BOLD, 12));
        Back_Button.setBounds(5, 5, 120, 20);
        Back_Button.setCursor(cur);
        cH.add(Back_Button);

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
        //submit button ActionListener
        Submit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Submit_Button) {
                    if (terms_CheckBox.isSelected()) {
                        String Hos_Name, Hos_phn, Hos_email, Hos_pass, Hos_bed, Hos_ward, Hos_icu, Hos_classification, Hos_address;
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
                            Hos_Name = HospitalName_TextF.getText();
                            Hos_phn = PhnNumber_TextF.getText();
                            Hos_email = Email_TextF.getText();
                            Hos_pass = Password_TextF.getText();
                            Hos_bed = Beds_TextF.getText();
                            Hos_ward = Wards_TextF.getText();
                            Hos_icu = Icu_TextF.getText();
                            if (public_Button.isSelected()) {
                                Hos_classification = "Public";
                            } else {
                                Hos_classification = "Private";
                            }
                            Hos_address = Add_Area.getText();
                            try {
                                FileReader a = new FileReader(f + "\\" + Hos_email + ".txt");
                                FileReader b = new FileReader(f + "\\Appointment-" + Hos_email + ".txt");
                                System.out.println("file exists!");
                            } catch (FileNotFoundException ex) {
                                try {
                                    FileWriter fw = new FileWriter(f + "\\" + Hos_email + ".txt");
                                    FileWriter b = new FileWriter(f + "\\Appointment-" + Hos_email + ".txt");
                                    System.out.println("File created");
                                    try {
                                        FileWriter fowl = new FileWriter(f + "\\" + Hos_email + ".txt");
                                        FileWriter ft = new FileWriter(f + "\\Hospital_Name.txt");
                                        PrintWriter pw = new PrintWriter(ft);
                                        pw.println(Hos_email);
                                        pw.close();
                                        PrintWriter pwl = new PrintWriter(fowl);
                                        pwl.println(Hos_Name);
                                        pwl.println(Hos_phn);
                                        pwl.println(Hos_email);
                                        pwl.println(Hos_pass);
                                        pwl.println(Hos_bed);
                                        pwl.println(Hos_ward);
                                        pwl.println(Hos_icu);
                                        pwl.println(Hos_classification);
                                        pwl.println(Hos_address);
                                        pwl.close();
                                        try {
                                            FileWriter Writer = new FileWriter("E:\\virtual_hospital_project\\Hospital\\Mail & passwords.txt", true);
                                            Writer.write("" + Hos_email + " " + Hos_pass);
                                            Writer.write(System.getProperty("line.separator"));
                                            Writer.close();
                                            JOptionPane.showMessageDialog(null, "Registration Successful");
                                            //setVisible(false);
                                        } catch (Exception er) {

                                            JOptionPane.showMessageDialog(null, "Error");
                                        }
                                    } catch (IOException ex1) {
                                        Logger.getLogger(SignUp_forHospital.class.getName()).log(Level.SEVERE, null, ex1);
                                    }
                                    n = n + 1;
                                    FileWriter fow = new FileWriter(path + "\\Serial.txt");
                                    PrintWriter pw = new PrintWriter(fow);
                                    pw.println(n);
                                    pw.close();
                                } catch (IOException ex1) {
                                    Logger.getLogger(SignUp_forHospital.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        } catch (IOException ex) {
                            try {
                                FileWriter fw = new FileWriter(path + "\\Serial.txt");
                                System.out.println("File created");
                            } catch (IOException ex1) {
                                Logger.getLogger(SignUp_forHospital.class.getName()).log(Level.SEVERE, null, ex1);
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


        hos_pic = new ImageIcon(getClass().getResource("/hos1.jpg")); // for background image add.
        sign_label = new JLabel(hos_pic);
        //Bg_level.setBounds(50,30,626,386);
        cH.add(sign_label);
        pack();
    }

}
