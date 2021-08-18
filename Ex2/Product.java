public class Product
{
    private String name;
    private double price;
    private int productID;
    private static int total = 0;

    Product(String name, double price)
    {
        this.name = name;
        this.price = price;
        total++;
        this.productID = total;
    }

    public String getName()
    {
        return this.name;
    }

    public int getProductID()
    {
        return this.productID;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void changePrice(double price)
    {
        this.price = price;
    }

    public static int getTotal()
    {
        return total;
    }
}