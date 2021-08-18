/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

//Importing neccessary packages
import java.util.Scanner;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.Serializable;
import java.util.ArrayList;

//School Management System class
public class SchoolManagementSystem implements Cloneable
{
    private static ObjectInputStream input;
    private static Formatter output;

    private static School CSFile;
    //main method where the program is written
    public static void main(String[] args) throws CloneNotSupportedException, NoInputException
    {
		System.out.println("\nWelcome to the School of Computer Science.");
		
        boolean loop = true;
        School CS = new School("School of Computer Science", null, null);
        
        while(loop)
		{
			System.out.println("\nPlease make a selection from the following items: ");
            System.out.println("1: import the school");
            System.out.println("2: add a staff member");
            System.out.println("3: add a subject");
            System.out.println("4: add a student");
            System.out.println("5: display the school's staff members");
            System.out.println("6: display the school's subjects");
            System.out.println("7: display the school's students");
            System.out.println("8: export the school information");
            System.out.println("9: exit the system");

            Scanner scan = new Scanner(System.in);
                    
            int choice = intInput();

            scan.nextLine(); //Consumes \n
            
            switch(choice)
            {
                //Initialising the school
                case 1:
                    openFile();
                    readSchool();
                    closeFile();
                    CS = CSFile;
                    break;

                //adding a staff member
                case 2:
                    //Getting values of all attributes
                    System.out.println("Please input the staff name: ");
                    String stName = noInput(scan.nextLine());

                    System.out.println("Please input the staff ID: ");
                    String stID = noInput(scan.nextLine());

                    System.out.println("Please input the staff title: ");
                    String title = noInput(scan.nextLine());

                    System.out.println("Please input the staff gender: ");
                    String gender = noInput(scan.nextLine());

                    System.out.println("Please input the staff position: ");
                    String position = noInput(scan.nextLine());

                    System.out.println("Please input the staff phone number: ");
                    String number = noInput(scan.nextLine());

                    System.out.println("Please input the staff email address: ");
                    String email = noInput(scan.nextLine());

                    System.out.println("Please input the staff office location: ");
                    String location = noInput(scan.nextLine());

                    //Creating the new staff member
                    System.out.println("Is this (1) a professional staff or (2) an academic staff: ");
                    int staffChoice = scan.nextInt();
                    scan.nextLine(); //Consumes \n
                    if(staffChoice == 1)
                    {
                        System.out.println("Please input the working hours: ");
                        String workingHours = noInput(scan.nextLine());
                        ProfessionalStaff newProfessionalStaff = new ProfessionalStaff(stID, stName, gender, title, position, email, location, number, workingHours);
                        CS.staffAdd(newProfessionalStaff);
                    }
                    else if(staffChoice == 2)
                    {
                        AcademicStaff newAcademicStaff = new AcademicStaff(stID, stName, gender, title, position, email, location, number);
                        CS.staffAdd(newAcademicStaff);
                    }
                    break;

                //Adding a subject
                case 3:
                    //Getting the values for all attributes
                    System.out.println("Please input the subject code: ");
                    String subCode = noInput(scan.nextLine());

                    System.out.println("Please input the subject name: ");
                    String subName = noInput(scan.nextLine());

                    System.out.println("Please input the subject session and year (such as Autumn 2021): ");
                    String session = noInput(scan.nextLine());

                    System.out.println("Please input the campus (Wollongong or SWS): ");
                    String campus = noInput(scan.nextLine());

                    System.out.println("Please nominate a subject coordinator from the following staff: ");
                    
                    //For loop of the staff array
                    for(int i=0; i<CS.getStaffList().size(); i++)
                    {
                        if(CS.getStaffList().get(i) instanceof AcademicStaff)
                        {
                            System.out.println(i+": "+CS.getStaffList().get(i).getName());
                        }
                    }

                    System.out.println("Please input the index for the subject coordinator:"); //Getting the index of the subject coordinator
                    int coSelection = scan.nextInt();

                    AcademicStaff coordinator = (AcademicStaff)CS.getStaffList().get(coSelection);

                    //Creating new subject object
                    Subject newSubject = new Subject(subCode, subName, session, campus, coordinator);
                    coordinator.teachingSubjectsAdd(newSubject);
                    CS.subjectAdd(newSubject);
                    break;

                //Adding a new HDR Student    
                case 4:
                    //Getting values of all attributes
                    System.out.println("Please input the student name:");
                    String stuName = noInput(scan.nextLine());

                    System.out.println("Please input the student ID:");
                    String stuID = noInput(scan.nextLine());

                    System.out.println("Please input the student's date of birth:");
                    String stuDob = enterDate();

                    System.out.println("Please input the student gender:");
                    String stuGender = noInput(scan.nextLine());

                    System.out.println("Please input the student course (BCS, BIT, MCS, MIT or PhD): ");
                    String course = noInput(scan.nextLine());

                    if(course.equals("PhD"))
                    {
                        
                        System.out.println("Please nominate a supervisor from the following staff: ");
                    
                        for(int i=0; i<CS.getStaffList().size();i++)
                        {
                            if(CS.getStaffList().get(i) instanceof AcademicStaff)
                            {
                                System.out.println(i+": "+ CS.getStaffList().get(i).getName());
                            }
                        }
                        System.out.println("Please input the index for the subject coordinator:"); //Getting the index of the subject coordinator
                        int supSelection = scan.nextInt();
                        
                        AcademicStaff supervisor = (AcademicStaff)CS.getStaffList().get(supSelection);

                        //Create HDRStudent
                        HDRStudent newHDRStudent = new HDRStudent(stuID, stuName, stuDob, stuGender, course, supervisor);
                        CS.studentAdd(newHDRStudent);
                        supervisor.HDRStudentSupervisionAdd(newHDRStudent);
                    }

                    else if(course.equals("BCS") || course.equals("BIT") || course.equals("MCS") || course.equals("MIT"))
                    {
                        System.out.println("Please enrol at least one subject offered by the school: ");
                    
                        for(int i=0; i<CS.getSubjectList().size();i++)
                        {
                            System.out.println(i+": "+ CS.getSubjectList().get(i).getSubCode() + "(" + CS.getSubjectList().get(i).getSubName() + ")");
                        }
                        System.out.println("Please input the index for the subjects (separate by comma): "); //Getting the index of the subjects
                        
                        String [] subjectChoice = scan.nextLine().split(",");
                        //Create Coursework student
                        CourseWorkStudent newCourseWorkStudent = new CourseWorkStudent(stuID, stuName, stuDob, stuGender, course);
                        CS.studentAdd(newCourseWorkStudent);
                        
                        for(String i:subjectChoice)
                        {
                            Subject subject = CS.getSubjectList().get(Integer.parseInt(i));
                            subject.enrolledStudentAdd(newCourseWorkStudent);
                            newCourseWorkStudent.enrolledSubjectsAdd(subject);
                        }
                    }
                    break;
                
                //Display the school's staff members
                case 5:
                    System.out.println("School Staff List: ");
                    for(Staff staff:CS.getStaffList())
                    {
                        System.out.println(staff);
                    }
                    break;

                //Displaying the school's students
                case 6:
                    System.out.println("School Subject List: ");
                    for(Subject subject:CS.getSubjectList())
                    {
                        System.out.println(subject);
                    }
                    break;

                //Displaying the school's subjects
                case 7:
                    System.out.println("School Student List: ");
                    for(Student student:CS.getStudentList())
                    {
                        System.out.println(student);
                    }
                    break;
                    
                case 8:
                    openTxtFile();
                    addSchool();
                    closeTxtFile();
                    break;

                case 9:
                    loop = false;
                    System.out.println("Thanks for using the SMS, see you next time.");
                    break;

                // If selection is invalid    
                default:
                    System.out.println("Invalid Choice.. Try Again");
            }
        }
    }

