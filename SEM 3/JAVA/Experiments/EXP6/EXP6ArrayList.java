import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EXP6ArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> arrayList = new ArrayList<>();

        System.out.print("Enter the number of elements to add to the ArrayList: ");
        int listSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter " + listSize + " elements for the ArrayList:");
        for (int i = 0; i < listSize; i++) {
            arrayList.add(scanner.nextLine());
        }

        System.out.println("ArrayList elements:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Element at index " + i + ": " + arrayList.get(i));
        }

        scanner.close();
    }
}
