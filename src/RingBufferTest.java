/**
 * IF-4/10 Mantas Zambacevičius
 * Klasė skirta žiedinio sarašo testavimui
 */
public class RingBufferTest {
    static Buffer test = new RingBuffer(3);
    static void testavimas()
    {
        test.enqueue(1.9);
        test.dequeue();
        test.enqueue(0.3);
        test.enqueue(0.9);
        test.enqueue(0.3);
        Ks.oun(test.toString());
        test.enqueue(0.3);
        test.dequeue();
        test.enqueue(1.9);
        test.enqueue(0.9);
        test.dequeue();
        test.dequeue();
        Ks.oun(test.toString());
        Ks.oun("Spausdinamas veliausiai idetas elementas: "+test.peek());
    }
    public static void main(String[] args) {
        testavimas();
    }
}
