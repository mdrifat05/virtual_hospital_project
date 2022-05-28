
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

interface Ambulance_pickup {
    void pickUpMenu() throws FileNotFoundException;
}

public class Ambulance_PickUpPage extends JFrame implements Ambulance_pickup {

    private Cursor cursor;
    private JTable Table;
    private JScrollPane scroll_Pane;
    private DefaultTableModel Table_Model;
    private ImageIcon icon, BG_Img, accept_Img;
    private JButton back_Button, accept_Button;
    private JLabel BG_Label, title_Label, des_Label;

    public String[] columns = {"Hospital Name", "Driver Name", "Address", "Email Address", "Phone Number"};

    private Container cu;
    private String q, sum;
    private String[] line = new String[100];
    private int sum1;

    public void pickUpMenu() throws FileNotFoundException {
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.next();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192, 192, 192));
        //setBounds(50,30,626,386);
        setResizable(false);// can't resize
        setTitle("Ambulance Pick Up Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("vh1.png"));// icon add
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
        title_Label = new JLabel("ALL  AVAILABLE  RIDE");
        title_Label.setFont(new Font("Arial", Font.PLAIN, 25));
        title_Label.setBounds(420, 25, 1000, 20);
        cu.add(title_Label);
        Font add = new Font("Arial", Font.BOLD + Font.ITALIC, 20);// change font
        title_Label.setFont(add);
        title_Label.setForeground(Color.black);
        cu.add(title_Label);

        //description label
        des_Label = new JLabel("SELECT YOUR RIDE FROM THE GIVEN ROW");
        des_Label.setFont(new Font("Arial", Font.PLAIN, 25));
        des_Label.setBounds(40, 100, 1000, 20);
        cu.add(des_Label);
        Font ad = new Font("Arial", Font.BOLD, 15);// change font
        des_Label.setFont(ad);
        des_Label.setForeground(Color.black);
        cu.add(des_Label);

        //making table
        Table = new JTable();
        Table_Model = new DefaultTableModel();
        Table_Model.setColumnIdentifiers(columns);
        Table.setModel(Table_Model);
        Font tf = new Font("Arial", Font.PLAIN, 10);
        Table.setFont(tf);
        Table.setSelectionBackground(Color.GREEN);
        Table.setBackground(Color.white);
        Table.setRowHeight(30);

        scroll_Pane = new JScrollPane(Table);
        scroll_Pane.setBounds(30, 120, 950, 380);
        cu.add(scroll_Pane);


        //Accept Ride button
        accept_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\pick up.png");
        accept_Button = new JButton("  ACCEPT", accept_Img); //adding image and text in the button

        Font f = new Font("Arial", Font.BOLD, 20);// change font
        accept_Button.setFont(f);
        accept_Button.setCursor(cursor);
        accept_Button.setBackground(new Color(255, 128, 0));
        accept_Button.setBounds(400, 550, 200, 80);
        accept_Button.setFocusable(false);
        cu.add(accept_Button);


        BG_Img = new ImageIcon(getClass().getResource("/900.png")); // for background image add.
        BG_Label = new JLabel(BG_Img);
        cu.add(BG_Label);
        pack();

        Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();

                int Row_number = Table.getSelectedRow();
                String Hospital_Name = Table_Model.getValueAt(Row_number, 0).toString();
                String Driver_Name = Table_Model.getValueAt(Row_number, 1).toString();
                String Address = Table_Model.getValueAt(Row_number, 2).toString();
                String Email_Address = Table_Model.getValueAt(Row_number, 3).toString();
                String Phone_Number = Table_Model.getValueAt(Row_number, 4).toString();

                JOptionPane.showConfirmDialog(null, "Ambulance will charge 1500/= Tk. Are you confirm?");

                try {
                    FileReader fw = new FileReader("E:\\virtual_hospital_project\\Wallet\\" + q + ".txt");
                    BufferedReader b = new BufferedReader(fw);
                    Scanner c = new Scanner(b);
                    sum = c.next();
                    sum1 = Integer.parseInt(sum);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                if (sum1 >= 1500) {
                    try {
                        FileReader d = new FileReader("E:\\virtual_hospital_project\\Patient\\" + q + ".txt");
                        BufferedReader f = new BufferedReader(d);
                        Scanner s = new Scanner(f);
                        for (int i = 0; i < 9; i++) {
                            line[i] = s.next();
                        }
                        f.close();
                        d.close();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    try {
                        FileWriter g = new FileWriter("E:\\virtual_hospital_project\\Ambulance\\PickUp_" + Email_Address + ".txt");
                        g.write("" + line[0] + "   /" + line[1] + "   /" + line[2] + "   /" + line[3] + "   /" + line[4] + "   /" + line[5] + "   /" + line[7] + "   /" + line[8]);
                        g.write(System.getProperty("line.separator"));
                        g.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    sum1 = sum1 - 1500;
                    try {
                        FileWriter d = new FileWriter("E:\\virtual_hospital_project\\Wallet\\" + q + ".txt");
                        PrintWriter p = new PrintWriter(d);
                        p.println(sum1);
                        p.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Request accepted");
                    User_HomePage u = new User_HomePage();
                    try {
                        u.userMenu();
                        u.setVisible(true);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                }

            }
        });
        //Back Button
        back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_HomePage a = new User_HomePage();
                a.setVisible(true);
            }
        });
        final String File = "E:\\virtual_hospital_project\\Ambulance\\List.txt";
        try {
            FileReader fReader = new FileReader(File);
            BufferedReader fileBuff = new BufferedReader(fReader);
            Object[] tableLines = fileBuff.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                Table_Model.addRow(dataRow);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }
}
