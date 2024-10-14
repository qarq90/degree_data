package EXP4;

import java.util.Scanner;

class BankBranch {
    static String IFSC_code = "DCBL0000027";
    static String MICR_code = "400072027";
    static String swiftCode = "DCBLINBB";
    static String branchCode = "000027";
    static String branchName = "Byculla - Mumbai";
    static String address = "Zainab Manzil, 108-110, Dr. Babasaheb Ambedkar Road, Byculla, Mumbai - 400 027";
    static String city = "Mumbai";
    static String district = "Mumbai";
    static String state = "Maharashtra";

    public static void showBranchDetails() {
        System.out.println("Branch Name: " + branchName);
        System.out.println("Branch Address: " + address);
        System.out.println("Branch City: " + city);
        System.out.println("Branch District: " + district);
        System.out.println("Branch State: " + state);
        System.out.println("Branch Code: " + branchCode);
        System.out.println("Branch IFSC Code: " + IFSC_code);
        System.out.println("Branch MICR Code: " + MICR_code);
        System.out.println("Branch Swift Code: " + swiftCode);
    }

}

class Bankuser extends BankBranch {
    Scanner sc = new Scanner(System.in);
    long acc_no = 0, temp;
    String customer_name, customer_address;
    double ROI = 0.08, initial_balance = 0;

    public void createAccount() {
        System.out.print("Please enter account number: ");
        acc_no = sc.nextLong();
        System.out.print("Please enter customer name: ");
        customer_name = sc.next();
        System.out.print("Please enter customer address: ");
        customer_address = sc.next();
        System.out.println("Account created successfully!");
        initial_balance = 0;
    }

    public void deposit() {
        System.out.println("Enter amount you wish to deposit: ");
        long deposit = sc.nextLong();
        initial_balance += deposit;
        System.out.println("Amount deposited successfully!\nBalance: " + initial_balance);
    }

    public void withdraw() {
        System.out.println("Enter amount you wish to withdraw: ");
        long withdrawal = sc.nextLong();
        initial_balance -= withdrawal;
        System.out.println("Amount withdrawn successfully!\nBalance: " + initial_balance);
    }

    public void computeInterest() {
        double amt = (initial_balance * ROI * 1);
        System.out.println("Interest for initial balance after 1 years: " + amt);
    }

    public void displayBalance() {
        System.out.println("Initial balance: " + initial_balance);
    }

    public void showAccountSummary() {
        System.out.println("Branch Details: ");
        System.out.println("Branch Name: " + branchName + "\nBranch Address: " + address + "\nIFSC Code: " + IFSC_code);
        System.out.println("Customer Details: ");
        System.out.println("Name: " + customer_name + "\nAddress: " + customer_address + "\nAccount Number: " + acc_no);
        this.displayBalance();
    }
}

public class bank {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bankuser[] user = new Bankuser[3];
        int loop, n = 0;
        for (int i = 0; i < user.length; i++) {
            user[i] = new Bankuser();
        }
        do {
            System.out.println("Please choose from the following menu:\n1.Create Account\n2.Deposit\n3.Withdraw\n4.Compute Interest\n5.Display Balance\n6.Display Account details\n7.Display Branch Details");
            int choice = sc.nextInt();
            long temp;
            boolean found = false;
            switch (choice) {
                case 1:
                    user[n].createAccount();
                    n++;
                    break;
                case 2:
                    System.out.print("Enter Account number: ");
                    temp = sc.nextLong();
                    for (Bankuser value : user) {
                        if (value.acc_no == temp) {
                            value.deposit();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account number does not exist!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account number: ");
                    temp = sc.nextLong();
                    for (Bankuser bankuser : user) {
                        if (bankuser.acc_no == temp) {
                            bankuser.withdraw();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account number does not exist!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account number: ");
                    temp = sc.nextLong();
                    for (Bankuser bankuser : user) {
                        if (bankuser.acc_no == temp) {
                            bankuser.computeInterest();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account number does not exist!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account number: ");
                    temp = sc.nextLong();
                    for (Bankuser bankuser : user) {
                        if (bankuser.acc_no == temp) {
                            bankuser.displayBalance();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account number does not exist!");
                    }
                    break;
                case 6:
                    System.out.print("Enter Account number: ");
                    temp = sc.nextLong();
                    for (Bankuser bankuser : user) {
                        if (bankuser.acc_no == temp) {
                            bankuser.showAccountSummary();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account number does not exist!");
                    }
                    break;
                case 7:
                    BankBranch.showBranchDetails();
                    break;
                default:
                    System.out.println("Invalid choice entered!");
                    break;
            }
            System.out.print("Would you like to continue with other operations?(Press 1 to continue)");
            loop = sc.nextInt();
        } while (loop == 1);
    }
}
