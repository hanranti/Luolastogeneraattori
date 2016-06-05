package luolasto;

/**
 * Piste -luokka kuvaa yksittäistä koordinaattia luolassa.
 *
 * @author hanranti
 */
public class Piste {

    private int x;
    private int y;

    /**
     * Metodi luo Piste -olion ja asettaa x- ja y koordinaateiksi parametrina
     * saadut x- ja y muuttujat.
     *
     * @param x
     * @param y
     */
    public Piste(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metodi palauttaa x-koordinaatin.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Metodi palauttaa y-koordinaatin.
     *
     * @return
     */
    public int getY() {
        return y;
    }

}
