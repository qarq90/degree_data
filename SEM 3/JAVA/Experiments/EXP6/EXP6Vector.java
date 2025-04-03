import java.util.Vector;

public class EXP6Vector {

    public static void main(String[] args) {
        Vector vector = new Vector<String>();

        vector.add("Element1");
        vector.add("Element2");
        vector.add("Element3");
        vector.add("Element4");
        vector.add("Element5");

        System.out.println("Initial Vector: " + vector);

        vector.remove("Element2");
        vector.remove(2);

        System.out.println("Vector after removals: " + vector);

        int index = 1;
        if (index < vector.size()) {
            System.out.println("Element at index " + index + ": " + vector.get(index));
        } else {
            System.out.println("Index " + index + " is out of bounds.");
        }

        System.out.println("Displaying all elements in Vector:");
        for (Object element : vector) {
            System.out.println(element);
        }
    }
}
