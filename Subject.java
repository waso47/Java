/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

import java.io.Serializable;
import java.util.ArrayList;
public class Subject implements Cloneable, Serializable
{
    //Declaring attributes
    private String subCode;
    private String subName;
    private String session;
    private String campus;
    private AcademicStaff coordinator;
    private ArrayList <CourseWorkStudent> enrolledStudent;

    //Subject constructor
    public Subject(String subCode, String subName, String session, String campus, AcademicStaff coordinator)
    {
        this.subCode = subCode;
        this.subName = subName;
        this.session = session;
        this.campus = campus;
        this.coordinator = coordinator;
        enrolledStudent = new ArrayList<>();
    }

    //Default constructor
    public Subject()
    {}

    public String getSubCode()
    {
        return this.subCode;
    }

    public void setSubCode(String subCode)
    {
        this.subCode = subCode;
    }

    public String getSubName()
    {
        return this.subName;
    }

    public void setSubName(String subName)
    {
        this.subName = subName;
    }

    public String getSession()
    {
        return this.session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public String getCampus()
    {
        return this.campus;
    }

    public void setCampus(String campus)
    {
        this.campus = campus;
    }

    public AcademicStaff getCoordinator()
    {
        return this.coordinator;
    }

    public void setCoordinator(AcademicStaff coordinator)
    {
        this.coordinator = coordinator;
    }

    public ArrayList<CourseWorkStudent> getEnrolledStudent()
    {
        return this.enrolledStudent;
    }

    public void enrolledStudentAdd(CourseWorkStudent courseWorkStudent)
    {
        if(!enrolledStudent.contains(courseWorkStudent))
        {
            enrolledStudent.add(courseWorkStudent);
        }
    }

    @Override
    public Subject clone() throws CloneNotSupportedException
    {
        Subject subject = (Subject) super.clone();
        subject.enrolledStudent = (ArrayList<CourseWorkStudent>) enrolledStudent.clone();
        subject.enrolledStudent.clear();
        return  subject;
    }

    @Override
    public String toString()
    {
        String string = "";
        
        string += "\nCode: " +subCode + "\n";
		string += "Name: " + subName + "\n";
		string += "Session and Year: " + session + "\n";
        string += "Campus: " + campus + "\n";
		string += "Coordinator: " + coordinator.getName() + "\n";
        string += "Enrolled Students: ";
        for(Student student:getEnrolledStudent())
        {
            string += student.getName() + ", ";
        }
		
        return string; 
    }
}