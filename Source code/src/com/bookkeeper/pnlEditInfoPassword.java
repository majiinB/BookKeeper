
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

public class pnlEditInfoPassword extends JPanel {

	private PlaceholderPassword txtCurrentPassword;
	private PlaceholderPassword txtNewPassword;
	private PlaceholderPassword txtConfirmNewPassword;

	private JButton btnPasswordEdit;
	private JButton btnCancelEdit;
	
	public pnlEditInfoPassword() {
		setLayout(null);
		
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(31, 42, 138, 124);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setOpaque(false);
		lblChangePassword.setForeground(new Color(23, 21, 77));
		lblChangePassword.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblChangePassword.setBorder(null);
		lblChangePassword.setBounds(31, 83, 528, 52);
		add(lblChangePassword);

		JPanel pnlChangePassword = new JPanel();
		pnlChangePassword.setLayout(null);
		pnlChangePassword.setBounds(31, 171, 528, 163);
		add(pnlChangePassword);
		
		JPanel pnlCurrentPassword = new JPanel();
		pnlCurrentPassword.setLayout(null);
		pnlCurrentPassword.setBounds(0, 6, 528, 30);
		pnlChangePassword.add(pnlCurrentPassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(0, 0, 116, 30);
		pnlCurrentPassword.add(lblCurrentPassword);
		
		txtCurrentPassword = new PlaceholderPassword("");
		txtCurrentPassword.setOpaque(false);
		txtCurrentPassword.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtCurrentPassword.setColumns(10);
		txtCurrentPassword.setBounds(128, 1, 400, 30);
		pnlCurrentPassword.add(txtCurrentPassword);
		
		JPanel pnlNewPassword = new JPanel();
		pnlNewPassword.setBounds(0, 52, 528, 35);
		pnlChangePassword.add(pnlNewPassword);
		pnlNewPassword.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(0, 1, 116, 30);
		pnlNewPassword.add(lblNewPassword);
		
		txtNewPassword = new PlaceholderPassword("");
		txtNewPassword.setBounds(128, 1, 400, 30);
		txtNewPassword.setOpaque(false);
		txtNewPassword.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtNewPassword.setColumns(10);
		pnlNewPassword.add(txtNewPassword);
		
		JPanel pnlConfirmNewPassword = new JPanel();
		pnlConfirmNewPassword.setLayout(null);
		pnlConfirmNewPassword.setBounds(0, 99, 528, 30);
		pnlChangePassword.add(pnlConfirmNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm Password");
		lblConfirmNewPassword.setBounds(0, 0, 116, 30);
		pnlConfirmNewPassword.add(lblConfirmNewPassword);
		
		txtConfirmNewPassword = new PlaceholderPassword("");
		txtConfirmNewPassword.setOpaque(false);
		txtConfirmNewPassword.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtConfirmNewPassword.setColumns(10);
		txtConfirmNewPassword.setBounds(128, 1, 400, 30);
		pnlConfirmNewPassword.add(txtConfirmNewPassword);
		
		
		
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