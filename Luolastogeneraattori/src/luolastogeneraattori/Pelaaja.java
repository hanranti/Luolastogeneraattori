package luolastogeneraattori;

public class Pelaaja {

    private int x, y, luolaX, luolaY;
    private Luolasto luolasto;

    public Pelaaja(int x, int y, int luolaX, int luolaY, Luolasto luolasto) {
        this.x = x;
        this.y = y;
        this.luolaX = luolaX;
        this.luolaY = luolaY;
        this.luolasto = luolasto;
    }

    public void liikutaYlos() {
        y--;
        if (y < 0) {
            luolaY--;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = luolasto.getSize() - 1;
        }
    }

    public void liikutaAlas() {
        y++;
        if (y > luolasto.getSize() - 1) {
            luolaY++;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = 0;
        }
    }

    public void liikutaOikealle() {
        x++;
        if (x > luolasto.getSize() - 1) {
            luolaX++;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = 0;
        }
    }

    public void liikutaVasemmalle() {
        x--;
        if (x < 0) {
            luolaX--;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = luolasto.getSize() - 1;
        }
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
