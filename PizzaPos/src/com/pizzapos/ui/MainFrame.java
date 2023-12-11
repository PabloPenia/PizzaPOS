package com.pizzapos.ui;

import javax.swing.*;

import com.pizzapos.model.Session;
import com.pizzapos.model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame  extends JFrame {
	private boolean isAdmin;
	private JPanel cardPanel;
	private CardLayout cardLayout;

	public MainFrame(boolean isAdmin) {
		this.isAdmin = isAdmin;
		setTitle("menu principal");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create panels for different sections
        JPanel mainPanel = createMainPanel();
        JPanel adminUsersPanel = createAdminUsersPanel();

        // Add panels to card panel
        cardPanel.add(mainPanel, "main");
        cardPanel.add(adminUsersPanel, "adminUsers");

        getContentPane().add(cardPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	private JPanel createMainPanel() {
        JPanel optionsPanel = new JPanel(new GridLayout(2, 2));

        JButton ordersButton = new JButton("Ordenes");
        JButton usersButton = new JButton("Usuarios");
        JButton customersButton = new JButton("Clientes");
        JButton combosButton = new JButton("Combos");

        optionsPanel.add(ordersButton);
        optionsPanel.add(usersButton);
        optionsPanel.add(customersButton);
        optionsPanel.add(combosButton);

        // Access current user if needed
        User currentUser = Session.getCurrentUser();

        if (currentUser != null) {
            System.out.println("Current User ID: " + currentUser.getId());
        }

        // Add action listeners for the buttons
        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminUsers");
            }
        });

        return optionsPanel;
    }

	private JPanel createAdminUsersPanel() {
        JPanel adminUsersPanel = new JPanel(new GridLayout(3, 1));

        JButton registerUserButton = new JButton("Registrar Usuario");
        JButton editUserButton = new JButton("Editar Usuario");
        JButton listUsersButton = new JButton("Listar Usuarios");

        adminUsersPanel.add(registerUserButton);
        adminUsersPanel.add(editUserButton);
        adminUsersPanel.add(listUsersButton);

        // Add action listeners for the buttons
        registerUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to show a dialog for registering a new user
                // You can use JOptionPane or create a custom dialog
            }
        });

        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to show a dialog for editing an existing user
                // You can use JOptionPane or create a custom dialog
            }
        });

        listUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to list users
            }
        });

        return adminUsersPanel;
    }
	
//	private void addAdminOptions(JPanel optionsPanel) {
//		JButton ordersButton = new JButton("Ordenes");
//		JButton usersButton = new JButton("Usuarios");
//		JButton customersButton = new JButton("Clientes");
//		JButton combosButton = new JButton("Combos");
//		
//		optionsPanel.add(ordersButton);
//		optionsPanel.add(usersButton);
//		optionsPanel.add(customersButton);
//		optionsPanel.add(combosButton);
//		
//		// access current user if needed
//		User currentUser = Session.getCurrentUser();
//		
//		if(currentUser != null) {
//			System.out.println("Current User ID: " + currentUser.getId());
//		}
//	}
//	
//	private void addUserOptions(JPanel optionsPanel) {
//		JButton placeOrderButton = new JButton("Ingresar Orden");
//		JButton addCustomerButton = new JButton("Ingresar Cliente");
//		JButton displayCombosButton = new JButton("Ver Combos");
//		
//		optionsPanel.add(placeOrderButton);
//		optionsPanel.add(addCustomerButton);
//		optionsPanel.add(displayCombosButton);
//	}

}
