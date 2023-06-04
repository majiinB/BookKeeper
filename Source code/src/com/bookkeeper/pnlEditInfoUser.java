
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

public class pnlEditInfoUser extends JPanel {

	private PlaceholderTextField txtFirstNameEdit;
	private PlaceholderTextField txtLastNameEdit;
	private PlaceholderTextField txtContactNumberEdit;
	private PlaceholderTextField txtEmailAddressEdit;
	private PlaceholderTextField txtAddressEdit;
	private PlaceholderTextField txtPatronID;
	private JButton btnPasswordEdit;
	private JButton btnCancelEdit;
	
	public pnlEditInfoUser() {
				setLayout(null);
		
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(31, 42, 138, 124);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		
		JLabel lblInfoUserEdit = new JLabel("Patron Information");
		lblInfoUserEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUserEdit.setOpaque(false);
		lblInfoUserEdit.setForeground(new Color(23, 21, 77));
		lblInfoUserEdit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblInfoUserEdit.setBorder(null);
		lblInfoUserEdit.setBounds(31, 83, 528, 52);
		add(lblInfoUserEdit);

		JPanel pnlUserDetailsEdit = new JPanel();
		pnlUserDetailsEdit.setLayout(null);
		pnlUserDetailsEdit.setBounds(31, 171, 528, 261);
		add(pnlUserDetailsEdit);
		
		JPanel pnlFirstNameEdit = new JPanel();
		pnlFirstNameEdit.setLayout(null);
		pnlFirstNameEdit.setBounds(0, 0, 528, 30);
		pnlUserDetailsEdit.add(pnlFirstNameEdit);
		
		JLabel lblFirstNameEdit = new JLabel("First Name:");//dating info nya pwede ilagay sa placeholder
		lblFirstNameEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFirstNameEdit.setBounds(0, 0, 116, 30);
		pnlFirstNameEdit.add(lblFirstNameEdit);
		
		txtFirstNameEdit = new PlaceholderTextField("");//dating info nya pwede ilagay sa placeholder
		txtFirstNameEdit.setOpaque(false);
		txtFirstNameEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtFirstNameEdit.setColumns(10);
		txtFirstNameEdit.setBounds(128, 1, 400, 30);
		pnlFirstNameEdit.add(txtFirstNameEdit);
		
		JPanel pnlLastNameEdit = new JPanel();
		pnlLastNameEdit.setLayout(null);
		pnlLastNameEdit.setBounds(0, 34, 528, 30);
		pnlUserDetailsEdit.add(pnlLastNameEdit);
		
		JLabel lblLastNameEdit = new JLabel("Last Name:");
		lblLastNameEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLastNameEdit.setBounds(0, 0, 116, 30);
		pnlLastNameEdit.add(lblLastNameEdit);
		
		txtLastNameEdit = new PlaceholderTextField("");//dating info nya pwede ilagay sa placeholder
		txtLastNameEdit.setOpaque(false);
		txtLastNameEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtLastNameEdit.setColumns(10);
		txtLastNameEdit.setBounds(128, 1, 400, 30);
		pnlLastNameEdit.add(txtLastNameEdit);
		
		JPanel pnlPatronID = new JPanel();
		pnlPatronID.setLayout(null);
		pnlPatronID.setBounds(0, 67, 528, 30);
		pnlUserDetailsEdit.add(pnlPatronID);
		
		JLabel lblPatronID = new JLabel("Patron ID:");
		lblPatronID.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPatronID.setBounds(0, 0, 117, 30);
		pnlPatronID.add(lblPatronID);
		
		txtPatronID = new PlaceholderTextField("");//bawal mapalitan toh
		txtPatronID.setEnabled(false);
		txtPatronID.setEditable(false);
		txtPatronID.setOpaque(false);
		
		txtPatronID.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtPatronID.setColumns(10);
		txtPatronID.setBounds(128, 1, 400, 30);
		pnlPatronID.add(txtPatronID);
		
		
		JPanel pnlContactNumberEdit = new JPanel();
		pnlContactNumberEdit.setLayout(null);
		pnlContactNumberEdit.setBounds(0, 100, 528, 30);
		pnlUserDetailsEdit.add(pnlContactNumberEdit);
		
		JLabel lblContactNumberEdit = new JLabel("Contact Number:");
		lblContactNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblContactNumberEdit.setBounds(0, 0, 117, 30);
		pnlContactNumberEdit.add(lblContactNumberEdit);
		
		txtContactNumberEdit = new PlaceholderTextField("");//dating info nya pwede ilagay sa placeholder
		txtContactNumberEdit.setOpaque(false);
		txtContactNumberEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtContactNumberEdit.setColumns(10);
		txtContactNumberEdit.setBounds(128, 1, 400, 30);
		pnlContactNumberEdit.add(txtContactNumberEdit);
		
		JPanel pnlEmailAddressEdit = new JPanel();
		pnlEmailAddressEdit.setLayout(null);
		pnlEmailAddressEdit.setBounds(0, 131, 528, 30);
		pnlUserDetailsEdit.add(pnlEmailAddressEdit);
		
		JLabel lblEmailAddressEdit = new JLabel("Email Address:");
		lblEmailAddressEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEmailAddressEdit.setBounds(0, 0, 117, 30);
		pnlEmailAddressEdit.add(lblEmailAddressEdit);
		
		txtEmailAddressEdit = new PlaceholderTextField("");//dating info nya pwede ilagay sa placeholder
		txtEmailAddressEdit.setOpaque(false);
		txtEmailAddressEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtEmailAddressEdit.setColumns(10);
		txtEmailAddressEdit.setBounds(128, 1, 400, 30);
		pnlEmailAddressEdit.add(txtEmailAddressEdit);
		
		JPanel pnlAddressEdit = new JPanel();
		pnlAddressEdit.setLayout(null);
		pnlAddressEdit.setBounds(0, 161, 528, 30);
		pnlUserDetailsEdit.add(pnlAddressEdit);		
		
		JLabel lblAddressEdit = new JLabel("Address:");
		lblAddressEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAddressEdit.setBounds(0, 0, 117, 30);
		pnlAddressEdit.add(lblAddressEdit);
		
		txtAddressEdit = new PlaceholderTextField("");//dating info nya pwede ilagay sa placeholder
		txtAddressEdit.setOpaque(false);
		txtAddressEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtAddressEdit.setColumns(10);
		txtAddressEdit.setBounds(128, 1, 400, 30);
		pnlAddressEdit.add(txtAddressEdit);		
		
		JPanel pnlPasswordEdit = new JPanel();
		pnlPasswordEdit.setBounds(0, 225, 528, 30);
		pnlUserDetailsEdit.add(pnlPasswordEdit);
		pnlPasswordEdit.setLayout(null);
		
		JLabel lblPasswordEdit = new JLabel("Password:");
		lblPasswordEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPasswordEdit.setBounds(0, 0, 117, 30);
		pnlPasswordEdit.add(lblPasswordEdit);
		
		btnPasswordEdit = new JButton("Change Password");//dating info nya pwede ilagay sa placeholder
		btnPasswordEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnPasswordEdit.setBounds(128, 1, 400, 30);
		btnPasswordEdit.setBorderPainted(false);
		btnPasswordEdit.setOpaque(true);
		btnPasswordEdit.setForeground(Color.WHITE);
		btnPasswordEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnPasswordEdit.setBackground(new Color(23, 22, 77));
		pnlPasswordEdit.add(btnPasswordEdit);		
		
		
		JSeparator separatorEdit = new JSeparator();
		separatorEdit.setOpaque(true);
		separatorEdit.setBackground(new Color(23, 21, 77));
		separatorEdit.setBounds(31, 433, 528, 12);
		add(separatorEdit);
		
		btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.setBorderPainted(false);
		btnCancelEdit.setOpaque(true);
		btnCancelEdit.setForeground(Color.WHITE);
		btnCancelEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancelEdit.setBackground(new Color(23, 22, 77));
		btnCancelEdit.setBounds(309, 470, 250, 29);
		add(btnCancelEdit);
		
		JButton btnSaveChangesEdit = new JButton("Save Changes");
		btnSaveChangesEdit.setBorderPainted(false);
		btnSaveChangesEdit.setOpaque(true);
		btnSaveChangesEdit.setForeground(Color.WHITE);
		btnSaveChangesEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnSaveChangesEdit.setBackground(new Color(23, 22, 77));
		btnSaveChangesEdit.setBounds(31, 470, 250, 29);
		add(btnSaveChangesEdit);


	}

    
}