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
     * @param o1 Kaaren ensimmainen Piste -olio
     * @param o2 Kaaren toinen Piste -olio
     * @param length Kaare paino
     */
    public Kaari(Piste o1, Piste o2, int length) {
        this.o1 = o1;
        this.o2 = o2;
        this.length = length;
    }

    /**
     * Metodi palauttaa toisen Kaaren paissa olevista pisteista.
     *
     * @return Palauttaa ensimmaisen Kaaren paissä olevista pisteista
     */
    public Piste getO1() {
        return o1;
    }

    /**
     * Metodi palauttaa toisen Kaaren paissa olevista pisteista.
     *
     * @return Palauttaa toisen Kaaren paissa olevista pisteista
     */
    public Piste getO2() {
        return o2;
    }

    /**
     * Metodi palauttaa Kaaren painon.
     *
     * @return Kaaren paino
     */
    public int getLength() {
        return length;
    }
}
