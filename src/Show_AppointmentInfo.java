import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

interface appointment_d {
    void Appointment_display();
}

public class Show_AppointmentInfo extends JFrame implements appointment_d {
    private ImageIcon Ga_logo, background_pic;
    private Container Cg;
    public JTable table;
    private JScrollPane scroll_Pane;
    public DefaultTableModel table_Model;
    private Cursor cursor;
    private JLabel back_label, faInfo_label, hospitalName_label, hosHelpline_label, hosAddress_label, doctorName_label,
            department_label, appointmentTime_label, appointmentDate_label, chamber_label, floor_label;
    private JTextField hosName_field, hosHelpline_field, doctorName_field, appointmentTime_TextF, appointmentDate_TextF;
    private JTextArea hosAddress_area;
    private JComboBox specialist_Combo, floor_Combo;
    private JButton back_b, take_appo;

    public String[] columns = {"Hospital Name", "Hospital Helpline", "Hospital Address", "Doctor Name",
            "Specialist", "Appointment Date", "Appointment Time", "Chamber"};
    public String[] rows = new String[8];

    private String[] specialization_list = {"Anatomical Pathology", "Anesthesiology", "Cardiology", "Thoracic Surgery",
            "Allergy", "Dermatology", "Diagnostic Radiology", "Emergency Medicine", "Family Medicine", "Medical Biochemistry",
            "Gastroenterology", "General Surgery", "Gynecologist", "Clinical Pathology", "Geriatric Medicine", "Hematology",
            "Medical Genetics", "Medical Oncology", "Nephrology", "Neurology", "Neurosurgery", "Nuclear Medicine",
            "Obstetrics/Gynecology", "Occupational Medicine", "Ophthalmology", "Orthopedic Surgery", "Otolaryngology",
            "Pediatrics", "Plastic Surgery", "Psychiatry", "PhPm", "Radiation Oncology", "Urology"};

    private String[] floors = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

    private String qc, qc1, sum;
    private int sum1;

