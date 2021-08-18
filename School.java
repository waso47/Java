/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

import java.io.Serializable;
import java.util.ArrayList;
public class School implements Serializable
{
    //Declaring attributes
    private String sName;
    private AcademicStaff HoS;
    private ProfessionalStaff schoolManager;
    ArrayList <Staff> staffList = new ArrayList<Staff>();
    ArrayList <Subject> subjectList = new ArrayList<Subject>();
    ArrayList <Student> studentList = new ArrayList<Student>();

    //School constructor
    public School(String sName, AcademicStaff HoS, ProfessionalStaff schoolManager)
    {
        this.sName = sName;
        this.HoS = HoS;
        this.schoolManager = schoolManager;
        staffList = new ArrayList<>();
        subjectList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    //Default constructor
    public School()
    {}

    //School getters and setters
    public String getSName()
    {
        return sName;
    }

    public void setSName(String sName)
    {
        this.sName = sName;
    }

    public AcademicStaff getHoS()
    {
        return HoS;
    }

    public void setHoS(AcademicStaff HoS)
    {
        this.HoS = HoS;
    }

    public ProfessionalStaff getSchoolManager()
    {
        return schoolManager;
    }

    public void setSchoolManager(ProfessionalStaff schoolManager)
    {
        this.schoolManager = schoolManager;
    }

    public ArrayList<Staff> getStaffList()
    {
        return staffList;
    }

    public ArrayList<Subject> getSubjectList()
    {
        return subjectList;
    }

    public ArrayList<Student> getStudentList()
    {
        return studentList;
    }

    public void staffAdd(Staff staff)
    {
        if(!staffList.contains(staff))
        {
            staffList.add(staff);
        }
    }

    public void subjectAdd(Subject subject)
    {
        if(!subjectList.contains(subject))
        {
            subjectList.add(subject);
        }
    }


    public void studentAdd(Student student)
    {
        if(!studentList.contains(student))
        {
            studentList.add(student);
        }
    }

    //Making ther return value a string
    @Override
    public String toString()
    {
        String string = "";
        string += "\nSchool Name: " + sName;
        string += "\nSchool Staff List: ";
        for(Staff staff:getStaffList())
        {
            string += "\n" + staff;
        } 

        string += "\nSchool Subject List: ";
        for(Subject subject:getSubjectList())
        {
            string += "\n" + subject;
        }

        string += "\nSchool Student List: ";
        for(Student student:getStudentList())
        {
            string += "\n" + student;
        }

    return string;
    }
}