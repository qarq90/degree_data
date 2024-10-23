package OOPConcepts;

public class FunctionOverloadingJava {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        FunctionOverloadingJava example = new FunctionOverloadingJava();

        System.out.println("Sum of 2 and 3: " + example.add(2, 3));
        System.out.println("Sum of 2, 3 and 4: " + example.add(2, 3, 4));
        System.out.println("Sum of 2.5 and 3.5: " + example.add(2.5, 3.5));
    }
}
