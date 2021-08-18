/*------------------------------------------------------  
My name: Jack Wason
My subject code: CSIT111
My student number: 6780957
My email address: jaw403@uowmail.edu.au
Assignment number: 4
-------------------------------------------------------*/ 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

class Task //Task class
{
    private static int taskcounter = 0; //For the amount of tasks
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm"); // To get a date
    private int taskIDNumber; //ID number for each task
    private String title, date, time, location; //Needed information for each task
    private Date datetime;
    private String participants, duration; //optional information
    // Constructors are below
    public Task(String title, String date, String time, String location) throws ParseException
    {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        taskcounter++;
        this.taskIDNumber = taskcounter;
        this.datetime = dateFormat.parse(date + " " + time);
    }
    
    public Task(String title, String date, String time, String location, String participants) throws ParseException
    {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.participants = participants;
        taskcounter++;
        this.taskIDNumber = taskcounter;
        this.datetime = dateFormat.parse(date + " " + time);
    }
    
    public Task(String title, String date, String time, String location, String participants, String duration) throws ParseException
    {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.participants = participants;
        this.duration = duration;
        taskcounter++;
        this.taskIDNumber = taskcounter;
        this.datetime = dateFormat.parse(date + " " + time);
    }
    
    public String getTime() //Method to return time
    {
        return time;
    }

    public void setTime(String time) //Setting the time
    {
        this.time = time;
    }

    public Date getDatetime() //Method to return datetime
    {
        return datetime;
    }

    public String toString() //Converting the users input to a complete string
    {
        if (participants != null && duration != null)
            return title + ", " + date + ", " + time + ", " + location + ", " + participants + ", " + duration;
        else if (participants != null)
            return title + ", " + date + ", " + time + ", " + location + ", " + participants;
        else
            return title + ", " + date + ", " + time + ", " + location;
    }
}

public class ToDoList //To do list class
{
    public static void main(String[] args)
    {
        int choice;
        Scanner scan = new Scanner(System.in);
        LinkedList <Task> tasks = new LinkedList<>(); //Array of all tasks
        do
        {
            displayMenu();
            choice = scan.nextInt(); //Get choice of menu item from user
            scan.nextLine();
            switch (choice)
            {
                case 1: //Add Task to todolist
                    System.out.println("Enter task details separated by comma (Task name, dd/mm/yyyy, HH:MM, location, opt participants and duration");
                    String details = scan.nextLine();
                    String[] detail = details.split(", ");
                    if (detail.length < 4 || detail.length > 6)
                    {
                        System.out.println("Input mismatch");
                        break;
                    }
                    //validating the date
                    try
                    {
                    detail[1] = detail[1].trim();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false);
                    dateFormat.parse(detail[1]);
                    }
                    catch (Exception e) //If date is in the wrong format
                    {
                        System.out.println("Date should be in dd/mm/yyyy format");
                        break;
                    }
                    //Validating the time
                    try
                    {
                        detail[2] = detail[2].trim();
                        LocalTime.parse(detail[2]);
                    }
                    catch (Exception e) //If time is in the wrong format
                    {
                        System.out.println("Time should be in HH:MM format");
                        break;
                    }
                    //Creating task
                    try
                    {
                        Task task;
                        if (detail.length == 4)
                            task = new Task(detail[0], detail[1], detail[2], detail[3]);
                        else if (detail.length == 5)
                            task = new Task(detail[0], detail[1], detail[2], detail[3], detail[4]);
                        else
                            task = new Task(detail[0], detail[1], detail[2], detail[3], detail[4], detail[5]);
                        tasks.add(task); //Adding task to todolist
                    }
                    catch (ParseException ignored){}
                    System.out.println("Task added successfully.");
                    break;
                
                case 2:
                    {   
                        //Deleting task
                        listTasks(tasks);
                        System.out.print("Enter option: ");
                        int option = scan.nextInt();
                        while (option < 0 || option > tasks.size())
                        {
                            System.out.println("Invalid option... Try again");
                            option = scan.nextInt();
                        }
                        tasks.remove(option - 1);
                        //Remove from list
                        System.out.println("Task deleted successfully.");
                    }
                    break;
                
                case 3:
                    {
                        //deleting all tasks
                        listTasks(tasks);
                        System.out.print("Press 1 to confirm deletion.. 0 to go back ");
                        int option = scan.nextInt();
                        while (option != 0 && option != 1)
                        {
                        System.out.println("Invalid option... Try again");
                        option = scan.nextInt();
                        }
                        if (option == 1)
                        {
                            tasks.clear(); // delete all tasks
                            System.out.println("All Tasks deleted successfully.");
                        }
                        else
                            break;
                    }
                    break;

                case 4:
                    //List all tasks
                    listTasks(tasks);
                    break;
                
                case 5:
                    //Sort all tasks
                    sortTasks(tasks);
                    listTasks(tasks);
                    break;
                
                case 6: //For quitting the program
                    System.out.println("Thank you!");
                    break;
                
                default: //If the choice isn't available
                    System.out.println("Invalid Choice.. Try Again");
            }
        }
        while (choice != 6);
    }

    //Method to display the main menu
    public static void displayMenu()
    {
        System.out.println("#########################\n" + "1: Add a task\n"
        + "2: Delete a task\n" + "3: Delete all tasks\n" + "4: List all tasks\n"
        + "5: Sort all tasks\n" + "6: Exit the program\n" + "#########################");
        System.out.print("Select Action: ");
    }
    // Lists all tasks
    public static void listTasks(LinkedList <Task> tasks)
    {
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < tasks.size(); i++)
        {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
        System.out.println("--------------------------------------------------------------");
    }

    //Sort all tasks by time
    public static void sortTasks(LinkedList <Task> tasks)
    {
        int n = tasks.size();
        Task temp;
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < (n - i); j++)
            {
                if (tasks.get(j - 1).getDatetime().compareTo(tasks.get(j).getDatetime()) > 0)
                {
                    //Swap elements
                    temp = tasks.get(j - 1);
                    tasks.set(j - 1, tasks.set(j, temp));
                }
            }
        }
    }
}