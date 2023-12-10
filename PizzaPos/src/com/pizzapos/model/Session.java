package com.pizzapos.model;

public class Session {
	private static User currentUser;
	
	public static void setCurrentUser(User user) {
		currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	public static void close() {
		currentUser = null;
	}
}
