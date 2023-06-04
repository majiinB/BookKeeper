package com.bookkeeper;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class loginPanel extends JPanel {
	private JPanel pnlLogIn;
	private JPanel pnlEmail;
	private JPanel pnlPassword;
	private JPanel pnlButtons;
	private JPanel pnlInput;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblLogIn;
	private PlaceholderTextField txtEmail;
	private PlaceholderPassword pssPassword;
	private JButton btnLogIn;
	private JButton btnBack;
	private User user;
	public Object newUser;
	
	public loginPanel() {
		setBackground(new Color(23, 21, 77));
		setLayout(new BorderLayout(0, 0));        
		setBorder(new EmptyBorder(130, 60, 130, 60));
		
		//create Panels	
		pnlEmail = new JPanel();
		pnlPassword = new JPanel();
		pnlButtons = new JPanel();		
	    pnlLogIn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    pnlInput= new JPanel();
	    
		lblLogIn = new JLabel("Log-in to your account.");
		lblLogIn.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(new Color(23, 22, 77));
		lblLogIn.setFont(new Font("Verdana", Font.BOLD, 50));
		
		//email Panel
		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 13));
			
		txtEmail = new PlaceholderTextField("Email Address");
		txtEmail.setColumns(25);
		
		//pass Panel
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 13));
			
		pssPassword = new PlaceholderPassword("");
		pssPassword.setColumns(20);

		//btns
		btnLogIn = new JButton("Log-In");
		btnLogIn.setOpaque(true);
		btnLogIn.setFont(new Font("Verdana", Font.BOLD, 11));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBorderPainted(false);
		btnLogIn.setBackground(new Color(26, 25, 87));
		btnLogIn.addActionListener(new ActionListener() {
			private int numTries = 1;
			public void actionPerformed(ActionEvent e) {
				MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(loginPanel.this);
				int remain = 3 - numTries;
				
					try {
						String email = "";
						email = txtEmail.getText();
						String trimed = email.trim();
						String table = "patron";
						String colemail = "patron_email";
						String colpass = "patron_password";
						String colStatus ="patron_status";
						char[] pass = pssPassword.getPassword();
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
							MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(btnLogIn);
							frame.dispose();

							// Create and show the DashboardFrame
			                DashboardFrame DashboardFrame = new DashboardFrame(0, user);
			                DashboardFrame.setVisible(true);
			                
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
			
			btnBack = new JButton("Back");
			btnBack.setOpaque(true);
			btnBack.setFont(new Font("Verdana", Font.BOLD, 11));
			btnBack.setForeground(new Color(255, 255, 255));
			btnBack.setBackground(new Color(26, 25, 87));
			btnBack.setBorderPainted(false);
			
			pnlPassword.setBorder(null);
			pnlButtons.setBorder(null);
			pnlEmail.setOpaque(false);
			pnlPassword.setOpaque(false);
			pnlButtons.setOpaque(false);
		    pnlInput.setOpaque(false);
		    pnlInput.setBorder(null);
		    pnlLogIn.setBorder(null);
			pnlLogIn.setBackground(new Color(255, 255, 255));
			pnlLogIn.setLayout(new GridLayout(3, 1, 15, 15));


			pnlEmail.add(lblEmail);
			pnlEmail.add(txtEmail);
			pnlPassword.add(lblPassword);
			pnlPassword.add(pssPassword);
			pnlButtons.add(btnLogIn);
			pnlButtons.add(btnBack);

			pnlInput.add(pnlEmail);
			pnlInput.add(pnlPassword);
			pnlLogIn.add(lblLogIn);
			pnlLogIn.add(pnlInput);
			pnlLogIn.add(pnlButtons);
			add(pnlLogIn);

	}

	/**
	 * Create the panel.
	 */
	
	public User getUser() {
		return user;	
	}
	
	public JButton getBackButton() {
		return btnBack;
	}
	/*
	public JButton getSignUpButton() {
		return btnSignUp;
		
	}*/
	public void clear() {
		txtEmail.setText("");
		pssPassword.setText("");
	}
}