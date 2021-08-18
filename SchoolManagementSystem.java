/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

//Importing neccessary packages
import java.util.Scanner;

//School Management System class
public class SchoolManagementSystem implements Cloneable
{
    //main method where the program is written
    public static void main(String[] args) throws CloneNotSupportedException
    {
		System.out.println("\nWelcome to the School of Computer Science.");
		
        AcademicStaff david = new AcademicStaff("100001", "David", "Male", "Prof.", "HoS", "david@university.edu.au", "3.001", "4221-1111");
        ProfessionalStaff cindy = new ProfessionalStaff("100002", "Cindy", "Female", "Miss", "Manager", "cindy@university.edu.au", "3.002", "4221-1112", "Monday ~ Thursday");
        
        School CS = new School("School of Computer Science", david, cindy);
        
        boolean loop = true;
        while(loop)
		{
			System.out.println("\nPlease make a selection from the following items: ");
            System.out.println("1: initialise the school");
            System.out.println("2: add a staff member");
            System.out.println("3: add a subject");
            System.out.println("4: add a student");
            System.out.println("5: display the school's staff members");
            System.out.println("6: display the school's subjects");
            System.out.println("7: display the school's students");
            System.out.println("8: exit the system");

            Scanner scan = new Scanner(System.in);
                    
            int choice = scan.nextInt();

            scan.nextLine(); //Consumes \n
            
            switch(choice)
            {
                //Initialising the school
                case 1:

                    //Initialising the staff members and school
                    AcademicStaff liam = new AcademicStaff("100003", "Liam", "Male", "Dr.", "Lecturer", "liam@university.edu.au", "3.003", "4221-1113");
                    CS.staffAdd(liam);

                    AcademicStaff noah = new AcademicStaff("100004", "Noah", "Male", "Dr.", "Lecturer", "noah@university.edu.au", "3.004", "4221-1114");
                    CS.staffAdd(noah);

                    AcademicStaff william = new AcademicStaff("100005", "William", "Male", "Dr.", "Lecturer", "william@university.edu.au", "3.005", "4221-1115");
                    CS.staffAdd(william);

                    AcademicStaff emma = new AcademicStaff("100006", "Emma", "Female", "Dr.", "Lecturer", "emma@university.edu.au", "3.006", "4221-1116");
                    CS.staffAdd(emma);

                    AcademicStaff ava = new AcademicStaff("100007", "Ava", "Female", "Dr.", "Lecturer", "ava@university.edu.au", "3.007", "4221-1117");
                    CS.staffAdd(ava);

                    AcademicStaff mia = new AcademicStaff("100008", "Mia", "Female", "Dr.", "Lecturer", "mia@university.edu.au", "3.008", "4221-1118");
                    CS.staffAdd(mia);

                    //Initialising the subjects
                    Subject csit111 = new Subject("CSIT111", "Programming Fundamentals", "Autumn 2021", "Wollongong", liam);
                    CS.subjectAdd(csit111);
                    liam.teachingSubjectsAdd(csit111);

                    Subject csit113 = new Subject("CSIT113", "Problem Solving", "Autumn 2021", "Wollongong", noah);
                    CS.subjectAdd(csit113);
                    noah.teachingSubjectsAdd(csit113);

                    Subject csit114 = new Subject("CSIT114", "System Analysis", "Autumn 2021", "Wollongong", william);
                    CS.subjectAdd(csit114);
                    william.teachingSubjectsAdd(csit114);

                    //CLONE csit111 for SWS campus
                    Subject csit111sws = csit111.clone();
                    csit111sws.setSubCode("CSIT111SWS");
                    csit111sws.setCampus("SWS");
                    CS.subjectAdd(csit111sws);
                    liam.teachingSubjectsAdd(csit111sws);

                    //Clone csit113 for SWS campus
                    Subject csit113sws = csit113.clone();
                    csit113sws.setSubCode("CSIT113SWS");
                    csit113sws.setCampus("SWS");
                    CS.subjectAdd(csit113sws);
                    noah.teachingSubjectsAdd(csit113sws);

                    //Clone csit114 for SWS campus
                    Subject csit114sws = csit114.clone();
                    csit114sws.setSubCode("CSIT114SWS");
                    csit114sws.setCampus("SWS");
                    CS.subjectAdd(csit114sws);
                    william.teachingSubjectsAdd(csit114sws);

                    Subject csit115 = new Subject("CSIT115", "Data Management and Security", "Autumn 2021", "Wollongong", emma);
                    CS.subjectAdd(csit115);
                    emma.teachingSubjectsAdd(csit115);

                    Subject csit121 = new Subject("CSIT121", "Object Oriented Design and Programming", "Autumn 2021", "Wollongong", ava);
                    CS.subjectAdd(csit121);
                    ava.teachingSubjectsAdd(csit121);

                    Subject csit127 = new Subject("CSIT127", "Networks and Communications", "Autumn 2021", "Wollongong", mia);
                    CS.subjectAdd(csit127);
                    mia.teachingSubjectsAdd(csit127);

                    Subject csit128 = new Subject("CSIT128", "Introduction to Web Technology", "Autumn 2021", "Wollongong", mia);
                    CS.subjectAdd(csit128);
                    mia.teachingSubjectsAdd(csit128);

                    Subject csit214 = new Subject("CSIT214", "IT Project Management", "Autumn 2021", "Wollongong", david);
                    CS.subjectAdd(csit214);
                    david.teachingSubjectsAdd(csit214);

                    Subject csci235 = new Subject("CSCI235", "Database Systems", "Autumn 2021", "Wollongong", emma);
                    CS.subjectAdd(csci235);
                    emma.teachingSubjectsAdd(csci235);

                    Subject csci251 = new Subject("CSCI251", "Advanced Programming", "Autumn 2021", "Wollongong", ava);
                    CS.subjectAdd(csci251);
                    ava.teachingSubjectsAdd(csci251);

                    //Initialising the students
                    CourseWorkStudent isabella = new CourseWorkStudent("1234501", "Isabella", "Female", "BCS");
                    CS.studentAdd(isabella);
                    csit111.enrolledStudentAdd(isabella);
                    isabella.enrolledSubjectsAdd(csit111);

                    CourseWorkStudent james = new CourseWorkStudent("1234502", "James", "Male", "BCS");
                    CS.studentAdd(james);
                    csit111sws.enrolledStudentAdd(james);
                    james.enrolledSubjectsAdd(csit111sws);

                    CourseWorkStudent sophia = new CourseWorkStudent("1234503", "Sophia", "Female", "BCS");
                    CS.studentAdd(sophia);
                    csit113.enrolledStudentAdd(sophia);
                    sophia.enrolledSubjectsAdd(csit113);

                    CourseWorkStudent logan = new CourseWorkStudent("1234504", "Logan", "Male", "BCS");
                    CS.studentAdd(logan);
                    csit113sws.enrolledStudentAdd(logan);
                    logan.enrolledSubjectsAdd(csit113sws);

                    CourseWorkStudent charlotte = new CourseWorkStudent("1234505", "Charlotte", "Female", "BCS");
                    CS.studentAdd(charlotte);
                    csit114.enrolledStudentAdd(charlotte);
                    charlotte.enrolledSubjectsAdd(csit114);

                    CourseWorkStudent benjamin = new CourseWorkStudent("1234506", "Benjamin", "Male", "BCS");
                    CS.studentAdd(benjamin);
                    csit114sws.enrolledStudentAdd(benjamin);
                    benjamin.enrolledSubjectsAdd(csit114sws);

                    CourseWorkStudent amelia = new CourseWorkStudent("1234507", "Amelia", "Female", "BCS");
                    CS.studentAdd(amelia);
                    csit115.enrolledStudentAdd(amelia);
                    amelia.enrolledSubjectsAdd(csit115);

                    CourseWorkStudent mason = new CourseWorkStudent("1234508", "Mason", "Male", "BCS");
                    CS.studentAdd(mason);
                    csit121.enrolledStudentAdd(mason);
                    mason.enrolledSubjectsAdd(csit121);

                    CourseWorkStudent evelyn = new CourseWorkStudent("1234509", "Evelyn", "Female", "BCS");
                    CS.studentAdd(evelyn);
                    csit127.enrolledStudentAdd(evelyn);
                    evelyn.enrolledSubjectsAdd(csit127);

                    CourseWorkStudent elijah = new CourseWorkStudent("12345010", "Elijah", "Male", "BCS");
                    CS.studentAdd(elijah);
                    csit128.enrolledStudentAdd(elijah);
                    elijah.enrolledSubjectsAdd(csit128);

                    CourseWorkStudent emily = new CourseWorkStudent("12345011", "Emily", "Female", "BIT");
                    CS.studentAdd(emily);
                    csit214.enrolledStudentAdd(emily);
                    emily.enrolledSubjectsAdd(csit214);

                    CourseWorkStudent aiden = new CourseWorkStudent("12345012", "Aiden", "Male", "BIT");
                    CS.studentAdd(aiden);
                    csci235.enrolledStudentAdd(aiden);
                    aiden.enrolledSubjectsAdd(csci235);

                    CourseWorkStudent selena = new CourseWorkStudent("12345013", "Selena", "Female", "BIT");
                    CS.studentAdd(selena);
                    csci251.enrolledStudentAdd(selena);
                    selena.enrolledSubjectsAdd(csci251);

                    HDRStudent sofia = new HDRStudent("12345014", "Sofia", "Female", "PhD", david);
                    CS.studentAdd(sofia);
                    david.HDRStudentSupervisionAdd(sofia);

                    HDRStudent lucas = new HDRStudent("12345015", "Lucas", "Male", "PhD", liam);
                    CS.studentAdd(lucas);
                    liam.HDRStudentSupervisionAdd(lucas);

                    HDRStudent ella = new HDRStudent("12345016", "Ella", "Female", "PhD", noah);
                    CS.studentAdd(ella);
                    noah.HDRStudentSupervisionAdd(ella);

                    HDRStudent ethan = new HDRStudent("12345017", "Ethan", "Male", "PhD", william);
                    CS.studentAdd(ethan);
                    william.HDRStudentSupervisionAdd(ethan);

                    HDRStudent victoria = new HDRStudent("12345018", "Victoria", "Female", "PhD", emma);
                    CS.studentAdd(victoria);
                    emma.HDRStudentSupervisionAdd(victoria);

                    HDRStudent daniel = new HDRStudent("12345019", "Daniel", "Male", "PhD", ava);
                    CS.studentAdd(daniel);
                    ava.HDRStudentSupervisionAdd(daniel);

                    HDRStudent grace = new HDRStudent("12345020", "Grace", "Female", "PhD", mia);
                    CS.studentAdd(grace);
                    mia.HDRStudentSupervisionAdd(grace);
                    
                    break;

                //adding a staff member
                case 2:
                    //Getting values of all attributes
                    System.out.println("Please input the staff name: ");
                    String stName = scan.nextLine();

                    System.out.println("Please input the staff ID: ");
                    String stID = scan.nextLine();

                    System.out.println("Please input the staff title: ");
                    String title = scan.nextLine();

                    System.out.println("Please input the staff gender: ");
                    String gender = scan.nextLine();

                    System.out.println("Please input the staff position: ");
                    String position = scan.nextLine();

                    System.out.println("Please input the staff phone number: ");
                    String number = scan.nextLine();

                    System.out.println("Please input the staff email address: ");
                    String email = scan.nextLine();

                    System.out.println("Please input the staff office location: ");
                    String location = scan.nextLine();

                    //Creating the new staff member
                    System.out.println("Is this (1) a professional staff or (2) an academic staff: ");
                    int staffChoice = scan.nextInt();
                    scan.nextLine(); //Consumes \n
                    if(staffChoice == 1)
                    {
                        System.out.println("Please input the working hours: ");
                        String workingHours = scan.nextLine();
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
                    String subCode = scan.nextLine();

                    System.out.println("Please input the subject name: ");
                    String subName = scan.nextLine();

                    System.out.println("Please input the subject session and year (such as Autumn 2021): ");
                    String session = scan.nextLine();

                    System.out.println("Please input the campus (Wollongong or SWS): ");
                    String campus = scan.nextLine();

                    System.out.println("Please nominate a subject coordinator from the following staff: ");
                    
                    //For loop of the staff array
                    for(int i=0; i<CS.getStaffList().size(); i++)
                    {
                        if(CS.getStaffList().get(i) instanceof AcademicStaff)
                        {
                            System.out.println(i + ": "+CS.getStaffList().get(i).getName());
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
                    String stuName = scan.nextLine();

                    System.out.println("Please input the student ID:");
                    String stuID = scan.nextLine();

                    System.out.println("Please input the student gender:");
                    String stuGender = scan.nextLine();

                    System.out.println("Please input the student course (BCS, BIT, MCS, MIT or PhD): ");
                    String course = scan.nextLine();

                    if(course.equals("PhD"))
                    {
                        
                        System.out.println("Please nominate a supervisor from the following staff:\n");
                    
                        for(int i=0; i<CS.getStaffList().size();i++)
                        {
                            if(CS.getStaffList().get(i) instanceof AcademicStaff)
                            {
                                System.out.println(i + ": "+ CS.getStaffList().get(i).getName());
                            }
                        }
                        System.out.println("Please input the index for the subject coordinator:"); //Getting the index of the subject coordinator
                        int supSelection = scan.nextInt();
                        
                        AcademicStaff supervisor = (AcademicStaff)CS.getStaffList().get(supSelection);

                        //Create HDRStudent
                        HDRStudent newHDRStudent = new HDRStudent(stuID, stuName, stuGender, course, supervisor);
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
                        CourseWorkStudent newCourseWorkStudent = new CourseWorkStudent(stuID, stuName, stuGender, course);
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
                    System.out.println(CS.showStaff());
                    break;

                //Displaying the school's students
                case 6:
                    System.out.println(CS.showStudents());
                    break;

                //Displaying the school's subjects
                case 7:
                    System.out.println(CS.showSubjects());
                    break;
                    
                case 8:
                    loop = false;
                    System.out.println("Thanks for using the SMS, see you next time.");
                    break;

                // If selection is invalid    
                default:
                    System.out.println("Invalid Choice.. Try Again");
            }
        }
    }
}