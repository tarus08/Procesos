public class Chicken implements Runnable
{
    private String nameChicken;
    public Chicken (String name)
    {
        this.nameChicken = name;
    }

    @Override
    public void run () {
        for (int i = 0; i < 12; i++) {
            try {
                EggCup.addEgg(new Egg(nameChicken, (int) (Math.random() * 51 + 25)));
                Thread.sleep((long) (Math.random()*4000+1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setNameChicken(String nameChicken) {
        this.nameChicken = nameChicken;
    }
    public String getNameChicken()
    {
        return this.nameChicken;
    }
}
