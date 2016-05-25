package luolastogeneraattori;

public class Luolasto {

    private Luola[][] luolasto;
    private int size;

    public Luolasto(int size) {
        luolasto = new Luola[10][10];
        this.size = size;
    }

    public void genertoiLuola(int x, int y) {
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

    public Luola getLuola(int x, int y) {
        return luolasto[x][y];
    }

    public int getSize() {
        return size;
    }
}
