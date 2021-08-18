import java.lang.Math;
import java.util.Scanner;

class Cartesian
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the radius (r) of the circle: ");
        double r = Double.parseDouble(input.nextLine());

        System.out.print("Please enter the angle: ");
        double angle = Double.parseDouble(input.nextLine());

        double x =  r * Math.cos(r);
        double y = r * Math.sin(r);

        System.out.printf("x = %.1f and y = %.1f", x, y);

        input.close();
    }
}