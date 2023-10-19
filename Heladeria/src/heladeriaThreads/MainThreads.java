package heladeriaThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainThreads {
    private static final List<IceCreamThreads> iceCreamThreadsList = new ArrayList<>();
    private static final int[] randomNum = new int[5];
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int minimum = 30;
            int maximum = 50;
            randomNum[i] = (int) (Math.random() * (maximum - minimum) + minimum);
            System.out.println("Ice cream man " + i + " has to make " + randomNum[i] + " ice creams.");
        }
        List<Thread> threads = getThreads();
        for (Thread thread : threads)
        {
            thread.join();
        }
    }

    private static List<Thread> getThreads() {
        List<Thread> threads = new ArrayList<>();

        if (iceCreamThreadsList.size() < 25) {
            // Start ice cream man threads
            for (int i = 0; i < 5; i++) {
                Thread iceCreamManThread = new Thread(new IceCreamManThreads(iceCreamThreadsList, MainThreads.randomNum[i], i, lock));
                threads.add(iceCreamManThread);
                iceCreamManThread.start();
            }
        }

        // start kids threads
        for (int i = 0; i < 10; i++) {
            Thread kidsThread = new Thread(new KidThreads(iceCreamThreadsList, lock));
            threads.add(kidsThread);
            kidsThread.start();
        }
        return threads;
    }
}
