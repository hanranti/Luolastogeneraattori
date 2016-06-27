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
        maksimikeko.insert("dsa", 4);
        testKekoJarjestyksessa(maksimikeko);
        assertTrue(maksimikeko.juuri().equals("A"));
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

    @Test
    public void testInsertJuuriJaPoistaJuuriMinimiKeossa() {
        assertEquals(null, minimikeko.juuri());
        assertEquals(null, minimikeko.poistaJuuri());
        minimikeko.insert("A", 5);
        assertTrue(minimikeko.juuri().equals("A"));
        testKekoJarjestyksessa(minimikeko);
        minimikeko.insert("dsa", 4);
        testKekoJarjestyksessa(minimikeko);
        assertTrue(minimikeko.juuri().equals("dsa"));
        minimikeko.insert(123, 6);
        testKekoJarjestyksessa(minimikeko);
        assertEquals("dsa", minimikeko.juuri());
        minimikeko.insert(67, 3);
        testKekoJarjestyksessa(minimikeko);
        assertEquals(67, minimikeko.juuri());
        assertEquals(67, minimikeko.poistaJuuri());
        testKekoJarjestyksessa(minimikeko);
        assertEquals("dsa", minimikeko.poistaJuuri());
        testKekoJarjestyksessa(minimikeko);
        assertEquals("A", minimikeko.poistaJuuri());
        testKekoJarjestyksessa(minimikeko);
        assertEquals(123, minimikeko.poistaJuuri());
        testKekoJarjestyksessa(minimikeko);
    }

    @Test
    public void testInsertJuuriJaPoistaJuuriMininmikeossa2() {
        minimikeko.insert(25, 25);
        minimikeko.insert(24, 24);
        minimikeko.insert(23, 23);
        minimikeko.insert(22, 22);
        minimikeko.insert(21, 21);
        minimikeko.insert(20, 20);
        minimikeko.insert(19, 19);
        minimikeko.insert(18, 18);
        minimikeko.insert(17, 17);
        minimikeko.insert(16, 16);
        minimikeko.insert(15, 15);
        minimikeko.insert(14, 14);
        minimikeko.insert(13, 13);
        minimikeko.insert(12, 12);
        minimikeko.insert(11, 11);
        minimikeko.insert(10, 10);
        minimikeko.insert(9, 9);
        minimikeko.insert(8, 8);
        minimikeko.insert(7, 7);
        minimikeko.insert(6, 6);
        minimikeko.insert(5, 5);
        minimikeko.insert(4, 4);
        minimikeko.insert(3, 3);
        minimikeko.insert(2, 2);
        minimikeko.insert(1, 1);
        minimikeko.insert(0, 0);

        assertEquals(0, minimikeko.juuri());
        assertFalse((int)minimikeko.juuri()==25);
        
        testKekoJarjestyksessa(minimikeko);

        assertEquals(0, minimikeko.poistaJuuri());
        assertEquals(1, minimikeko.poistaJuuri());
        assertEquals(2, minimikeko.poistaJuuri());
        assertEquals(3, minimikeko.poistaJuuri());
        assertEquals(4, minimikeko.poistaJuuri());
        assertEquals(5, minimikeko.poistaJuuri());
        assertEquals(6, minimikeko.poistaJuuri());
        assertEquals(7, minimikeko.poistaJuuri());
        assertEquals(8, minimikeko.poistaJuuri());
        assertEquals(9, minimikeko.poistaJuuri());
        assertEquals(10, minimikeko.poistaJuuri());
        assertEquals(11, minimikeko.poistaJuuri());
        assertEquals(12, minimikeko.poistaJuuri());
        assertEquals(13, minimikeko.poistaJuuri());
        assertEquals(14, minimikeko.poistaJuuri());
        assertEquals(15, minimikeko.poistaJuuri());
        assertEquals(16, minimikeko.poistaJuuri());
        assertEquals(17, minimikeko.poistaJuuri());
        assertEquals(18, minimikeko.poistaJuuri());
        assertEquals(19, minimikeko.poistaJuuri());
        assertEquals(20, minimikeko.poistaJuuri());
        assertEquals(21, minimikeko.poistaJuuri());
        assertEquals(22, minimikeko.poistaJuuri());
        assertEquals(23, minimikeko.poistaJuuri());
        assertEquals(24, minimikeko.poistaJuuri());
        assertEquals(25, minimikeko.poistaJuuri());
    }

    private void testKekoJarjestyksessa(Keko keko) {
        int[] taulukko = (int[]) FieldAccess.getArray(keko, "taulukko");
        int size = (int) FieldAccess.getField(keko, "size");
        assertEquals(0, taulukko[0]);

        if ((boolean) FieldAccess.getField(keko, "max")) {
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
        } else {
            for (int i = 1; i < size; i++) {
                if (i > 1) {
                    assertTrue((int) taulukko[i] > (int) taulukko[i / 2]);
                }
                if (i * 2 < size) {
                    assertTrue((int) taulukko[i] < (int) taulukko[i * 2]);
                }
                if ((i * 2) + 1 < size) {
                    assertTrue((int) taulukko[i] < (int) taulukko[(i * 2) + 1]);
                }
            }
        }
    }
}
