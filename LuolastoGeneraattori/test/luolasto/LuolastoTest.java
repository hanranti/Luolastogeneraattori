/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolasto;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testKasvataTaulukkoa() {
        Luolasto luolasto = new Luolasto(32);
//        Method kasvataTaulukkoa = Luolasto.class.getDeclaredMethod("kasvataTaulukkoa", parameterTypes);
    }

    @Test
    public void testMuutos() {
        try {
            Luolasto luolasto = new Luolasto(10);
            Field muutos = luolasto.getClass().getDeclaredField("muutos");
            muutos.setAccessible(true);
            assertEquals(0, muutos.get(luolasto));
            luolasto.genertoiLuola(-1, 5);
            assertEquals(5, muutos.get(luolasto));
            luolasto.getLuola(-11, 5);
            assertEquals(10, muutos.get(luolasto));
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
