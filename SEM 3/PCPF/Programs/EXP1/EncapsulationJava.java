package EXP1;

class Character {
    private String name;

    public void getName(String n) {
        name = n;
    }

    public void printName() {
        System.out.println("Name: " + name);
    }
}

public class EncapsulationJava {
    public static void main(String[] args) {
        Character p = new Character();
        p.getName("Arthur Morgan");
        p.printName();
    }
}