import java.util.ArrayList;
public class AcademicStaff extends Staff
{
    //AcademicStaff attributes
    private ArrayList <Subject> teachingSubjects;
    private ArrayList <HDRStudent> HDRSuper;


    //AcademicStaff constructor
    public AcademicStaff(String ID, String title, String name, String phone, String email, String location)
    {
        super(ID, title, name, phone, email, location);
        teachingSubjects = new ArrayList<Subject> (0);
        HDRSuper = new ArrayList<HDRStudent> (0);
    }

    //Default constructor
    public AcademicStaff()
    {
        this("","","","","","");
    }
    
    //AcademicStaff constructor
    public ArrayList<Subject> getTeachingSubjects()
    {
        return teachingSubjects;
    }

    //To add new subject to array
    public void addTeachingSubject(Subject sub){
        if(!teachingSubjects.contains(sub))
            teachingSubjects.add(sub);
    }

    public void removeTeachingSubject(String c){
        for(Subject s:teachingSubjects){
            if(s.getCode().equals(c)){
                teachingSubjects.remove(s);
                break;
            }
        }
    }

    public ArrayList<HDRStudent> getHDRSuper()
    {
        return HDRSuper;
    }

    public void SupervisorAdd(HDRStudent stu){
        if(!HDRSuper.contains(stu))
        HDRSuper.add(stu);
    }
    
    public void SupervisorRemove(String id){
        for(HDRStudent stu:HDRSuper){
            if(stu.getID().equals(id)){
                HDRSuper.remove(stu);
                break;
            }
        }
    }
    
    public String toString()
    {
        return super.toString(); 
    }
}