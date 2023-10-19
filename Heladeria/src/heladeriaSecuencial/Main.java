package heladeriaSecuencial;
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        IceCreamMan ice = new IceCreamMan();
        // el run es para hacerlo secuencial, queremos usar el start, para hacer varios hilos.
        // el programa accede a un sitio, se pone la gorra de heladero y la de niño segun convenga
        ice.run();
    }
}
