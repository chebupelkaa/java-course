public class TwoThreads {
    private static final Object lock = new Object();
    private static boolean isOneTurn = true;

    public static void main(String[] args) throws InterruptedException {

        final Thread thread1 = createThread("1", false, "Thread1");
        final Thread thread2 = createThread("2", true, "Thread2");

        thread1.start();
        thread2.start();

        Thread.sleep(5000);

        thread1.interrupt();
        thread2.interrupt();

        thread1.join();
        thread2.join();
    }

    private static Thread createThread(final String message, final boolean waitCondition, final String threadName) {
        return new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (lock) {
                    try {
                        while (waitCondition == isOneTurn) {
                            lock.wait();
                        }
                        System.out.println(message);
                        isOneTurn = !isOneTurn;
                        lock.notifyAll();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }, threadName);
    }

}