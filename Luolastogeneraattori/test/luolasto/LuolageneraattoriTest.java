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
import tietorakenteet.Solmu;

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
    public void testSisaltaaUloskaynnin() {
        for (int i = 0; i < 100; i++) {
            sisaltaaUloskaynnin();
        }
    }

    private void sisaltaaUloskaynnin() {
        Luolasto luolasto = new Luolasto(32, 0);
        this.luolageneraattori = new Luolageneraattori(luolasto, 0);
        boolean sisaltaaUloskaynnin = false;
        Luola luola = new Luola(luolasto, 5, 5);
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
    public void testkaikkienUloskayntienValillaOnPolut() {
        for (int i = 0; i < 50; i++) {
            kaikkienUloskayntienValillaOnPolut(32);
            kaikkienUloskayntienValillaOnPolut(50);
            kaikkienUloskayntienValillaOnPolut(100);
            kaikkienUloskayntienValillaOnPolut(200);
        }
    }

    private void kaikkienUloskayntienValillaOnPolut(int size) {
        Luolasto luolasto = new Luolasto(size, 0);
        luolageneraattori = new Luolageneraattori(luolasto, 0);
        Luola luola = new Luola(luolasto, 5, 5);
        luolageneraattori.generoi(luola);
        Lista huoneet = luola.getHuoneet();
        boolean[][] pisteet = new boolean[size][size];
        Solmu s = huoneet.getFirst();
        while (s!=null) {
            Piste h = (Piste) s.getObject();
            pisteet[h.getX()][h.getY()] = true;
            s = s.getOikea();
        }
        Jono qX = new Jono();
        Jono qY = new Jono();
        boolean[][] color = new boolean[size][size];
        int o = 0;
        Piste p = (Piste) huoneet.get(o);
        while (!luola.getLuola()[p.getX()][p.getY()]) {
            o++;
            p = (Piste) huoneet.get(o);
        }
        qX.push(p.getX());
        qY.push(p.getY());
        color[p.getX()][p.getY()] = true;

        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            pisteet[x][y] = false;
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
        for (int i = 0; i < size; i++) {
            assertFalse(pisteet[i][0]);
            assertFalse(pisteet[i][size - 1]);
            assertFalse(pisteet[0][i]);
            assertFalse(pisteet[size - 1][i]);
        }
    }
}
