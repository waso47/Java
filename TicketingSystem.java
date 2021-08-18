/*------------------------------------------------------
My name: Jack Wason
My student number: 6780957
My course code: CSIT121
My email address: jaw403@uowmail.edu.au
Assignment number: Final Project
-------------------------------------------------------*/

//Importing Necessary Packages
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class TicketingSystem extends JFrame
{
    private static Formatter output;

    private static Order newOrder = new Order("", "", "", "", "", 0.00);

    //JComboBox Arrays
    private static final String[] genders = {"Male", "Female"};
    private static final String[] stations = {"Kiama", "Shellharbour", "Dapto", "Wollongong", "North Wollongong", "Thirroul", "Sutherland", "Hurstville", "Wolli Creek", "Central"};
    private static final String[] ticketTypes = {"Adult One-Way", "Adult Return", "Adult Weekly", "Child One-Way", "Child Return", "Child Weekly", "Senior One-Way", "Senior Return"};

    // Java Swing Attributes
    private JPanel jPanel1 = new JPanel();
    private JLabel orderDetailsLabel = new JLabel();
    private JButton createOrder = new JButton();
    private JButton addTicket = new JButton();
    private JTextArea orderDetailsTextArea = new JTextArea();
    private JScrollPane orderDetailsScrollPane = new JScrollPane();
    private JButton confirmPurchase = new JButton();
    private JButton deleteTicket = new JButton();
    private JButton cancelOrder = new JButton();  
    private JButton exitButton = new JButton();

    public static void main(String args[])
    {   
        new TicketingSystem().setVisible(true);
    }

    public TicketingSystem()
    {
        super("Ticket Management System");
        initComps();
    }

    private void initComps()
    {
        //Operation when the X button is clicked on the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Setting layout and size of the JPanel
        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 5, 5));
        jPanel1.setSize(1000, 1000);

        //Setting JLabel to Order Details
        orderDetailsLabel.setText("Order Summary:");
        jPanel1.add(orderDetailsLabel);

        //Setting up textArea
        orderDetailsTextArea.setColumns(20);
        orderDetailsTextArea.setRows(20);
        orderDetailsScrollPane.setViewportView(orderDetailsTextArea);
        orderDetailsTextArea.setEditable(false);
        jPanel1.add(orderDetailsScrollPane);

        //Setting label of JButton to Create Order
        //To create new order
        createOrder.setText("Create New Order");

        createOrder.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                createOrderMouseClicked(evt);
            }
        });
        jPanel1.add(createOrder);

        //Setting label of JButton to Add ticket
        //To add new ticket
        addTicket.setText("Add Ticket");
        addTicket.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                addTicketMouseClicked(evt);
            }
        });
        jPanel1.add(addTicket);

        //Setting label of JButton to Confirm Purchase
        //To export order to .txt
        confirmPurchase.setText("Confirm Purchase");
        confirmPurchase.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                confirmPurchaseMouseClicked(evt);
            }
        });
        jPanel1.add(confirmPurchase);

        //Setting label of JButton to Edit Order
        //To remove tickets from order
        deleteTicket.setText("Delete Ticket");
        deleteTicket.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                deleteTicketMouseClicked(evt);
            }
        });
        jPanel1.add(deleteTicket);

        //Setting label of JButton to Cancel Order
        //To cancel the order
        cancelOrder.setText("Cancel Order");
        cancelOrder.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                cancelOrderMouseClicked(evt);
            }
        });
        jPanel1.add(cancelOrder);

        //Setting label of JButton to exit
        //To exit program
        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                exitButtonMouseClicked(evt);
            }
        });
        jPanel1.add(exitButton);

        //Setting the group layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );

        pack();
    }


    //To open option pane to add new ticket to order when the add ticket button is added
    private void createOrderMouseClicked(ActionEvent evt)
    {
        JTextField fName = new JTextField();
        JTextField lName = new JTextField();
        JComboBox<String> gender = new JComboBox(genders);
        JTextField phone = new JTextField();
        JTextField email = new JTextField();
        

        Object[] getInputs =
        {
            "Please input the buyer's first name:", fName,
            "Please input the buyer's last name:", lName,
            "Please select the buyer's gender:", gender,
            "Please enter the buyer's phone number:", phone,
            "Please enter the buyer's email:", email,
        };
        int option = JOptionPane.showConfirmDialog(null, getInputs, "Enter Order Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            String oFName = noInput(fName.getText());
            String oLName = noInput(lName.getText());
            String oGender = String.valueOf(gender.getSelectedItem());
            String oPhone = inputPhone(phone.getText());
            String oEmail = inputEmail(email.getText());
            double totalPrice = 0.00;
            newOrder = new Order(oFName, oLName, oGender, oPhone, oEmail, totalPrice);
            if(oFName != null && oLName != null && oPhone != null && oEmail != null)
            {
                orderDetailsTextArea.setText(newOrder.toString());
            }
        }
    }

    //To open option pane to add new ticket to order when the add ticket button is added
    private void addTicketMouseClicked(ActionEvent evt)
    {
        JTextField fName = new JTextField();
        JTextField lName = new JTextField();
        JComboBox gender = new JComboBox(genders);
        JTextField phone = new JTextField();
        JTextField email = new JTextField();
        JComboBox leaveStation = new JComboBox(stations);
        JComboBox arriveStation = new JComboBox(stations);
        JComboBox type = new JComboBox(ticketTypes);
        //Index for calculating ticket price
        int i = 0;
        int j = 0;

        Object[] getInputs = 
        {
            "Please input the passenger's first name:", fName,
            "Please input the passengers's last name:", lName,
            "Please select the passengers's gender:", gender,
            "Please enter the passenger's phone number:", phone,
            "Please enter the passengers's email:", email,
            "Please select the passenger's Departing Station:", leaveStation,
            "Please select the passenger's Arrival Station:", arriveStation,
            "Please select the passenger's ticket type:", type,
        };
        int option = JOptionPane.showConfirmDialog(null, getInputs, "Enter Ticket details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            String tFName = noInput(fName.getText());
            String tLName = noInput(lName.getText());
            String tGender = String.valueOf(gender.getSelectedItem());
            String tPhone = inputPhone(phone.getText());
            String tEmail = inputEmail(email.getText());
            String tLeaveStation = String.valueOf(leaveStation.getSelectedItem());
            String tArriveStation = String.valueOf(arriveStation.getSelectedItem());
            String tType = String.valueOf(type.getSelectedItem());
            double ticketPrice = 0.00;

            if(tLeaveStation.equals("Kiama"))
            {
                i = 1;
            }
            if(tArriveStation.equals("Kiama"))
            {
                j = 1;
            }
            if(tLeaveStation.equals("Shellharbour"))
            {
                i = 2;
            }
            if(tArriveStation.equals("Shellharbour"))
            {
                j = 2;
            }
            if(tLeaveStation.equals("Dapto"))
            {
                i = 3;
            }
            if(tArriveStation.equals("Dapto"))
            {
                j = 3;
            }
            if(tLeaveStation.equals("Wollongong"))
            {
                i = 4;
            }
            if(tArriveStation.equals("Wollongong"))
            {
                j = 4;
            }
            if(tLeaveStation.equals("North Wollongong"))
            {
                i = 5;
            }
            if(tArriveStation.equals("North Wollongong"))
            {
                j = 5;
            }
            if(tLeaveStation.equals("Thirroul"))
            {
                i = 6;
            }
            if(tArriveStation.equals("Thirroul"))
            {
                j = 6;
            }
            if(tLeaveStation.equals("Sutherland"))
            {
                i = 7;
            }
            if(tArriveStation.equals("Sutherland"))
            {
                j = 7;
            }
            if(tLeaveStation.equals("Hurstville"))
            {
                i = 8;
            }
            if(tArriveStation.equals("Hurstville"))
            {
                j = 8;
            }
            if(tLeaveStation.equals("Wolli Creek"))
            {
                i = 9;
            }
            if(tArriveStation.equals("Wolli Creek"))
            {
                j = 9;
            }
            if(tLeaveStation.equals("Central"))
            {
                i = 10;
            }
            if(tArriveStation.equals("Central"))
            {
                j = 10;
            }
            if(i == 9 || j ==9)
            {
                ticketPrice = 15;
            }
            //Calculating ticket price
            if(newOrder.getFName() != "")
            {
                    if(tType.equals("Adult One-Way"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Adult newAdult = new Adult(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newAdult);
                        newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Adult Return"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 1.8;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Adult newAdult = new Adult(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newAdult);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    } 
                }
                else if(tType.equals("Adult Weekly"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 1.8;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 6;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Adult newAdult = new Adult(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newAdult);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Child One-Way"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 0.5;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Child newChild = new Child(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newChild);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Child Return"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 1.8;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 0.5;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Child newChild = new Child(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newChild);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Child Weekly"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 1.8;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 6;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 0.5; 
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Child newChild = new Child(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, ticketPrice);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newChild);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Senior One-Way"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 0.1;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Senior newSenior = new Senior(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, Math.round(ticketPrice * 20) / 20.0);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newSenior);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
                else if(tType.equals("Senior Return"))
                {
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 + (Math.abs(i - j) * 1.2);
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 1.8;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0 * 0.1;
                    ticketPrice = Math.round(ticketPrice * 20) / 20.0;
                    Senior newSenior = new Senior(tFName, tLName, tGender, tPhone, tEmail, tLeaveStation, tArriveStation, tType, Math.round(ticketPrice * 20) / 20.0);
                    if(tFName != null && tLName != null && tPhone != null && tEmail != null)
                    {
                        newOrder.ticketsOrdered.add(newSenior);
                        TicketingSystem.newOrder.setTotalPrice(Math.round(ticketPrice * 20) / 20.0);
                        orderDetailsTextArea.setText(newOrder.toString());
                    }
                }
            }
            else
            {
                int opt = JOptionPane.showConfirmDialog(null, null, "Create Order First!", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }

    //When an action is performed to confirm purchase button
    private void confirmPurchaseMouseClicked(ActionEvent evt)
    {
        openTxtFile();
        addOrder();
        closeTxtFile();
        Order newOrder = new Order("", "", "", "", "", 0.00);
        orderDetailsTextArea.setText(newOrder.toString());
    }

    //To delete tickets from order
    private void deleteTicketMouseClicked(ActionEvent evt)
    {
        JList ticketDelete = new JList(newOrder.ticketsOrdered.toArray());

        Object[] getInputs =
        {
            "Select ticket to delete", ticketDelete
        };
        int option = JOptionPane.showConfirmDialog(null, getInputs, "Select the ticket to edit", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            int delete = ticketDelete.getSelectedIndex();
            TicketingSystem.newOrder.setTotalPrice(0-(newOrder.ticketsOrdered.get(delete).getTicketPrice()));
            TicketingSystem.newOrder.ticketsOrdered.remove(delete);
            orderDetailsTextArea.setText(newOrder.toString());
        }
    }

    //To cancel order
    private void cancelOrderMouseClicked(ActionEvent evt)
    {
        Order newOrder = new Order("", "", "", "", "", 0.00);
        TicketingSystem.newOrder.setTotalPrice(0-(newOrder.getTotalPrice()));
        newOrder.ticketsOrdered.clear();
        orderDetailsTextArea.setText(newOrder.toString());
    }

    //to exit program when the exit button is clicked
    private void exitButtonMouseClicked(ActionEvent evt)
    {
        System.exit(0);
    }

    //open file (1st ticket holders lastname).txt
    public static void openTxtFile()
    {
        String ticketHoldersLname = newOrder.ticketsOrdered.get(0).getLName();
        try
        {
            output = new Formatter(ticketHoldersLname + ".txt"); //Opening the file
        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating");
            System.exit(1); //Terminate the program
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening the file. Terminating.");
            System.exit(1); //terminate the program
        }
    }

    //add object to file
    public static void addOrder()
    {
        try
        {
            output.format("%s", newOrder);
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating");
        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.err.println("Invalid element. Please try again.");
        }
    }

    public static void closeTxtFile()
    {
        if(output != null)
        {
            output.close();
        }
    }

    public static String noInput(String input)
    {
        boolean data = false;
        do
        {
            if(input.equals(""))
            {
                int option = JOptionPane.showConfirmDialog(null, null, "A text input was empty. Please enter something", JOptionPane.OK_CANCEL_OPTION);
                return null;
            }
            else
            {
                data = true;
                return input;
            }
        }
        while(!data);
    }

    public static String inputPhone(String input)//Error checking for phone number, must be in format iiii-iiii
    {
       boolean data;
       do
       {
           data = true;
           
           if(input.length() == 9)
           {
               for(int i = 0; i < 9; i++)
               {
                   if(i == 4)
                   {
                       if(!(input.substring(4, 5).equals("-")))
                       {
                           data = false;
                       }
                   }
                   else
                   {
                       if(!(input.substring(i, i + 1).equals("1") || input.substring(i, i + 1).equals("2") || input.substring(i, i + 1).equals("3") || input.substring(i, i + 1).equals("4") || input.substring(i, i + 1).equals("5") || 
                       input.substring(i, i + 1).equals("6") || input.substring(i, i + 1).equals("7") || input.substring(i, i + 1).equals("8") || input.substring(i, i + 1).equals("9") || input.substring(i, i + 1).equals("0")))
                       {
                           data = false;
                       }
                   }
               }
           }
           else
           {
               data = false;
               int option = JOptionPane.showConfirmDialog(null, null, "Invalid phone number must be in format iiii-iiii. Try again.", JOptionPane.OK_CANCEL_OPTION);
               return null;
           }
           if(data = true)
           {
               return input;
           }
           else
           {
            int option = JOptionPane.showConfirmDialog(null, null, "Invalid phone number must be in format iiii-iiii. Try again.", JOptionPane.OK_CANCEL_OPTION);
           }
       }
       while(!data);
       return input;
    }

    public static String inputEmail(String input)//Error checking for staff email
    {
        boolean data = false;
        do
        {
            if(input.contains("@"))
            {
                data = true;
            }
            else
            {
                int option = JOptionPane.showConfirmDialog(null, null, "A correct email must include an @", JOptionPane.OK_CANCEL_OPTION); 
                return null;
            }
        }
        while(!data);
        return input;
    }
}

//PersonalInformation interface
interface PersonalInformation
{
    //PersonalInformation Interface getters and setters
    public String getFName();

    public void setFName(String fName);

    public String getLName();

    public void setLName(String lName);

    public String getGender();

    public void setGender(String gender);

    public String getPhone();

    public void setPhone(String phone);

    public String getEmail();

    public void setEmail(String email);
}

//Order class
class Order implements PersonalInformation, Serializable
{
    //Declaring attributes
    private String oFName;
    private String oLName;
    private String oGender;
    private String oPhone;
    private String oEmail;
    private double totalPrice;
    ArrayList <Ticket> ticketsOrdered = new ArrayList<Ticket>();

    //Order constructor
    public Order(String oFName, String oLName, String oGender, String oPhone, String oEmail, double totalPrice)
    {
        this.oFName = oFName;
        this.oLName = oLName;
        this.oGender = oGender;
        this.oPhone = oPhone;
        this.oEmail = oEmail;
        this.totalPrice = Math.round(totalPrice * 20) / 20.0;
        ticketsOrdered = new ArrayList<>();
    }

    //Default constructor
    public Order()
    {}

    //Order getters and setters
    public ArrayList<Ticket> getTicketsOrdered()
    {
        return ticketsOrdered;
    }

    public String getFName()
    {
        return oFName;
    }

    public void setFName(String fName)
    {
        this.oFName = fName;
    }

    public String getLName()
    {
        return oLName;
    }

    public void setLName(String lName)
    {
        this.oLName = lName;
    }

    public String getGender()
    {
        return oGender;
    }

    public void setGender(String gender)
    {
        this.oGender = gender;
    }

    public String getPhone()
    {
        return oPhone;
    }

    public void setPhone(String phone)
    {
        this.oPhone = phone;
    }

    public String getEmail()
    {
        return oEmail;
    }

    public void setEmail(String email)
    {
        this.oEmail = email;
    }

    public double getTotalPrice()
    {
        return Math.round(totalPrice * 20) / 20.0;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice += Math.round(totalPrice * 20) / 20.0;
    }

    public void ticketAdd(Ticket ticket)
    {
        if(!ticketsOrdered.contains(ticket))
        {
            ticketsOrdered.add(ticket);
        }
    }

    //Making the return value a string
    @Override
    public String toString()
    {
        String string = "";
        string += "Buyer's Name: " + getFName() + " " + getLName();
        string += "\nBuyer's Gender: " + getGender();
        string += "\nBuyer's Phone Number: " + getPhone();
        string += "\nBuyer's Email Address: " + getEmail();
        string += "\nTicket list:\n";
        for(Ticket ticket:getTicketsOrdered())
        {
            string += ticket.toString() + "\n";
        }
        string += "\nTotal Order Price: " + getTotalPrice();
        return string;
    }
}

//Ticket class
abstract class Ticket implements PersonalInformation, Serializable
{
    //Declaring attributes
    private String tFName;
    private String tLName;
    private String tGender;
    private String tPhone;
    private String tEmail;
    private String tLeaveStation;
    private String tArriveStation;
    private String type;
    private double ticketPrice;

    //Ticket Constructor
    public Ticket(String tFName, String tLName, String tGender, String tPhone, String tEmail, String tLeaveStation, String tArriveStation, String type, double ticketPrice)
    {
        this.tFName = tFName;
        this.tLName = tLName;
        this.tGender = tGender;
        this.tPhone = tPhone;
        this.tEmail = tEmail;
        this.tLeaveStation = tLeaveStation;
        this.tArriveStation = tArriveStation;
        this.type = type;
        this.ticketPrice = ticketPrice;
    }

    //Default constructor
    public Ticket()
    {}


    //Ticket getters and setters
    public String getFName()
    {
        return tFName;
    }

    public void setFName(String fName)
    {
        this.tFName = fName;
    }

    public String getLName()
    {
        return tLName;
    }

    public void setLName(String lName)
    {
        this.tLName = lName;
    }

    public String getGender()
    {
        return tGender;
    }

    public void setGender(String gender)
    {
        this.tGender = gender;
    }

    public String getPhone()
    {
        return tPhone;
    }

    public void setPhone(String phone)
    {
        this.tPhone = phone;
    }

    public String getEmail()
    {
        return tEmail;
    }

    public void setEmail(String email)
    {
        this.tEmail = email;
    }

    public String getLeaveStation()
    {
        return tLeaveStation;
    }

    public void setLeaveStation(String leaveStation)
    {
        this.tLeaveStation = leaveStation;
    }

    public String getArriveStation()
    {
        return tArriveStation;
    }

    public void setArriveStation(String arriveStation)
    {
        this.tArriveStation = arriveStation;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString()
    {
        String string = "";
        string += "\nPassenger's Name: " + getFName() + " " + getLName();
        string += "\nPassenger's Gender: " + getGender();
        string += "\nPassenger's Phone Number: " + getPhone();
        string += "\nPassenger's Email Address: " + getEmail();
        string += "\nPassenger's Departing Station: " + getLeaveStation();
        string += "\nPassenger's Arrival Station: " + getArriveStation();
        string += "\nPassenger's Ticket Type: " + getType();
        string += "\nTicket Price: " + getTicketPrice();
        return string;
    }
}

//Adult ticket class
class Adult extends Ticket
{
    //Adult ticket constructor
    public Adult(String tFName, String tLName, String tGender, String tPhone, String tEmail, String leaveStation, String arriveStation, String type, double ticketPrice)
    {
        super(tFName, tLName, tGender, tPhone, tEmail, leaveStation, arriveStation, type, ticketPrice);
    }

    //Default constructor
    public Adult()
    {}

    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        return string;
    }
}

//Child ticket class
class Child extends Ticket
{
    //Child ticket constructor
    public Child(String tFName, String tLName, String tGender, String tPhone, String tEmail, String leaveStation, String arriveStation, String type, double ticketPrice)
    {
        super(tFName, tLName, tGender, tPhone, tEmail, leaveStation, arriveStation, type, ticketPrice);
    }

    //Default constructor
    public Child()
    {}

    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        return string;
    }
}

//Senior ticket class
class Senior extends Ticket
{
    //Senior ticket constructor
    public Senior(String tFName, String tLName, String tGender, String tPhone, String tEmail, String leaveStation, String arriveStation, String type, double ticketPrice)
    {
        super(tFName, tLName, tGender, tPhone, tEmail, leaveStation, arriveStation, type, ticketPrice);
    }

    //Default constructor
    public Senior()
    {}

    @Override
    public String toString()
    {
        String string = "";
        string += super.toString();
        return string;
    }
}