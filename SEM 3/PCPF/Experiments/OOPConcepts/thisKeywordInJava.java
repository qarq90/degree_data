package OOPConcepts;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

}

public class thisKeywordInJava {
    public static void main(String[] args) {
        Person person = new Person("Trevor Philips", 56);

        person.displayInfo();

        person.displayInfo();
    }
}
