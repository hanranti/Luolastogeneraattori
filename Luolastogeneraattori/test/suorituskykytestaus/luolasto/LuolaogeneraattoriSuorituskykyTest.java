package suorituskykytestaus.luolasto;

import java.util.Random;
import luolasto.Luola;
import luolasto.Luolageneraattori;
import luolasto.Luolasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tietorakenteet.Jono;

/**
 *
 * @author hanranti
 */
public class LuolaogeneraattoriSuorituskykyTest {

    private Random random;
    private Luolageneraattori luolageneraattori32;
    private Luolasto luolasto32;
    private Luolageneraattori luolageneraattori50;
    private Luolasto luolasto50;
    private Luolageneraattori luolageneraattori100;
    private Luolasto luolasto100;
    private Luolageneraattori luolageneraattori200;
    private Luolasto luolasto200;
    private int maara;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        random = new Random();
        luolasto32 = new Luolasto(32, 0);
        luolageneraattori32 = new Luolageneraattori(luolasto32, 0);
        luolasto50 = new Luolasto(50, 0);
        luolageneraattori50 = new Luolageneraattori(luolasto50, 0);
        luolasto100 = new Luolasto(100, 0);
        luolageneraattori100 = new Luolageneraattori(luolasto100, 0);
        luolasto200 = new Luolasto(200, 0);
        luolageneraattori200 = new Luolageneraattori(luolasto200, 0);
        maara = 1000000;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGeneroiLuolanKoolla32() {
        System.out.println("testGeneroiLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto32, 5, 5);
            long alku = System.nanoTime();
            luolageneraattori32.generoi(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testGeneroiLuolanKoolla50() {
        System.out.println("testGeneroiLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto50, 5, 5);
            long alku = System.nanoTime();
            luolageneraattori50.generoi(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testGeneroiLuolanKoolla100() {
        System.out.println("testGeneroiLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            long alku = System.nanoTime();
            luolageneraattori100.generoi(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testGeneroiLuolanKoolla200() {
        System.out.println("testGeneroiLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            long alku = System.nanoTime();
            luolageneraattori200.generoi(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoHuoneetLuolanKoolla32() {
        System.out.println("testLuoHuoneetLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            int s = random.nextInt(8) + 1;
            int m = 32;
            m /= 10;
            m *= s;
            m++;
            Luola luola = new Luola(luolasto32, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori32.luoHuoneet(luola, j1, j2, j3, m);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoHuoneetLuolanKoolla50() {
        System.out.println("testLuoHuoneetLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            int s = random.nextInt(8) + 1;
            int m = 50;
            m /= 10;
            m *= s;
            m++;
            Luola luola = new Luola(luolasto50, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori50.luoHuoneet(luola, j1, j2, j3, m);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoHuoneetLuolanKoolla100() {
        System.out.println("testLuoHuoneetLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            int s = random.nextInt(8) + 1;
            int m = 100;
            m /= 10;
            m *= s;
            m++;
            Luola luola = new Luola(luolasto100, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori100.luoHuoneet(luola, j1, j2, j3, m);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoHuoneetLuolanKoolla200() {
        System.out.println("testLuoHuoneetLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            int s = random.nextInt(8) + 1;
            int m = 200;
            m /= 10;
            m *= s;
            m++;
            Luola luola = new Luola(luolasto200, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori200.luoHuoneet(luola, j1, j2, j3, m);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoUloskaynnitLuolanKoolla32() {
        System.out.println("testLuoUlosKaynnitLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto32, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori32.luoUloskaynnit(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoUloskaynnitLuolanKoolla150() {
        System.out.println("testLuoUlosKaynnitLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto50, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori50.luoUloskaynnit(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoUloskaynnitLuolanKoolla100() {
        System.out.println("testLuoUlosKaynnitLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori100.luoUloskaynnit(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoUloskaynnitLuolanKoolla200() {
        System.out.println("testLuoUlosKaynnitLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto200, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            long alku = System.nanoTime();
            luolageneraattori200.luoUloskaynnit(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoKaytavatLuolanKoolla32() {
        System.out.println("testLuoKaytavatLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto32, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 32;
            m /= 10;
            m *= s;
            m++;
            luolageneraattori32.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori32.luoUloskaynnit(luola, j3, j3, j3);
            long alku = System.nanoTime();
            luolageneraattori32.luoKaytavat(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoKaytavatLuolanKoolla50() {
        System.out.println("testLuoKaytavatLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto50, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 50;
            m /= 10;
            m *= s;
            m++;
            luolageneraattori50.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori50.luoUloskaynnit(luola, j3, j3, j3);
            long alku = System.nanoTime();
            luolageneraattori50.luoKaytavat(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoKaytavatLuolanKoolla100() {
        System.out.println("testLuoKaytavatLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 100;
            m /= 10;
            m *= s;
            m++;
            luolageneraattori100.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori100.luoUloskaynnit(luola, j3, j3, j3);
            long alku = System.nanoTime();
            luolageneraattori100.luoKaytavat(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }

    @Test
    public void testLuoKaytavatLuolanKoolla200() {
        System.out.println("testLuoKaytavatLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto200, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 200;
            m /= 10;
            m *= s;
            m++;
            luolageneraattori200.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori200.luoUloskaynnit(luola, j3, j3, j3);
            long alku = System.nanoTime();
            luolageneraattori200.luoKaytavat(luola, j1, j2, j3);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiAvoimetAlueetLuolanKoolla32() {
        System.out.println("testGeneroiAvoimetAlueetLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto32, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 32;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori32.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori32.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori32.luoKaytavat(luola, j1, j2, j3);
            long alku = System.nanoTime();
            luolageneraattori32.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiAvoimetAlueetLuolanKoolla50() {
        System.out.println("testGeneroiAvoimetAlueetLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto50, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 50;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori50.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori50.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori50.luoKaytavat(luola, j1, j2, j3);
            long alku = System.nanoTime();
            luolageneraattori50.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }
@Test
    public void testGeneroiAvoimetAlueetLuolanKoolla100() {
        System.out.println("testGeneroiAvoimetAlueetLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 100;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori100.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori100.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori100.luoKaytavat(luola, j1, j2, j3);
            long alku = System.nanoTime();
            luolageneraattori100.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }
    @Test
    public void testGeneroiAvoimetAlueetLuolanKoolla200() {
        System.out.println("testGeneroiAvoimetAlueetLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto200, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 200;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori200.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori200.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori200.luoKaytavat(luola, j1, j2, j3);
            long alku = System.nanoTime();
            luolageneraattori200.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiReunatLuolanKoolla32() {
        System.out.println("testGeneroiReunatLuolanKoolla32");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto32, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 32;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori32.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori32.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori32.luoKaytavat(luola, j1, j2, j3);
            luolageneraattori32.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long alku = System.nanoTime();
            luolageneraattori32.generoiReunat(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiReunatLuolanKoolla50() {
        System.out.println("testGeneroiReunatLuolanKoolla50");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto50, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 50;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori50.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori50.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori50.luoKaytavat(luola, j1, j2, j3);
            luolageneraattori50.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long alku = System.nanoTime();
            luolageneraattori50.generoiReunat(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiReunatLuolanKoolla100() {
        System.out.println("testGeneroiReunatLuolanKoolla100");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto100, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 100;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori100.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori100.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori100.luoKaytavat(luola, j1, j2, j3);
            luolageneraattori100.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long alku = System.nanoTime();
            luolageneraattori100.generoiReunat(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }@Test
    public void testGeneroiReunatLuolanKoolla200() {
        System.out.println("testGeneroiReunatLuolanKoolla200");
        long keskiarvo = 0;
        for (int i = 0; i < maara; i++) {
            Luola luola = new Luola(luolasto200, 5, 5);
            Jono j1 = new Jono();
            Jono j2 = new Jono();
            Jono j3 = new Jono();
            int s = random.nextInt(8) + 1;
            int m = 200;
            m /= 10;
            int m2 = m;
            m *= s;
            m2 *= (10 - s);
            m++;
            luolageneraattori200.luoHuoneet(luola, j1, j2, j3, m);
            luolageneraattori200.luoUloskaynnit(luola, j3, j3, j3);
            luolageneraattori200.luoKaytavat(luola, j1, j2, j3);
            luolageneraattori200.generoiAvoimetAlueet(luola, j1, j2, j3, m2);
            long alku = System.nanoTime();
            luolageneraattori200.generoiReunat(luola);
            long loppu = System.nanoTime();
            keskiarvo += (loppu - alku);
        }
        keskiarvo /= maara;
        System.out.println("Keskiarvo: " + keskiarvo + "ns");
    }
}
