package luolasto;

/**
 *
 * @author Hannu
 */
public class Luola {

    boolean[][] luola;
    int size;

    /**
     *
     * @param size
     */
    public Luola(int size) {
        this.size = size;
        luola = new boolean[size][size];
    }

    /**
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
     *
     * @return
     */
    public boolean[][] getLuola() {
        return luola;
    }
}
