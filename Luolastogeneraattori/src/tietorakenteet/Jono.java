package tietorakenteet;

/**
 * Jono -luokka kuvaa jono -tietorakennetta, jossa jonon loppuun voidaan lisätä
 * olioita ja jonon alusta voidaan poistaa olioita.
 *
 * @author hanranti
 */
public class Jono {

    private Object[] taulukko;
    private int alku, loppu, koko;

    /**
     * Metodi luo jono -olion. Jono sisältää taulukon johon jono tallennetaan.
     * Jonon loppuun voidaan tallentaa olioita ja alusta voidaan poistaa
     * olioita.
     *
     */
    public Jono() {
        taulukko = new Object[10];
        alku = 0;
        loppu = 0;
        koko = 0;
    }

    /**
     * Metodi lisää olion jonon loppuun. Jos taulukko on lisäyksen jälkeen
     * täysi, taulukon kokoa kasvatetaan kasvataTaulukkoa -metodilla.
     *
     * @param object Olio, joka lisataan jonon loppuun
     */
    public void push(Object object) {
        taulukko[loppu] = object;
        loppu++;
        if (loppu == taulukko.length) {
            loppu = 0;
        }
        if (loppu == alku) {
            kasvataTaulukkoa();
        }
        koko++;
    }

    /**
     * Metodi poistaa ja palauttaa jonon ensimmäisen alkion.
     *
     * @return Palauttaa jonon ensimmaisen alkion
     */
    public Object poll() {
        if (this.tyhja()) {
            return null;
        }
        Object object = taulukko[alku];
        taulukko[alku] = null;
        alku++;
        if (alku == taulukko.length) {
            alku = 0;
        }
        koko--;
        return object;
    }

    private void kasvataTaulukkoa() {
        Object[] uusiTaulukko = new Object[taulukko.length * 2];
        int i = 0;
        boolean s = true;
        while (alku != loppu || s) {
            uusiTaulukko[i] = taulukko[alku];
            alku++;
            if (alku >= taulukko.length) {
                alku = 0;
            }
            i++;
            s = false;
        }
        taulukko = uusiTaulukko;
        alku = 0;
        loppu = koko + 1;
    }

    /**
     * Jos jono on tyhjä, metodi palauttaa true, muulloin false.
     *
     * @return Palauttaa true, jos jono on tyhja, muulloin false
     */
    public boolean tyhja() {
        if (koko == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa montako alkioita jonossa on.
     *
     * @return Palauttaa alkioiden maaran jonossa
     */
    public int getKoko() {
        return koko;
    }
}
