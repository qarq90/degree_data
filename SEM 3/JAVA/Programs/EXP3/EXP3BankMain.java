class EXP3Bank {
    private String accountHolder;
    private double balance;

    public EXP3Bank(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void showAccountInfo() {
        System.out.println("Account Holder: " + accountHolder + ", Balance: $" + balance);
    }
}

public class EXP3BankMain {
    public static void main(String[] args) {
        EXP3Bank account = new EXP3Bank("John Doe", 500);

        account.deposit(200);
        account.showAccountInfo();
        account.withdraw(100);
        account.showAccountInfo();
    }
}
