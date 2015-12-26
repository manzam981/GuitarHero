/**
 * IF-4/10 Mantas Zambacevičius
 * Klasė skirta testavimui
 */
public class GuitarStringTest {
    static double [] dazniai =  {2000,1500,1000};
    static Guitar test = new GuitarString(dazniai[0]);
    static Guitar test2 = new GuitarString(dazniai[1]);
    static Guitar test3 = new GuitarString(dazniai[2]);
    public static void main(String[] args) {
        test.pluck();
        Ks.oun(test.toString());
        Ks.oun("Buferio dydis esant auksciausiam dazniui "+test.size());
        test2.pluck();
        Ks.oun(test2.toString());
        Ks.oun("Buferio dydis esant vidutiniam dazniui "+test2.size());
        test3.pluck();
        Ks.oun(test3.toString());
        Ks.oun("Buferio dydis esant maziausiam dazniui "+test3.size());
    }
}
