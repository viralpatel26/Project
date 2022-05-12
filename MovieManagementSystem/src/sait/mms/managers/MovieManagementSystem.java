package sait.mms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;


public class MovieManagementSystem {
	// Constant
	private static final String FILE_NAME = "res//movies.txt";
	//Attributes
	private ArrayList<Movie> movies;
	public Scanner in;
	public String y;

	//constructor
	public MovieManagementSystem() throws FileNotFoundException { 
				movies = new ArrayList<Movie>();
				in = new Scanner(System.in);	
				loadMovieList();
}
	//Methods
	// This method display menu for MovieManagementSystem.
	public void displayMenu() throws IOException {
		int option = -1;
		while (option > 0)
		{
			System.out.println("Movie Management system");
			System.out.println("1 Add New Movie and Save");
			System.out.println("2 Generate List of Movies Released in a Year");
			System.out.println("3 Generate List of Random Movies");
			System.out.println("4 Exit");
			System.out.println("");
			System.out.print("Enter an option: ");
			option = in.nextInt();
			//in.hasNextLine();
			// Using switch to select option from menu
			switch (option) {
			case 1:
				addMovie();
				break;
			case 2:
				generateMovieListInYear();
				break;
			case 3:
				generateRandomMovieList();
				break;
			case 4:
				break;
			default:
				System.out.println("Wrong number entered.");
					break;
			}
			System.out.println();
		}
	}
	//Adding movie name ,duration,year in file
	private void addMovie() throws IOException {
		int duration = 0;
		int year = 0;
		String title;
	//Checking @duration is greater than zero
		do {
			System.out.print("Enter duration:");
			duration = in.nextInt();
		} while(duration <= 0);
		
		in.nextLine();
	//Checking @year is greater than zero	
		do {
			System.out.print("Enter year:");
		    year = in.nextInt();
		} while (year <= 0);
		
		in.nextLine();
	//Checking @title is greater than zero
		do {
			System.out.print("Enter movie title:");
			title = in.nextLine();
		}while(title.isEmpty());
		
		
		Movie tempMovie =new Movie(duration,title,year);
		movies.add(tempMovie);
		FileWriter fw = new FileWriter(FILE_NAME,false);
		PrintWriter output = new PrintWriter(fw);
		for (Movie tmpMovie: movies) {
			output.println(tmpMovie.formatToFile());
		}
		output.close();
		System.out.print("Saving movies...");
		System.out.print("Added movie to the data file.");
		System.out.println();
	}
	//Display movies that released in entered year.
	private void generateMovieListInYear() {
		System.out.print("Enter in year:");
		int year= in.nextInt();
		in.nextLine();
		int durationForMovies = 0;
	 
		System.out.println("Movie List");
		System.out.printf("%s %13s %14s\n","Duration","Year","Title");
		for(int i=0; i < movies.size(); i++)
		{
			if(movies.get(i).getYear()== year)
			{
				System.out.println(movies.get(i).toString());
				durationForMovies += movies.get(i).getDuration();
			}
		}
		System.out.println("Total duration: " + durationForMovies);
	}
	//Generate random number of movies
	private void generateRandomMovieList() {
		System.out.print("Enter number of movies:");
		int movieCount = in.nextInt();
		in.nextLine();
		System.out.println("Movie List\n");
		System.out.printf("%s %13s %14s\n","Duration","Year","Title");
		Collections.shuffle(movies);
		
		int durationForMovies = 0;
		
		for(int i=0;i < movieCount; i++) {
			System.out.println(movies.get(i));
			durationForMovies += movies.get(i).getDuration();
		}
		System.out.println("Total duration: " + durationForMovies);
	}
	//Loading movies in @movies and converting to string
	private void loadMovieList() throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(FILE_NAME));
		String current;
		String[] splittedLine;
		Movie tempMovie;
		while(fileReader.hasNextLine()) {
			current = fileReader.nextLine();
			splittedLine = current.split(",");
			tempMovie = new Movie(Integer.parseInt(splittedLine[0]),splittedLine[1],Integer.parseInt(splittedLine[2]));
			movies.add(tempMovie);
		}
		fileReader.close();
		System.out.print("Loaded");
	}
	
}