package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class Solmu<E extends Object> {

    private Object object;
    private Solmu vasen, oikea;

    public Solmu(E object) {
        this.object = object;
    }

    public void setVasen(Solmu prev) {
        this.vasen = prev;
    }

    public void setOikea(Solmu next) {
        this.oikea = next;
    }

    public Solmu getVasen() {
        return vasen;
    }

    public Solmu getOikea() {
        return oikea;
    }

    public Object getObject() {
        return object;
    }
}
