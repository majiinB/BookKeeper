package com.bookkeeper;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class signUpPanel extends JPanel {
	private JTextField textField;
	private JTextField firstNameField;
	private JTextField emailField;
	private JTextField homeAddField;
	private JTextField contactNumField;
	private JTextField passField;
	private JTextField retypePassField;

	/**
	 * Create the panel.
	 */
	public signUpPanel() {
		setBackground(new Color(18, 57, 150));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(68, 11, 408, 289);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an Account");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 388, 40);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		PlaceholderTextField lastNameField = new PlaceholderTextField("Last name");
		lastNameField.setBounds(209, 62, 177, 20);
		panel.add(lastNameField);
		lastNameField.setColumns(10);
		
		PlaceholderTextField firstNameField = new PlaceholderTextField("First name");
		firstNameField.setColumns(10);
		firstNameField.setBounds(20, 62, 179, 20);
		panel.add(firstNameField);
		
		PlaceholderTextField emailField = new PlaceholderTextField("Email address");
		emailField.setBounds(20, 93, 366, 20);
		panel.add(emailField);
		emailField.setColumns(10);
		
		PlaceholderTextField homeAddField = new PlaceholderTextField("Home address");
		homeAddField.setColumns(10);
		homeAddField.setBounds(20, 124, 366, 20);
		panel.add(homeAddField);
		
		PlaceholderTextField contactNumField = new PlaceholderTextField("Contact number");
		contactNumField.setColumns(10);
		contactNumField.setBounds(20, 155, 366, 20);
		panel.add(contactNumField);
		
		PlaceholderTextField passField = new PlaceholderTextField("Password");
		passField.setColumns(10);
		passField.setBounds(20, 186, 366, 20);
		panel.add(passField);
		
		PlaceholderTextField retypePassField = new PlaceholderTextField("Re-type your password");
		retypePassField.setColumns(10);
		retypePassField.setBounds(20, 217, 366, 20);
		panel.add(retypePassField);
		
		JButton createAccField = new JButton("Create Account");
		createAccField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createAccField.setBorderPainted(false);
		createAccField.setFont(new Font("Verdana", Font.BOLD, 9));
		createAccField.setForeground(new Color(255, 255, 255));
		createAccField.setBackground(new Color(0, 0, 160));
		createAccField.setBounds(20, 248, 200, 23);
		panel.add(createAccField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Verdana", Font.BOLD, 9));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(0, 0, 160));
		btnClear.setBounds(230, 248, 73, 23);
		panel.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Verdana", Font.BOLD, 9));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(0, 0, 160));
		btnBack.setBounds(313, 248, 73, 23);
		panel.add(btnBack);

	}
}
