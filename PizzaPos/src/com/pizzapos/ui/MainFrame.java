package com.pizzapos.ui;

import javax.swing.*;

import com.pizzapos.model.Session;
import com.pizzapos.model.User;

import java.awt.*;

public class MainFrame  extends JFrame {
	private boolean isAdmin;
	public MainFrame(boolean isAdmin) {
		this.isAdmin = isAdmin;
		setTitle("menu principal");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel optionsPanel = new JPanel(new GridLayout(2, 2));
		
		if(isAdmin) {
			addAdminOptions(optionsPanel);
		} else {
			addUserOptions(optionsPanel);
		}
		
		getContentPane().add(optionsPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void addAdminOptions(JPanel optionsPanel) {
		JButton ordersButton = new JButton("Ordenes");
		JButton usersButton = new JButton("Usuarios");
		JButton customersButton = new JButton("Clientes");
		JButton combosButton = new JButton("Combos");
		
		optionsPanel.add(ordersButton);
		optionsPanel.add(usersButton);
		optionsPanel.add(customersButton);
		optionsPanel.add(combosButton);
		
		// access current user if needed
		User currentUser = Session.getCurrentUser();
		
		if(currentUser != null) {
			System.out.println("Current User ID: " + currentUser.getId());
		}
	}
	
	private void addUserOptions(JPanel optionsPanel) {
		JButton placeOrderButton = new JButton("Ingresar Orden");
		JButton addCustomerButton = new JButton("Ingresar Cliente");
		JButton displayCombosButton = new JButton("Ver Combos");
		
		optionsPanel.add(placeOrderButton);
		optionsPanel.add(addCustomerButton);
		optionsPanel.add(displayCombosButton);
	}

}
