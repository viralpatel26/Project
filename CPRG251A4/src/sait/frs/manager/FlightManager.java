package sait.frs.manager;

import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;
import sait.frs.exception.*;
import sait.frs.problemdomain.*;
/**
 * This class is responsible for managing flights, reservations, and airports.
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 26, 2020
 */

public final class FlightManager{
	
	private ArrayList<String> airports;
	
	private ArrayList<Flight> flight;
	
	/**
	 * Used to search for reservations on any day of the week.
	 */
	public final String WEEKDAY_ANY = "Any";
	
	/**
	 * Used to search for reservations on Monday.
	 */
	public final String WEEKDAY_MONDAY = "Monday";
	
	/**
	 * Used to search for reservations on Tuesday.
	 */
	public final String WEEKDAY_TUESDAY = "Tuesday";
	
	/**
	 * Used to search for reservations on Wednesday.
	 */
	public final String WEEKDAY_WEDNESDAY = "Wednesday";
	
	/**
	 * Used to search for reservations on Thursday.
	 */
	public final String WEEKDAY_THURSDAY = "Thursday";
	
	/**
	 * Used to search for reservations on Friday.
	 */
	public final String WEEKDAY_FRIDAY = "Friday";
	
	/**
	 * Used to search for reservations on Saturday.
	 */
	public final String WEEKDAY_SATURDAY = "Saturday";
	
	/**
	 * The location of the flights text database file.
	 */
	public final String WEEKDAY_SUNDAY = "Sunday";
	
	/**
	 * Default constructor for FlightManager.
	 * @throws FileNotFoundException 
	 */
	public FlightManager() throws FileNotFoundException {
		this.airports = new ArrayList<String>();
		this.flight = new ArrayList<Flight>();
		this.populateAirports();
		this.populateFlights();
		
	}
	

	/**
	 * Gets all of the airports.
	 * @return ArrayList of airports.
	 */
	public ArrayList<String> getAirports(){
		return airports;
		
	}
	
	/**
	 * Gets all of the flights.
	 * @return ArrayList of Flight objects.
	 */
	public ArrayList<Flight> getFlights() {
		return flight;
		
	}
	
	public String findAirportByCode(String code) {
		return code;
		
	}
	
	/**
	 * Finds a flight using code.
	 * @param code - Flight code
	 * @return Flight object or null if code is not found.
	 */
	public String findFlightByCode(String code) {
	
		return null;
		
	}
	

	
	/**
	 * Finds flights going between airports on a specified weekday.
	 * @param from - From airport
	 * @param to - To airport
	 * @param weekday - Day of week (one of WEEKDAY_* constants). Use WEEKDAY_ANY for any day of the week.
	 * @return Any found Flight objects.
	 */
	public ArrayList<Flight> findFlights(String from, 
			String to,
            String weekday) {
				return flight;
		
	}
	

	/**
	 * 
	 */
	private void populateFlights() throws FileNotFoundException {
		Scanner inFile = new Scanner("res//flights.csv");
		String line = "";
		String[] columns;
		
		while(inFile.hasNext()) {
			line = inFile.nextLine();
			columns = line.split(",");
			
			
			this.flight.add(new Flight(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5], Integer.parseInt(columns[6]), Double.parseDouble(columns[7])));
		}
		
		inFile.close();
		
		
	}

	/**
	 * 
	 */
	private void populateAirports() throws FileNotFoundException{
		Scanner inFile = new Scanner("res//airports.csv");
		String line = "";
		String[] columns;
		
		while(inFile.hasNext()) {
			line = inFile.nextLine();
			columns = line.split(",");
			
			this.airports.add(columns[0]);

			
		}	
		
		inFile.close();
	}
	
}
