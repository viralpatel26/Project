package sait.mms.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import sait.mms.problemdomain.Book;
import sait.mms.problemdomain.Movie;
import sait.mms.problemdomain.childrenBooks;
import sait.mms.problemdomain.cookBooks;
import sait.mms.problemdomain.paperBack;
import sait.mms.problemdomain.periodicalBooks;

public class BookManagementSystem {

	private static final String FILE_NAME = "res//books.txt";
	
	private ArrayList<Book> Books=new ArrayList <Book>();
	public Scanner in;
	
	
	public BookManagementSystem() throws IOException{ 
		//Books = new ArrayList<Book>();
		in = new Scanner(System.in);	
		loadBookList();

	}
	/*public void displayMenu()
	{
		int option = -1;
		while (option != 6)
		{
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1 Checkout Book");
			System.out.println("2 Find Books by Title");
			System.out.println("3 Display Books by Type");
			System.out.println("4 Produce Random Book List");
			System.out.println("5 Save & Exit");
			System.out.println("");
			System.out.print("Enter option: ");
			option = in.nextInt();
			in.hasNextLine();
			switch (option) {
			case 1:
				checkOutBook();
				break;
			case 2:
				//findBookTitle();
				break;
			case 3:
				//findBookType();
				break;
			case 4:
				//generateRandomBooks();
				break;
			case 5:
				//saveAndExit();
			default:
				System.out.println("Wrong number entered.");
					break;
			}
			System.out.println();
		}
	}

	public void checkOutBook() {
		System.out.print("Enter ISBN of book: ");
		String is=in.nextLine();
		Book temp;
		for (int a=0;a<Books.size();a++)
		{
		temp=Books.get(a);

		if(temp.getIsbn().equals(is))
		{
		if(temp.getAvailable()>0)
		{

		System.out.println("The book \""+temp.getTitle()+"\" has been checked out.");
		System.out.println("It can be located using call number: "+temp.getCallNumber());
		}
		else
		{
		System.out.println("Sorry! This book is currently unavailable.");
		}
		}
		}
	}
	
	public void findBookTitle() {
		System.out.print("Enter title to search for: ");
		String name = in.nextLine();
		Book temp;
		System.out.println("Matching books: ");
		for (int a=0;a<Books.size();a++)
		{
		temp=Books.get(a);

		if(temp.getTitle().toLowerCase().contains(name.toLowerCase()))
		{
		System.out.print("ISBN:\t\t");
		System.out.println(temp.getIsbn());

		System.out.print("Call Number:\t");
		System.out.println(temp.getCallNumber());

		System.out.print("Available:\t");
		System.out.println(temp.getAvailable());

		System.out.print("Total:\t\t");
		System.out.println(temp.getTotal());

		System.out.print("Title:\t\t");
		System.out.println(temp.getTitle());

		System.out.println();
		}

		}
	}*/
	
