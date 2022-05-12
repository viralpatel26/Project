package sait.mms.problemdomain;

	public class paperBack extends Book
	{
	private String isbn;//ends between 4 to 7
	private String callNumber;
	private int available;
	private int total;
	private String title;
	private String author;
	private String yearOfRelease;
	private String genre;//A,D,E,C,F or S

	public paperBack(String isbn,String callNumber,int available,int total,String title,String author, String yearOfRelease, String genre)
	{
	this.isbn=isbn;
	this.callNumber=callNumber;
	this.available=available;
	this.total=total;
	this.title=title;
	this.author=author;
	this.yearOfRelease=yearOfRelease;
	this.genre=genre;

	}

	/**
	* @return the isbn
	*/
	public String getIsbn()
	{
	return isbn;
	}
	/**
	* @param isbn the isbn to set
	*/
	public void setIsbn(String isbn)
	{
	this.isbn = isbn;
	}
	/**
	* @return the callNumber
	*/
	public String getCallNumber()
	{
	return callNumber;
	}
	/**
	* @param callNumber the callNumber to set
	*/
	public void setCallNumber(String callNumber)
	{
	this.callNumber = callNumber;
	}
	/**
	* @return the available
	*/
	public int getAvailable()
	{
	return available;
	}
	/**
	* @param available the available to set
	*/
	public void setAvailable(int available)
	{
	this.available = available;
	}
	/**
	* @return the total
	*/
	public int getTotal()
	{
	return total;
	}
	/**
	* @param total the total to set
	*/
	public void setTotal(int total)
	{
	this.total = total;
	}
	/**
	* @return the title
	*/
	public String getTitle()
	{
	return title;
	}
	/**
	* @param title the title to set
	*/
	public void setTitle(String title)
	{
	this.title = title;
	}
	/**
	* @return the author
	*/
	public String getAuthor()
	{
	return author;
	}
	/**
	* @param author the author to set
	*/
	public void setAuthor(String author)
	{
	this.author = author;
	}
	/**
	* @return the yearOfRelease
	*/
	public String getYearOfRelease()
	{
	return yearOfRelease;
	}
	/**
	* @param yearOfRelease the yearOfRelease to set
	*/
	public void setYearOfRelease(String yearOfRelease)
	{
	this.yearOfRelease = yearOfRelease;
	}
	/**
	* @return the genre
	*/
	public String getGenre()
	{
	return genre;
	}
	/**
	* @param genre the genre to set
	*/
	public void setGenre(String genre)
	{
	this.genre = genre;
	}

	public String toString()
	{
	return String.format("%s\t%s\t%d\t%d\t%s\t%s\t%s\t%s", isbn, callNumber, available, total, title, author, yearOfRelease, genre);
	}

	public String formatToFile()
	{
	return String.format("%s;%s;%d;%d;%s;%s;%d;%s", isbn, callNumber, available, total, title, author, yearOfRelease, genre);
	}
	}

