public abstract class Staff implements Cloneable
{
    private String fName;
    private String lName;
    private String dob;
    private Address address;
    private int mobileNumber;
    private int staffID;

    //Default constructor
    public Staff()
    {
        this.staffID = 0;
        this.address = null;
        this.fName = "";
        this.lName = "";
        this.dob = "";
        this.mobileNumber = 0;
    }

    //Constructor

    public Staff(String fName, String lName, String dob, Address address, int mobileNumber, int staffID)
    {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.staffID = staffID;
    }

    //Getters and Setters

    public String getFName()
    {
        return this.fName;
    }

    public void setFName(String fName)
    {
        this.fName = fName;
    }

    public String getLName()
    {
        return this.lName;
    }

    public void setLName(String lName)
    {
        this.lName = lName;
    }

    public String getDob()
    {
        return this.dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(Address Address)
    {
        this.address = Address;
    }

    public int getMobileNumber()
    {
        return this.mobileNumber;
    }

    public void setMobileNumber(int mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public int getStaffID()
    {
        return this.staffID;
    }

    public void setStaffID(int staffID)
    {
        this.staffID = staffID;
    }

    public Staff clone() throws CloneNotSupportedException
    {
        return (Staff) super.clone();
    }

    @Override
    public String toString()
    {
        return "ID: " + getStaffID() + "\nName: " + getFName() + " " + getLName() + "\nDOB: " + getDob() + "\nAddress: " + getAddress() + "\nMobile Number: " + getMobileNumber();
    }
}
