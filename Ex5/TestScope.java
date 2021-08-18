class TestScope
{
    private static final double CT = 0.25;
    private static double fd = 1.0;

    public static void main(String[] args)
    {
        double x = 1, y = 1;
        method1(x);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("fd = " + fd);

        double z = method2(x);
        System.out.println("x = " + x);
        System.out.println("z = " + z);
        System.out.println("fd = " + fd);
    }

    private static void method1(double x)
    {
        x += 3;
        double y = 6;
        double fd = 2.0;
        System.out.println( CT* (x + y));
    }

    private static double method2( double x)
    {
        fd = 2.0;
        return ((x + 3.0)/fd);
    }
}
// In method 1 the value of x in overwritten to the value of +3 because it isn't redifined in method 1.
// x is then reset to 1 when method1 is done.
// because fd is defined in method 1 it is then also modified at class level to fd = 2
// main() can call the private methods method1() and method2() because they are in the same class.