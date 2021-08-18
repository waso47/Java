/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Lab number: 1
-------------------------------------------------------*/

// At the moment need to remove the for loop.

import java.util.ArrayList;

// School class
public class School
{
    //school attributes
   private String name;
   private Staff head;
   private Staff manager;
   ArrayList <Staff> acaStaff = new ArrayList<>();
   ArrayList <Subject> subjects = new ArrayList<>();

   //School constructor
    public School(String name, Staff head, Staff manager, ArrayList<Staff> acaStaff, ArrayList<Subject> subjects) {
        this.name = name;
        this.head = head;
        this.manager = manager;
        this.acaStaff = acaStaff;
        this.subjects = subjects;
    }

    // get getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff getHead() {
        return this.head;
    }

    public void setHead(Staff head) {
        this.head = head;
    }

    public Staff getManager() {
        return this.manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public ArrayList<Staff> getAcaStaff() {
        return this.acaStaff;
    }

    public void setAcaStaff(ArrayList<Staff> acaStaff) {
        this.acaStaff = acaStaff;
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


   //Main method where all objects are created and all the print statements are ran from
   public static void main(String[] args)
   {
       Staff s1 = new Staff("Mrs ", "Amy Bell", 100001, "Female", "4221-1111", "amy@university.edu.au", "3.001", "Lecturer");
       Staff s2 = new Staff("Dr. ", "Bob Brown", 100002, "Male", "4221-1112", "bob@university.edu.au", "3.002", "Senior Lecturer");
       Staff manager = new Staff("Miss ", "Cindy Ma", 100003, "Female", "4221-1113", "cindy@university.edu.au", "3.003", "Professional Staff");
       Staff head = new Staff("Prof. ", "David Hintz", 100004, "Male", "4221-1114", "david@university.edu.au", "3.004", "Professor");
       ArrayList<Staff> staff = new ArrayList<Staff>();

       Subject sub1 = new Subject("CSIT111", "Programming Fundamentals", "Autumn, 2021", "Country", 6, 4, s1);
       Subject sub2 = new Subject("CSIT121", "Object Oriented Design and Programming", "Autumn, 2021", "City", 6, 3, s2);
       ArrayList<Subject> subjects = new ArrayList<Subject>();

       School CS = new School("School of Computer Science", head, manager, staff, subjects);
       
       CS.subjects.add(sub1);
       CS.subjects.add(sub2);

       CS.acaStaff.add(s1);
       CS.acaStaff.add(s2);
       CS.acaStaff.add(manager);
       CS.acaStaff.add(head);
           
       System.out.println("School Name: " + CS.name);
       System.out.println("Head of School: " + CS.head.getTitle() + CS.head.getName());
       System.out.println("School Manager: " + CS.manager.getTitle() + CS.manager.getName());
       System.out.println("Staff List: ");
       System.out.println();
       
       System.out.println(CS.head.getTitle() + CS.head.getName());
       System.out.println("ID: " + CS.head.getID());
       System.out.println("Gender: " + CS.head.getGender());
       System.out.println("Phone: " + CS.head.getPhone());
       System.out.println("Location: " + CS.head.getOfficeLocation());
       System.out.println("Position: " + CS.head.getPosition());
       System.out.println();
            
       System.out.println(CS.manager.getTitle() + CS.manager.getName());
       System.out.println("ID: " + CS.manager.getID());
       System.out.println("Gender: " + CS.manager.getGender());
       System.out.println("Phone: " + CS.manager.getPhone());
       System.out.println("Location: " + CS.manager.getOfficeLocation());
       System.out.println("Position: " + CS.manager.getPosition());
       System.out.println();

       System.out.println(CS.acaStaff.get(0).getTitle() + " " + CS.acaStaff.get(0).getName());
       System.out.println("ID: " + CS.acaStaff.get(0).getID());
       System.out.println("Gender: " + CS.acaStaff.get(0).getGender());
       System.out.println("Phone: " + CS.acaStaff.get(0).getPhone());
       System.out.println("Location: " + CS.acaStaff.get(0).getOfficeLocation());
       System.out.println("Position: " + CS.acaStaff.get(0).getPosition());
       System.out.println();

       System.out.println(CS.acaStaff.get(1).getTitle() + " " + CS.acaStaff.get(1).getName());
       System.out.println("ID: " + CS.acaStaff.get(1).getID());
       System.out.println("Gender: " + CS.acaStaff.get(1).getGender());
       System.out.println("Phone: " + CS.acaStaff.get(1).getPhone());
       System.out.println("Location: " + CS.acaStaff.get(1).getOfficeLocation());
       System.out.println("Position: " + CS.acaStaff.get(1).getPosition());
       System.out.println();

       System.out.println("Subject List:");
       System.out.println();

       System.out.println("Code: " + CS.subjects.get(0).getCode());
       System.out.println("Name: " + CS.subjects.get(0).getName());
       System.out.println("Session and Year: " + CS.subjects.get(0).getSessionYear());
       System.out.println("Campus: " + CS.subjects.get(0).getCampus());
       System.out.println("Credit: " + CS.subjects.get(0).getCredit());
       System.out.println("Lab numbers: " + CS.subjects.get(0).getLabNum());
       System.out.println("Coordinator: " + CS.subjects.get(0).getCoordinator().getName());
       System.out.println();

       System.out.println("Code: " + CS.subjects.get(1).getCode());
       System.out.println("Name: " + CS.subjects.get(1).getName());
       System.out.println("Session and Year: " + CS.subjects.get(1).getSessionYear());
       System.out.println("Campus: " + CS.subjects.get(1).getCampus());
       System.out.println("Credit: " + CS.subjects.get(1).getCredit());
       System.out.println("Lab numbers: " + CS.subjects.get(1).getLabNum());
       System.out.println("Coordinator: " + CS.subjects.get(1).getCoordinator().getName());
       System.out.println();

       CS.acaStaff.remove(1);
       CS.subjects.get(1).setCoordinator(CS.head);

       System.out.println("School Name: " + CS.name);
       System.out.println("Head of School: " + CS.head.getTitle() + CS.head.getName());
       System.out.println("School Manager: " + CS.manager.getTitle() + CS.manager.getName());
       System.out.println("Staff List: ");
       System.out.println();
       
       System.out.println(CS.head.getTitle() + CS.head.getName());
       System.out.println("ID: " + CS.head.getID());
       System.out.println("Gender: " + CS.head.getGender());
       System.out.println("Phone: " + CS.head.getPhone());
       System.out.println("Location: " + CS.head.getOfficeLocation());
       System.out.println("Position: " + CS.head.getPosition());
       System.out.println();
            
       System.out.println(CS.manager.getTitle() + CS.manager.getName());
       System.out.println("ID: " + CS.manager.getID());
       System.out.println("Gender: " + CS.manager.getGender());
       System.out.println("Phone: " + CS.manager.getPhone());
       System.out.println("Location: " + CS.manager.getOfficeLocation());
       System.out.println("Position: " + CS.manager.getPosition());
       System.out.println();

       System.out.println(CS.acaStaff.get(0).getTitle() + " " + CS.acaStaff.get(0).getName());
       System.out.println("ID: " + CS.acaStaff.get(0).getID());
       System.out.println("Gender: " + CS.acaStaff.get(0).getGender());
       System.out.println("Phone: " + CS.acaStaff.get(0).getPhone());
       System.out.println("Location: " + CS.acaStaff.get(0).getOfficeLocation());
       System.out.println("Position: " + CS.acaStaff.get(0).getPosition());
       System.out.println();

       System.out.println("Subject List:");
       System.out.println();

       System.out.println("Code: " + CS.subjects.get(0).getCode());
       System.out.println("Name: " + CS.subjects.get(0).getName());
       System.out.println("Session and Year: " + CS.subjects.get(0).getSessionYear());
       System.out.println("Campus: " + CS.subjects.get(0).getCampus());
       System.out.println("Credit: " + CS.subjects.get(0).getCredit());
       System.out.println("Lab numbers: " + CS.subjects.get(0).getLabNum());
       System.out.println("Coordinator: " + CS.subjects.get(0).getCoordinator().getName());
       System.out.println();

       System.out.println("Code: " + CS.subjects.get(1).getCode());
       System.out.println("Name: " + CS.subjects.get(1).getName());
       System.out.println("Session and Year: " + CS.subjects.get(1).getSessionYear());
       System.out.println("Campus: " + CS.subjects.get(1).getCampus());
       System.out.println("Credit: " + CS.subjects.get(1).getCredit());
       System.out.println("Lab numbers: " + CS.subjects.get(1).getLabNum());
       System.out.println("Coordinator: " + CS.subjects.get(1).getCoordinator().getName());
       System.out.println();
    }
}

// Staff class
class Staff
{
    //Staff Attributes
    private String title;
    private String Name ;
    protected int ID;
    private String gender;
    private String phone;
    private String email;
    private String officeLocation;
    private String position;
    
    //Staff Constructor
    public Staff(String title, String Name, int ID, String gender, String phone, String email, String officeLocation, String position) {
        this.title = title;
        this.Name = Name;
        this.ID = ID;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.officeLocation = officeLocation;
        this.position = position;
    }

    //Default Constructor
    public Staff()
    {
    }


    //Staff getters and setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeLocation() {
        return this.officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}

//Subject class
class Subject
{
    //Subject Attributes
    private String code;
    private String name;
    private String sessionYear;
    private String campus;
    private int credit;
    private int labNum;
    private Staff coordinator;

    //Subject Constructor
    public Subject(String code, String name, String sessionYear, String campus, int credit, int labNum, Staff coordinator) {
        this.code = code;
        this.name = name;
        this.sessionYear = sessionYear;
        this.campus = campus;
        this.credit = credit;
        this.labNum = labNum;
        this.coordinator = coordinator;
    }

    //Default Constructor
    public Subject()
    {
    }


    // Subject getters and setters
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionYear() {
        return this.sessionYear;
    }

    public void setSessionYear(String sessionYear) {
        this.sessionYear = sessionYear;
    }

    public String getCampus() {
        return this.campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLabNum() {
        return this.labNum;
    }

    public void setLabNum(int labNum) {
        this.labNum = labNum;
    }

    public Staff getCoordinator() {
        return this.coordinator;
    }

    public void setCoordinator(Staff coordinator) {
        this.coordinator = coordinator;
    }

}