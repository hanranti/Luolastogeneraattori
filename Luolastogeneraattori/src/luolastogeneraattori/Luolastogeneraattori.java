package luolastogeneraattori;

import java.util.Random;
import java.util.Scanner;
import luolasto.Luolasto;
import luolasto.Pelaaja;
import tietorakenteet.Jono;
import tietorakenteet.Lista;
import tietorakenteet.Piste;
import ui.GUI;

/**
 * Luokkaa käytetään ohjelman käynnistämiseen.
 *
 * @author hanranti
 */
public class Luolastogeneraattori {

    private int size;
    private Luolasto luolasto;
    private Pelaaja pelaaja;
    private GUI gui;

    /**
     * Metodi luo ohjelman tarvitsemat luokat ja välittää näille parametrina
     * saamansa luolan koon.
     *
     * @param size
     */
    public Luolastogeneraattori(int size, int uusiaUloskaynteja) {
        System.out.println("LuolastoGeneraattori");
        this.size = size;
        luolasto = new Luolasto(size, uusiaUloskaynteja);
        pelaaja = new Pelaaja(size / 2, size / 2, 5, 5, luolasto, size);
        luolasto.genertoiLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY());
        gui = new GUI();
    }

    /**
     * Metodi aloittaa ohjelman suorituksen. Metodi kysyy pelaajan siirtoja,
     * suorittaa nämä ja tulostaa tilanteen luolasta, jossa pelaaja on.
     *
     */
    public void kaynnista() {
        System.out.println("kaynnista");
        Scanner scanner = new Scanner(System.in);
        boolean jatka = true;
        while (true) {
//            System.out.println(pelaaja.getLuolaX() + " " + pelaaja.getLuolaY());
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
                } else if (s.equals("t")) {
//                luolasto.tulostaLuolasto();
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
        qX.push(size / 2);
        qY.push(size / 2);
        while (!qX.tyhja()) {
            int x = (int) qX.poll();
            int y = (int) qY.poll();
            if (luolasto.getLuola(5, 5).getLuola()[x][y]) {
                pelaaja.setX(x);
                pelaaja.setY(y);
                return;
            }
            if (x + 1 <= size - 1) {
                qX.push(x + 1);
                qY.push(y);
            }
            if (y + 1 <= size - 1) {
                qX.push(x);
                qY.push(y + 1);
            }
            if (x - 1 >= 0) {
                qX.push(x - 1);
                qY.push(y);
            }
            if (y - 1 >= 0) {
                qX.push(x);
                qY.push(y - 1);
            }
        }
    }
}
