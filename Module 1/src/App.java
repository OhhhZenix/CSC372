class App {

  public static void main(String[] args) {
    // Testing BankAccount
    BankAccount account1 = new BankAccount("Bob", "Bob", 1001);
    account1.accountSummary();
    account1.deposit(1000);
    account1.accountSummary();
    account1.withdrawal(500); // regular withdrawal
    account1.accountSummary();
    account1.withdrawal(50000); // overdraft withdrawal
    account1.accountSummary();

    // Testing CheckingAccount
    CheckingAccount checkingAccount = new CheckingAccount("Billy", "Billy", 2001, 1.5);
    checkingAccount.displayAccount();
    checkingAccount.deposit(2000);
    checkingAccount.displayAccount();
    checkingAccount.processWithdrawal(200); // regular withdrawal
    checkingAccount.displayAccount();
    checkingAccount.processWithdrawal(2500); // overdraft withdrawal
    checkingAccount.displayAccount();
  }
}
