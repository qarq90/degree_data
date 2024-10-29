import java.util.Scanner;

class EXP5ExceptionBankInsufficientBalanceException extends Exception {
    public EXP5ExceptionBankInsufficientBalanceException(String message) {
        super(message);
    }
}

class EXP5ExceptionBankLogic {
    private double balance;
    private final double minimumBalance;

    public EXP5ExceptionBankLogic(double initialBalance, double minimumBalance) {
        this.balance = initialBalance;
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount) throws EXP5ExceptionBankInsufficientBalanceException {
        if ((balance - amount) < minimumBalance) {
            throw new EXP5ExceptionBankInsufficientBalanceException(
                    "Withdrawal denied! Minimum balance of " + minimumBalance + " must be maintained.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class EXP5ExceptionBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EXP5ExceptionBankLogic account = new EXP5ExceptionBankLogic(1000.0, 500.0);

        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        try {
            account.withdraw(withdrawAmount);
        } catch (EXP5ExceptionBankInsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Current balance: " + account.getBalance());

        scanner.close();
    }
}
