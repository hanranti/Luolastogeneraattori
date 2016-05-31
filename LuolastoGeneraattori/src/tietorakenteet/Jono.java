package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class Jono<E extends Object> {

    private Object[] taulukko;
    private int alku, loppu, koko;

    public Jono() {
        taulukko = new Object[10];
        alku = 0;
        loppu = 0;
        koko = 0;
    }

    public void push(E object) {
        taulukko[loppu] = object;
        loppu++;
        if (loppu >= taulukko.length) {
            loppu = 0;
        }
        if (loppu == alku) {
            kasvataTaulukkoa();
        }
        koko++;
    }

    public E poll() {
        if (this.tyhja()) {
            return null;
        }
        Object object = taulukko[alku];
        alku++;
        koko--;
        return (E) object;
    }

    private void kasvataTaulukkoa() {
        Object[] uusiTaulukko = new Object[taulukko.length * 2];
        int i = 0;
        while (alku != loppu) {
            uusiTaulukko[i] = taulukko[alku];
            if (alku >= taulukko.length) {
                alku = 0;
            }
            alku++;
            i++;
        }
        alku = 0;
        loppu = koko;
    }

    public boolean tyhja() {
        if (alku == loppu) {
            return true;
        }
        return false;
    }

    public int koko() {
        return koko;
    }
}
