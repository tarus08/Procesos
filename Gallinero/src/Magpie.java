import java.util.concurrent.locks.ReentrantLock;

public class Magpie implements Runnable, Predator {
    private String magpieName;
    private static final ReentrantLock lock = new ReentrantLock();
    private boolean hasEaten;

    public Magpie(String magpieName) {
        this.magpieName = magpieName;
        this.hasEaten = false;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (!hasEaten && !EggCup.getEggStack().isEmpty()) {
                EggCup.stealEgg(this);
                hasEaten = true;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getPredatorName() {
        return magpieName;
    }

    @Override
    public int getPredatorWeight() {
        return 0;
    }

    @Override
    public void calculateWeight(int eggWeight) {
        // Magpie doesn't track its weight, so no need to do anything here
    }

    @Override
    public void eatEggMessage(Egg eatenEgg) {
        System.out.println("I am " + getPredatorName() + " and I ate this egg: " + eatenEgg +
                ". See ya!\t Eggs left: " + EggCup.getEggStack().size());
    }
}

