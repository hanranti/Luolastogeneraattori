package tietorakenteet;

/**
 * Keko -luokka kuvaa keko -tietorakennetta.
 *
 * @author hanranti
 */
public class Keko {

    private int[] taulukko;
    private Object[] objects;
    private int size;

    /**
     * Metodi luo keko -olion, johon voidaan lisätä olioita antaen oliolle arvon
     * ja poistaa aina suurimman arvon saanut olio keosta.
     *
     */
    public Keko() {
        taulukko = new int[8];
        objects = new Object[8];
        size = 0;
    }

    /**
     * Metodi lisää kekoon olion ja tälle arvon. Jos olioiden määrä kasvaa yli
     * taulukon koon, taulukon kokoa kasvatetaan kasvataTaulukkoa -metodilla.
     *
     * @param object
     * @param k
     */
    public void insert(Object object, int k) {
        size++;
        if (size >= taulukko.length - 1) {
            kasvataTaulukkoa();
        }
        int i = size;
        while (i > 1 && taulukko[i / 2] < k) {
            taulukko[i] = taulukko[i / 2];
            objects[i] = objects[i / 2];
            i /= 2;
        }
        taulukko[i] = k;
        objects[i] = object;
    }

    /**
     * Metodi palauttaa olion, jonka saama arvo on suurin keossa.
     *
     * @return
     */
    public Object juuri() {
        return objects[1];
    }

    /**
     * Metodi poistaa suurimman arvon saaneen olion keosta, järjestää keon
     * uudelleen heapify -metodilla ja palauttaa entisen suurimman arvon saaneen
     * olion.
     *
     * @return
     */
    public Object poistaJuuri() {
        Object juuri = objects[1];
        taulukko[1] = taulukko[size];
        objects[1] = objects[size];
        heapify(1);
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
        Object object = objects[a];
        taulukko[a] = taulukko[b];
        taulukko[b] = arvo;
        objects[a] = objects[b];
        objects[b] = object;
    }

    private void kasvataTaulukkoa() {
        for (int i = 0; i < taulukko.length; i++) {
            System.out.println(objects[i] + " " + taulukko[i]);
        }
        int[] uusiTaulukko = new int[taulukko.length * 2];
        Object[] uusiObjects = new Object[taulukko.length * 2];
        for (int i = 0; i < taulukko.length; i++) {
            uusiTaulukko[i] = taulukko[i];
            uusiObjects[i] = objects[i];
        }
        taulukko = uusiTaulukko;
        objects = uusiObjects;
        for (int i = 0; i < taulukko.length; i++) {
            System.out.println(objects[i] + " " + taulukko[i]);
        }
    }
}
