package sait.frs.exception;

/**
 * NullFlightException throws an exception when the user forgets to enter the flight.
 * @author Khushi Sunil Bhatt, Viral Patel 
 * @version July 9, 2020
 */

public class NullFlightException extends Exception {
	public NullFlightException() {
		super("Flight is missing");
	}
}