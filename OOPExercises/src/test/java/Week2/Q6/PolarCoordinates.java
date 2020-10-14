import static java.lang.StrictMath.atan;

public class PolarCoordinates {
    public static void main(String[] args){
      double x = Double.parseDouble(args[0]);
      double y = Double.parseDouble(args[1]);
      double r = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
      double z = atan(y/x);
      System.out.println(r);
      System.out.println(z);


}}
