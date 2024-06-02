class BankAccount {

  private String firstName;
  private String lastName;
  protected int accountId;
  protected double balance;

  public BankAccount(String firstName, String lastName, int accountId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.accountId = accountId;
    this.balance = 0;
  }

  public void deposit(double amount) {
    System.out.println(String.format("Attempting to deposit $%,.2f to %s...", amount, this.accountId));
    this.balance += amount;
    System.out.println(String.format("Successfully deposited $%,.2f to %s!", amount, this.accountId));
  }

  public void withdrawal(double amount) {
    System.out.println(String.format("Attempting to withdraw $%,.2f from %s...", amount, this.accountId));

    if (this.balance < amount) {
      System.out.println("Failed to withdraw. Withdrawal amount is greater than account balance.");
      return;
    }

    this.balance -= amount;
    System.out.println(String.format("Successfully withdrew $%,.2f from %s!", amount, this.accountId));
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
