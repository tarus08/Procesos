package heladeriaSecuencial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class IceCreamMan implements IceCreamManInterface
{
    private final List<IceCream> iceCreamList = new ArrayList<>();
    @Override
    public void run() throws InterruptedException
    {
        // minimum of 30
        int minimum = 30;

        // maximum of 50
        int maximum = 50;

        for (int i = 1; i <= 5; i++)
        {
            // generate the random number of ice creams each ice cream man has to make
            int randomNum = (int) (Math.random() * (maximum - minimum) + minimum);
            System.out.println("----------------------------------------------------------");
            System.out.println("Ice cream man " + (i) + " has to make " + randomNum + " ice creams.");

            // create the ice creams
            Lock lock02 = new ReentrantLock();
            for (int j = 1; j <= randomNum; j++)
            {
                if (iceCreamList.size() < 25)
                {
                    iceCreamList.add(IceCream.iceCreamCreator());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Ice cream man " +i+ " has made " + j + " ice creams successfully.");
                    Thread.sleep(200);
                }
                else if (iceCreamList.size() == 25)
                {
                    Kid.kaliseParaTodos(iceCreamList);
                }
            }
            if (i == 5)
            {
                Kid.kaliseParaTodos(iceCreamList);
                System.out.println("This is the number of ice cream left: " +iceCreamList.size());
            }
        }
    }
}