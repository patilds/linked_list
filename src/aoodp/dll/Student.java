package aoodp.dll;

/**
 * Assignment 1 - Doubly linked list implementation 
 * This class has the basic structure to store in records and contains getter setter methods to access elements. 
 * @author dhirajpatil.
 * @created 01/29/2015.
 * 
 */
class Student {
	private String firstName;
	private String lastName;
	private int redId;
	private double gpa;
		
	public Student(String firstName, String lastName, int redId, double gpa){
		this.firstName = firstName;
		this.lastName = lastName;
		this.redId = redId;
		this.gpa = gpa;
	}
		
	String getFirstName() {
		return firstName;
	}
	
	String getLastName() {
		return lastName;
	}

	int getRedId() {
		return redId;
	}

	protected double getGpa() {
		return gpa;
	}
	
	@Override
	public String toString() { //override default toString method in order to print Object in our own way 
		//Return object info as required
		return "First Name: "+this.firstName+"\nLast Name: "+this.lastName+"\nRed-id: "+String.format("%05d", this.redId)+"\nGPA: "+this.gpa;
	}
}
