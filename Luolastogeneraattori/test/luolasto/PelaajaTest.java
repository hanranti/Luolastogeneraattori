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
public class PelaajaTest {

    private Pelaaja pelaaja;
    private Luolasto luolasto;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luolasto = new Luolasto(32, 0);
        pelaaja = new Pelaaja(5, 5, luolasto, 32);
        luolasto.genertoiLuola(5, 5);
    }

    @After
    public void tearDown() {
    }

    private void poistaSeinat(Luola luola) {
        boolean[][] t = luola.getLuola();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = true;
            }
        }
    }

    @Test
    public void testLiikuta() {
        poistaSeinat(luolasto.getLuola(5, 5));
        assertEquals(pelaaja.getX(), 5);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaOikealle();
        assertEquals(pelaaja.getX(), 6);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaAlas();
        assertEquals(pelaaja.getX(), 6);
        assertEquals(pelaaja.getY(), 6);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 5);
        assertEquals(pelaaja.getY(), 6);
        pelaaja.liikutaYlos();
        assertEquals(pelaaja.getX(), 5);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 4);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 3);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 2);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 1);
        assertEquals(pelaaja.getY(), 5);
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 0);
        assertEquals(pelaaja.getY(), 5);
        luolasto.genertoiLuola(4, 5);
        poistaSeinat(luolasto.getLuola(4, 5));
        pelaaja.liikutaVasemmalle();
        assertEquals(pelaaja.getX(), 9);
        assertEquals(pelaaja.getY(), 5);
        assertEquals(pelaaja.getLuolaX(), 4);
        assertEquals(pelaaja.getLuolaY(), 5);
    }

    @Test
    public void testSeinat() {
        poistaSeinat(luolasto.getLuola(5, 5));
        boolean[][] t = luolasto.getLuola(5, 5).getLuola();
        t[4][5] = false;
        t[6][5] = false;
        t[5][4] = false;
        t[5][6] = false;
        pelaaja.liikutaVasemmalle();
        assertEquals(5, pelaaja.getX());
        pelaaja.liikutaOikealle();
        assertEquals(5, pelaaja.getX());
        pelaaja.liikutaAlas();
        assertEquals(5, pelaaja.getY());
        pelaaja.liikutaYlos();
        assertEquals(5, pelaaja.getY());
    }
}
