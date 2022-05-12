package sait.mms.problemdomain;

public class Movie {
	//Attributes
	private int duration, year;
	private String title;
	//Methods
	public Movie(int duration, String title, int year) {
		this.duration=duration;
		this.title=title;
		this.year=year;
	}
	//Get method for @duration
	public int getDuration() {
		return duration;
	}
	//set method for @duration
	public void setDuration(int duration) {
		this.duration = duration;
	}
	//Get method for @year
	public int getYear() {
		return year;
	}
	//Set method for @year
	public void setYear(int year) {
		this.year = year;
	}
	//Get method for @title
	public String getTitle() {
		return title;
	}
	//Set method for @title
	public void setTitle(String title) {
		this.title = title;
	}

	//Converting to following format
	public String toString() {
		return String.format("%-5d %16d \t\t%-10s", duration, year, title);
	}
	public String formatToFile() {
		return String.format("%d,%s,%d", duration, title, year);
	}
}
