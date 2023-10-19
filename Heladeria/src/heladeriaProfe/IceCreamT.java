package heladeriaProfe;
public class IceCreamT {
    private String flavor;
    private double price;
    private enum flavorEnum {Orange, Strawberry, Chocolate, Oreo}

    public IceCreamT(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    public IceCreamT() {
        double randomPrice = Math.random() * 2.55 + 0.45;
        this.price = Double.parseDouble(String.format("%.2f", randomPrice));
        this.flavor = flavorEnum.values()[(int) (Math.random()*3)].toString();
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

    @Override
    public String toString() {
        return flavor + ", price: " + price ;
    }
}
