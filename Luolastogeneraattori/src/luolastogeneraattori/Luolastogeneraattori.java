package luolastogeneraattori;

public class Luolastogeneraattori {

    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        Pelaaja pelaaja = new Pelaaja(size / 2, size / 2, 5, 5);
        Luolasto luolasto = new Luolasto(size);
        GUI gui = new GUI(pelaaja);

        while (true) {
            gui.piirra(luolasto.getLuola(pelaaja.getLuolaX(), pelaaja.getLuolaY()).getLuola());
        }
    }
}
