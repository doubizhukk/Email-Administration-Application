package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //call a method asking fot the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() +"@" + department + "." + companySuffix;
        System.out.println("Your email is" + email);

    }

    //ask for the department
    private String setDepartment(){
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1)
            return "sales";
        else if(depChoice == 2)
            return "development";
        else if(depChoice == 3)
            return "accounting";
        else
            return "";


    }

    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM@#$%&*";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mail box capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity= capacity;
    }

    //set the alternate email
    public void setAlterEmail(String altEmail){
        this.alternateEmail= altEmail;
    }

    //change the password
    public void changePassword(String password){
       this.password= password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

}
