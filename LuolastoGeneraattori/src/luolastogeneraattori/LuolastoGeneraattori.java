package luolastogeneraattori;

import luolasto.Pelaaja;
import luolasto.Luolasto;
import ui.GUI;
import java.util.Scanner;

/**
 * Luokka sisältää ohjelman käynnistävän main metodin.
 * 
 * @author Hannu
 */
public class LuolastoGeneraattori {

    /**
     * Metodi käynnistää ohjelman. Ohjelman parametri args sisältää tiedon 
     * yksittäisen luolan koosta size. Jos tätä lukua ei anneta, size muuttujan 
     * arvoksi annetaan 32.
     * 
     * Metodi luo tämän jälkeen ohjelman tarvitsemat luokat ja alkaa while 
     * -loopissa kysymään pelaajan siirtoja ja näiden mukaan tulostaa luolan, 
     * jossa pelaaja on. Antamalla siirroksi "exit" ohjelman suoritus 
     * lopetetaan.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        Luolasto luolasto = new Luolasto(size);
        Pelaaja pelaaja = new Pelaaja(size / 2, size / 2, 5, 5, luolasto, size);
        luolasto.genertoiLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY());
        GUI gui = new GUI();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(pelaaja.getLuolaX() + " " + pelaaja.getLuolaY());
            gui.tulosta(
                    luolasto.getLuola(
                            pelaaja.getLuolaX(),
                            pelaaja.getLuolaY())
                    .getLuola(),
                    pelaaja);
            System.out.print("Seuraava siirto: ");
            String s = scanner.nextLine();
            if (s.equals("o")) {
                pelaaja.liikutaOikealle();
            } else if (s.equals("v")) {
                pelaaja.liikutaVasemmalle();
            } else if (s.equals("y")) {
                pelaaja.liikutaYlos();
            } else if (s.equals("a")) {
                pelaaja.liikutaAlas();
            } else if (s.equals("exit")) {
                break;
            }
        }
    }
}
