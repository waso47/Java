public class TestCode
{
    public static void main(String[] args)
    {
        //Creating StaffSystem object
        StaffSystem staffSystem = new StaffSystem();

        //Creating ProfessionalStaff object
        Address address1 = new Address(28, "Crown", "Wollongong", "NSW", 2500, "Austrlia");
        ProfessionalStaff proStaff1 = new ProfessionalStaff("Billbo", "Baggons", "24/06/1992", address1, 0445345653, 100001, "Administrator", "Monday - Thursday");

        //Creating AcademicStaff object
        Address address2 = new Address(45, "Pitt", "Sydney", "NSW", 2000, "Australia");
        AcademicStaff acaStaff1 = new AcademicStaff("Severus", "Snape", "26/12/1990", address2, 0456437564, 200001, "Professer", "ENG101", "Engineering");

        //Adding staff objects to ArrayList
        staffSystem.addStaff(proStaff1);
        staffSystem.addStaff(acaStaff1);

        //Searching for a particular staff member
        staffSystem.searchStaff();

        //Showing all staff objects
        staffSystem.showAllStaffMembers();

        //Updating staff objects
        staffSystem.updateStaff();
        System.out.println("Updated staff information!\n");
        staffSystem.showAllStaffMembers();
    }
}

