package com.pizzapos.ui.admin;

import javax.swing.*;
import java.awt.*;
import com.pizzapos.ui.common.MainFrame;

public class AdminMainFrame extends MainFrame {
	public AdminMainFrame() {
		super("Administracion");
	}
	
	@Override
    protected JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        JButton ordersButton = new JButton("Orders");
        JButton usersButton = new JButton("Users");
        JButton customersButton = new JButton("Customers");
        JButton combosButton = new JButton("Combos");

        mainPanel.add(ordersButton);
        mainPanel.add(usersButton);
        mainPanel.add(customersButton);
        mainPanel.add(combosButton);

        return mainPanel;
    }
}
