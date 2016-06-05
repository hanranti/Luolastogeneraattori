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
public class SolmuTest {
    private Solmu solmu;

    public SolmuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        solmu = new Solmu(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSolmu() {
        assertEquals(5, solmu.getObject());
        solmu.setOikea(new Solmu("asd"));
        assertEquals("asd", solmu.getOikea().getObject());
        solmu.setVasen(new Solmu(4));
        assertEquals(4, solmu.getVasen().getObject());
        solmu.getOikea().setOikea(solmu.getVasen());
        solmu.getVasen().setOikea(solmu);
        assertEquals(5, solmu.getOikea().getOikea().getOikea().getObject());
    }

}
