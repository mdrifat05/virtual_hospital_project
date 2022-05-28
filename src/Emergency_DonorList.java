import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

interface Emergency {
    void Donor_display();
}

public class Emergency_DonorList extends JFrame implements Emergency {

    private ImageIcon Ga_logo, background_pic;
    private Container Cg;
    public JTable table;
    private JScrollPane scroll_Pane;
    public DefaultTableModel table_Model;
    private Cursor cursor;
    private JLabel back_label, faInfo_label, message_label;
    private JButton back_b;

    public String[] columns = {"Name", "Phone Number", "Blood Group", "Gender", "Address"};
    public String[] rows = new String[5];


    public void Donor_display() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Emergency Blood Donor");
        cursor = new Cursor(cursor.HAND_CURSOR);
        Ga_logo = new ImageIcon(getClass().getResource("/vh1.png"));
        setIconImage(Ga_logo.getImage());
        Cg = getContentPane();

        faInfo_label = new JLabel();
        faInfo_label.setText("Emergency Blood Donor List");
        faInfo_label.setBounds(380, 5, 400, 50);// set the text where ever you want
        Font font = new Font("Arial", Font.BOLD + Font.ITALIC, 22);// change font
        faInfo_label.setFont(font);
        Cg.add(faInfo_label);

        message_label = new JLabel();
        message_label.setText("It's a free service don't pay");
        message_label.setBounds(400, 50, 400, 50);// set the text where ever you want
        Font f = new Font("Arial", Font.BOLD + Font.ITALIC, 18);// change font
        message_label.setFont(f);
        Cg.add(message_label);

        message_label = new JLabel();
        message_label.setText("Choose blood donor from table and contact with them");
        message_label.setBounds(300, 70, 550, 50);// set the text where ever you want
        Font fa = new Font("Arial", Font.BOLD + Font.ITALIC, 18);// change font
        message_label.setFont(fa);
        Cg.add(message_label);

        message_label = new JLabel();
        message_label.setText("Stay Safe");
        message_label.setBounds(450, 100, 570, 50);// set the text where ever you want
        Font fe = new Font("Arial", Font.BOLD + Font.ITALIC, 18);// change font
        message_label.setFont(fe);
        Cg.add(message_label);


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
        scroll_Pane.setBounds(50, 200, 900, 300);
        Cg.add(scroll_Pane);

        back_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_EmergencyPage frame = new User_EmergencyPage();
                frame.emergencyMenu();
                frame.setVisible(true);
            }
        });
        background_pic = new ImageIcon(getClass().getResource("/900.png")); // for background image add.
        back_label = new JLabel(background_pic);
        Cg.add(back_label);
        pack();

        final String File = "E:\\virtual_hospital_project\\Patient\\Donor_Data.txt";
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

}
