import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;/**
 * 此类主要是把控制台输入的内容保存到data.txt中
 * 由于只是实现了你的功能,局部考虑还是不全面..
 *
 * @author greatwqs
 */
public class test1 {
    private static final String fileName = "D://data.txt";
    public static void main(String[] args) throws IOException {
        System.out.println("请你输入一串字符,系统自动保存到D://data.txt文件中!下面请输入你的字串:");
//进行file的初始化...
        File outputFile = new File(fileName);
        if(!outputFile.exists()){
            outputFile.createNewFile();
        }
//捕捉控制台来的字符串..
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)), true);
        String str = in.nextLine();
        if (str != null && str.length() != 0) {
            out.println(str);
        }else{
            out.println("你好,你没有在控制台输入任何字符!");
        }
        System.out.println("你好,请观察你的D盘下的data.txt文件,程序执行完毕.");
        out.close();
        in.close();
    }
}