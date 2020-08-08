package com.lti.dao.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	public static Connection connect() {
		try {
			Properties dbProps = new Properties();
			//dbProps.load(new FileReader("dev-db.properties"));
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			Class.forName(dbProps.getProperty("driverName"));
			
			return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"), dbProps.getProperty("pass"));
		}
		catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace(); //should throw exception
			return null; //very bad, should throw some user-defined exception
		}
	
	/* public static Connection connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL",
					"system", "Crypto123");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //should throw exception
			return null; //very bad, should throw some user-defined exception
		} */
		
	}
}
