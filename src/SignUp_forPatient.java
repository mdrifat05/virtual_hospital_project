import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface patient {
    public abstract void SignUp_patient();
}

public class SignUp_forPatient extends JFrame implements ActionListener, patient {
    int j = 1, n;
    int l = 0;
    int k = 1, s = 0;
    File f = new File("E:\\virtual_hospital_project\\Patient");
    File u= new File("E:\\virtual_hospital_project\\Wallet");
    File path = new File("E:\\virtual_hospital_project\\Patient\\Serial");
    File path2=new File("E:\\virtual_hospital_project\\Appointment");

    void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
        if (!path.exists()) {
            path.mkdirs();
        }
        if(!u.exists()){
            u.mkdirs();
        }
        if(!path2.exists()){
            path2.mkdirs();
        }
    }

    void readFile() throws IOException {
        try {
            FileReader fr = new FileReader(path + "\\Serial.txt");
            System.out.println("file exists!");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                n = Integer.parseInt(line);
                System.out.println(line);
            }
            try {
                FileReader a = new FileReader(f + "\\Profile" + n + ".txt");
                System.out.println("file exists!");
            } catch (FileNotFoundException ex) {
                try {
                    FileWriter fw = new FileWriter(f + "\\Profile" + n + ".txt");
                    System.out.println("File created");
                    n = n + 1;
                    FileWriter fow = new FileWriter(path + "\\Serial.txt");
                    PrintWriter pw = new PrintWriter(fow);
                    pw.println(n);
                    pw.close();
                } catch (IOException ex1) {
                    Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(path + "\\Serial.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    private Container c2;
    private ImageIcon ic, sign_pic;
    private JLabel sign_label, SignHere_label, FirstName_label, LastName_label, PhnNumber_label, Email_label,
            Password_label, Gender_label, Dob_label, Address_label, Blood_label;
    private JTextField FirstName_TextF, LastName_TextF, PhnNumber_TextF, Email_TextF, Password_TextF;
    private JRadioButton Male_Button, Female_Button, Other_Button;
    private ButtonGroup Gender_BG;
    private JComboBox date, month, year, Blood_group;
    private JTextArea Add_Area;
    private JCheckBox terms_CheckBox;
    private JButton Submit_Button, Reset_Button, Back_Button;
    private Cursor cur;

    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"1990", "1991", "1992", "1994",
            "1993", "1994", "1995", "1996",
            "1997", "1998", "1999", "2000",
            "2001", "2002", "2003", "2004",
            "2005", "2006", "2007", "2008",
            "2009", "2010", "2011", "2012",
            "2013", "2014", "2015", "2016",
            "2017", "2018", "2019",};
    private String Blood[]
            = {"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"};

    public void SignUp_patient() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(831, 745); // frame size
        this.setLocationRelativeTo(null);// frame in the middle
        this.setResizable(false);// can't resize
        this.setTitle("Registration form for Patient"); // title add
        ic = new ImageIcon(getClass().getResource("vh1.png"));// icon add
        this.setIconImage(ic.getImage());
        c2 = this.getContentPane();

        cur = new Cursor(cur.HAND_CURSOR);
        //Register label
        SignHere_label = new JLabel();
        SignHere_label.setText("Register Here");
        SignHere_label.setBounds(300, 10, 300, 30);
        c2.add(SignHere_label);
        Font ut = new Font("Helvetica", Font.BOLD, 20);// change font
        SignHere_label.setFont(ut);
        SignHere_label.setForeground(Color.black);
        c2.add(SignHere_label);

        //First Name label
        FirstName_label = new JLabel();
        FirstName_label.setText("First Name :");
        FirstName_label.setBounds(45, 70, 100, 20);
        c2.add(FirstName_label);
        Font fn = new Font("Arial", Font.BOLD, 15);// change font
        FirstName_label.setFont(fn);
        FirstName_label.setForeground(Color.black);
        c2.add(FirstName_label);

        // First name text field
        FirstName_TextF = new JTextField();
        FirstName_TextF.setBounds(45, 90, 195, 25);
        c2.add(FirstName_TextF);

        //Last Name label
        LastName_label = new JLabel();
        LastName_label.setText("Last Name :");
        LastName_label.setBounds(45, 130, 100, 20);
        c2.add(LastName_label);
        Font ln = new Font("Arial", Font.BOLD, 15);// change font
        LastName_label.setFont(ln);
        LastName_label.setForeground(Color.black);
        c2.add(LastName_label);

        // Last name text field
        LastName_TextF = new JTextField();
        LastName_TextF.setBounds(45, 150, 195, 25);
        c2.add(LastName_TextF);

        //Phone Number label
        PhnNumber_label = new JLabel();
        PhnNumber_label.setText("Phone Number :");
        PhnNumber_label.setBounds(45, 190, 140, 20);
        c2.add(PhnNumber_label);
        Font pn = new Font("Arial", Font.BOLD, 15);// change font
        PhnNumber_label.setFont(pn);
        PhnNumber_label.setForeground(Color.black);
        c2.add(PhnNumber_label);

        // Phone Number text field
        PhnNumber_TextF = new JTextField();
        PhnNumber_TextF.setBounds(45, 210, 195, 25);
        c2.add(PhnNumber_TextF);

        //Email label
        Email_label = new JLabel();
        Email_label.setText("Email :");
        Email_label.setBounds(45, 250, 100, 20);
        c2.add(Email_label);
        Font Em = new Font("Arial", Font.BOLD, 15);// change font
        Email_label.setFont(Em);
        Email_label.setForeground(Color.black);
        c2.add(Email_label);

        // Email text field
        Email_TextF = new JTextField();
        Email_TextF.setBounds(45, 270, 195, 25);
        c2.add(Email_TextF);

        // Password label
        Password_label = new JLabel();
        Password_label.setText("Password :");
        Password_label.setBounds(45, 310, 100, 20);
        c2.add(Password_label);
        Font pass = new Font("Arial", Font.BOLD, 15);// change font
        Password_label.setFont(pass);
        Password_label.setForeground(Color.black);
        c2.add(Password_label);

        // Password field
        Password_TextF = new JTextField();
        Password_TextF.setBounds(45, 330, 195, 25);
        c2.add(Password_TextF);

        //Gender label
        Gender_label = new JLabel("Gender :");
        Gender_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Gender_label.setBounds(45, 371, 100, 20);
        c2.add(Gender_label);
        Font gl = new Font("Arial", Font.BOLD, 15);// change font
        Gender_label.setFont(gl);
        Gender_label.setForeground(Color.black);
        c2.add(Password_label);

        // For male RadioButton
        Male_Button = new JRadioButton("Male");
        Male_Button.setFont(new Font("Arial", Font.PLAIN, 15));
        Male_Button.setSelected(true);
        Male_Button.setBounds(120, 373, 60, 20);
        c2.add(Male_Button);

        // For Female RadioButton
        Female_Button = new JRadioButton("Female");
        Female_Button.setFont(new Font("Arial", Font.PLAIN, 15));
        Female_Button.setBounds(200, 373, 77, 20);
        c2.add(Female_Button);

        // Other RadioButton
        Other_Button = new JRadioButton("Other");
        Other_Button.setFont(new Font("Arial", Font.PLAIN, 15));
        Other_Button.setBounds(300, 373, 70, 20);
        c2.add(Other_Button);

        // For Button group
        Gender_BG = new ButtonGroup();
        Gender_BG.add(Male_Button);
        Gender_BG.add(Female_Button);
        Gender_BG.add(Other_Button);

        //Date of birth label
        Dob_label = new JLabel("DOB :");
        Dob_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Dob_label.setBounds(45, 421, 100, 20);
        c2.add(Dob_label);
        Font dob = new Font("Arial", Font.BOLD, 15);// change font
        Dob_label.setFont(dob);
        Dob_label.setForeground(Color.black);
        c2.add(Dob_label);

        // JComboBox for day,month,year
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setBounds(120, 421, 70, 20);
        c2.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setBounds(210, 421, 70, 20);
        c2.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setBounds(300, 421, 70, 20);
        c2.add(year);

        //Blood group of birth label
        Blood_label = new JLabel("Blood Group :");
        Blood_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Blood_label.setBounds(45, 463, 150, 20);
        c2.add(Blood_label);
        Font bg = new Font("Arial", Font.BOLD, 15);// change font
        Blood_label.setFont(bg);
        Blood_label.setForeground(Color.black);
        c2.add(Blood_label);

        Blood_group = new JComboBox(Blood);
        Blood_group.setFont(new Font("Arial", Font.PLAIN, 15));
        Blood_group.setBounds(160, 463, 70, 20);
        c2.add(Blood_group);

        //Address label
        Address_label = new JLabel("Address :");
        Address_label.setFont(new Font("Arial", Font.PLAIN, 20));
        Address_label.setBounds(45, 500, 100, 20);
        c2.add(Address_label);
        Font add = new Font("Arial", Font.BOLD, 15);// change font
        Address_label.setFont(add);
        Address_label.setForeground(Color.black);
        c2.add(Address_label);

        //Address Text Area
        Add_Area = new JTextArea();
        Add_Area.setFont(new Font("Arial", Font.PLAIN, 15));
        Add_Area.setBounds(120, 500, 200, 75);
        Add_Area.setLineWrap(true);
        Add_Area.setWrapStyleWord(true);
        c2.add(Add_Area);

        //CheckBox for terms and Condition
        terms_CheckBox = new JCheckBox("Accept Terms And Conditions.");
        terms_CheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        terms_CheckBox.setBounds(100, 600, 235, 20);
        terms_CheckBox.setCursor(cur);
        c2.add(terms_CheckBox);

        //Submit Button
        Submit_Button = new JButton("Submit");
        Submit_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Submit_Button.setBounds(90, 650, 90, 20);
        Submit_Button.setCursor(cur);
        Submit_Button.addActionListener(this);
        c2.add(Submit_Button);

        //Reset Button
        Reset_Button = new JButton("Reset");
        Reset_Button.setFont(new Font("Arial", Font.BOLD, 15));
        Reset_Button.setBounds(220, 650, 90, 20);
        Reset_Button.setCursor(cur);
        Reset_Button.addActionListener(this);
        c2.add(Reset_Button);

        //for Back Button
        Back_Button = new JButton("Back to login");
        Back_Button.setFont(new Font("Arial", Font.BOLD, 12));
        Back_Button.setBounds(5, 5, 120, 20);
        Back_Button.setCursor(cur);
        Back_Button.addActionListener(this);
        c2.add(Back_Button);


        sign_pic = new ImageIcon(getClass().getResource("patient.jpg")); // for background image add.
        sign_label = new JLabel(sign_pic);
        //Bg_level.setBounds(50,30,626,386);
        c2.add(sign_label);
        pack();
    }


    //taking user input from text field to txt.file
    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == Submit_Button) {
            if (terms_CheckBox.isSelected()) {
                String first_Name, last_Name, mobile_Num, mail,
                        pass, gender, dob, address,blood;
                createFolder();
                try {
                    FileReader fr = new FileReader(path + "\\Serial.txt");
                    FileReader frr=new FileReader(path2+"\\Appointment.txt");
                    System.out.println("file exists!");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        n = Integer.parseInt(line);
                        System.out.println(line);
                    }
                    first_Name = FirstName_TextF.getText();
                    last_Name = LastName_TextF.getText();
                    mobile_Num = PhnNumber_TextF.getText();
                    mail = Email_TextF.getText();
                    pass = Password_TextF.getText();
                    if (Male_Button.isSelected())
                        gender = "Male";
                    else if (Female_Button.isSelected())
                        gender = "Female";
                    else
                        gender = "Other";

                    dob = (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem()
                            + "/" + (String) year.getSelectedItem();
                    blood=(String)Blood_group.getSelectedItem();
                    address = Add_Area.getText();
                    try {
                        FileReader a = new FileReader(f + "\\" + mail + ".txt");
                        FileReader e = new FileReader(u + "\\" + mail + ".txt");
                        FileReader r = new FileReader(path2+"\\"+mail+".txt");
                        System.out.println("file exists!");
                    } catch (FileNotFoundException ex) {
                        try {
                            FileWriter fw = new FileWriter(f + "\\" + mail + ".txt");
                            FileWriter faw = new FileWriter(u + "\\" + mail + ".txt");
                            FileWriter r = new FileWriter(path2+"\\"+mail+".txt");
                            System.out.println("File created");
                            try {
                                FileWriter fowl = new FileWriter(f + "\\" + mail + ".txt");
                                FileWriter fwl = new FileWriter(u + "\\" + mail + ".txt");
                                FileWriter r1 = new FileWriter(path2+"\\"+mail+".txt");
                                PrintWriter pwl = new PrintWriter(fowl);
                                PrintWriter k=new PrintWriter(fwl);
                                pwl.println(first_Name);
                                pwl.println(last_Name);
                                pwl.println(dob);
                                pwl.println(blood);
                                pwl.println(mobile_Num);
                                pwl.println(mail);
                                pwl.println(pass);
                                pwl.println(gender);
                                pwl.println(address);
                                pwl.close();
                                k.println(0);
                                k.close();
                                try {
                                    FileWriter Writer = new FileWriter("E:\\virtual_hospital_project\\Patient\\Mail & passwords.txt", true);
                                    Writer.write("" + mail + " " + pass);
                                    Writer.write(System.getProperty("line.separator"));
                                    Writer.close();
                                    JOptionPane.showMessageDialog(null, "Registration Successful");
                                    //setVisible(false);
                                } catch (Exception er) {

                                    JOptionPane.showMessageDialog(null, "Error");
                                }
                            } catch (IOException ex1) {
                                Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            n = n + 1;
                            FileWriter fow = new FileWriter(path + "\\Serial.txt");
                            PrintWriter pw = new PrintWriter(fow);
                            pw.println(n);
                            pw.close();
                        } catch (IOException ex1) {
                            Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                } catch (IOException ex) {
                    try{
                        FileWriter q=new FileWriter(u+"\\Wallet.txt");
                        System.out.println("File created");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        FileWriter fw = new FileWriter(path + "\\Serial.txt");
                        System.out.println("File created");
                    } catch (IOException ex1) {
                        Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    try {
                        FileWriter fiw = new FileWriter(path2 + "\\Appointment.txt");
                        System.out.println("File created");
                    } catch (IOException ex1) {
                        Logger.getLogger(SignUp_forPatient.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                dispose();
                Login_Page frame = new Login_Page();
                frame.LoginMenu();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please accept the terms & conditions");
            }
        } else if (ee.getSource() == Reset_Button) {
            String reset = "";
            FirstName_TextF.setText(reset);
            LastName_TextF.setText(reset);
            PhnNumber_TextF.setText(reset);
            Email_TextF.setText(reset);
            Password_TextF.setText(reset);
            terms_CheckBox.setSelected(false);
            Male_Button.setSelected(true);
            Add_Area.setText(reset);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        } else if (ee.getSource() == Back_Button) {
            dispose();
            Login_Page frame = new Login_Page();
            frame.LoginMenu();
            frame.setVisible(true);
        }
    }

}

