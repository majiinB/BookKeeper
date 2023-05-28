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

public class pnlLibraryAdmin extends JPanel {
    private JTextField txtSearchBar;
    private JPanel pnlSearchResults;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private BookInfoFrame frame;
    private  Book selectedBook;
    public pnlLibraryAdmin() {
        setLayout(null);

        //Create main panel that will contain library panel
        JLabel lblBookKeeper = new JLabel("Book Keeper");
        lblBookKeeper.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        lblBookKeeper.setOpaque(true);
        lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);
        lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookKeeper.setBounds(55, 46, 125, 38);
        lblBookKeeper.setBackground(new Color(26, 24, 87));
        lblBookKeeper.setForeground(new Color(232, 246, 239));
        add(lblBookKeeper);
        
        //Search bar
        txtSearchBar = new JTextField();
        lblBookKeeper.setLabelFor(txtSearchBar);
        txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        txtSearchBar.setBackground(new Color(255, 255, 255));
        txtSearchBar.setBounds(192, 46, 587, 38);
        txtSearchBar.setColumns(10);
        add(txtSearchBar);
        
        //Search button
        //create panel for button
        JPanel pnlSearchBtn = new JPanel();
        pnlSearchBtn.setBackground(new Color(255, 255, 255));
        pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnlSearchBtn.setBounds(778, 46, 41, 38);
        //create button
        JButton btnSearch = new JButton("");
        btnSearch.setBounds(0, 0, 40, 38);
        ImageIcon icnSearch = new ImageIcon("D:\\documents\\Final_Project\\img\\searchIcon.png");
        Image imgSearch = icnSearch.getImage();
        Image rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        btnSearch.setIcon(new ImageIcon(rsdImgSearch));
        btnSearch.setContentAreaFilled(false);
        btnSearch.setOpaque(false);
        btnSearch.setBorderPainted(false);
        pnlSearchBtn.add(btnSearch);
        add(pnlSearchBtn);

        //Create panel for result table
        pnlSearchResults = new JPanel();
        pnlSearchResults.setBounds(55, 123, 764, 356);
        pnlSearchResults.setLayout(new GridLayout(0, 1, 0, 5));
        add(pnlSearchResults);
        
        //add scroll pane
        scrollPane = new JScrollPane();
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
        
       //listener for clicking cells in table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the values from the selected row
                    int bookId = (int) table.getValueAt(selectedRow, 0);
                    String bookTitle = (String) table.getValueAt(selectedRow, 1);
                    String authorName = (String) table.getValueAt(selectedRow, 2);
                    String genreName = (String) table.getValueAt(selectedRow, 3);
                    String bookPublisher = (String) table.getValueAt(selectedRow, 4);
                    java.sql.Date date = (java.sql.Date) table.getValueAt(selectedRow, 5);
                    String bookPublishDate = date.toString();
                    String bookStatus = (String) table.getValueAt(selectedRow, 6);
                    int aisleNumber = (int) table.getValueAt(selectedRow, 7);
                    int shelfNumber = (int) table.getValueAt(selectedRow, 8);

                    //Create a Book object with the retrieved values
                    selectedBook = new Book(bookId, bookTitle, genreName, authorName, bookPublishDate , bookPublisher, bookStatus, aisleNumber, shelfNumber);

                    //Use the selectedBook object as needed
                    // ...

                    // Open the BookInfoFrame with the selected book
                    BookInfoFrame frame = new BookInfoFrame(2, selectedBook);
                    frame.setVisible(true);
                } 
            }
        }); 
        
        //Action listener for add book to show pop up
        JButton btnAddBook = new JButton("Add Book");
        btnAddBook.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
                    BookInfoFrame frame = new BookInfoFrame(1);
                    frame.setVisible(true);
        	}
        });
        
        //set what's inside the scroll pane
        scrollPane.setViewportView(table);
        
        //Create button for adding books
        btnAddBook.setOpaque(true);
		btnAddBook.setBorderPainted(false);
        btnAddBook.setForeground(new Color(255, 255, 255));
        btnAddBook.setBackground(new Color(26, 24, 87));
        btnAddBook.setBounds(55, 495, 764, 29); 
        add(btnAddBook);
        
        //method to display books prior to displaying the library admin panel
        displayAllBooks(); 
        
        //Action listener for search button
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
                        getQuery = "SELECT b.book_id, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
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
    
    
    //Methods
    public String searchQuery(String search) {
    	 String query = "SELECT b.book_id, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
                 "JOIN location l ON b.location_id = l.location_id " +
                 "WHERE b.book_title LIKE '" + search + "%' OR " +
                 "b.author_name LIKE '" + search + "%' OR " +
                 "b.genre_name LIKE '%" + search + "%' OR " +
                 "b.book_publisher LIKE '" + search + "%'";      
    	return query;
    }
    public void addBook() {
    	
    }
    private void displayAllBooks() {
        try {
            // Establish database connection
        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            String getQuery = "SELECT b.book_id, b.book_title, b.author_name, b.genre_name,b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
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
    public Book getBook() {
    	return selectedBook;
    }
}