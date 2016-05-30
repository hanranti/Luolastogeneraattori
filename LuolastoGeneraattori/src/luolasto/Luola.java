package luolasto;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

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
    public void generoi(Luolasto luolasto, int x, int y) {
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
        luoHuoneet(random.nextInt(8) + 1);
    }

    private void luoKaytavat() {
    }

    private void luoUloskaynnit(int s, int x, int y, Luolasto luolasto) {
        if (s > 9) {
            s = 9;
        } else if (s < 1) {
            s = 1;
        }
        if (luolasto.getLuola(x + 1, y) == null) {
            int maara = random.nextInt(size / 10);
        }

    }

    private void luoHuoneet(int s) {
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
        m/=10;
        System.out.println(m);
        int maara = random.nextInt(m) + 1;
        for (int i = 0; i < maara; i++) {
            Piste piste = new Piste(random.nextInt(size), random.nextInt(size));
            huoneet.add(piste);
        }
        for (Piste huone : huoneet) {
            generoiHuone(huone, m2);
        }
    }

    public void generoiHuone(Piste piste, int s) {
        int limit = random.nextInt(s);
        ArrayDeque<Integer> qX = new ArrayDeque<>();
        ArrayDeque<Integer> qY = new ArrayDeque<>();
        int[][] dist = new int[size][size];
        boolean[][] color = new boolean[size][size];
        qX.add(piste.getX());
        qY.add(piste.getY());
        dist[piste.getX()][piste.getY()] = 0;
        color[piste.getX()][piste.getY()] = true;
        while (!qX.isEmpty()) {
            int x = qX.poll();
            int y = qY.poll();
            luola[x][y] = true;
            if (limit == 0) {
//                break;
            }
            limit--;
            if (x < size - 1 && !color[x + 1][y] && (dist[x][y] < 4 || random.nextBoolean())) {
                color[x + 1][y] = true;
                dist[x + 1][y] = dist[x][y] + 1;
                qX.add(x + 1);
                qY.add(y);
            }
            if (x > 0 && !color[x - 1][y] && (dist[x][y] < 4 || random.nextBoolean())) {
                color[x - 1][y] = true;
                dist[x - 1][y] = dist[x][y] + 1;
                qX.add(x - 1);
                qY.add(y);
            }
            if (y < size - 1 && !color[x][y + 1] && (dist[x][y] < 4 || random.nextBoolean())) {
                color[x][y + 1] = true;
                dist[x][y + 1] = dist[x][y] + 1;
                qX.add(x);
                qY.add(y + 1);
            }
            if (y > 0 && !color[x][y - 1] && (dist[x][y] < 4 || random.nextBoolean())) {
                color[x][y - 1] = true;
                dist[x][y - 1] = dist[x][y] + 1;
                qX.add(x);
                qY.add(y - 1);
            }
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
}
