public class Threads extends Thread {
    public static void main(String[] args) {
        Threads thread = new Threads();
        thread.start();
        for(int i = 0; i < 50; i++) {
            System.out.println("Outside: " + i);
        }
    }
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("Inside: " + i);
        }
    }
}
