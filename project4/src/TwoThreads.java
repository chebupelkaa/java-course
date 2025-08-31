public class TwoThreads {
    private static final Object lock = new Object();
    private static boolean isOneTurn = true;

    public static void main(String[] args) {

        final Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isOneTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.println("1");
                    isOneTurn = false;
                    lock.notifyAll();
                }
            }
        }, "Thread1");

        final Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isOneTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.println("2");
                    isOneTurn = true;
                    lock.notifyAll();
                }
            }
        }, "Thread2");

        thread1.start();
        thread2.start();
    }
}