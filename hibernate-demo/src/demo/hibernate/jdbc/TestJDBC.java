package demo.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String userID = "hbstudent";
		String password = "hbstudent";
		
		try {
			
			System.out.println("Connecting to database : "+jdbcUrl);
			
			Connection dbConnection = 
					DriverManager.getConnection(jdbcUrl, userID, password);
			
			System.out.println("Connection Successful !!");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		

	}

}
