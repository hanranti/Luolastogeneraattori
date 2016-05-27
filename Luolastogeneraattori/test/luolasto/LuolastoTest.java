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

    /**
     * Test of genertoiLuola method, of class Luolasto.
     */
    @Test
    public void testGenertoiLuola() {
        System.out.println("genertoiLuola");
        int x = 0;
        int y = 0;
        Luolasto instance = null;
        instance.genertoiLuola(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLuola method, of class Luolasto.
     */
    @Test
    public void testGetLuola() {
        System.out.println("getLuola");
        int x = 0;
        int y = 0;
        Luolasto instance = null;
        Luola expResult = null;
        Luola result = instance.getLuola(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Luolasto.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Luolasto instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
