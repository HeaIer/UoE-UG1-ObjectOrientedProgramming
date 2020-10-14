package Week2.Q12;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ImQuadraticSolver {
    public static  void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        if ( a != 0 ) {
            if (sqrt((b*b)-4*a*c) >= 0){
            double e = ((-b + sqrt((b*b)-4*a*c)) /2*a);
            double d = ((-b - sqrt((b*b)-4*a*c)) /2*a);
            System.out.println(e);
            System.out.println(d);}
            else{
                double i = (-b/2*a);
                double k =  abs((sqrt(abs((b*b)-4*a*c)) /2*a));
                double j = (-b/2*a);
                double h =  abs((sqrt(abs((b*b)-4*a*c))) /2*a);
                System.out.println(i+" "+"+"+" "+k+"i");
                System.out.println(i+" "+"-"+" "+k+"i");
            }
        } else {
            double k = -c/b;
           System.out.println(k);
        }


}}