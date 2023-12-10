package modelsConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;
import database.connection.*;
public class UserConnection {
	
	private Connection connection;
	
	public UserConnection(Connection con) {
		this.connection = con;
	}
	
	
	
	public User isLoged(String Email,String Password) throws SQLException {
		
		User user = null;
		try {
		String sqlQ ="select * from user where email = ? and password = ?"; 
		PreparedStatement mystat = connection.prepareStatement(sqlQ);
		
		mystat.setString(1, Email);
		mystat.setString(2, Password);
		
		ResultSet result = mystat.executeQuery();
		
		// zero of 1 record
		
		while(result.next()) {
			user = new User();
			user.setId(result.getInt("id"));
			user.setEmail(result.getString("email"));
			user.setAddress(result.getString("address"));
			user.setUsername(result.getString("username"));
			
		} 
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
		
	}
	/*
	public static void main(String []args) throws ClassNotFoundException, SQLException {
		
		
		User user = new UserConnection(GetConnection.getConnection()).isLoged("mohamed@google.com");
		if(user!=null)
		System.out.println(user.getUsername());
		
	}
	*/
	


	
}
