//Importing neccessary packages
import java.util.Scanner;

/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: Lab 4
-------------------------------------------------------*/

//School Management System class
public class SchoolManagementSystem
{
    //main method where the program is written
    public static void main(String[] args) throws NoInputException
    {
		//Creating AcademicStaff object
        AcademicStaff david = new AcademicStaff("100001", "Professor", "David Hintz" , "4221-1111", "david@university.edu.au", "3.001" );
        //Creating ProfessionalStaff object
        ProfessionalStaff cindy = new ProfessionalStaff("100002", "Miss", "Cindy Ma", "4221-1112", "cindy@university.edu.au", "3.002", "Monday - Thursday", "School Manager");

        //Creating School object
        School CS = new School("School of Computer Science", david, cindy);
		
		System.out.println("Welcome to the School of Computer Science. Here is the information about the school\n");
		
		//Disply Current School information
		System.out.println(CS);
		
        boolean loop = true;
        
        while(loop)
		{
			System.out.println("\nPlease make a selection from the following items: ");
            System.out.println("1: add a professional staff member");
            System.out.println("2: add an academic staff member");
            System.out.println("3: add a subject");
            System.out.println("4: add an HDR student");
            System.out.println("5: display the school information");
            System.out.println("6: exit the system");

            Scanner scan = new Scanner(System.in);

            int choice = intInput();
            
            switch(choice)
            {
                //Adding a professional staff member
                case 1:
                    //Getting values of all attributes
                    System.out.println("Please input the staff name:");
                    String psName = noInput(scan.nextLine());
                
                    System.out.println("Please input the staff ID:");
                    String psId = noInput(scan.nextLine());

                    System.out.println("Please the staff title:");
                    String psTitle = noInput(scan.nextLine());

                    System.out.println("Please input the staff phone number:");
                    String psPhone = noInput(scan.nextLine());

                    System.out.println("Please input the staff email address:");
                    String psEmail = noInput(scan.nextLine());

                    System.out.println("Please input the staff office location:");
                    String psOffLoc = noInput(scan.nextLine());

                    System.out.println("Please input the staff working days:");
                    String psWork = noInput(scan.nextLine());

                    System.out.println("Please input the staff position (Manager or Administration):");
                    String psPos = noInput(scan.nextLine());

                    //Creating the new professional staff object
                    ProfessionalStaff newPStaff = new ProfessionalStaff(psId, psTitle, psName, psPhone, psEmail, psOffLoc, psWork, psPos);
                    
                    //Adding new ProfessionalStaff object to arraylist
                    CS.staffAdd(newPStaff);
                    break;

                case 2:
                    //Getting values of all attributes
                    System.out.println("Please input the staff name:");
                    String asName = noInput(scan.nextLine());

                    System.out.println("Please input the staff ID:");
                    String asId = noInput(scan.nextLine());

                    System.out.println("Please the staff title:");
                    String asTitle = noInput(scan.nextLine());

                    System.out.println("Please input the staff phone number:");
                    String asPhone = noInput(scan.nextLine());

                    System.out.println("Please input the staff email address:");
                    String asEmail = scan.nextLine();

                    System.out.println("Please input the staff office location:");
                    String asOffLoc = noInput(scan.nextLine());

                    //Creating the new professional staff object
                    AcademicStaff newAStaff = new AcademicStaff(asId, asTitle, asName, asPhone, asEmail, asOffLoc);

                    //Adding new Academic
                    CS.staffAdd(newAStaff);
                    break;

                //Adding a subject
                case 3:
                    //Getting values of all attributes
                    System.out.println("Please input the subject code:");
                    String subCode = noInput(scan.nextLine());

                    System.out.println("Please input the subject name:");
                    String subName = noInput(scan.nextLine());

                    System.out.println("Please input the subject session and year (such as Autumn 2021):");
                    String subSY = noInput(scan.nextLine());

                    System.out.println("Please nominate a subject coordinator from the following staff:\n");
                    
                    //For loop of the staff array
                    for(int i=0;i<CS.getStaffList().size();i++)
                    {
                        if(CS.getStaffList().get(i) instanceof AcademicStaff)
                        {
                            System.out.println(i + ": " + CS.getStaffList().get(i).getName());
                        }
                        
                    }

                    System.out.println("Please input the index for the subject coordinator:"); //Getting the index of the subject coordinator
                    int coSelection = scan.nextInt();

                    AcademicStaff subCoordinator = (AcademicStaff)CS.getStaffList().get(coSelection);

                    //Creating new subject
                    Subject newSub = new Subject(subCode, subName, subSY, subCoordinator);

                    //Adding new teaching subject
                    subCoordinator.addTeachingSubject(newSub);

                    //Adding new subject to school
                    CS.subjectAdd(newSub);
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

                    System.out.println("Please input the HDR course (Master or PhD):");
                    String stuHDRCourse = noInput(scan.nextLine());

                    System.out.println("Please nominate a supervisor from the following staff:");
                    
                    for(int i=0;i<CS.getStaffList().size();i++)
                    {
                        if(CS.getStaffList().get(i) instanceof AcademicStaff)
                        {
                            System.out.println(i+": "+CS.getStaffList().get(i).getName());
                        }
                    }

                    System.out.println("Please input the index for the subject coordinator:"); //Getting the index of the subject coordinator
                    int supSelection = scan.nextInt();

                    AcademicStaff stuSupervisor = (AcademicStaff)CS.getStaffList().get(supSelection);
                    
                    //Creating new HDR student object
                    HDRStudent hs = new HDRStudent(stuName, stuID, stuDob, stuHDRCourse, stuSupervisor);
                    
                    stuSupervisor.SupervisorAdd(hs);
                    CS.HDRStudentAdd(hs);
                    break;
                
                //Show the whole school information
                case 5:
                    System.out.println(CS);
                    break;

                //To quit the program
                case 6:
                    loop = false;
                    System.out.println("Thanks for using the SMS, see you next time.");
                    break;

                // If selection is invalid    
                default:
                    System.out.println("Invalid Choice must be from 1 and 6.. Try Again");
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
}