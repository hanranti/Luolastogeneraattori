package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class Keko {

    private int[] taulukko;
    private int size;

    public Keko() {
        taulukko = new int[8];
        size = 0;
    }

    public void insert(int k) {
        size++;
        if (size >= taulukko.length) {
            kasvataTaulukkoa();
        }
        int i = size;
        while (i > 1 && taulukko[i / 2] < k) {
            taulukko[i] = taulukko[i / 2];
            i /= 2;
        }
        taulukko[i] = k;
    }

    public Object juuri() {
        return taulukko[1];
    }

    public Object poistaJuuri() {
        int juuri = taulukko[1];
        taulukko[1] = taulukko[size];
        return juuri;
    }

    private void heapify(int i) {
        int l = 2 * i;
        int r = 2 * i + 1;
        if (r <= size) {
            int largest;
            if (taulukko[l] > (taulukko[r])) {
                largest = l;
            } else {
                largest = r;
            }
            if (taulukko[i] < (taulukko[largest])) {
                vaihda(i, largest);
                heapify(largest);
            }
        } else if (l == size && taulukko[i] < taulukko[l]) {
            vaihda(i, l);
        }
    }

    private void vaihda(int a, int b) {
        int arvo = taulukko[a];
        taulukko[a] = taulukko[b];
        taulukko[b] = arvo;
    }

    private void kasvataTaulukkoa() {
        int[] uusiTaulukko = new int[taulukko.length * 2];
        for (int i = 0; i < taulukko.length; i++) {
            uusiTaulukko[i] = taulukko[i];
        }
    }
}
