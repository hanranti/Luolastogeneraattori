package luolastogeneraattori;

public class Pelaaja {

    private int x, y, luolaX, luolaY;

    public Pelaaja(int x, int y, int luolaX, int luolaY) {
        this.x = x;
        this.y = y;
        this.luolaX = luolaX;
        this.luolaY = luolaY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
