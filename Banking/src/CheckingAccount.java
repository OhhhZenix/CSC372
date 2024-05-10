
class CheckingAccount extends BankAccount {

    private final double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountId, double interestRate) {
        super(firstName, lastName, accountId);
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        if (amount <= this.getBalance()) {
            this.balance -= amount;
            return;
        }

        this.balance -= amount + 30;
        System.out.println("Overdraft fee of $30 has been applied.");
    }

    public void displayAccount() {
        this.accountSummary();
        System.out.println(String.format("Interest Rate: %,.2f%%", this.interestRate));
    }
}
