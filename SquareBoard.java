public class SquareBoard
{
    public static void main(String[] args)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.print("# "); //prints # and a space, in inner loop without a new line
            }
            System.out.println(); //prints a new line inside the outer loop.
        }
    }
}