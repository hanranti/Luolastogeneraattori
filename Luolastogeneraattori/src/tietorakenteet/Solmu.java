package tietorakenteet;

/**
 * Luokka kuvaa solmua, joka sisältää jonkin olion ja tuntee 0-2 muuta solmua.
 *
 * @author hanranti
 * @param <E>
 */
public class Solmu<E extends Object> {

    private Object object;
    private Solmu vasen, oikea;

    /**
     * Metodi luo Solmu -olion, ja asettaa parametrinä annetun olion Solmun
     * olioksi.
     *
     * @param object
     */
    public Solmu(E object) {
        this.object = object;
    }

    /**
     * Metodi asettaa parametrinä annetun solmun tämän solmun vasen muuttujan 
     * paikalle.
     *
     * @param prev
     */
    public void setVasen(Solmu prev) {
        this.vasen = prev;
    }

    /**
     * Metodi asettaa parametrinä annetun solmun tämän solmun oikea muuttujan 
     * paikalle.
     *
     * @param next
     */
    public void setOikea(Solmu next) {
        this.oikea = next;
    }

    /**
     * Metodi palauttaa muuttujan vasen paikalla olevan solmun.
     *
     * @return
     */
    public Solmu getVasen() {
        return vasen;
    }

    /**
     * Metodi palauttaa muuttujan oikea paikalla olevan solmun.
     *
     * @return
     */
    public Solmu getOikea() {
        return oikea;
    }

    /**
     * Metodi palauttaa solmuun asetetun olion.
     *
     * @return
     */
    public Object getObject() {
        return object;
    }
}
