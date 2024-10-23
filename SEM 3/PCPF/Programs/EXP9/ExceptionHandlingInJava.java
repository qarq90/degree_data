package EXP9;

public class ExceptionHandlingInJava {

    public static double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        double num1 = 10.0, num2 = 0.0;

        try {
            double result = divide(num1, num2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
