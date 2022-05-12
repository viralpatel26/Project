package sait.frs.exception;

/**
 * InvalidNameException throws an exception when the user forgets to fill out the name text field.
 * @author Khushi Sunil Bhatt, Viral Patel 
 * @version July 9, 2020
 */

public class InvalidNameException extends Exception
{
	public InvalidNameException() {
		super("Name is missing");
	}
}
