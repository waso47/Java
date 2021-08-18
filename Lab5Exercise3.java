import java.util.Scanner;

public class Lab5Exercise3{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a floating point number nA: ");
        float nA = input.nextFloat();

        double nB = Math.pow(nA, 3.5);

        nB = Math.min(199, nB);
        System.out.printf("\n nB = %.1f", nB);

        input.close();
    }
}