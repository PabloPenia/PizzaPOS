package com.pizzapos.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	private static final String DATABASE_URL = "jdbc:sqlite:data/pizzapos.db";
	
//    public static void getConnection() {
//        try {
//        	Connection connection = DriverManager.getConnection(DATABASE_URL);
//        	connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
    public static Connection connect() {
    	Connection con = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
    		con = DriverManager.getConnection(DATABASE_URL);
    		System.out.println("Conexion exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
		}
    	
    	return con;
    }
}
