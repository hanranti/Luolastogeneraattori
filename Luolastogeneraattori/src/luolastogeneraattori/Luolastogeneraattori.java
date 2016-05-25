package luolastogeneraattori;

public class Luolastogeneraattori {

    public static void main(String[] args) {
        int size = 32;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
        
        Luolasto luolasto = new Luolasto();
    }

}
