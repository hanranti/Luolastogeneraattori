package luolastogeneraattori;

/**
 *
 * @author Hannu
 */
public class GUI {

    private Pelaaja pelaaja;
    
    /**
     *
     * @param pelaaja
     */
    public GUI(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
     *
     * @param luola
     */
    public void piirra(boolean[][] luola) {
        for (int i = 0; i < luola.length; i++) {
            for (int j = 0; j < luola[0].length; j++) {
                if (i == pelaaja.getX() && j == pelaaja.getY()) {
                    System.out.print("@");
                } else if (luola[i][j]) {
                    System.out.print("x");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println("");
        }
    }
}
