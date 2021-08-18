import java.util.Scanner;

public class SumOfDigits2
{
    public static void main(String[] args)
    {
        int n, sum, temp;

        //get n from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input positive number n: ");
        n = scan.nextInt();

        //Calculate sum of all digits from users input.
        sum = 0;
        temp = n;
        while (temp>0)
        {
            sum += temp%10;
            temp = temp/10;
        }

        //Print results.
        System.out.printf("Sum of all digits of the number %d is %d", n, sum);
    }
}