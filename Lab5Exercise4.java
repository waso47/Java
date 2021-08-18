import java.util.Scanner;

public class Lab5Exercise4 {

    public static void main(String[] args) {
        float nA = Float.parseFloat(args[0]);

        double nB = Math.exp(nA);
        
        int nBInt = (int) nB;
        
        System.out.printf("\n nB (int) = %d", nBInt);
        }
}