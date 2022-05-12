package sait.frs.problemdomain;

/**
 * FLight class to create Flight objects
 * 
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */

public class Flight {
	
	/**
	 * private variables required to store flight data
	 */
	private String airlineName; 	//Name of flight
	private String code; 			//Code of flight
	private double costPerSeat; 	//Seat cost of flight
	private String from; 			//origin of flight
	private int seats; 				//Seat of flight
	private String time; 			//Time of flight
	private String to; 				//Destination of flight
	private String weekday; 		//Days of flight
	
	
	/**
	 * The constructor for the flight class
	 * @param code is the code of the flight
	 * @param costPerSeat is the seat cost of the flight
	 * @param from is the origin of the flight
 	 * @param seats is the seats of the flight
	 * @param time the time of the flight
	 * @param to the destination of the flight
	 * @param weekday the days of the flight
	 */
	public Flight(String code, double costPerSeat, String from, int seats, String time, String to,
			String weekday) {
		this.code = code;
		this.costPerSeat = costPerSeat;
		this.from = from;
		this.seats = seats;
		this.time = time;
		this.to = to;
		this.weekday = weekday;
		parseCode(code);
	}
	/**
	 * getter method of airlineName in flight class
	 * @return airlineName attribute of  flight object
	 */
	public String getAirlineName() {
		return airlineName;
	}
	/**
	 * getter method of code in flight class
	 * @return code attribute of flight object
	 */
	public String getCode() {
		return code;
	}
	/**
	 * getter method of costPerSeat in flight class
	 * @return a value of costPerSeat attribute of a flight object
	 */
	public double getCostPerSeat() {
		return costPerSeat;
	}
	/**
	 * getter method of from in flight class
	 * @return a value of from attribute of flight object
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * getter method of seats in flight class
	 * @return a value of seats attribute of flight object
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * getter method of time in flight class
	 * @return a value of time attribute of flight object
	 */
	public String getTime() {
		return time;
	}
	/**
	 * getter of to in flight class
	 * @return a value of to attribute of flight object
	 */
	public String getTo() {
		return to;
	}
	/**
	 * getter method of weekday in flight class
	 * @return a value of weekday attribute of flight object
	 */
	public String getWeekday() {
		return weekday;
	}
	/**
	 * checks whether the airport is domestic or not
	 * @return true if the airport is domestic, false if not
	 */
	public boolean isDometic() {
		if ( this.from.charAt(0) == 'Y' && this.to.charAt(0) == 'Y' ) return true;
		else return false;
	}
	
	/**
	 * This method assigns airline name according to  its code
	 */
	private void parseCode(String code) {
		if ( code == "OA" ) this.airlineName = "Otto Airlines";
		else if ( code == "CA" ) this.airlineName = "Conned Air";
		else if ( code == "TB") this.airlineName = "Try a Bus Airways";
		else this.airlineName = "Vertical Airways";
	}

	@Override
	public String toString() {
		return code + ", From: " + from + ", To: "+ to + ", Day: " + weekday + ", Cost: " + costPerSeat;
	}
}
