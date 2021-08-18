/*
===============================
CashRegister
-------------------------------
-itemPurchased: int
-totalPurchased: double
-------------------------------
+CashRegister()
+getItemPurchased(): int
+totalPurchased(): double
+scanProduct(Product): void
-------------------------------
*/
class CashRegister
{
    private int itemPurchased;
    private double totalPurchased;

    public CashRegister()
    {

    }

    public int getItemPurchased()
    {
        return this.itemPurchased;
    }

    public double totalPurchased()
    {
        return this.totalPurchased;
    }

    public void scanProduct(Product products)
    {
        this.totalPurchased += products.getPrice();
        this.itemPurchased++;
    }
}