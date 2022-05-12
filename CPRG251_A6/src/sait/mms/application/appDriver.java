package sait.mms.application;
import java.lang.*;
import java.io.IOException;
import java.sql.*;
import sait.mms.managers.*;

public class appDriver {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, NullPointerException{
		MovieManagementSystem mms = new MovieManagementSystem();
		mms.displayMenu();
	}
}
