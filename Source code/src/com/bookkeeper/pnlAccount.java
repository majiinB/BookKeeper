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
	private JTable table_1;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel_1;

    public pnlAccount(User user) {
	setBackground(new Color(255, 255, 255));
	setLayout(null);
	
	// Add labels
	JLabel lblMyAccount_1 = new JLabel("My Account");
	lblMyAccount_1.setForeground(new Color(26, 24, 87));
	lblMyAccount_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 40));
	lblMyAccount_1.setBounds(31, 24, 324, 48);
	add(lblMyAccount_1);
	
	JLabel lblBookHistory = new JLabel("Book Borrow History");
	lblBookHistory.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
	lblBookHistory.setForeground(new Color(26, 24, 87));
	lblBookHistory.setBounds(41, 269, 240, 16);
	add(lblBookHistory);
	
	JLabel lblBookReservationHistory = new JLabel("Reserved Books");
	lblBookReservationHistory.setForeground(new Color(26, 24, 87));
	lblBookReservationHistory.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
	lblBookReservationHistory.setBounds(424, 56, 335, 16);
	add(lblBookReservationHistory);
	
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
	
	// New Panel for reservationHistory table
	JPanel panel_1 = new JPanel();
	pnlinformation.add(panel_1);
	panel_1.setLayout(null);
	
	// New Scroll Pane for reservationHistory
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 11, 364, 123);
	panel_1.add(scrollPane_1);
	
	tableModel_1 = new DefaultTableModel();
	table_1 = new JTable(tableModel_1);
	scrollPane_1.setViewportView(table_1);
	
	String Id = user.getUser_id();
	displayAllReservation(Id);

	
	JButton btnEditInfo = new JButton("Edit Info");
	btnEditInfo.setForeground(new Color(255, 255, 255));
	btnEditInfo.setOpaque(true);
	btnEditInfo.setBorderPainted(false);
	btnEditInfo.setBackground(new Color(24, 21, 79));
	btnEditInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
	btnEditInfo.setBounds(31, 233, 779, 25);
	add(btnEditInfo);
	
	// New Panel for bookHistory table
	JPanel panel = new JPanel();
	panel.setBounds(31, 296, 779, 201);
	add(panel);
	panel.setLayout(null);
	
	// New Scroll Pane for bookHistory table
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 11, 759, 179);
	panel.add(scrollPane);
	
	tableModel = new DefaultTableModel();
	table = new JTable(tableModel);
	scrollPane.setViewportView(table);
	
	String ID = user.getUser_id();
	displayAllBooks(ID); 
	JButton btnReload = new JButton("Reload tables");
	btnReload.setBounds(679, 49, 129, 23);
	add(btnReload);
	// Action listeners
	btnEditInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserInfoFrame frame = new UserInfoFrame(user);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
	});
	btnReload.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String userID = user.getUser_id();
			reloadReservationTable(userID);
			reloadBookTable(userID);
		}
	});
    }
    private void reloadReservationTable(String userId) {
        // Remove all rows from the reservation table
        tableModel_1.setRowCount(0);

        // Reload the reservation data
        displayAllReservation(userId);
    }

    private void reloadBookTable(String userId) {
        // Remove all rows from the book table
        tableModel.setRowCount(0);

        // Reload the book data
        displayAllBooks(userId);
    }
    private void displayAllBooks(String id) {
        try {
            // Establish database connection
        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            String getQuery = "SELECT b.book_title, bb.borrowed_date" +
                    " FROM book AS b " +
                    "JOIN borrowed_book AS bb ON b.book_id = bb.book_id" +
                    " WHERE bb.patron_id = '" + id + "' ORDER BY bb.borrowed_date";

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
    private void displayAllReservation(String id) {
        try {
            // Establish database connection
        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            String getQuery = "SELECT b.book_status, b.book_id, b.book_title " +
                    "FROM reserved_book AS rb " +
                    "JOIN book AS b ON rb.book_id = b.book_id " +
                    "WHERE rb.patron_id = '" + id + "' AND  rb.reservation_status = 'in que'";


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
            tableModel_1.setColumnIdentifiers(columnNames);
            
            //Retrieve all row data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel_1.addRow(rowData);
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