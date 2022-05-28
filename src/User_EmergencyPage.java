
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

interface UserEmergencyPage{
    void emergencyMenu();
}
public class User_EmergencyPage extends JFrame implements UserEmergencyPage{
    private  ImageIcon icon,BG_Img,bDonation_Img,findBlood_Img,fireService_Img;
	private JButton back_Button,bDonation_Button,findBlood_Button,fireService_Button;
	private JLabel bG_Label;
	private Cursor cursor;
	private Container cu;
	
	
	public void emergencyMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); // frame size
        setLocationRelativeTo(null);// frame in the middle
        getContentPane().setBackground(new Color(192,192,192));
        setResizable(false);// can't resize
        setTitle("Emergency Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        cu = this.getContentPane();
        
        //Back button
        back_Button = new JButton("Back");
        Font bt = new Font("Arial", Font.BOLD, 13);// change font
        back_Button.setFont(bt);
        back_Button.setCursor(cursor);
        back_Button.setBackground(new Color(255,255,255));
        back_Button.setFocusable(false);
        back_Button.setBounds(10, 10, 80, 20);
        cu.add(back_Button);
        
        
        //Blood Donation button
        bDonation_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\Blood Donation.png");
        bDonation_Button = new JButton("Donate Blood",bDonation_Img); //adding image and text in the button
  
        Font f = new Font("Arial", Font.BOLD, 20);// change font
        bDonation_Button.setFont(f);
        bDonation_Button.setCursor(cursor);
        bDonation_Button.setBackground(new Color(255,120,0));
        bDonation_Button.setBounds(100, 100, 280, 80);
        bDonation_Button.setFocusable(false);
        cu.add(bDonation_Button);
        
        //Find Blood Button button
        findBlood_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\Find Blood.png");
        findBlood_Button = new JButton("Find Blood",findBlood_Img); //adding image and text in the button
  
        Font fr = new Font("Arial", Font.BOLD, 20);// change font
        findBlood_Button.setFont(fr);
        findBlood_Button.setCursor(cursor);
        findBlood_Button.setBackground(new Color(255,120,0));
        findBlood_Button.setBounds(100, 200, 280, 80);
        findBlood_Button.setFocusable(false);
        cu.add(findBlood_Button);
        
        
        //Fire Service Button
        fireService_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\Fire Service.png");
        fireService_Button = new JButton("Fire Service",fireService_Img); //adding image and text in the button
  
        Font fu= new Font("Arial", Font.BOLD, 20);// change font
        fireService_Button.setFont(fu);
        fireService_Button.setCursor(cursor);
        fireService_Button.setBackground(new Color(255,120,0));
        fireService_Button.setBounds(100, 300, 280, 80);
        fireService_Button.setFocusable(false);
        cu.add(fireService_Button);
        
        bDonation_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_EmergencyBDonation frame = new User_EmergencyBDonation();
                frame.BloodDonationMenu();
                frame.setVisible(true);
            }
        });
        findBlood_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Emergency_DonorList ed = new Emergency_DonorList();
                ed.Donor_display();
                ed.setVisible(true);
            }
        });

        //Back Button
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

        //Fire Service
        fireService_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Unavailable_ServiceFrame u=new Unavailable_ServiceFrame();
                u.setVisible(true);
            }
        });
        
        BG_Img = new ImageIcon(getClass().getResource("admin.png")); // for background image add.
        bG_Label = new JLabel(BG_Img);
        //Bg_level.setBounds(50,30,626,386);
        cu.add(bG_Label);
        this.pack();
	}
}
