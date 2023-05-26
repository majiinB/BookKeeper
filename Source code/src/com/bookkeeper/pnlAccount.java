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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
public class pnlAccount extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;

    public pnlAccount(User user) {
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

	JLabel lblName = new JLabel("  Name:       " + user.getUser_fname() + " " + user.getUser_lname());
	column1.add(lblName);

	JLabel lblID = new JLabel("  ID:       " + user.getUser_id());
	column1.add(lblID);

	JLabel lblContactNumber = new JLabel("  Contact Number:       " + user.getUser_contact());
	column1.add(lblContactNumber);
	
	JLabel lblAddress = new JLabel("  Address:       " + user.getUser_address());
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
	
	JPanel panel = new JPanel();
	panel.setBounds(31, 273, 779, 201);
	add(panel);
	panel.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 11, 759, 179);
	panel.add(scrollPane);
	
	tableModel = new DefaultTableModel();
	table = new JTable(tableModel);
	scrollPane.setViewportView(table);
	String ID = user.getUser_id();
	displayAllBooks(ID); 

    }
    private void displayAllBooks(String id) {
        try {
            // Establish database connection
        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            String getQuery = "SELECT b.book_title, bb.borrowed_date" +
                    " FROM book AS b " +
                    "JOIN borrowed_book AS bb ON b.book_id = bb.book_id" +
                    " WHERE bb.patron_id = '" + id + "'";

            // Execute the SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getQuery); 

            // Get the metadata for column information
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create an array to store column names
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            // Set the column names in the table model
            tableModel.setColumnIdentifiers(columnNames);
            
            //Retrieve all row data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            // Close the database connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }
