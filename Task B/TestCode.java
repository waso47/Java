public class TestCode implements Cloneable
{
    public static void main(String[] args) throws CloneNotSupportedException
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

        Staff acaStaff2 = acaStaff1.clone();
        acaStaff2.setFName("Austin");
        acaStaff2.setLName("Evans");
        acaStaff2.setAddress(new Address(65, "Home", "Wollongong", "NSW", 2500, "Australia"));
        staffSystem.addStaff(acaStaff2);

        Staff proStaff2 = proStaff1.clone();
        proStaff2.setFName("Ali");
        proStaff2.setLName("Muhammed");
        proStaff2.setAddress(new Address(21, "Jump", "Sydney", "NSW", 2000, "Australia"));
        staffSystem.addStaff(proStaff2);

        //Showing all staff objects
        staffSystem.showAllStaffMembers();
    }
}

