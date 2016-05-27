package luolastogeneraattori;

import luolasto.Pelaaja;
import luolasto.Luolasto;
import ui.GUI;
import java.util.Scanner;

/**
 *
 * @author Hannu
 */
public class Luolastogeneraattori {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        Luolasto luolasto = new Luolasto(size);
        Pelaaja pelaaja = new Pelaaja(size / 2, size / 2, 5, 5, luolasto);
        luolasto.genertoiLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY());
        GUI gui = new GUI();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(pelaaja.getLuolaX() + " " + pelaaja.getLuolaY());
            gui.piirra(
                    luolasto.getLuola(
                            pelaaja.getLuolaX(),
                            pelaaja.getLuolaY())
                    .getLuola(),
                    pelaaja);
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
