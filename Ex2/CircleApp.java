import java.util.Scanner;

class CircleApp
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insert radius: ");
        double r = scan.nextDouble();
        Circle circle1 = new Circle(r);
        System.out.println(circle1.calCircumference());
        System.out.println(circle1.calArea());

        Circle circle2 = new Circle(circle1);
        System.out.println(circle2.calCircumference());
        System.out.println(circle2.calArea());

        //setRadius()
        System.out.println("set radius (0.5) of circle 1******************");
        circle1.setRadius(0.5);
        System.out.println(circle1.getRadius() + "?=" + circle2.getRadius());

        //declare circle3
        System.out.println("declare new circle3 (=circle2)*****************");
        Circle circle3 = circle2;
        System.out.println(circle3.getRadius());
        System.out.println(circle2.getRadius());

        // change radius of circle3
        System.out.println("change radius(2) of circle3*********************");
        circle3.setRadius(2);
        System.out.println(circle3.getRadius());
        System.out.println(circle2.getRadius());
    }
}