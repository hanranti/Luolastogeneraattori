package luolasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hannu
 */
public class LuolaTest {
private Luolageneraattori luolageneraattori;
    public LuolaTest() {
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
    public void testLuola() {
        Luolasto luolasto = new Luolasto(10);
        this.luolageneraattori = new Luolageneraattori(luolasto, 10);
        Luola luola = new Luola(luolasto, 5, 5, 10);
        assertEquals(10, luola.getLuola().length);
        assertEquals(10, luola.getLuola()[0].length);
        luola = new Luola(luolasto, 5, 5, 32);
        assertEquals(32, luola.getLuola().length);
        assertEquals(32, luola.getLuola()[0].length);
    }

    @Test
    public void sisaltaaUloskaynnin() {
        Luolasto luolasto = new Luolasto(32);
        this.luolageneraattori = new Luolageneraattori(luolasto, 32);
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
}
