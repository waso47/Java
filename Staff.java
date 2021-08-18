/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

public abstract class Staff implements PersonalInformation
{
    //Declaring attributes
    private String stID;
    private String stName;
    private String gender;
    private String title;
    private String position;
    private String email;
    private String location;
    private String number;

    //Staff constructor
    public Staff(String stID, String stName, String gender, String title, String position, String email, String location, String number)
    {
        this.stID = stID;
        this.stName = stName;
        this.gender = gender;
        this.title = title;
        this.position = position;
        this.email = email;
        this.location = location;
        this.number = number; 
    }

    //Default Constructor
    public Staff()
    {}

    //Staff getters and setters
    @Override
    public String getName()
    {
        return stName;
    }

    @Override
    public void setName(String name)
    {
        this.stName = name;
    }

    @Override
    public String getID()
    {
        return stID;
    }

    @Override
    public void setID(String ID)
    {
        this.stID = ID;
    }

    @Override
    public String getGender()
    {
        return gender;
    }

    @Override
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        String string ="";
		string += getTitle() + " " + getName() + "\n";
		string += "Staff ID: " + getID() + "\n";
        string += "Gender: " + getGender() + "\n";
        string += "Phone: " + getNumber() + "\n";
        string += "Email: " + getEmail() + "\n";
        string += "Location: " + getLocation()  + "\n";

        return string;
    }  
}