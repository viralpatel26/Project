package sait.frs.manager;

import java.util.*;
import java.io.*;

import sait.frs.problemdomain.*;

/**
 * This program find flight by the origin "from" airport and the destination "to" airport. It also takes into consideration 
 * the day of the week on which the flight is departing.
 * @author Khushi Sunil Bhatt, Viral Patel 
 * @version July 9, 2020
 */

public class FlightManager {

	public final String WEEKDAY_ANY = "Any";
	public final String WEEKDAY_SUNDAY = "Sunday";
	public final String WEEKDAY_MONDAY = "Monday";
	public final String WEEKDAY_TUESDAY = "Tuesday";
	public final String WEEKDAY_WEDNESDAY = "Wednesday";
	public final String WEEKDAY_THURSDAY = "Thursday";
	public final String WEEKDAY_FRIDAY = "Friday";
	public final String WEEKDAY_SATURDAY = "Saturday";
	private ArrayList<Flight> flights;
	private ArrayList<String> airports;
	
	/**
	 * This is the Constructor of the Flight Manager class
	 * @param flights instantiates the flights arraylist
	 * @param airports instantiates the airports arraylist
	 */
	public FlightManager() {
		this.airports = new ArrayList<String> ();
		this.populateAirports();
		
		this.flights = new ArrayList<Flight> ();
		this.populateFlights();
	}

	/**
	 * @return the flights
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	/**
	 * @return the airports
	 */
	public ArrayList<String> getAirports() {
		return airports;
	}
	
	/**
	 * @param code the unique code of the airport
	 * @return returns the airport according to its code
	 */

	public String findAirportByCode(String code) {
		String res = "";
		try {
			Scanner inputFile = new Scanner(new FileInputStream("res/airports.csv"), "UTF-8");
			String line = "";
			while (inputFile.hasNextLine()) {
				line = inputFile.nextLine();
				String columns[] = line.split(",");
				if ( columns[0].equals(code) ) {
					res = columns[1];
				}
			}
			inputFile.close();
		} catch ( FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param code the unique code of the flight
	 * @return returns the flight according to its code
	 */
	public Flight findFlightByCode(String code) {
		for ( Flight f : this.flights) {
			if ( f.getCode().equals(code) ) return f;
		}
		return null;
	}
	
	/**
	 * 
	 * @param from accepts input about where the user to leave FROM
	 * @param to accepts input about where the user wants to go TO
	 * @param weekday accepts the weekday which the user enters and is looking for
	 * @return returns the filtered result of flights found according to the specifications of the user
	 */
	
	public ArrayList<Flight> findFlights(String from, String to, String weekday) {
		ArrayList<Flight> foundFlights = new ArrayList<Flight> ();
		
		for(int i = 0; i < flights.size(); i++) {
			Flight getFlight = flights.get(i);
			
			if(getFlight.getFrom().equalsIgnoreCase(from) && getFlight.getTo().equalsIgnoreCase(to)) {
				if(weekday.equalsIgnoreCase(WEEKDAY_ANY) || getFlight.getWeekday().equals(weekday)) {
					foundFlights.add(getFlight);
				}
				
			}
		}
		
		return foundFlights;
	}
	
	/********************************************* Private Methods ************************************************************/
	
	/**
	 * This private method is used to load the input file of 'flights.csv'. It creates a new Flight object each time and stores it
	 *  in the flights arraylist.
	 */
	
	private void populateFlights() {
		try {
			Scanner data = new Scanner(new FileInputStream("res/flights.csv"), "UTF-8");
			String line = "";
		
			while (data.hasNextLine()) {
				line = data.nextLine();
				String columns[] = line.split(",");
				
				Flight flight = new Flight(columns[0], Double.parseDouble(columns[6]), columns[1], 
				Integer.parseInt(columns[5]), columns[4], columns[2], columns[3]);
				
				flights.add(flight);
				}
			data.close();
		}
		catch ( FileNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This private method is used to load the input file of 'airports.csv'.It adds data into the airports arraylist.
	 */
	
	private void populateAirports() {
		try {
			Scanner data = new Scanner(new FileInputStream("res/airports.csv"), "UTF-8");
			String line = "";
			while (data.hasNextLine()) {
				line = data.nextLine();
				String columns[] = line.split(",");
				this.airports.add(columns[0]);
			}
			data.close();
		}
		catch ( FileNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
}