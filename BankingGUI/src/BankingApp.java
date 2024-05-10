
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BankingApp extends JFrame {

    private final BankAccount account;

    public BankingApp() {
        this.account = new BankAccount();
    }

    public void run() {
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
        checkBalanceButton.addActionListener(e -> checkBalanceAction());
        panel.add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> depositAction());
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> withdrawalAction());

        panel.add(withdrawButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkBalanceAction() {
        JOptionPane.showMessageDialog(this, String.format("Your balance is $%,.2f!", this.account.getBalance()));
    }

    private void depositAction() {
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
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            }
        }
    }

    private void withdrawalAction() {
        String withdrawInput = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        if (withdrawInput != null) {
            try {
                double withdrawAmount = Double.parseDouble(withdrawInput);
                if (withdrawAmount >= 0) {
                    try {
                        this.account.withdrawal(withdrawAmount);
                        JOptionPane.showMessageDialog(this, String.format(
                                "$%,.2f has been withdrawn. Your balance is now $%,.2f!",
                                withdrawAmount,
                                this.account.getBalance()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a positive amount.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            }
        }
    }
}
