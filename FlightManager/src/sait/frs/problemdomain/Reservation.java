package sait.frs.problemdomain;

import sait.frs.exception.*;

/**
 * Class for creating "Reservation" objects
 * 
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */

public class Reservation {
	
	/**
	 * private attributes
	 */
	private boolean active; 		//An Active reservation
	private String citizenship; 	//Citizenship of reservation
	private String code; 			//Code of reservation
	private String flightCode; 		//Flight code of reservation
	private String name; 			//Name of reservation
	private String airline; 		// airline of reservation
	private double cost; 			//Cost of reservation
	

	/**
	 * The constructor for the reservation class
	 * @param active is the value for whether the flight is active or not
	 * @param citizenship is the citizenship of reservation
	 * @param code is the code of reservation
	 * @param flightCode is the flight code of reservation
	 * @param name is the name of reservation
	 * @param airline is the airline of reservation
	 * @param cost is the cost of reservation
	 */
	public Reservation(boolean active, String citizenship, String code, String flightCode, String name, String airline,
			double cost) {
		this.active = active;
		this.citizenship = citizenship;
		this.code = code;
		this.flightCode = flightCode;
		this.name = name;
		this.airline = airline;
		this.cost = cost;
	}
	
	/**
	 * @return boolean for whether the reservation is active or not
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * getter method of citizenship in Reservation class
	 * @return a value of citizenship attribute of Reservation object
	 */
	public String getCitizenship() {
		return citizenship;
	}
	/**
	 * getter method of code in Reservation class
	 * @return a value of code attribute of Reservation object
	 */
	public String getCode() {
		return code;
	}
	/**
	 * getter method of flightCode in Reservation class
	 * @return a value of flightCode attribute of Reservation object
	 */
	public String getFlightCode() {
		return flightCode;
	}
	/**
	 * getter method of name in Reservation class
	 * @return a value of name attribute of Reservation object
	 */
	public String getName() {
		return name;
	}
	/**
	 * getter method of airline in Reservation class
	 * @return a value of airline attribute of Reservation object
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * getter method of cost in Reservation class
	 * @return a value of cost attribute of Reservation object
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * setter method of active attribute in Reservation class
	 * @param active to set a value for active attribute of Reservation object
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * This method throws an exception when the user forgets to enter the citizenship.
	 * @param citizenship the citizenship to set
	 * @throws InvalidCitizenshipException 
	 */
	public void setCitizenship(String citizenship) throws InvalidCitizenshipException {
		if ( citizenship == "" ) {
			throw new InvalidCitizenshipException();
		}
		this.citizenship = citizenship;
	}
	/**
	 * This method throws an exception when the user forgets to enter the name.
	 * @param name the name to set
	 * @throws InvalidNameException 
	 */
	public void setName(String name) throws InvalidNameException {
		if ( name.equals("") ) {
			throw new InvalidNameException();
		} else this.name = name;
	}

	@Override
	public String toString() {
		return code;
	}
}
