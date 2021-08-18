import static java.lang.System.*;  // import all members of System
import java.util.Scanner;          // import Scanner class
class Converter
{       
   public static void main(String[] args)
   {
       double distInMiles, distInKilom;  // local variables
       final double COEFF = 1.609;       // a local constant
        
       Scanner input = new Scanner( in );
       out.print("Enter distance in miles:");
       distInMiles = input.nextDouble(); // input the typed number
        
       distInKilom = COEFF * distInMiles;
       // formatted output 
       out.printf("%.1f miles = %.1f km \n", distInMiles, distInKilom);
   }
}