/**
 * IF-4/10 Interface skirtas gitaros veiksmams
 */
public interface Guitar {
    void pluck();                        // set the buffer to white noise
    void tic() ;                          // advance the simulation one time step
    double sample();                     // return the current sample
    int time();                       // return number of tics
    int size();
}
