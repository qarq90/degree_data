import java.util.Scanner;

public class EXP6String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.println("Original String: " + inputString);
        System.out.println("Length of the string: " + inputString.length());
        System.out.println("Uppercase: " + inputString.toUpperCase());
        System.out.println("Lowercase: " + inputString.toLowerCase());
        System.out.println("Substring (first 5 characters): " + inputString.substring(0, 5));
        System.out.println("Reversed String: " + reverseString(inputString));

        System.out.print("Enter another string to build: ");
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());

        stringBuilder.append(" - This is appended text.");
        System.out.println("StringBuilder Content: " + stringBuilder);
        System.out.println("Reversed StringBuilder: " + stringBuilder.reverse());
        stringBuilder.reverse();
        System.out.println("Original StringBuilder after reversing back: " + stringBuilder);
        stringBuilder.insert(5, " INSERTED ");
        System.out.println("StringBuilder after inserting: " + stringBuilder);
        stringBuilder.delete(5, 16);
        System.out.println("StringBuilder after deletion: " + stringBuilder);

        scanner.close();
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
