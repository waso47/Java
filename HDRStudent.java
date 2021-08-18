public class HDRStudent
{
    //HDRStudent attributes
    private String name;
    private String ID;
    private String HDRCourse;
    private AcademicStaff supervisor;



    //HDRStudent constructor
    public HDRStudent(String stuname, String stuID, String stuHDRCourse, AcademicStaff stusupervisor)
    {
        name = stuname;
        ID = stuID;
        HDRCourse = stuHDRCourse;
        supervisor = stusupervisor;
    }

    //Default constructor
    public HDRStudent() 
    {
        this("","","",null);
    }

    //HDRStudent getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String stuname)
    {
        name = stuname;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String stuID)
    {
        ID = stuID;
    }

    public String getHDRCourse()
    {
        return HDRCourse;
    }

    public void setHDRCourse(String stuHDRCourse)
    {
        HDRCourse = stuHDRCourse;
    }

    public Staff getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(AcademicStaff stusupervisor)
    {
        supervisor = stusupervisor;
    }
    
    public String toString()
    {
        String string = "";
        string += "Student Name " + name + "\n";
        string += "Student ID: " + ID + "\n";
        string += "HDR Course: " + HDRCourse + "\n";
        string += "Supervisor: " + supervisor.getName() + "\n";
        
        return string;
    }
}