/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class KaariTest {
    
    public KaariTest() {
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
     * Test of getO1 method, of class Kaari.
     */
    @Test
    public void testGetO1() {
        System.out.println("getO1");
        Kaari instance = null;
        Piste expResult = null;
        Piste result = instance.getO1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getO2 method, of class Kaari.
     */
    @Test
    public void testGetO2() {
        System.out.println("getO2");
        Kaari instance = null;
        Piste expResult = null;
        Piste result = instance.getO2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Kaari.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Kaari instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
