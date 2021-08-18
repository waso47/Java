import java.io.Serializable;

/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/
import java.io.Serializable;

public abstract class Student implements PersonalInformation, Serializable
{
    //Declaring attributes
    private String stID;
    private String stName;
    private String stDob;
    private String gender;
    private String course;

    //Student constructor
    public Student(String stID, String stName, String stDob, String gender, String course)
    {
        this.stID = stID;
        this.stName = stName;
        this.stDob = stDob;
        this.gender = gender;
        this.course = course;
    }

    //Default constructor
    public Student()
    {}

    //Student getters and setters
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

    public String getStDob()
    {
        return stDob;
    }

    public void setStDob()
    {
        this.stDob = stDob;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        String string = "";
        string += "\nStudent Name: " + stName + "\n";
        string += "Student ID: " + stID + "\n";
        string += "DOB: " + stDob + "\n";
        string += "Course: " + course + "\n";
            
        return string;
    }
}
