import java.util.concurrent.locks.ReentrantLock;

public class Magpie implements Runnable {
    private String magpieName;
    private static ReentrantLock consumerLock = new ReentrantLock();
    public Magpie(String name) {
        this.magpieName = name;
    }

    @Override
    public void run() {
        try {
            consumerLock.lock();
            if (!EggCup.getEggStack().isEmpty()) {
                consumerLock.unlock();
                EggCup.stealEgg(magpieName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setMagpieName(String magpieName) {
        this.magpieName = magpieName;
    }

    public String getMagpieName() {
        return magpieName;
    }
}
