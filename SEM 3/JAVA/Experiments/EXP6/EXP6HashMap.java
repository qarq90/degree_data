import java.util.HashMap;

public class EXP6HashMap extends HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> ageMap = new HashMap<>();

        ageMap.put("Alice", 30);
        ageMap.put("Bob", 25);
        ageMap.put("Charlie", 35);

        System.out.println("Original Hashmap:" + ageMap);

        System.out.println("Alice's age: " + ageMap.get("Alice"));
        System.out.println("Bob's age: " + ageMap.get("Bob"));
        System.out.println("Charlie's age: " + ageMap.get("Charlie"));

        if (ageMap.containsKey("Alice")) {
            System.out.println("Alice is in the map.");
        }

        ageMap.remove("Bob");
        System.out.println("Bob removed from the map.");

        System.out.println("Updated ageMap: " + ageMap);
    }
}
