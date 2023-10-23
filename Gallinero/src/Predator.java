public interface Predator
{
    void calculateWeight(int eggWeight);

    void eatEggMessage(Egg eatenEgg);

    String getPredatorName();

    int getPredatorWeight();
}
