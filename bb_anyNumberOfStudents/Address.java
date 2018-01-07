//Honor Pledge: I pledge that I have neither
//given nor received any undue help on this assignment.
//
//strangni

//CS 240 - Assignment 4 - Stacks Upon Stacks
//Created by: Nicholas Strange

public class Address {
	//attributes of an address:
	private String street;        
	private String address_2;
	private String city;
	private String state;
	private String zip;
	
	//default constructor
	public Address(){	
	}
	
	//overloaded constructor; sets an address' attributes
	public Address(String street, String address_2, String city, String state, String zip) {
		this.street = street;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//returns a concatenated string containing an address according to project formatting specs
	//the printStudent() method of the Student class uses this
	public String printAddress(){
		String full_address= "Address: "+street+" "+address_2+" "+city+", "+state+" "+zip;
		return full_address;
	
	}
	
}

