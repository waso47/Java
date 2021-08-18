import java.util.Scanner;

public class FindBiggest2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int [] a;
        int n, biggest, index;

        do
        {
            System.out.print("How long is the array (n)? ");
            n = scan.nextInt();
        }
        while(n<1);

        a = new int[n];
        
        System.out.println("Enter the integers");
        for (int i = 0; i<n; i++)
        {
            a [i] = scan.nextInt();
        }
        System.out.println();
        FindBiggest2 findBiggest = new FindBiggest2();
        int[] returnValues = findBiggest.getBiggest(a,n);
        System.out.println("The biggest number is: " + returnValues[0] + ", and the index is: " +returnValues[1]);
    }
    private int[] getBiggest(int[] list, int length)
    {
        int[] returnValues = new int[2];
        returnValues[0] = list[0];
        returnValues[1] = 0;

        for(int i = 0; i<length; i++)
        {
            if (list[i]>returnValues[0])
            {
                returnValues[0] = list[i];
                returnValues[1] = i;
            }
        }
        return returnValues;
    }

}