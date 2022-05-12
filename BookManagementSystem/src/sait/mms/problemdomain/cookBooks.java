package sait.mms.problemdomain;


	public class cookBooks extends Book
	{
	//isbn ending with 2 or 3
	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;
	private String pub;
	private String diet; //diet is D,V,G,I or N

	public cookBooks(String isbn,String callNumber,int available,int total,String title,String pub, String diet)
	{
	this.isbn=isbn;
	this.callNumber=callNumber;
	this.available=available;
	this.total=total;
	this.title=title;
	this.pub=pub;
	this.diet=diet;

	}

	public String getIsbn()
	{
	return isbn;
	}
	public void setIsbn(String isbn)
	{
	this.isbn = isbn;
	}
	public String getCallNumber()
	{
	return callNumber;
	}
	public void setCallNumber(String callNumber)
	{
	this.callNumber = callNumber;
	}
	public int getAvailable()
	{
	return available;
	}
	public void setAvailable(int available)
	{
	this.available = available;
	}
	public int getTotal()
	{
	return total;
	}
	public void setTotal(int total)
	{
	this.total = total;
	}
	public String getTitle()
	{
	return title;
	}
	public void setTitle(String title)
	{
	this.title = title;
	}
	public String getPub()
	{
	return pub;
	}
	public void setPub(String pub)
	{
	this.pub = pub;
	}
	public String getDiet()
	{
	return diet;
	}
	public void setDiet(String diet)
	{
	this.diet = diet;
	}

	public String toString()
	{
	return String.format("%s\t%s\t%d\t%d\t%s\t%s\t%s", isbn, callNumber, available, total, title, pub, diet);
	}

	public String formatToFile()
	{
	return String.format("%s;%s;%d;%d;%s;%s;%s", isbn, callNumber, available, total, title, pub, diet);
	}
	}
