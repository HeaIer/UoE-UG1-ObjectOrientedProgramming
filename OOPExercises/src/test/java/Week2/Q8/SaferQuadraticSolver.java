import static java.lang.Math.sqrt;

public class SaferQuadraticSolver {
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
                System.out.println("Equation is not solvable for real x.");
            }
        } else {
           System.out.println("A = 0. Cannot solve equation.");
        }


}}