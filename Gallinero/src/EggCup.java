import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class EggCup {

    private static Stack<Egg> eggStack = new Stack<>();
    private static ReentrantLock lock = new ReentrantLock();
    public EggCup() {}
    public static void addEgg(Egg egg) {
        lock.lock();
        try {
            while (eggStack.size() >= 12) {
                try {
                    lock.unlock();
                    Thread.sleep(3000);
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


    public static void stealEgg(String name) {
        Egg eatenEgg;
        lock.lock();
        try
        {
            while (eggStack.isEmpty() && 200 > Vulture.getWeight())
            {
                try
                {
                    lock.unlock();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.lock();
                }
            }

            if (!eggStack.isEmpty()) {
                eatenEgg = eggStack.pop();

                if (name.contains("Vulture") && Vulture.getWeight() < 200) {
                    Vulture.calculateWeight(eatenEgg.getWeight());
                    System.out.println("I am " + name + " and I ate this egg: " + eatenEgg + ". Total weight: " + Vulture.getWeight() + ".\t Eggs left: " + eggStack.size());
                    if (Vulture.getWeight() >= 200) {
                        System.out.println(name + " is full. See ya!");
                    } else {
                        System.out.println(name + " is " + (200 - Vulture.getWeight()) + " from being full.");
                    }
                } else if (name.contains("Magpie")) {
                    System.out.println("I am " + name + " and I ate this egg: " + eatenEgg + ". See ya! \t Eggs left: " + eggStack.size());
                } else {
                    System.out.println("There are no predators available...");
                }
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

