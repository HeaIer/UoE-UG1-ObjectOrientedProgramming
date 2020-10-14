package Week3.Q6;
import java.util.Arrays;

public class Mode {

    public static void main(String[] args) {
        int[] a = new int[10];
        int aa = 1;
        int ab = 1;
        int ac = 1;
        int ad = 1;
        int af = 1;
        int ag = 1;
        int ah = 1;
        int ai = 1;
        int aj = 1;
        int ak = 1;
        String str = ".";
        for (int i = 0; i <args.length ; i++) {
          if(Integer.parseInt(args[i]) == 0){
              a[0]  =  aa++;
          }
            if(Integer.parseInt(args[i]) == 1){
                a[1]  =  ab++;
            }
            if(Integer.parseInt(args[i]) == 2){
                a[2]  =  ac++;
            }
            if(Integer.parseInt(args[i]) == 3){
                a[3]  =  ad++;
            }
            if(Integer.parseInt(args[i]) == 4){
                a[4]  =  af++;
            }
            if(Integer.parseInt(args[i]) == 5){
                a[5]  =  ag++;
            }
            if(Integer.parseInt(args[i]) == 6){
                a[6]  =  ah++;
            }
            if(Integer.parseInt(args[i]) == 7){
                a[7]  =  ai++;
            }
            if(Integer.parseInt(args[i]) == 8){
                a[8]  =  aj++;
            }
            if(Integer.parseInt(args[i]) == 9){
                a[9]  =  ak++;
            }

        }
        for (int i = 0; i <=9 ; i++) {
            System.out.println("["+i +"s: "+a[i]+"]" +" "+ str.repeat(a[i]));
        }
        int max = getMax(a);
        int positon = Arrays.binarySearch(a, max);
        System.out.println("Mode: "+positon);
        }


    public static int getMax(int[] arr) {

        int max = arr[0];

        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max)
                max = arr[x];

        }
        return max;
    }}
