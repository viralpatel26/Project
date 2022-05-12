package sait.frs.exception;

import java.lang.*;

/**
 * This exception is thrown when citizenship is missing.
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 26, 2020
 */
public class NoMoreSeatsException extends Exception {
	

	/**
	 * 
	 */
	public NoMoreSeatsException() {
		super("Error. No vacancy in this flight");
	}
	
}