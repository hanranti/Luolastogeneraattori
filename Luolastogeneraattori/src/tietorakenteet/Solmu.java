package tietorakenteet;

/**
 * Luokka kuvaa solmua, joka sisältää jonkin olion ja tuntee 0-2 muuta solmua.
 *
 * @author hanranti
 * @param <E> 
 */
public class Solmu<E extends Object> {

    private final Object object;
    private Solmu vasen, oikea;

    /**
     * Metodi luo Solmu -olion, ja asettaa parametrinä annetun olion Solmun
     * olioksi.
     *
     * @param object Olio, joka lisataan solmuun
     */
    public Solmu(E object) {
        this.object = object;
    }

    /**
     * Metodi asettaa parametrinä annetun solmun tämän solmun vasen muuttujan 
     * paikalle.
     *
     * @param prev Solmu, joka asetetaan taman solmun vasemmaksi solmuksi
     */
    public void setVasen(Solmu prev) {
        this.vasen = prev;
    }

    /**
     * Metodi asettaa parametrinä annetun solmun tämän solmun oikea muuttujan 
     * paikalle.
     *
     * @param next Solmu, joka asetetaan taman solmun oikeaksi solmuksi
     */
    public void setOikea(Solmu next) {
        this.oikea = next;
    }

    /**
     * Metodi palauttaa muuttujan vasen paikalla olevan solmun.
     *
     * @return Palauttaa taman solmun vasemmanpuolisen solmun
     */
    public Solmu getVasen() {
        return vasen;
    }

    /**
     * Metodi palauttaa muuttujan oikea paikalla olevan solmun.
     *
     * @return Palauttaa taman solmun oikeanpuolisen solmun
     */
    public Solmu getOikea() {
        return oikea;
    }

    /**
     * Metodi palauttaa solmuun asetetun olion.
     *
     * @return Palauttaa solmuun asetetun olion
     */
    public Object getObject() {
        return object;
    }
}