    public static int intInput()//Error checking for integers
    {
        boolean input = false;
        int choice = 0;
        Scanner scan = new Scanner(System.in);

        while(!input)
        {
            try
            {
                choice = scan.nextInt();
                scan.nextLine(); //Consumes \n
                input = true;
                break;
            }
            catch(Exception e)
            {
                scan.nextLine(); //Consumes \n
                System.out.println("Error! " + e + " Enter an integer and try again!");
                input = false;
            }
            finally
            {
                if(!input)
                {
                    assert (!input): "Invalid Choice must be from 1 and 6.. Try Again";
                }
                else
                {
                   System.out.println("Your selection is: " + choice);
                }
            }
        }
        return choice;
    }

    public static String enterDate()
    {
        int y, m, d;

        System.out.println("Enter year: ");
        y = intInput();

        m = 0;
        do
        {
            System.out.println("Enter month: ");
            m = intInput();
            if(m > 12 || m < 1 || m%1 != 0)
            {
                System.out.println("Month must be from 1 to 12!");
                m = 0;
            }
        }
        while(m == 0);

        d = 0;
        do
        {
            System.out.println("Enter day: ");
            d = intInput();
            if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
            {
                if(d < 1 || d > 31)
                {
                    System.out.println("Day must be from 1 to 31!");
                    d = 0;
                }
            }

            if(m == 4 || m == 6 || m == 9 || m == 11)
            {
                if(d < 1 || d > 30)
                {
                    System.out.println("Day must be from 1 to 30!");
                    d = 0;
                }
            }

            if(m == 2 && y % 4 == 0)
            {
                    if(d < 1 || d > 29)
                    {
                        System.out.println("Day must be from 1 to 29!");
                        d = 0;
                    }
            }
            
            if(m == 2)
            {
                if(d < 1 || d > 28)
                {
                    System.out.println("Day must be from 1 to 28!");
                    d = 0;
                }
            }
        }
        while(d == 0);

        return d + "/" + m + "/" + y;
    }

