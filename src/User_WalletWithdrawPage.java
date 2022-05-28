import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

interface u_wallet {
    void Show_amount();
}

class User_WalletWithdrawPage extends JFrame implements u_wallet {

    private ImageIcon im;
    private Container Cm;
    private Cursor cursor;
    private JLabel addMoney_label, trans_label;
    private JTextField addMoney_field, trans_filed;
    private JButton back_w, wallet_button;
    private String q;
    private int g;
    private int add_money, transaction;
    private String Add_money, Transaction;
    private String File;
    private String sum;
    private int sum1;

    public void Show_amount() {
        try {
            FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
            BufferedReader b2 = new BufferedReader(f2);
            Scanner s = new Scanner(b2);
            q = s.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Withdraw Money");
        cursor = new Cursor(cursor.HAND_CURSOR);
        im = new ImageIcon(getClass().getResource("vh1.png"));
        setIconImage(im.getImage());
        Cm = getContentPane();
        Cm.setLayout(null);
        Cm.setBackground(Color.LIGHT_GRAY);

        //add money label
        addMoney_label = new JLabel();
        addMoney_label.setText("Amount :");
        addMoney_label.setBounds(30, 40, 100, 20);
        Cm.add(addMoney_label);

        //add money text filed
        addMoney_field = new JTextField();
        addMoney_field.setBounds(30, 60, 150, 25);
        Cm.add(addMoney_field);

        //transaction label
        trans_label = new JLabel();
        trans_label.setText("Transaction No :");
        trans_label.setBounds(30, 120, 100, 20);
        Cm.add(trans_label);

        //Transaction filed
        trans_filed = new JTextField();
        trans_filed.setBounds(30, 140, 150, 25);
        Cm.add(trans_filed);

        //back button
        back_w = new JButton("Back");
        back_w.setBounds(5, 5, 70, 18);
        back_w.setCursor(cursor);
        Cm.add(back_w);

        //wallet button
        wallet_button = new JButton("Withdraw");
        wallet_button.setBounds(150, 200, 110, 20);
        wallet_button.setCursor(cursor);
        Cm.add(wallet_button);

        back_w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_WalletHomePage w = new User_WalletHomePage();
                w.walletMenu();
                w.setVisible(true);
            }
        });


        //balance transfer action listener
        wallet_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Add_money = addMoney_field.getText();
                    Transaction = trans_filed.getText();
                    add_money = Integer.parseInt(Add_money);
                    if (Transaction.equals("1001")) {
                        FileReader fw = new FileReader("E:\\virtual_hospital_project\\Wallet\\" + q + ".txt");
                        BufferedReader b = new BufferedReader(fw);
                        Scanner c = new Scanner(b);
                        sum = c.next();
                        sum1 = Integer.parseInt(sum);
                        sum1 = sum1 - add_money;
                        b.close();
                        FileWriter f = new FileWriter("E:\\virtual_hospital_project\\Wallet\\" + q + ".txt");
                        PrintWriter p = new PrintWriter(f);
                        p.println(sum1);
                        p.close();
                        JOptionPane.showMessageDialog(null, "Successful!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error!");
                    }
                } catch (Exception er) {
                    try {
                        FileWriter f = new FileWriter("E:\\virtual_hospital_project\\Wallet\\" + q + ".txt");
                        PrintWriter p = new PrintWriter(f);
                        p.println(0);
                        p.close();
                    } catch (Exception w) {
                    }
                }
                User_HomePage u = new User_HomePage();
                try {
                    u.userMenu();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                u.setVisible(true);
            }
        });
    }

}



