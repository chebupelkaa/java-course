import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    private static final int MAX_ATTEMPTS = 20;
    private static ReentrantLock lock1;
    private static ReentrantLock lock2;

    public static void main(String[] args) {
        lock1 = new ReentrantLock();
        lock2 = new ReentrantLock();

        new Thread(() -> work("Worker1", lock1, lock2)).start();
        new Thread(() -> work("Worker2", lock2, lock1)).start();
    }

    private static void work(final String name, final ReentrantLock first, final ReentrantLock second) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            if (first.tryLock()) {
                System.out.println(name + ": acquired " + getLockName(first));
                try {
                    Thread.sleep(50);
                    if (second.tryLock()) {
                        System.out.println(name + ": acquired " + getLockName(second));
                        try {
                            System.out.println(name + ": working with both");
                            Thread.sleep(100);
                            return;
                        } finally {
                            second.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    return;
                } finally {
                    first.unlock();
                }
            }

        }
    }

    private static String getLockName(final ReentrantLock lock) {
        if (lock == lock1) return "Lock1";
        if (lock == lock2) return "Lock2";
        return "UnknownLock";
    }
}