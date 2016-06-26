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

    private Luolasto luolasto;
    private Luola luola;

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
        luolasto = new Luolasto(22, 0);
        luola = new Luola(luolasto, 1, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLuola() {
        assertEquals(1, luola.getX());
        assertEquals(2, luola.getY());
        assertEquals(22, luola.getLuola().length);
        assertEquals(22, luola.getLuola()[0].length);
    }

    @Test
    public void testHuoneet() {
        assertTrue(luola.getHuoneet().getKoko() == 0);
        Luolageneraattori luolageneraattori = new Luolageneraattori(luolasto, 0);
        luolageneraattori.generoi(luola);
        assertTrue(luola.getHuoneet().getKoko() > 0);
    }
}
