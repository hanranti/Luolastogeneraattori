package suorituskykytestaus.luolasto;

import luolasto.Luola;
import luolasto.Luolageneraattori;
import luolasto.Luolasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hanranti
 */
public class LuolaogeneraattoriSuorituskykyTest {

    private Luolageneraattori luolageneraattori32;
    private Luolasto luolasto32;
    private Luolageneraattori luolageneraattori50;
    private Luolasto luolasto50;
    private Luolageneraattori luolageneraattori100;
    private Luolasto luolasto100;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luolasto32 = new Luolasto(32, 0);
        luolageneraattori32 = new Luolageneraattori(luolasto32, 32, 0);
        luolasto50 = new Luolasto(50, 0);
        luolageneraattori50 = new Luolageneraattori(luolasto50, 50, 0);
        luolasto100 = new Luolasto(100, 0);
        luolageneraattori100 = new Luolageneraattori(luolasto100, 100, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGeneroiLuolanKoolla32() {
        System.out.println("testGeneroiLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < 10000; i++) {
            long alku = System.nanoTime();
            luolageneraattori32.generoi(new Luola(luolasto32, 5, 5, 32));
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= 10000;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiLuolanKoolla50() {
        System.out.println("testGeneroiLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < 10000; i++) {
            long alku = System.nanoTime();
            luolageneraattori50.generoi(new Luola(luolasto50, 5, 5, 50));
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= 10000;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiLuolanKoolla100() {
        System.out.println("testGeneroiLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < 10000; i++) {
            long alku = System.nanoTime();
            luolageneraattori100.generoi(new Luola(luolasto100, 5, 5, 100));
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= 10000;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }
}
