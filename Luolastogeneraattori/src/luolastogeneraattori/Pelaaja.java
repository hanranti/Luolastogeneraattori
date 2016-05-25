package luolastogeneraattori;

public class Pelaaja {

    private int x, y, luolaX, luolaY;

    public Pelaaja(int x, int y, int luolaX, int luolaY) {
        this.x = x;
        this.y = y;
        this.luolaX = luolaX;
        this.luolaY = luolaY;
    }

    public void liikutaYlos() {
        y--;
    }

    public void liikutaAlas() {
        y++;
    }

    public void liikutaOikealle() {
        x++;
    }

    public void liikutaVasemmalle() {
        x--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLuolaX() {
        return luolaX;
    }

    public int getLuolaY() {
        return luolaY;
    }
}
