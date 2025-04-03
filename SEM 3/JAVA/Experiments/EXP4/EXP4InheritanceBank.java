import java.util.Scanner;
import java.util.Random;

class EXP4BankExceptions extends Exception {
    EXP4BankExceptions(String exceptionMessage) {
        super(exceptionMessage);
    }
}

abstract class EXP4BankAccount {
    public long accountNumber;
    public String accountName;
    public double accountBalance;

    abstract void withdrawBalance(double amount) throws EXP4BankExceptions;

    abstract void depositBalance(double amount) throws EXP4BankExceptions;

    abstract void displayDetails();
}

class EXP4Bank extends EXP4BankAccount {
    EXP4Bank(String accountName, double accountBalance) {
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

    void depositBalance(double amount) throws EXP4BankExceptions {
        if (amount == 0) {
            throw new EXP4BankExceptions("Deposit Amount cannot be zero");
        } else {
            this.accountBalance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + this.accountBalance);
        }
    }

    void withdrawBalance(double amount) throws EXP4BankExceptions {
        if (this.accountBalance < amount) {
            throw new EXP4BankExceptions("Withdraw Amount cannot be more than Balance");
        } else {
            this.accountBalance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + this.accountBalance);
        }
    }
}

public class EXP4InheritanceBank {
    public static void main(String[] args) {
        EXP4Bank bank = new EXP4Bank("Spectre", 15000.00);
        bank.displayDetails();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        try {
            bank.depositBalance(depositAmount);
        } catch (EXP4BankExceptions e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        try {
            bank.withdrawBalance(withdrawAmount);
        } catch (EXP4BankExceptions e) {
            System.out.println(e.getMessage());
        }

        bank.displayDetails();

        scanner.close();
    }
}
