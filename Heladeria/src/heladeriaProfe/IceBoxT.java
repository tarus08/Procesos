package heladeriaProfe;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceBoxT {

    static Stack<IceCreamT> iceCreamStack = new Stack<IceCreamT>();
    static ReentrantLock lock = new ReentrantLock();
    private static int numIceCreamMade = 0;

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
        while (iceCreamStack.size() >= 25) {
            lock.unlock();
            try {
                Thread.sleep((long) (Math.random() * 3000 + 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(IceBoxT.class.getName()).log(Level.SEVERE, null, ex);
            }
            lock.lock();
        }
        iceCreamStack.push(iceCream);
        numIceCreamMade++;
        System.out.println("I am the ice cream man number " + name + " and I made this ice cream: " + iceCream.toString());
        lock.unlock();
    }

    public static IceCreamT getIceCream(String name) {
        lock.lock();
        while (iceCreamStack.empty()) {
            lock.unlock();
            try {
                Thread.sleep((long) (Math.random() * 3000 + 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(IceBoxT.class.getName()).log(Level.SEVERE, null, ex);
            }
            lock.lock();
        }
        IceCreamT iceCreamT = iceCreamStack.pop();
        System.out.println("I am the kid number " + name + " and I ate this ice cream " + iceCreamT.toString());
        lock.unlock();

        return iceCreamT;
    }

    public static void setNumIceCreamMade(int numIceCreamMade) {
        IceBoxT.numIceCreamMade = numIceCreamMade;
    }

    @Override
    public String toString() {
        return "Icebox:{" + '}';
    }

}
