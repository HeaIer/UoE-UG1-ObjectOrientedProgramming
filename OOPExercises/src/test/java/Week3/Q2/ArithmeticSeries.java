package Week3.Q2;

public class ArithmeticSeries {
    public static  void main(String args[]){
        int a = Integer.parseInt(args[0]);
        int b = 1, k = 1;
        while(b<a){
            b++;
            k = b + k;
        }
        System.out.println(k);
    }
}
