public class CircleBugs {

    public static void main(String[] args){
        double t = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[0]); // Needs to be a accept double

        System.out.println("r = " + r + ", t = " + t); //All statements must end with ;

        double c = 2 * Math.PI * r;
        double a = Math.PI * r * r;

        double x = r * Math.cos(t);
        double y = r * Math.sin(t);
        
        System.out.println("c = " + c);
        System.out.println("A = " + a);
        System.out.println("x = " + x + ", " + "y = " + y);
        }
}