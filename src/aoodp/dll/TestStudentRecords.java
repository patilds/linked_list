package aoodp.dll;

/**
 * Assignment 1 - Doubly linked list implementation 
 * Test class to check basic StudentRecords operations
 * @author dhirajpatil.
 * @created 01/29/2015.
 * 
 */
public class TestStudentRecords {
	public static void main(String[] args) {
		//Create an instance of record list
		StudentRecords masterRecordSet = new StudentRecords();
		//Add records to list
		masterRecordSet.insertRecord(new Student("Ajay", "Malhotra", 00001, 3.9));
		masterRecordSet.insertRecord(new Student("Anuj", "Sharma", 00002, 2.4));
		masterRecordSet.insertRecord(new Student("Rajesh", "Agarwal", 00003, 4.0));
		masterRecordSet.insertRecord(new Student("Rohan", "Ahire", 00004, 2.5));
		masterRecordSet.insertRecord(new Student("Ganesh", "Shetty", 00005, 4.0));
		//Print all records
		masterRecordSet.printAllRecords();
		//Check size of linked list
		System.out.println("Size of list is: "+masterRecordSet.getSize());
		//Call to retrieve record with index
		int index = 6;
		System.out.println("Index "+ index +" "+ masterRecordSet.getRecordByIndex(index));
		index = 4;
		System.out.println("Index "+ index +" "+ masterRecordSet.getRecordByIndex(index));
		//Print red-ids of students with GPA less than 2.85
		masterRecordSet.printRecordsWithProbation();
		//Print names of students with GPA 4.0
		masterRecordSet.printRecordsWithFullScore();
	}
}
