package sait.frs.application;

import java.io.*;

import sait.frs.gui.MainWindow;
import sait.frs.manager.*;

/**
 * This is the driver of the program which needs to be run .The program has been written for a Flight Reservation System. 
 * 
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */

public class AppDriver {
	
	/**
	 * This is the program which needs to be run to start the application.
	 * @param args arguments of the main method passed as a String.
	 */
	
	public static void main(String[] args) throws IOException {
		MainWindow startMainWindow = new MainWindow();
		startMainWindow.display();
	}
}
