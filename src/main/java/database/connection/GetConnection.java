package database.connection;

import java.sql.*;

public class GetConnection {
	
	
	public static Connection connect = null;


	
	
	public static Connection getConnection() throws SQLException , ClassNotFoundException{
		
		
		if(connect == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
						   
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","mysql");
			
			System.out.println("Got Connection");
		}
		

		return connect;
	}

	/*
	
	public static void main(String []args) throws SQLException, ClassNotFoundException {
		
		
		GetConnection ob = new GetConnection();
		
		connect = ob.getConnection();
		
		
		
		
		ResultSet res = connect.createStatement().executeQuery("select * from user");
		
		
		while(res.next()) {
			
			System.out.println(res.getString("username"));
			
		}
		
		
	}
	*/
	
	
}
