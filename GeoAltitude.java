/*------------------------------------------------------
Name: Jack Wason
Student number: 6780957
Email address: jaw403@uowmail.edu.au
Subject Code: CSIT111/811
Assignment number: 1
-------------------------------------------------------*/
import java.lang.Math;
import java.util.Scanner;

class GeoAltitude{
    
    public static void main(String args[]){
        String planetName;
        double gravitationalConstant;
        double rotationalPeriod;
        double equatorialRadius;
        Scanner input = new Scanner(System.in);
        
        System.out.println("- Geostationary Altitude Calculation -");
        System.out.println();
        System.out.println("Enter the planet parameters|");
        System.out.println();

        System.out.print("Planet Name: ");
        planetName = input.nextLine();

        System.out.print("Gravitational Constant (km3/s2): ");
        gravitationalConstant = input.nextDouble();

        System.out.print("Rotational Period (s): ");
        rotationalPeriod = input.nextDouble();

        System.out.print("Equatorial Radius (km): ");
        equatorialRadius = input.nextDouble();

        double numerator = gravitationalConstant * Math.pow(rotationalPeriod, 2);

        double denominator = 4 *Math.pow(Math.PI, 2);

        double radius = Math.cbrt(numerator/denominator);

        double geostationaryAltitude = radius - equatorialRadius;

        System.out.printf("The Geostationary Altitude of %s is %.1f km.", planetName, geostationaryAltitude);
        }
}