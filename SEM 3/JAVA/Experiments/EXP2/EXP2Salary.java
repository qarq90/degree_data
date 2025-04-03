import java.util.Scanner;

public class EXP2Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.50;
        double ta = basicSalary * 0.10;
        double totalSalary = basicSalary + hra + da + ta;

        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA (20%): " + hra);
        System.out.println("DA (50%): " + da);
        System.out.println("TA (10%): " + ta);
        System.out.println("Total Salary: " + totalSalary);
        scanner.close();
    }
}
