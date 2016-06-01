package tietorakenteet;

import java.lang.reflect.Array;

/**
 *
 * @author hanranti
 */
public class Lista<E extends Object> {

    private Solmu first, last;

    public Lista() {
    }

    public void add(E object) {
        if (first == null) {
            first = new Solmu(object);
            last = first;
        } else {
            Solmu solmu = new Solmu(object);
            last.setOikea(solmu);
            last = solmu;
        }
    }

    public void remove(E object) {
        if (first == null) {
            return;
        }
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject() == object) {
                if (solmu == first) {
                    first = solmu.getOikea();
                }
                if (solmu == last) {
                    last = solmu.getVasen();
                }
                if (solmu.getVasen() != null) {
                    solmu.getVasen().setOikea(solmu.getOikea());
                }
                if (solmu.getOikea() != null) {
                    solmu.getOikea().setVasen(solmu.getVasen());
                }
            }
            solmu = solmu.getOikea();
        }
    }

    public boolean contains(E object) {
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject() == object) {
                return true;
            }
            solmu = solmu.getOikea();
        }
        return false;
    }

    public Solmu getFirst() {
        return first;
    }

    public Solmu getLast() {
        return last;
    }
}
