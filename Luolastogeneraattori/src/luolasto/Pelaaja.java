package luolasto;

import luolasto.Luolasto;

/**
 *
 * @author Hannu
 */
public class Pelaaja {

    private int x, y, luolaX, luolaY, size;
    private Luolasto luolasto;

    /**
     *
     * @param x
     * @param y
     * @param luolaX
     * @param luolaY
     * @param luolasto
     */
    public Pelaaja(int x, int y, int luolaX, int luolaY, Luolasto luolasto, int size) {
        this.x = x;
        this.y = y;
        this.luolaX = luolaX;
        this.luolaY = luolaY;
        this.luolasto = luolasto;
        this.size = size;
    }

    /**
     *
     */
    public void liikutaYlos() {
        if (y - 1 >= 0 && luolasto.getLuola(luolaX, luolaY).getLuola()[x][y - 1]) {
            return;
        }
        y--;
        if (y < 0) {
            luolaY--;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = luolasto.getSize() - 1;
        }
    }

    /**
     *
     */
    public void liikutaAlas() {
        if (y >= size && luolasto.getLuola(luolaX, luolaY).getLuola()[x][y + 1]) {
            return;
        }
        y++;
        if (y > luolasto.getSize() - 1) {
            luolaY++;
            luolasto.genertoiLuola(luolaX, luolaY);
            y = 0;
        }
    }

    /**
     *
     */
    public void liikutaOikealle() {
        if (x >= size && luolasto.getLuola(luolaX, luolaY).getLuola()[x + 1][y]) {
            return;
        }
        x++;
        if (x > luolasto.getSize() - 1) {
            luolaX++;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = 0;
        }
    }

    /**
     *
     */
    public void liikutaVasemmalle() {
        if (x - 1 >= 0 && luolasto.getLuola(luolaX, luolaY).getLuola()[x - 1][y]) {
            return;
        }
        x--;
        if (x < 0) {
            luolaX--;
            luolasto.genertoiLuola(luolaX, luolaY);
            x = luolasto.getSize() - 1;
        }
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public int getLuolaX() {
        return luolaX;
    }

    /**
     *
     * @return
     */
    public int getLuolaY() {
        return luolaY;
    }
}
