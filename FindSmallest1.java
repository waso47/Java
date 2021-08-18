import java.util.Random;

public class FindSmallest1
{
    public static void main(String[] args)
    {
        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random()*100)+1;
        }

        System.out.println("Displaying the elements in the Array");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        findSmallestInt(arr);
    }
    
    private static void findSmallestInt(int[] arr)
    {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i <arr.length; i++)
        {
            if (min >arr[i])
            {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("\nThe Smallest element in the array is " + min + " and is found at the position " + index);
    }
}