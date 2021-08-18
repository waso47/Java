import java.util.Scanner;

public class Projectile
{
    Scanner input = new Scanner(System.in);
    private final double G = 9.8;

    private double calculateMaxHeight(double vel)
    {
        return Math.pow(vel, 2)/(2*6);
        
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" Please enter the initial Velocity: ");

        
        double vel = scan.nextDouble();
        Projectile p = new Projectile();
        
        double hMax = p.calculateMaxHeight(vel);
        System.out.println(" The max height is " + hMax);
    }
}

