package luolasto;

import java.util.Random;
import tietorakenteet.Jono;
import tietorakenteet.Kaari;
import tietorakenteet.Keko;
import tietorakenteet.Lista;
import tietorakenteet.Matematiikka;
import tietorakenteet.Piste;
import tietorakenteet.Solmu;
import tietorakenteet.UnionFind;

/**
 * Luokka sisältää luolan seinien ja avointen alueiden generointiin tarvittavat 
 * metodit.
 *
 * @author hanranti
 */
public class Luolageneraattori {

    private final Luolasto luolasto;
    private final Random random;
    private final int size;

    /**
     * Metodi luo Luolageneraattori -olion, joka voi generoida luoliin avoimia 
     * alueita.
     *
     * @param luolasto
     * @param size
     */
    public Luolageneraattori(Luolasto luolasto, int size) {
        random = new Random();
        this.luolasto = luolasto;
        this.size = size;
    }

    /**
     * Metodi generoi luolaan seiniä ja avoimia alueita. Luolaan luodaan
     * satunnaisesti huoneita, uloskäyntejä ja näitä yhdistäviä käytäviä.
     *
     * @param luola
     */
    public void generoi(Luola luola) {
        System.out.println("generoi");
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
        Jono qX = new Jono();
        Jono qY = new Jono();
        Jono dist = new Jono();
        int s = random.nextInt(8) + 1;
        int m = size;
        m /= 10;
        int m2 = m;
        m *= s;
        m2 *= (10 - s);
        m++;
        luoHuoneet(luola, qX, qY, dist, m);
        luoUloskaynnit(luola, qX, qY, dist);
        luoKaytavat(luola, qX, qY, dist);
        generoiHuoneet(luola, qX, qY, dist, m2);
    }

