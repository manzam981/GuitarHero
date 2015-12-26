import java.util.Random;

/**
 * Created by mantas on 15.12.8.
 */
public class Greitaveika {
    static int tiriamiDydziai[]= {10000000,20000000,40000000,80000000};
    static Buffer ring1 = new RingBuffer(tiriamiDydziai[0]);
    static double [] randomMasyvas(int dydis)
    {
        Random rand = new Random();
        double masyvas[]= new double[dydis];
        for(int i=0; i<dydis; i++)
        {
            double random = rand.nextDouble();
            masyvas[i]=random;
        }
        return masyvas;
    }
    static void tyrimas()
    {
        Timekeeper tk = new Timekeeper(tiriamiDydziai);
        for(int i:tiriamiDydziai)
        {
            double tyrimo[]=randomMasyvas(i);
            tk.start();
            for(double value:tyrimo)
            {
                ring1.enqueue(value);
            }
            tk.finish("Ring enqueue");
            tk.start();
            while(!ring1.isEmpty())
            {
                ring1.dequeue();
            }
            tk.finish("Ring dequeue");
            tk.seriesFinish();
        }
    }
    public static void main(String[] args) {
        tyrimas();
    }
}
