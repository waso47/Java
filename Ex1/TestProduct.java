
public class TestProduct {

	public static void main(String[] args) {

		Product[] products = new Product[3];
		
		products[0] = new Product("Milk", 2.5);
		products[1] = new Product("Apple", 6);		
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		for(int i=0; i<Product.getTotal();i++){
			System.out.println("You have " + products[i].getName() 
					+ "(ID="+products[i].getProductID() +"). Its price is $"
					+ String.format("%.2f", products[i].getPrice()));
		}
		
		products[2] = new Product("Bread", 1.5);
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		for(int i=0; i<Product.getTotal();i++){
			System.out.println("You have " + products[i].getName() 
					+ "(ID="+products[i].getProductID() +"). Its price is $"
					+ String.format("%.2f", products[i].getPrice()));
		}
		
		// Change the price of Apple
		products[1].changePrice(5.99);
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		for(int i=0; i<Product.getTotal();i++){
			System.out.println("You have " + products[i].getName() 
					+ "(ID="+products[i].getProductID() +"). Its price is $"
					+ String.format("%.2f", products[i].getPrice()));
		}		
	}
}
