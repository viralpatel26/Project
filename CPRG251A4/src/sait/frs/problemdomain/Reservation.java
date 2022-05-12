package sait.frs.problemdomain;

import java.lang.Object;
import sait.frs.exception.*;
import sait.frs.problemdomain.Reservation;

/**
 * Represents a Reservation.
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 26, 2020
 */

public final class Reservation extends Object {
	
	private String code;
	private String flightCode;
	private String airline;
	private String name;
	private String citizenship;
	private double cost;
	private boolean	active;
	
	  
	/**
	 * User-defined constructor for Reservation.
	 * @param code
	 * @param flightCode
	 * @param name
	 * @param citizenship
	 * @param active
	 * @param cost
	 * @param airline
	 */
	public Reservation(String code,
		String flightCode,	
		String airline,
		String name,
		String citizenship,
		double cost,
		boolean active) {
		
		this.code = code;
		this.flightCode = flightCode;
		this.airline = airline;
		this.name = name;
		this.citizenship = citizenship;
		this.cost = cost;
		this.active = active;
		
	}
	
	/**
	 * @return
	 */
	public String getCode(){
		return code;
		
	}
	
	/**
	 * @return flightCode
	 */
	public String getFlightCode() {
		return flightCode;
		
	}
	
		
	/**
	 * @return airline
	 */
	public String getAirline () {
		return airline;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
		
	}
		
	/**
	 * @return citizenship
	 */
	public String getCitizenship(){
		return citizenship;
		
	}

	
	/**
	 * @return cost
	 */
	public double getCost() {
		return cost;
		
	}
	
		/**
	 * @return
	 */
	public boolean isActive() {
		return active;
		
	}
	
	/**
	 * @param name
	 * @throws InvalidNameException
	 */
	public void setName(String name) throws InvalidNameException{
		if (name.contentEquals("")) {
			throw new InvalidNameException();
		}
		else this.name = name;
	}
	
	/**
	 * @param citizenship
	 * @throws InvalidCitizenshipException
	 */
	public void setCitizenship(String citizenship) throws InvalidCitizenshipException {
		if (citizenship.equals("")) {
			throw new InvalidCitizenshipException();
		}
		else this.citizenship = citizenship;
	}
	
	/**
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
		
	public String toString(){
		return code;
		
	}



}