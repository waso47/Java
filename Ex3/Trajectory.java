public class Trajectory
{
    private final double G =9.8;

    public double calculateMaxHeight(double vel)
    {
        double hMax = Math.pow(vel, 2)/(2*6);
        return hMax;
    }
}