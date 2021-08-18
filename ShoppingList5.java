import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingList5
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        String item;

        System.out.print("Please input the name of items (None for end): ");
        item = scan.nextLine();
        while(!item.equals("None"))
        {
            list.add(item);
            System.out.print("Please input the name of items (None for end): ");
            item = scan.nextLine();
        }

        System.out.println("The shopping list is: ");
        for(int i = 0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}