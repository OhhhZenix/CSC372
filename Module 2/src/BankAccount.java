public class BankAccount {

  private double balance;

  public BankAccount() {
    this.balance = 0;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  public void withdrawal(double amount) throws Exception {
    if (this.balance < amount) {
      throw new Exception("Withdrawal amount is greater than account balance.");
    }
    this.balance -= amount;
  }

  public double getBalance() {
    return this.balance;
  }
}
