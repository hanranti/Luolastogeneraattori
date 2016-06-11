package tietorakenteet;

/**
 * Luokka kuvaa unionFind - tietorakennetta.
 *
 * @author hanranti
 */
public class UnionFind {

    private int[] taulukko;
    private int[] korkeus;
    private Object[] objects;
    private int i;
    private int komponentit;

    /**
     * Metodi luo UnionFind olion, johon voidaan lisätä olioita, yhdistää 
     * olioita toisiinsa polulla ja kysyä, mitkä oliot ovat yhteydessä toisiinsa
     * polulla.
     *
     */
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

    /**
     * Metodi lisää uuden olion ja komponentin tietorakenteeseen.
     *
     * @param object
     */
    public void makeSet(Object object) {
        if (i >= objects.length) {
            kasvataTaulukkoa();
        }
        objects[i] = object;
        i++;
        komponentit++;
    }

    /**
     * Metodi yhdistää kaksi oliota toisiinsa. Metodin kutsun jälkeen kaikkia
     * kumpaankin olioon yhteydessä olleita olioita kutsuttaessa find -metodilla
     * saadaan sama arvo.
     *
     * @param oA
     * @param oB
     */
    public void union(Object oA, Object oB) {
       int a = find(oA);
       int b = find(oB);
        if (a==-1||b==-1) {
            return;
        }
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

    /**
     * Metodi palauttaa arvon, joka kertoo mihin komponenttiin parametrin olio 
     * kuuluu. Jos unionFind ei sisällä oliota, metodi palauttaa -1.
     *
     * @param object
     * @return
     */
    public int find(Object object) {
        int k = -1;
        for (int j = 0; j < objects.length; j++) {
            if (objects[j] != null && object.equals(objects[j])) {
                k = find(j);
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
        System.out.println("unionFindKasvataTaulukkoa");
        for (int j = 0; j < objects.length; j++) {
            System.out.println(objects[j]);
        }
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
        System.out.println("/unionFindKasvataTaulukkoa");
        for (int j = 0; j < objects.length; j++) {
            System.out.println(objects[j]);
        }
    }

    /**
     * Metodi palauttaa komponenttien määrän tietorakenteessa.
     *
     * @return
     */
    public int getKomponentit() {
        return komponentit;
    }
}
