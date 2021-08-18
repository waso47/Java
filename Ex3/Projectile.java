import java.util.Scanner;

public class Projectile
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" Please enter the initial Velocity: ");

        double vel = scan.nextDouble();
        Trajectory t = new Trajectory();
        double hMax = t.calculateMaxHeight(vel);
        System.out.println(" The max height is " + hMax);
    }
}
// As none of the code in the Trajectory class is static we need to create an
// instance of Trajectory class. This is done in line 11 using Trajectory t = new Trajectory
// we then call the calculateMaxHeight from this instance.