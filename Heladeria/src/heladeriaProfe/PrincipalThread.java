package heladeriaProfe;

public class PrincipalThread {
    private static final long MAX_RUNNING_TIME = 21000; // 21 seconds to execute the whole program
    public static void main(String[] args) {

        // Start timer thread
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(MAX_RUNNING_TIME);
                System.out.println("\nProgram exceeded maximum running time. Aborting.");
                System.exit(1); // Abruptly exit the program
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        timerThread.start();

        // ice cream men
        for (int i = 0; i < 5; i++) {
            IceCreamManT h = new IceCreamManT(i + "");
            Thread t = new Thread(h);
            t.start();
        }

        // kids
        for (int i = 0; i < 10; i++) {
            KidsT n = new KidsT(i + "");
            Thread t = new Thread(n);
            t.start();
        }
    }
}
