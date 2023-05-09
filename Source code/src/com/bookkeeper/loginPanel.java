package com.bookkeeper;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPanel extends JPanel {
	private JLabel emailLabel;
	private JTextField textField;
	private JLabel passLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	public User newUser;

	/**
	 * Create the panel.
	 */
	public loginPanel() {
		setLayout(null);
		
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(95, 89, 36, 14);
		add(emailLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 86, 237, 20);
		add(textField);
		textField.setColumns(10);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(73, 155, 62, 14);
		add(passLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 152, 237, 20);
		add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			private int numTries = 1;
			public void actionPerformed(ActionEvent e) {
				Book_keeper_main_interface main = new Book_keeper_main_interface();
				int remain = 3 - numTries;
				
					try {
						String email = "";
						email = textField.getText();
						String table = "patron";
						String colemail = "patron_email";
						String colpass = "patron_password";
						char[] pass = passwordField.getPassword();
						String password = new String(pass);
						newUser = main.loginMethod(email, password, table, colemail, colpass);
						if (newUser == null && numTries<3) {
							// Show error message if login failed
							JOptionPane.showMessageDialog(loginPanel.this, "Invalid email or password" + "\nRemaining Attempts:" + remain, "Error", JOptionPane.ERROR_MESSAGE);
							numTries++;
							
						} else {
							if(numTries>=3) {
								JOptionPane.showMessageDialog(loginPanel.this, "Limit Reached! Program will now close", "Error", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							// Hide the login panel and show the main interface
							JOptionPane.showMessageDialog(loginPanel.this, "Welcome,\n" + newUser.toString() + " !", "\nSuccess", JOptionPane.INFORMATION_MESSAGE);
							//setVisible(false); nextTime na to wala pa next panel eh
							
							//Book_keeper_main_interface.showInterface(newUser);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		loginButton.setBounds(73, 220, 89, 23);
		add(loginButton);
		
		JButton signUpButton = new JButton("Signup");
		signUpButton.setBounds(193, 220, 89, 23);
		add(signUpButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(310, 220, 89, 23);
		add(backButton);
	}
	public User getUser() {
		return newUser;
	}
}
