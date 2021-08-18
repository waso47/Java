import java.util.Scanner;

class InputTest
{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a double: ");
        double db = keyboard.nextDouble();
        System.out.println("Input was: " + db);

        System.out.print("Enter an integer: ");
        //int ia = keyboard.nextInt(); The program crashes because ia is only set to accept integers not doubles
        double ia = keyboard.nextDouble(); // So we can just change the ia to accept doubles
        System.out.println("Input was: " + ia);
    }
    } 