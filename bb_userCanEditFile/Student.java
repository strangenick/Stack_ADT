//Honor Pledge: I pledge that I have neither
//given nor received any undue help on this assignment.
//
//strangni

//CS 240 - Assignment 4 - Stacks Upon Stacks
//Created by: Nicholas Strange

public class Student{
	private String ID;           //Student's ID#
	private String fName;    //Student's first name
	private	String lName;    //Student's last name
	private Address home;  //Student's address
	private String gpa;        //Student's GPA
		
	public Student(){  //default constructor
	}
	
	//overloaded constructor; sets Student's private attributes:
	public Student(String fName, String lName, Address home, String ID, String gpa){ 
		this.fName = fName;
		this.lName = lName;	
		this.home = home;
		this.ID = ID;
		this.gpa = gpa;
		}
			
	public void printStudent(){  //prints Student's attributes according to project formatting specs
		String fullName = fName + " "+ lName;
		System.out.printf("ID: %-13s Name: %-20s %-63s GPA: %s\n", ID, fullName, home.printAddress(), gpa); 
	}
}
