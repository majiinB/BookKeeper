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
    private JTextField searchBar;
    private JPanel pnlSearchResults;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable table_1;
    public pnlLibraryAdmin() {
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

        searchBar = new JTextField();
        lblBookKeeper.setLabelFor(searchBar);
        searchBar.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        searchBar.setBackground(new Color(255, 255, 255));
        searchBar.setBounds(192, 46, 587, 38);
        add(searchBar);
        searchBar.setColumns(10);

        JPanel pnlSearchBtn = new JPanel();
        pnlSearchBtn.setBackground(new Color(255, 255, 255));
        pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnlSearchBtn.setBounds(778, 46, 41, 38);

        ImageIcon icnSearch = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/searchIcon.png");
        Image imgSearch = icnSearch.getImage();
        Image rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        JButton btnSearch = new JButton("");
        btnSearch.setBounds(0, 0, 40, 38);
        btnSearch.setIcon(new ImageIcon(rsdImgSearch));
        btnSearch.setSelectedIcon(new ImageIcon(rsdImgSearch));
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
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel.setRowCount(0);
        		table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Get the selected row and column
                        int selectedRow = table.getSelectedRow();
                        int selectedColumn = table.getSelectedColumn();

                        // Get the value from the selected cell
                        Object selectedValue = table.getValueAt(selectedRow, selectedColumn);

                        // Display the selected value
                        int option = JOptionPane.showOptionDialog(pnlLibraryAdmin.this,"Selected Value: " + selectedValue, "Cell Value", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Exit"}, "Exit");
                        if (option == 0) {
                            // User clicked "Exit"
                            JOptionPane.getRootFrame().dispose(); // Close the JOptionPane dialog
                        }
                    }
                });
                
                //add table to scroll
                scrollPane.setViewportView(table);
                
                try {
                    // Establish database connection
                	String getSearch = searchBar.getText();
                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
                	String getQuery = searchQuery(getSearch);
                    // Execute the SQL query
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(getQuery);
                    if(getQuery.equals("")) {
                    	getQuery = "SELECT * FROM book ORDER BY book_title ASC;";
                    }
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

    /*public void displaySearchResults() {
        pnlSearchResults.removeAll();
        pnlSearchResults.add(createResultPanel());
        // Add your logic to display search results here
        revalidate();
        repaint();
    }*/

    /*private JPanel createResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.white);
        resultPanel.setBorder(new LineBorder(new Color(26, 24, 87), 1, true));
        resultPanel.setLayout(new BorderLayout());

        JLabel lblBookId = new JLabel("Book ID: "  + Book ID);
        lblBookId.setFont(new Font("Arial", Font.BOLD, 14));
        lblBookId.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resultPanel.add(lblBookId, BorderLayout.WEST);

        JLabel lblBookTitle = new JLabel("Title: "  + Book Ttile);
        lblBookTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBookTitle.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resultPanel.add(lblBookTitle, BorderLayout.CENTER);

        JLabel lblBookAuthor = new JLabel("Author: "  + Book Author);
        lblBookAuthor.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBookAuthor.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resultPanel.add(lblBookAuthor, BorderLayout.EAST);

        JLabel lblBookStatus = new JLabel("Status: "  + Book Status);
        lblBookStatus.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBookStatus.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resultPanel.add(lblBookStatus, BorderLayout.SOUTH);

        return resultPanel;
    }*/
    public String searchQuery(String search) {
       String query = "SELECT * FROM book WHERE book_title LIKE '" + search + "%' OR author_name LIKE '" + search + "' OR genre_name LIKE '" + search + "%' OR book_publisher LIKE '" + search + "%'" ;
       return query;
    }
    
}
