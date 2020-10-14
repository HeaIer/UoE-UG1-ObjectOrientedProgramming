import com.sun.org.apache.xpath.internal.objects.XString;

import static java.lang.Math.sqrt;

public class QuadraticSolver {
    public static  void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double e = (-b + sqrt(Math.pow(b, 2)-4*a*c) /2*a);
        double d = (-b - sqrt(Math.pow(b, 2)-4*a*c) /2*a);
        System.out.println(a);
        System.out.println(c);
}}
