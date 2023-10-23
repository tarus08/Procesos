public class Pulard implements Runnable{
    private String namePulard;
    public Pulard(String name)
    {
        this.namePulard = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 12; i++) {
            try {
                EggCup.addEgg(new Egg(namePulard, (int) (Math.random() * 41 + 80)));
                Thread.sleep((long) (Math.random()*4000+1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setNamePulard(String namePulard) {
        this.namePulard = namePulard;
    }

    public String getNamePulard() {
        return namePulard;
    }
}
