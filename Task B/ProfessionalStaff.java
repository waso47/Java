public class ProfessionalStaff extends Staff
{
    private String professionalPosition;
    private String workingDays;
    
    //Default Constructor
    public ProfessionalStaff()
    {
        super();
        this.professionalPosition = "";
        this.workingDays = "";
    }

    //Constructor

    public ProfessionalStaff(String fName, String lName, String dob, Address address, int mobileNumber, int staffID, String professionalPosition, String workingDays)
    {
        super(fName, lName, dob, address, mobileNumber, staffID);
        this.professionalPosition = professionalPosition;
        this.workingDays = workingDays;
    }


    public String getProfessionalPosition()
    {
        return this.professionalPosition;
    }

    public void setProfessionalPosition(String professionalPosition)
    {
        this.professionalPosition = professionalPosition;
    }

    public String getWorkingDays()
    {
        return this.workingDays;
    }

    public void setWorkingDays(String workingDays)
    {
        this.workingDays = workingDays;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nProfessional Position: " + getProfessionalPosition() + "\nWorking Days: " + getWorkingDays();
    }
}