    public static String noInput(String input) throws NoInputException
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            if(input.equals(""))
            {
                throw new NoInputException();
            }
            else
            {
                return input;
            }
        }
        catch(NoInputException e)
        {
            System.out.println(e);
            return noInput(scan.nextLine());
        }
    }

    //getting the file
    public static void openFile()
    {
        try //opening the file
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("csschool.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    //Read the object from file
    public static void readSchool()
    {
        try
        {
                CSFile = (School) input.readObject();
        }
        catch (EOFException eofException)
        {
            System.out.printf("%No more objects%n");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.out.println("Invalid object type. Terminating");
        }
        catch (IOException ioException)
        {
            System.err.println("error reading from file. Terminating.");
        }
    }

    //close file and terminate application
    public static void closeFile()
    {
        try
        {
            if(input != null)
            {
                input.close();
            }
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
    }

    //open file csscholl.txt
    public static void openTxtFile()
    {
        try
        {
            output = new Formatter("csschool.txt"); //Opening the file
        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating");
            System.exit(1); //Terminate the program
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening the file. Terminating.");
            System.exit(1); //terminate the program
        }
    }

    //add object to file
    public static void addSchool()
    {
        try
        {
            output.format("%s", CSFile);
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating");
        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.err.println("Invalid element. Please try again.");
        }
    }

    public static void closeTxtFile()
    {
        if(output != null)
        {
            output.close();
        }
    }
}

interface PersonalInformation
{
    //PersonalInformation Interface getters and setters
    public String getName();

    public void setName(String name);

    public String getID();

    public void setID(String ID);

    public String getGender();

    public void setGender(String gender);
}

class School implements Serializable
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

class Subject implements Cloneable, Serializable
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

abstract class Student implements PersonalInformation, Serializable
{
    //Declaring attributes
    private String stID;
    private String stName;
    private String stDob;
    private String gender;
    private String course;

    //Student constructor
    public Student(String stID, String stName, String stDob, String gender, String course)
    {
        this.stID = stID;
        this.stName = stName;
        this.stDob = stDob;
        this.gender = gender;
        this.course = course;
    }

    //Default constructor
    public Student()
    {}

    //Student getters and setters
    public String getName()
    {
        return stName;
    }

    public void setName(String name)
    {
        this.stName = name;
    }

    public String getID()
    {
        return stID;
    }

    public void setID(String ID)
    {
        this.stID = ID;
    }

    public String getStDob()
    {
        return stDob;
    }

    public void setStDob()
    {
        this.stDob = stDob;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        String string = "";
        string += "\nStudent Name: " + stName + "\n";
        string += "Student ID: " + stID + "\n";
        string += "DOB: " + stDob + "\n";
        string += "Course: " + course + "\n";
            
        return string;
    }
}

class HDRStudent extends Student
{
    //Declaring attributes
    private AcademicStaff supervisor;

    //HDRStudent constructor
    public HDRStudent(String stID, String stName, String stDob, String gender, String course, AcademicStaff supervisor)
    {
        super(stID, stName, stDob, gender, course);
        this.supervisor = supervisor;
    }

    //Default constructor
    public HDRStudent() 
    {}

    //HDRStudent getters and setters
    public AcademicStaff getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(AcademicStaff supervisor)
    {
        this.supervisor = supervisor;
    }
    
    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Supervisor: " + supervisor.getName();
        
        return string;
    }
}

class CourseWorkStudent extends Student
{
    //Declaring attributes
    private  ArrayList <Subject> enrolledSubjects;

    //CourseWorkStudent constructor
    public CourseWorkStudent(String stID, String stName, String stDob, String gender, String course)
    {
        super(stID, stName, stDob, gender, course);
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

abstract class Staff implements PersonalInformation, Serializable
{
    //Declaring attributes
    private String stID;
    private String stName;
    private String gender;
    private String title;
    private String position;
    private String email;
    private String location;
    private String number;

    //Staff constructor
    public Staff(String stID, String stName, String gender, String title, String position, String email, String location, String number)
    {
        this.stID = stID;
        this.stName = stName;
        this.gender = gender;
        this.title = title;
        this.position = position;
        this.email = email;
        this.location = location;
        this.number = number; 
    }

    //Default Constructor
    public Staff()
    {}

    //Staff getters and setters
    public String getName()
    {
        return stName;
    }

    public void setName(String name)
    {
        this.stName = name;
    }

    public String getID()
    {
        return stID;
    }

    public void setID(String ID)
    {
        this.stID = ID;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        String string ="";
		string += title + " " + stName + "\n";
		string += "Staff ID: " + stID + "\n";
        string += "Gender: " + gender + "\n";
        string += "Phone: " + number + "\n";
        string += "Email: " + email + "\n";
        string += "Location: " + location  + "\n";

        return string;
    }  
}

class ProfessionalStaff extends Staff
{
    //Declaring attributes
    private String workingHours;

    //ProfessionalStaff constructor
    public ProfessionalStaff(String stID, String stName, String gender, String title, String position, String email, String location, String number, String workingHours)
    {
        super(stID, stName, gender, title, position, email, location, number);
        this.workingHours = workingHours;
    }

    //Default constructor
    public ProfessionalStaff()
    {}

    //ProfessionalStaff getters and setters
    public String getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(String workingHours)
    {
        this.workingHours = workingHours;
    }
    
    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        string += "Working Hours: " + workingHours + "\n";
            
        return string;
    }
}

class AcademicStaff extends Staff
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