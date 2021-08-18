class SwapInt
{
    public static void main(String[] args)
    {
        //use the command line arguments to get two integer numbers from user
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int temp;

        System.out.println("Before swapping: " + "a = " + a + ", b = " + b);
        
        temp = a;
        a = b;
        b = temp;
        
        System.out.println("After swapping: " + "a = " + a + ", b = " + b); 
    }
}