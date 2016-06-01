package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import luolasto.Luolasto;
import luolasto.Pelaaja;

/**
 *
 * @author hanranti
 */
public class NappaimistonKuuntelija extends JFrame implements KeyListener {

    private Pelaaja pelaaja;
    private Luolasto luolasto;
    private GUI gui;

    public NappaimistonKuuntelija(Luolasto luolasto, Pelaaja pelaaja, GUI gui) {
        super("frame");
        this.luolasto = luolasto;
        this.pelaaja = pelaaja;
        this.gui = gui;
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.liikutaOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.liikutaVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.liikutaYlos();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.liikutaAlas();
        } //        else if (s.equals("exit")) {
        //            break;
        //        } 
        else if (e.getKeyCode() == KeyEvent.VK_M) {
            pelaaja.merkkaa();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gui.tulosta(
                luolasto.getLuola(
                        pelaaja.getLuolaX(),
                        pelaaja.getLuolaY())
                .getLuola(),
                pelaaja);
    }

}
