package EXP2;

import java.util.Scanner;

class bank {
    private String name;
    private String accno;
    private static long balance = 0;

    static Scanner KB = new Scanner(System.in);

    void createAccount() {
        System.out.println("Enter Name: ");
        name = KB.next();
        System.out.println("Enter Account No: ");
        accno = KB.next();
        System.out.println("Enter Balance: ");
        balance = KB.nextLong();
        System.out.println("\n");
    }

    void showAccount() {
        System.out.println("Name: " + name + "\nAccount No: " + accno + "\nBalance: " + balance + "\n");
    }

    void deposit() {
        long amt;
        System.out.println("Enter Amount you want to deposit: ");
        amt = KB.nextLong();
        balance += amt;
    }

    void withdraw() {
        long amt;
        System.out.println("Enter amount you want to withdraw: ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance -= amt;
        } else {
            System.out.println("Less balance. Transaction failed.");
        }
    }

    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return true;
        }
        return false;
    }

    void computeInterest() {
        System.out.println("Enter term in months to calculate interest on current balance");
        System.out.print("Term (Months): ");
        int t = KB.nextInt();
        System.out.println("Our Bank's ROI is 8%");
        double interest = getBalance() * 0.08 * (t / 12.0);
        System.out.println("Interest after " + t + " months will be: " + interest);
        System.out.println("");
    }

    static double getBalance() {
        return balance;
    }
}

class ExBank {
    public static void main(String[] args) {
        Scanner KB = new Scanner(System.in);
        System.out.println("How many customers do you want to input? ");
        int n = KB.nextInt();
        bank[] C = new bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new bank();
            C[i].createAccount();
        }
        int ch;
        do {
            System.out.println("Main menu\n1. Display All\n2. Search by Account\n3. Deposit\n4. Withdrawal\n5. Compute Interest\n6. Exit ");
            System.out.print("\nEnter your choice: ");
            ch = KB.nextInt();
            switch (ch) {
                case 1:
                    for (bank bank : C) {
                        bank.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter Account No you want to search: ");
                    String acn = KB.next();
                    boolean found = false;
                    for (bank bank : C) {
                        found = bank.search(acn);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed. Account does not exist.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account No: ");
                    acn = KB.next();
                    found = false;
                    for (bank bank : C) {
                        found = bank.search(acn);
                        if (found) {
                            bank.deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed. Account does not exist.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No: ");
                    acn = KB.next();
                    found = false;
                    for (bank bank : C) {
                        found = bank.search(acn);
                        if (found) {
                            bank.withdraw();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed. Account does not exist.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account No: ");
                    acn = KB.next();
                    found = false;
                    for (bank bank : C) {
                        found = bank.search(acn);
                        if (found) {
                            bank.computeInterest();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed. Account does not exist.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (ch != 6);
        KB.close();
    }
}

