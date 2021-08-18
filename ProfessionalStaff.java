/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

public class ProfessionalStaff extends Staff
{
    //Declaring attributes
    private String workingHours;

    //ProfessionalStaff constructor
    public ProfessionalStaff(String stID, String stName, String gender, String title, String position, String email, String location, String number, String workingHours)
    {
        super(stID, stName, gender, title, position, email, location, number);
        this.workingHours = workingHours;
    }

    //Default constructor
    public ProfessionalStaff()
    {}

    //ProfessionalStaff getters and setters
    public String getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(String workingHours)
    {
        this.workingHours = workingHours;
    }
    
    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Working Hours: " + workingHours + "\n";
            
        return string;
    }
}