class Circle
{
    private double r;

    public Circle(double r )
    {
        this.r = r;
    }

    public double calCircumference()
    {
        return 2*Math.PI*r;
    }

    public double calArea()
    {
        return Math.PI*r*r;
    }
}