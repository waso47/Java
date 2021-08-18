import java.util.ArrayList;
import java.util.Scanner;

public class StaffSystem
{
    Scanner scan = new Scanner(System.in);
    private ArrayList<Staff> uniStaff;
    int staffID;

    //Default Constructor
    public StaffSystem()
    {
        uniStaff = new ArrayList<>();
    }

    //Constructor

    public StaffSystem(ArrayList<Staff> uniStaff)
    {
        uniStaff = new ArrayList<>();
    }

    //Adding staff to the arraylist uniStaff
    public void addStaff(Staff staff)
    {
        uniStaff.add(staff);
    }

    //Searching the arraylist uniStaff
    public void findStaff(int staffID)
    {
        if(uniStaff.size() == 0)
        {
            System.out.println("The ArrayList is empty!");
            return;
        }

        System.out.println("Enter the staff ID of the staff member that is wanted: ");
        staffID = scan.nextInt();
        scan.nextLine(); //Consumes \n
        for(int i = 0; i < uniStaff.size(); i++)
        {
            if(uniStaff.get(i).getStaffID() == staffID)
            {
                staffID = i;
                break;
            }
        }

        if(staffID == -1)
        {
            System.out.println("There was no staff member found with the ID: " + staffID + "!");
        }
        else
        {
            System.out.println("Staff member found with given ID: " + uniStaff.get(staffID));
        }
    }

    //Displaying all the staff members
    public void showAllStaffMembers()
    {
        //If ArrayList is empty
        if(uniStaff.size() == 0)
        {
            System.out.println("The Arraylist is empty!");
        }

        else
        {
            //When ArrayList has contents
            System.out.println("All Staff Members:\n");
            for(Staff staff:uniStaff)
            {
                if(staff instanceof ProfessionalStaff)
                {
                    System.out.println(((ProfessionalStaff)staff) + "\n");
                }
                else if(staff instanceof AcademicStaff)
                {
                    System.out.println(((AcademicStaff)staff) + "\n");
                }
            }
        }
    }

    //Updating Staff member
    public void updateStaff()
    {
        //If ArrayList is empty
        if(uniStaff.isEmpty())
        {
            System.out.println("The Arraylist is empty!");
        }

        else
        {
            //When the ArrayList has content
            for(Staff staff:uniStaff)
            {
                if(staff instanceof ProfessionalStaff)
                {
                    ((ProfessionalStaff)staff).setWorkingDays("Monday - Wednesday");
                }
                else if(staff instanceof AcademicStaff)
                {

                    System.out.println("Enter the subject:");
                    ((AcademicStaff)staff).setTeachingSubject(scan.nextLine());
                }
            }
        }
    }

    //Searching for staff
    public void searchStaff()
    {
        System.out.println("Please enter the id of the required staff member:");
        int id = scan.nextInt();
        scan.nextLine(); //Consumes \n
        for(Staff staff:uniStaff)
        {
            if(staff.getStaffID() == id)
            {
                System.out.println("\n" + staff + "\n");
                return;
            }

        }
        System.out.println("\n" + "No staff member with that id exists." + "\n");
    }
}
