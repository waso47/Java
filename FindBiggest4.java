import java.util.ArrayList;
import java.util.Scanner;

public class FindBiggest4
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int num, biggest, index;

        System.out.print("Please input integers (0 for end): ");
        num = scan.nextInt();
        while(num != 0)
        {
            list.add(num);
            System.out.print("next integer (0 for end): ");
            num = scan.nextInt();
        }

        biggest = list.get(0);
        index = 0;

        for(int i = 0; i<list.size(); i ++)
        {
            if(biggest<list.get(i))
                biggest = list.get(i);
        }
        System.out.println("The biggest number is: " + biggest);
    }
}