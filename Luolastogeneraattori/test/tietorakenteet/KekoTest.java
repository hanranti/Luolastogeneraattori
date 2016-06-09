package tietorakenteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tyokalut.FieldAccess;

/**
 *
 * @author hanranti
 */
public class KekoTest {

    private Keko maksimikeko;
    private Keko minimikeko;

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
        maksimikeko = new Keko(true);
        minimikeko = new Keko(false);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsertJuuriJaPoistaJuuriMaksimiKeossa() {
        assertEquals(null, maksimikeko.juuri());
        assertEquals(null, maksimikeko.poistaJuuri());
        maksimikeko.insert("A", 5);
        assertTrue(maksimikeko.juuri().equals("A"));
        testKekoJarjestyksessa(maksimikeko);
        assertTrue(maksimikeko.poistaJuuri().equals("A"));
        maksimikeko.insert("dsa", 4);
        testKekoJarjestyksessa(maksimikeko);
//        assertTrue(maksimikeko.juuri().equals("A"));
        maksimikeko.insert(123, 6);
        testKekoJarjestyksessa(maksimikeko);
        assertEquals(123, maksimikeko.juuri());
        maksimikeko.insert(67, 7);
        testKekoJarjestyksessa(maksimikeko);
        assertEquals(67, maksimikeko.juuri());
        assertEquals(67, maksimikeko.poistaJuuri());
        testKekoJarjestyksessa(maksimikeko);
        assertEquals(123, maksimikeko.poistaJuuri());
        testKekoJarjestyksessa(maksimikeko);
        assertEquals("A", maksimikeko.poistaJuuri());
        testKekoJarjestyksessa(maksimikeko);
        assertEquals("dsa", maksimikeko.poistaJuuri());
        testKekoJarjestyksessa(maksimikeko);
    }

    @Test
    public void testInsertJuuriJaPoistaJuuriMaksimikeossa2() {
        System.out.println("testinsertjuurijapoistajuuri2");
        maksimikeko.insert(0, 0);
        maksimikeko.insert(1, 1);
        maksimikeko.insert(2, 2);
        maksimikeko.insert(3, 3);
        maksimikeko.insert(4, 4);
        maksimikeko.insert(5, 5);
        maksimikeko.insert(6, 6);
        maksimikeko.insert(7, 7);
        maksimikeko.insert(8, 8);
        maksimikeko.insert(9, 9);
        maksimikeko.insert(10, 10);
        maksimikeko.insert(11, 11);
        maksimikeko.insert(12, 12);
        maksimikeko.insert(13, 13);
        maksimikeko.insert(14, 14);
        maksimikeko.insert(15, 15);
        maksimikeko.insert(16, 16);
        maksimikeko.insert(17, 17);
        maksimikeko.insert(18, 18);
        maksimikeko.insert(19, 19);
        maksimikeko.insert(20, 20);
        maksimikeko.insert(21, 21);
        maksimikeko.insert(22, 22);
        maksimikeko.insert(23, 23);
        maksimikeko.insert(24, 24);
        maksimikeko.insert(25, 25);

        assertEquals(25, maksimikeko.juuri());
        assertFalse((int) maksimikeko.juuri() == 0);

        testKekoJarjestyksessa(maksimikeko);

        assertEquals(25, maksimikeko.poistaJuuri());
        assertEquals(24, maksimikeko.poistaJuuri());
        assertEquals(23, maksimikeko.poistaJuuri());
        assertEquals(22, maksimikeko.poistaJuuri());
        assertEquals(21, maksimikeko.poistaJuuri());
        assertEquals(20, maksimikeko.poistaJuuri());
        assertEquals(19, maksimikeko.poistaJuuri());
        assertEquals(18, maksimikeko.poistaJuuri());
        assertEquals(17, maksimikeko.poistaJuuri());
        assertEquals(16, maksimikeko.poistaJuuri());
        assertEquals(15, maksimikeko.poistaJuuri());
        assertEquals(14, maksimikeko.poistaJuuri());
        assertEquals(13, maksimikeko.poistaJuuri());
        assertEquals(12, maksimikeko.poistaJuuri());
        assertEquals(11, maksimikeko.poistaJuuri());
        assertEquals(10, maksimikeko.poistaJuuri());
        assertEquals(9, maksimikeko.poistaJuuri());
        assertEquals(8, maksimikeko.poistaJuuri());
        assertEquals(7, maksimikeko.poistaJuuri());
        assertEquals(6, maksimikeko.poistaJuuri());
        assertEquals(5, maksimikeko.poistaJuuri());
        assertEquals(4, maksimikeko.poistaJuuri());
        assertEquals(3, maksimikeko.poistaJuuri());
        assertEquals(2, maksimikeko.poistaJuuri());
        assertEquals(1, maksimikeko.poistaJuuri());
        assertEquals(0, maksimikeko.poistaJuuri());
    }

    private void testKekoJarjestyksessa(Keko keko) {
        Object[] taulukko = (Object[]) FieldAccess.getField(keko, "taulukko");
        int size = (int) FieldAccess.getField(keko, "size");
        assertNull(taulukko[0]);
        for (int i = 1; i < size; i++) {
            if (i > 1) {
                assertTrue((int) taulukko[i] < (int) taulukko[i / 2]);
            }
            if (i * 2 < size) {
                assertTrue((int) taulukko[i] > (int) taulukko[i * 2]);
            }
            if ((i * 2) + 1 < size) {
                assertTrue((int) taulukko[i] > (int) taulukko[(i * 2) + 1]);
            }
        }
    }
}
