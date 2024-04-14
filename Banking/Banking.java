class BankAccount {
    private String firstName;
    private String lastName;
    private int accountId;
    private double balance;

    public BankAccount(String firstName, String lastName, int accountId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountId = accountId;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println(String.format("Name: %s %s", this.firstName, this.lastName));
        System.out.println(String.format("Account ID: %s", this.accountId));
        System.out.println(String.format("Balance: $%,.2f", this.balance));
    }
}

class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountId, double interestRate) {
        super(firstName, lastName, accountId);
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        if (amount <= this.getBalance()) {
            this.withdrawal(amount);
            return;
        }

        this.withdrawal(amount + 30);
        System.out.println("Overdraft fee of $30 has been applied.");
    }

    public void displayAccount() {
        this.accountSummary();
        System.out.println(String.format("Interest Rate: %,.2f%%", this.interestRate));
    }
}

class BankingApp {
    public static void main(String[] args) {
        // Testing BankAccount
        BankAccount account1 = new BankAccount("Bob", "Bob", 1001);
        account1.accountSummary();
        account1.deposit(1000);
        account1.accountSummary();
        account1.withdrawal(500);
        account1.accountSummary();

        // Testing CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Billy", "Billy", 2001, 1.5);
        checkingAccount.displayAccount();
        checkingAccount.deposit(2000);
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(2500);
        checkingAccount.displayAccount();
    }
}