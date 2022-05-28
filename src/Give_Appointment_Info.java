import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface appointment {
    void Appointment_Info() throws FileNotFoundException;
}

public class Give_Appointment_Info extends JFrame implements appointment {
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
    private JComboBox specialist, floor_Combo;
    private JButton back_b, Submit_b, show_detail, Reset_b;

    public String[] columns = {"Hospital Name", "Hospital Helpline", "Hospital Address", "Doctor Name",
            "Specialist", "Appointment Date", "Appointment Time", "Chamber"};
    public String[] rows = new String[8];

    private String[] specialization_list = {"Anatomical Pathology", "Anesthesiology", "Cardiology", "Thoracic Surgery",
            "Allergy", "Dermatology", "Diagnostic Radiology", "Emergency Medicine", "Family Medicine", "Medical Biochemistry",
            "Gastroenterology", "General Surgery", "Gynecologist", "Clinical Pathology", "Geriatric Medicine", "Hematology",
            "Medical Genetics", "Medical Oncology", "Nephrology", "Neurology", "Neurosurgery", "Nuclear Medicine",
            "Obstetrics/Gynecology", "Occupational_Medicine", "Ophthalmology", "Orthopedic Surgery", "Otolaryngology",
            "Pediatrics", "Plastic Surgery", "Psychiatry", "PhPm", "Radiation Oncology", "Urology"};

    private String[] floors = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    private String q, qc;

    List<String> list = new ArrayList<String>();

    public void Appointment_Info() throws FileNotFoundException {
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Hospital\\line.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.nextLine();

        FileReader f3 = new FileReader("E:\\virtual_hospital_project\\Hospital\\Hospital_Name.txt");
        BufferedReader b3 = new BufferedReader(f3);
        Scanner s1 = new Scanner(b3);
        qc = s1.nextLine();

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
        hosName_field.setBounds(200, 60, 190, 25);
        hosName_field.setText(q);
        Cg.add(hosName_field);

        //level for hospital helpline
        hosHelpline_label = new JLabel();
        hosHelpline_label.setText("Hospital helpline :");
        hosHelpline_label.setBounds(200, 100, 150, 20);
        Cg.add(hosHelpline_label);

        //text field for hospital helpline
        hosHelpline_field = new JTextField();
        hosHelpline_field.setBounds(200, 120, 190, 25);
        Cg.add(hosHelpline_field);

        //level for hospital address
        hosAddress_label = new JLabel();
        hosAddress_label.setText("Hospital Address :");
        hosAddress_label.setBounds(200, 160, 150, 20);
        Cg.add(hosAddress_label);

        //text field for hospital helpline
        hosAddress_area = new JTextArea();
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
        doctorName_field.setBounds(500, 60, 190, 25);
        Cg.add(doctorName_field);

        //level for department
        department_label = new JLabel();
        department_label.setText("Specialist :");
        department_label.setBounds(500, 100, 150, 20);
        Cg.add(department_label);

        //specialization list combo box
        specialist = new JComboBox(specialization_list);
        specialist.setFont(new Font("Arial", Font.PLAIN, 12));
        specialist.setBounds(500, 120, 200, 20);
        Cg.add(specialist);

        //level for appointment time
        appointmentTime_label = new JLabel();
        appointmentTime_label.setText("Appointment Time(Hour:Min:am/pm):");
        appointmentTime_label.setBounds(500, 160, 240, 20);
        Cg.add(appointmentTime_label);

        //appointment time text field
        appointmentTime_TextF = new JTextField();
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
        floor_Combo.setFont(new Font("Arial", Font.PLAIN, 12));
        floor_Combo.setBounds(640, 247, 55, 20);
        Cg.add(floor_Combo);

        //Submit Button
        Submit_b = new JButton("Add Appointment");
        Submit_b.setFont(new Font("Arial", Font.BOLD, 15));
        Submit_b.setBounds(735, 57, 170, 25);
        Submit_b.setCursor(cursor);
        Cg.add(Submit_b);

        //Submit Button
        show_detail = new JButton("Display Data");
        show_detail.setFont(new Font("Arial", Font.BOLD, 15));
        show_detail.setBounds(735, 100, 170, 25);
        show_detail.setCursor(cursor);
        Cg.add(show_detail);

        //Reset Button
        Reset_b = new JButton("Reset");
        Reset_b.setFont(new Font("Arial", Font.BOLD, 15));
        Reset_b.setBounds(735, 140, 170, 25);
        Reset_b.setCursor(cursor);
        Cg.add(Reset_b);

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
        back_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HospitalLogin_Page hp = new HospitalLogin_Page();
                try {
                    hp.userMenu();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                hp.setVisible(true);

            }
        });

        Reset_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reset = "";
                hosName_field.setText(reset);
                hosHelpline_field.setText(reset);
                hosAddress_area.setText(reset);
                doctorName_field.setText(reset);
                specialist.setSelectedIndex(0);
                appointmentTime_TextF.setText(reset);
                appointmentDate_TextF.setText(reset);
                floor_Combo.setSelectedIndex(0);
            }
        });

        Submit_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Hos_name, Hos_helpline, Hos_address, Doctor_name, Specialist, time, date, floor;
                Hos_name = hosName_field.getText();
                Hos_helpline = hosHelpline_field.getText();
                Hos_address = hosAddress_area.getText();
                Doctor_name = doctorName_field.getText();
                Specialist = (String) specialist.getSelectedItem();
                time = appointmentTime_TextF.getText();
                date = appointmentDate_TextF.getText();
                floor = (String) floor_Combo.getSelectedItem();

                try {
                    String f = "E:\\virtual_hospital_project\\Hospital\\Appointment.txt";
                    FileWriter writer = new FileWriter(f, true);
                    writer.write("" + Hos_name + "   /" + Hos_helpline + "   /" + Hos_address + "   /" + Doctor_name + "   /" + Specialist + "   /" + time + "   /" + date + "   /" + floor);
                    writer.write(System.getProperty("line.separator"));
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        show_detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
    }

}

