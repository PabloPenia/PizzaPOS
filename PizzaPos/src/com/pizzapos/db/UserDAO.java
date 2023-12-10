package com.pizzapos.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizzapos.model.User;

public class UserDAO {
	public static User authUser(String username, String password) {
		
		String query = "SELECT * FROM Users WHERE name = ? AND hashedPassword = ?";
		
		try (Connection connection = DbManager.connect();
				PreparedStatement ps = connection.prepareStatement(query)) {
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					String id = rs.getString("id");
					boolean isAdmin = rs.getBoolean("isAdmin");
					
					return new User(username, password, isAdmin, id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; // no se encuentra el usuario
	}
}
// e6c099d6-fa60-4b9b-9f9b-d99a16985b1d