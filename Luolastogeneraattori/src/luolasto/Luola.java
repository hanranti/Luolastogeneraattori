package luolasto;

import tietorakenteet.Piste;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import tietorakenteet.Kaari;
import tietorakenteet.Keko;
import tietorakenteet.Matematiikka;
import tietorakenteet.UnionFind;

/**
 * Luokka sisältää boolean[][] taulukon, joka määrittää yksittäisen luolan
 * seinät ja avoimet alueet. True kuvaa seinää ja false avointa aluetta.
 *
 * @author Hannu
 */
public class Luola {

    private boolean[][] luola;
    private int luolaX, luolaY, size;
    private ArrayList<Piste> huoneet;
    private Random random;
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
        random = new Random();
        this.luolasto = luolasto;
        this.luolaX = x;
        this.luolaY = y;
        huoneet = new ArrayList<>();
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
     * Metodi palauttaa yksittäistä luolaa kuvaavan boolean[][] -taulukon.
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
    public ArrayList<Piste> getHuoneet() {
        return huoneet;
    }

    public int getLuolaX() {
        return luolaX;
    }

    public int getLuolaY() {
        return luolaY;
    }
}
