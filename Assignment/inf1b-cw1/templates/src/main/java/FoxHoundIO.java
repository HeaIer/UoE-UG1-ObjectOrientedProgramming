/**
 * A utility class for the fox hound program.
 *
 * It contains helper functions for all file input / output
 * related operations such as saving and loading a game.
 */

/**
 * A utility class for the fox hound program.
 *
 * It contains helper functions for all file input / output
 * related operations such as saving and loading a game.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
public class FoxHoundIO {

    public static boolean saveGame(String[] player, char figure, Path path) throws IOException {
        boolean b = false;

        File outputFile = new File(path.toString());
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)), true);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < player.length; i++){
            sb. append(player[i]+" ");
        }
        String s = sb.toString();
        String str = figure + " " + s;
        if (str != null && str.length() != 0) {
            out.println(str);
            b = true;
        } else {
            b = false;
        }
    return b;}
}