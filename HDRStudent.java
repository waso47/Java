/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

public class HDRStudent extends Student
{
    //Declaring attributes
    private AcademicStaff supervisor;

    //HDRStudent constructor
    public HDRStudent(String stID, String stName, String gender, String course, AcademicStaff supervisor)
    {
        super(stID, stName, gender, course);
        this.supervisor = supervisor;
    }

    //Default constructor
    public HDRStudent() 
    {}

    //HDRStudent getters and setters
    public AcademicStaff getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(AcademicStaff supervisor)
    {
        this.supervisor = supervisor;
    }
    
    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Supervisor: " + supervisor.getName();
        
        return string;
    }
}