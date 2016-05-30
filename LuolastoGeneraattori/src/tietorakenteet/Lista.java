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
            last.setNext(solmu);
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
                    first = solmu.getNext();
                }
                if (solmu == last) {
                    last = solmu.getPrev();
                }
                if (solmu.getPrev() != null) {
                    solmu.getPrev().setNext(solmu.getNext());
                }
                if (solmu.getNext() != null) {
                    solmu.getNext().setPrev(solmu.getPrev());
                }
            }
            solmu = solmu.getNext();
        }
    }

    public boolean contains(E object) {
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject() == object) {
                return true;
            }
            solmu = solmu.getNext();
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
