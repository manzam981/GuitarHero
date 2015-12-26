/**
 * IF-4/10 Mantas Zambacevičius
 * Klasė skirta realizuoti žiedinį sąrašą
 */
public class RingBuffer implements Buffer {
    int size;
    int capacity;
    int first;
    int last;
    double values[];
    RingBuffer(int capacity)
    {
        values = new double[capacity];
        size=0;
        this.capacity=capacity;
        first=0;
        last=0;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public boolean isFull()
    {
        return size==capacity;
    }

    public void enqueue(double x)
    {
        values[last]=x;
        last++;
        if(last==capacity)
        {
            last=0;
        }
        if(size!=capacity)
        {
            size++;
        }
        else
        {
        }
    }
    private double[] remove(double arr[], int pos)
    {
        double newArr[] = new double[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            if(pos!=i)
            {
                newArr[i]=arr[i];
            }
        }
        return newArr;
    }
    public double dequeue()
    {
        if(isEmpty())
            throw new RuntimeException();
        double fVal = values[first];
        values = remove(values,first);
        if(first==values.length-1)
        {
            first=0;
        }
        else
        {
            first++;
        }
        size--;
        return fVal;
    }
    public double peek()
    {
        if(isEmpty())
            throw new RuntimeException();
        return values[first];
    }
    @Override
    public String toString()
    {
        String reiksmes="";
        for(int i=0; i<values.length; i++)
        {
            reiksmes+=Double.toString(values[i])+" ";
        }
        return reiksmes;
    }
}
