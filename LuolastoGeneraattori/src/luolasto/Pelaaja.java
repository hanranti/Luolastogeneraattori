package luolasto;

/**
 * Luokka sisältää tiedon, missä luolassa pelaaja on luolastossa, ja, missä
 * koordinaateissa pelaaja on luolassa. Luokan liikuta metodeilla voidaan
 * liikuttaa pelaajaa yksi askel kerrallaan.
 *
 * @author Hannu
 */
public class Pelaaja {

    private int x, y, luolaX, luolaY, size;
    private final Luolasto luolasto;

    /**
     * Metodi luo Pelaaja -olion. Metodi saa parametreina pelaajan aloitus
     * koordinaatit luolassa ja luolasta, jossa pelaaja on, sekä luolasto
     * -olion, joka sisältää tiedon luolastosta, jossa pelaaja sijaitsee.
     *
     * @param x
     * @param y
     * @param luolaX
     * @param luolaY
     * @param luolasto
     */
    public Pelaaja(int x, int y, int luolaX, int luolaY, Luolasto luolasto, int size) {
        this.x = x;
        this.y = y;
        this.luolaX = luolaX;
        this.luolaY = luolaY;
        this.luolasto = luolasto;
        this.size = size;
    }

    /**
     * Metodi liikuttaa pelaajaa y-koordinaateissa yhden askeleen alaspäin. Jos
     * kohteessa on seinä, pelaajaa ei liikuteta. Jos pelaaja liikkuu luolan
     * ulkopuolelle, luolasto generoi uuden luolan uudelle paikalle
     *
     */
    public void liikutaYlos() {
        if (y - 1 >= 0 && luolasto.getLuola(luolaX, luolaY).getLuola()[x][y - 1]) {
            return;
        }
        y--;
        if (y < 0) {
            luolaY--;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = size - 1;
        }
    }

    /**
     * Metodi liikuttaa pelaajaa y-koordinaateissa yhden askeleen ylöspäin. Jos
     * kohteessa on seinä, pelaajaa ei liikuteta. Jos pelaaja liikkuu luolan
     * ulkopuolelle, luolasto generoi uuden luolan uudelle paikalle
     *
     */
    public void liikutaAlas() {
        if (y < size - 1 && luolasto.getLuola(luolaX, luolaY).getLuola()[x][y + 1]) {
            return;
        }
        y++;
        if (y > size - 1) {
            luolaY++;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = 0;
        }
    }

    /**
     * Metodi liikuttaa pelaajaa x-koordinaateissa yhden askeleen oikealle. Jos
     * kohteessa on seinä, pelaajaa ei liikuteta. Jos pelaaja liikkuu luolan
     * ulkopuolelle, luolasto generoi uuden luolan uudelle paikalle
     *
     */
    public void liikutaOikealle() {
        if (x < size - 1 && luolasto.getLuola(luolaX, luolaY).getLuola()[x + 1][y]) {
            return;
        }
        x++;
        if (x > size - 1) {
            luolaX++;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = 0;
        }
    }

    /**
     * Metodi liikuttaa pelaajaa x-koordinaateissa yhden askeleen vasemmalle.
     * Jos kohteessa on seinä, pelaajaa ei liikuteta. Jos pelaaja liikkuu luolan
     * ulkopuolelle, luolasto generoi uuden luolan uudelle paikalle
     *
     */
    public void liikutaVasemmalle() {
        if (x - 1 >= 0 && luolasto.getLuola(luolaX, luolaY).getLuola()[x - 1][y]) {
            return;
        }
        x--;
        if (x < 0) {
            luolaX--;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = size - 1;
        }
    }

    /**
     * Metodi palauttaa pelaajan x-koordinaatin.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Metodi palauttaa pelaajan y-koordinaatin.
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Metodi palauttaa x-koordinaatin luolasta, jossa pelaaja on, luolastosta.
     *
     * @return
     */
    public int getLuolaX() {
        return luolaX;
    }

    /**
     * Metodi palauttaa y-koordinaatin luolasta, jossa pelaaja on, luolastosta.
     *
     * @return
     */
    public int getLuolaY() {
        return luolaY;
    }

    public void merkkaa() {
        luolasto.getLuola(luolaX, luolaY).getLuola()[x][y] = true;
    }
}
