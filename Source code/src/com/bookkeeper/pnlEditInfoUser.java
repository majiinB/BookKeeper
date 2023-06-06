
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
	private PlaceholderTextField txtAddressEdit;
	private JButton btnPasswordEdit;
	private JButton btnCancelEdit;
	
	public pnlEditInfoUser(User user) {
				setLayout(null);
		
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(31, 42, 138, 124);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		
		JLabel lblInfoUserEdit = new JLabel("Edit Patron Information");
		lblInfoUserEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUserEdit.setOpaque(false);
		lblInfoUserEdit.setForeground(new Color(23, 21, 77));
		lblInfoUserEdit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblInfoUserEdit.setBorder(null);
		lblInfoUserEdit.setBounds(156, 83, 403, 52);
		add(lblInfoUserEdit);

		JPanel pnlUserDetailsEdit = new JPanel();
		pnlUserDetailsEdit.setLayout(null);
		pnlUserDetailsEdit.setBounds(31, 171, 528, 261);
		add(pnlUserDetailsEdit);
		
		JPanel pnlFirstNameEdit = new JPanel();
		pnlFirstNameEdit.setLayout(null);
		pnlFirstNameEdit.setBounds(0, 18, 528, 30);
		pnlUserDetailsEdit.add(pnlFirstNameEdit);
		
		JLabel lblFirstNameEdit = new JLabel("First Name:");//dating info nya pwede ilagay sa placeholder
		lblFirstNameEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFirstNameEdit.setBounds(0, 0, 116, 30);
		pnlFirstNameEdit.add(lblFirstNameEdit);
		
		txtFirstNameEdit = new PlaceholderTextField(user.getUser_fname());//dating info nya pwede ilagay sa placeholder
		txtFirstNameEdit.setOpaque(false);
		txtFirstNameEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtFirstNameEdit.setColumns(10);
		txtFirstNameEdit.setBounds(128, 1, 400, 30);
		pnlFirstNameEdit.add(txtFirstNameEdit);
		
		JPanel pnlLastNameEdit = new JPanel();
		pnlLastNameEdit.setLayout(null);
		pnlLastNameEdit.setBounds(0, 59, 528, 30);
		pnlUserDetailsEdit.add(pnlLastNameEdit);
		
		JLabel lblLastNameEdit = new JLabel("Last Name:");
		lblLastNameEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLastNameEdit.setBounds(0, 0, 116, 30);
		pnlLastNameEdit.add(lblLastNameEdit);
		
		txtLastNameEdit = new PlaceholderTextField(user.getUser_lname());//dating info nya pwede ilagay sa placeholder
		txtLastNameEdit.setOpaque(false);
		txtLastNameEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtLastNameEdit.setColumns(10);
		txtLastNameEdit.setBounds(128, 1, 400, 30);
		pnlLastNameEdit.add(txtLastNameEdit);
		
		
		JPanel pnlContactNumberEdit = new JPanel();
		pnlContactNumberEdit.setLayout(null);
		pnlContactNumberEdit.setBounds(0, 120, 528, 30);
		pnlUserDetailsEdit.add(pnlContactNumberEdit);
		
		JLabel lblContactNumberEdit = new JLabel("Contact Number:");
		lblContactNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblContactNumberEdit.setBounds(0, 0, 117, 30);
		pnlContactNumberEdit.add(lblContactNumberEdit);
		
		txtContactNumberEdit = new PlaceholderTextField(user.getUser_contact());//dating info nya pwede ilagay sa placeholder
		txtContactNumberEdit.setOpaque(false);
		txtContactNumberEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtContactNumberEdit.setColumns(10);
		txtContactNumberEdit.setBounds(128, 1, 400, 30);
		pnlContactNumberEdit.add(txtContactNumberEdit);
		
		JPanel pnlAddressEdit = new JPanel();
		pnlAddressEdit.setLayout(null);
		pnlAddressEdit.setBounds(0, 161, 528, 30);
		pnlUserDetailsEdit.add(pnlAddressEdit);		
		
		JLabel lblAddressEdit = new JLabel("Address:");
		lblAddressEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAddressEdit.setBounds(0, 0, 117, 30);
		pnlAddressEdit.add(lblAddressEdit);
		
		txtAddressEdit = new PlaceholderTextField(user.getUser_address());//dating info nya pwede ilagay sa placeholder
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
		
		// Action Listener
		btnSaveChangesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = txtFirstNameEdit.getText();
				String lName = txtLastNameEdit.getText();
				String contactNum = txtContactNumberEdit.getText();
				String address = txtAddressEdit.getText();
				String userId = user.getUser_id();
				updateUserInfo(fName, lName, contactNum, address, userId);
			}
		});

	}
	// Methods
	public JButton getEditPassbtn() {
		return btnPasswordEdit;
	}
	public JButton getCancelEdit() {
		return btnCancelEdit;
	}
	//Update the User
		public void updateUserInfo(String fname, String lname, String contactNum, String address, String ID) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        String DB_URL = "jdbc:mysql://localhost/book_keeper";
			String USERNAME = "root";
			String PASSWORD = "";
	        try {
	            // Establish the database connection
	            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	            
	            //Condition to handle blank values
	            if(fname.isBlank()||lname.isBlank()||contactNum.isBlank()||address.isBlank()) {
	            	JOptionPane.showMessageDialog(pnlEditInfoUser.this, "Cannot have blank values", "Error", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	String sql = "UPDATE patron SET patron_fname = ?, patron_lname = ?, patron_contact = ?, patron_address = ? WHERE patron_id = ?";

	                // Prepare the statement
	                stmt = conn.prepareStatement(sql);
	                stmt.setString(1, fname);
	                stmt.setString(2, lname);
	                stmt.setString(3, contactNum);
	                stmt.setString(4, address);
	                stmt.setString(5, ID);

	                // Execute the update
	                int rowsUpdated = stmt.executeUpdate();
	            	
	                if (rowsUpdated > 0) {
	                	JOptionPane.showMessageDialog(pnlEditInfoUser.this, "Book Info Updated Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
	                } else {
	                	JOptionPane.showMessageDialog(pnlEditInfoUser.this, "Book did not update", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Error updating row: " + e.getMessage());
	        } finally {
	            // Close the statement and connection
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                    System.out.println("Database connection closed.");
	                }
	            } catch (SQLException e) {
	                System.err.println("Error closing resources: " + e.getMessage());
	            }
	        }
	    }
    
}