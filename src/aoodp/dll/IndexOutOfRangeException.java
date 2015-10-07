package aoodp.dll;

/**
 * Assignment 1 - Doubly linked list implementation 
 * This class creates a customized exception IndexOutOfRangeException
 * @author dhirajpatil.
 * @created 01/29/2015.
 * 
 */
public class IndexOutOfRangeException extends Exception {
	//Parameterless Constructor
    public IndexOutOfRangeException() {}

    //Constructor with customized message
    public IndexOutOfRangeException(String message)
    {
       super(message);
    }
}
