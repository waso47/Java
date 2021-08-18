import java.util.Scanner;

public class OddEven1
{
    private static int a;
    public static void main(String[] args)
    {
        String type_pn = null;
        String type_fi = null;
        String type_eo = null;

        System.out.print("Please input a number: ");
        Scanner input = new Scanner (System.in);
        
        if (input.hasNextInt()) // check integer
        {
            type_fi = "integer";
            int i = input.nextInt();
            if (i % 2 == 0) //checks odd of even
            {
                type_eo = "even";
            }
            if (i % 2 != 0)
            {
                type_eo = "odd";
            }
            if (i > 0) //checks positive of negative
            {
                type_pn = "positive";
            }
            if (i < 0)
            {
                type_pn = "negative";
            }
            System.out.println(i + " is a " + type_pn + ", " + type_eo + " number.");
        }
        else
        {
            if (input.hasNextFloat()) //check floating number
            {
                type_fi = "floating";
                float f = input.nextFloat();
                if (f > 0) //checking positive or negative
                {
                    type_pn = "positive";
                }
                else if (f < 0)
                {
                    type_pn = "negative";
                }
                System.out.println(f + " is a " + type_pn + ", " + type_fi + " number.");
            }
        }
    }
}