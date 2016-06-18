package luolasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testGeneroi() {
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
    public void sisaltaaUloskaynnin() {
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

}
