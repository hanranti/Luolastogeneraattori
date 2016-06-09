package luolasto;

import tyokalut.MethodInvoker;
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
public class LuolastoTest {

    private MethodInvoker luolastoMethodInvoker;
    private FieldAccess luolastoFieldAccess;
    private Luolasto luolasto;

    public LuolastoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luolasto = new Luolasto(10);
        luolastoMethodInvoker = new MethodInvoker(luolasto);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testKasvataTaulukkoa() {
        assertEquals(0, (int) FieldAccess.getField(luolasto, "muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(5, (int) FieldAccess.getField(luolasto, "muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(15, (int) FieldAccess.getField(luolasto, "muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(35, (int) FieldAccess.getField(luolasto, "muutos"));
    }
// -15 -5 0 10 15 25

    @Test
    public void testMuutos() {
        int muutos = (int) FieldAccess.getField(luolasto, "muutos");
        assertEquals(0, muutos);
        luolasto.genertoiLuola(-1, 5);
        muutos = (int) FieldAccess.getField(luolasto, "muutos");
        assertEquals(5, muutos);
        luolasto.genertoiLuola(-6, 5);
        muutos = (int) FieldAccess.getField(luolasto, "muutos");
        assertEquals(15, muutos);
        luolasto.genertoiLuola(-16, 5);
        muutos = (int) FieldAccess.getField(luolasto, "muutos");
        assertEquals(35, muutos);
    }

    @Test
    public void testMuutos2() {
        luolasto.genertoiLuola(5, 5);
        Luola luola = luolasto.getLuola(5, 5);
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(luola, luolasto.getLuola(5, 5));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(luola, luolasto.getLuola(5, 5));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(luola, luolasto.getLuola(5, 5));
    }
}
