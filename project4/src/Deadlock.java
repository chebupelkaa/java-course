public class Deadlock {
    public static void main(String[] args) {

        final Object lock1 = new Object() {
            public String toString() {
                return "Lock1";
            }
        };

        final Object lock2 = new Object() {
            public String toString() {
                return "Lock2";
            }
        };

        final long delayMs = 1000;

        final Thread thread1 = new Thread(() -> {
            performLockingOperation("Thread1", lock1, lock2, delayMs);
        }, "Thread1");

        final Thread thread2 = new Thread(() -> {
            performLockingOperation("Thread2", lock2, lock1, delayMs);
        }, "Thread2");

        thread1.start();
        thread2.start();

        checkForDeadlock(thread1, thread2);
    }

    private static void performLockingOperation(final String threadName, final Object lock1,
                                                final Object lock2, final long delay) {
        System.out.println(threadName + " start");
        synchronized (lock1) {
            System.out.println(threadName + " acquired " + lock1.toString());
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            synchronized (lock2) {
                System.out.println(threadName + " acquired " + lock2.toString());
            }
        }
        System.out.println(threadName + " end");
    }

    private static void checkForDeadlock(final Thread thread1, final Thread thread2) {
        try {
            thread1.join(3000);
            thread2.join(3000);

            if (thread1.isAlive() || thread2.isAlive()) {
                System.out.println("\nDeadlock detected");
                System.out.println("Thread1 state: " + thread1.getState());
                System.out.println("Thread2 state: " + thread2.getState());
            } else {
                System.out.println("\nThreads completed successfully");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}