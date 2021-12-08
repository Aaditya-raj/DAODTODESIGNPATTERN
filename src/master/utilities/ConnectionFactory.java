package master.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectionFactory {
	Connection cn = null;
	
		public Connection getConn()
		{
			try
	   	 {
	   	 Class.forName("oracle.jdbc.driver.OracleDriver");//Resister and load the driver.
	   	 cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","iche","iche");//Establish the connection.
	   	 }
	   	 catch(ClassNotFoundException ce)
	   	 {
	   		 ce.printStackTrace();
	   	 }
	   	 catch(SQLException se)
	   	 {
	   		 se.printStackTrace();  
	   	 } 
			
			return cn; 
		}
}
