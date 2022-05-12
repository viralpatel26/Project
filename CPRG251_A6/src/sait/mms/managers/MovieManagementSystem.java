package sait.mms.managers;
import java.lang.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import sait.mms.drivers.MariaDBDriver;

import java.io.*;
public class MovieManagementSystem {
	
	public Scanner in = new Scanner(System.in);
	private Connection connection = null;
	MariaDBDriver mdbd = new MariaDBDriver();
	
	public MovieManagementSystem() throws SQLException {
		mdbd.connect();
	}
	
	public void displayMenu() throws IOException, SQLException {
		int option = 1;
		while (option > 0)
		{
			mdbd.connect();
			System.out.println("Movie Management system");
			System.out.println("1 Add New Movie and Save");
			System.out.println("2 Generate List of Movies Released in a Year");
			System.out.println("3 Generate List of Random Movies");
			System.out.println("4 Delete movie by ID");
			System.out.println("5 Exit");
			System.out.println("");
			System.out.print("Enter an option: ");
			option = in.nextInt();
			//in.hasNextLine();
			// Using switch to select option from menu
			switch (option) {
			case 1:
				addMovie();
				mdbd.disconnect();
				break;
			case 2:
				generateMovieListInYear();
				mdbd.disconnect();
				break;
			case 3:
				generateRandomMovieList();
				mdbd.disconnect();
				break;
			case 4:
				deleteMovieById();
				mdbd.disconnect();
				break;
			case 5:
				System.out.println("Exiting");
				mdbd.disconnect();
				break;
			default:
				System.out.println("Wrong number entered.");
					break;
			}
			System.out.println();
		}
	}


	private void addMovie() throws SQLException {
		System.out.println("Add a movie");	
		System.out.print("Enter duration of movie:");
		int duration =in.nextInt();
		in.nextLine();
		System.out.print("Enter title of movie:");
		String title = in.nextLine();
		System.out.print("Enter year of movie released:");
		String year = in.nextLine();
		
		String query = "INSERT INTO movies(duration,title,year) VALUES ("+duration+",'"+title+"','"+year+"')";
		mdbd.update(query);
		System.out.println("Movie added sucessfully");
	}
	
	private void generateMovieListInYear() throws SQLException {
		System.out.println("Generate movie list by year");
		System.out.println("");
		System.out.print("Enter year: ");
		int year = in.nextInt();
		
		String query = "SELECT * FROM movies WHERE year = '" + year + "'";

		ResultSet results = mdbd.get(query);
		
		System.out.printf("%-5s %16s \t\t%-10s\n", "duration", "year", "title");
		
		while (results.next()) {
			int duration = results.getInt("duration");
			String title = results.getString("title");
			int year1 = results.getInt("year");
			
			System.out.printf("%-5d %16d \t\t%-10s\n", duration, year1 , title);
 		}
		System.out.println("");
	}
	
	private void generateRandomMovieList() throws SQLException {
		System.out.println("Retrive random movie list");
		System.out.println("");
		System.out.println("Enter number of movies to display:");
		int totalNumMovie = in.nextInt();
		String query = "SELECT * FROM movies ORDER BY RAND() LIMIT " + totalNumMovie + "";
		ResultSet results = mdbd.get(query);
		System.out.printf("%-5s %16s \t\t%-10s\n", "duration", "year", "title");
		
		while(results.next()) {
			int duration = results.getInt("duration");
			String title = results.getString("title");
			int year = results.getInt("year");
			
			System.out.printf("%-5d %16d \t\t%-10s\n", duration, year, title);
		}
		System.out.println("");
	}
	
	private void deleteMovieById() throws SQLException {
		System.out.println("Delete movie");
		System.out.println("");
		System.out.println("Enter ID");
		int id = in.nextInt();
		
		String query = "DELETE FROM movies where id = '"+id+"'";
		mdbd.update(query);
		System.out.println("Movie deleted sucessfully");
	}
	
}
