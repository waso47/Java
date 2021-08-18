import java.util.Scanner;

public class SumAndAverage2
{
    public static void main(String[] args)
    {
        int n; 
        int i=0; 
        int sum=0;
        // to get user input number
        System.out.println("-----------------");
        System.out.print("Please input a positive integer number: ");

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        //checking to find if users input is valid, if n is not valid ask for reentry of a positve integer.
        while(n<1)
        {
            System.out.print("Please re-enter a valid value: ");
            n = scan.nextInt();
        }
        do
        {
            sum+=i;
            i++;
        } while(i <= n);

        //Calculate the average
        double ave = (double)sum/n;


        // Print the results
        System.out.println("The sum from 1 to " + n + " is: " + sum);
        System.out.println("The average is: " + ave);
        System.out.println("---------------");


    }
}