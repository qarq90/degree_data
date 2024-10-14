package EXP6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class moreDS {
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

        HashMap<String, String> hashMap = new HashMap<>();

        System.out.print("Enter the number of key-value pairs to add to the HashMap: ");
        int mapSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter " + mapSize + " key-value pairs (key and value separated by a space):");
        for (int i = 0; i < mapSize; i++) {
            String[] entry = scanner.nextLine().split(" ");
            if (entry.length == 2) {
                hashMap.put(entry[0], entry[1]);
            } else {
                System.out.println("Invalid input! Please enter a key and a value.");
                i--;
            }
        }

        System.out.println("HashMap elements:");
        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        }

        System.out.print("Enter key to retrieve value from HashMap: ");
        String keyToRetrieve = scanner.nextLine();
        if (hashMap.containsKey(keyToRetrieve)) {
            System.out.println("Value for key '" + keyToRetrieve + "': " + hashMap.get(keyToRetrieve));
        } else {
            System.out.println("Key not found!");
        }

        scanner.close();
    }
}

