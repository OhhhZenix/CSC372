class CheckingAccount extends BankAccount {

  private final double interestRate;

  public CheckingAccount(String firstName, String lastName, int accountId, double interestRate) {
    super(firstName, lastName, accountId);
    this.interestRate = interestRate;
  }

  public void processWithdrawal(double amount) {
    System.out.println(String.format("Attempting to withdraw $%,.2f from %s...", amount, this.accountId));

    if (amount <= this.getBalance()) {
      this.balance -= amount;
    } else {
      this.balance -= amount + 30;
      System.out.println("Overdraft fee of $30 has been applied.");
    }

    System.out.println(String.format("Successfully withdrew $%,.2f from %s!", amount, this.accountId));
  }

  public void displayAccount() {
    this.accountSummary();
    System.out.println(String.format("Interest Rate: %,.2f%%", this.interestRate));
  }
}
