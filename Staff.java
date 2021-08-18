public class Staff
{
    //Staff attributes
    private String ID;
    private String title;
    private String name;
    private String phone;
    private String email;
    private String location;

    //Staff constructor
    public Staff(String sID, String stitle, String sname, String sphone, String semail, String slocation)
    {
        ID = sID;
        title = stitle;
        name = sname;
        phone = sphone;
        email = semail;
        location = slocation;
    }

    public Staff()
    {
        this("","","","","","");
    }

    //Staff getters and setters
    public String getID()
    {
        return ID;
    }

    public void setID(String sID)
    {
        ID = sID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String stitle)
    {
        title = stitle;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String sname)
    {
        name = sname;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String sphone)
    {
        phone = sphone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String semail)
    {
        email = semail;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String slocation)
    {
        location = slocation;
    }
    
    public String toString()
    {
        String string ="";
		string += title + " " + name + "\n";
		string += "Staff ID: " + ID + "\n";
		string += "Phone: " + phone + "\n";
		string += "Location: " + location  + "\n";

        return string;
    }  
}