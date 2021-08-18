import java.util.Scanner;

public class Projectile
{
    Scanner input = new Scanner(System.in);
    private final static double G =9.8;
    public static double calculateMaxHeight(double vel)
    {
        double hMax = Math.pow(vel, 2)/(2*6);
        return hMax;
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" Please enter the initial Velocity: ");

        double vel = scan.nextDouble();
        double hMax = calculateMaxHeight(vel);
        System.out.println(" The max height is " + hMax);
    }
}