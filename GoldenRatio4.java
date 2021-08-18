import java.util.Scanner;

public class GoldenRatio4
{
    public static void main(String[] args)
    {
    int n;

    //Get n from user
    Scanner scan = new Scanner(System.in);
    System.out.print("Please input positive number n: ");
    n = scan.nextInt();

    //Calculates the golden ration using recusion method calcGoldenRatio()
    System.out.printf("The golden ration for %d in %.15f", n, calcGoldenRatio(n));
    }

    //A recursion method to calculate the golden ratio
    public static double calcGoldenRatio(int n)
    {
        if (n == 0)
        {
            return 1; //base case return 1 if n is 0
        }
        else
        {
            return (1 + 1/calcGoldenRatio(n - 1));
        }
    }
}