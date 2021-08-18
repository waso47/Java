public class Subject
{
    //Subject attributes
    private String code;
    private String name;
    private String sessionYear;
    private AcademicStaff coordinator;

    //Subject constructor
    public Subject(String subcode, String subname, String subsessionYear, AcademicStaff subcoordinator)
    {
        code = subcode;
        name = subname;
        sessionYear = subsessionYear;
        coordinator = subcoordinator;
    }

    //Default constructor
    public Subject()
    {
        this("","","",null);
    }

    //Subject getters and setters
    public String getCode()
    {
        return code;
    }

    public void setCode(String subcode)
    {
        code = subcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String subname)
    {
        name = subname;
    }

    public String getSessionYear()
    {
        return sessionYear;
    }

    public void setSessionYear(String subsessionYear)
    {
        sessionYear = subsessionYear;
    }

    public Staff getCoordinator()
    {
        return coordinator;
    }

    public void setCoordinator(AcademicStaff subcoordinator)
    {
        coordinator = subcoordinator;
    }
    
    public String toString()
    {
        String string = "";
        
        string += "Code: " + code + "\n";
		string += "Name: " + name + "\n";
		string += "Session and Year: " + sessionYear + "\n";
		string += "Coordinator: " + coordinator.getTitle() + " " + coordinator.getName() + "\n";
		
        return string; 
    }
}