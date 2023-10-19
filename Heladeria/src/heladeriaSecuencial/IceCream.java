package heladeriaSecuencial;
import java.util.Random;
public class IceCream
{
    private String flavor;
    private double price;

    public IceCream(String flavor, double price)
    {
        this.flavor = flavor;
        this.price = price;
    }

    static IceCream iceCreamCreator()
    {
        // array of flavors
        String [] flavor = {"Naranja", "Sandia", "Melon", "Vainilla"};
        Random random = new Random();

        // create randomness for the ice creams
        int randomIndex = random.nextInt(flavor.length);
        String randomFlavor = flavor[randomIndex];

        // array of prices
        double [] prices = {1, 2, 2.5, 3};
        double randomPrice = prices [randomIndex];

        return new IceCream(randomFlavor, randomPrice);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