	private void findBookType() {
		Book temp;
		int option=0;
		System.out.print("#	Type");
		System.out.print("1 Children's Books");
		System.out.print("2 Cookbooks");
		System.out.print("3 Paperbacks");
		System.out.print("4 Periodicals");
		System.out.print("Enter type of book:");
		option = in.nextInt();
		in.hasNextLine();
		switch (option) {
		case 1:
			//checkOutBook();
			break;
		case 2:
			//findBookTitle();
			break;
		case 3:
			//findBookType();
			break;
		case 4:
			System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly):");
			String a = in.next();
			in.hasNextLine();
			switch (a) {
				case "D" :
					for(int i=0;i<Books.size();i++)
					{
						temp=Books.get(i);
						if(temp.getIsbn().endsWith("8")|| temp.getIsbn().endsWith("9")) {
							if(temp.getFrequency().contains("Daily"))
							{
								System.out.print(Books.i);
							}
						}
					}	
					
				break;
			}
			break;
		}
	}

	/*public void generateRandomBooks() {
		System.out.print("Enter number of Books:");
		int BookCount = in.nextInt();
		in.nextLine();
		System.out.println("Random book\n");
		Collections.shuffle(Books);
		for(int i=0;i < BookCount; i++) {
			Book a= Books.get(i);
			//System.out.print("isbn:");
			if(a.getIsbn().endsWith("0") ||a.getIsbn().endsWith("1")) {
				System.out.print("\nISBN:\t\t"+a.getIsbn());
				System.out.print("\nCall Number:\t"+a.getCallNumber());
				System.out.print("\nAvailable:\t"+a.getAvailable());
				System.out.print("\nTotal:\t\t"+a.getTotal());
				System.out.print("\nTitle:\t\t"+a.getTitle());
				System.out.print("\nAuthors:\t\t"+a.getAuthor());
				System.out.print("\nFormat:\t\t"+a.getFormat());
			}
			else if(a.getIsbn().endsWith("2") ||a.getIsbn().endsWith("3")) {
				System.out.print("\nISBN:\t\t"+a.getIsbn());
				System.out.print("\nCall Number:\t"+a.getCallNumber());
				System.out.print("\nAvailable:\t"+a.getAvailable());
				System.out.print("\nTotal:\t\t"+a.getTotal());
				System.out.print("\nTitle:\t\t"+a.getTitle());
				System.out.print("\nPublisher:\t"+a.getPub());
				System.out.print("\nDiet:\t\t"+a.getDiet());
			}
			else if(a.getIsbn().endsWith("4") ||a.getIsbn().endsWith("5") || a.getIsbn().endsWith("6") ||a.getIsbn().endsWith("7")) {
				System.out.print("\nISBN:\t\t"+a.getIsbn());
				System.out.print("\nCall Number:\t"+a.getCallNumber());
				System.out.print("\nAvailable:\t"+a.getAvailable());
				System.out.print("\nTotal:\t\t"+a.getTotal());
				System.out.print("\nTitle:\t\t"+a.getTitle());
				System.out.print("\nAuthors:\t"+a.getAuthor());
				System.out.print("\nYear:\t\t"+a.getYearOfRelease());
				System.out.print("\nGenre:\t\t"+a.getGenre());
			}
			else if(a.getIsbn().endsWith("8") ||a.getIsbn().endsWith("9")) {
				System.out.print("\nISBN:\t\t"+a.getIsbn());
				System.out.print("\nCall Number\t "+a.getCallNumber());
				System.out.print("\nAvailable:\t"+a.getAvailable());
				System.out.print("\nTotal:\t\t"+a.getTotal());
				System.out.print("\nTitle:\t\t"+a.getTitle());
				System.out.print("\nFrequency:\t "+a.getFrequency());
			}
			}
		
	}

	private void saveAndExit() {
	FileWriter fw = new FileWriter(FILE_NAME,false);
		PrintWriter output = new PrintWriter(fw);
		for (Book tmpBook: Books) {
			output.println(tmpBook.formatToFile());
		}
		output.close();
		System.out.print("Saving books...");
	}*/
	public void loadBookList() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
		String nextLineForBook;
		
		while((nextLineForBook = reader.readLine()) != null) {
			String[] currentBookInList = nextLineForBook.split(";");
			
			if(currentBookInList[0].endsWith("0") || currentBookInList[0].endsWith("1")) {
				Books.add(new childrenBooks(currentBookInList[0], currentBookInList[1],
										Integer.parseInt(currentBookInList[2]), Integer.parseInt(currentBookInList[3]), 
										currentBookInList[4], currentBookInList[5], currentBookInList[6]));
			}
			else if (currentBookInList[0].endsWith("2") || currentBookInList[0].endsWith("3"))
			{
				Books.add(new cookBooks(currentBookInList[0], currentBookInList[1],
						Integer.parseInt(currentBookInList[2]), Integer.parseInt(currentBookInList[3]), 
						currentBookInList[4], currentBookInList[5], currentBookInList[6]));
			}
			else if (currentBookInList[0].endsWith("4") || currentBookInList[0].endsWith("5") || currentBookInList[0].endsWith("6") || currentBookInList[0].endsWith("7"))
			{
				Books.add(new paperBack(currentBookInList[0], currentBookInList[1],
						Integer.parseInt(currentBookInList[2]), Integer.parseInt(currentBookInList[3]), 
						currentBookInList[4], currentBookInList[5], currentBookInList[6],currentBookInList[6]));
			}
			
			else if (currentBookInList[0].endsWith("8") || currentBookInList[0].endsWith("9"))
			{
				Books.add(new periodicalBooks(currentBookInList[0], currentBookInList[1],
						Integer.parseInt(currentBookInList[2]), Integer.parseInt(currentBookInList[3]), 
						currentBookInList[4], currentBookInList[5]));
			}
		}	
	}

	
}
	

