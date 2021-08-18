import java.util.Scanner;

public class CheckPassFail2
{
    public static void main(String[] args)
    {
        //get input from the user
        Scanner scan = new Scanner(System.in);
        System.out.print("insert marks (integer): ");
        int mark = scan.nextInt();

        //output "PASS" if mark >= 50, otherwise output "FAIL"
        if (mark >= 50)
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }

        //output "DONE"
        System.out.println("DONE");
    }
}