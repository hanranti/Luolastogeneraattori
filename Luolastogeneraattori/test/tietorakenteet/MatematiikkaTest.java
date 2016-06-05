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
public class MatematiikkaTest {

    public MatematiikkaTest() {
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
    public void testHypotenuusanPituus() {
        assertEquals(1, (int) Matematiikka.hypotenuusanPituus(1, 1));
        assertEquals(2, (int) Matematiikka.hypotenuusanPituus(2, 1));
        assertEquals(2, (int) Matematiikka.hypotenuusanPituus(2, 2));
        assertEquals(4, (int) Matematiikka.hypotenuusanPituus(3, 3));
        assertEquals(5, (int) Matematiikka.hypotenuusanPituus(4, 4));
        assertEquals(4, (int) Matematiikka.hypotenuusanPituus(4, 2));
    }

}
