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
public class PelaajaTest {

    private Pelaaja pelaaja;
    private Luolasto luolasto;

    public PelaajaTest() {
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
        pelaaja = new Pelaaja(5, 5, 5, 5, luolasto, 10);
    }

    @After
    public void tearDown() {
    }

    private void poistaSeinat(Luola luola) {
        boolean[][] t = luola.getLuola();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = false;
            }
        }
    }
}
