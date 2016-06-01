package main;

import luolastogeneraattori.Luolastogeneraattori;

/**
 *
 * @author Hannu
 */
public class Main {

    /**
     * Metodi käynnistää ohjelman. Ohjelman parametri args sisältää tiedon
     * yksittäisen luolan koosta size. Jos tätä lukua ei anneta, size muuttujan
     * arvoksi annetaan 32.
     *
     * @param args
     */
    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        Luolastogeneraattori luolastogeneraattori = new Luolastogeneraattori(size);
        luolastogeneraattori.kaynnista();
    }
}
