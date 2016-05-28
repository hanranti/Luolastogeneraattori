package luolasto;

/**
 * Luokka sisältää boolean[][] taulukon, joka määrittää yksittäisen luolan 
 * seinät ja avoimet alueet. True kuvaa seinää ja false avointa aluetta.
 *
 * @author Hannu
 */
public class Luola {

    boolean[][] luola;
    int size;

    /**
     * Metodi luo Luola -olion. Metodi ottaa parametrina int size muuttujan,
     * joka määrittää luolan leveyden ja korkeuden.
     *
     * @param size
     */
    public Luola(int size) {
        this.size = size;
        luola = new boolean[size][size];
    }

    /**
     * Metodi generoi luolaan seiniä ja avoimia alueita. Luolaan luodaan 
     * satunnaisesti huoneita, uloskäyntejä ja näitä yhdistäviä käytäviä.
     *
     */
    public void generoi() {
        for (int i = 0; i < luola.length; i++) {
            for (int j = 0; j < luola[0].length; j++) {
                if (i == 0 || j == 0 || i == luola.length - 1 || j == luola[0].length - 1) {
                    luola[i][j] = true;
                }
            }
        }
        luola[0][(luola.length - 1) / 2] = false;
        luola[luola.length - 1][(luola.length - 1) / 2] = false;
        luola[(luola.length - 1) / 2][0] = false;
        luola[(luola.length - 1) / 2][luola.length - 1] = false;
    }

    /**
     * Metodi palauttaa yksittäistä luolaa kuvaavan boolean[][] -taulukon.
     *
     * @return
     */
    public boolean[][] getLuola() {
        return luola;
    }
}
