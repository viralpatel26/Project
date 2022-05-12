/**
 * Movie management system
 * This program add movies duration,year and title.It also shows movies released in selected year and also randmonly generate movie list.
 * Date written- 22,May,2020
 * @author 	ViralPatel  
 */


package sait.mms.application;

import java.io.IOException;

import sait.mms.managers.MovieManagementSystem;

public class AppDriver {
	//Main method MovieManagementSystem
	public static void main(String[] args) throws IOException {
		// Creating an object of class 
		MovieManagementSystem m =new MovieManagementSystem();
		m.displayMenu();
	}
}
