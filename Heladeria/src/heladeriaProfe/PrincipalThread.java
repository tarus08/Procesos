package heladeriaProfe;
public class PrincipalThread {
    public static void main(String[] args)
    {
        // ice cream men
        for (int i = 0; i < 5; i++)
        {
            IceCreamManT h = new IceCreamManT(i + "");
            Thread t = new Thread(h);
            t.start();
        }
        // kids
        for (int i = 0; i < 10; i++)
        {
            KidsT n = new KidsT(i + "");
            Thread t = new Thread(n);
            t.start();
        }
        System.out.println("\nI am the main thread, and I died -.-");
    }
}
