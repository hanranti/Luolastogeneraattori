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
     * @param object Olio, joka lisataan komponenttina unionFindiin
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
     * @param oA Olio, joka yhdistetaan toiseen parametrina saatuun olioon
     * @param oB Olio, joka yhdistetaan toiseen parametrina saatuun olioon
     */
    public void union(Object oA, Object oB) {
        int a = find(oA);
        int b = find(oB);
        if (a == -1 || b == -1) {
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
     * @param object Olio, jonka find -arvo etsitaan unionFindista
     * @return Parametrina annetun olion find -arvo
     */
    public int find(Object object) {
        int k = -1;
        if (object ==null) {
            return k;
        }
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

    /**
     * Metodi palauttaa false, jos parametrina saatujen olioiden find arvo on
     * eri tai jompikumpi olioista on null, muulloin true.
     *
     * @param o1 Olio, jonka find arvoa verrataan toisen parametrina saadun olion
     * find arvoon
     * @param o2 Olio, jonka find arvoa verrataan toisen parametrina saadun olion
     * find arvoon
     * @return Jos parametrina saatujen olioiden find arvot eivat ole samat tai
     * jompikumpi olioista on null, palautetaan false, muulloin true
     */
    public boolean sama(Object o1, Object o2) {
        if (o1==null|| o2==null) {
            return false;
        }
        if (find(o1)==find(o2)) {
            return true;
        }
        return false;
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
        for (int j = taulukko.length; j < uusiTaulukko.length; j++) {
            uusiTaulukko[j] = j;
            uusiKorkeus[j] = 1;
        }
        objects = uusiObjects;
        taulukko = uusiTaulukko;
        korkeus = uusiKorkeus;
    }

    /**
     * Metodi palauttaa komponenttien maaran tietorakenteessa.
     *
     * @return Palauttaa komponenttien maaran unionFindissa
     */
    public int getKomponentit() {
        return komponentit;
    }
}
