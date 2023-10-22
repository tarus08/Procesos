package heladeriaProfe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceCreamManT extends Thread {

    private String name;
    /*
        the numIceCreamToMake was static, which meant that this variable was shared
        across the code, if you got: 38,40,40,40,40; then you would have 2 numbers, not 5
     */
    private int numIceCreamToMake;
    // list to store the generated numbers
    private static final List<Integer> generatedNumbersList = new ArrayList<>();
    //lock to access the numbers
    private static ReentrantLock lock = new ReentrantLock();
    public IceCreamManT(String name) {
        this.name = name;
    }

    public IceCreamManT() {
    }

    @Override
    public void run() {

        numIceCreamToMake = (int) (Math.random() * 20 + 30);
        try
        {
            // access the number of ice creams to make
            lock.lock();
            // add the randomly generated number of ice creams to sum them
            generatedNumbersList.add(numIceCreamToMake);
            System.out.println("I am the ice cream man number "+ name +" and I will make "+ numIceCreamToMake + " ice creams.");
        }
        finally
        {
            lock.unlock();
        }
        for (int i = 0; i < numIceCreamToMake; i++)
        {
            try {
                IceCreamT iceCreamT = new IceCreamT();
                IceBoxT.addIceCream(iceCreamT, name);
                Thread.sleep((long) (Math.random()*4000+1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(IceCreamManT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static int getTotalNumOfIceCream()
    {
        int total = 0;
        try
        {
            lock.lock();
            for (Integer sum : generatedNumbersList)
            {
                total += sum;
            }
        }
        finally
        {
            lock.unlock();
        }
        return total;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public int getNumIceCreamToMake() {
        return numIceCreamToMake;
    }

    public void setNumIceCreamToMake(int numIceCreamToMake) {
        this.numIceCreamToMake = numIceCreamToMake;
    }

    @Override
    public String toString() {
        return "Ice cream man{" + name + '}';
    }
}
