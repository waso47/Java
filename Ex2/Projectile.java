import java.util.Scanner;

public class Projectile
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" Please enter the initial Velocity: ");

        double vel = scan.nextDouble();
        double hMax = Trajectory.calculateMaxHeight(vel);
        System.out.println(" The max height is " + hMax);
    }
}
// As the calculateMaxHeight method is moved to a separate class we
// need to define the class using Trajectory.calculateMaxHeight.
// This tells the program to use the calculateMaxHeight method,
// in the Trajectory class.