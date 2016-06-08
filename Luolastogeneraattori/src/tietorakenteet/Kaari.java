package tietorakenteet;

import luolasto.Piste;

/**
 *
 * @author hanranti
 */
public class Kaari {

    private Piste o1, o2;
    private int length;

    public Kaari(Piste o1, Piste o2, int length) {
        this.o1 = o1;
        this.o2 = o2;
        this.length = length;
    }

    public Piste getO1() {
        return o1;
    }

    public Piste getO2() {
        return o2;
    }

    public int getLength() {
        return length;
    }
}
