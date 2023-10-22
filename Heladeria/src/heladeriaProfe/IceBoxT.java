package heladeriaProfe;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceBoxT {

    static Stack<IceCreamT> iceCreamStack = new Stack<IceCreamT>();
    static ReentrantLock lock = new ReentrantLock();
    private static int numIceCreamMade = 0;
    private static int numIceCreamEaten = 0;

    public IceBoxT() {
    }

    public static Stack<IceCreamT> getIceCreamStack() {
        return iceCreamStack;
    }

    public static void setIceCreamStack(Stack<IceCreamT> iceCreamStack) {
        IceBoxT.iceCreamStack = iceCreamStack;
    }

    public static void addIceCream(IceCreamT iceCream, String name) {
        lock.lock();
        try {
            while (iceCreamStack.size() >= 25) {
                try {
                    lock.unlock();
                    Thread.sleep((long) (Math.random() * 3000 + 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(IceBoxT.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    lock.lock();
                }
            }

            iceCreamStack.push(iceCream);
            numIceCreamMade++;
            System.out.println("I am the ice cream man number " + name + " and I made this ice cream: " + iceCream.toString());
            System.out.println("This is the number of ice creams to be made: " + IceCreamManT.getTotalNumOfIceCream() +
                    ". Currently made: " + numIceCreamMade + ". Currently eaten: " +numIceCreamEaten+ ". Size of the icebox: " + iceCreamStack.size());
        } finally {
            lock.unlock();
        }
    }

    public static void getIceCream(String name) {
        lock.lock();
        try {
            while (iceCreamStack.isEmpty() && IceCreamManT.getTotalNumOfIceCream() > numIceCreamEaten)
            {
                try {
                    lock.unlock();
                    Thread.sleep((long) (Math.random() * 3000 + 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(IceBoxT.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    lock.lock();
                }
            }

            if (!iceCreamStack.isEmpty()) {
                IceCreamT iceCreamT = iceCreamStack.pop();
                System.out.println("I am the kid number " + name + " and I ate a/an " + iceCreamT.toString());
                numIceCreamEaten++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void setNumIceCreamMade(int numIceCreamMade) {
        IceBoxT.numIceCreamMade = numIceCreamMade;
    }

    public static int getNumIceCreamMade() {
        return numIceCreamMade;
    }

    public static int getNumIceCreamEaten()
    {
        return numIceCreamEaten;
    }

    @Override
    public String toString() {
        return "Icebox:{" + '}';
    }
}
