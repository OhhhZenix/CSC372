import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BankingApp extends JFrame implements ActionListener {
    private BankAccount account;

    public BankingApp() {
        this.account = new BankAccount();

        setTitle("Banking App");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

        JLabel welcomeLabel = new JLabel("Welcome to the Banking app!");
        panel.add(welcomeLabel);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(this);
        panel.add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Check Balance":
                JOptionPane.showMessageDialog(this, String.format(
                        "Your balance is $%,.2f!", this.account.getBalance()));
                break;
            case "Deposit":
                String depositInput = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
                if (depositInput != null) {
                    try {
                        double depositAmount = Double.parseDouble(depositInput);
                        if (depositAmount >= 0) {
                            this.account.deposit(depositAmount);
                            JOptionPane.showMessageDialog(this, String.format(
                                    "$%,.2f has been deposited. Your balance is now $%,.2f!",
                                    depositAmount,
                                    this.account.getBalance()));
                        } else {
                            JOptionPane.showMessageDialog(this, "Please enter a positive amount.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                    }
                }
                break;
            case "Withdraw":
                String withdrawInput = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
                if (withdrawInput != null) {
                    try {
                        double withdrawAmount = Double.parseDouble(withdrawInput);
                        if (withdrawAmount >= 0) {
                            if (withdrawAmount <= this.account.getBalance()) {
                                this.account.withdrawal(withdrawAmount);
                                JOptionPane.showMessageDialog(this, String.format(
                                        "$%,.2f has been withdrawn. Your balance is now $%,.2f!",
                                        withdrawAmount,
                                        this.account.getBalance()));
                            } else {
                                JOptionPane.showMessageDialog(this, "Insufficient funds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please enter a positive amount.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                    }
                }
                break;
            default:
                break;
        }
    }
}
