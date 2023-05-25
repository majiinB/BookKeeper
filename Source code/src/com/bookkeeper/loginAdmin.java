package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class loginAdmin extends JPanel {

	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private Object newUser;
	private JLabel loginPaneLabel;
	private JButton backButton; 
	private Employee employee;

	public loginAdmin() {
		setBackground(new Color(18, 57, 150));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
        panel.setSize(545,300);
        panel.setBounds(190, 175, 401, 207);
		add(panel);
		
			setLayout(null);
			panel.setLayout(null);
			
			emailLabel = new JLabel("Email:");
			emailLabel.setBounds(69, 71, 42, 14);
			panel.add(emailLabel);
			
			emailField = new JTextField();
			emailField.setBounds(121, 67, 228, 23);
			panel.add(emailField);
			emailField.setColumns(10);
			
			passLabel = new JLabel("Password:");
			passLabel.setBounds(46, 109, 65, 14);
			panel.add(passLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(121, 105, 228, 23);
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
					MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(loginAdmin.this);
					int remain = 3 - numTries;
					
						try {
							String email = "";
							email = emailField.getText();
							String trimed = email.trim();
							String table = "admin";
							String colemail = "admin_email";
							String colpass = "admin_password";
							String colStatus ="admin_status";
							char[] pass = passwordField.getPassword();
							String password = new String(pass);
							String status = "active";
							newUser = main.loginMethod(trimed, password, table, colemail, colpass, colStatus, status);
							if (newUser == null && numTries<3) {
								// Show error message if login failed
								JOptionPane.showMessageDialog(loginAdmin.this, "Invalid email or password" + "\nRemaining Attempts:" + remain, "Error", JOptionPane.ERROR_MESSAGE);
								numTries++;
								
							} else {
								if(numTries>=3) {
									JOptionPane.showMessageDialog(loginAdmin.this, "Limit Reached! Program will now close", "Error", JOptionPane.ERROR_MESSAGE);
									System.exit(0);
								}
								employee = (Employee) newUser;
								// Hide the login panel and show the main interface
								JOptionPane.showMessageDialog(loginAdmin.this, "Sucessful Admin Login", "\nSuccess", JOptionPane.INFORMATION_MESSAGE);
								MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(loginButton);
								frame.dispose();
								
								// Create and show the DashboardFrame
								//Pass value 1 for the condition inside the dash board
								DashboardFrame DashboardFrame = new DashboardFrame(1);
				                DashboardFrame.setVisible(true);
								
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					
				}
			});
			loginButton.setBounds(46, 152, 154, 29);
			panel.add(loginButton);
			backButton = new JButton("Back");
			backButton.setOpaque(true);
			
			backButton.setFont(new Font("Verdana", Font.BOLD, 11));
			backButton.setForeground(new Color(255, 255, 255));
			backButton.setBackground(new Color(18, 57, 150));
			backButton.setBorderPainted(false);
			backButton.setBounds(210, 152, 139, 29);
			panel.add(backButton);
			
			loginPaneLabel = new JLabel("Admin Login");
			loginPaneLabel.setBackground(new Color(9, 3, 105));
			loginPaneLabel.setFont(new Font("Verdana", Font.BOLD, 15));
			loginPaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
			loginPaneLabel.setBounds(10, 11, 381, 34);
			panel.add(loginPaneLabel);
	}
	public JButton getBackButton() {
		return backButton;
	}

	public void clear() {
		emailField.setText("");
		passwordField.setText("");
	}
	public Employee getAdmin() {
		return employee;
	}
}
