package models;

import java.util.HashMap;

public class User {
	
	
	private int id;
	private String username , email , address,password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/*
	 public static void main(String[] args) {
		
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		mp.put(0, 5);
		
		System.out.println(mp.get(5));
		
		
		
	}
	
*/
}
