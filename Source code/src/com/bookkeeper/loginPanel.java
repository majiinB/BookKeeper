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
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class loginPanel extends JPanel {
	
	private JLabel emailLabel;
	private JTextField textField;
	private JLabel passLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	public User newUser;
	private JLabel loginPaneLabel;
	
	public loginPanel() {
		setBackground(new Color(18, 57, 150));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(64, 70, 401, 207);
		add(panel);
		
			setLayout(null);
			panel.setLayout(null);
			
			emailLabel = new JLabel("Email:");
			emailLabel.setBounds(69, 71, 42, 14);
			panel.add(emailLabel);
			
			textField = new JTextField();
			textField.setBounds(121, 67, 228, 23);
			panel.add(textField);
			textField.setColumns(10);
			
			passLabel = new JLabel("Password:");
			passLabel.setBounds(46, 109, 65, 14);
			panel.add(passLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(121, 105, 228, 23);
			panel.add(passwordField);
			
			loginButton = new JButton("Login");
			loginButton.setFont(new Font("Verdana", Font.BOLD, 11));
			loginButton.setForeground(new Color(255, 255, 255));
			loginButton.setBorderPainted(false);
			loginButton.setBackground(new Color(18, 57, 150));
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
			loginButton.setBounds(46, 152, 82, 29);
			panel.add(loginButton);
			
			JButton signUpButton = new JButton("Signup");
			signUpButton.setFont(new Font("Verdana", Font.BOLD, 11));
			signUpButton.setForeground(new Color(255, 255, 255));
			signUpButton.setBackground(new Color(18, 57, 150));
			signUpButton.setBorderPainted(false);
			signUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			signUpButton.setBounds(161, 152, 82, 29);
			panel.add(signUpButton);
			
			JButton backButton = new JButton("Back");
			backButton.setFont(new Font("Verdana", Font.BOLD, 11));
			backButton.setForeground(new Color(255, 255, 255));
			backButton.setBackground(new Color(18, 57, 150));
			backButton.setBorderPainted(false);
			backButton.setBounds(267, 152, 82, 29);
			panel.add(backButton);
			
			loginPaneLabel = new JLabel("Log-in to your account");
			loginPaneLabel.setBackground(new Color(9, 3, 105));
			loginPaneLabel.setFont(new Font("Verdana", Font.BOLD, 15));
			loginPaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
			loginPaneLabel.setBounds(10, 11, 381, 34);
			panel.add(loginPaneLabel);
		
	}

	/**
	 * Create the panel.
	 */
	
	public User getUser() {
		return newUser;
	}
}
