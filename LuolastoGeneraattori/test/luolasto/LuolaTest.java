/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hannu
 */
public class LuolaTest {

    public LuolaTest() {
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

    /**
     * Test of generoi method, of class Luola.
     */
    @Test
    public void testGeneroi() {
        System.out.println("generoi");
        Luola instance = null;
        instance.generoi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLuola method, of class Luola.
     */
    @Test
    public void testGetLuola() {
        System.out.println("getLuola");
        Luola instance = null;
        boolean[][] expResult = null;
        boolean[][] result = instance.getLuola();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testLuola() {
        Luola luola = new Luola(10);
        assertEquals(10, luola.getLuola().length);
        assertEquals(10, luola.getLuola()[0].length);
        luola = new Luola(32);
        assertEquals(32, luola.getLuola().length);
        assertEquals(3, luola.getLuola()[0].length);
    }
}
