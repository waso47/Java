/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

import java.util.ArrayList;

public class AcademicStaff extends Staff
{
    //AcademicStaff attributes
    private ArrayList <Subject> teachingSubjects;
    private ArrayList <HDRStudent> HDRStudentSupervision;


    //AcademicStaff constructor
    public AcademicStaff(String stID, String stName, String gender, String title, String position, String email, String location, String number)
    {
        super(stID, stName, gender, title, position, email, location, number);
        teachingSubjects = new ArrayList<>();
        HDRStudentSupervision = new ArrayList<>();
    }

    //Default constructor
    public AcademicStaff()
    {}

    //AcademicStaff getters and setters
    public ArrayList<Subject> getTeachingSubjects()
    {
        return teachingSubjects;
    }

    public ArrayList<HDRStudent> getHDRSuper()
    {
        return HDRStudentSupervision;
    }

    public void teachingSubjectsAdd(Subject subject)
    {
        if(!teachingSubjects.contains(subject))
        {
            teachingSubjects.add(subject);
        }
    }
    
    public void HDRStudentSupervisionAdd(HDRStudent hdrStudent)
    {
        if(!HDRStudentSupervision.contains(hdrStudent))
        {
            HDRStudentSupervision.add(hdrStudent);
        }
    }

    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Teaching Subjects: ";
        for(Subject subject:getTeachingSubjects())
        {
            string += subject.getSubCode() + ", ";
        }
        string += "\nHDR Student Supervision: ";
        
        for(HDRStudent hdrStudent:getHDRSuper())
        {
            string += hdrStudent.getName() + ", ";
        }

        string += "\n";

        return string;
    }
}