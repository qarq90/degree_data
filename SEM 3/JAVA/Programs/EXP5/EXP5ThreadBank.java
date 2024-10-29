class EXP5ThreadBankAccount {
    private int balance;

    public EXP5ThreadBankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds to withdraw: " + amount + ", Current Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class EXP5ThreadDeposit extends Thread {
    private EXP5ThreadBankAccount account;
    private int amount;

    public EXP5ThreadDeposit(EXP5ThreadBankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

class EXP5ThreadWithdraw extends Thread {
    private EXP5ThreadBankAccount account;
    private int amount;

    public EXP5ThreadWithdraw(EXP5ThreadBankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

class EXP5ThreadBank {
    public static void main(String[] args) {
        EXP5ThreadBankAccount account = new EXP5ThreadBankAccount(1000);

        EXP5ThreadDeposit deposit1 = new EXP5ThreadDeposit(account, 500);
        EXP5ThreadWithdraw withdraw1 = new EXP5ThreadWithdraw(account, 200);
        EXP5ThreadWithdraw withdraw2 = new EXP5ThreadWithdraw(account, 800);

        deposit1.start();
        withdraw1.start();
        withdraw2.start();

        try {
            deposit1.join();
            withdraw1.join();
            withdraw2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
