import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Objects;

/**
 * A utility class for the fox hound program.
 * <p>
 * It contains helper functions for all user interface related
 * functionality such as printing menus and displaying the game board.
 */
public class FoxHoundUI {

    /**
     * Number of main menu entries.
     */
    private static final int MENU_ENTRIES = 2;
    /**
     * Main menu display string.
     */
    private static final String MAIN_MENU =
            "\n1. Move\n2. Exit\n\nEnter 1 - 2:";

    /**
     * Menu entry to select a move action.
     */
    public static final int MENU_MOVE = 1;
    /**
     * Menu entry to terminate the program.
     */
    public static final int MENU_EXIT = 2;

    public static void displayBoard(String[] Player, int dimension) {
        if (dimension < 10) {
            System.out.print("  ");
        } else {
            System.out.print("   ");
        }
        String[] brr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        char[] b = new char[Player.length];
        int[] c = new int[Player.length];
        char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < Player.length; i++) {
            b[i] = Player[i].charAt(0);
            c[i] = Integer.parseInt(Player[i].substring(1))-1;
        }
        int[] d = new int[Player.length];
        for (int i = 0; i < Player.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (b[i] == e[j]) {
                    d[i] = j;
                }
            }
        }

        for (int i = 0; i < dimension; i++) {
            System.out.print(brr[i]);
        }
        System.out.print("  " + "\n" + "\n");
        for (int i = 0; i < dimension; i++) {
            if (dimension >= 10) {
                if (i <= 8) {
                    System.out.print("0" + (i + 1));
                } else {
                    System.out.print(i + 1);
                }
            } else {
                System.out.print(i + 1);
            }
            System.out.print(" ");
            for (int j = 0; j < dimension; j++) {
                String[][] drr = new String[dimension][dimension];

                for (int k = 0; k < Player.length; k++) {
                    if (j == d[k] && i == c[k] && k<Player.length-1) {
                        drr[j][i] = "H";
                        break;
                    } else if (j == d[k] && i == c[k]&&k==Player.length-1) {
                        drr[j][i] = "F";

                    } else {
                        drr[j][i] = ".";
                    }
                }

                System.out.print(drr[j][i]);
            }
            System.out.print(" ");
            if (dimension >= 10) {
                if (i <= 8) {
                    System.out.print("0" + (i + 1) + "\n");
                } else {
                    System.out.print(i + 1 + "\n");
                }
            } else {
                System.out.print(i + 1 + "\n");
            }
        }
        if (dimension < 10) {
            System.out.print("\n");
            System.out.print("  ");
        } else {
            System.out.print("\n");
            System.out.print("   ");
        }
        for (int i = 0; i < dimension; i++) {
            System.out.print(brr[i]);
        }
        System.out.print("  \n\n");
    }


    /**
     * Print the main menu and query the user for an entry selection.
     *
     * @param figureToMove the figure type that has the next move
     * @param stdin        a Scanner object to read user input from
     * @return a number representing the menu entry selected by the user
     * @throws IllegalArgumentException if the given figure type is invalid
     * @throws NullPointerException     if the given Scanner is null
     */
    public static int mainMenuQuery(char figureToMove, Scanner stdin) {
        Objects.requireNonNull(stdin, "Given Scanner must not be null");
        if (figureToMove != FoxHoundUtils.FOX_FIELD
                && figureToMove != FoxHoundUtils.HOUND_FIELD) {
            throw new IllegalArgumentException("Given figure field invalid: " + figureToMove);
        }

        String nextFigure =
                figureToMove == FoxHoundUtils.FOX_FIELD ? "Fox" : "Hounds";

        int input = -1;
        while (input == -1) {
            System.out.println(nextFigure + " to move");
            System.out.println(MAIN_MENU);

            boolean validInput = false;
            if (stdin.hasNextInt()) {
                input = stdin.nextInt();
                validInput = input > 0 && input <= MENU_ENTRIES;
            }

            if (!validInput) {
                System.out.println("Please enter valid number.");
                input = -1; // reset input variable
            }

            stdin.nextLine(); // throw away the rest of the line
        }

        return input;
    }

    public static String[] positionQuery(int dim, Scanner stdin) {
            String[] brr = new String[2];
            brr[0] = "28";
        while (brr[0] == "28") {
            char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            String[] arr = new String[2];
            System.out.println("Provide origin and destination coordinates.\n" + "Enter two positions between A1-H8:");
            if (stdin.hasNext()) {
                arr[0] = stdin.next();
            } else {
                arr[0] = null;
            }
            if (stdin.hasNext()) {
                arr[1] = stdin.next();
            } else {
                arr[1] = null;
            }
            assert arr[0] != null;
            int length1 = arr[0].length();
            assert arr[1] != null;
            int length2 = arr[1].length();

            if (length1<=3&&length2<=3&&Character.isDigit(arr[0].charAt(1))&&Character.isDigit(arr[1].charAt(1))&&Character.isLetter(arr[0].charAt(0))&&Character.isLetter(arr[1].charAt(0))){
                for (int i = 0; i < e.length; i++) {
                    if (arr[0].charAt(0) == e[i] && Integer.parseInt(arr[0].substring(1)) <= dim && Integer.parseInt(arr[1].substring(1)) <= dim) {
                        brr = arr;
                        break;
                    } else {
                        brr[0] = "28";
                    }}}
            else{
                brr[0] = "28";
            }
            if(brr[0] == "28"){
                System.out.println();
                System.err.println("ERROR: Please enter valid coordinate pair separated by space.\n");
            }

            stdin.nextLine();
        }
            return(brr);}

    public static Path fileQuery(Scanner stdin) {
        System.out.println("Enter file path:");
    String path1;
        path1 = stdin.nextLine();
        Path relative = Paths.get(path1);
        return relative;
    }}