package sait.mms.problemdomain;

public class Movie {
	private int duration;
	private String title;
	private String year;
	
	public Movie(int duration,String title, String year) {
		this.duration = duration;
		this.title = title;
		this.year = year;
		toString();
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration1(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}
	public void setDuration(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String toString() {
		return String.format("%-5d %16d \t\t%-10s", duration, year, title);
	}
}