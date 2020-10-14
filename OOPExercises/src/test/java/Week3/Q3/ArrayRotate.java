package Week3.Q3;

import java.util.Arrays;

public class ArrayRotate {
    public static void main(String[] args) {

        int[] num = new int[args.length];
        int[] copy = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            num[i] = Integer.parseInt(args[i]);
        }

        for (int i = 0; i < num.length-1; i++) {
            copy[i] = num[i+1];
        }
        copy[num.length-1] = num[0];
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i]);
            System.out.print(" ");
        }
    }
}