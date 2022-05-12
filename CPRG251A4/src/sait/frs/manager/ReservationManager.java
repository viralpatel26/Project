package sait.frs.manager;

import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;
import sait.frs.exception.*;
import sait.frs.problemdomain.*;



/**
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 26, 2020
 *
 */
public class ReservationManager {

	
	private ArrayList<Reservation> reservations;
	
	
	/**
	 * Default constructor for ReservationManager.
	 * @throws FileNotFoundException 
	 */
	public ReservationManager() throws FileNotFoundException {
		reservations = new ArrayList<Reservation>();
		populateFromBinary();
	}


	/**
	 * Gets all the reservations.
	 * @return ArrayList of Reservation objects.
	 */
	public ArrayList<Reservation> getReservations(){
		return reservations;
		
	}
	
	/**
	 * @param flight - Flight to book reservation for.
	 * @param name - Name of person (cannot be null or empty).
	 * @param citizenship - Citizenship of person (cannot be null or empty).
	 * @return Created reservation instance.
	 * @throws NullFlightException - Thrown if flight is null.
	 * @throws NoMoreSeatsException - Thrown if flight is booked up.
	 * @throws InvalidNameException - Thrown if name is null or empty.
	 * @throws InvalidCitizenshipException - Thrown if citizenship is null or empty.
	 */
	public Reservation makeReservation(Flight flight,
            String name,
            String citizenship)
     throws NullFlightException,
            NoMoreSeatsException,
            InvalidNameException,
            InvalidCitizenshipException {
		if (flight == null) {
			throw new NullFlightException();
		} 
		else if (name.equals("")) {
			throw new InvalidNameException();
		}
		else if (citizenship.equals("")) {
			throw new InvalidCitizenshipException();
		}
		else if (getAvailableSeats(flight) == 0) {
			throw new NoMoreSeatsException();
		} 
		else {
			Reservation reserve = new Reservation(
					generateReservationCode(flight), 
					flight.getCode(), 
					flight.getAirline(), 
					name, 
					citizenship, 
					flight.getCostPerSeat(), 
					true);
			
			reservations.add(reserve);
		
			return reserve;
		} 
		
	}

	
	/**
	 * Finds reservations containing either reservation code or airline.
	 * @param reservationCode - Reservation code to search for.
	 * @param airline - Airline to search for.
	 * @param name - Travelers name to search for.
	 * @return Any matching Reservation objects.
	 */
	public ArrayList<Reservation> findReservations(String reservationCode,
            String airline,
            String name) {
				return reservations;
		
	}
	
	
	/**
	 * Finds reservation with the exact reservation code.
	 * @param code - Reservation code.
	 * @return Reservation object or null if none found.
	 */
	public Reservation findReservationByCode(String code) {
		for (Reservation r : this.reservations) {
			if (r.getCode().equals(code)) {
				return r;
			}
		}
		
		return null;
		
	}
	
	/**
	 * 
	 */
	public void persist() {
		
	}
	
	/**
	 * Gets the number of available seats for a flight.
	 * @param flight - Flight instance.
	 * @return Number of available seats.
	 */
	private int getAvailableSeats(Flight flight) {
		return flight.getSeats();
		
	}
	
	/**
	 * @param flight
	 * @return
	 */
	private String generateReservationCode(Flight flight) {
		return flight.getCode();
	}
	
	
	/**
	 * 
	 */
	private void populateFromBinary() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
}
