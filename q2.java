/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab6
-------------------------------------------------------*/

import java.util.*;

public class q2
{
    public static void main(String[] args)
    {
        Integer[] values = {66,88,11,33,44,55};
        Set<Integer> a = new TreeSet<>(Arrays.asList(values));
        a.forEach(e -> System.out.println(e));
    }
}
