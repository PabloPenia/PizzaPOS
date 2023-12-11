package com.pizzapos.ui.common;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
	private JFrame frame;
	
	public MainFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Hello World");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(800, 500);
		this.frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panel.setBackground(Color.red);
		frame.add(panel, BorderLayout.CENTER);
	}
	
	public void display() {
		this.frame.setVisible(true);
	}
}
