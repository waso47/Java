/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
public class School
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
        staffList.add(HoS);
	staffList.add(schoolManager);
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

    public void staffRemove(String identifier)
    {	
        for(Staff staff:staffList){
            if (staff.getID().equals(identifier))
            {
                staffList.remove(staff);
            }
        }
    }

    public void subjectAdd(Subject subject)
    {
        if(!subjectList.contains(subject))
        {
            subjectList.add(subject);
        }
    }

    public void subjectRemove(String code)
    {
        for(Subject subject:subjectList)
        {
            if(subject.getSubCode().equals(code))
            {
                subjectList.remove(subject);
                break;
            }
        }
    }


    public void studentAdd(Student student)
    {
        if(!studentList.contains(student))
        {
            studentList.add(student);
        }
    }

    public void studentRemove(Student student)
    {
        if(studentList.contains(student))
        {
            studentList.remove(student);
        }
    }

    public String showStaff(){
        String string = "";
        
        if(!staffList.isEmpty())
        {
                string += "School Staff List: " + "\n";
    
                for(Staff staff: staffList)
                {
                    string += "\n" + staff;
                }
        }
            
        return string;
    }
    
    public String showSubjects(){
        String string = "";
        
        if(!subjectList.isEmpty()){
                string += "\n" + "School Subject List: " + "\n";
    
                for(Subject subject: subjectList)
                {
                    string += "\n" + subject + "\n";
                }
        }
            
        return string;
    }
    
    public String showStudents()
    {
        String string = "";
        
        if(!studentList.isEmpty())
        {
                string += "\n" + "School Student List: " + "\n";
            
                for(Student student: studentList)
                {
                    string += "\n" + student + "\n";
                }
        }
            
        return string;
    }

    //Making ther return value a string
    @Override
    public String toString()
    {
        String string = "";
        string += "School Name: " + sName + "\n";
        string += "Head of School: " + HoS.getTitle() + " " + HoS.getName() + "\n";
        string += "School Manager: " + schoolManager.getTitle() + " " + schoolManager.getName() + "\n";

        if(!staffList.isEmpty())
        {
            string += "Staff List: " + "\n";
            for(Staff staff:staffList)
            {
                string += "\n" + staff;
            }
        }

        if(!subjectList.isEmpty())
        {
            string += "\n" + "School Subject List: " + "\n";
            for(Subject subject: subjectList)
            {
                string += "\n" + subject + "\n";
            }
        }

        if(!studentList.isEmpty())
        {
            string += "\n" + "School Student List: " + "\n";
        
            for(Student student: studentList)
            {
                string += "\n" + student + "\n";
            }
        }
    return string;
    }
}