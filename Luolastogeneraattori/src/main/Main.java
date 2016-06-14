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
        int uusiaUloskaynteja = 10;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
            if (args.length > 1) {
                uusiaUloskaynteja = Integer.parseInt(args[1]);
            }
        }
        
        if (size < 32) {
            size = 32;
            System.out.println("Pienin luolan koko on 32");
        }
        if (uusiaUloskaynteja<0) {
            uusiaUloskaynteja = 0;
            System.out.println("Pienin uusien luolien löytymisen määrittävä luku on 0");
        }

        Luolastogeneraattori luolastogeneraattori
                = new Luolastogeneraattori(size, uusiaUloskaynteja);
        luolastogeneraattori.kaynnista();
    }
}
