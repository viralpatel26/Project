package sait.mms.application;

import java.io.FileNotFoundException;
import java.io.IOException;

import sait.mms.managers.BookManagementSystem;

public class AppDriver {
	public static void main(String[] args) throws IOException
	{
		BookManagementSystem b =new BookManagementSystem();
		//b.loadBookList();
		//b.generateRandomBooks();
		//b.checkOutBook();
		//b.findBookTitle();
		b.displayMenu();
	}
}
