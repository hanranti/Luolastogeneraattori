package luolastogeneraattori;

import luolasto.Luola;
import luolasto.Luolasto;
import luolasto.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.Jono;
import tyokalut.FieldAccess;

/**
 *
 * @author hanranti
 */
public class LuolastogeneraattoriTest {

    private Luolastogeneraattori luolastogeneraattori;

    public LuolastogeneraattoriTest() {
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
    public void testAsetaPelaajaLuolaanAsettaaPelaajanKoordinaatteihinJoistaOnReittiKaikkiinUloskaynteihin() {
        for (int i = 0; i < 50; i++) {
            int size = 32;
            luolastogeneraattori = new Luolastogeneraattori(32, 0);
            Pelaaja p = (Pelaaja) FieldAccess.getField(luolastogeneraattori, "pelaaja");
            Luolasto luolasto = (Luolasto) FieldAccess.getField(luolastogeneraattori, "luolasto");
            Luola luola = luolasto.getLuola(5, 5);

            Jono qX = new Jono();
            Jono qY = new Jono();
            boolean[][] color = new boolean[size][size];
            boolean[][] pisteet = new boolean[size][size];
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
            for (int j = 0; j < size; j++) {
                assertFalse(pisteet[j][0]);
                assertFalse(pisteet[j][size - 1]);
                assertFalse(pisteet[0][j]);
                assertFalse(pisteet[size - 1][j]);
            }
        }
    }

}
