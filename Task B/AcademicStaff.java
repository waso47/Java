public class AcademicStaff extends Staff
{
    private String academicPosition;
    private String teachingSubject;
    private String researchArea;
    
    //Default Constructor
    public AcademicStaff()
    {
        super();
        this.academicPosition = "";
        this.teachingSubject = "";
        this.researchArea = "";
    }

    //Constructor

    public AcademicStaff(String fName, String lName, String dob, Address address, int mobileNumber, int staffID, String academicPosition, String teachingSubject, String researchArea)
    {
        super(fName, lName, dob, address, mobileNumber, staffID);
        this.academicPosition = academicPosition;
        this.teachingSubject = teachingSubject;
        this.researchArea = researchArea;
    }

    public String getAcademicPosition()
    {
        return this.academicPosition;
    }

    public void setAcademicPosition(String academicPosition)
    {
        this.academicPosition = academicPosition;
    }

    public String getTeachingSubject()
    {
        return this.teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject)
    {
        this.teachingSubject = teachingSubject;
    }

    public String getResearchArea()
    {
        return this.researchArea;
    }

    public void setResearchArea(String researchArea)
    {
        this.researchArea = researchArea;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nAcademic Position: " + getAcademicPosition() + "\nTeaching Subject: " + getTeachingSubject() + "\nResearch Area: " + getResearchArea();
    }
}
