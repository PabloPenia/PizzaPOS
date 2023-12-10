package com.pizzapos.manager;

import com.pizzapos.db.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

public class POSManager {

	public static void main(String[] args) {
		// Example: Insert a new customer into the database
//		insert("dfgdf", "Rosa Meltrozo", "gilazo", "8734658", new Date().toString(), "Admin");
		// readARow();
		// readAllData();
		// update();
		// deleteRow();
		countRows();
	}

	private static void insert(String customerId, String name, String address, String tel, String updated,
			String updatedBy) {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO Customers (customerId, name, address, tel, updated, updatedBy) VALUES (?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, tel);
			ps.setString(5, updated);
			ps.setString(6, updatedBy);
			ps.execute();
			System.out.println("COnsulta realizada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readAllData() {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM customers";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("Clientes");
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");

				System.out.println("Nombre: " + name);
				System.out.println("Direccion: " + address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readARow() {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT name FROM customers where address = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "Whatever");
			rs = ps.executeQuery();
			System.out.println("Cliente");
			String name = rs.getString(1);

			System.out.println("Nombre: " + name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void update() {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;

		try {
			String sql = "UPDATE customers set name = ? where address = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "Me pica el culo");
			ps.setString(2, "Whatever");
			ps.execute();
			System.out.println("Datos actualizados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteRow() {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;

		try {
			String sql = "DELETE  FROM customers where address = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "Whatever");
			ps.execute();
			System.out.println("Datos eliminados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void countRows() {
		Connection connection = DbManager.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT count(name) FROM customers";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			int registersNum = rs.getInt(1);
			System.out.println("Clientes: " + registersNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
