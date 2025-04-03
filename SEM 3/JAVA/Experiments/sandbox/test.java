class test implements Runnable {
    public void run() {
        System.out.println("Thread started");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable());
        t.start();
    }
}