/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab6
-------------------------------------------------------*/

import java.util.stream.*;

public class q1
{
    public static void main(String[] args)
    {
        int[] values ={12,2,18,25,4,65,75};
        double result = 0;
        
        System.out.print(Double.valueOf(IntStream.of(values)
                       .reduce(0,(x, y) -> (x + y))) / values.length);
        
        System.out.println(IntStream.of(values).average().getAsDouble());
    }
}