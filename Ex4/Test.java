import java.util.Scanner; // import scanner class

public class Test
{
    private int a;

    //Pass by value can't modify original value of fp
    public void method1()
    {
        int ap = 5;
        method2(ap);
        System.out.println("Value = "+ ap);
    }
    public void method2(int fp)
    {
        fp = 2;
        System.out.println("Value = " + fp);
    }

    //Pass by reference, method 4 will change the original value of field data a as
    // bothe references apand fp link to the exact same object in the memory.
    public void method3()
    {
        Test ap;
        ap = new Test();
        ap.a = 5;
        method4(ap);
        System.out.println("Value = " + ap.a);
    }
    public void method4(Test fp)
    {
        fp.a = 10;
        System.out.println("Value = " + fp.a);
    }

    public static void main(String[] args)
    {
        Test app = new Test();
        app.method1();
        app.method3();
    }
}