    public void Appointment_display() {
        try {
            FileReader f4 = new FileReader("E:\\virtual_hospital_project\\Hospital\\Hospital_Name.txt");
            BufferedReader b4 = new BufferedReader(f4);
            Scanner s2 = new Scanner(b4);
            qc = s2.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileReader f5 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
            BufferedReader b5 = new BufferedReader(f5);
            Scanner s3 = new Scanner(b5);
            qc1 = s3.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Appointment information");
        cursor = new Cursor(cursor.HAND_CURSOR);
        Ga_logo = new ImageIcon(getClass().getResource("/vh1.png"));
        setIconImage(Ga_logo.getImage());
        Cg = getContentPane();

        faInfo_label = new JLabel();
        faInfo_label.setText("Fill Up Appointment Information");
        faInfo_label.setBounds(380, 0, 300, 50);// set the text where ever you want
        Font font = new Font("Arial", Font.BOLD, 16);// change font
        faInfo_label.setFont(font);
        Cg.add(faInfo_label);

        //level for hospital name
        hospitalName_label = new JLabel();
        hospitalName_label.setText("Hospital Name :");
        hospitalName_label.setBounds(200, 40, 150, 20);
        Cg.add(hospitalName_label);

        //text field for hospital name
        hosName_field = new JTextField();
        hosName_field.setEditable(false);
        hosName_field.setBounds(200, 60, 190, 25);
        Cg.add(hosName_field);

        //level for hospital helpline
        hosHelpline_label = new JLabel();
        hosHelpline_label.setText("Hospital helpline :");
        hosHelpline_label.setBounds(200, 100, 150, 20);
        Cg.add(hosHelpline_label);

        //text field for hospital helpline
        hosHelpline_field = new JTextField();
        hosHelpline_field.setEditable(false);
        hosHelpline_field.setBounds(200, 120, 190, 25);
        Cg.add(hosHelpline_field);

        //level for hospital address
        hosAddress_label = new JLabel();
        hosAddress_label.setText("Hospital Address :");
        hosAddress_label.setBounds(200, 160, 150, 20);
        Cg.add(hosAddress_label);

        //text field for hospital helpline
        hosAddress_area = new JTextArea();
        hosAddress_area.setEditable(false);
        hosAddress_area.setBounds(200, 180, 190, 75);
        hosAddress_area.setLineWrap(true);
        hosAddress_area.setWrapStyleWord(true);
        Cg.add(hosAddress_area);

        //level for Doctor name
        doctorName_label = new JLabel();
        doctorName_label.setText("Doctor Name :");
        doctorName_label.setBounds(500, 40, 150, 20);
        Cg.add(doctorName_label);

        //text field for Doctor name
        doctorName_field = new JTextField();
        doctorName_field.setEditable(false);
        doctorName_field.setBounds(500, 60, 190, 25);
        Cg.add(doctorName_field);

        //level for department
        department_label = new JLabel();
        department_label.setText("Specialist :");
        department_label.setBounds(500, 100, 150, 20);
        Cg.add(department_label);

        //specialization list combo box
        specialist_Combo = new JComboBox(specialization_list);
        specialist_Combo.setEnabled(false);
        specialist_Combo.setFont(new Font("Arial", Font.PLAIN, 12));
        specialist_Combo.setBounds(500, 120, 200, 20);
        Cg.add(specialist_Combo);

        //level for appointment time
        appointmentTime_label = new JLabel();
        appointmentTime_label.setText("Appointment Time(Hour:Min:am/pm):");
        appointmentTime_label.setBounds(500, 160, 240, 20);
        Cg.add(appointmentTime_label);

        //appointment time text field
        appointmentTime_TextF = new JTextField();
        appointmentTime_TextF.setEditable(false);
        appointmentTime_TextF.setBounds(500, 180, 200, 22);
        Cg.add(appointmentTime_TextF);


        //Appointment date label
        appointmentDate_label = new JLabel();
        appointmentDate_label.setText("Appointment Date (DD/MM/YYYY) :");
        appointmentDate_label.setBounds(500, 205, 280, 20);
        Font f = new Font("Arial", Font.BOLD, 12);// change font
        appointmentDate_label.setFont(f);
        Cg.add(appointmentDate_label);

        //appointment date text field
        appointmentDate_TextF = new JTextField();
        appointmentDate_TextF.setEditable(false);
        appointmentDate_TextF.setBounds(500, 223, 200, 22);
        Cg.add(appointmentDate_TextF);


        //level for hospital helpline
        chamber_label = new JLabel();
        chamber_label.setText("Chamber :");
        chamber_label.setBounds(500, 245, 150, 20);
        Cg.add(chamber_label);


        //floor label
        floor_label = new JLabel();
        floor_label.setText("Floor Number ");
        floor_label.setBounds(565, 246, 100, 20);
        Font ff = new Font("Arial", Font.PLAIN, 12);// change font
        floor_label.setFont(ff);
        Cg.add(floor_label);

        //floor list combo box
        floor_Combo = new JComboBox(floors);
        floor_Combo.setEnabled(false);
        floor_Combo.setFont(new Font("Arial", Font.PLAIN, 12));
        floor_Combo.setBounds(640, 247, 55, 20);
        Cg.add(floor_Combo);

        //Submit Button
        take_appo = new JButton("Take Appointment");
        take_appo.setFont(new Font("Arial", Font.BOLD, 15));
        take_appo.setBounds(735, 57, 170, 25);
        take_appo.setCursor(cursor);
        Cg.add(take_appo);

        //back Button
        back_b = new JButton("Back");
        back_b.setFont(new Font("Arial", Font.BOLD, 13));
        back_b.setBounds(5, 5, 80, 18);
        back_b.setCursor(cursor);
        Cg.add(back_b);

        //making table
        table = new JTable();
        table_Model = new DefaultTableModel();
        table_Model.setColumnIdentifiers(columns);
        table.setModel(table_Model);
        Font tf = new Font("New Roman Time", Font.PLAIN, 10);
        table.setFont(tf);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.white);
        table.setRowHeight(25);

        scroll_Pane = new JScrollPane(table);
        scroll_Pane.setBounds(30, 300, 940, 270);
        Cg.add(scroll_Pane);

        background_pic = new ImageIcon(getClass().getResource("/900.png")); // for background image add.
        back_label = new JLabel(background_pic);
        Cg.add(back_label);
        pack();

        //read file
        final String File = "E:\\virtual_hospital_project\\Hospital\\Appointment.txt";
        try {
            FileReader fReader = new FileReader(File);
            BufferedReader fileBuff = new BufferedReader(fReader);
            Object[] tableLines = fileBuff.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                table_Model.addRow(dataRow);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Row_number = table.getSelectedRow();
                String H_name = table_Model.getValueAt(Row_number, 0).toString();
                String H_hotLine = table_Model.getValueAt(Row_number, 1).toString();
                String H_address = table_Model.getValueAt(Row_number, 2).toString();
                String D_name = table_Model.getValueAt(Row_number, 3).toString();
                String D_special = table_Model.getValueAt(Row_number, 4).toString();
                String H_time = table_Model.getValueAt(Row_number, 5).toString();
                String H_date = table_Model.getValueAt(Row_number, 6).toString();
                String H_floor = table_Model.getValueAt(Row_number, 7).toString();

                hosName_field.setText(H_name);
                hosName_field.setEditable(false);
                hosHelpline_field.setText(H_hotLine);
                hosHelpline_field.setEditable(false);
                hosAddress_area.setText(H_address);
                hosAddress_area.setEditable(false);
                doctorName_field.setText(D_name);
                doctorName_field.setEditable(false);
                specialist_Combo.setSelectedItem(D_special);
                specialist_Combo.setEnabled(false);
                appointmentTime_TextF.setText(H_time);
                appointmentTime_TextF.setEditable(false);
                appointmentDate_TextF.setText(H_date);
                appointmentDate_TextF.setEditable(false);
                floor_Combo.setSelectedItem(H_floor);
                floor_Combo.setEnabled(false);

            }
        });
        //take appointment
        take_appo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String Hospital_name, Hospital_Hotline, Hospital_Address, Doctorname, Specialists, Time, Date, Floor;
                Hospital_name = hosName_field.getText();
                Hospital_Hotline = hosHelpline_field.getText();
                Hospital_Address = hosAddress_area.getText();
                Doctorname = doctorName_field.getText();
                Specialists = (String) specialist_Combo.getSelectedItem();
                Time = appointmentTime_TextF.getText();
                Date = appointmentDate_TextF.getText();
                Floor = (String) floor_Combo.getSelectedItem();
                try {
                    FileReader fw = new FileReader("E:\\virtual_hospital_project\\Wallet\\" + qc1 + ".txt");
                    BufferedReader b = new BufferedReader(fw);
                    Scanner c = new Scanner(b);
                    sum = c.next();
                    sum1 = Integer.parseInt(sum);
                    if (sum1 >= 1000) {
                        JOptionPane.showConfirmDialog(null, "This appointment will charge 1000/= Tk. Do you want to confirm?");
                        try {
                            FileWriter fq = new FileWriter("E:\\virtual_hospital_project\\Appointment\\" + qc1 + ".txt", true);
                            fq.write("" + Hospital_name + "   /" + Hospital_Hotline + "   /" + Hospital_Address + "   /" + Doctorname + "   /" + Specialists + "   /" + Time + "   /" + Date + "   /" + Floor);
                            fq.write(System.getProperty("line.separator"));
                            fq.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        sum1 = sum1 - 1000;
                        FileWriter d = new FileWriter("E:\\virtual_hospital_project\\Wallet\\" + qc1 + ".txt");
                        PrintWriter p = new PrintWriter(d);
                        p.println(sum1);
                        p.close();
                        JOptionPane.showMessageDialog(null, "Appointment has been taken.");
                        Show_AppointmentInfo u = new Show_AppointmentInfo();
                        u.Appointment_display();
                        u.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Appointment Failed");
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        back_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_HomePage uh = new User_HomePage();
                try {
                    uh.userMenu();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                uh.setVisible(true);
            }
        });

    }
}

