
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
    public void testIntLista() {
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

}
