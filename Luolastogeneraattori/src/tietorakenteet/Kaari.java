package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class Kaari {

    private Piste o1, o2;
    private int length;

    /**
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
     *
     * @return
     */
    public Piste getO1() {
        return o1;
    }

    /**
     *
     * @return
     */
    public Piste getO2() {
        return o2;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }
}
