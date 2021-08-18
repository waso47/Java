/*------------------------------------------------------
Name: Jack Wason
Student number: 6780957
Email address: jaw403@uowmail.edu.au
Subject Code: CSIT111/811
Assignment number: 2
-------------------------------------------------------*/
import java.lang.Math;     //Importing the Math class
import java.util.Scanner;//Importing the scanner class


class Bank
{   
    private Customer customer;
    private int numYears;
    private final double INTEREST_SAVING = 2.95;
    private final double INTEREST_CHEQUE = 2.1;
    

    public void createCustomerAccounts()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the customer's full name: ");
        String newCustomerName = input.nextLine();

        System.out.print("Enter the number of years: ");
        numYears = input.nextInt();

        System.out.print("Enter the initial balance for the saving account: ");
        double initialSavingBalance = input.nextDouble();
        Account NewSavingsAccount = new Account(initialSavingBalance);
        
        System.out.print("Enter the initial balance for the check account: ");
        double initialCheckBalance = input.nextDouble();
        Account NewCheckAccount = new Account(initialCheckBalance);

        customer = new Customer(newCustomerName, NewSavingsAccount, NewCheckAccount);
    }

    public void printInitialBalances()
    {
        System.out.println("=================================================");
        System.out.println("Initial account balances");
        System.out.println("=================================================");
        System.out.printf("%s's Account\t\tRate\tBalance\n", customer.getCustomerName());
        System.out.println("=================================================");
        System.out.printf("Saving\t\t\t%.2f%%\t$%.2f\n", INTEREST_SAVING, customer.getSavingAccount().getInitialBalance());
        System.out.printf("Check\t\t\t%.2f%%\t$%.2f\n", INTEREST_CHEQUE, customer.getCheckAccount().getInitialBalance());

    }
        
    public void printFinalBalances()
    {
        System.out.println("=================================================");
        System.out.println("=================================================");
        System.out.printf("Final account balances after %d years\n", numYears);
        System.out.println("=================================================");
        System.out.printf("%s's Account\t\tRate\tBalance\n", customer.getCustomerName());
        System.out.println("=================================================");
        System.out.printf("Saving\t\t\t%.2f%%\t$%.2f\n", INTEREST_SAVING, customer.getSavingAccount().getFinalBalance(INTEREST_SAVING, numYears));
        System.out.printf("Check\t\t\t%.2f%%\t$%.2f\n", INTEREST_CHEQUE, customer.getCheckAccount().getFinalBalance(INTEREST_CHEQUE, numYears));
    }
    
    public static void main(String[] args) 
    {
        Bank b = new Bank();
        b.createCustomerAccounts();
        b.printInitialBalances();
        b.printFinalBalances();
    }
}

class Customer
{
    private String name;
    private Account savingAccount;
    private Account checkAccount;

    Customer(String name, Account savingAccount, Account checkAccount)
    {
        this.name = name;
        this.savingAccount = savingAccount;
        this.checkAccount = checkAccount;
    }

    public Account getSavingAccount()
    {
        return this.savingAccount;
    } 

    public Account getCheckAccount()
    {
        return this.checkAccount;
    }

    public String getCustomerName()
    {
        return this.name;
    }
}

class Account
{
    private double balance;
    private final int NUM_COMPOUND_TIMES = 12;
    
    Account(double balance) 
    {
        this.balance = balance;
    }

    public double getInitialBalance() 
    {
        return this.balance;
    }

    public double getFinalBalance(double rate, int numYears)
    {
        double x = Math.pow(1 + ((rate/100) / NUM_COMPOUND_TIMES), NUM_COMPOUND_TIMES * numYears);
        double t = (balance * x);
        return t;
    }
}