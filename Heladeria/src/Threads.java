import java.util.concurrent.locks.ReentrantLock;

public class Threads extends Thread {

    static int counter01 = 0;
    static int counter02 = 0;
    String name;
    ReentrantLock lock01;
    ReentrantLock lock02;
    public Threads(String name, ReentrantLock lock01, ReentrantLock lock02)
    {
        this.name = name;
        this.lock01 = lock01;
        this.lock02 = lock02;
    }
    public static void main(String[] args)  {

        ReentrantLock lock01 = new ReentrantLock();
        ReentrantLock lock02 = new ReentrantLock();

        for(int i=0;i<100;i++)
        {
            Threads t;
            if (i%2 == 0)
            {
                t = new Threads("SUM", lock01, lock02);
            }
            else
            {
                t = new Threads("SUBSTRACT", lock01, lock02);
            }
            t.start();
        }
        System.out.println("PRINCIPAL THREAD FINISHED");
    }
    public void run()
    {
        if(this.name.equals("SUM"))
        {
            lock01.lock();
            Threads.counter01++;
            lock01.unlock();
            counter02++;
        }
        else if (this.name.equals("SUBSTRACT"))
        {
            lock02.lock();
            Threads.counter01--;
            lock02.unlock();
            counter02++;
        }
        System.out.println(this.name +". Value:"+Threads.counter01+".");
        System.out.println(counter02);
    }
}
