package luolasto;

/**
 *
 * @author Hannu
 */
public class Luolasto {

    private Luola[][] luolasto;
    private int size;
    private int muutos;

    /**
     *
     * @param size
     */
    public Luolasto(int size) {
        luolasto = new Luola[10][10];
        this.size = size;
        muutos = 0;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void genertoiLuola(int x, int y) {
        if (x >= size || x < 0 || y >= size || y < 0) {
            kasvataTaulukkoa();
        }
        Luola luola = new Luola(size);
        luola.generoi();
        luolasto[x + muutos][y + muutos] = luola;
    }

    /**
     * Metodi vaihtaa luolastotaulukon tilalle tästä kaksi kertaa suuremman
     * taulukon, jonka keskelle tallennetaan vanhan taulukon arvot. Metodi
     * kasvattaa muutos -muuttujaa, siten että hakemalla alkuperäisen taulukon 
     * mukaisilla koordinaateilla palautetaan oikea luola.
     */
    private void kasvataTaulukkoa() {
        muutos = luolasto.length / 2;
        Luola[][] luolasto2 = new Luola[luolasto.length * 2][luolasto.length * 2];
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                luolasto2[muutos + i][muutos + j] = luolasto[i][j];
            }
        }
        luolasto = luolasto2;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Luola getLuola(int x, int y) {
        return luolasto[x + muutos][y + muutos];
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }
}
