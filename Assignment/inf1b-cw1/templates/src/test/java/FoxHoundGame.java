import java.util.Arrays;
import java.util.Scanner;

/**
 * The Main class of the fox hound program.
 * <p>
 * It contains the main game loop where main menu interactions
 * are processed and handler functions are called.
 */
public class FoxHoundGame {

    /**
     * This scanner can be used by the program to read from
     * <p>
     * Every scanner should be closed after its use, however, if you do
     * that for StdIn, it will close the underlying input stream as well
     * which makes it difficult to read from StdIn again later during the
     * program.
     * <p>
     * Therefore, it is advisable to create only one Scanner for StdIn
     * over the course of a program and only close it when the program
     * exits. Additionally, it reduces complexity.
     */
    private static final Scanner STDIN_SCAN = new Scanner(System.in);

    /**
     * Swap between fox and hounds to determine the next
     * figure to move.
     *
     * @param currentTurn last figure to be moved
     * @return next figure to be moved
     */
    private static char swapPlayers(char currentTurn) {
        if (currentTurn == FoxHoundUtils.FOX_FIELD) {
            return FoxHoundUtils.HOUND_FIELD;
        } else {
            return FoxHoundUtils.FOX_FIELD;
        }
    }

    /**
     * The main loop of the game. Interactions with the main
     * menu are interpreted and executed here.
     *
     * @param dim     the dimension of the game board
     * @param players current position of all figures on the board in board coordinates
     */
    private static void gameLoop(int dim, String[] players) {

        // start each game with the Fox
        char turn = FoxHoundUtils.FOX_FIELD;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n#################################");
            FoxHoundUI.displayBoard(players, dim);

            int choice = FoxHoundUI.mainMenuQuery(turn, STDIN_SCAN);

            // handle menu choice
            switch (choice) {
                case FoxHoundUI.MENU_MOVE:
                    turn = swapPlayers(turn);
                    String[] brr = FoxHoundUI.positionQuery(dim, STDIN_SCAN);
                    char b;
                    if (turn == 'F') {
                        b = 'H';
                    } else {
                        b = 'F';
                    }
                    boolean isValidMove = FoxHoundUtils.isValidMove(dim, players, b, brr[0], brr[1]);
                    boolean isFoxWin = FoxHoundUtils.isFoxWin(players[players.length - 1]);
                    boolean isHoundWin = FoxHoundUtils.isHoundWin(players, dim);
                    while (!isValidMove) {
                        System.out.println("Invalid move. Try again!");
                        brr = FoxHoundUI.positionQuery(dim, STDIN_SCAN);
                        isValidMove = FoxHoundUtils.isValidMove(dim, players, b, brr[0], brr[1]);
                        isFoxWin = FoxHoundUtils.isFoxWin(players[players.length - 1]);
                        isHoundWin = FoxHoundUtils.isHoundWin(players, dim);
                    }
                    for (int i = 0; i < players.length; i++) {
                        if (players[i].equals(brr[0])) {
                            players[i] = brr[1];
                        }
                    }
                    if (isFoxWin) {
                        System.out.println("The Fox win!");
                        exit = true;
                    }
                    if (isHoundWin) {
                        System.out.println("The Hounds win!");
                        exit = true;
                    }
                    break;
                case FoxHoundUI.MENU_EXIT:
                    exit = true;
                    break;
                default:
                    System.err.println("ERROR: invalid menu choice: " + choice);
            }


        }
    }

    /**
     * Entry method for the Fox and Hound game.
     * <p>
     * The dimensions of the game board can be passed in as
     * optional command line argument.
     * <p>
     * If no argument is passed, a default dimension of
     * {@value FoxHoundUtils#DEFAULT_DIM} is used.
     * <p>
     * Dimensions must be between {@value FoxHoundUtils#MIN_DIM} and
     * {@value FoxHoundUtils#MAX_DIM}.
     *
     * @param args contain the command line arguments where the first can be
     *             board dimensions.
     */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        if (a > 26 || a < 5) {

            int dimension = FoxHoundUtils.DEFAULT_DIM;

            String[] players = FoxHoundUtils.initialisePositions(dimension);
            gameLoop(dimension, players);

            // Close the scanner reading the standard input stream
        } else {

            String[] players = FoxHoundUtils.initialisePositions(a);
            gameLoop(a, players);
            //Close the scanner reading the standard input stream
        }
        STDIN_SCAN.close();

    }
}