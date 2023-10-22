public class Chicken implements Runnable
{
    private String nameChicken;
    public Chicken (String name)
    {
        this.nameChicken = name;
    }

    @Override
    public void run () {
        while (EggCup.getEggStack().size() < 12) {
            try {
                EggCup.addEgg(new Egg(nameChicken, (int) (Math.random() * 51 + 25)));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
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
