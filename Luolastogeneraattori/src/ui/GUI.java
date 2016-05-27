package ui;

import luolasto.Pelaaja;

/**
 *
 * @author Hannu
 */
public class GUI {

    /**
     * Metodi luo luolia tulostavan GUI olion.
     */
    public GUI() {
    }

    /**
     * Metodi ottaa parametreinä tulostettavan luolan ja pelaajan. Metodi
     * tulostaa luolan, jossa seiniä kuvataan merkillä "x", avoimia alueita 
     * merkillä " " ja pelaajaa merkillä "@".
     * 
     * @param luola
     * @param pelaaja
     */
    public void tulosta(boolean[][] luola, Pelaaja pelaaja) {
        for (int i = 0; i < luola[0].length; i++) {
            for (int j = 0; j < luola.length; j++) {
                if (j == pelaaja.getX() && i == pelaaja.getY()) {
                    System.out.print("@");
                } else if (luola[j][i]) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
