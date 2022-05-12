package sait.frs.exception;

/**
 * NoMoreSeatsException throws an exception when there are no more seats left on the flight.
 * @author Khushi Sunil Bhatt, Viral Patel 
 * @version July 9, 2020
 */

public class NoMoreSeatsException extends Exception {
	public NoMoreSeatsException() {
		super("No more seats on this flight");
	}
}