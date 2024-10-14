package EXP6;

import java.util.Scanner;
import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at index " + i + ": " + array[i]);
        }

        Vector<Integer> vector = new Vector<>();

        System.out.print("Enter the number of elements to add to the Vector: ");
        int vectorSize = scanner.nextInt();
        System.out.println("Enter " + vectorSize + " elements for the Vector:");
        for (int i = 0; i < vectorSize; i++) {
            vector.add(scanner.nextInt());
        }

        System.out.println("Vector elements:");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println("Element at index " + i + ": " + vector.get(i));
        }

        System.out.print("Enter index to retrieve from Vector: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < vector.size()) {
            System.out.println("Element at index " + index + ": " + vector.get(index));
        } else {
            System.out.println("Invalid index!");
        }

        scanner.close();
    }
}
