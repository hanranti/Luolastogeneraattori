package tietorakenteet;

/**
 * Lista -luokka kuvaa linkitetty lista -tietorakennetta. Luokalla on tieto
 * listan ensimmäisestä ja viimeisestä Solmusta. Muihin solmuihin päästään
 * käsiksi tiedolla, solmujen viereisistä solmuista.
 *
 * @author hanranti
 */
public class Lista {

    private Solmu first, last;
    private int koko;

    /**
     * Metodi luo Lista -olion.
     *
     */
    public Lista() {
        koko = 0;
    }

    /**
     * Metodi lisää listaan uuden Solmun, jolla on parametrinä annettu olio.
     *
     * @param object
     */
    public void add(Object object) {
        if (first == null) {
            first = new Solmu(object);
            last = first;
        } else {
            Solmu solmu = new Solmu(object);
            last.setOikea(solmu);
            solmu.setVasen(last);
            last = solmu;
        }
        koko++;
    }

    /**
     * Metodi poistaa listasta Solmut, joilla on parametrinä annettu olio.
     *
     * @param object
     */
    public void remove(Object object) {
        if (first == null) {
            return;
        }
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject().equals(object)) {
                if (solmu.equals(first)) {
                    first = solmu.getOikea();
                }
                if (solmu.equals(last)) {
                    last = solmu.getVasen();
                }
                if (solmu.getVasen() != null) {
                    solmu.getVasen().setOikea(solmu.getOikea());
                }
                if (solmu.getOikea() != null) {
                    solmu.getOikea().setVasen(solmu.getVasen());
                }
                koko--;
            }
            solmu = solmu.getOikea();
        }
    }

    /**
     * Metodi palauttaa true, jos listassa on solmu, jolla on parametrinä saatu
     * olio, muulloin false.
     *
     * @param object
     * @return
     */
    public boolean contains(Object object) {
        Solmu solmu = first;
        while (solmu != null) {
            if (solmu.getObject() == object) {
                return true;
            }
            solmu = solmu.getOikea();
        }
        return false;
    }

    /**
     * Metodi palauttaa olion, joka on parametrinä saadussa indeksissä olevassa
     * solmussa, eli solmussa, jonka etäisyys first solmusta kulkien oikealle on
     * parametrinä saadun int i:n arvo.
     *
     * @param i
     * @return
     */
    public Object get(int i){
        Solmu solmu = first;
        for (int j = 0; j < i; j++) {
            solmu = solmu.getOikea();
        }
        return solmu.getObject();
    }

    /**
     * Metodi palauttaa listan ensimmäisen solmun.
     *
     * @return
     */
    public Solmu getFirst() {
        return first;
    }

    /**
     * Metodi palauttaa listan viimeisen solmun.
     *
     * @return
     */
    public Solmu getLast() {
        return last;
    }

    /**
     * Metodi palauttaa solmujen määrän listassa.
     *
     * @return
     */
    public int getKoko() {
        return koko;
    }
}
