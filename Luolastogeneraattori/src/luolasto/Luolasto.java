package luolasto;

/**
 * Luokka sisältää luolaston eli ohjelman tarvitsemat luolat.
 *
 * @author Hannu
 */
public class Luolasto {

    private Luola[][] luolasto;
    private final Luolageneraattori luolageneraattori;
    private final int size;
    private int muutos;

    /**
     * Metodi luo Luolasto -olion, joka sisältää ja generoi ohjelman tarvitsemat
     * luolat.
     *
     * @param size
     * @param todennakoisyysVahennys
     */
    public Luolasto(int size, int todennakoisyysVahennys) {
        luolasto = new Luola[10][10];
        this.size = size;
        luolageneraattori = new Luolageneraattori(this, todennakoisyysVahennys);
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
        if (x + muutos >= luolasto.length || x + muutos < 0 || y + muutos >= luolasto[0].length || y + muutos < 0) {
            kasvataTaulukkoa();
        }
        if (luolasto[x + muutos][y + muutos] == null) {
            Luola luola = new Luola(this, x, y);
            luolageneraattori.generoi(luola);
            luolasto[x + muutos][y + muutos] = luola;
        }
    }

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
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
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

    /**
     * Metodi palauttaa luolan koon.
     *
     * @return
     */
    public int getSize() {
        return size;
    }
}
