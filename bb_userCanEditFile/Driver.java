//Honor Pledge: I pledge that I have neither
//given nor received any undue help on this assignment.
//
//strangni

//CS 240 - Assignment 4 - Stacks Upon Stacks
//Created by: Nicholas Strange

import java.io.*;
import java.util.Scanner;

public class Driver{
	
	public static void main (String[] args){
		int selection = 0;  //stores user's menu selection
		  //creates instance of a Stack of Students by calling the constructor
		Scanner input = new Scanner(System.in);  //used for getting user input
		int numStudents = 0;
		String modify;
		int lineToEdit;
		System.out.println("\nWelcome to the CSCI 240 Student program!");
		
		try{
			//strategy for reading text file data:
			InputStream inputStream = new FileInputStream("students.txt");
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();  //returns the next line in the text file
			while (line != null){ 
				numStudents++; 
				line = buffer.readLine();
			}
			buffer.close();
					
		}catch(FileNotFoundException fnfe){
			System.out.println("The student file cannot be found. Make sure it exists and is in the right folder, and rerun the program.");
		}
		catch(IOException e){
			System.err.println(e);
		}
		Stack<Student> studentStack = new Stack<Student>(numStudents);
		
		
		System.out.print("Would you like to edit a student? Y|N: ");
		modify = input.next();
		
		while (modify.compareTo("Y") == 0){
			
			try{
				System.out.println("Which line would you like to modify (starting with line 1) ?");
				lineToEdit = input.nextInt();
				input.nextLine();
				System.out.println("\nType the new line here:\n");
				String replacement = input.nextLine();
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("students.temp")));
				FileReader readr = new FileReader("students.txt");
				BufferedReader br = new BufferedReader(readr);
				String liner = br.readLine();
				while (liner != null){
				for(int j=0; j<numStudents; j++){
					if (j==lineToEdit-1){
						liner = liner.replace(liner, replacement);
					}
					writer.println(liner);
					liner = br.readLine();
				}
		
				}
				
				writer.close();
				File real = new File("students.txt");
				real.delete();
				new File("students.temp").renameTo(real);
				
				System.out.print("Would you like to edit another student? Y|N: ");
				modify = input.next();
				
			}catch (IOException e) {
				System.err.println(e);
			}
			
			
		}
		
		while (selection != 3){  //while the user hasn't selected to end the program:
		
			System.out.print("\n1. Load Students (From File)\n2. Print Stack\n3. Exit Program\nPlease enter your selection:  ");  //menu
			selection = input.nextInt();  //get user's menu selection
			
			switch(selection){
			
				case 1:  //user has selected to load students from the text file
				
					/*if (studentStack.isFull()){  //controls for the case where the user selects this option more than once in a row
						System.out.println("\nThe students have already been loaded!");
					}else{*/
						try{
							InputStream iS = new FileInputStream("students.txt");
							InputStreamReader read = new InputStreamReader(iS);
							BufferedReader buff = new BufferedReader(read);
							String lines = buff.readLine();
							while (lines != null) {
								
								String[] parsed = lines.split(",");  //delimits the line by commas and stores 'tokens' in an array
								
								//assign the new 'tokens' created by line.split to their respective variables
								String lName = parsed[0];
								String fName = parsed[1];
								String street = parsed[2];
								String address_2 = parsed[3];
								String city = parsed[4];
								String state = parsed[5];
								String zip = parsed[6];
								String ID = parsed[7];
								String gpa = parsed[8];
								
								//pass the variables to the Address and Student constructors to create an Address and Student:
								Address home = new Address(street, address_2, city, state, zip);
								Student pupil = new Student(fName, lName, home, ID, gpa);
								
								studentStack.push(pupil); //push the new Student onto the Student Stack
								lines = buff.readLine();  //read next line, and repeat
							
							}
							buff.close();
						}catch(IOException q){
							System.err.println(q);
						}
							
							System.out.println("\nStudents successfully loaded from file!");
					
					break;
					
				case 2:  //user has selected to print out the Students who were previously loaded from text file
					System.out.print("\n");
					try{
						for (int i=0; i<numStudents; i++){
							Student nextStudent = studentStack.pop();  //pops the Students off the Student Stack one-by-one...
							nextStudent.printStudent();  //...and prints them
						}				
					}catch(NullPointerException npe){  //if the user has selected to print the Students twice in a row or before they have been loaded:
						System.err.println(npe + ". There are no students to print; select option 1 to load students.");
					}
					break;

				case 3:  //option to end program
					break;

				default:  //if the user has selected a number besides 1, 2, or 3:
					System.out.println("Invalid choice! Please select Option 1, 2, or 3.\n");
			}
		}

		System.out.println("\nThank you for using our program! Goodbye!\n");				
	}
}
