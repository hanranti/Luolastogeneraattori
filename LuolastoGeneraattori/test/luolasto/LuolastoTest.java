/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        luolastoFieldAccess = new FieldAccess(luolasto);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testKasvataTaulukkoa() {
        assertEquals(0, (int) luolastoFieldAccess.getField("muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(5, (int) luolastoFieldAccess.getField("muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(10, (int) luolastoFieldAccess.getField("muutos"));
        luolastoMethodInvoker.invokeMethod("kasvataTaulukkoa", new Object[0]);
        assertEquals(20, (int) luolastoFieldAccess.getField("muutos"));
    }
// -15 -5 0 10 15 25

    @Test
    public void testMuutos() {
        int muutos = (int) luolastoFieldAccess.getField("muutos");
        assertEquals(0, muutos);
        luolasto.genertoiLuola(-1, 5);
        muutos = (int) luolastoFieldAccess.getField("muutos");
        assertEquals(5, muutos);
        luolasto.genertoiLuola(-6, 5);
        muutos = (int) luolastoFieldAccess.getField("muutos");
        assertEquals(10, muutos);
        luolasto.genertoiLuola(-16, 5);
        muutos = (int) luolastoFieldAccess.getField("muutos");
        assertEquals(20, muutos);
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
