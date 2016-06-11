package luolasto;

import tietorakenteet.Piste;
import java.util.Random;
import tietorakenteet.Lista;

/**
 * Luokka sisältää boolean[][] taulukon, joka määrittää yksittäisen luolan
 * seinät ja avoimet alueet. False kuvaa seinää ja true avointa aluetta.
 *
 * @author Hannu
 */
public class Luola {

    private boolean[][] luola;
    private int luolaX, luolaY, size;
    private Lista huoneet;
    private Luolasto luolasto;

    /**
     * Metodi luo Luola -olion. Metodi ottaa parametrina int size muuttujan,
     * joka määrittää luolan leveyden ja korkeuden.
     *
     * @param luolasto
     * @param size
     * @param y
     * @param x
     */
    public Luola(Luolasto luolasto, int x, int y, int size) {
        System.out.println("Luola");
        this.size = size;
        luola = new boolean[size][size];
        this.luolasto = luolasto;
        this.luolaX = x;
        this.luolaY = y;
        huoneet = new Lista();
    }

    /**
     * Metodi lisää huoneisiin uuden Piste -olion, joka sisältää yhden huoneen
     * koordinaatit.
     *
     * @param huone
     */
    public void addHuone(Piste huone) {
        huoneet.add(huone);
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
    public int getLuolaX() {
        return luolaX;
    }

    /**
     * Metodi palauttaa tämän luolan y-koordinaatin luolastossa.
     *
     * @return
     */
    public int getLuolaY() {
        return luolaY;
    }
}
