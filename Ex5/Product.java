class Product
{
    private String name;
    private double price;
    private int scanCode;
    private static int numOfObjects = 0;

    //Parametered constructor
    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
        numOfObjects++;
    }

    // Default constructor
    public Product()
    {
        this.name = "";
        this.price = -1;
        this.scanCode = -1;
        numOfObjects++;
    }

    public String getName()
    {
        return this.name;
    }
    public int getScanCode()
    {
        return this.scanCode;
    }
    public double getPrice()
    {
        return this.price;
    }
    public static int getNumOfObjects()
    {
        return numOfObjects;
    }
    public void changePrice(double price)
    {
        this.price = price;
    }
}