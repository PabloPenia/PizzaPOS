package com.pizzapos.ui;

import com.pizzapos.App;
import com.pizzapos.db.UserDAO;
import com.pizzapos.model.Session;
import com.pizzapos.model.User;
import com.pizzapos.ui.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;

	public LoginFrame() {
		setTitle("Iniciar sesión");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		usernameField = new JTextField();
		passwordField = new JPasswordField();
		JButton loginButton = new JButton("Ingresar");

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleLogin();
			}
		});

		// Agregar componentes a la ventana
		setLayout(new GridLayout(4, 2));
		add(new JLabel("Usuario: "));
		add(usernameField);
		add(new JLabel("Contraseña: "));
		add(passwordField);
		add(new JLabel());
		add(loginButton);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				handleWindowClosing();
			}
		});

		// layout
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void handleLogin() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		User authenticatedUser = UserDAO.authUser(username, password);

		if (authenticatedUser != null) {
			Session.setCurrentUser(authenticatedUser);
//			new MainFrame(authenticatedUser.isAdmin());
			dispose();
		} else {
			JOptionPane.showMessageDialog(LoginFrame.this, "Credenciales invalidas", "No se pudo iniciar sesión",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void handleWindowClosing() {
		App.getMainFrame().setVisible(true);
		dispose();
	}
}
