import java.util.Scanner;

public class TimeTable1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input n: ");
        
        int n = scan.nextInt();

        System.out.print("* |");
        
        for (int i=1; i<=n; i++)
        {
            System.out.printf("%3d", i);
        }
        
        System.out.println();
        for (int i=0; i<=3*n+2; i++)
        {
            System.out.print(" - ");
        }

        System.out.println();
        for (int i=1; i<=n; i++)
        {
            System.out.print(i + " |");
            for (int j=1; j<=n; j++)
            {
                System.out.printf("%3d", j*i);
            }
            System.out.println();
        }
    }
}