package tietorakenteet;

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
public class KaariTest {

    private Kaari kaari;

    public KaariTest() {
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
    public void testKaari() {
        Piste p1 = new Piste(1, 1);
        Piste p2 = new Piste(2, 3);
        kaari = new Kaari(p1, p2, 7);
        assertEquals(p1, kaari.getO1());
        assertEquals(p2, kaari.getO2());
        assertEquals(7, kaari.getLength());
    }

}
