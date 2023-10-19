package heladeriaProfe;

import java.util.logging.Level;
import java.util.logging.Logger;
public class KidsT extends Thread {

    private String name;

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

        while (true) {
            IceCreamT iceCreamT = IceBoxT.getIceCream(name);
            try {
                Thread.sleep((long) (Math.random() * 4000 + 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(IceCreamManT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "Kid{ name:" + name + '}';
    }

}
