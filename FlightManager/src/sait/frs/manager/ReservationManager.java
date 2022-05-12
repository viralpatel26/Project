package sait.frs .manager;

import sait.frs.exception.*;

import java.io.*;
import java.util.*;
import sait.frs.problemdomain.*;

/**
 * This is the manager class of all the reservations made by the users. It makes reservation by their code, the airline, and the name
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */

public class ReservationManager {
private ArrayList<Reservation> reservations;

/**
* This is the Constructor of the Reservation Manager class
* @param reservations arraylist is instantiated
* @throws IOException
*/
public ReservationManager() 
{
	reservations = new ArrayList<Reservation> ();
	populateFromBinary();
}

/**
 * @return the reservations
 */

public ArrayList<Reservation> getReservations() 
{
	return reservations;
}

/**
 * 
 * @param flight entered by the user
 * @param name entered by the user
 * @param citizenship entered by the user
 * @return the reservation object created. Includes the details about the reservation made.
 * 
 * @throws NullFlightException explained in the sait.frs.exception package
 * @throws InvalidNameException explained in the sait.frs.exception package
 * @throws InvalidCitizenshipException explained in the sait.frs.exception package
 * @throws NoMoreSeatsException explained in the sait.frs.exception package
 */

public Reservation makeReservation (Flight flight, String name, String citizenship) throws NullFlightException, InvalidNameException, InvalidCitizenshipException, NoMoreSeatsException 
{
	
	if ( flight == null ) 
	{
		throw new NullFlightException();
	}
	if ( name.equals("") ) 
	{
		throw new InvalidNameException();
	}
	if ( citizenship.equals("") ) 
	{
		throw new InvalidCitizenshipException();
	}
	if ( getAvailableSeats(flight) <= 0 ) 
	{
		throw new NoMoreSeatsException();
	}
	
	Reservation reservation = new Reservation(true, citizenship, generateResevationCode(flight), flight.getCode(), name, flight.getAirlineName(),
	flight.getCostPerSeat());
	reservations.add(reservation);
	return reservation;

}

/**
 * @param code of the airline
 * @param airline
 * @param name 
 * @return returns an arraylist of the reservations according to the specification mentioned in the arguments
 */

public ArrayList<Reservation> findReservations (String code, String airline, String name) 
{
	
	ArrayList<Reservation> newRes = new ArrayList<Reservation> ();

	for(int i = 0; i < reservations.size(); i++) 
	{
		String reservationCode = reservations.get(i).getCode();
		String airlineName = reservations.get(i).getAirline();
		String namePerson = reservations.get(i).getName();

		if(reservationCode.equalsIgnoreCase(code) || airlineName.equalsIgnoreCase(airline) || namePerson.equalsIgnoreCase(name)) 
		{
			newRes.add(reservations.get(i));
		}
	}


	return newRes;
}

/**
* Finds the related reservation based the reservation code entered in the arguments
* @param code reservation code
* @return reservation code
*/
public Reservation findReservationByCode (String code) 
{
	for(int i = 0; i < reservations.size(); i++) 
	{
		Reservation reserve = reservations.get(i);

		if(reserve.getCode().equals(code)) 
		{
			return reserve;
		}
	}

	return null;
}

/**
 * rewrites the random access file "reservations.dat"
 */

public void persist() 
{
	try 
	{
		RandomAccessFile raf = new RandomAccessFile ("res/reservations.bin", "rw");

		int i = 0;
		while (i < reservations.size()) {
			Reservation reserve = reservations.get(i);
			raf.writeBoolean(reserve.isActive());
			raf.writeUTF(reserve.getCitizenship());
			raf.writeUTF(reserve.getCode());
			raf.writeUTF(reserve.getFlightCode());
			raf.writeUTF(reserve.getName());
			raf.writeUTF(reserve.getAirline());
			raf.writeDouble(reserve.getCost());

			i++;
		}

		raf.close();
	}
	catch (IOException e) 
	{
		System.out.println(e.getMessage());
	}
}

/**
 * @param flight object
 * @return available seats
 */

private int getAvailableSeats (Flight flight) 
{
	return flight.getSeats();
}

/**
 * @param flight object
 * @return randomly generated reservation code
 */

private String generateResevationCode (Flight flight) 
{
	String code = "";
	int number = (new Random().nextInt(9000) + 1000);
	if(flight.isDometic()) 
	{
		code = "D" + number;
	}
	else 
	{
		code = "L" + number;
	}

	return code;
}

/**
 * populates the random access file
 */

private void populateFromBinary()
{
	try 
	{
		RandomAccessFile file = new RandomAccessFile ("res/reservations.bin", "rw");
		for(int i = 0; i < file.length(); i++) 
		{
			Reservation res = new Reservation(file.readBoolean(),
					file.readUTF(),
					file.readUTF(),
					file.readUTF(),
					file.readUTF(),
					file.readUTF(),
					file.readDouble());

			reservations.add(res);
		}

		file.close();
	} 
	
	catch (IOException e) 
	{
		System.out.println(e.getMessage());
	}
}


} 