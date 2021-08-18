public class ProfessionalStaff extends Staff
{
    //ProfessionalStaff attributes
    private String workingDays;
    private String position;

    //ProfessionalStaff constructor
    public ProfessionalStaff(String ID, String title, String name, String phone, String email, String location, String pworkingDays, String pposition)
    {
        super(ID, title, name, phone, email, location);
        workingDays = pworkingDays;
        position = pposition;
    }

    //Default constructor
    public ProfessionalStaff()
    {
        this("","","","","","","","");
    }
    //ProfessionalStaff getters and setters
    public String getWorkingDays()
    {
        return workingDays;
    }

    public void setWorkingDays(String pworkingDays)
    {
        workingDays = pworkingDays;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String dposition)
    {
        position = dposition;
    }
    
    public String toString(){
        String string = "";
            string += super.toString();
        string += "Working Days: " + workingDays + "\n";
        string += "Position: " + position + "\n";
            
        return string;
        }
}