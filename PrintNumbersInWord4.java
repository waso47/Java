import java.util.Scanner;

public class PrintNumbersInWord4
{
     public static void main(String[] args)
    {
        //get user's input number
        Scanner scan = new Scanner(System.in);
        System.out.print("Please insert a number in the range 1-9: ");
        int num = scan.nextInt();

        //output the corresponding words using a switch...case
        switch(num)
        {
            case 1: System.out.println("ONE");
                break;
            case 2: System.out.println("TWO");
                break;
            case 3: System.out.println("THREE");
                break;
            case 4: System.out.println("FOUR");
                break;
            case 5: System.out.println("FIVE");
                break;
            case 6: System.out.println("SIX");
                break;
            case 7: System.out.println("SEVEN");
                break;
            case 8: System.out.println("EIGTH");
                break;
            case 9: System.out.println("NINE");
                break;
            default: System.out.println("OTHER");
                break;
        }
    }
}
