package luolasto;

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
     * @param luolasto Luolasto, jossa luola sijaitsee
     * @param y Luolan x -koordinaatti luolastossa
     * @param x Luolan y -koordinaatti luolastossa
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
     * @return Boolean -taulukko, jossa false on seina ja true avoin alue
     */
    public boolean[][] getLuola() {
        return luola;
    }

    /**
     * Metodi palauttaa listan Piste olioista,jotka sisältävät huoneiden
     * koordinaatit.
     *
     * @return Lista luolan sisältämistä huoneista
     */
    public Lista getHuoneet() {
        return huoneet;
    }

    /**
     * Metodi palauttaa tämän luolan x-koordinaatin luolastossa.
     *
     * @return Tämän luolan x-koordinaatti luolastossa
     */
    public int getX() {
        return x;
    }

    /**
     * Metodi palauttaa tämän luolan y-koordinaatin luolastossa.
     *
     * @return Tämän luolan y-koordinaatti luolastossa
     */
    public int getY() {
        return y;
    }
}
