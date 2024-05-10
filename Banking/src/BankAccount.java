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

    public void withdrawal(double amount) throws Exception {
        if (this.balance < amount)
            throw new Exception("Withdrawal amount is greater than account balance.");

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