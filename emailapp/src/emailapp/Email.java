package emailapp;

import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	private Signature signature = new Signature();
	// constructor to receive firstName and lastName
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.signature.setSignature("Best Regards,\n"+this.firstName+" "+this.lastName);
		// call a method asking for department
		
		this.department = setDepartment();
		
		// call a method for random password
		
		this.password = setPassword(defaultPasswordLength);
		
		// combine elements to generate email
		
		email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" 
		+ this.department + companySuffix;
		
		// pick alternate email
		setAltEmail();
		// sub object signature
	}
	// ask for department
	private String setDepartment(){
		System.out.println("Enter department: \n1 For Sales"
				+ "\n2 For Development"
				+ "\n3 For Accouting"
				+ "\n4 For None");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		switch(departmentChoice){
		case(1):
			return "sales";
		case(2):
			return "dev";
		case(3):
			return "acc";
		case(4):
			return "";
		default:
			System.out.println("Please kindly type one of above option.");
			return this.setDepartment();
		}
	}
	private String setPassword(int length){
		String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i < length; i++){
			int rand = (int) (Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	// set the mailbox Capacity
	public void mailboxCapacity(){
		System.out.println("Choose mailboxCapacity: \n (a) 100 \n (b) 200 \n (c) 300 \n (d) 400");
		Scanner in = new Scanner(System.in);
		int result = in.nextInt();
		switch(result){
		case 100:
			this.mailboxCapacity = 100; break;
		case 200:
			this.mailboxCapacity = 200; break;
		case 300:
			this.mailboxCapacity = 300; break;
		case 400:
			this.mailboxCapacity = 400; break;
		}
		System.out.println("Your mailbox cap is: "+this.mailboxCapacity);
				
	}
	// set alternate email
	public void setAltEmail(){
		System.out.println("Type your alternate email:\n\t");
		Scanner in = new Scanner(System.in);
		this.alternateEmail = in.nextLine();
		System.out.println("Your new alternate email is:\n\t"+this.alternateEmail+"\n\n \t\t Do you submit?\n\t\tyes/no");
		Scanner in2 = new Scanner(System.in);		
		String result = in.nextLine();
		switch(result){
		case "yes":
			System.out.println("Your alternate email is "+this.alternateEmail); break;
		default:
			setAltEmail(); break;
		}
	}
	
	
	// change password
	
	public void changePassword(){
		System.out.println("Do you wish to change your password?");
		Scanner in = new Scanner(System.in);
		String result = in.nextLine();
		switch(result){
		case "yes":
			System.out.println("Type new password: ");
			this.password = in.nextLine(); break;
		default:
			;break;
		}
	}
	public void showSummary(){
		System.out.println(
		"Summary:\n"+
		"firstname: "+		this.firstName+"\n"+
		"lastname: "+		this.lastName+"\n"+
        "department: "+				this.department+"\n"+
		"email: "+                    this.email+"\n"+
		"alternate email: "+		this.alternateEmail+"\n"+
		"password: "+		this.password+"\n"
				);
		System.out.println("Your signature:");
		signature.showSignature();
	}
}
