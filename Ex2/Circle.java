import java.util.Scanner;

class Circle
{
    private double r;

    public Circle(double r )
    {
        this.r = r;
    }
    
    public Circle(Circle circle)
    {
        this.r = circle.r;
    }
    public double calCircumference()
    {
        return 2*Math.PI*r;
    }

    public double calArea()
    {
        return Math.PI*r*r;
    }

    public void setRadius(double r)
    {
        this.r = r;
    }

    public double getRadius()
    {
        return this.r;
    }

}