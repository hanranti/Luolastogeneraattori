package tietorakenteet;

/**
 *
 * @author hanranti
 */
public class UnionFind {

    private int[] taulukko;
    private int[] korkeus;
    private Object[] objects;
    private int i;
    private int komponentit;

    public UnionFind() {
        int n = 10;
        taulukko = new int[n + 1];
        korkeus = new int[n + 1];
        objects = new Object[n + 1];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = i;
            korkeus[i] = 1;
        }
        i = 0;
        komponentit = 0;
    }

    public void makeSet(Object object) {
        if (i >= objects.length) {
            kasvataTaulukkoa();
        }
        objects[i] = object;
        i++;
        komponentit++;
    }

    public void union(int a, int b) {
        if (objects[a] == null || objects[b] == null) {
            return;
        }
        a = find(a);
        b = find(b);
        if (korkeus[a] < korkeus[b]) {
            taulukko[a] = b;
        } else if (korkeus[a] > korkeus[b]) {
            taulukko[b] = a;
        } else {
            taulukko[a] = b;
            korkeus[b] = korkeus[a] + 1;
        }
        komponentit--;
    }

    public int find(Object object) {
        int k = -1;
        for (int j = 0; j < objects.length; j++) {
            if (objects[j].equals(object)) {
                k = find(k);
            }
        }
        return k;
    }

    private int find(int b) {
        int y = b;
        while (taulukko[y] != y) {
            y = taulukko[y];
        }
        return y;
    }

    private void kasvataTaulukkoa() {
        Object[] uusiObjects = new Object[2 * objects.length];
        int[] uusiTaulukko = new int[2 * taulukko.length];
        int[] uusiKorkeus = new int[2 * korkeus.length];
        for (int j = 0; j < objects.length; j++) {
            uusiObjects[j] = objects[j];
            uusiTaulukko[j] = taulukko[j];
            uusiKorkeus[j] = korkeus[j];
        }
        objects = uusiObjects;
        taulukko = uusiTaulukko;
        korkeus = uusiKorkeus;
    }

    public int getKomponentit() {
        return komponentit;
    }
}
