package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class Solmu<E extends Object> {

    private Object object;
    private Solmu prev, next;

    public Solmu(E object) {
        this.object = object;
    }

    public void setPrev(Solmu prev) {
        this.prev = prev;
    }

    public void setNext(Solmu next) {
        this.next = next;
    }

    public Solmu getPrev() {
        return prev;
    }

    public Solmu getNext() {
        return next;
    }

    public Object getObject() {
        return object;
    }
}
