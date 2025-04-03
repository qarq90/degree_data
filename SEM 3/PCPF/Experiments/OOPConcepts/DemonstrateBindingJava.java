package OOPConcepts;

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void speak() {
        System.out.println("Cat meows");
    }
}

public class DemonstrateBindingJava {
    static void makeAnimalSpeak(Animal animal) {
        animal.speak();
    }

    public static void main(String[] args) {
        Dog myDog = new Dog();
        Cat myCat = new Cat();

        makeAnimalSpeak(myDog);
        makeAnimalSpeak(myCat);
    }
}
