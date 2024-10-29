class EXP5ThreadEvenNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EXP5ThreadOddNumber extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 20; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class EXP5ThreadNumber {
    public static void main(String[] args) {
        EXP5ThreadEvenNumber evenThread = new EXP5ThreadEvenNumber();
        EXP5ThreadOddNumber oddThread = new EXP5ThreadOddNumber();

        evenThread.start();
        oddThread.start();

        System.out.println("Finished printing even and odd numbers.");
    }
}
