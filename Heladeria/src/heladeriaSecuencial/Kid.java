package heladeriaSecuencial;

import heladeriaThreads.IceCreamThreads;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Kid
{
    public static void kaliseParaTodos(List<IceCream> iceBox) throws InterruptedException
    {
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= iceBox.size(); j++)
            {
                int index = iceBox.size() - 1;
                // we need this to call the values of the ice cream that is going to be deleted
                IceCream eatenIceCream = iceBox.get(index);
                iceBox.remove(index);
                System.out.println("Kid "+i+ " ate a " +eatenIceCream.getFlavor()+ " ice cream for " +eatenIceCream.getPrice()+ " ("+j+")");
            }
            Thread.sleep(200);
        }
    }
}

