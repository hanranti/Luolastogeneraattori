/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolasto;

import tyokalut.MethodInvoker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LuolastoTest {

    private MethodInvoker luolastoMethodInvoker;
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
        
    }
// -15 -5 0 10 15 25

    @Test
    public void testMuutos() {
        try {
            Luolasto luolasto = new Luolasto(10);
            Field muutos = luolasto.getClass().getDeclaredField("muutos");
            muutos.setAccessible(true);
            assertEquals(0, muutos.get(luolasto));
            luolasto.genertoiLuola(-1, 5);
            assertEquals(5, muutos.get(luolasto));
            luolasto.genertoiLuola(-6, 5);
            assertEquals(10, muutos.get(luolasto));
            luolasto.genertoiLuola(-15, 5);
            assertEquals(20, muutos.get(luolasto));
        } catch (IllegalArgumentException ex) {
            fail("IllegalArgumentException");
        } catch (IllegalAccessException ex) {
            fail("IllegalAccessException");
        } catch (NoSuchFieldException ex) {
            fail("NoSuchFieldException");
        } catch (SecurityException ex) {
            fail("SecurityException");
        }
    }
}
