import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String alternateEmail;
    private String password;
    private String email;
    private String companySuffix="company.com";
    private int mailboxCapacity=500;
    private int defaultPasswordLength=10;

    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
//        System.out.println("Email Created: "+ this.firstName+" "+ this.lastName);

        this.department=setDepartment();
//        System.out.println("Department: " + this.department);

        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Password is :"+ this.password);

        email=firstName.toLowerCase() +"." +lastName.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;
//        System.out.println("Your email is "+email);
    }

    private String setDepartment(){
        System.out.print("Enter your Department\n1 for sales\n2 for Development\n3 for Accounts\n0 for none");
        Scanner input=new Scanner(System.in);
        int depChoice=input.nextInt();
        if (depChoice==1){return "sales";}
        else if (depChoice==2){return "dev";}
        else if(depChoice==3){return "acc";}
        else {return "";}
    }

    private String randomPassword(int len){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$&";
        char[] password= new char[len];
        for(int i=0;i<len;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);

    }

    public void  setMailBoxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    public void changePassword(String password){
        this.password=password;
    }

    public int getMailBoxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}


    public String showInfo(){
        return "Name: "+ firstName+" "+lastName+" "+
                "\nEmail: "+ email +" "+
                "\nMailBoxCapacity: "+ mailboxCapacity+"mb";

    }


}
