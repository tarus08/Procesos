package heladeriaThreads;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class IceCreamManThreads implements Runnable {
    private final List<IceCreamThreads> iceCreamThreadsList;
    private final int randomNum;
    private final int iceCreamManNum;
    private final Lock lock;

    public IceCreamManThreads(List<IceCreamThreads> iceCreamThreadsList, int randomNum, int iceCreamManNum, Lock lock) {
        this.iceCreamThreadsList = iceCreamThreadsList;
        this.randomNum = randomNum;
        this.iceCreamManNum = iceCreamManNum;
        this.lock = lock;
    }
    @Override
    public void run() {
        for (int j = 1; j <= randomNum; j++) {
            lock.lock();
            try {
                if (iceCreamThreadsList.size() < 25)
                {
                    iceCreamThreadsList.add(IceCreamThreads.randomIceCreamCreator());
                    System.out.println("Ice cream man " + iceCreamManNum + " has made " + j + " ice creams successfully. \nIce creams left in the icebox: " + iceCreamThreadsList.size());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
