package luolasto;

/**
 *
 * @author Hannu
 */
public class Luolasto {

    private Luola[][] luolasto;
    private int size;

    /**
     *
     * @param size
     */
    public Luolasto(int size) {
        luolasto = new Luola[10][10];
        this.size = size;
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
        luolasto[x][y] = luola;
    }

    private void kasvataTaulukkoa() {
        Luola[][] luolasto2 = new Luola[size * 2][size * 2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                luolasto2[size / 2 + i][size / 2 + j] = luolasto[i][j];
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
        return luolasto[x][y];
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }
}