    private void luoUloskaynnit(Luola luola, Jono qX, Jono qY, Jono dist) {
        int luolaX = luola.getLuolaX();
        int luolaY = luola.getLuolaY();
        Lista huoneet = luola.getHuoneet();
        System.out.println("luoUloskaynnit");
        int maara = random.nextInt(2) + 1;
        if (luolasto.getLuola(luolaX - 1, luolaY) != null) {
            System.out.println("x-1");
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX - 1, luolaY).getLuola()[size - 1][i]) {
                    qX.push(0);
                    qY.push(i);
                    dist.push(random.nextInt(1) + 1);
                }
            }
        } else {
            if (maara == 0 && random.nextBoolean()) {
                maara = random.nextInt(3);
            }
            while (maara > 0) {
                qX.push(0);
                int y = random.nextInt(size);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(0, y));
                maara--;
            }
        }
        if (luolasto.getLuola(luolaX + 1, luolaY) != null) {
            System.out.println("x+1");
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX + 1, luolaY).getLuola()[0][i]) {
                    qX.push(size - 1);
                    qY.push(i);
                    dist.push(random.nextInt(1) + 1);
                }
            }
        } else {
            if (maara == 0 && random.nextBoolean()) {
                maara = random.nextInt(3);
            }
            while (maara > 0) {
                qX.push(size - 1);
                int y = random.nextInt(size);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(size - 1, y));
                maara--;
            }
        }
        if (luolasto.getLuola(luolaX, luolaY - 1) != null) {
            System.out.println("y-1");
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX, luolaY - 1).getLuola()[i][size - 1]) {
                    qX.push(i);
                    qY.push(0);
                    dist.push(random.nextInt(1) + 1);
                }
            }
        } else {
            if (maara == 0 && random.nextBoolean()) {
                maara = random.nextInt(3);
            }
            while (maara > 0) {
                qY.push(0);
                int x = random.nextInt(size);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, 0));
                maara--;
            }
        }
        if (luolasto.getLuola(luolaX, luolaY + 1) != null) {
            System.out.println("y+1");
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX, luolaY + 1).getLuola()[i][0]) {
                    qX.push(i);
                    qY.push(size - 1);
                    dist.push(random.nextInt(1) + 1);
                }
            }
        } else {
            if (maara == 0 && random.nextBoolean()) {
                maara = random.nextInt(3);
            }
            while (maara > 0) {
                qY.push(size - 1);
                int x = random.nextInt(size);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, size - 1));
                maara--;
            }
        }
    }

    private void luoKaytavat(Luola luola, Jono qX, Jono qY, Jono dist) {
        Lista huoneet = luola.getHuoneet();
        System.out.println("luoKaytavat");
//        int maara = random.nextInt(huoneet.size());
//        while (maara > 0) {
//            Piste huone1 = huoneet.get(random.nextInt(huoneet.size()));
//            Piste huone2 = huoneet.get(random.nextInt(huoneet.size()));
//            generoiKaytava(qX, qY, dist, huone1.getX(), huone1.getY(),
//                    huone2.getX(), huone2.getY());
//            maara--;
//        }
        UnionFind unionFind = new UnionFind();
        Keko keko = new Keko(false);
        Solmu solmu1 = huoneet.getFirst();
        while (solmu1 != null) {
            Piste h = (Piste) solmu1.getObject();
            unionFind.makeSet(h);
            Solmu solmu2 = huoneet.getFirst();
            while (solmu2 != null) {
                Piste h2 = (Piste) solmu2.getObject();
                solmu2 = solmu2.getOikea();
                if (h.equals(h2)) {
                    continue;
                }
                Kaari kO = new Kaari(h, h2,
                        (int) Matematiikka.hypotenuusanPituus(
                                Math.abs(h.getX() - h2.getX()),
                                Math.abs(h.getY() - h2.getY())));
                keko.insert(kO, kO.getLength());
            }
            solmu1 = solmu1.getOikea();
        }
        while (unionFind.getKomponentit() > 1 && !keko.tyhja()) {
            Kaari u = (Kaari) keko.poistaJuuri();
            if (unionFind
                    .find(
                            u
                            .getO1())
                    != unionFind.
                    find(
                            u
                            .getO2())) {
                unionFind.union(u.getO1(), u.getO2());
                generoiKaytava(qX, qY, dist, u.getO1().getX(), u.getO1().getY(),
                        u.getO2().getX(), u.getO2().getY());
            }
        }
    }

    private void generoiKaytava(Jono qX, Jono qY, Jono dist, int x, int y, int loppuX, int loppuY) {
        System.out.println("generoiKaytava");
        if (x == loppuX && y == loppuY) {
            return;
        }
        qX.push(x);
        qY.push(y);
        dist.push(random.nextInt(2));
        if (Math.abs(loppuX - x) > Math.abs(loppuY - y)) {
            if (x > loppuX) {
                generoiKaytava(qX, qY, dist, x - 1, y, loppuX, loppuY);
            } else {
                generoiKaytava(qX, qY, dist, x + 1, y, loppuX, loppuY);
            }
        } else if (y > loppuY) {
            generoiKaytava(qX, qY, dist, x, y - 1, loppuX, loppuY);
        } else {
            generoiKaytava(qX, qY, dist, x, y + 1, loppuX, loppuY);
        }
    }

    private void luoHuoneet(Luola luola, Jono qX, Jono qY, Jono dist, int m) {
        Lista huoneet = luola.getHuoneet();
        System.out.println("luohuoneet");
        int maara = random.nextInt(m) + 1;
        for (int i = 0; i < maara; i++) {
            Piste piste = new Piste(random.nextInt(size), random.nextInt(size));
            huoneet.add(piste);
        }
        Solmu solmu = huoneet.getFirst();
        while (solmu != null) {
            Piste huone = (Piste) solmu.getObject();
            qX.push(huone.getX());
            qY.push(huone.getY());
            dist.push(random.nextInt(5) + 8);
            solmu = solmu.getOikea();
        }
    }

    private void generoiHuoneet(Luola l, Jono qX, Jono qY, Jono dist, int s) {
        boolean[][] luola = l.getLuola();
        int luolaX = l.getLuolaX();
        int luolaY = l.getLuolaY();
        char[][] asd = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                asd[i][j] = ' ';
            }
        }
        for (int i = 0; i < qX.koko(); i++) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            asd[x][y] = 'o';
            qX.push(x);
            qY.push(y);
        }
        Solmu solmu = l.getHuoneet().getFirst();
        while (solmu != null) {
            Piste piste = (Piste) solmu.getObject();
            asd[piste.getX()][piste.getY()] = 'x';
            solmu = solmu.getOikea();
        }
        for (int i = 0; i < asd[0].length; i++) {
            for (int j = 0; j < asd.length; j++) {
                System.out.print(asd[j][i]);
            }
            System.out.println("");
        }
        System.out.println("generoiHuoneet");
        int[][] aloitusX = new int[size][size];
        int[][] aloitusY = new int[size][size];
        for (int i = 0; i < qX.koko(); i++) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            aloitusX[x][y] = x;
            aloitusY[x][y] = y;
            qX.push(x);
            qY.push(y);
        }
        boolean[][] color = new boolean[size][size];
        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            int d = (int) dist.poll();
            luola[x][y] = true;
            if ((x == size - 1 && luolasto.getLuola(luolaX + 1, luolaY) != null
                    && !luolasto.getLuola(luolaX + 1, luolaY).getLuola()[0][y])
                    || (y == size - 1 && luolasto.getLuola(luolaX, luolaY + 1) != null
                    && !luolasto.getLuola(luolaX, luolaY + 1).getLuola()[x][0])
                    || x == 0 && luolasto.getLuola(luolaX - 1, luolaY) != null
                    && !luolasto.getLuola(luolaX - 1, luolaY).getLuola()[size - 1][y]
                    || y == 0 && luolasto.getLuola(luolaX, luolaY - 1) != null
                    && !luolasto.getLuola(luolaX, luolaY - 1).getLuola()[x][size - 1]) {
                luola[x][y] = false;
                continue;
            }
            if (x < size - 1 && !color[x + 1][y] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(3) < 1)) {
                color[x + 1][y] = true;
                aloitusX[x + 1][y] = aloitusX[x][y];
                qX.push(x + 1);
                qY.push(y);
                dist.push(d);
            }
            if (x > 0 && !color[x - 1][y] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(3) < 1)) {
                color[x - 1][y] = true;
                aloitusX[x - 1][y] = aloitusX[x][y];
                qX.push(x - 1);
                qY.push(y);
                dist.push(d);
            }
            if (y < size - 1 && !color[x][y + 1] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(3) < 1)) {
                color[x][y + 1] = true;
                aloitusX[x][y + 1] = aloitusX[x][y];
                qX.push(x);
                qY.push(y + 1);
                dist.push(d);
            }
            if (y > 0 && !color[x][y - 1] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(3) < 1)) {
                color[x][y - 1] = true;
                aloitusX[x][y - 1] = aloitusX[x][y];
                qX.push(x);
                qY.push(y - 1);
                dist.push(d);
            }
            color[x][y] = true;
        }
    }
}
