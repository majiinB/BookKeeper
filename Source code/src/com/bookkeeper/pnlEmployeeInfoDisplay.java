
package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class pnlEmployeeInfoDisplay extends JPanel {

	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtContactNumber;
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderTextField txtAddress;
	private PlaceholderTextField txtEmployeeID;
	

	private JButton btnRemoveEmployee;
	private JButton btnCancel;
	
	public pnlEmployeeInfoDisplay() {
		setLayout(null);
		
		JLabel lblInfoEmployee = new JLabel("Employee Information");
		lblInfoEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoEmployee.setOpaque(false);
		lblInfoEmployee.setForeground(new Color(23, 21, 77));
		lblInfoEmployee.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblInfoEmployee.setBorder(null);
		lblInfoEmployee.setBounds(31, 83, 528, 52);
		add(lblInfoEmployee);

		JPanel pnlEmployeeDetails = new JPanel();
		pnlEmployeeDetails.setLayout(null);
		pnlEmployeeDetails.setBounds(31, 171, 528, 261);
		add(pnlEmployeeDetails);
		
		JPanel pnlFirstName = new JPanel();
		pnlFirstName.setLayout(null);
		pnlFirstName.setBounds(0, 0, 528, 30);
		pnlEmployeeDetails.add(pnlFirstName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFirstName.setBounds(0, 0, 116, 30);
		pnlFirstName.add(lblFirstName);
		
		txtFirstName = new PlaceholderTextField("");
		txtFirstName.setEditable(false);
		txtFirstName.setOpaque(false);
		txtFirstName.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(128, 1, 400, 30);
		pnlFirstName.add(txtFirstName);
		
		JPanel pnlLastName = new JPanel();
		pnlLastName.setLayout(null);
		pnlLastName.setBounds(0, 34, 528, 30);
		pnlEmployeeDetails.add(pnlLastName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLastName.setBounds(0, 0, 116, 30);
		pnlLastName.add(lblLastName);
		
		txtLastName = new PlaceholderTextField("");
		txtLastName.setEditable(false);
		txtLastName.setOpaque(false);
		txtLastName.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtLastName.setColumns(10);
		txtLastName.setBounds(128, 1, 400, 30);
		pnlLastName.add(txtLastName);
		
		JPanel pnlEmployeeID = new JPanel();
		pnlEmployeeID.setLayout(null);
		pnlEmployeeID.setBounds(0, 67, 528, 30);
		pnlEmployeeDetails.add(pnlEmployeeID);
		
		JLabel lblPatronID = new JLabel("Employee ID:");
		lblPatronID.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPatronID.setBounds(0, 0, 117, 30);
		pnlEmployeeID.add(lblPatronID);
		
		txtEmployeeID = new PlaceholderTextField("");
		txtEmployeeID.setEnabled(false);
		txtEmployeeID.setEditable(false);
		txtEmployeeID.setOpaque(false);
		
		txtEmployeeID.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtEmployeeID.setColumns(10);
		txtEmployeeID.setBounds(128, 1, 400, 30);
		pnlEmployeeID.add(txtEmployeeID);
		
		
		JPanel pnlContactNumber = new JPanel();
		pnlContactNumber.setLayout(null);
		pnlContactNumber.setBounds(0, 100, 528, 30);
		pnlEmployeeDetails.add(pnlContactNumber);
		
		txtContactNumber = new PlaceholderTextField("");
		txtContactNumber.setEditable(false);
		txtContactNumber.setOpaque(false);
		txtContactNumber.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtContactNumber.setColumns(10);
		txtContactNumber.setBounds(128, 1, 400, 30);
		pnlContactNumber.add(txtContactNumber);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setBounds(0, 0, 117, 30);
		pnlContactNumber.add(lblContactNumber);
		lblContactNumber.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		JPanel pnlEmailAddress = new JPanel();
		pnlEmailAddress.setLayout(null);
		pnlEmailAddress.setBounds(0, 131, 528, 30);
		pnlEmployeeDetails.add(pnlEmailAddress);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEmailAddress.setBounds(0, 0, 117, 30);
		pnlEmailAddress.add(lblEmailAddress);
		
		txtEmailAddress = new PlaceholderTextField("");
		txtEmailAddress.setEditable(false);
		txtEmailAddress.setOpaque(false);
		txtEmailAddress.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(128, 1, 400, 30);
		pnlEmailAddress.add(txtEmailAddress);
		
		JPanel pnlAddress = new JPanel();
		pnlAddress.setLayout(null);
		pnlAddress.setBounds(0, 161, 528, 30);
		pnlEmployeeDetails.add(pnlAddress);		
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAddress.setBounds(0, 0, 117, 30);
		pnlAddress.add(lblAddress);
		
		txtAddress = new PlaceholderTextField("");
		txtAddress.setEditable(false);
		txtAddress.setOpaque(false);
		txtAddress.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtAddress.setColumns(10);
		txtAddress.setBounds(128, 1, 400, 30);
		pnlAddress.add(txtAddress);		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(278, 231, 250, 30);
		pnlEmployeeDetails.add(btnCancel);
		btnCancel.setBorderPainted(false);
		btnCancel.setOpaque(true);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancel.setBackground(new Color(23, 22, 77));
		
		btnRemoveEmployee = new JButton("Remove Employee");

		btnRemoveEmployee.setBounds(0, 230, 250, 31);
		pnlEmployeeDetails.add(btnRemoveEmployee);
		btnRemoveEmployee.setBorderPainted(false);
		btnRemoveEmployee.setOpaque(true);
		btnRemoveEmployee.setForeground(Color.WHITE);
		btnRemoveEmployee.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnRemoveEmployee.setBackground(new Color(23, 22, 77));


	}

    
}
