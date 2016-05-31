package luolasto;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import tietorakenteet.Matematiikka;

/**
 * Luokka sisältää boolean[][] taulukon, joka määrittää yksittäisen luolan
 * seinät ja avoimet alueet. True kuvaa seinää ja false avointa aluetta.
 *
 * @author Hannu
 */
public class Luola {

    private boolean[][] luola;
    private int size;
    private ArrayList<Piste> huoneet;
    private ArrayList<Piste> uloskaynnit;
    private Random random;

    /**
     * Metodi luo Luola -olion. Metodi ottaa parametrina int size muuttujan,
     * joka määrittää luolan leveyden ja korkeuden.
     *
     * @param size
     */
    public Luola(int size) {
        this.size = size;
        luola = new boolean[size][size];
        random = new Random();
    }

    /**
     * Metodi generoi luolaan seiniä ja avoimia alueita. Luolaan luodaan
     * satunnaisesti huoneita, uloskäyntejä ja näitä yhdistäviä käytäviä.
     *
     */
    public void generoi(Luolasto luolasto, int X, int Y) {
        //        for (int i = 0; i < luola.length; i++) {
        //            for (int j = 0; j < luola[0].length; j++) {
        //                if (i == 0 || j == 0 || i == luola.length - 1 || j == luola[0].length - 1) {
        //                    luola[i][j] = true;
        //                }
        //            }
        //        }
        //        luola[0][(luola.length - 1) / 2] = false;
        //        luola[luola.length - 1][(luola.length - 1) / 2] = false;
        //        luola[(luola.length - 1) / 2][0] = false;
        //        luola[(luola.length - 1) / 2][luola.length - 1] = false;
        luoHuoneet(luolasto, random.nextInt(8) + 1, X, Y);
    }

    private void luoKaytavat() {
    }

    private void luoHuoneet(Luolasto luolasto, int s, int X, int Y) {
        if (s > 9) {
            s = 9;
        } else if (s < 1) {
            s = 1;
        }
        huoneet = new ArrayList<>();
        int m = size;
        m /= 10;
        int m2 = m;
        m *= s;
        m2 *= (10 - s);
        m++;
        int maara = random.nextInt(m) + 1;
        for (int i = 0; i < maara; i++) {
            Piste piste = new Piste(random.nextInt(size), random.nextInt(size));
            huoneet.add(piste);
        }
        ArrayDeque<Integer> qX = new ArrayDeque<>();
        ArrayDeque<Integer> qY = new ArrayDeque<>();
        for (Piste huone : huoneet) {
            qX.add(huone.getX());
            qY.add(huone.getY());
        }
        generoiHuoneet(qX, qY, luolasto, m2, X, Y);
    }

    public void generoiHuoneet(ArrayDeque<Integer> qX, ArrayDeque<Integer> qY, Luolasto luolasto, int s, int X, int Y) {
        int[][] aloitusX = new int[size][size];
        int[][] aloitusY = new int[size][size];
        for (int i = 0; i < qX.size(); i++) {
            int x = qX.poll();
            int y = qY.poll();
            aloitusX[x][y] = x;
            aloitusY[x][y] = y;
            qX.add(x);
            qY.add(y);
        }
        boolean[][] color = new boolean[size][size];
        while (!qX.isEmpty()) {
            int x = qX.poll();
            int y = qY.poll();
            luola[x][y] = true;
            if ((x == size - 1 && luolasto.getLuola(X + 1, Y) != null && !luolasto.getLuola(X + 1, Y).getLuola()[0][y])
                    || (y == size - 1 && luolasto.getLuola(X, Y + 1) != null && !luolasto.getLuola(X, Y + 1).getLuola()[x][0])
                    || x == 0 && luolasto.getLuola(X - 1, Y) != null && !luolasto.getLuola(X - 1, Y).getLuola()[size - 1][y]
                    || y == 0 && luolasto.getLuola(X, Y - 1) != null && !luolasto.getLuola(X, Y - 1).getLuola()[x][size - 1]) {
                luola[x][y] = false;
                continue;
            }
            if (x < size - 1 && !color[x + 1][y] && (Matematiikka.kateetinPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < 6 || random.nextInt(3) < 1)) {
                color[x + 1][y] = true;
                aloitusX[x + 1][y] = aloitusX[x][y];
                qX.add(x + 1);
                qY.add(y);
            }
            if (x > 0 && !color[x - 1][y] && (Matematiikka.kateetinPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < 6 || random.nextInt(3) < 1)) {
                color[x - 1][y] = true;
                aloitusX[x - 1][y] = aloitusX[x][y];
                qX.add(x - 1);
                qY.add(y);
            }
            if (y < size - 1 && !color[x][y + 1] && (Matematiikka.kateetinPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < 6 || random.nextInt(3) < 1)) {
                color[x][y + 1] = true;
                aloitusX[x][y + 1] = aloitusX[x][y];
                qX.add(x);
                qY.add(y + 1);
            }
            if (y > 0 && !color[x][y - 1] && (Matematiikka.kateetinPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < 6 || random.nextInt(3) < 1)) {
                color[x][y - 1] = true;
                aloitusX[x][y - 1] = aloitusX[x][y];
                qX.add(x);
                qY.add(y - 1);
            }
            color[x][y] = true;
        }
    }

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

    public ArrayList<Piste> getHuoneet() {
        return huoneet;
    }
}
