import java.util.Scanner;
import java.util.Random;

class BankExceptions extends Exception {
    BankExceptions(String exceptionMessage) {
        super(exceptionMessage);
    }
}

abstract class Account {
    public long accountNumber;
    public String accountName;
    public double accountBalance;

    abstract void withdrawBalance(double amount) throws BankExceptions;

    abstract void depositBalance(double amount) throws BankExceptions;

    abstract void displayDetails();
}

class Bank extends Account {
    Bank(String accountName, double accountBalance) {
        Random random = new Random();

        this.accountNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder: " + this.accountName);
        System.out.println("Account Balance: " + this.accountBalance);
    }

    void depositBalance(double amount) throws BankExceptions {
        if (amount == 0) {
            throw new BankExceptions("Deposit Amount cannot be zero");
        } else {
            this.accountBalance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + this.accountBalance);
        }
    }

    void withdrawBalance(double amount) throws BankExceptions {
        if (this.accountBalance < amount) {
            throw new BankExceptions("Withdraw Amount cannot be more than Balance");
        } else {
            this.accountBalance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + this.accountBalance);
        }
    }
}

public class EXP4Bank {
    public static void main(String[] args) {
        Bank bank = new Bank("Spectre", 15000.00);
        bank.displayDetails();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        try {
            bank.depositBalance(depositAmount);
        } catch (BankExceptions e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        try {
            bank.withdrawBalance(withdrawAmount);
        } catch (BankExceptions e) {
            System.out.println(e.getMessage());
        }

        bank.displayDetails();

        scanner.close();
    }
}
