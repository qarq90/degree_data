package EXP5;

import java.util.Scanner;

public class auth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String predefinedEmail = "qarq90@gmail.com";
        final String predefinedPassword = "iLoveGymommies";

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            if (email.equals(predefinedEmail) && password.equals(predefinedPassword)) {
                System.out.println("Login successful! Welcome!");
            } else {
                throw new Exception("Invalid email or password.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

