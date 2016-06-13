package luolastogeneraattori;

import java.util.Random;
import java.util.Scanner;
import luolasto.Luolasto;
import luolasto.Pelaaja;
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
        Random random = new Random();
        Lista huoneet = luolasto.getLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY()).getHuoneet();
        Piste huone =(Piste) huoneet.get(random.nextInt(huoneet.getKoko()));
        pelaaja.setX(huone.getX());
        pelaaja.setY(huone.getY());
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
}
