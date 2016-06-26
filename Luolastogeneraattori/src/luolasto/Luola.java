package luolasto;

import tietorakenteet.Piste;
import tietorakenteet.Lista;

/**
 * Luokka sisältää boolean[][] taulukon, joka määrittää yksittäisen luolan
 * seinät ja avoimet alueet. False kuvaa seinää ja true avointa aluetta.
 *
 * @author Hannu
 */
public class Luola {

    private final boolean[][] luola;
    private final int x, y, size;
    private final Lista huoneet;
    private final Luolasto luolasto;

    /**
     * Metodi luo Luola -olion. Metodi ottaa parametrina int size muuttujan,
     * joka määrittää luolan leveyden ja korkeuden.
     *
     * @param luolasto
     * @param y
     * @param x
     */
    public Luola(Luolasto luolasto, int x, int y) {
        this.luolasto = luolasto;
        this.size = luolasto.getSize();
        luola = new boolean[size][size];
        this.x = x;
        this.y = y;
        huoneet = new Lista();
    }

    

    /**
     * Metodi palauttaa tätä luolaa kuvaavan boolean[][] -taulukon.
     *
     * @return
     */
    public boolean[][] getLuola() {
        return luola;
    }

    /**
     * Metodi palauttaa listan Piste olioista,jotka sisältävät huoneiden
     * koordinaatit.
     *
     * @return
     */
    public Lista getHuoneet() {
        return huoneet;
    }

    /**
     * Metodi palauttaa tämän luolan x-koordinaatin luolastossa.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Metodi palauttaa tämän luolan y-koordinaatin luolastossa.
     *
     * @return
     */
    public int getY() {
        return y;
    }
}
