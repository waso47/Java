public class CheckOut
{
    public static void main(String[] args)
    {
        CashRegister cashRegister1 = new CashRegister();

        cashRegister1.scanProduct(new Product("Milk", 2.99));
        cashRegister1.scanProduct(new Product("Apple", 5.49));
        cashRegister1.scanProduct(new Product("Bread", 1.75));
        System.out.println("***** At Register 1 *****");
        System.out.println("You have purchased " + cashRegister1.getItemPurchased() + " items");
        System.out.println("Total: $" + cashRegister1.totalPurchased());
        cashRegister1.scanProduct(new Product("Apple", 5.49));
        System.out.println("You have purchased " + cashRegister1.getItemPurchased() + " items");
        System.out.println("Total: $" + cashRegister1.totalPurchased());
        System.out.println();

        CashRegister cashRegister2 = new CashRegister();
        cashRegister2.scanProduct(new Product("Milk", 2.99));
        cashRegister2.scanProduct(new Product("Bread", 1.75));
        System.out.println("***** At Register 2 *****");
        System.out.println("You have purchased " + cashRegister2.getItemPurchased() + " items");
        System.out.println("Total: $" + cashRegister2.totalPurchased());
    }
}