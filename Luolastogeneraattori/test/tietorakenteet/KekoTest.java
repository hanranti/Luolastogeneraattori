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
public class KekoTest {

    private Keko keko;

    public KekoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        keko = new Keko();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsertJuuriJaPoistaJuuri() {
        assertEquals(null, keko.juuri());
        assertEquals(null, keko.poistaJuuri());
        keko.insert("A", 5);
        assertTrue(keko.juuri().equals("A"));
        assertTrue(keko.poistaJuuri().equals("A"));
        keko.insert("dsa", 4);
        assertTrue(keko.juuri().equals("A"));
        keko.insert(123, 6);
        assertEquals(123, keko.juuri());
        keko.insert(67, 7);
        assertEquals(67, keko.juuri());
        assertEquals(67, keko.poistaJuuri());
        assertEquals(123, keko.poistaJuuri());
        assertEquals("A", keko.poistaJuuri());
        assertEquals("dsa", keko.poistaJuuri());
    }

    @Test
    public void testInsertJuuriJaPoistaJuuri2() {System.out.println("testinsertjuurijapoistajuuri2");
        keko.insert(0, 0);
        keko.insert(1, 1);
        keko.insert(2, 2);
        keko.insert(3, 3);
        keko.insert(4, 4);
        keko.insert(5, 5);
        keko.insert(6, 6);
        keko.insert(7, 7);
        keko.insert(8, 8);
        keko.insert(9, 9);
        keko.insert(10, 10);
        keko.insert(11, 11);
        keko.insert(12, 12);
        keko.insert(13, 13);
        keko.insert(14, 14);
        keko.insert(15, 15);
        keko.insert(16, 16);
        keko.insert(17, 17);
        keko.insert(18, 18);
        keko.insert(19, 19);
        keko.insert(20, 20);
        keko.insert(21, 21);
        keko.insert(22, 22);
        keko.insert(23, 23);
        keko.insert(24, 24);
        keko.insert(25, 25);
        
        assertEquals(25, keko.juuri());
        assertFalse((int) keko.juuri() == 0);

        assertEquals(25, keko.poistaJuuri());
        assertEquals(24, keko.poistaJuuri());
        assertEquals(23, keko.poistaJuuri());
        assertEquals(22, keko.poistaJuuri());
        assertEquals(21, keko.poistaJuuri());
        assertEquals(20, keko.poistaJuuri());
        assertEquals(19, keko.poistaJuuri());
        assertEquals(18, keko.poistaJuuri());
        assertEquals(17, keko.poistaJuuri());
        assertEquals(16, keko.poistaJuuri());
        assertEquals(15, keko.poistaJuuri());
        assertEquals(14, keko.poistaJuuri());
        assertEquals(13, keko.poistaJuuri());
        assertEquals(12, keko.poistaJuuri());
        assertEquals(11, keko.poistaJuuri());
        assertEquals(10, keko.poistaJuuri());
        assertEquals(9, keko.poistaJuuri());
        assertEquals(8, keko.poistaJuuri());
        assertEquals(7, keko.poistaJuuri());
        assertEquals(6, keko.poistaJuuri());
        assertEquals(5, keko.poistaJuuri());
        assertEquals(4, keko.poistaJuuri());
        assertEquals(3, keko.poistaJuuri());
        assertEquals(2, keko.poistaJuuri());
        assertEquals(1, keko.poistaJuuri());
        assertEquals(0, keko.poistaJuuri());
    }
}
