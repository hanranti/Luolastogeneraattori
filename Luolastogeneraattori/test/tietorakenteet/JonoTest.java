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
public class JonoTest {

    private Jono jono;

    public JonoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        jono = new Jono();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testJono() {
        assertEquals(0, jono.getKoko());
        assertTrue(jono.tyhja());
        assertEquals(null, jono.poll());
        jono.push(5);
        assertEquals(1, jono.getKoko());
        assertFalse(jono.tyhja());
        assertEquals(5, jono.poll());
    }

    @Test
    public void testJono2() {
        assertTrue(jono.tyhja());
        assertEquals(0, jono.getKoko());
        jono.push(0);
        assertFalse(jono.tyhja());
        assertEquals(1, jono.getKoko());
        jono.push(1);
        assertFalse(jono.tyhja());
        assertEquals(2, jono.getKoko());
        jono.push(2);
        assertFalse(jono.tyhja());
        assertEquals(3, jono.getKoko());
        jono.push(3);
        assertFalse(jono.tyhja());
        assertEquals(4, jono.getKoko());
        jono.push(4);
        assertFalse(jono.tyhja());
        assertEquals(5, jono.getKoko());
        jono.push(5);
        assertFalse(jono.tyhja());
        assertEquals(6, jono.getKoko());
        jono.push(6);
        assertFalse(jono.tyhja());
        assertEquals(7, jono.getKoko());
        jono.push(7);
        assertFalse(jono.tyhja());
        assertEquals(8, jono.getKoko());
        jono.push(8);
        assertFalse(jono.tyhja());
        assertEquals(9, jono.getKoko());
        jono.push(9);
        assertFalse(jono.tyhja());
        assertEquals(10, jono.getKoko());
        jono.push(10);
        assertFalse(jono.tyhja());
        assertEquals(11, jono.getKoko());
        jono.push(11);
        assertFalse(jono.tyhja());
        assertEquals(12, jono.getKoko());
        jono.push(12);
        assertFalse(jono.tyhja());
        assertEquals(13, jono.getKoko());
        jono.push(13);
        assertFalse(jono.tyhja());
        assertEquals(14, jono.getKoko());
        jono.push(14);
        assertFalse(jono.tyhja());
        assertEquals(15, jono.getKoko());
        jono.push(15);
        assertFalse(jono.tyhja());
        assertEquals(16, jono.getKoko());
        jono.push(16);
        assertFalse(jono.tyhja());
        assertEquals(17, jono.getKoko());
        jono.push(17);
        assertFalse(jono.tyhja());
        assertEquals(18, jono.getKoko());
        jono.push(18);
        assertFalse(jono.tyhja());
        assertEquals(19, jono.getKoko());
        jono.push(19);
        assertFalse(jono.tyhja());
        assertEquals(20, jono.getKoko());
        jono.push(20);
        assertFalse(jono.tyhja());
        assertEquals(21, jono.getKoko());
        jono.push(21);
        assertFalse(jono.tyhja());
        assertEquals(22, jono.getKoko());
        jono.push(22);
        assertFalse(jono.tyhja());
        assertEquals(23, jono.getKoko());
        jono.push(23);
        assertFalse(jono.tyhja());
        assertEquals(24, jono.getKoko());
        jono.push(24);
        assertFalse(jono.tyhja());
        assertEquals(25, jono.getKoko());

        assertEquals(0, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(24, jono.getKoko());
        assertEquals(1, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(23, jono.getKoko());
        assertEquals(2, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(22, jono.getKoko());
        assertEquals(3, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(21, jono.getKoko());
        assertEquals(4, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(20, jono.getKoko());
        assertEquals(5, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(19, jono.getKoko());
        assertEquals(6, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(18, jono.getKoko());
        assertEquals(7, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(17, jono.getKoko());
        assertEquals(8, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(16, jono.getKoko());
        assertEquals(9, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(15, jono.getKoko());
        assertEquals(10, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(14, jono.getKoko());
        assertEquals(11, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(13, jono.getKoko());
        assertEquals(12, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(12, jono.getKoko());
        assertEquals(13, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(11, jono.getKoko());
        assertEquals(14, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(10, jono.getKoko());
        assertEquals(15, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(9, jono.getKoko());
        assertEquals(16, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(8, jono.getKoko());
        assertEquals(17, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(7, jono.getKoko());
        assertEquals(18, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(6, jono.getKoko());
        assertEquals(19, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(5, jono.getKoko());
        assertEquals(20, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(4, jono.getKoko());
        assertEquals(21, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(3, jono.getKoko());
        assertEquals(22, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(2, jono.getKoko());
        assertEquals(23, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(1, jono.getKoko());
        assertEquals(24, jono.poll());
        assertTrue(jono.tyhja());
        assertEquals(0, jono.getKoko());
    }

}
