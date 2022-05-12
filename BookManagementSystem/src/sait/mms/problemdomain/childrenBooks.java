package sait.mms.problemdomain;


	public class childrenBooks extends Book
	{
	//books having isbn ending with 0 or 1
	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;
	private String author;
	private String format; //format is P, E, or C

		public childrenBooks(String isbn,String callNumber,int available,int total,String title,String author,String format)
	    {
	        this.isbn=isbn;
	        this.callNumber=callNumber;
	        this.available=available;
	        this.total=total;
	        this.title=title;
	        this.author=author;
	        this.format=format;
	       
	    }
		
		public String getAuthor()
		{
		return author;
		}

		public void setAuthor(String author)
		{
		this.author = author;
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



		public String getFormat()
		{
		return format;
		}



		public void setFormat(String format)
		{
		this.format = format;
		}



		public String getTitle()
		{
		return title;
		}



		public void setTitle(String title)
		{
		this.title = title;
		}



		public int getTotal()
		{
		return total;
		}



		public void setTotal(int total)
		{
		this.total = total;
		}



		public int getAvailable()
		{
		return available;
		}



		public void setAvailable(int available)
		{
		this.available = available;
		}

		public String toString()
		{
		return String.format("%s\t%s\t%d\t%d\t%s\t%s\t%s", isbn, callNumber, available, total, title, author, format);
		}

		public String formatToFile()
		{
		return String.format("%s;%s;%d;%d;%s;%s;%s", isbn, callNumber, available, total, title, author, format);
		}
		
}