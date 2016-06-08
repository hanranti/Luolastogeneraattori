package luolasto;

/**
 * Luokka sisältää luolaston eli ohjelman tarvitsemat luolat.
 *
 * @author Hannu
 */
public class Luolasto {

    private Luola[][] luolasto;
    private final int size;
    private int muutos;

    /**
     * Metodi luo Luolasto -olion, joka sisältää ja generoi ohjelman tarvitsemat
     * luolat.
     *
     * @param size
     */
    public Luolasto(int size) {
        luolasto = new Luola[10][10];
        this.size = size;
        muutos = 0;
    }

    /**
     * Metodi luo jageneroi luolan, jossa on satunnaisesti asetettuja huoneita
     * uloskäyntejä ja käytäviä näiden välillä. Jos luolaa yritetään generoida
     * taulukon ulkopuolelle, taulukon koko kasvatetaan kaksinkertaisesksi
     * kasvataTaulukkoa() metodilla.
     *
     * @param x
     * @param y
     */
    public void genertoiLuola(int x, int y) {
        System.out.println(luolasto.length);
        if (x + muutos >= luolasto.length || x + muutos < 0 || y + muutos >= luolasto[0].length || y + muutos < 0) {
            kasvataTaulukkoa();
        }
        if (luolasto[x + muutos][y + muutos] == null) {
            Luola luola = new Luola(this, x , y, size);
            luola.generoi();
            luolasto[x + muutos][y + muutos] = luola;
        }
    }
    //  -75 -35 -15 -5 0 10(10) 15(20) 25(40) 45(80)  85
    //  -40 -20 -10 -5 0 10     15     30     60

    /**
     * Metodi vaihtaa luolastotaulukon tilalle tästä kaksi kertaa suuremman
     * taulukon, jonka keskelle tallennetaan vanhan taulukon arvot. Metodi
     * kasvattaa muutos -muuttujaa, siten että hakemalla alkuperäisen taulukon
     * mukaisilla koordinaateilla palautetaan oikea luola.
     */
    private void kasvataTaulukkoa() {
        int uusiMuutos = muutos + luolasto.length / 2;
        Luola[][] luolasto2 = new Luola[luolasto.length * 2][luolasto[0].length * 2];
        boolean[][] generoitu2 = new boolean[luolasto2.length][luolasto2[0].length];
//        System.out.println("uusimuutos " + uusiMuutos);
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
//                System.out.println("i" + i + "j" + j);
                luolasto2[uusiMuutos - muutos + i][uusiMuutos - muutos + j]
                        = luolasto[i][j];
            }
        }
        muutos = uusiMuutos;
        luolasto = luolasto2;
    }

    /**
     * Metodi palauttaa Luola -olion taulukon x, ja y koordinaateista.
     *
     * @param x
     * @param y
     * @return
     */
    public Luola getLuola(int x, int y) {
        if (x + muutos < 0 || x + muutos >= luolasto.length || y + muutos < 0 || y + muutos >= luolasto[0].length) {
            return null;
        }
        return luolasto[x + muutos][y + muutos];
    }

//    public void tulostaLuolasto() {
//        System.out.print(" ");
//        for (int i = 0; i < luolasto.length; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(i);
//            }
//        }
//        System.out.println("");
//        for (int i = 0; i < luolasto[0].length; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(i);
//                for (int k = 0; k < luolasto.length; k++) {
////                    System.out.print(k);
//                    for (int l = 0; l < size; l++) {
//                        if (luolasto[k][i] == null) {
//                            System.out.print("n");
//                        } else if (luolasto[k][i].getLuola()[l][j]) {
//                            System.out.print("x");
//                        } else {
//                            System.out.print(" ");
//                        }
//                    }
//                }
//                System.out.println("");
//            }
//        }
//    }
}
