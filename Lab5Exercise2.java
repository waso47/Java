import java.util.Scanner;

public class Lab5Exercise2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter lowercase character: ");
        String value = input.next();

        char letter = value.charAt(0);
        int letterValue = (int) letter - 32;
        System.out.println("\nConverted to uppercase " + letter + " = " + (char) letterValue);

        input.close();
    }
}