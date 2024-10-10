public class exp9 {
    static class MyClass {
        MyClass() {
            System.out.println("Constructor called!");
        }

    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();

        System.out.println("Auto destructor called.");
    }
}
