package Week3.Q5;
import java.util.Arrays;

public class TempMedian {
    public static void main(String[] args) {
        String[] sum = new String[args.length];
        int[] add = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sum[i] = args[i];
        }
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                add[i] = Integer.parseInt(sum[i]);
            }
            if ((sum[i]).equals("+")) {
                add[i] = add[i - 1] + 1;
            }
            if (sum[i].equals(".")) {
                add[i] = add[i - 1];
            }
            if (sum[i].equals("-")) {
                add[i] = add[i - 1] - 1;
            }
            System.out.print(add[i] + " ");

        }
        System.out.println();
        Arrays.sort(add);
        for (int i = 0; i < add.length; i++) {
            System.out.print(add[i] + " ");
        }
        System.out.println();
        if (add.length % 2 != 0){
            double a = add[(add.length+1)/2-1];
            System.out.println(a);
        }
        if (add.length %2 == 0){
            double b = ((add[(add.length)/2])+(add[(add.length)/2-1]));
            System.out.println(b/2);
        }

    }}


