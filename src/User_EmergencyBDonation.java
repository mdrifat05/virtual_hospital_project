import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

interface UserEmergencyBDonation{
        void BloodDonationMenu();
}
public class User_EmergencyBDonation extends JFrame implements UserEmergencyBDonation{

	private ImageIcon icon,BG_Img;
	private Container cu;
	private Cursor cursor;
	private JButton back_Button,donar_Button;
	private JLabel BG_Label,blank_Label,title_Label,gender_Label,name_Label,phNumber_Label,bloodGroup_Label,address_Label;
	private JTextField addresss_TextF,name_TextF,phnNumber_TextF,bloodGroup_TextF,gender_TextF;
	private String []line =new String[100];
	private String q;
	public void BloodDonationMenu() {

            FileReader f2 = null;
            try {
                    f2 = new FileReader("E:\\virtual_hospital_project\\Patient\\Email.txt");
                    BufferedReader b2 = new BufferedReader(f2);
                    Scanner s = new Scanner(b2);
                    q = s.next();
            } catch (FileNotFoundException e) {
                    e.printStackTrace();
            }

            try {
                    FileReader d = new FileReader("E:\\virtual_hospital_project\\Patient\\"+q+".txt");
                    BufferedReader f=new BufferedReader(d);
                    Scanner s=new Scanner(f);
                    for(int i=0;i<9;i++){
                            line[i]=s.nextLine();
                    }
                    f.close();
                    d.close();
            } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                    ioException.printStackTrace();
            }



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192,192,192));
        //setBounds(50,30,626,386);
        setResizable(false);// can't resize
        setTitle("Blood Donator Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        cu = this.getContentPane();
        
        //for Back Button
        back_Button = new JButton("Back");
        back_Button.setFont(new Font("Arial", Font.BOLD, 12));
        back_Button.setBounds(15, 15, 70, 30);
        back_Button.setBackground(new Color(255,215,255));
        back_Button.setCursor(cursor);
        back_Button.setFocusable(false);
        //back_Button.addActionListener(this);
        cu.add(back_Button);

        
        //Title Label
        title_Label = new JLabel();
        title_Label.setText("\"Fill The Form To Be A Free Blood Donator\"");
        title_Label.setBounds(50,80, 500, 100);
        cu.add(title_Label);
        Font us = new Font("Adobe Gothic Std B",Font.BOLD, 20);// change font
        title_Label.setFont(us);
        
        //Name label
        name_Label = new JLabel();
        name_Label.setText("Name :");
        name_Label.setBounds(42, 150, 150, 15);
        cu.add(name_Label);
        Font an = new Font("Arial", Font.BOLD, 15);// change font
        name_Label.setFont(an);
        name_Label.setForeground(Color.black);
        cu.add(name_Label);

        //Name text field
        name_TextF = new JTextField();
        name_TextF.setText(line[0]+" "+line[1]);
        name_TextF.setBounds(40, 170, 200, 25);
        cu.add(name_TextF);
        
        
        //Phone Number label
        phNumber_Label = new JLabel();
        phNumber_Label.setText("Phone Number : ");
        phNumber_Label.setBounds(42, 210, 150, 15);
        cu.add(phNumber_Label);
        Font pl = new Font("Arial", Font.BOLD, 15);// change font
        phNumber_Label.setFont(pl);
        phNumber_Label.setForeground(Color.black);
        cu.add(phNumber_Label);

        //Phone Number text field
        phnNumber_TextF = new JTextField();
        phnNumber_TextF.setText(line[5]);
        phnNumber_TextF.setBounds(40, 230, 200, 25);
        cu.add(phnNumber_TextF);
        
        //Blood Group label
        bloodGroup_Label = new JLabel();
        bloodGroup_Label.setText("Blood Group : ");
        bloodGroup_Label.setBounds(42, 270, 150, 15);
        cu.add(bloodGroup_Label);
        Font ul = new Font("Arial", Font.BOLD, 15);// change font
        bloodGroup_Label.setFont(ul);
        bloodGroup_Label.setForeground(Color.black);
        cu.add(bloodGroup_Label);

        //Blood Group text field
        bloodGroup_TextF = new JTextField();
        bloodGroup_TextF.setText(line[3]);
        bloodGroup_TextF.setBounds(40, 290, 200, 25);
        cu.add(bloodGroup_TextF);
        
        //Gender label
        gender_Label = new JLabel();
        gender_Label.setText("Gender : ");
        gender_Label.setBounds(42, 330, 250, 15);
        cu.add(gender_Label);
        Font uw = new Font("Arial", Font.BOLD, 15);// change font
        gender_Label.setFont(uw);
        gender_Label.setForeground(Color.black);
        cu.add(gender_Label);

        //Gender text field
        gender_TextF = new JTextField();
        gender_TextF.setText(line[7]);
        gender_TextF.setBounds(40, 350, 200, 25);
        cu.add(gender_TextF);
        
        
         //Address Label
        address_Label = new JLabel();
        address_Label.setText("Address :");
        address_Label.setBounds(42, 390, 400, 15);
        cu.add(address_Label);
        Font pn = new Font("Arial", Font.BOLD, 15);// change font
        address_Label.setFont(pn);
        address_Label.setForeground(Color.black);
        cu.add(address_Label);

        // Address text field
        addresss_TextF = new JTextField();
        addresss_TextF.setText(line[8]);
        addresss_TextF.setBounds(42, 415, 200, 25);
        cu.add(addresss_TextF);
        
        
        //Pick up Button
        donar_Button = new JButton("Be a Donor");
        donar_Button.setFont(new Font("Arial", Font.BOLD, 12));
        donar_Button.setBounds(300, 498, 120, 30);
        donar_Button.setBackground(new Color(100,100,255));
        donar_Button.setCursor(cursor);
        donar_Button.setFocusable(false);
        //back_Button.addActionListener(this);
        cu.add(donar_Button);

            donar_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String name,phn,Blood_g,gender,address;
                            name = name_TextF.getText();
                            phn = phnNumber_TextF.getText();
                            Blood_g = bloodGroup_TextF.getText();
                            gender = gender_TextF.getText();
                            address = addresss_TextF.getText();

                            try {
                                    FileWriter writer = new FileWriter("E:\\virtual_hospital_project\\Patient\\Donor_Data.txt", true);
                                    writer.write("" + name + "    /" + phn + "   /" + Blood_g + "    /" + gender + "    /" + address);
                                    writer.write(System.getProperty("line.separator"));
                                    writer.close();
                                    JOptionPane.showMessageDialog(null, "Successful");
                            } catch (IOException ioException) {
                                    JOptionPane.showMessageDialog(null, "Error");
                            }
                    }
            });


        back_Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        dispose();
                        User_EmergencyPage frame = new User_EmergencyPage();
                        frame.emergencyMenu();
                        frame.setVisible(true);
                }
        });


        BG_Img = new ImageIcon(getClass().getResource("/admin.png")); // for background image add.
        BG_Label = new JLabel(BG_Img);
        cu.add(BG_Label);
       // fr.pack();
		
	}

}
