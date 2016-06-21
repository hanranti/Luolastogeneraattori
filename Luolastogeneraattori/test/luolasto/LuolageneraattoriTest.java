package luolasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.Jono;
import tietorakenteet.Lista;
import tietorakenteet.Piste;

/**
 *
 * @author hanranti
 */
public class LuolageneraattoriTest {

    private Luolageneraattori luolageneraattori;

    public LuolageneraattoriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLength() {
        Luolasto luolasto = new Luolasto(50, 0);
        this.luolageneraattori = new Luolageneraattori(luolasto, 50, 0);
        Luola luola = new Luola(luolasto, 5, 5, 50);
        assertEquals(50, luola.getLuola().length);
        assertEquals(50, luola.getLuola()[0].length);
        luola = new Luola(luolasto, 5, 5, 32);
        assertEquals(32, luola.getLuola().length);
        assertEquals(32, luola.getLuola()[0].length);
    }

    @Test
    public void testSisaltaaUloskaynnin() {
        for (int i = 0; i < 100; i++) {
            sisaltaaUloskaynnin();
        }
    }

    private void sisaltaaUloskaynnin() {
        Luolasto luolasto = new Luolasto(32, 0);
        this.luolageneraattori = new Luolageneraattori(luolasto, 32, 0);
        boolean sisaltaaUloskaynnin = false;
        Luola luola = new Luola(luolasto, 5, 5, 32);
        luolageneraattori.generoi(luola);
        boolean[][] taulukko = luola.getLuola();
        for (int j = 0; j < taulukko.length; j++) {
            if (!taulukko[0][j]) {
                sisaltaaUloskaynnin = true;
                break;
            }
            if (!taulukko[j][0]) {
                sisaltaaUloskaynnin = true;
                break;
            }
            if (!taulukko[taulukko.length - 1][j]) {
                sisaltaaUloskaynnin = true;
                break;
            }
            if (!taulukko[j][taulukko[0].length - 1]) {
                sisaltaaUloskaynnin = true;
                break;
            }
        }
        assertTrue(sisaltaaUloskaynnin);
    }

    @Test
    public void testkaikkienUloskayntienJaReittienValillaOnPolut() {
        for (int i = 0; i < 100; i++) {
            kaikkienUloskayntienJaReittienValillaOnPolut(32);
            kaikkienUloskayntienJaReittienValillaOnPolut(50);
            kaikkienUloskayntienJaReittienValillaOnPolut(100);
        }
    }

    private void kaikkienUloskayntienJaReittienValillaOnPolut(int size) {
        Luolasto luolasto = new Luolasto(size, 0);
        luolageneraattori = new Luolageneraattori(luolasto, size, 0);
        Luola luola = new Luola(luolasto, 5, 5, size);
        luolageneraattori.generoi(luola);
        char[][] asd = new char[size][size];
        for (int i = 0; i < luola.getLuola()[0].length; i++) {
            for (int j = 0; j < luola.getLuola().length; j++) {
                if (luola.getLuola()[j][i]) {
                    System.out.print(" ");
                } else {
                    System.out.print("x");
                }
                asd[j][i] = ' ';
            }
            System.out.println("");
        }
        Lista huoneet = luola.getHuoneet();
        boolean[] kayty = new boolean[huoneet.getKoko()];
        Jono qX = new Jono();
        Jono qY = new Jono();
        boolean[][] color = new boolean[size][size];
        Piste p = (Piste) huoneet.get(0);
        qX.push(p.getX());
        qY.push(p.getY());
        color[p.getX()][p.getY()] = true;

        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            asd[x][y] = 'k';
            int i = 0;
            while (i < huoneet.getKoko()) {
                Piste huone = (Piste) huoneet.get(i);
                if (huone.getX() == x && huone.getY() == y) {
                    kayty[i] = true;
                }
                i++;
            }
            if (x + 1 < size && luola.getLuola()[x + 1][y] && !color[x + 1][y]) {
                qX.push(x + 1);
                qY.push(y);
                color[x + 1][y] = true;
            }
            if (y + 1 < size && luola.getLuola()[x][y + 1] && !color[x][y + 1]) {
                qX.push(x);
                qY.push(y + 1);
                color[x][y + 1] = true;
            }
            if (x - 1 >= 0 && luola.getLuola()[x - 1][y] && !color[x - 1][y]) {
                qX.push(x - 1);
                qY.push(y);
                color[x - 1][y] = true;
            }
            if (y - 1 >= 0 && luola.getLuola()[x][y - 1] && !color[x][y - 1]) {
                qX.push(x);
                qY.push(y - 1);
                color[x][y - 1] = true;
            }
        }
        for (int i = 0; i < asd[0].length; i++) {
            for (int j = 0; j < asd.length; j++) {
                System.out.print(asd[j][i]);
            }
            System.out.println("");
        }
        boolean kaikkiinReitit = true;
        for (int i = 0; i < kayty.length; i++) {
            System.out.println("i " + i);
            Piste a = (Piste) huoneet.get(i);
            System.out.println(a.getX() + " " + a.getY());
            if (!kayty[i]) {
                kaikkiinReitit = false;
                break;
            }
        }
        assertTrue(kaikkiinReitit);
    }
}
