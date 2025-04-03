package OOPConcepts;

class Character {
    public String name;

    public Character(String n) {
        System.out.println("Character is in scope - Object created");
        name = n;
        System.out.println(name + " is a damn good character");
    }
}

public class ConstructorJava {
    public static void main(String[] args) {
        Character T = new Character("Trevor Philips");
        Character J = new Character("John Marston");

        System.out.println(T.name + " is dead");
        System.out.println("Character is now out of scope - Object destroyed");
        System.out.println(J.name + " is dead");
        System.out.println("Character is now out of scope - Object destroyed");
    }
}
