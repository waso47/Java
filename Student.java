/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/
public abstract class Student implements PersonalInformation
{
    //Declaring attributes
    private String stID;
    private String stName;
    private String gender;
    private String course;

    //Student constructor
    public Student(String stID, String stName, String gender, String course)
    {
        this.stID = stID;
        this.stName = stName;
        this.gender = gender;
        this.course = course;
    }

    //Default constructor
    public Student()
    {}

    //Student getters and setters
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
        string += "\nStudent Name: " + getName() + "\n";
        string += "Student ID: " + getID() + "\n";
        string += "Course: " + getCourse() + "\n";
            
        return string;
    }
}
