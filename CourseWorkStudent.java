/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/
import java.util.ArrayList;

public class CourseWorkStudent extends Student
{
    //Declaring attributes
    private  ArrayList <Subject> enrolledSubjects;

    //CourseWorkStudent constructor
    public CourseWorkStudent(String stID, String stName, String gender, String course)
    {
        super(stID, stName, gender, course);
        enrolledSubjects = new ArrayList<> ();
    }

    //Default constructor
    public CourseWorkStudent() 
    {}


    //CourseWorkStudent getters and setters
    public ArrayList<Subject> getEnrolledSubjects()
    {
        return this.enrolledSubjects;
    }

    public void enrolledSubjectsAdd(Subject subject)
    {
        if(!enrolledSubjects.contains(subject))
        {
            enrolledSubjects.add(subject);
        }
    }
    
    public void withdrawSubject(Subject subject)
    {
        if(enrolledSubjects.contains(subject))
        {
            enrolledSubjects.remove(subject);
        }
    }

    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Enrolled Subjects: ";
        for(Subject subject:getEnrolledSubjects())
        {
            string += subject.getSubCode() + ", ";
        }

        return string;
    }
}
