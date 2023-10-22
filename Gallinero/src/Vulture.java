import java.util.concurrent.locks.ReentrantLock;

public class Vulture implements Runnable{
    private static String vultureName;
    private static int vultureWeight;
    private static ReentrantLock consumerLock = new ReentrantLock();

    public Vulture(String vultureName, int vultureWeight) {
        Vulture.vultureName = vultureName;
        Vulture.vultureWeight = vultureWeight;
    }

    public static void calculateWeight(int eggWeight)
    {
        try
        {
            consumerLock.lock();
            vultureWeight += eggWeight;
        } finally {
            consumerLock.unlock();
        }
    }

    @Override
    public void run() {
        try
        {
            consumerLock.lock();
            while (getWeight() < 200)
            {
                consumerLock.unlock();
                EggCup.stealEgg(vultureName);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
                consumerLock.lock();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            consumerLock.unlock();
        }
    }

    public static int getWeight() {
        return vultureWeight;
    }

    public static void setVultureWeight(int vultureWeight) {
        Vulture.vultureWeight = vultureWeight;
    }

    public String getVultureName() {
        return vultureName;
    }
    public static void setVultureName (String vultureName) {
        Vulture.vultureName = vultureName;
    }
}
