class PrintTest
{
    public static void main( String[] args )
    {
        int a = 2, b = 3;
        System.out.println(" a + b = " + a + b ); // 1
        System.out.println(" a + b = " + (a + b)); // 2
        System.out.println( a + b + " a + b " ); // 3
    }
}

// 1 (auto typecasting moves left to right )This concatenates a and b as strings once it stats as a string is can't change to an integer 
// 2 This adds a and b as integers because it adds them first as the brackets happen first and it identifies them as integers
// 3 This adds a and b as integers by autotypecast moving left to right then concatenates  a + b