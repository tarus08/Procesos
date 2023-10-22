package heladeriaProfe;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
public class KidsT extends Thread {

    private String name;
    private final ReentrantLock lock = new ReentrantLock();
    public KidsT(String name) {
        this.name = name;
    }

    public KidsT() {
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (IceBoxT.getNumIceCreamEaten() < IceCreamManT.getTotalNumOfIceCream()) {
                lock.unlock();
                IceBoxT.getIceCream(name);
                try {
                    Thread.sleep((long) (Math.random() * 4000 + 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(IceCreamManT.class.getName()).log(Level.SEVERE, null, ex);
                }
                lock.lock();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Kid{ name:" + name + '}';
    }

}
