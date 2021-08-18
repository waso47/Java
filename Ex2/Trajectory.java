public class Trajectory
{
    private final static double G =9.8;

    public static double calculateMaxHeight(double vel)
    {
        double hMax = Math.pow(vel, 2)/(2*6);
        return hMax;
    }
}