package Week1.Q7.SaferDivider;

public class SaferDivider {
    public static void main(String[] args ){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        if ( b == 0 ) {
            System.out.println("I can't divide by zero!");
        } else {
            System.out.println(a/b);
        }
    }
}
