public class Farmer
{
    private static final long MAX_RUNNING_TIME = 7000;
    public static void main(String[] args)
    {
        // the farmer sleeps for 7 seconds
        Thread farmerNap = new Thread(()->
        {
            try
            {
                Thread.sleep(MAX_RUNNING_TIME);
                System.out.println("I am the farmer, the program ends here.");
                System.exit(1);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }
        });

        farmerNap.start();

        // chicken
        for (int i = 0; i < 10; i++)
        {
            new Thread(new Chicken("Chicken " +i)).start();
        }

        // vulture
        for (int i = 0; i < 2; i++)
        {
            new Thread(new Vulture("Vulture " +i)).start();
        }

        // pulard
        for (int i = 0; i < 5; i++)
        {
            new Thread(new Pulard("Pulard " +i)).start();
        }

        // magpie
        for (int i = 0; i < 3; i++)
        {
            new Thread(new Magpie("Magpie " +i)).start();
        }
    }
}
