package luolastogeneraattori;

import java.util.Scanner;

public class Luolastogeneraattori {

    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        Pelaaja pelaaja = new Pelaaja(size / 2, size / 2, 5, 5);
        Luolasto luolasto = new Luolasto(size);
        luolasto.genertoiLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY());
        GUI gui = new GUI(pelaaja);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            gui.piirra(
                    luolasto.getLuola(
                            pelaaja.getLuolaX(),
                            pelaaja.getLuolaY())
                    .getLuola());
            String s = scanner.nextLine();
            if (s == "o") {
                pelaaja.liikutaOikealle();
            } else if (s == "v") {
                pelaaja.liikutaVasemmalle();
            } else if (s == "y") {
                pelaaja.liikutaYlos();
            } else if (s == "a") {
                pelaaja.liikutaAlas();;
            };
        }
    }
}
