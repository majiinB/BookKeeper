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
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTable;

public class loginPanel extends JPanel {
	
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	public Object newUser;
	private JLabel loginPaneLabel;
	private JButton backButton;
	private JButton signUpButton;
	private User user;
	
	public loginPanel() {
		setBackground(new Color(18, 57, 150));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(185, 182, 410, 207);
		add(panel);
		
			setLayout(null);
			panel.setLayout(null);
			
			emailLabel = new JLabel("Email:");
			emailLabel.setBounds(69, 71, 42, 14);
			panel.add(emailLabel);
			
			emailField = new JTextField();
			emailField.setBounds(121, 67, 244, 23);
			panel.add(emailField);
			emailField.setColumns(10);
			
			passLabel = new JLabel("Password:");
			passLabel.setBounds(46, 109, 65, 14);
			panel.add(passLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(121, 105, 244, 23);
			panel.add(passwordField);
			
			loginButton = new JButton("Log-In");
			loginButton.setOpaque(true);
			loginButton.setFont(new Font("Verdana", Font.BOLD, 11));
			loginButton.setForeground(new Color(255, 255, 255));
			loginButton.setBorderPainted(false);
			loginButton.setBackground(new Color(18, 57, 150));
			loginButton.addActionListener(new ActionListener() {
				private int numTries = 1;
				public void actionPerformed(ActionEvent e) {
					MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(loginPanel.this);
					int remain = 3 - numTries;
					
						try {
							String email = "";
							email = emailField.getText();
							String trimed = email.trim();
							String table = "patron";
							String colemail = "patron_email";
							String colpass = "patron_password";
							String colStatus ="patron_status";
							char[] pass = passwordField.getPassword();
							String password = new String(pass);
							String status = "active";
							newUser = main.loginMethod(trimed, password, table, colemail, colpass, colStatus, status);
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
								user = (User) newUser;
								JOptionPane.showMessageDialog(loginPanel.this, "Welcome,\n" + newUser.toString() + " !", "\nSuccess", JOptionPane.INFORMATION_MESSAGE);
								MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(loginButton);
								frame.dispose();

								// Create and show the DashboardFrame
				                DashboardFrame DashboardFrame = new DashboardFrame(0);
				                DashboardFrame.setVisible(true);
				                
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					
				}
			});
			loginButton.setBounds(46, 152, 100, 29);
			panel.add(loginButton);
			
			signUpButton = new JButton("Sign-Up");
			signUpButton.setOpaque(true);
			signUpButton.setFont(new Font("Verdana", Font.BOLD, 11));
			signUpButton.setForeground(new Color(255, 255, 255));
			signUpButton.setBackground(new Color(18, 57, 150));
			signUpButton.setBorderPainted(false);
			
			signUpButton.setBounds(158, 152, 116, 29);
			panel.add(signUpButton);
			
			backButton = new JButton("Back");
			backButton.setOpaque(true);
			
			backButton.setFont(new Font("Verdana", Font.BOLD, 11));
			backButton.setForeground(new Color(255, 255, 255));
			backButton.setBackground(new Color(18, 57, 150));
			backButton.setBorderPainted(false);
			backButton.setBounds(283, 152, 82, 29);
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
		return user;
	}
	public JButton getBackButton() {
		return backButton;
	}
	public JButton getSignUpButton() {
		return signUpButton;
		
	}
	public void clear() {
		emailField.setText("");
		passwordField.setText("");
	}

}