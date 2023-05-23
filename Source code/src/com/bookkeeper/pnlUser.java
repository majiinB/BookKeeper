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

public class pnlUser extends JPanel {
	private JTextField txtSearchBar;
    private JPanel pnlSearchResults;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
	//USERMANAGEMENT
	public pnlUser() {
        setLayout(null);
        
        JLabel lblBookKeeper = new JLabel("Book Keeper");
        lblBookKeeper.setOpaque(true);
        lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);
        lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookKeeper.setForeground(new Color(232, 246, 239));
        lblBookKeeper.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        lblBookKeeper.setBackground(new Color(26, 24, 87));
        lblBookKeeper.setBounds(55, 46, 125, 38);
        add(lblBookKeeper);
        
        txtSearchBar = new JTextField();
        txtSearchBar.setColumns(10);
        txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        txtSearchBar.setBackground(Color.WHITE);
        txtSearchBar.setBounds(192, 46, 587, 38);
        add(txtSearchBar);
        
        JPanel pnlSearchBtn = new JPanel();
        pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnlSearchBtn.setBackground(Color.WHITE);
        pnlSearchBtn.setBounds(778, 46, 41, 38);
        add(pnlSearchBtn);
        
        JButton btnSearch = new JButton("");
        btnSearch.setOpaque(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setBorderPainted(false);
        ImageIcon icnSearch = new ImageIcon("D:\\documents\\Final_Project\\img\\searchIcon.png");
        Image imgSearch = icnSearch.getImage();
        Image rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        btnSearch.setIcon(new ImageIcon(rsdImgSearch));                                   
        pnlSearchBtn.add(btnSearch);
        
        JPanel pnlSearchResults = new JPanel();
        pnlSearchResults.setBounds(55, 123, 764, 356);
        add(pnlSearchResults);
        pnlSearchResults.setLayout(null);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 764, 356);
        pnlSearchResults.add(scrollPane);
        
        tableModel = new DefaultTableModel();
        scrollPane.setViewportView(table);

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
                // Get the selected row and column
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();

                // Get the value from the selected cell
                Object selectedValue = table.getValueAt(selectedRow, selectedColumn);

                // Display the selected value
                int option = JOptionPane.showOptionDialog(pnlUser.this,"Selected Value: " + selectedValue, "Cell Value", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Exit"}, "Exit");
                if (option == 0) {
                    // User clicked "Exit"
                    JOptionPane.getRootFrame().dispose(); // Close the JOptionPane dialog
                }
            }
        });
        
        //set what's inside the scroll pane
        scrollPane.setViewportView(table);
        
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
                        getQuery = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
        	            		+ "FROM patron "
        	            		+ "ORDER BY patron_lname ASC";
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
	       String query = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
	       		+ "FROM patron "
	       		+ "WHERE patron_id LIKE '" +search+"%' OR patron_fname LIKE '"+search+"%' OR patron_lname LIKE '"+search+"%' "
	       		+ "ORDER BY patron_lname ASC";
	       return query;
	    }

	    private void displayAllBooks() {
	        try {
	            // Establish database connection
	        	//Rekta na kasi tinamad mag assign pa ng variables same lang naman kasi db na gagamitin HAHAHAHAA
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            String getQuery = "SELECT patron_id, patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_status "
	            		+ "FROM patron "
	            		+ "ORDER BY patron_lname ASC";

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
