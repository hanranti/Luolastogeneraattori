package tietorakenteet;

/**
 * Luokka sisältää metodeja, jotka palauttavat vastauksia matemaattisiin 
 * ongelmiin.
 *
 * @author hanranti
 */
public class Matematiikka {

    /**
     * Metodi palauttaa hypotenuusan pituuden kolmiosta, jossa kateettien
     * pituudet ovat parametrit a ja b.
     *
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuusanPituus(int a, int b) {
        int c = a * a + b * b;
        return Math.sqrt(c);
    }
}
