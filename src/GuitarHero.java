import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * IF-4/10 pagrindinė klasė skirta garso paleidimui bei atvaizdavimui
 */
public class GuitarHero {
    Guitar test = new GuitarString(150);
    int t=0; // time
    static final int xAxis=5000;
    static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    static Guitar notes[] = new Guitar[keyboard.length()];
    void mainProgram()
    {
        StdDraw.setCanvasSize(1000,500);
        StdDraw.setYscale(-0.7, 0.7);
        StdDraw.setXscale(0,xAxis);
        StdDraw.show(0);
        int recently=0;
        createGuitarStringArray();
        while(true)
        {
            if(StdDraw.hasNextKeyTyped())
            {
                char key = StdDraw.nextKeyTyped();
                int ind = keyboard.indexOf(key);
                if(ind!=-1)
                {
                    notes[ind].pluck();
                    recently=ind;
                }
            }
            double sampleSum=0;
            for(int i=0; i<keyboard.length();i++)
            {
                sampleSum=notes[i].sample();
            }
            notes[recently].tic();
            sampleSum+=notes[recently].sample();
            StdDraw.point(t,sampleSum);
            t++;
            test.tic();
            if(t>=xAxis)
            {
                StdDraw.show(0);
                StdDraw.clear();
                t = 0;
            }
            StdAudio.play(sampleSum);
        }
    }
    void createGuitarStringArray()
    {
        int defaultFrequency = 440;
        double base=1.05956;
        for(int i=0; i<keyboard.length();i++)
        {
            double exponent = i-24;
            double frequency=defaultFrequency*Math.pow(base,exponent);
            notes[i]=new GuitarString(frequency);
        }
    }
    public static void main(String[] args) {
        new GuitarHero().mainProgram();
    }
}
