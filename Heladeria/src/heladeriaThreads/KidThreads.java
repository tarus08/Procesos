package heladeriaThreads;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class KidThreads implements Runnable {
    private final List<IceCreamThreads> iceCreamThreadsList;
    private final Lock lock;

    public KidThreads(List<IceCreamThreads> iceCreamThreadsList, Lock lock) {
        this.iceCreamThreadsList = iceCreamThreadsList;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true)
        {
            if (!iceCreamThreadsList.isEmpty()) {
                lock.lock();
                int index = iceCreamThreadsList.size() - 1;
                IceCreamThreads eatenIceCream = iceCreamThreadsList.get(index);
                iceCreamThreadsList.remove(index);
                System.out.println("Kid ate a " + eatenIceCream.getRandomFlavor() + " ice cream for " + eatenIceCream.getRandomPrice() + ".\nIce creams left in the icebox: " + iceCreamThreadsList.size());
                try {
                    // Sleep to simulate time passing before the next attempt to eat ice cream
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}


