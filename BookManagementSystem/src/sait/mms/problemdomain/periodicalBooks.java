package sait.mms.problemdomain;

public class periodicalBooks extends Book
{
private String isbn; //ends in 8 or 9
private String callNumber;
private int available;
private int total;
private String title;
private String frequency;//D,W,M,B or Q

public periodicalBooks(String isbn,String callNumber,int available,int total,String title,String frequency)
{
this.isbn=isbn;
this.callNumber=callNumber;
this.available=available;
this.total=total;
this.title=title;
this.frequency=frequency;
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
* @return the frequency
*/
public String getFrequency()
{
return frequency;
}
/**
* @param frequency the frequency to set
*/
public void setFrequency(String frequency)
{
this.frequency = frequency;
}

public String toString()
{
return String.format("%s\t%s\t%d\t%d\t%s\t%s", isbn, callNumber, available, total, title, frequency);
}

public String formatToFile()
{
return String.format("%s;%s;%d;%d;%s;%s", isbn, callNumber, available, total, title, frequency);
}
}

