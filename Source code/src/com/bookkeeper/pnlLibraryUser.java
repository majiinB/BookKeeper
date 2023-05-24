package com.bookkeeper;

import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlLibraryUser extends JPanel {
	
	private JTextField txtSearchBar;
	private JPanel pnlSearchResults;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table_1;
	public pnlLibraryUser() {
		setLayout(null);
		JLabel lblBookKeeper = new JLabel("Book Keeper");
		lblBookKeeper.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
		lblBookKeeper.setOpaque(true);
		lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);
		        lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);
		        lblBookKeeper.setBounds(55, 46, 125, 38);
		        lblBookKeeper.setBackground(new Color(26, 24, 87));
		        lblBookKeeper.setForeground(new Color(232, 246, 239));
		        add(lblBookKeeper);

		        txtSearchBar = new JTextField();
		        lblBookKeeper.setLabelFor(txtSearchBar);
		        txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
		        txtSearchBar.setBackground(new Color(255, 255, 255));
		        txtSearchBar.setBounds(192, 46, 587, 38);
		        add(txtSearchBar);
		        txtSearchBar.setColumns(10);

		        JPanel pnlSearchBtn = new JPanel();
		        pnlSearchBtn.setBackground(new Color(255, 255, 255));
		        pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		        pnlSearchBtn.setBounds(778, 46, 41, 38);

		        

		        JButton btnSearch = new JButton("");
		        btnSearch.setBounds(0, 0, 40, 38);
		        ImageIcon icnSearch = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/searchIcon.png");
		        Image imgSearch = icnSearch.getImage();
		        Image rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		        btnSearch.setIcon(new ImageIcon(rsdImgSearch));

		        btnSearch.setContentAreaFilled(false);
		        btnSearch.setOpaque(false);
		        btnSearch.setBorderPainted(false);
		        pnlSearchBtn.add(btnSearch);
		        add(pnlSearchBtn);

		        pnlSearchResults = new JPanel();
		        pnlSearchResults.setBounds(55, 123, 764, 400);
		        pnlSearchResults.setLayout(new GridLayout(0, 1, 0, 5));
		        add(pnlSearchResults);
		        
		        //add scroll pane 
		        JScrollPane scrollPane = new JScrollPane();
		        pnlSearchResults.add(scrollPane);
		        
		        //add table
		        tableModel = new DefaultTableModel();
		        table = new JTable(tableModel) {
		            // Override isCellEditable method to make cells not editable
		            @Override
		            public boolean isCellEditable(int row, int column) {
		                return false;
		            }
		        };
		        
		       
		        table.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	BookInfoFrame frame = new BookInfoFrame(3);
		        		frame.setVisible(true);
		            }
		        });
		        scrollPane.setViewportView(table);
		        displayAllBooks();
		        
		        btnSearch.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                tableModel.setRowCount(0);
		                scrollPane.setViewportView(table);

		                try {
		                    // Establish database connection
		                    String getSearch = txtSearchBar.getText().trim();
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		                    String getQuery = "";
		                    
		                    // Check for empty search
		                    if (getSearch.isEmpty()) {
		                        getQuery = "SELECT b.book_id, b.book_title, b.author_name, b.book_publisher, b.genre_name, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
		                                "JOIN location l ON b.location_id = l.location_id ORDER BY book_title ASC;";
		                    } else {
		                        getQuery = searchQuery(getSearch);
		                    }

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
		                } catch (SQLException e1) {
		                    e1.printStackTrace();
		                }
		            }
		        });
		    }
		   
		    
		    //Methods na dito
		    public String searchQuery(String search) {
		    	 String query = "SELECT b.book_id, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
		                 "JOIN location l ON b.location_id = l.location_id " +
		                 "WHERE b.book_title LIKE '" + search + "%' OR " +
		                 "b.author_name LIKE '" + search + "%' OR " +
		                 "b.genre_name LIKE '" + search + "%' OR " +
		                 "b.book_publisher LIKE '" + search + "%'";
		       return query;
		    }
		    public void addBook() {
		    	
		    }
		    private void displayAllBooks() {
		        try {
		            // Establish database connection
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		            String getQuery = "SELECT b.book_id, b.book_title, b.author_name, b.book_publisher, b.genre_name,  b.book_status, l.aisle_number, l.shelf_number FROM book b " +
		                    "JOIN location l ON b.location_id = l.location_id ORDER BY book_title ASC;";

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
