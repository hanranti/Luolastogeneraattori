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

    private UnionFind unionFind;

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
        unionFind = new UnionFind();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUnionFind() {
        unionFind.makeSet(5);
        unionFind.makeSet("asd");
        Piste piste = new Piste(6, 7);
        unionFind.makeSet(piste);
        assertNotSame(unionFind.find(5), unionFind.find("asd"));
        assertNotSame(unionFind.find(5), unionFind.find(piste));
        assertNotSame(unionFind.find(piste), unionFind.find("asd"));

        unionFind.union("asd", piste);
        assertNotSame(unionFind.find(5), unionFind.find("asd"));
        assertNotSame(unionFind.find(5), unionFind.find(piste));
        assertEquals(unionFind.find(piste), unionFind.find("asd"));

        unionFind.union("asd", 5);
        assertEquals(unionFind.find(5), unionFind.find("asd"));
        assertEquals(unionFind.find(piste), unionFind.find("asd"));
        assertEquals(unionFind.find(5), unionFind.find(piste));

        assertEquals(-1, unionFind.find(4));

    }

    @Test
    public void testUnionFind2() {

        unionFind.makeSet(0);
        assertNotSame(unionFind.find(-1), unionFind.find(0));
        unionFind.makeSet(1);
        assertNotSame(unionFind.find(0), unionFind.find(1));
        unionFind.makeSet(2);
        assertNotSame(unionFind.find(1), unionFind.find(2));
        unionFind.makeSet(3);
        assertNotSame(unionFind.find(2), unionFind.find(3));
        unionFind.makeSet(4);
        assertNotSame(unionFind.find(3), unionFind.find(4));
        unionFind.makeSet(5);
        assertNotSame(unionFind.find(4), unionFind.find(5));
        unionFind.makeSet(6);
        assertNotSame(unionFind.find(5), unionFind.find(6));
        unionFind.makeSet(7);
        assertNotSame(unionFind.find(6), unionFind.find(7));
        unionFind.makeSet(8);
        assertNotSame(unionFind.find(7), unionFind.find(8));
        unionFind.makeSet(9);
        assertNotSame(unionFind.find(8), unionFind.find(9));
        unionFind.makeSet(10);
        assertNotSame(unionFind.find(9), unionFind.find(10));
        unionFind.makeSet(11);
        assertNotSame(unionFind.find(10), unionFind.find(11));
        unionFind.makeSet(12);
        assertNotSame(unionFind.find(11), unionFind.find(12));
        unionFind.makeSet(13);
        assertNotSame(unionFind.find(12), unionFind.find(13));
        unionFind.makeSet(14);
        assertNotSame(unionFind.find(13), unionFind.find(14));
        unionFind.makeSet(15);
        assertNotSame(unionFind.find(14), unionFind.find(15));
        unionFind.makeSet(16);
        assertNotSame(unionFind.find(15), unionFind.find(16));
        unionFind.makeSet(17);
        assertNotSame(unionFind.find(16), unionFind.find(17));
        unionFind.makeSet(18);
        assertNotSame(unionFind.find(17), unionFind.find(18));
        unionFind.makeSet(19);
        assertNotSame(unionFind.find(18), unionFind.find(19));
        unionFind.makeSet(20);
        assertNotSame(unionFind.find(19), unionFind.find(20));
        unionFind.makeSet(21);
        assertNotSame(unionFind.find(20), unionFind.find(21));
        unionFind.makeSet(22);
        assertNotSame(unionFind.find(21), unionFind.find(22));
        unionFind.makeSet(23);
        assertNotSame(unionFind.find(22), unionFind.find(23));
        unionFind.makeSet(24);
        assertNotSame(unionFind.find(23), unionFind.find(24));

        unionFind.union(0, 1);
        assertEquals(unionFind.find(0), unionFind.find(1));
        unionFind.union(1, 2);
        assertEquals(unionFind.find(1), unionFind.find(2));
        unionFind.union(2, 3);
        assertEquals(unionFind.find(2), unionFind.find(3));
        unionFind.union(3, 4);
        assertEquals(unionFind.find(3), unionFind.find(4));
        unionFind.union(4, 5);
        assertEquals(unionFind.find(4), unionFind.find(5));
        unionFind.union(5, 6);
        assertEquals(unionFind.find(5), unionFind.find(6));
        unionFind.union(6, 7);
        assertEquals(unionFind.find(6), unionFind.find(7));
        unionFind.union(7, 8);
        assertEquals(unionFind.find(7), unionFind.find(8));
        unionFind.union(8, 9);
        assertEquals(unionFind.find(8), unionFind.find(9));
        unionFind.union(9, 10);
        assertEquals(unionFind.find(9), unionFind.find(10));
        unionFind.union(10, 11);
        assertEquals(unionFind.find(10), unionFind.find(11));
        unionFind.union(11, 12);
        assertEquals(unionFind.find(11), unionFind.find(12));
        unionFind.union(12, 13);
        assertEquals(unionFind.find(12), unionFind.find(13));
        unionFind.union(13, 14);
        assertEquals(unionFind.find(13), unionFind.find(14));
        unionFind.union(14, 15);
        assertEquals(unionFind.find(14), unionFind.find(15));
        unionFind.union(15, 16);
        assertEquals(unionFind.find(15), unionFind.find(16));
        unionFind.union(16, 17);
        assertEquals(unionFind.find(16), unionFind.find(17));
        unionFind.union(17, 18);
        assertEquals(unionFind.find(17), unionFind.find(18));
        unionFind.union(18, 19);
        assertEquals(unionFind.find(18), unionFind.find(19));
        unionFind.union(19, 20);
        assertEquals(unionFind.find(19), unionFind.find(20));
        unionFind.union(20, 21);
        assertEquals(unionFind.find(20), unionFind.find(21));
        unionFind.union(21, 22);
        assertEquals(unionFind.find(21), unionFind.find(22));
        unionFind.union(22, 23);
        assertEquals(unionFind.find(22), unionFind.find(23));
        unionFind.union(23, 24);
        assertEquals(unionFind.find(23), unionFind.find(24));
    }

}
