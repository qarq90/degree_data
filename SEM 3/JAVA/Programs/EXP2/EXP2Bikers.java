import java.util.Scanner;

public class EXP2Bikers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] speeds = new double[5];

        System.out.println("Enter the speeds of five bikers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Biker " + (i + 1) + " speed: ");
            speeds[i] = scanner.nextDouble();
        }

        double maxSpeed = speeds[0];
        for (int i = 1; i < speeds.length; i++) {
            if (speeds[i] > maxSpeed) {
                maxSpeed = speeds[i];
            }
        }

        System.out.println("The fastest biker's speed is: " + maxSpeed);
        scanner.close();
    }
}
