//Importing necessary packages
import java.util.ArrayList;
import java.util.Scanner;

public class TestCode
{
    public static void main(String[] args)
    {
        Alarm alarm1 = new Alarm("Alarm number 1", 5, 70);

        System.out.println("Alarm: " + alarm1);

        System.out.println("Changing the hour to 2.");

        try
        {
            alarm1.setHour(5);
        }

        catch (Exception e)
        {
            System.out.println("Error, hour must be between 0 and 24. " + e + "TRY AGAIN!!");
        }

        System.out.println("Alarm = " + alarm1);

        System.out.println("Changing the hour to 3.");

        try
        {
            alarm1.setHour(2);
        }

        catch (Exception e)
        {
            System.out.println("Error, hour must be between 0 and 24. " + e + "TRY AGAIN!!");
        }

        System.out.println("Alarm = " + alarm1);

        System.out.println("Alarm = " + alarm1);

        System.out.println("Changing the minutes to 55.");

        try
        {
            alarm1.setMinute(55);
        }

        catch (Exception e)
        {
            System.out.println("Error, minutes must be between 0 and 60. " + e + "TRY AGAIN!!");
        }

        System.out.println("Alarm = " + alarm1);

        AlarmManagement alarmManager = new AlarmManagement();

        System.out.println("Adding alarm to alarm management.");
        alarmManager.addAlarm(alarm1);
        alarmManager.displayAlarmView();

        System.out.println("Adding an alarm from view.");
        alarmManager.addAlarmFromView();
        alarmManager.displayAlarmView();
        System.out.println("Alarm at index 0 = " + alarmManager.getAlarmAt(0));
        System.out.println("Alarm at index 1 = " + alarmManager.getAlarmAt(1));
    }
}

//Alarm Class
class Alarm
{
    //Declaring Attributes
    private String alarmName;
    private int hour;
    private int minute;

    //Constructors
    public Alarm(String alarmName, int hour, int minute)
    {
        this.alarmName = alarmName;
        this.hour = hour;
        this.minute = minute;
    }

    public Alarm(int hour, int minute) throws Exception
    {
        //Check time for alarm is valid
        if(hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
        {
            this.hour = hour;
            this.minute = minute;
        }
        else
        {
            throw new Exception("Input value is not valid, try again.");
        }
    }

    //Getters and Setters
    public String getAlarmName()
    {
        return this.alarmName;
    }

    public void setAlarmName(String alarmName)
    {
        this.alarmName = alarmName;
    }

    public int getHour()
    {
        return this.hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
        //Checking that hour is valid
        if(!isValidTime(hour))
        {
            System.out.println("Hour is incorrect, must be between 0 and 24. Now set to 0.");
            this.hour = 0;
        }
    }

    public int getMinute()
    {
        return this.minute;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
        if(!(minute >= 0 && minute < 60))
        {
            System.out.println("Minute is incorrect, must be between 0 and 24. Now set to 0.");
            this.minute = 0;
        }
    }

    //To string method
    @Override
    public String toString()
    {
        return getAlarmName() + " at " + getHour() +
            ":" + getMinute();
    }

    public Boolean isValidTime(int hour)
    {
        if(hour >= 0 && hour < 24)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public Boolean isValidTime(int hour, int minute)
    {
        if(isValidTime(hour))
        {
            if(minute >= 0 && minute < 60)
            {
                return true;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}

class AlarmView
{
    Scanner scan = new Scanner(System.in);

    public AlarmView()
    {

    }

    public Alarm userCreateAnAlarm()
    {
        System.out.println("Please enter the name for your alarm: ");
        String aName = scan.nextLine();
        
        System.out.println("Please enter hour for your alarm");
        int hour = scan.nextInt();

        System.out.println("Please enter minute for your alarm");
        int minute = scan.nextInt();

        //Creating new Alarm object
        Alarm alarm = new Alarm(aName, hour, minute);
        alarm.setHour(hour);
        alarm.setMinute(minute);
        return alarm;
    }

    public int getAlarmIndex()
    {
        System.out.println("Enter the alarm index: ");
        int alarmIndex = scan.nextInt();
        return alarmIndex;
    }

    public void displayAlarm(String name)
    {
        System.out.println("\t" + name);
    }
}

class AlarmManagement
{
    ArrayList <Alarm> alarms;
    private AlarmView view;    

    //Constructors
    public AlarmManagement()
    {
        alarms = new ArrayList<>();
        view = new AlarmView();
    }

    public void addAlarm(Alarm alarm)
    {
        alarms.add(alarm);
    }

    public Alarm getAlarmAt(int alarmIndex)
    {
        return alarms.get(alarmIndex);
    }

    public void addAlarmFromView()
    {
        //Creating new alarm
        Alarm  alarm = view.userCreateAnAlarm();
        addAlarm(alarm);
    }

    public void displayAlarmView()
    {
        for(Alarm allAlarm:alarms)
            view.displayAlarm(allAlarm.getAlarmName());
    }

}


