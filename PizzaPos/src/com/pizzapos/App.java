package com.pizzapos;
import com.pizzapos.ui.LoginFrame;
import javax.swing.*;

public class App {
	private static JFrame mainFrame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(App::createAndShowGUI);
	}
	
	private static void createAndShowGUI() {
		mainFrame = new JFrame("Pizza POS App");
		mainFrame.setSize(400, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton loginButton = new JButton("Iniciar Sesión");
		loginButton.addActionListener(e -> showLoginFrame());
		
		JPanel panel = new JPanel();
		panel.add(loginButton);
		
		mainFrame.getContentPane().add(panel);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	private static void showLoginFrame() {
		mainFrame.setVisible(false);
		new LoginFrame();
	}
	
	public static JFrame getMainFrame() {
		return mainFrame;
	}

}
