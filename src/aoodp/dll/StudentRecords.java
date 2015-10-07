package aoodp.dll;

/**
 * Assignment 1 - Doubly linked list implementation This class contains the
 * logic to create doubly linked list of Student records which contains Records
 * as nodes which ultimately contain Student objects as their data (variable).
 * It also contains various methods to perform some operations on this list such
 * as add, search and print records.
 * 
 * @author dhirajpatil.
 * @created 01/29/2015.
 * 
 */
public class StudentRecords {
	// Inner class Record to store student information as Nodes of linked list
	private class Record {
		Student information;
		Record previousRecord;
		Record nextRecord;

		// Parameterized constructor
		Record(Student newInfo) {
			this.information = newInfo;
			this.previousRecord = null;
			this.nextRecord = null;
		}

		@Override
		public String toString() {
			return "Record info is: \n" + this.information
					+ "\n----------------------------\n";
		}
	}

	private Record firstRecord;
	private Record lastRecord;//extra variable to traverse list from last
	private int size = 0;

	// default constructor
	public StudentRecords() {
		firstRecord = null;
		lastRecord = null;
	}

	/**
	 * Function to insert a record in lexicographic order
	 * 
	 * @param studentInfo
	 */
	public void insertRecord(Student studentInfo) {
		// Find position for record to insert after, lexicographically
		Record currentRecord = findPositionToInsertAfter(studentInfo);

		// Create record object with given student info
		Record newRecord = new Record(studentInfo);
		// Assign the current record to previous link
		newRecord.previousRecord = currentRecord;

		// Case in which we insert new record at start
		if (currentRecord == null) {
			newRecord.nextRecord = firstRecord;
			if (firstRecord != null)
				firstRecord.previousRecord = newRecord;
			firstRecord = newRecord;
		}
		// Case in which we insert a new record after other record
		else {
			// Assign current record's next to next of new record
			// Case where we insert record at last
			if (currentRecord.nextRecord == null) {
				lastRecord = newRecord;
				newRecord.previousRecord = currentRecord;
				currentRecord.nextRecord = newRecord;
			} else {
				newRecord.nextRecord = currentRecord.nextRecord;
				newRecord.nextRecord.previousRecord = newRecord;
				currentRecord.nextRecord = newRecord;
			}
		}
		size += 1;
	}

	/**
	 * Function to find position to insert a record after a particular record
	 * (node) in lexicographic order
	 * 
	 * @param info
	 */
	private Record findPositionToInsertAfter(Student info) {
		Record localFirst = firstRecord;
		while (localFirst != null) {
			// Compare last name of given record to each record in list

			// Case in which current records last name comes lexicographically
			// first compared to last name of recored to be inserted
			if (localFirst.information.getLastName().compareTo(
					info.getLastName()) < 0) {
				if (localFirst.nextRecord != null)
					localFirst = localFirst.nextRecord;
				else
					return localFirst;
			} else if (localFirst.information.getLastName().compareTo(
					info.getLastName()) >= 0) {
				return localFirst.previousRecord;
			}
		}
		return localFirst;
	}

	/**
	 * Function to print all records in default (lexicographic) order
	 */
	public void printAllRecords() {
		Record currentRecord = firstRecord;
		// Loop through till last record
		while (currentRecord != null) {
			System.out.println(currentRecord);
			currentRecord = currentRecord.nextRecord;
		}
	}
	
	/**
	 * Function to print records with GPA less than 2.85
	 */
	public void printRecordsWithProbation() {
		Record currentRecord = firstRecord;
		System.out.println("Red-ids of the students that are on probation are as follows: "
				+ "(Ordered from first to last)");
		while (currentRecord != null) {
			if (currentRecord.information.getGpa() < 2.85)
				System.out.println(String.format("%05d",
						currentRecord.information.getRedId()));
			currentRecord = currentRecord.nextRecord;
		}
	}
	
	/**
	 * Function to print records with GPA 4.0
	 */
	public void printRecordsWithFullScore() {
		Record currentRecord = lastRecord;
		System.out.println("Names of the students with GPA as 4.0 are as follows: "
				+ "(Ordered from last to first)");
		while (currentRecord != null) {
			if (currentRecord.information.getGpa() == 4.0)
				System.out.println(currentRecord.information.getFirstName()
						+ " " + currentRecord.information.getLastName());
			currentRecord = currentRecord.previousRecord;
		}
	}

	public int getSize() {
		return size;
	}

	/**
	 * Function to get record at particular position indicated by index (starts from 1)
	 * 
	 * @return record at given index position
	 */
	public Record getRecordByIndex(int index) {
		// Throw exception if index out of bounds
		Record recordToGet = firstRecord;
		try {
			if (index < 1 || index > (this.getSize()))
				throw new IndexOutOfRangeException(
						"Exception: Index provided is not valid.");
			for (int i = 1; i < index; i++) {
				recordToGet = recordToGet.nextRecord;
			}
			return recordToGet;
		} catch (IndexOutOfRangeException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
