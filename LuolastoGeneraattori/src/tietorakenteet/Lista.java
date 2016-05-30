package tietorakenteet;

import java.lang.reflect.Array;

/**
 *
 * @author hanranti
 */
public class Lista<E extends Object> {

    private Object[] taulukko;
    private int i;

    public Lista() {
        taulukko = new Object[10];
        i = 0;
    }

    public void add(E object) {
        if (i == taulukko.length) {
            kasvataTaulukkoa();
        }
        taulukko[i] = object;
        i++;
    }

    private void kasvataTaulukkoa() {
        Object[] uusiTaulukko = new Object[taulukko.length * 2];
        for (int j = 0; j < taulukko.length; j++) {
            uusiTaulukko[j] = taulukko[j];
        }
        taulukko = uusiTaulukko;
    }

}
