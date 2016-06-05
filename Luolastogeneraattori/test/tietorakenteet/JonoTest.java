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
        assertEquals(0, jono.koko());
        assertTrue(jono.tyhja());
        assertEquals(null, jono.poll());
        jono.push(5);
        assertEquals(1, jono.koko());
        assertFalse(jono.tyhja());
        assertEquals(5, jono.poll());
    }

    @Test
    public void testJono2() {
        assertTrue(jono.tyhja());
        assertEquals(0, jono.koko());
        jono.push(0);
        assertFalse(jono.tyhja());
        assertEquals(1, jono.koko());
        jono.push(1);
        assertFalse(jono.tyhja());
        assertEquals(2, jono.koko());
        jono.push(2);
        assertFalse(jono.tyhja());
        assertEquals(3, jono.koko());
        jono.push(3);
        assertFalse(jono.tyhja());
        assertEquals(4, jono.koko());
        jono.push(4);
        assertFalse(jono.tyhja());
        assertEquals(5, jono.koko());
        jono.push(5);
        assertFalse(jono.tyhja());
        assertEquals(6, jono.koko());
        jono.push(6);
        assertFalse(jono.tyhja());
        assertEquals(7, jono.koko());
        jono.push(7);
        assertFalse(jono.tyhja());
        assertEquals(8, jono.koko());
        jono.push(8);
        assertFalse(jono.tyhja());
        assertEquals(9, jono.koko());
        jono.push(9);
        assertFalse(jono.tyhja());
        assertEquals(10, jono.koko());
        jono.push(10);
        assertFalse(jono.tyhja());
        assertEquals(11, jono.koko());
        jono.push(11);
        assertFalse(jono.tyhja());
        assertEquals(12, jono.koko());
        jono.push(12);
        assertFalse(jono.tyhja());
        assertEquals(13, jono.koko());
        jono.push(13);
        assertFalse(jono.tyhja());
        assertEquals(14, jono.koko());
        jono.push(14);
        assertFalse(jono.tyhja());
        assertEquals(15, jono.koko());
        jono.push(15);
        assertFalse(jono.tyhja());
        assertEquals(16, jono.koko());
        jono.push(16);
        assertFalse(jono.tyhja());
        assertEquals(17, jono.koko());
        jono.push(17);
        assertFalse(jono.tyhja());
        assertEquals(18, jono.koko());
        jono.push(18);
        assertFalse(jono.tyhja());
        assertEquals(19, jono.koko());
        jono.push(19);
        assertFalse(jono.tyhja());
        assertEquals(20, jono.koko());
        jono.push(20);
        assertFalse(jono.tyhja());
        assertEquals(21, jono.koko());
        jono.push(21);
        assertFalse(jono.tyhja());
        assertEquals(22, jono.koko());
        jono.push(22);
        assertFalse(jono.tyhja());
        assertEquals(23, jono.koko());
        jono.push(23);
        assertFalse(jono.tyhja());
        assertEquals(24, jono.koko());
        jono.push(24);
        assertFalse(jono.tyhja());
        assertEquals(25, jono.koko());

        assertEquals(24, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(24, jono.koko());
        assertEquals(23, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(23, jono.koko());
        assertEquals(22, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(22, jono.koko());
        assertEquals(21, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(21, jono.koko());
        assertEquals(20, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(20, jono.koko());
        assertEquals(19, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(19, jono.koko());
        assertEquals(18, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(18, jono.koko());
        assertEquals(17, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(17, jono.koko());
        assertEquals(16, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(16, jono.koko());
        assertEquals(15, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(15, jono.koko());
        assertEquals(14, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(14, jono.koko());
        assertEquals(13, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(13, jono.koko());
        assertEquals(12, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(12, jono.koko());
        assertEquals(11, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(11, jono.koko());
        assertEquals(10, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(10, jono.koko());
        assertEquals(9, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(9, jono.koko());
        assertEquals(8, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(8, jono.koko());
        assertEquals(7, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(7, jono.koko());
        assertEquals(6, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(6, jono.koko());
        assertEquals(5, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(5, jono.koko());
        assertEquals(4, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(4, jono.koko());
        assertEquals(3, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(3, jono.koko());
        assertEquals(2, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(2, jono.koko());
        assertEquals(1, jono.poll());
        assertFalse(jono.tyhja());
        assertEquals(1, jono.koko());
        assertEquals(0, jono.poll());
        assertTrue(jono.tyhja());
        assertEquals(0, jono.koko());
    }

}
