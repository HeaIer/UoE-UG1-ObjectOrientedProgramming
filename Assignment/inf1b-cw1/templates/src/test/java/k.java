import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Arrays;

public class k {
    public static void main(String[] args) {

    String[] player = {"B1","D1","F1","H1","E8"};
        char b = '#';
        if(player.length>5){
            throw new IllegalArgumentException();
        }  else {

            b = '#';
            char[] a = {'A','B','C','D','E','F','G','H'};



String pathname = "E:\\School Documents\\Edinburgh\\1B Year\\Object Oriented Programming\\Assignment\\inf1b-cw1\\templates\\invalidGame03.txt";

            String line = "";
            try {

                String encoding = "UTF-8";
                File file = new File(pathname);
                if (file.isFile() && file.exists()) {
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file), encoding);
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String strBrr = null;
                    while ((strBrr = bufferedReader.readLine()) != null) {
                        String[] strArr = strBrr.split(" ");
                        System.out.println(Arrays.toString(strArr));
                        System.out.println(strArr.length);
                        if (strArr.length == 6 && Integer.parseInt(strArr[strArr.length - 1].substring(1)) < 8&&strArr[0].length()==1) {
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
                        }
                        System.out.println(Arrays.toString(player));}

                    read.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


}}