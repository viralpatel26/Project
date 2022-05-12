package application;

import java.sql.*;
import drivers.*;


public class connectTest {

	public static void main(String[] args) {
		DatabaseDriver driver = new MariaDBDriver();
		
		try {
			driver.connect();
			
			System.out.println("Connected!");
			
			ResultSet rs = driver.get("SELECT 'Hello from the other side!'");
			
			boolean hasRow = rs.next();
			
			if (hasRow) {
				String column1 = rs.getString(1);
				System.out.println(column1);
			} else {
				System.out.println("Ooops! No rows were found.");
			}
			
			driver.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
