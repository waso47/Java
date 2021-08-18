public class Address implements Cloneable
{
    private int sNum;
    private String sName;
    private String city;
    private String state;
    private int postcode;
    private String country;

    //Default constructor
    public Address()
    {
        this.sNum = 0;
        this.sName = this.city = this.state = this.country = "";
        this.postcode = 0;
    }

    //Constructor
    public Address(int sNum, String sName, String city, String state, int postcode, String country)
    {
        this.sNum = sNum;
        this.sName = sName;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    //Getters and setters

    public int getSNum()
    {
        return this.sNum;
    }

    public void setSNum(int sNum)
    {
        this.sNum = sNum;
    }

    public String getSName()
    {
        return this.sName;
    }

    public void setSName(String sName)
    {
        this.sName = sName;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(int postcode)
    {
        this.postcode = postcode;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Address clone() throws CloneNotSupportedException
    {
        return (Address) super.clone();
    }

    @Override
    public String toString()
    {
        return getSNum() + ", " + getSName() + ", " + getCity() + ", " + getState() + ", " + getPostcode() + ", " + getCountry();
    }
}