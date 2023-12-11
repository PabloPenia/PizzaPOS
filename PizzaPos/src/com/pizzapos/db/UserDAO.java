package com.pizzapos.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizzapos.model.User;

public class UserDAO {
	public static boolean registerUser(User newUser) {
		String query = "INSERT INTO Users (id, name, hashedPassword, isAdmin, updatedAt, updatedBy) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = DbManager.connect(); PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, newUser.getId());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getHashedPassword());
			ps.setBoolean(4, newUser.isAdmin());
			ps.setString(5, newUser.getUpdatedAt());
			ps.setString(6, newUser.getUpdatedBy());

			int execRows = ps.executeUpdate();
			return execRows > 0; // Registration successful if rows were affected

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception
		}

		return false; // Registration failed

	}

	public static User authUser(String username, String password) {

		String query = "SELECT * FROM Users WHERE name = ? AND hashedPassword = ?";

		try (Connection connection = DbManager.connect(); PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, username);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
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