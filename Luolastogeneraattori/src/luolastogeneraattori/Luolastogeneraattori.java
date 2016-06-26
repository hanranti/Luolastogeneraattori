package luolastogeneraattori;

import java.util.Scanner;
import luolasto.Luolasto;
import luolasto.Pelaaja;
import tietorakenteet.Jono;
import ui.GUI;

/**
 * Luokkaa käytetään ohjelman käynnistämiseen.
 *
 * @author hanranti
 */
public class Luolastogeneraattori {

    private final int size;
    private final Luolasto luolasto;
    private final Pelaaja pelaaja;
    private final GUI gui;

    /**
     * Metodi luo ohjelman tarvitsemat luokat ja välittää näille parametrina
     * saamansa luolan koon.
     *
     * @param size
     * @param todennakoisyysVahennys
     */
    public Luolastogeneraattori(int size, int todennakoisyysVahennys) {
        this.size = size;
        luolasto = new Luolasto(size, todennakoisyysVahennys);
        pelaaja = new Pelaaja(5, 5, luolasto);
        luolasto.genertoiLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY());
        gui = new GUI();
        asetaPelaajaLuolaan();
    }

    /**
     * Metodi aloittaa ohjelman suorituksen. Metodi kysyy pelaajan siirtoja,
     * suorittaa nämä ja tulostaa tilanteen luolasta, jossa pelaaja on.
     *
     */
    public void kaynnista() {
        Scanner scanner = new Scanner(System.in);
        boolean jatka = true;
        while (true) {
            gui.tulosta(
                    luolasto.getLuola(
                            pelaaja.getLuolaX(),
                            pelaaja.getLuolaY())
                    .getLuola(),
                    pelaaja);
            System.out.print("Seuraava siirto: ");
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    pelaaja.liikutaOikealle();
                } else if (s.charAt(i) == 'v') {
                    pelaaja.liikutaVasemmalle();
                } else if (s.charAt(i) == 'y') {
                    pelaaja.liikutaYlos();
                } else if (s.charAt(i) == 'a') {
                    pelaaja.liikutaAlas();
                } else if (s.charAt(i) == 'q') {
                    jatka = false;
                    break;
                } 
            }
            if (!jatka) {
                break;
            }
        }
    }

    private void asetaPelaajaLuolaan() {
        Jono qX = new Jono();
        Jono qY = new Jono();
        boolean[][] color = new boolean[size][size];
        qX.push(size / 2);
        qY.push(size / 2);
        color[size / 2][size / 2] = true;
        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            if (luolasto.getLuola(5, 5).getLuola()[x][y]) {
                pelaaja.setX(x);
                pelaaja.setY(y);
                return;
            }
            if (x + 1 <= size - 1 && color[x + 1][y] == false) {
                qX.push(x + 1);
                qY.push(y);
                color[x + 1][y] = true;
            }
            if (y + 1 <= size - 1 && color[x][y + 1] == false) {
                qX.push(x);
                qY.push(y + 1);
                color[x][y + 1] = true;
            }
            if (x - 1 >= 0 && color[x - 1][y] == false) {
                qX.push(x - 1);
                qY.push(y);
                color[x - 1][y] = true;
            }
            if (y - 1 >= 0 && color[x][y - 1] == false) {
                qX.push(x);
                qY.push(y - 1);
                color[x][y - 1] = true;
            }
        }
    }
}
