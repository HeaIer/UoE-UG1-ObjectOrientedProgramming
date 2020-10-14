import java.util.Arrays;

/**
 * A utility class for the fox hound program.
 * <p>
 * It contains helper functions to check the state of the game
 * board and validate board coordinates and figure positions.
 */
public class FoxHoundUtils {

    // ATTENTION: Changing the following given constants can 
    // negatively affect the outcome of the auto grading!

    /**
     * Default dimension of the game board in case none is specified.
     */
    public static final int DEFAULT_DIM = 8;
    /**
     * Minimum possible dimension of the game board.
     */
    public static final int MIN_DIM = 4;
    /**
     * Maximum possible dimension of the game board.
     */
    public static final int MAX_DIM = 26;

    /**
     * Symbol to represent a hound figure.
     */
    public static final char HOUND_FIELD = 'H';
    /**
     * Symbol to represent the fox figure.
     */
    public static final char FOX_FIELD = 'F';

    // HINT Write your own constants here to improve code readability ...

    public static String[] initialisePositions(int dimension) {
        if (dimension < 0) {
            throw new IllegalArgumentException();
        } else {
            int a = 0;
            if (dimension > 26 || dimension < 4) {
                a = 8;
            } else {
                if (dimension % 2 == 0) {
                    a = (dimension);
                } else {
                    a = (dimension - 1);
                }
            }
            String[] arr = new String[a / 2 + 1];
            String[] brr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            for (int i = 0; i < a; i++) {
                if (i == a - 1&&dimension%2==0) {
                    arr[i / 2 + 1] = brr[a / 2] + (a);
                }
                if (i == a - 1&&dimension%2!=0) {
                    arr[i / 2 + 1] = brr[a / 2] + (dimension);
                }
                if ((i % 2) == 0) {
                    arr[i / 2] = brr[i + 1] + "1";
                }
            }
            return arr;
        }
    }


    public static boolean isValidMove(int dimension, String[] players, char figure, String origin, String destination) {
        boolean a;
        boolean b = true;
        boolean f;
        boolean g = true;
        boolean h = true;
        boolean p = true;
        boolean x = true;
        boolean y = true;
        boolean z = true;
        boolean kb = true;
        int d = 0;
        int c = Integer.parseInt(destination.substring(1));
        char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < e.length; i++) {
            if (destination.charAt(0) == e[i]) {
                d = i;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (destination.charAt(0) == origin.charAt((0)) + 1 || destination.charAt(0) == origin.charAt((0)) + -1) {
                kb = true;
            } else {
                kb = false;
            }
        }
        if (dimension > c && dimension > d)//This is a move error
        {
            a = true;
        } else {
            a = false;
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals(origin)) {
                b = true;
                break;
            } else {
                b = false;
            }
        }

        if (figure == 'H') {
            if (Integer.parseInt(destination.substring(1)) == Integer.parseInt(origin.substring(1)) + 1) {
                g = true;
            } else {
                g = false;
            }
        }
        if (figure == 'F') {
            if (Integer.parseInt(origin.substring(1)) == dimension) {
                if ((Integer.parseInt(destination.substring(1)) == Integer.parseInt(origin.substring(1)) - 1)) {
                    h = true;
                } else {
                    h = false;
                }
            }
        }
        if (figure == 'H') {
            for (int i = 0; i < players.length - 1; i++) {
                if (players[i].equals(origin)) {
                    x = true;
                    break;
                } else {
                    x = false;
                }
            }
        }
        if (figure == 'F') {
            if (players[players.length - 1].equals(origin)) {
                y = true;
            } else {
                y = false;
            }
        }
        for (int i = 0; i < players.length; i++) {
            if (destination.equals(players[i])) {
                z = false;
                break;
            } else {
                z = true;
            }
        }

        return (a && b && g && h && p && x && y && z && kb);
    }


    public static boolean isFoxWin(String Player) {
        boolean b;
        if (Integer.parseInt(Player.substring(1)) == 1) {
            b = true;
        }
        else{
            b= false;
        }
    return  b;}

    public static boolean isHoundWin(String[] Player,int dim) {
        if(dim<5){
            throw new IllegalArgumentException();
        }
        else{
        char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean l = false;
        boolean m = false;
        boolean n = false;
        boolean ab = false;
        boolean ac = false;
        boolean ad = false;
        boolean ax = false;
        boolean ak = false;
        boolean aj = false;
        boolean az = false;
        if (Integer.parseInt(Player[Player.length - 1].substring(1)) != 1&&Integer.parseInt(Player[Player.length - 1].substring(1)) != dim && Player[Player.length - 1].charAt(0) != e[dim - 1] && Player[Player.length - 1].charAt(0) != 'A') {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    a = true;
                    break;
                } else {
                    a = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    b = true;
                    break;
                } else {
                    b = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) + 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    c = true;
                    break;
                } else {
                    c = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) + 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    d = true;
                    break;
                } else {
                    d = false;
                }

            }
            f = a && b && c && d;
        } else {
            f = false;
        }


        if (Integer.parseInt(Player[Player.length - 1].substring(1)) != 1&&Integer.parseInt(Player[Player.length - 1].substring(1)) == dim && Player[Player.length - 1].charAt(0) != e[dim - 1] && Player[Player.length - 1].charAt(0) != 'A') {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    g = true;
                    break;
                } else {
                    g = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    h = true;
                    break;
                } else {
                    h = false;
                }

            }
            l = g && h;
        } else {
            l = false;
        }

        if (Integer.parseInt(Player[Player.length - 1].substring(1)) == dim && Player[Player.length - 1].charAt(0) == e[dim - 1] ) {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    m = true;
                    break;
                } else {
                    m = false;
                }

            }
        } else {
            m = false;
        }

        if (Integer.parseInt(Player[Player.length - 1].substring(1)) != 1&&Integer.parseInt(Player[Player.length - 1].substring(1)) == dim && Player[Player.length - 1].charAt(0) == 'A' ) {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    n = true;
                    break;
                } else {
                    n = false;
                }

            }
        } else {
            n = false;
        }

        if (Integer.parseInt(Player[Player.length - 1].substring(1)) != 1&&Integer.parseInt(Player[Player.length - 1].substring(1)) != dim && Player[Player.length - 1].charAt(0) != e[dim - 1] && Player[Player.length - 1].charAt(0) == 'A') {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    ac = true;
                    break;
                } else {
                    ac = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) + 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) + 1 == Player[i].charAt(0)) {
                    ad = true;
                    break;
                } else {
                    ad = false;
                }

            }

            ab = ac &&ad;
        }

        else {
            ab = false;
        }

        if (Integer.parseInt(Player[Player.length - 1].substring(1)) != 1&&Integer.parseInt(Player[Player.length - 1].substring(1)) != dim && Player[Player.length - 1].charAt(0) == e[dim - 1] && Player[Player.length - 1].charAt(0) != 'A') {
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) - 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    ak = true;
                    break;
                } else {
                    ak = false;
                }

            }
            for (int i = 0; i < Player.length; i++) {
                if (Integer.parseInt(Player[Player.length - 1].substring(1)) + 1 == (Integer.parseInt(Player[i].substring(1))) && Player[Player.length - 1].charAt(0) - 1 == Player[i].charAt(0)) {
                    aj = true;
                    break;
                } else {
                    aj = false;
                }

            }

            ax = ak &&aj;
        }

        else {
            ax = false;
        }
        az= ax||ab||n||l||m||f;
        return az; }}
}