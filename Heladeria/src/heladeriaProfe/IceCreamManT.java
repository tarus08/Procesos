package heladeriaProfe;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IceCreamManT extends Thread {

    private String name;
    public static int iceCreamToMake;
    public IceCreamManT(String name) {
        this.name = name;
    }

    public IceCreamManT() {
    }

    @Override
    public void run() {
        iceCreamToMake = (int) (Math.random() * 20 + 30);
        System.out.println("I am the ice cream man number "+ name +" and I will make "+iceCreamToMake+ " ice creams.");
        for (int i = 0; i < iceCreamToMake; i++) {
            try {
                IceCreamT iceCreamT = new IceCreamT();
                IceBoxT.addIceCream(iceCreamT, name);
                Thread.sleep((long) (Math.random()*4000+1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(IceCreamManT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("I am the ice cream man number "+ name +" and I died -.-");
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public static int getIceCreamToMake() {
        return iceCreamToMake;
    }

    public static void setIceCreamToMake(int iceCreamToMake) {
        IceCreamManT.iceCreamToMake = iceCreamToMake;
    }

    @Override
    public String toString() {
        return "Ice cream man{" + name + '}';
    }
}
