import java.util.Scanner;

public class SumOfDigits3
{
    public static void main(String[] args)
    {
        int n, sum, temp;

        //Get n from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input positive number n: ");
        n = scan.nextInt();

        //call the recursion method calcSum()
        System.out.printf("Sum of all digits of the number %d is %d", n, calcSum(n));
    }

    public static int calcSum(int n)
    {
        if (n>0)
        {
            return ((n%10) + calcSum(n/10));
        }
        else
        {
            return 0; //base case if n<= 0, return 0;
        }
    }
}