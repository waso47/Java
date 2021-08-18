import java.util.Scanner;

public class TimeTable2DArray3
{
    public static void main(String[] args)
    {
        int n = 9;
        int[][] array = new int [n][n];

        for (int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                array[i][j] = (i+1)*(j+1);
        
        System.out.print("* |");
        for(int i = 1; i<n; i++)
        {
            System.out.printf("%3d", i);
        }

        System.out.println();
        for(int i = 0; i<=3*n+2; i++)
        {
            System.out.print("-");
        }
        System.out.println();

        for(int i = 1; i<=n; i++)
        {
            System.out.print(i +" |");
            for(int j = 1; j<=n; j++)
                System.out.printf("%3d", array[i-1][j-1]);
            System.out.println();
        }
    }
}