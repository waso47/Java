import java.util.Scanner;

public class ComputePI
{
    public static void main(String[] args)
    {
        double sum = 0;
        double PI = 0;
        double k = 1;
        double n = 1;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        long numOfIterations = scan.nextLong();

        // number entered can be <100 or any other number
        while(n<numOfIterations)
        {
            //calculate sum
            sum+=k/n;
            n=n+2;
            k*=-1;

            //Calculate value of PI
            PI = 4*sum;
        }
        //Print output
        System.out.println("PI = " + PI);
        System.out.printf("The result in percents of Math.PI = %.12f%% ", 100*PI/Math.PI);
    }
}