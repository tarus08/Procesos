import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
public class EggCup {
    private static Stack<Egg> eggStack = new Stack<>();
    private static ReentrantLock lock = new ReentrantLock();
    private static final int MAX_EGGS = 12;
    private static final int MAX_WEIGHT = 200;

    public EggCup() {}
    public static void addEgg(Egg egg) {
        lock.lock();
        try {
            while (eggStack.size() >= MAX_EGGS) {
                try {
                    lock.unlock();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.lock();
                }
            }
                eggStack.push(egg);
                System.out.println(egg + ".\t Egg number: " + eggStack.size());
        } finally {
            lock.unlock();
        }
    }

    public static void stealEgg(Predator predator) {
        Egg eatenEgg;
        lock.lock();
        try {
            while (eggStack.isEmpty() && MAX_WEIGHT > predator.getPredatorWeight()) {
                try {
                    lock.unlock();
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    lock.lock();
                }
            }

            if (!eggStack.isEmpty()) {
                eatenEgg = eggStack.pop();
                predator.eatEggMessage(eatenEgg);
                predator.calculateWeight(eatenEgg.getWeight());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
    public void setEggStack(Stack<Egg> eggStack) {
        EggCup.eggStack = eggStack;
    }

    public static Stack<Egg> getEggStack() {
        return eggStack;
    }

}

