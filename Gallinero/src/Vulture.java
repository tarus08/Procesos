import java.util.concurrent.locks.ReentrantLock;

public class Vulture implements Runnable, Predator{
    private String vultureName;
    private int vultureWeight;
    private static final ReentrantLock consumerLock = new ReentrantLock();
    private static final int MAX_WEIGHT = 200;

    public Vulture(String vultureName) {
        this.vultureName = vultureName;
        this.vultureWeight = 0;
    }

    @Override
    public void run() {
        try {
            consumerLock.lock();
            System.out.println(getPredatorName() + " is starting to steal.");
            while (getPredatorWeight() < MAX_WEIGHT) {
                EggCup.stealEgg(this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            consumerLock.unlock();
        }
    }

    @Override
    public String getPredatorName() {
        return vultureName;
    }

    @Override
    public int getPredatorWeight() {
        return vultureWeight;
    }

    @Override
    public void calculateWeight(int eggWeight) {
        int newWeight = getPredatorWeight() + eggWeight;
        if (newWeight <= MAX_WEIGHT) {
            vultureWeight = newWeight;
            System.out.println("Total weight: " + newWeight + ". " +getPredatorName() + " is " + (MAX_WEIGHT - newWeight) + " from being full.");
        } else {
            setVultureWeight(MAX_WEIGHT);
            System.out.println(getPredatorName() + " is full. See ya!");
        }
    }

    @Override
    public void eatEggMessage(Egg eatenEgg) {
        System.out.println("I am " + getPredatorName() + " and I ate this egg: " + eatenEgg +
                ".\t Eggs left: " + EggCup.getEggStack().size());
    }

    public void setVultureWeight(int vultureWeight) {
        this.vultureWeight = vultureWeight;
    }
}