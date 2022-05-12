package sait.frs.exception;

/**
 * InvalidCitizenshipException throws an exception when the user forgets to fill out the citizenship text field.
 * @author Khushi Sunil Bhatt, Viral Patel 
 * @version July 9, 2020
 */

public class InvalidCitizenshipException extends Exception
{
	public InvalidCitizenshipException() 
	{
		super("Citizenship is missing");
	}
}

