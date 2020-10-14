/**
 * A utility class for the fox hound program.
 * <p>
 * It contains helper functions for all file input / output
 * related operations such as saving and loading a game.
 * <p>
 * A utility class for the fox hound program.
 * <p>
 * It contains helper functions for all file input / output
 * related operations such as saving and loading a game.
 */

/**
 * A utility class for the fox hound program.
 *
 * It contains helper functions for all file input / output
 * related operations such as saving and loading a game.
 */


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FoxHoundIO {

    public static boolean saveGame(String[] player, char figure, Path path1) {
        boolean b = false;
        boolean a = false;
        if (player.length != 5 && Integer.parseInt(player[player.length - 1].substring(1)) > 8) {
            throw new IllegalArgumentException();
        } else {
            a = true;
        }
        Path path = path1.toAbsolutePath();
        if (path1.toString().charAt(0) != 'p') {
            a = true;
            File outputFile = new File(path.toString());
            if (!outputFile.exists()) {
                try {
                    outputFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < player.length; i++) {
                sb.append(player[i] + " ");
            }
            String s = sb.toString();
            String str = figure + " " + s;
            if (str != null && str.length() != 0) {
                out.println(str);
                b = true;
            } else {
                b = false;
            }
        } else {
            a = false;
        }


        return b && a;
    }

    public static char loadGame(String[] player, Path path1) {
        char b = '#';
        if(player.length>5){
            throw new IllegalArgumentException();
        }  else {

            Path path = path1.toAbsolutePath();
            b = '#';
            char[] a = {'A','B','C','D','E','F','G','H'};





                String line = "";
                try {

                    String pathname = path.toString();
                    String encoding = "UTF-8";
                    File file = new File(pathname);
                    if (file.isFile() && file.exists()) {
                        InputStreamReader read = new InputStreamReader(
                                new FileInputStream(file), encoding);
                        BufferedReader bufferedReader = new BufferedReader(read);
                        String strBrr = null;
                        while ((strBrr = bufferedReader.readLine()) != null) {
                            String[] strArr = strBrr.split(" ");
                            if (strArr.length == 6 && Integer.parseInt(strArr[strArr.length - 1].substring(1)) < 8&&strArr[0].length()==1&&!Character.isDigit(strArr[1].charAt(0))&&((strArr[0].charAt(0))=='F'||(strArr[0].charAt(0))=='H')&&Integer.parseInt(strArr[1].substring(1)) < 8) {
                                b = strArr[0].charAt(0);
                                player[0] = strArr[1];
                                player[1] = strArr[2];
                                player[2] = strArr[3];
                                player[3] = strArr[4];
                                player[4] = strArr[5];
                            }else{
                                b = '#';
                                player[0] = player[0];
                                player[1] = player[1];
                                player[2] = player[2];
                                player[3] = player[3];
                                player[4] = player[4];
                    }}
                        read.close();}
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

   return b;}}