package EXP3;

import java.util.Scanner;

class emp {
    int empNumber, empSalary;
    String empName, empAddress;
    static Scanner sc = new Scanner(System.in);

    void getEmployee() {
        System.out.print("Enter employee number: ");
        this.empNumber = sc.nextInt();
        System.out.print("Enter employee name: ");
        this.empName = sc.next();
        System.out.print("Enter employee address: ");
        this.empAddress = sc.next();
        System.out.print("Enter employee salary: ");
        this.empSalary = sc.nextInt();
    }

    void getEmployee(int empNumber, int empSalary, String empName, String empAddress) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
    }

    void showEmployee() {
        System.out.println(" " + empNumber + "\t" + empName + "\t" + empSalary + "\t" + empAddress);
    }

    static void searchEmployee(emp[] arr, int searchId) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].empNumber == searchId) {
                System.out.print("Employee exists. Details are as follows: \n");
                arr[i].showEmployee();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No such Employee exists.");
        }
    }

    void updateEmployee() {
        System.out.print("Please enter updated employee address: ");
        this.empAddress = sc.next();
        System.out.print("Enter the updated salary: ");
        this.empSalary = sc.nextInt();
        this.showEmployee();
    }
}

class EXP3a {
    public static void main(String[] args) {
        emp[] arr = new emp[1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new emp();
            arr[i].getEmployee();
        }
        System.out.print("Enter the employee number to search: ");
        int s = emp.sc.nextInt();
        emp.searchEmployee(arr, s);
    }
}

