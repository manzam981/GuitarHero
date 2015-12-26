import java.util.Random;

/**
 * IF-4/10 Mantas Zambacevičius
 * Klasė skirta realizuoti gitaros veiksmams
 */
public class GuitarString implements Guitar {
    static final int SAMPLING_RATE=44_100;
    static final double ENERGY_DECAY_FACTOR=0.994;
    RingBuffer ring;
    int size;
    int ticks;
    GuitarString(double frequency)
    {
        int N = (int) (SAMPLING_RATE/frequency);
        ring = new RingBuffer(N);
        for(int i=0; i<N; i++)
        {
            ring.enqueue(0);
        }
        size=N;
        ticks=0;
    }
    GuitarString(double[] init)
    {
        ring = new RingBuffer(init.length);
        for(int i=0; i<init.length; i++)
        {
            ring.enqueue(init[i]);
        }
    }
    public int size()
    {
        return size;
    }
    public void pluck()
    {
        double start = -0.5;
        Random rand = new Random();
        for(int i=0; i<size; i++)
        {
            double result = start+rand.nextDouble();
            ring.enqueue(result);
        }
    }
    public void tic()
    {
        double temp = ring.dequeue();
        double temp2 = ring.peek();
        double newValue=(temp+temp2)/2*ENERGY_DECAY_FACTOR;
        ring.enqueue(newValue);
        ticks++;
    }
    public double sample()
    {
        return ring.peek();
    }
    public int time()
    {
        return ticks;
    }
    public String toString()
    {
        String reiksmes="";
        for(int i=0; i<ring.size; i++)
        {
            reiksmes+=ring.peek()+" ";
            ring.dequeue();
        }
        return reiksmes;
    }
}