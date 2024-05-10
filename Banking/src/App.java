
class App {

    public static void main(String[] args) {
        // Testing BankAccount
        BankAccount account1 = new BankAccount("Bob", "Bob", 1001);
        account1.accountSummary();
        account1.deposit(1000);
        account1.accountSummary();
        try {
            account1.withdrawal(500);
            account1.accountSummary();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            account1.withdrawal(50000);
            account1.accountSummary();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testing CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Billy", "Billy", 2001, 1.5);
        checkingAccount.displayAccount();
        checkingAccount.deposit(2000);
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(2500);
        checkingAccount.displayAccount();
    }
}
