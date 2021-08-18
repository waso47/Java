public class TestCode
{
    public static void main(String [] args)
    {
        Timer timer = new Timer(23, 32, 15);
        Alarm alarm = new Alarm("Wake up!!!", 5, 20);
        System.out.println(alarm.toString());
        System.out.println(timer.toString());
    }
}

class Time
{
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        //Validating the time
        if(!validTime(hour, minute, second))
        {
            System.out.println("Invalid time, setting to 00:00:00.");
            this.minute = this.hour = this.second = 0;
        }
    }

    public Time(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;

        //Validating the time
        if(!validTime(hour, minute))
        {
            System.out.println("Invalid time, setting to 00:00.");
            this.minute = this.hour = 0;
        }
    }

    public Time(int hour)
    {
        this.hour = hour;

        //Validating time
        if(!validTime(hour))
        {
            System.out.println("Invalid time, setting to 00.");
            this.hour = 0;
        }
    }

    public Time()
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }


    public int getHour()
    {
        return this.hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;

        //Validate time
        if(!validTime(hour))
        {
            System.out.println("Invalid time, setting to 00.");
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

        //Validate time
        if(!(minute >= 0 && minute < 60))
        {
            System.out.println("Invalid time, setting to 00.");
            this.minute = 0;
        }
    }

    public int getSecond()
    {
        return this.second;
    }

    public void setSecond(int second)
    {
        this.second = second;

        //Validating time
        if(!(second >= 0 && second < 60))
        {
            System.out.println("Invalid time, setting to 00.");
            this.second = 0; 
        }
    }

    public String toString()
    {
        return hour + ":" + minute + ":" + second;
    }

    //Validating hour
    public Boolean validTime(int hour)
    {
        if(hour >= 0 && hour < 24)
        {
            return true;
        }
        return false;
    }

    //Validating hour and minute
    public Boolean validTime(int hour, int minute)
    {
        if(validTime(hour))
        {
            if(minute >= 0 && minute < 60)
            {
                return true;
            }
        }
        return false;
    }

    //Validating hour, minute and second
    public Boolean validTime(int hour, int minute, int second)
    {
        if(validTime(hour, minute))
        {
            if(second >= 0 && second < 60)
            {
                return true;
            }
        }
        return false;
    }
}

class Alarm extends Time
{
    private String alarmName;

    public Alarm(String alarmName, int hour, int minute)
    {
        super(hour, minute);
        this.alarmName = alarmName;
    }

    public Alarm(int hour, int minute)
    {
        //Default alarmName is N/A
        this("N/A", hour, minute);
    }


    public String getAlarmName()
    {
        return this.alarmName;
    }

    public void setAlarmName(String alarmName)
    {
        this.alarmName = alarmName;
    }

    public String toString()
    {
        return alarmName + " " + getHour() + ":" + getMinute();
    }
}

class Timer extends Time
{
    public Timer(int hour, int minute, int second)
    {
        super(hour, minute, second);
    }

    public Timer(int hour, int minute)
    {
        super(hour, minute);
    }

    public Timer(int hour)
    {
        super(hour);
    }

    public void setTimer(int hour, int minute, int second)
    {
        setHour(hour);
        setTimer(minute, second);
    }

    public void setTimer(int hour, int minute)
    {
        setHour(hour);
        setMinute(minute);
    }
}