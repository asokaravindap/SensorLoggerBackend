package org.uts.service.trafficservice.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import org.uts.service.trafficservice.beans.PropertiesParams;

public class MySQLConnector {
	
	Connection connection = null;  
	 
	 public static MySQLConnector getInstance() {
	        return Holder.INSTANCE;
	    }
	
	 public void init(PropertiesParams propertiesObj) throws Exception{
		 
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL JDBC Driver not found");
				throw new ClassNotFoundException();
			}

			System.out.println("MySQL JDBC Driver Registered");
			connection = null;

			try {
				//connection = DriverManager.getConnection("jdbc:mysql://localhost/utstraffic","root", "uts");
				connection = DriverManager.getConnection(propertiesObj.getdbPath(), propertiesObj.getuserName(), propertiesObj.getpassword());
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				throw new SQLException();
			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
	 }
	 
	 public boolean isInitialized(){
		 if (connection != null) {
				System.out.println("Connection is initialized");
				return true;
			} else {
				System.out.println("Connection is not initialized");
				return false;
			}
	 }
	 
	 public Connection getConnection(){
		 return connection;
	 }
	 
	 private static class Holder{
		 private static final MySQLConnector INSTANCE = new MySQLConnector();
	 }
}
