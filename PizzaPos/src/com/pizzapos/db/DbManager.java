package com.pizzapos.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	private static final String DATABASE_URL = "jdbc:sqlite:data/pizzapos.db";
	
    public static Connection connect() throws SQLException {
    	return DriverManager.getConnection(DATABASE_URL);
    }
}
