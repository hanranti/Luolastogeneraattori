package tietorakenteet;

/**
 * Luokka kuvaa kaarta Pisteistä koostuvassa verkossa.
 *
 * @author hanranti
 */
public class Kaari {

    private final Piste o1, o2;
    private final int length;

    /**
     * Metodi luo Kaari -olion asettaen tälle Pisteiksi parametreina saadut 
     * Pisteet ja asettaen Kaaren painoksi parametrina saadun int arvon.
     *
     * @param o1
     * @param o2
     * @param length
     */
    public Kaari(Piste o1, Piste o2, int length) {
        this.o1 = o1;
        this.o2 = o2;
        this.length = length;
    }

    /**
     * Metodi palauttaa toisen Kaaren päissä olevista pisteistä.
     *
     * @return
     */
    public Piste getO1() {
        return o1;
    }

    /**
     * Metodi palauttaa toisen Kaaren päissä olevista pisteistä.
     *
     * @return
     */
    public Piste getO2() {
        return o2;
    }

    /**
     * Metodi palauttaa Kaaren painon.
     *
     * @return
     */
    public int getLength() {
        return length;
    }
}
