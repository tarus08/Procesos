public class Egg
{
    private String name;
    private int weight;

    public Egg(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Egg (){}

   @Override
    public String toString() {
        return "Egg created by: " + name + ". Weighs: " + weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
