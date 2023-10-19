package heladeriaThreads;
import java.util.Random;

public class IceCreamThreads {
    private String randomFlavor;
    private double randomPrice;

    public IceCreamThreads(String randomFlavor, double randomPrice)
    {
        this.randomFlavor = randomFlavor;
        this.randomPrice = randomPrice;
    }

    static IceCreamThreads randomIceCreamCreator()
    {
        // array of flavors
        String[] flavor = {"Naranja", "Sandia", "Melon", "Vainilla"};
        Random random = new Random();

        // create randomness for the ice creams
        int randomIndex = random.nextInt(flavor.length);
        String randomFlavor = flavor[randomIndex];

        // array of prices
        double[] prices = {1, 2, 2.5, 3};
        double randomPrice = prices[randomIndex];

        return new IceCreamThreads(randomFlavor, randomPrice);
    }
    public String getRandomFlavor() {
        return randomFlavor;
    }
    public double getRandomPrice() {
        return randomPrice;
    }
}