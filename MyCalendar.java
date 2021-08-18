/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT111
My email address: jaw403@uowmail.edu.au
Assignment number: 3
-------------------------------------------------------*/

import java.util.Scanner;

class MyDate //MyDate class
{
    private int day;
    private int month;
    private int year; //Private data members

    MyDate(int day, int month, int year) //Construtor to input date
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    MyDate() //Default constructor
    {
        this.day = 1;
        this.month = 1;
        this.year = 1800;
    }

    public int getDay() //Return the day
    {
        return day;
    }

    public int getMonth() //Return the month
    {
        return month;
    }

    public int getYear() //Return the year
    {
        return year;
    }

    public String getDate() //Return the date
    {
        return "" + day + "/" + month + "/" + year; //Returns the date as dd/mm/yyyy
    }

    public Boolean isValid() //Check if the date is valid
    {
        if (day < 1 || day > 31 || month < 1 || month > 12)
        {
            return false; //If month is more than 31 days or more than the 12th month
        }

        if (month == 2) //For February to determine if the year is a leap year
        {
            if(year%400==0 || year%4==0&&year%100!=0) 
            {
                if (day > 29) return false;
            }
            else
                if (day > 28) return false;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) //The months that have 30 days
        {
            if (day > 30) return false;
        }

        return true;
    }
}

enum WeekDay
{
    Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday
} //Enumeration of week days

public class MyCalendar //MyCalendar class
{
    private MyDate myDate;

    MyCalendar(MyDate newDate) //Contructor
    {
       myDate = newDate; 
    }

    MyCalendar() //Default Constructor
    {
        myDate = new MyDate();
    }

    public WeekDay dayOfWeek() //Returns the day of week to the array arr
    {
        int q = myDate.getDay();
        int m = myDate.getMonth();

        if ( m < 3) m += 12;

        int y = myDate.getYear();

        if (myDate.getMonth() < 3) y -= 1;

        int k = y % 100;
        int j = y / 100;

        int h = (int)(q + Math.floor(13 * (m + 1) / 5.0) + k + Math.floor(k / 4.0) + Math.floor(j / 4.0) + 5 * j) % 7; //Zeller's Congruence
        WeekDay arr[] = WeekDay.values(); //sending the enum week days to an array

        return arr[h];
    }

    public boolean isLeapYear(int year) //Check if year is a leap year.
    //Is a leap year if can be divided by 400 or
    //if divisible by 4 but not 100.
    {
        if(year%400==0 || year%4==0&&year%100!=0)
           return true;
       return false;
    }

    public int getNumDaysInMonth(int month, int year) //Return the days of the month
    {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year) && month == 2) return 29;
        return days[month - 1];
    }

    public int getStartDay(int day, int month, int year) //Return start of the month day.
    {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        return (d);
    }

    public static String getMonthName(int month) // Return the month name.
    {
        String months[] = {"January" , "February", "March", "April", "May", "June", "July",
                       "August", "September", "October", "November", "December"};

        return months[month - 1];
    }

    public String weekOfMonth() //Returns week number of the month.
    {
        int day = myDate.getDay();
        int week = 0;
        for(int i = 0; i < myDate.getDay(); i += 8)
        {
            week++;
        }
        week = week + 1;
        System.out.println(week);
        String weekWords = null;
        switch(week)
        {
            case 1:
                weekWords = "1st";
                break;
            case 2:
                weekWords = "2nd";
                break;
            case 3:
                weekWords = "3rd";
                break;
            case 4:
                weekWords = "4th";
                break;
            case 5:
                weekWords = "5th";
                break;
        }
        return weekWords;
    }

    public void printMonth() //Prints the calendar of the month
   {
        int month= myDate.getMonth(); //Gets month
        int year= myDate.getYear(); //Gets year
        int startDay = getStartDay(1, month, year)-1; //gets the start day of the month
        String gap = " ";
        int i;
        int days = getNumDaysInMonth(month, year); //Gets the number of days in the month
      
        System.out.println ("MON   TUE   WED   THU   FRI   SAT   SUN");
        
        if(startDay < 0)
        {
            i=-7; //To make code work when starting day is a Sunday
        }
        else
        {
            i = 0;
        }

        for(i = i; i < startDay; i++)
            System.out.printf("%6s", gap); //to print the blank space before the starting day
      
            for(i=1; i<=days; i++)
            {
                System.out.printf("%-6d", i);
                if(((i + startDay) % 7 == 0) || (i == days)) // To print the blank spaces between each number in the calendar
                    System.out.println ();
            }
    }  

    public static void main(String[] args) //Main method
    {
        String s = args[0];

        do
        {
            String a[] = s.split("/"); //Determines when the dat is separated by / as dd/mm/yyyy
            int day = Integer.parseInt(a[0].trim()); // gets the day from the coomand line (dd)
            int month = Integer.parseInt(a[1].trim());// gets the month from the command line (mm)
            int year = Integer.parseInt(a[2].trim()); // gets the year from the command line (yyyy)

            Scanner scan = new Scanner(System.in);

            MyDate mydate = new MyDate(day, month, year); //Creates a date object with the inputted day, month and year

            if(!mydate.isValid())
            {
                System.out.println(args[0] + " is not a valid date, please input a valid date or quit: "); // User has a choice, enter valid date or 
                s = scan.next();
                if(s.equalsIgnoreCase("quit")) //To quit the program
                {
                    System.out.println("Quit MyCalendar, See You!"); // quit program message
                    return;
                }
                continue;
            }
            else
            {
                MyCalendar myCalendar = new MyCalendar(mydate); //Create a new MyCalendar

                System.out.println(s + " is a " + myCalendar.dayOfWeek() + " and locates in the " + myCalendar.weekOfMonth() + " week."); //Prints the result consisting of the day, the date and the week is lies in.

                System.out.println("The calendar of " + myCalendar.getMonthName(mydate.getMonth()) + " " + mydate.getYear() + " is: \n"); //Prints the name of month and what year it is

                myCalendar.printMonth(); //Prints the calendar of the month that the date is in

                return;
            }
        } while(true);
    }
}