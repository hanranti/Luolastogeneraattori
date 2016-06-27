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
public class ListaTest {

    private Lista lista;

    public ListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lista = new Lista();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLista() {
        assertEquals(null, lista.getFirst());
        assertEquals(null, lista.getLast());
        lista.add(5);
        assertEquals(5, lista.getFirst().getObject());
        assertEquals(5, lista.getLast().getObject());
        assertEquals(true, lista.contains(5));
        assertEquals(false, lista.contains(4));
        lista.add(4);
        lista.add(3);
        lista.add(2);
        assertEquals(5, lista.getFirst().getObject());
        assertEquals(2, lista.getLast().getObject());
        assertEquals(true, lista.contains(3));
        assertEquals(false, lista.contains(6));
        lista.remove(3);
        Solmu s = lista.getFirst();
        int i = 0;
        int[] taulukko = new int[]{5, 4, 2};
        while (s != null) {
            assertEquals(taulukko[i], s.getObject());
            assertEquals(taulukko[i], lista.get(i));
            i++;
            s = s.getOikea();
        }
        assertEquals(false, lista.contains(3));
        lista.remove(2);
        assertEquals(4, lista.getLast().getObject());
        lista.remove(5);
        assertEquals(false, lista.contains(5));
        assertEquals(4, lista.getFirst().getObject());
        assertEquals(4, lista.getLast().getObject());
        lista.remove(4);
        assertEquals(null, lista.getFirst());
        assertEquals(null, lista.getLast());
    }

    @Test
    public void testLista2() {
        assertEquals(0, lista.getKoko());
        lista.add(25);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(25, lista.getLast().getObject());
        assertEquals(1, lista.getKoko());
        lista.add(24);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(24, lista.getLast().getObject());
        assertEquals(2, lista.getKoko());
        lista.add(23);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(23, lista.getLast().getObject());
        assertEquals(3, lista.getKoko());
        lista.add(22);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(22, lista.getLast().getObject());
        assertEquals(4, lista.getKoko());
        lista.add(21);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(21, lista.getLast().getObject());
        assertEquals(5, lista.getKoko());
        lista.add(20);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(20, lista.getLast().getObject());
        assertEquals(6, lista.getKoko());
        lista.add(19);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(19, lista.getLast().getObject());
        assertEquals(7, lista.getKoko());
        lista.add(18);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(18, lista.getLast().getObject());
        assertEquals(8, lista.getKoko());
        lista.add(17);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(17, lista.getLast().getObject());
        assertEquals(9, lista.getKoko());
        lista.add(16);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(16, lista.getLast().getObject());
        assertEquals(10, lista.getKoko());
        lista.add(15);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(15, lista.getLast().getObject());
        assertEquals(11, lista.getKoko());
        lista.add(14);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(14, lista.getLast().getObject());
        assertEquals(12, lista.getKoko());
        lista.add(13);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(13, lista.getLast().getObject());
        assertEquals(13, lista.getKoko());
        lista.add(12);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(12, lista.getLast().getObject());
        assertEquals(14, lista.getKoko());
        lista.add(11);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(11, lista.getLast().getObject());
        assertEquals(15, lista.getKoko());
        lista.add(10);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(10, lista.getLast().getObject());
        assertEquals(16, lista.getKoko());
        lista.add(9);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(9, lista.getLast().getObject());
        assertEquals(17, lista.getKoko());
        lista.add(8);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(8, lista.getLast().getObject());
        assertEquals(18, lista.getKoko());
        lista.add(7);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(7, lista.getLast().getObject());
        assertEquals(19, lista.getKoko());
        lista.add(6);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(6, lista.getLast().getObject());
        assertEquals(20, lista.getKoko());
        lista.add(5);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(5, lista.getLast().getObject());
        assertEquals(21, lista.getKoko());
        lista.add(4);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(4, lista.getLast().getObject());
        assertEquals(22, lista.getKoko());
        lista.add(3);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(3, lista.getLast().getObject());
        assertEquals(23, lista.getKoko());
        lista.add(2);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(2, lista.getLast().getObject());
        assertEquals(24, lista.getKoko());
        lista.add(1);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(1, lista.getLast().getObject());
        assertEquals(25, lista.getKoko());
        lista.add(0);
        assertEquals(25, lista.getFirst().getObject());
        assertEquals(0, lista.getLast().getObject());
        assertEquals(26, lista.getKoko());

        Solmu s = lista.getFirst();
        int i = 25;
        while (s != null) {
            assertEquals(i, s.getObject());
            assertTrue(lista.contains(i));
            s = s.getOikea();
            i--;
        }

        lista.remove(16);
        assertEquals(25, lista.getKoko());

        s = lista.getFirst();
        i = 25;
        while (s != null) {
            if (i == 16) {
                assertFalse(lista.contains(i));
            } else {
                assertEquals(i, s.getObject());
                assertTrue(lista.contains(i));
                s = s.getOikea();
            }
            i--;
        }

        for (int j = 25; j >= 0; j--) {
            if (j != 16) {
                assertTrue(lista.contains(j));
            assertTrue((int) lista.getFirst().getObject() == j);
            }
            assertTrue((int)lista.getLast().getObject()== 0);
            lista.remove(j);
            if (j > 16) {
                assertEquals(j-1, lista.getKoko());
            } else {
                assertEquals(j, lista.getKoko());
            }
            assertFalse(lista.contains(j));
        }
        
            assertNull(lista.getFirst());
            assertNull(lista.getLast());
    }

}
