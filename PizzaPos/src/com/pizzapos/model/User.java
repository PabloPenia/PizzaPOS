package com.pizzapos.model;

public class User extends AbstractEntity {
	private String username;
	private String hashedPassword;
	
	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
	}
	
	public static User register(String username, String hashedPassword) {
		return new User(username, hashedPassword);
	}
	
	public boolean login(String username, String password) {
		return true;
	}
}