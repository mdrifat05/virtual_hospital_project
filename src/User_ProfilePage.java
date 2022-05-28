
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
interface UserProfilePage{
        void profileMenu() throws FileNotFoundException, IOException;
}
public class User_ProfilePage extends JFrame implements UserProfilePage{

        private Cursor cursor;
        private ImageIcon icon,BG_Img;
        private JScrollPane scroll_Pane;
        private JLabel bG_Label,title_Label,name_Label,age_Label,blood_Label,phnNumber_Label,email_Label
                ,appointment_Label;
        private JButton back_Button;
        private JTable table;
        public DefaultTableModel table_Model;
        public String[] columns ={"Hospital Name","Hospital Helpline","Hospital Add","Doctor Name",
                "Specialist","Appointment Date","Appointment Time","Chamber"};
        private Container cu;
        private String qc1;
        private int count=0;
        private String line2,line3,line4,line5,line6;
        private String[]line=new String[100];

        public void profileMenu() throws IOException {
                try {
                        FileReader f5 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
                        BufferedReader b5 = new BufferedReader(f5);
                        Scanner s3 = new Scanner(b5);
                        qc1 = s3.nextLine();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                FileReader d=new FileReader("E:\\virtual_hospital_project\\Patient\\"+qc1+".txt");
                BufferedReader f=new BufferedReader(d);
                Scanner s=new Scanner(f);
                for(int i=0;i<9;i++){
                        line[i]=s.next();
                }
                f.close();
                d.close();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(500, 700); // frame size
                setLocationRelativeTo(null);// frame in the middle
                getContentPane().setBackground(new Color(192,192,192));
                //setBounds(50,30,626,386);
                setResizable(false);// can't resize
                setTitle("Profile Page"); // title add
                //mouse cursor
                cursor = new Cursor(cursor.HAND_CURSOR);

                icon = new ImageIcon(getClass().getResource("vh1.png"));// icon add
                this.setIconImage(icon.getImage());
                cu = this.getContentPane();

                //for Back Button
                back_Button = new JButton("Back");
                back_Button.setFont(new Font("Arial", Font.BOLD, 15));
                back_Button.setBounds(10, 10, 90, 20);
                back_Button.setBackground(new Color(255,255,255));
                back_Button.setCursor(cursor);
                back_Button.setFocusable(false);
                //back_Button.addActionListener(this);
                cu.add(back_Button);

                //Title label
                title_Label = new JLabel();
                title_Label.setText("BASIC INFORMATION");
                title_Label.setBounds(400, 30, 300, 50);
                cu.add(title_Label);
                Font uf = new Font("Adobe Gothic Std B",Font.BOLD+Font.ITALIC, 25);// change font
                title_Label.setFont(uf);
                title_Label.setForeground(new Color(125,12,12));
                cu.add(title_Label);

                //Name label
                name_Label = new JLabel();
                name_Label.setText("Name                 :"+line[0]+" "+line[1]);
                name_Label.setBounds(20, 60, 400, 100);
                cu.add(name_Label);
                Font sf = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
                name_Label.setFont(sf);
                name_Label.setForeground(Color.DARK_GRAY);
                cu.add(name_Label);

                //Age label
                age_Label = new JLabel();
                age_Label.setText("Age                    :"+line[2]);
                age_Label.setBounds(20, 85, 400, 100);
                cu.add(age_Label);
                Font qf = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
                age_Label.setFont(qf);
                age_Label.setForeground(Color.DARK_GRAY);
                cu.add(age_Label);

                //Blood Group label
                blood_Label = new JLabel();
                blood_Label.setText("Blood Group      :"+line[3]);
                blood_Label.setBounds(20, 110, 400, 100);
                cu.add(blood_Label);
                Font yf = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
                blood_Label.setFont(yf);
                blood_Label.setForeground(Color.DARK_GRAY);
                cu.add(blood_Label);

                //Phone Number label
                phnNumber_Label = new JLabel();
                phnNumber_Label.setText("Phone No.     :  "+line[4]);
                phnNumber_Label.setBounds(20, 135, 400, 100);
                cu.add(phnNumber_Label);
                Font zf = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
                phnNumber_Label.setFont(zf);
                phnNumber_Label.setForeground(Color.DARK_GRAY);
                cu.add(phnNumber_Label);


                //Email label
                email_Label = new JLabel();
                email_Label.setText("Email Add.        :"+line[5]);
                email_Label.setBounds(20, 160, 400, 100);
                cu.add(email_Label);
                Font pf = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
                email_Label.setFont(pf);
                email_Label.setForeground(Color.DARK_GRAY);
                cu.add(email_Label);

                //Appointment label
                appointment_Label = new JLabel();
                appointment_Label.setText("Recent Appointment Details");
                appointment_Label.setBounds(350, 225, 450, 40);
                cu.add(appointment_Label);
                Font vf = new Font("Adobe Gothic Std B",Font.BOLD, 25);// change font
                appointment_Label.setFont(vf);
                appointment_Label.setForeground(new Color(255,128,0));
                cu.add(appointment_Label);

                //making table
                table = new JTable();
                table_Model = new DefaultTableModel();
                table_Model.setColumnIdentifiers(columns);
                table.setModel(table_Model);
                Font tf = new Font("Arial",Font.PLAIN,10);
                table.setFont(tf);
                table.setSelectionBackground(Color.GREEN);
                table.setBackground(Color.white);
                table.setRowHeight(30);

                scroll_Pane = new JScrollPane(table);
                scroll_Pane.setBounds(30,260,940,200);
                cu.add(scroll_Pane);

                BG_Img = new ImageIcon(getClass().getResource("900.png")); // for background image add.
                bG_Label = new JLabel(BG_Img);
                //Bg_level.setBounds(50,30,626,386);
                cu.add(bG_Label);
                this.pack();


                try {
                        FileReader fReader = new FileReader("E:\\virtual_hospital_project\\Appointment\\"+qc1+".txt");
                        BufferedReader fileBuff = new BufferedReader(fReader);
                        Object[] tableLines = fileBuff.lines().toArray();

                        for(int i = 0; i<tableLines.length;i++){
                                String line = tableLines[i].toString().trim();
                                String [] dataRow = line.split("/");
                                table_Model.addRow(dataRow);
                        }

                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error");
                }
                back_Button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                dispose();
                                User_HomePage u=new User_HomePage();
                                try {
                                        u.userMenu();
                                        u.setVisible(true);
                                } catch (FileNotFoundException fileNotFoundException) {
                                        fileNotFoundException.printStackTrace();
                                }
                        }
                });
        }
}
