package com.bookkeeper;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class pnlAccount extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable table_1;
    
	public pnlAccount() {
	setBackground(new Color(255, 255, 255));
	setLayout(null);
	
	JLabel lblMyAccount_1 = new JLabel("My Account");
	lblMyAccount_1.setForeground(new Color(26, 24, 87));
	lblMyAccount_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 40));
	lblMyAccount_1.setBounds(31, 24, 324, 48);
	add(lblMyAccount_1);
	
	JLabel lblBookHistory = new JLabel("Book History");
	lblBookHistory.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
	lblBookHistory.setForeground(new Color(26, 24, 87));
	lblBookHistory.setBounds(31, 246, 185, 16);
	add(lblBookHistory);
	
	JPanel pnlinformation = new JPanel();
	pnlinformation.setBounds(31, 84, 779, 145);
	add(pnlinformation);
	pnlinformation.setLayout(new GridLayout(0, 2, 10, 10));

	// First column
	JPanel column1 = new JPanel(new GridLayout(0, 1));
	pnlinformation.add(column1);

	JLabel lblName = new JLabel("  Name:");
	column1.add(lblName);

	JLabel lblID = new JLabel("  ID:");
	column1.add(lblID);

	JLabel lblContactNumber = new JLabel("  Contact Number:");
	column1.add(lblContactNumber);
	
	JLabel lblAddress = new JLabel("  Address:");
	column1.add(lblAddress);

	// Second column
	JPanel column2 = new JPanel(new GridLayout(0, 1));
	pnlinformation.add(column2);

	JTextField txtName = new JTextField("  Patron Name");
	column2.add(txtName);

	JTextField txtID = new JTextField("  Patron ID");
	column2.add(txtID);
	
	JTextField txtContactNumber = new JTextField("  Patron Number");
	column2.add(txtContactNumber);

	JTextField txtEmail = new JTextField("  Patron Address");
	column2.add(txtEmail);

	
	
	JScrollPane scrBookHistory = new JScrollPane();
	scrBookHistory.setBounds(31, 274, 779, 222);
	add(scrBookHistory);
	
	JButton btnEditInfo = new JButton("Edit Info");
	btnEditInfo.setForeground(new Color(255, 255, 255));
	btnEditInfo.setOpaque(true);
	btnEditInfo.setBorderPainted(false);
	btnEditInfo.setBackground(new Color(24, 21, 79));
	btnEditInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
	btnEditInfo.setBounds(357, 47, 84, 25);
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logic to edit text fields tas may save changes button pa pala dpt
				JButton btnSaveInfo = new JButton("Save Changes");
				btnSaveInfo.setForeground(new Color(255, 255, 255));
				btnSaveInfo.setOpaque(true);
				btnSaveInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				btnSaveInfo.setBorderPainted(false);
				btnSaveInfo.setBackground(new Color(24, 21, 79));
				btnSaveInfo.setBounds(384, 43, 101, 29);
				add(btnSaveInfo);
			}
		});
	add(btnEditInfo);
	

	// Add table to display book  history
	
	 //add table
    tableModel = new DefaultTableModel();
    table = new JTable(tableModel) {
        // Override isCellEditable method to make cells not editable
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    
	JTable tblBookHistory = new JTable();
	tblBookHistory.setBounds(64, 236, 700, 231);
	scrBookHistory.setViewportView(tblBookHistory);
	
	
	

	}
}	

