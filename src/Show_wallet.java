import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Show_wallet extends JFrame {

    private ImageIcon im_s, im_balance;
    private Container Cs;
    private Cursor cursor;
    public JLabel balance_label, available_label, amount_label;
    private JButton back_s;
    private String q,sum;


    void Show_amount() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Wallet");
        cursor = new Cursor(cursor.HAND_CURSOR);
        im_s = new ImageIcon(getClass().getResource("vh1.png"));
        setIconImage(im_s.getImage());
        Cs = getContentPane();
        Cs.setLayout(null);
        Cs.setBackground(Color.LIGHT_GRAY);

        available_label = new JLabel();
        available_label.setText("Available Balance");
        available_label.setBounds(160, 27, 150, 20);
        Font f = new Font("New Roman Time", Font.BOLD, 16);
        available_label.setFont(f);
        Cs.add(available_label);

        //amount label
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.next();
        FileReader fw=new FileReader("E:\\virtual_hospital_project\\Wallet\\"+q+".txt");
        BufferedReader b=new BufferedReader(fw);
        Scanner c=new Scanner(b);
        sum=c.next();
        amount_label = new JLabel();
        //amount_label.setText("1000000");
        amount_label.setBounds(200, 90, 150, 20);
        Font ff = new Font("New Roman Time", Font.BOLD, 16);
        amount_label.setText(sum+"/= TK");
        amount_label.setFont(ff);
        Cs.add(amount_label);

        im_balance = new ImageIcon(getClass().getResource("balance_n.png"));
        balance_label = new JLabel(im_balance);
        balance_label.setBounds(115, 30, 250, 150);
        Cs.add(balance_label);

        //back button
        back_s = new JButton("Back");
        back_s.setBounds(5, 5, 70, 18);
        Cs.add(back_s);

        back_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_WalletHomePage w = new User_WalletHomePage();
                w.walletMenu();
                w.setVisible(true);
            }
        });
    }


}

