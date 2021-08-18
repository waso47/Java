/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab6
-------------------------------------------------------*/

import java.util.*;
import java.util.stream.Collectors;

public class CarEngine
{
    private String engineName;
    private int cylinderVolumn; // example 2.4L
    private int numberOfCylinder;
    private String fuelType;
    
    public static void main(String[] args)
    {
        CarEngine a0 = new CarEngine("BMW X1",2500,6,"01");
        CarEngine a1 = new CarEngine("Benz",2100,6,"03");
        CarEngine a2 = new CarEngine("Holden TT",1200,6,"05");
        CarEngine a3 = new CarEngine("Toyota TX",900,6,"10");
        CarEngine a4 = new CarEngine("BMW",0,0,"Electricity");
        Map<String,CarEngine> ma = new HashMap<>();
        ma.put(a0.getEngineName(),a0);
        ma.put(a1.getEngineName(),a1);
        ma.put(a2.getEngineName(),a2);
        ma.put(a3.getEngineName(),a3);
        ma.put(a4.getEngineName(),a4);
        ma.values().stream() //convert a hashmap to a stream.
                   .filter(j -> j.getEngineName().equals("Toyota TX"))
                   .collect(Collectors.toList())
                   .forEach(i -> System.out.println("Engine Name: " + i.getEngineName()+ "\nFuel Type: " + i.getFuelType() + "\nCylinder volume: "
                                                                    + i.getCylinderVolumn() + "\nNumber of cylinders: " + i.getNumberOfCylinder()));
        ma.values().stream() //convert a hashmap to a stream.
                   .filter(j -> j.getCylinderVolumn() > 1000 && j.getCylinderVolumn() < 2400)
                   .collect(Collectors.toList())
                   .forEach(i -> System.out.println("\nEngine Name: " + i.getEngineName()+ "\nFuel Type: " + i.getFuelType() + "\nCylinder volume: "
                                                            + i.getCylinderVolumn() + "\nNumber of cylinders: " + i.getNumberOfCylinder()));
    }
    
    public CarEngine(String engineName, int cylinderVolumn, int numberOfCylinder, String fuelType)
    {
        this.engineName = engineName;
        this.cylinderVolumn = cylinderVolumn;
        this.numberOfCylinder = numberOfCylinder;
        this.fuelType = fuelType;
    }

    public String getEngineName()
    {
        return engineName;
    }

    public void setEngineName(String engineName)
    {
    this.engineName = engineName;
    }

    public int getCylinderVolumn()
    {
        return cylinderVolumn;
    }

    public void setCylinderVolumn(int cylinderVolumn)
    {
        this.cylinderVolumn = cylinderVolumn;
    }

    public int getNumberOfCylinder()
    {
    return numberOfCylinder;
    }

    public void setNumberOfCylinder(int numberOfCylinder)
    {
        this.numberOfCylinder = numberOfCylinder;
    }

    public String getFuelType()
    {
        return fuelType;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
}