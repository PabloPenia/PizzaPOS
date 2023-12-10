package com.pizzapos.model;

public class User extends AbstractEntity {
	private String username;
	private String hashedPassword;
	private boolean isAdmin;
	
	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.isAdmin = false;
	}
	
	public User(String username, String hashedPassword, boolean isAdmin) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.isAdmin = isAdmin;
	}
	
	public User(String username, String hashedPassword, boolean isAdmin, String id) {
		super(id);
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.isAdmin = isAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}	
}