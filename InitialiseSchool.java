/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: lab5
-------------------------------------------------------*/

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class InitialiseSchool implements Cloneable
{
    private static ObjectOutputStream output; //outputs data to file

    public static void main(String[] args) throws CloneNotSupportedException
    {
        openFile();
        writeObject();
        closeFile();
    }

    //open file csschool.ser
    public static void openFile()
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("csschool.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating");
            System.exit(1); //Terminate the program
        }
    }

    //adds records to a file
    public static void writeObject() throws CloneNotSupportedException
    {
        School CS = new School("School of Computer Science", null, null);
        AcademicStaff david = new AcademicStaff("100001", "David", "Male", "Prof.", "HoS", "david@university.edu.au", "3.001", "4221-1111");
        ProfessionalStaff cindy = new ProfessionalStaff("100002", "Cindy", "Female", "Miss", "Manager", "cindy@university.edu.au", "3.002", "4221-1112", "Monday ~ Thursday");
                    
        CS.setHoS(david);
        CS.setSchoolManager(cindy);

        CS.staffAdd(david);
        CS.staffAdd(cindy);
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
        CourseWorkStudent isabella = new CourseWorkStudent("1234501", "Isabella", "20/12/2001", "Female", "BCS");
        CS.studentAdd(isabella);
        csit111.enrolledStudentAdd(isabella);
        isabella.enrolledSubjectsAdd(csit111);

        CourseWorkStudent james = new CourseWorkStudent("1234502", "James", "12/2/2000", "Male", "BCS");
        CS.studentAdd(james);
        csit111sws.enrolledStudentAdd(james);
        james.enrolledSubjectsAdd(csit111sws);

        CourseWorkStudent sophia = new CourseWorkStudent("1234503", "Sophia", "14/5/1999", "Female", "BCS");
        CS.studentAdd(sophia);
        csit113.enrolledStudentAdd(sophia);
        sophia.enrolledSubjectsAdd(csit113);

        CourseWorkStudent logan = new CourseWorkStudent("1234504", "Logan", "13/2/2001", "Male", "BCS");
        CS.studentAdd(logan);
        csit113sws.enrolledStudentAdd(logan);
        logan.enrolledSubjectsAdd(csit113sws);

        CourseWorkStudent charlotte = new CourseWorkStudent("1234505", "Charlotte", "29/4/2002", "Female", "BCS");
        CS.studentAdd(charlotte);
        csit114.enrolledStudentAdd(charlotte);
        charlotte.enrolledSubjectsAdd(csit114);

        CourseWorkStudent benjamin = new CourseWorkStudent("1234506", "Benjamin", "24/6/2001", "Male", "BCS");
        CS.studentAdd(benjamin);
        csit114sws.enrolledStudentAdd(benjamin);
        benjamin.enrolledSubjectsAdd(csit114sws);

        CourseWorkStudent amelia = new CourseWorkStudent("1234507", "Amelia", "25/9/2000", "Female", "BCS");
        CS.studentAdd(amelia);
        csit115.enrolledStudentAdd(amelia);
        amelia.enrolledSubjectsAdd(csit115);

        CourseWorkStudent mason = new CourseWorkStudent("1234508", "Mason", "19/12/1999", "Male", "BCS");
        CS.studentAdd(mason);
        csit121.enrolledStudentAdd(mason);
        mason.enrolledSubjectsAdd(csit121);

        CourseWorkStudent evelyn = new CourseWorkStudent("1234509", "Evelyn", "12/5/2002", "Female", "BCS");
        CS.studentAdd(evelyn);
        csit127.enrolledStudentAdd(evelyn);
        evelyn.enrolledSubjectsAdd(csit127);

        CourseWorkStudent elijah = new CourseWorkStudent("12345010", "Elijah", "12/12/2001", "Male", "BCS");
        CS.studentAdd(elijah);
        csit128.enrolledStudentAdd(elijah);
        elijah.enrolledSubjectsAdd(csit128);

        CourseWorkStudent emily = new CourseWorkStudent("12345011", "Emily", "1/1/2000", "Female", "BIT");
        CS.studentAdd(emily);
        csit214.enrolledStudentAdd(emily);
        emily.enrolledSubjectsAdd(csit214);

        CourseWorkStudent aiden = new CourseWorkStudent("12345012", "Aiden", "2/2/2002", "Male", "BIT");
        CS.studentAdd(aiden);
        csci235.enrolledStudentAdd(aiden);
        aiden.enrolledSubjectsAdd(csci235);

        CourseWorkStudent selena = new CourseWorkStudent("12345013", "Selena", "3/3/1999", "Female", "BIT");
        CS.studentAdd(selena);
        csci251.enrolledStudentAdd(selena);
        selena.enrolledSubjectsAdd(csci251);

        HDRStudent sofia = new HDRStudent("12345014", "Sofia", "5/4/2000", "Female", "PhD", david);
        CS.studentAdd(sofia);
        david.HDRStudentSupervisionAdd(sofia);

        HDRStudent lucas = new HDRStudent("12345015", "Lucas", "15/4/2002", "Male", "PhD", liam);
        CS.studentAdd(lucas);
        liam.HDRStudentSupervisionAdd(lucas);

        HDRStudent ella = new HDRStudent("12345016", "Ella", "12/10/1999", "Female", "PhD", noah);
        CS.studentAdd(ella);
        noah.HDRStudentSupervisionAdd(ella);

        HDRStudent ethan = new HDRStudent("12345017", "Ethan", "14/7/2000", "Male", "PhD", william);
        CS.studentAdd(ethan);
        william.HDRStudentSupervisionAdd(ethan);

        HDRStudent victoria = new HDRStudent("12345018", "Victoria", "12/12/2002", "Female", "PhD", emma);
        CS.studentAdd(victoria);
        emma.HDRStudentSupervisionAdd(victoria);

        HDRStudent daniel = new HDRStudent("12345019", "Daniel", "20/11/2000", "Male", "PhD", ava);
        CS.studentAdd(daniel);
        ava.HDRStudentSupervisionAdd(daniel);

        HDRStudent grace = new HDRStudent("12345020", "Grace", "17/10/2001", "Female", "PhD", mia);
        CS.studentAdd(grace);
        mia.HDRStudentSupervisionAdd(grace);
        
        try
        {
            output.writeObject(CS);
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("Invalid input. Please try again.");
        }
        catch (IOException ioException)
        {
            System.err.println("Error writing to file. Terminating.");
        }
    }

    public static void closeFile()
    {
        try
        {
            if (output != null)
            {
                output.close();
            }
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating");
        }
    }
}
