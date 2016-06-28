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
     * arvoksi annetaan 32. Toisena parametrina on todennakoisyysvahennys, joka
     * on todennakoisyydesta loytaa uusia uloskaynteja luolan generoinnin
     * yhteydessa vahennettava luku.
     *
     * @param args Sisaltaa mahdollisesti ensimmaisena parametrina luolan koon ja
     * toisena todennakoisyydesta loytaa uusia uloskaynteja luolan generoinnin
     * yhteydessa vahennettavan luvun
     */
    public static void main(String[] args) {
        int size = 32;
        int todennakoisyysVahennys = 10;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
            if (args.length > 1) {
                todennakoisyysVahennys = Integer.parseInt(args[1]);
            }
        }
        
        if (size < 32) {
            size = 32;
            System.out.println("Pienin luolan koko on 32");
        }
        if (todennakoisyysVahennys<0) {
            todennakoisyysVahennys = 0;
            System.out.println("Pienin todennäköisyysvähennös on 0");
        }

        Luolastogeneraattori luolastogeneraattori
                = new Luolastogeneraattori(size, todennakoisyysVahennys);
        luolastogeneraattori.kaynnista();
    }
}
