
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

public class pnlUserInfoDisplay extends JPanel {

	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtContactNumber;
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderTextField txtAddress;
	private PlaceholderTextField txtPatronID;
	

	private JButton btnDisableUser;
	private JButton btnCancel;
	
	public pnlUserInfoDisplay() {
		setLayout(null);
		
		JLabel lblInfoUser = new JLabel("Patron Information");
		lblInfoUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUser.setOpaque(false);
		lblInfoUser.setForeground(new Color(23, 21, 77));
		lblInfoUser.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblInfoUser.setBorder(null);
		lblInfoUser.setBounds(31, 83, 528, 52);
		add(lblInfoUser);

		JPanel pnlUserDetails = new JPanel();
		pnlUserDetails.setLayout(null);
		pnlUserDetails.setBounds(31, 171, 528, 261);
		add(pnlUserDetails);
		
		JPanel pnlFirstName = new JPanel();
		pnlFirstName.setLayout(null);
		pnlFirstName.setBounds(0, 0, 528, 30);
		pnlUserDetails.add(pnlFirstName);
		
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
		pnlUserDetails.add(pnlLastName);
		
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
		
		JPanel pnlPatronID = new JPanel();
		pnlPatronID.setLayout(null);
		pnlPatronID.setBounds(0, 67, 528, 30);
		pnlUserDetails.add(pnlPatronID);
		
		JLabel lblPatronID = new JLabel("Patron ID:");
		lblPatronID.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPatronID.setBounds(0, 0, 117, 30);
		pnlPatronID.add(lblPatronID);
		
		txtPatronID = new PlaceholderTextField("");
		txtPatronID.setEnabled(false);
		txtPatronID.setEditable(false);
		txtPatronID.setOpaque(false);
		
		txtPatronID.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtPatronID.setColumns(10);
		txtPatronID.setBounds(128, 1, 400, 30);
		pnlPatronID.add(txtPatronID);
		
		
		JPanel pnlContactNumber = new JPanel();
		pnlContactNumber.setLayout(null);
		pnlContactNumber.setBounds(0, 100, 528, 30);
		pnlUserDetails.add(pnlContactNumber);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblContactNumber.setBounds(0, 0, 117, 30);
		pnlContactNumber.add(lblContactNumber);
		
		txtContactNumber = new PlaceholderTextField("");
		txtContactNumber.setEditable(false);
		txtContactNumber.setOpaque(false);
		txtContactNumber.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtContactNumber.setColumns(10);
		txtContactNumber.setBounds(128, 1, 400, 30);
		pnlContactNumber.add(txtContactNumber);
		
		JPanel pnlEmailAddress = new JPanel();
		pnlEmailAddress.setLayout(null);
		pnlEmailAddress.setBounds(0, 131, 528, 30);
		pnlUserDetails.add(pnlEmailAddress);
		
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
		pnlUserDetails.add(pnlAddress);		
		
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
		pnlUserDetails.add(btnCancel);
		btnCancel.setBorderPainted(false);
		btnCancel.setOpaque(true);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancel.setBackground(new Color(23, 22, 77));
		
		btnDisableUser = new JButton("Disable User");
		btnDisableUser.setBounds(0, 230, 250, 31);
		pnlUserDetails.add(btnDisableUser);
		btnDisableUser.setBorderPainted(false);
		btnDisableUser.setOpaque(true);
		btnDisableUser.setForeground(Color.WHITE);
		btnDisableUser.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnDisableUser.setBackground(new Color(23, 22, 77));


	}

    
}
