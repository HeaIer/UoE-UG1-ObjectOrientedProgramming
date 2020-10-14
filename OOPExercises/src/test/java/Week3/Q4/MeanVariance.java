package Week3.Q4;
public class MeanVariance {
    public static void main(String[] args){

       double[] sum =  new double[args.length];
        double add = 0;
        double okk = 0;
        for (int i = 0; i < args.length ; i++) {
                sum[i] = Double.parseDouble(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            add = add + sum[i];
        }
        double abb = add/(sum.length);
        System.out.println(abb);
        for (int i = 0; i <sum.length; i++) {
            okk = okk+ (sum[i]-abb)*(sum[i]-abb);
        }
        System.out.println(okk/(sum.length));
        }
    }