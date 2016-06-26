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
    private final int size, uusiaUloskaynteja;
    private int todennakoisyys;

    /**
     * Metodi luo Luolageneraattori -olion, joka voi generoida luoliin avoimia
     * alueita.
     *
     * @param luolasto
     * @param todennakoisyysVahennys
     */
    public Luolageneraattori(Luolasto luolasto, int todennakoisyysVahennys) {
        random = new Random();
        this.luolasto = luolasto;
        this.size = luolasto.getSize();
        this.uusiaUloskaynteja = todennakoisyysVahennys;
        this.todennakoisyys = 100;
    }

    /**
     * Metodi generoi luolaan seiniä ja avoimia alueita. Luolaan luodaan
     * satunnaisesti huoneita, uloskäyntejä ja näitä yhdistäviä käytäviä.
     *
     * @param luola
     */
    public void generoi(Luola luola) {
        //Kaikki koordinaatit joihin generoidaan avoimia alueita lisätään jonoihin,
        //jotka annetaan leveyssuuntaisella läpikäynnillä toimivalle
        //generoiAvoimetAlueet -metodille.
        Jono qX = new Jono();
        Jono qY = new Jono();
        //dist sisältää arvot, jotka määrittävät, kuinka laajalle arvoja vastaavista
        //koordinaateista vähimmillään generoidaan avointa aluetta.
        Jono dist = new Jono();
        //Luodaan satunnaisluku m, joka vaikuttaa huoneiden määrään ja kokoon.
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
        generoiAvoimetAlueet(luola, qX, qY, dist, m2);
        generoiReunat(luola);
        if (todennakoisyys > 0) {
            todennakoisyys -= uusiaUloskaynteja;
        } else {
            todennakoisyys = 0;
        }
    }

    private void luoUloskaynnit(Luola luola, Jono qX, Jono qY, Jono dist) {
        int luolaX = luola.getX();
        int luolaY = luola.getY();
        Lista huoneet = luola.getHuoneet();
        //Seuraavia boolean ja int nullMaara muuttujia käytetään varmistamaan,
        //että, jos luolasta luodaan uusi uloskäynti generoimattomaan luolaan,
        //luolasta luodaan vähintään yksi uusi uloskäynti.
        boolean uusiUloskayntiLisatty = true;
        boolean viereinenNull[] = new boolean[4];
        int nullMaara = 0;
        int maara = 0;
        //Jos randomin antama todennäköisyys on pienempi, kuin todennäköisyys,
        //generoimattomiin luoliin luodaan uloskäyntejä.
        if (random.nextInt(100) + 1 <= todennakoisyys) {
            maara = random.nextInt(5) + 1;
            uusiUloskayntiLisatty = false;
        }

        //Jos seuraavissa if, niin viereinen luola on jo generoitu, ja viereisestä
        //luolasta haetaan paikat uloskäynnille.
        //Jos else, niin generoimattomaan luolaan luodaan mahdollisesti uloskäyntejä.
        if (luolasto.getLuola(luolaX - 1, luolaY) != null) {
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX - 1, luolaY).getLuola()[size - 1][i]) {
                    qX.push(0);
                    qY.push(i);
                    dist.push(random.nextInt(1) + 1);
                    huoneet.add(new Piste(0, i));
                }
            }
        } else {
            while (maara > 0 && random.nextInt(4) < 3) {
                qX.push(0);
                int y = 1 + random.nextInt(size - 2);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(0, y));
                maara--;
                uusiUloskayntiLisatty = true;
            }
            viereinenNull[0] = true;
            nullMaara++;
        }
        if (luolasto.getLuola(luolaX + 1, luolaY) != null) {
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX + 1, luolaY).getLuola()[0][i]) {
                    qX.push(size - 1);
                    qY.push(i);
                    dist.push(random.nextInt(1) + 1);
                    huoneet.add(new Piste(size - 1, i));
                }
            }
        } else {
            while (maara > 0 && random.nextInt(4) < 3) {
                qX.push(size - 1);
                int y = 1 + random.nextInt(size - 2);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(size - 1, y));
                maara--;
                uusiUloskayntiLisatty = true;
            }
            viereinenNull[1] = true;
            nullMaara++;
        }
        if (luolasto.getLuola(luolaX, luolaY - 1) != null) {
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX, luolaY - 1).getLuola()[i][size - 1]) {
                    qX.push(i);
                    qY.push(0);
                    dist.push(random.nextInt(1) + 1);
                    huoneet.add(new Piste(i, 0));
                }
            }
        } else {
            while (maara > 0 && random.nextInt(4) < 3) {
                qY.push(0);
                int x = 1 + random.nextInt(size - 2);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, 0));
                maara--;
                uusiUloskayntiLisatty = true;
            }
            viereinenNull[2] = true;
            nullMaara++;
        }
        if (luolasto.getLuola(luolaX, luolaY + 1) != null) {
            for (int i = 0; i < size; i++) {
                if (luolasto.getLuola(luolaX, luolaY + 1).getLuola()[i][0]) {
                    qX.push(i);
                    qY.push(size - 1);
                    dist.push(random.nextInt(1) + 1);
                    huoneet.add(new Piste(i, size - 1));
                }
            }
        } else {
            while (maara > 0 && random.nextInt(3) < 2) {
                qY.push(size - 1);
                int x = 1 + random.nextInt(size - 2);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, size - 1));
                maara--;
                uusiUloskayntiLisatty = true;
            }
            viereinenNull[3] = true;
            nullMaara++;
        }
        //Jos uutta uloskäyntiä ei ole lisätty ja randomin antama todennäköiyys
        //on pienempi kuin todennäköisyys, uusi uloskäynti luodaan randomin
        //antamaan luolaan.
        if (!uusiUloskayntiLisatty) {
            //Randomin antamia vaihtoehtoja on viereisten generoimattomien
            //luolien määrä.
            int xy = random.nextInt(nullMaara);
            //Tässä ja myöhemmissä, jos viereistä ei ole generoitu, tästä aiheutuva
            //virhe korjataan lisäämällä, xy++.
            //Jos esimerkiksi vain ensimmäinen vierusluola on jo generoitu, random
            //antaa xy:n arvoksi arvon välillä 0-2, koska tällöin nullMaara = 3.
            //Koska if(!viereinenNull[3]) saa tällöin true, xy:n arvo korjautuu
            //arvoksi välillä 1-3.
            if (!viereinenNull[3]) {
                xy++;
            }
            if (xy == 0) {
                qY.push(size - 1);
                int x = 1 + random.nextInt(size - 2);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, size - 1));
                return;
            }
            if (!viereinenNull[2]) {
                xy++;
            }
            if (xy == 1) {
                qY.push(0);
                int x = 1 + random.nextInt(size - 2);
                qX.push(x);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(x, 0));
                return;
            }
            if (!viereinenNull[1]) {
                xy++;
            }
            if (xy == 2) {
                qX.push(size - 1);
                int y = 1 + random.nextInt(size - 2);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(size - 1, y));
                return;
            }
            if (!viereinenNull[0]) {
                xy++;
            }
            if (xy == 3) {
                qX.push(0);
                int y = 1 + random.nextInt(size - 2);
                qY.push(y);
                dist.push(random.nextInt(1) + 1);
                huoneet.add(new Piste(0, y));
                return;
            }
        }
    }

    private void luoKaytavat(Luola luola, Jono qX, Jono qY, Jono dist) {
        //Käytävillä muodostetaan pienin virittävä puu käyttäen kruskalia. 
        Lista huoneet = luola.getHuoneet();
        UnionFind unionFind = new UnionFind();
        Keko keko = new Keko(false);
        Solmu solmu1 = huoneet.getFirst();
        //Kaikkien huoneiden välille luodaan kaaret ja nämä listään kekoon.
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
            if (unionFind.find(u.getO1()) != unionFind.find(u.getO2())) {
                unionFind.union(u.getO1(), u.getO2());
                luoPolku(qX, qY, dist, u.getO1().getX(), u.getO1().getY(),
                        u.getO2().getX(), u.getO2().getY());
            }
        }
    }

    private void luoPolku(Jono qX, Jono qY, Jono dist, int x, int y, int loppuX, int loppuY) {
        if (x == loppuX && y == loppuY) {
            return;
        }
        if (x == 0) {
            qX.push(x + 1);
        } else if (x == size - 1) {
            qX.push(x - 1);
        } else {
            qX.push(x);
        }
        if (y == 0) {
            qY.push(y + 1);
        } else if (y == size - 1) {
            qY.push(y - 1);
        } else {
            qY.push(y);
        }
        dist.push(random.nextInt(1) + 1);
        if (Math.abs(loppuX - x) > Math.abs(loppuY - y)) {
            if (x > loppuX) {
                luoPolku(qX, qY, dist, x - 1, y, loppuX, loppuY);
            } else {
                luoPolku(qX, qY, dist, x + 1, y, loppuX, loppuY);
            }
        } else {
            if (y > loppuY) {
                luoPolku(qX, qY, dist, x, y - 1, loppuX, loppuY);
            } else {
                luoPolku(qX, qY, dist, x, y + 1, loppuX, loppuY);
            }
        }
    }

    private void luoHuoneet(Luola luola, Jono qX, Jono qY, Jono dist, int m) {
        //Huoneita luodaan satunnainen määrä satunnaisiin koordinaatteihin.
        Lista huoneet = luola.getHuoneet();
        int maara = random.nextInt(m) + 1;
        for (int i = 0; i < maara; i++) {
            Piste piste = new Piste(1 + random.nextInt(size - 2), 1 + random.nextInt(size - 2));
            huoneet.add(piste);
            qX.push(piste.getX());
            qY.push(piste.getY());
            dist.push(random.nextInt(5) + 8);
        }
    }

    private void generoiAvoimetAlueet(Luola l, Jono qX, Jono qY, Jono dist, int s) {
        //Avoimet alueet generoidaan käyttäen saatuja koordinaatteja ja dist-arvoja
        //jonoissa.
        boolean[][] luola = l.getLuola();
        int luolaX = l.getX();
        int luolaY = l.getY();
        //Seuraavien taulukkojen arvot viittaavat koordinaatteihin, joista niille
        //annettujen koordinaattien käsittely on alkanut leveyssuuntaisessa
        //läpikäynnissä. Näiden ja dist-arvojen avulla lasketaan, miten laajalle
        //qX ja qY antamista koordinaateista avointa aluetta täytyy vähimmillään
        //generoida.
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
            //Jos x tai y arvo on luolan reunalla ja tämän viereisessä luolassa
            //on vastapuolella seinä, x y paikalle laitetaan seinä ja jatketaan
            //seuraavaan jonon arvoon.
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

            //Jos viereiset koordinaatit evät ole reunalla ja näitä ei ole vielä
            //käsitelty, ne lisätään generoitavien alueiden jonoon, jos niiden 
            //etäisyys pisteestä, josta ne ovat lähteneet on pienempi kuin nille
            //annettu dist-arvo tai, jos satunnaisluku saa sopivan arvon.
            if (x + 1 < size - 1 && !color[x + 1][y] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(4) < 1)) {
                color[x + 1][y] = true;
                aloitusX[x + 1][y] = aloitusX[x][y];
                qX.push(x + 1);
                qY.push(y);
                dist.push(d);
            }
            if (x - 1 > 0 && !color[x - 1][y] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(4) < 1)) {
                color[x - 1][y] = true;
                aloitusX[x - 1][y] = aloitusX[x][y];
                qX.push(x - 1);
                qY.push(y);
                dist.push(d);
            }
            if (y + 1 < size - 1 && !color[x][y + 1] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(4) < 1)) {
                color[x][y + 1] = true;
                aloitusX[x][y + 1] = aloitusX[x][y];
                qX.push(x);
                qY.push(y + 1);
                dist.push(d);
            }
            if (y - 1 > 0 && !color[x][y - 1] && (Matematiikka.hypotenuusanPituus(Math.abs(x - aloitusX[x][y]), Math.abs(y - aloitusY[x][y])) < d || random.nextInt(4) < 1)) {
                color[x][y - 1] = true;
                aloitusX[x][y - 1] = aloitusX[x][y];
                qX.push(x);
                qY.push(y - 1);
                dist.push(d);
            }
            color[x][y] = true;
        }
    }

    private void generoiReunat(Luola luola) {
        //Metodi poistaa reunojen kulmikkuuden lisäämälle seiniä reunoille 
        //satunnaisesti leveyssuuntaisella läpikäynnillä.
        boolean[][] color = new boolean[size][size];
        //Jonojen koordinaatteihin luodaan seinät.
        Jono qX = new Jono();
        Jono qY = new Jono();
        //Generoitavista seinistä täytyy tietää mitkä ovat yhteydessä toisiinsa,
        //jotta generointi ei tuki reittejä.
        UnionFind unionFind = new UnionFind();
        Piste[][] piste = new Piste[size][size];
        //Jos reunalla on seinä ja satunnaisluku saa sopivan arvon, reunan vierelle
        //luodaan seinä.
        if (!luola.getLuola()[1][0] && !luola.getLuola()[0][1] && luola.getLuola()[1][1]
                && !vieressaVanhojaSeinia(luola, color, 1, 1, 1, size - 2) && random.nextBoolean()) {
            qX.push(1);
            qY.push(1);
            color[1][1] = true;
            piste[1][1] = new Piste(1, 1);
            unionFind.makeSet(piste[1][1]);
            unionFind.union(piste[1][1], piste[1][0]);
            unionFind.union(piste[1][1], piste[0][1]);
        }
        if (!luola.getLuola()[size - 2][0] && !luola.getLuola()[size - 1][1] && luola.getLuola()[size - 2][1]
                && !vieressaVanhojaSeinia(luola, color, size - 2, 1, 1, size - 2) && random.nextBoolean()) {
            qX.push(size - 2);
            qY.push(1);
            color[size - 2][1] = true;
            piste[size - 2][1] = new Piste(size - 2, 1);
            unionFind.makeSet(piste[size - 2][1]);
            unionFind.union(piste[size - 2][1], piste[size - 2][0]);
            unionFind.union(piste[size - 2][1], piste[size - 1][1]);
        }
        if (!luola.getLuola()[size - 2][size - 1] && !luola.getLuola()[size - 1][size - 2]
                && luola.getLuola()[size - 2][size - 2] && !vieressaVanhojaSeinia(luola, color, size - 2, size - 2, 1, size - 2)
                && random.nextBoolean()) {
            qX.push(size - 2);
            qY.push(size - 2);
            color[size - 2][size - 2] = true;
            piste[size - 2][size - 2] = new Piste(size - 2, size - 2);
            unionFind.makeSet(piste[size - 2][size - 2]);
            unionFind.union(piste[size - 2][size - 2], piste[size - 2][size - 1]);
            unionFind.union(piste[size - 2][size - 2], piste[size - 1][size - 2]);
        }
        if (!luola.getLuola()[0][size - 2] && !luola.getLuola()[1][size - 1]
                && luola.getLuola()[1][size - 2] && !vieressaVanhojaSeinia(luola, color, 1, size - 2, 1, size - 2)
                && random.nextBoolean()) {
            qX.push(1);
            qY.push(size - 2);
            color[1][size - 2] = true;
            piste[1][size - 2] = new Piste(1, size - 2);
            unionFind.makeSet(piste[1][size - 2]);
            unionFind.union(piste[1][size - 2], piste[0][size - 2]);
            unionFind.union(piste[1][size - 2], piste[1][size - 1]);
        }
        for (int i = 2; i < size - 2; i++) {
            if (!luola.getLuola()[i][0] && luola.getLuola()[i][1]
                    && !vieressaVanhojaSeinia(luola, color, i, 1, 1, size - 2)
                    && random.nextBoolean()) {
                qX.push(i);
                qY.push(1);
                color[i][1] = true;
                piste[i][1] = new Piste(i, 1);
                unionFind.makeSet(piste[i][1]);
                if (piste[i - 1][1] != null) {
                    unionFind.union(piste[i][1], piste[i - 1][1]);
                }
            }
            if (!luola.getLuola()[size - 1][i] && luola.getLuola()[size - 2][i]
                    && !vieressaVanhojaSeinia(luola, color, size - 2, i, 1, size - 2)
                    && random.nextBoolean()) {
                qX.push(size - 2);
                qY.push(i);
                color[size - 2][i] = true;
                piste[size - 2][i] = new Piste(size - 2, i);
                unionFind.makeSet(piste[size - 2][i]);
                if (piste[size - 2][i - 1] != null) {
                    unionFind.union(piste[size - 2][i], piste[size - 2][i - 1]);
                }
            }
            if (!luola.getLuola()[0][i] && luola.getLuola()[1][i]
                    && !vieressaVanhojaSeinia(luola, color, 1, i, 1, size - 2)
                    && random.nextBoolean()) {
                qX.push(1);
                qY.push(i);
                color[1][i] = true;
                piste[1][i] = new Piste(1, i);
                unionFind.makeSet(piste[1][i]);
                if (piste[1][i - 1] != null) {
                    unionFind.union(piste[1][i], piste[1][i - 1]);
                }
            }
            if (!luola.getLuola()[i][size - 1] && luola.getLuola()[i][size - 2]
                    && !vieressaVanhojaSeinia(luola, color, i, size - 2, 1, size - 2)
                    && random.nextBoolean()) {
                qX.push(i);
                qY.push(size - 2);
                color[i][size - 2] = true;
                piste[i][size - 2] = new Piste(i, size - 2);
                unionFind.makeSet(piste[i][size - 2]);
                if (piste[i - 1][size - 2] != null) {
                    unionFind.union(piste[i][size - 2], piste[i - 1][size - 2]);
                }
            }
        }
        unionFind.union(piste[size - 3][1], piste[size - 2][1]);
        unionFind.union(piste[size - 3][size - 2], piste[size - 2][size - 2]);
        unionFind.union(piste[1][size - 3], piste[1][size - 2]);
        unionFind.union(piste[size - 2][size - 3], piste[size - 2][size - 2]);

        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            luola.getLuola()[x][y] = false;
            //Jos koordinaatin viereinen piste on avoimen reunan vieressä,
            //sitä ei lisätä jonoon. Muulloin, jos pisteen vieressä ei ole vanhoja
            //seiniä ja satunnaisluku saa sopivan arvon, piste lisätään jonoon.
            //Reunojen generointi ei siis voi tukkia yhtäkään reittiä.
            int findxy = unionFind.find(piste[x][y]);
            if (x + 1 <= size - 2
                    && (!vieressaVanhojaSeinia(luola, color, x + 1, y, 0, size - 1)
                    && !vieressaUusiaSeinia(x + 1, y, unionFind, piste, findxy))
                    && !color[x + 1][y] && random.nextInt(3) < 1) {
                qX.push(x + 1);
                qY.push(y);
                color[x + 1][y] = true;
                piste[x + 1][y] = new Piste(x + 1, y);
                unionFind.makeSet(piste[x + 1][y]);
                unionFind.union(piste[x][y], piste[x + 1][y]);
            }
            if (x - 1 >= 1
                    && (!vieressaVanhojaSeinia(luola, color, x - 1, y, 0, size - 1)
                    && !vieressaUusiaSeinia(x - 1, y, unionFind, piste, findxy))
                    && !color[x - 1][y] && random.nextInt(3) < 1) {
                qX.push(x - 1);
                qY.push(y);
                color[x - 1][y] = true;
                piste[x - 1][y] = new Piste(x - 1, y);
                unionFind.makeSet(piste[x - 1][y]);
                unionFind.union(piste[x][y], piste[x - 1][y]);
            }
            if (y + 1 <= size - 2
                    && (!vieressaVanhojaSeinia(luola, color, x, y + 1, 0, size - 1)
                    && !vieressaUusiaSeinia(x, y + 1, unionFind, piste, findxy))
                    && !color[x][y + 1] && random.nextInt(3) < 1) {
                qX.push(x);
                qY.push(y + 1);
                color[x][y + 1] = true;
                piste[x][y + 1] = new Piste(x, y + 1);
                unionFind.makeSet(piste[x][y + 1]);
                unionFind.union(piste[x][y], piste[x][y + 1]);
            }
            if (y - 1 >= 1
                    && (!vieressaVanhojaSeinia(luola, color, x, y - 1, 0, size - 1)
                    && !vieressaUusiaSeinia(x, y - 1, unionFind, piste, findxy))
                    && !color[x][y - 1] && random.nextInt(3) < 1) {
                qX.push(x);
                qY.push(y - 1);
                color[x][y - 1] = true;
                piste[x][y - 1] = new Piste(x, y - 1);
                unionFind.makeSet(piste[x][y - 1]);
                unionFind.union(piste[x][y], piste[x][y - 1]);
            }
        }
    }

    private boolean vieressaUusiaSeinia(int x, int y, UnionFind unionFind, Piste[][] pisteet, int findxy) {
        if (x > 0) {
            if (y > 0) {
                if (pisteet[x - 1][y - 1] != null && findxy
                        != unionFind.find(pisteet[x - 1][y - 1])) {
                    return true;
                }
            }
            if (pisteet[x - 1][y] != null && findxy
                    != unionFind.find(pisteet[x - 1][y])) {
                return true;
            }
            if (y < size - 1) {
                if (pisteet[x - 1][y + 1] != null && findxy
                        != unionFind.find(pisteet[x - 1][y + 1])) {
                    return true;
                }
            }
        }
        if (y > 0) {
            if (pisteet[x][y - 1] != null && findxy
                    != unionFind.find(pisteet[x][y - 1])) {
                return true;
            }
        }
        if (y < size - 1) {
            if (pisteet[x][y + 1] != null && findxy
                    != unionFind.find(pisteet[x][y + 1])) {
                return true;
            }
        }
        if (x < size - 1) {
            if (y > 0) {
                if (pisteet[x + 1][y - 1] != null && findxy
                        != unionFind.find(pisteet[x + 1][y - 1])) {
                    return true;
                }
            }
            if (pisteet[x + 1][y] != null && findxy
                    != unionFind.find(pisteet[x + 1][y])) {
                return true;
            }
            if (y < size - 1) {
                if (pisteet[x + 1][y + 1] != null && findxy
                        != unionFind.find(pisteet[x + 1][y + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean vieressaVanhojaSeinia(Luola luola, boolean[][] color, int x, int y, int min, int max) {
        //Jos pisteen x y vieressä tai kulmassa on vanha seinä x:n ja y:n min ja 
        //max arvojen rajaamalla alueella metodi palauttaa true, muulloin false.
        if (x - 1 >= min) {
            if (y - 1 >= min) {
                if (!luola.getLuola()[x - 1][y - 1] && !color[x - 1][y - 1]) {
                    return true;
                }
            }
            if (!luola.getLuola()[x - 1][y] && !color[x - 1][y]) {
                return true;
            }
            if (y + 1 <= max) {
                if (!luola.getLuola()[x - 1][y + 1] && !color[x - 1][y + 1]) {
                    return true;
                }
            }
        }
        if (y - 1 >= min) {
            if (!luola.getLuola()[x][y - 1] && !color[x][y - 1]) {
                return true;
            }
        }
        if (y + 1 <= max) {
            if (!luola.getLuola()[x][y + 1] && !color[x][y + 1]) {
                return true;
            }
        }
        if (x + 1 <= max) {
            if (y - 1 >= min) {
                if (!luola.getLuola()[x + 1][y - 1] && !color[x + 1][y - 1]) {
                    return true;
                }
            }
            if (!luola.getLuola()[x + 1][y] && !color[x + 1][y]) {
                return true;
            }
            if (y + 1 <= max) {
                if (!luola.getLuola()[x + 1][y + 1] && !color[x + 1][y + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
