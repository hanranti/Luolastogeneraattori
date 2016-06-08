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
public class UnionFindTest {
    
    public UnionFindTest() {
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
     * Test of makeSet method, of class UnionFind.
     */
    @Test
    public void testMakeSet() {
        System.out.println("makeSet");
        Object object = null;
        UnionFind instance = new UnionFind();
        instance.makeSet(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class UnionFind.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        Object oA = null;
        Object oB = null;
        UnionFind instance = new UnionFind();
        instance.union(oA, oB);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UnionFind.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Object object = null;
        UnionFind instance = new UnionFind();
        int expResult = 0;
        int result = instance.find(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKomponentit method, of class UnionFind.
     */
    @Test
    public void testGetKomponentit() {
        System.out.println("getKomponentit");
        UnionFind instance = new UnionFind();
        int expResult = 0;
        int result = instance.getKomponentit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
