package tietorakenteet;

import java.lang.reflect.Array;

/**
 *
 * @author hanranti
 */
public class Lista {

    private Solmu first, last;

    public Lista() {
    }

    public void add(Object object) {
        if (first == null) {
            first = new Solmu(object);
            last = first;
        } else {
            Solmu solmu = new Solmu(object);
            last.setOikea(solmu);
            last = solmu;
        }
    }

    public void remove(Object object) {
        Solmu s = first;
        while (s.getOikea() !=null) {
            System.out.println(s.getObject());
            s = s.getOikea();
        }
        if (first == null) {
            return;
        }
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject().equals(object)) {
                if (solmu.equals(first)) {
                    first = solmu.getOikea();
                }
                if (solmu.equals(last)) {
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
        s = first;
        while (s.getOikea() !=null) {
            System.out.println(s.getObject());
            s = s.getOikea();
        }
    }

    public boolean contains(Object object) {
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
