import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

interface wallet {
    void walletMenu();
}

public class User_WalletHomePage extends JFrame implements wallet {

    private Cursor cursor;
    private ImageIcon icon, addMoney_Img, withdrawMoney_Img, acDetials_Img;
    private Container cu;
    private JButton back_Button, addMoney_Button, withdrawMoney_Button, acDetials_Button;
    private JLabel blank_Label;

    public void walletMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(192, 192, 192));
        setSize(500, 600); // frame size
        setLocationRelativeTo(null);// frame in the middle
        //setBounds(50,30,626,386);
        setResizable(false);// can't resize
        setTitle("Wallet Page"); // title add
        //mouse cursor
        cursor = new Cursor(cursor.HAND_CURSOR);

        icon = new ImageIcon(getClass().getResource("/vh1.png"));// icon add
        this.setIconImage(icon.getImage());
        cu = this.getContentPane();

        //for Back Button
        back_Button = new JButton("Back");
        back_Button.setFont(new Font("Arial", Font.BOLD, 12));
        back_Button.setBounds(10, 10, 100, 20);
        back_Button.setBackground(new Color(255, 255, 255));
        back_Button.setCursor(cursor);
        back_Button.setFocusable(false);
        //back_Button.addActionListener(this);
        cu.add(back_Button);

        //blank Label
        blank_Label = new JLabel();
        blank_Label.setText("                                       ");
        cu.add(blank_Label);
        Font ut = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 40);// change font
        blank_Label.setFont(ut);

        //Add money button
        addMoney_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\AddMoney.png");
        addMoney_Button = new JButton("ADD MONEY IN YOUR WALLET", addMoney_Img); //adding image and text in the button

        Font f = new Font("Arial", Font.BOLD, 20);// change font
        addMoney_Button.setFont(f);
        addMoney_Button.setCursor(cursor);
        addMoney_Button.setBackground(new Color(255, 128, 0));
        addMoney_Button.setFocusable(false);
        cu.add(addMoney_Button);
        setLayout(new FlowLayout(10, 20, 20));


        //blank Label
        blank_Label = new JLabel();
        blank_Label.setText("                                       ");
        cu.add(blank_Label);
        Font lt = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        blank_Label.setFont(lt);


        //Withdraw money button
        withdrawMoney_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\WithdrawMoney.png");
        withdrawMoney_Button = new JButton("WITHDRAW FROM THE WALLET", withdrawMoney_Img); //adding image and text in the button
        Font t = new Font("Arial", Font.BOLD, 20);// change font
        withdrawMoney_Button.setFont(t);
        withdrawMoney_Button.setCursor(cursor);
        withdrawMoney_Button.setBackground(new Color(255, 128, 0));
        withdrawMoney_Button.setFocusable(false);
        cu.add(withdrawMoney_Button);
        setLayout(new FlowLayout(10, 20, 20));

        //blank Label
        blank_Label = new JLabel();
        blank_Label.setText("                                       ");
        cu.add(blank_Label);
        Font kt = new Font("Adobe Gothic Std B", Font.BOLD + Font.ITALIC, 30);// change font
        blank_Label.setFont(kt);

        //Wallet Details Button
        acDetials_Img = new ImageIcon("E:\\virtual_hospital_project\\src\\Wallet Detail.png");
        acDetials_Button = new JButton("SHOW DETAIL OF THE WALLET", acDetials_Img); //adding image and text in the button
        Font l = new Font("Arial", Font.BOLD, 20);// change font
        acDetials_Button.setFont(l);
        acDetials_Button.setCursor(cursor);
        acDetials_Button.setBackground(new Color(255, 128, 0));
        acDetials_Button.setFocusable(false);
        cu.add(acDetials_Button);
        setLayout(new FlowLayout(10, 30, 20));


        back_Button.addActionListener(new ActionListener() {
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

        addMoney_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Add_Money am = new Add_Money();
                try {
                    am.Add_amount();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                am.setVisible(true);
            }
        });

        acDetials_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Show_wallet s = new Show_wallet();
                try {
                    s.Show_amount();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                s.setVisible(true);
            }
        });
        withdrawMoney_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                User_WalletWithdrawPage s = new User_WalletWithdrawPage();
                s.Show_amount();
                s.setVisible(true);
            }
        });

    }


    public static void main(String[] args) {
        User_WalletHomePage u = new User_WalletHomePage();
        u.walletMenu();
        u.setVisible(true);
    }
}

class Add_Money extends JFrame {
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

    void Add_amount() throws FileNotFoundException {
        FileReader f2 = new FileReader("E:\\virtual_hospital_project\\Wallet\\Wallet.txt");
        BufferedReader b2 = new BufferedReader(f2);
        Scanner s = new Scanner(b2);
        q = s.next();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Add Money");
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
        wallet_button = new JButton("Add to Wallet");
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
                        sum1 = sum1 + add_money;
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


