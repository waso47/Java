import java.util.ArrayList;
public class School
{
    //School attributes
    private String name;
    private AcademicStaff head;
    private ProfessionalStaff manager;
    ArrayList <Staff> staffList = new ArrayList<Staff> (0);
    ArrayList <Subject> subjectList = new ArrayList<Subject> (0);
    ArrayList <HDRStudent> HDRStudentList;



    //School constructor
    public School(String n, AcademicStaff h, ProfessionalStaff m) {
        name = n;
        head = h;
        manager = m;
                staffList = new ArrayList<Staff> (0);
            staffList.add(h);
            staffList.add(m);
                subjectList = new ArrayList<Subject> (0);
                HDRStudentList = new ArrayList<HDRStudent> (0);
    }
    //Default constructor
    public School()
    {
        this("", null, null);
    }

    //School getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public AcademicStaff getHead()
    {
        return head;
    }

    public void setHead(AcademicStaff h)
    {
        head = h;
    }

    public ProfessionalStaff getManager()
    {
        return manager;
    }

    public void setManager(ProfessionalStaff m)
    {
        manager = m;
    }

    public void staffAdd(Staff staff)
    {
        if(!staffList.contains(staff))
        {
            staffList.add(staff);
        }
    }

    public void staffRemove(String id)
    {
        for(Staff staff:staffList)
        {
            if(staff.getID().equals(id))
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

    public void subjectRemove(String c)
    {
        for(Subject subject:subjectList)
        {
            if(subject.getCode().equals(c))
            {
                subjectList.remove(subject);
                break;
            }
        }
    }

    public void HDRStudentAdd(HDRStudent student)
    {
        if(!HDRStudentList.contains(student))
        {
            HDRStudentList.add(student);
        }
    }

    public void HDRStudentRemove(String stuid)
    {
        for(HDRStudent student:HDRStudentList)
        {
            if(student.getID().equals(stuid))
            {
                HDRStudentList.remove(student);
                break;
            }
        }
    }

    public ArrayList<Staff> getStaffList()
    {
        return staffList;
    }

    public ArrayList<Subject> getSubjectList()
    {
        return subjectList;
    }

    public ArrayList<HDRStudent> getHDRStudentList()
    {
        return HDRStudentList;
    }

    //Making ther return value a string
    public String toString()
    {
        String string = "";
        string +="School Name: " + name + "\n"; 
        string += "Head of School: " + head.getTitle() + " " + head.getName() + "\n";
        string += "School Manager: " + manager.getTitle() + " " + manager.getName() + "\n";

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
            string += "\n" + "Subject List: " + "\n";

            for(Subject subject: subjectList)
            {
                string += "\n" + subject;
            }
        }

        if(!HDRStudentList.isEmpty())
        {
            string += "\n" + "HDR Student List: " + "\n";

            for(HDRStudent student: HDRStudentList)
            {
                string += "\n" + student;
            }
        }

    return string;
    }
}