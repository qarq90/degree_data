package EXP1;

class Parent {
    void displayParent() {
        System.out.println("From Daddy");
    }
}

class Child extends Parent {
    void displayChild() {
        System.out.println("From Boomer");
    }
}

public class InheritanceJava {
    public static void main(String[] args) {
        Child child = new Child();
        child.displayParent();
        child.displayChild();
    }
}