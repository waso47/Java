import java.io.Serializable;

/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/
import java.io.Serializable;

public abstract class Staff implements PersonalInformation, Serializable
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
    public String getName()
    {
        return stName;
    }

    public void setName(String name)
    {
        this.stName = name;
    }

    public String getID()
    {
        return stID;
    }

    public void setID(String ID)
    {
        this.stID = ID;
    }

    public String getGender()
    {
        return gender;
    }

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
		string += title + " " + stName + "\n";
		string += "Staff ID: " + stID + "\n";
        string += "Gender: " + gender + "\n";
        string += "Phone: " + number + "\n";
        string += "Email: " + email + "\n";
        string += "Location: " + location  + "\n";

        return string;
    }  
}