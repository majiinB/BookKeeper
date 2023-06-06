package com.bookkeeper;

import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class pnlLibraryUser extends JPanel {
	
    private PlaceholderTextField txtSearchBar; 
    private JPanel pnlSearchResults;
    private JPanel pnlSearchBtn;
    private JPanel pnlSearchBar;
    private JPanel pnlLogo;
    private JPanel pnlWholeDisplay;
    private JLabel lblLogo;
    private JLabel lblBookKeeper;
    private JButton btnSearch ;
    private JScrollPane scrlSearchResults;
    private JTable table;
	private DefaultTableModel tableModel;
	private Book selectedBook;
    private GridBagLayout gbl_pnlWholeDisplay;
    private GridBagConstraints gbc_pnlSearchBar;
    private GridBagConstraints gbc_pnlSearchResults;
    private GridBagConstraints gbc_pnlLogo;
	private ImageIcon icnLogo;
    private ImageIcon icnSearch;
	private Image imgLogo;
	private Image rsdImgLogo;
    private Image imgSearch;
    private Image rsdImgSearch;
    
	public pnlLibraryUser(User user) {
        setLayout(new BorderLayout(0, 0));

        //panels
        pnlWholeDisplay= new JPanel();
        pnlLogo = new JPanel();//Logo
        pnlSearchBar = new JPanel();//Search button
        pnlSearchResults = new JPanel();//Create panel for result table
       
        icnLogo = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/bookKeeperLogo.png");
		//icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");
		imgLogo = icnLogo.getImage();
		rsdImgLogo = imgLogo.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        lblLogo = new JLabel("");    
        lblLogo.setBorder(new EmptyBorder(5, 5, 5, 5));     
        lblLogo.setOpaque(false);       
        lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);           
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);    		
        lblLogo.setOpaque(false);
        lblLogo.setIcon(new ImageIcon(rsdImgLogo));
         
        
        lblBookKeeper = new JLabel("Book Keeper");    
        lblBookKeeper.setBorder(new EmptyBorder(15, 15, 15, 15));     
        lblBookKeeper.setOpaque(true);       
        lblBookKeeper.setHorizontalTextPosition(SwingConstants.CENTER);           
        lblBookKeeper.setHorizontalAlignment(SwingConstants.CENTER);            
        lblBookKeeper.setBounds(55, 46, 125, 38);              
        lblBookKeeper.setBackground(new Color(26, 24, 87));           
        lblBookKeeper.setForeground(new Color(232, 246, 239));            
        lblBookKeeper.setLabelFor(txtSearchBar);    
        //Search bar
        txtSearchBar = new PlaceholderTextField("Search Book  ");
        txtSearchBar.setPreferredSize(new Dimension(109, 45));
        txtSearchBar.setHorizontalAlignment(SwingConstants.RIGHT);        
        txtSearchBar.setBorder(new LineBorder(new Color(26, 24, 87)));
        txtSearchBar.setBackground(new Color(255, 255, 255));
        txtSearchBar.setBounds(192, 46, 587, 38);
        txtSearchBar.setColumns(50);
              
        //create panel for button
        pnlSearchBtn = new JPanel();

        //icon of search button
        icnSearch = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/searchIcon.png");//insert nyo path file nyo papuntang image
        //ImageIcon icnSearch = new ImageIcon("D:\\documents\\Final_Project\\img\\searchIcon.png");
        imgSearch = icnSearch.getImage();
        rsdImgSearch = imgSearch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
          
      //create button
        btnSearch = new JButton("");
        btnSearch.setBounds(0, 0, 40, 38);
        btnSearch.setIcon(new ImageIcon(rsdImgSearch));
        btnSearch.setContentAreaFilled(false);
        btnSearch.setOpaque(false);
        btnSearch.setBorderPainted(false); 
        
        
      scrlSearchResults = new JScrollPane(); //add scroll pane
      
      tableModel = new DefaultTableModel();//add table
      
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
		    String ISBN = (String) table.getValueAt(selectedRow, 1);
		    String bookTitle = (String) table.getValueAt(selectedRow, 2);
		    String authorName = (String) table.getValueAt(selectedRow, 3);
		    String genreName = (String) table.getValueAt(selectedRow, 4);
		    String bookPublisher = (String) table.getValueAt(selectedRow, 5);
		    java.sql.Date date = (java.sql.Date) table.getValueAt(selectedRow, 6);
		    String bookPublishDate = date.toString();
		    String bookStatus = (String) table.getValueAt(selectedRow, 7);
		    int aisleNumber = (int) table.getValueAt(selectedRow, 8);
		    int shelfNumber = (int) table.getValueAt(selectedRow, 9);
		    //Create a Book object with the retrieved values
		    selectedBook = new Book(bookId, bookTitle, genreName, authorName, bookPublishDate , bookPublisher, bookStatus, aisleNumber, shelfNumber, ISBN);

		    //Use the selectedBook object as needed
		    // ...

		    // Open the BookInfoFrame with the selected book
		    BookInfoFrame frame = new BookInfoFrame(3, selectedBook, user);
		    frame.setVisible(true);
		    } 
		    }
	});

	//set what's inside the scroll pane
	scrlSearchResults.setViewportView(table);
    displayAllBooks();

    gbl_pnlWholeDisplay = new GridBagLayout();
    gbl_pnlWholeDisplay.columnWidths = new int[]{475};
    gbl_pnlWholeDisplay.rowHeights = new int[]{320, 59, 30};
    gbl_pnlWholeDisplay.columnWeights = new double[]{1.0};
    gbl_pnlWholeDisplay.rowWeights = new double[]{0.0, 0.0, 1.0};
    
    gbc_pnlLogo = new GridBagConstraints();
    gbc_pnlLogo.fill = GridBagConstraints.BOTH;
    gbc_pnlLogo.insets = new Insets(0, 0, 5, 5);
    gbc_pnlLogo.gridx = 0;
    gbc_pnlLogo.gridy = 0;
    
    
    gbc_pnlSearchBar = new GridBagConstraints();
    gbc_pnlSearchBar.anchor = GridBagConstraints.NORTH;
    gbc_pnlSearchBar.fill = GridBagConstraints.HORIZONTAL;
    gbc_pnlSearchBar.insets = new Insets(0, 0, 5, 5);
    gbc_pnlSearchBar.gridx = 0;
    gbc_pnlSearchBar.gridy = 1;
                     
    gbc_pnlSearchResults = new GridBagConstraints();
    gbc_pnlSearchResults.fill = GridBagConstraints.BOTH;
    gbc_pnlSearchResults.insets = new Insets(0, 0, 5, 0);
    gbc_pnlSearchResults.gridx = 0;
    gbc_pnlSearchResults.gridy = 2;
		      
  //panel layout details?
    pnlSearchResults.setLayout(new BorderLayout(0, 0));
    pnlSearchBar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
    pnlWholeDisplay.setLayout(gbl_pnlWholeDisplay);
    pnlWholeDisplay.setBorder(new EmptyBorder(20, 20, 20, 20)); 
    pnlSearchBtn.setBackground(new Color(255, 255, 255));
    pnlSearchBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
    pnlSearchBtn.setBounds(778, 46, 41, 38);
    
    pnlLogo.add(lblLogo);
    pnlSearchBar.add(lblBookKeeper);
    pnlSearchBar.add(txtSearchBar); 
    pnlSearchBtn.add(btnSearch);
    pnlSearchBar.add(pnlSearchBtn);
    pnlWholeDisplay.add(pnlLogo, gbc_pnlLogo);
    pnlWholeDisplay.add(pnlSearchBar, gbc_pnlSearchBar);
    pnlSearchResults.add(scrlSearchResults);
    pnlWholeDisplay.add(pnlSearchResults, gbc_pnlSearchResults);
    add(pnlWholeDisplay, BorderLayout.CENTER);
    
	btnSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tableModel.setRowCount(0);
		    scrlSearchResults.setViewportView(table);
		    try {
		        // Establish database connection
		        String getSearch = txtSearchBar.getText().trim();
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		        String getQuery = "";
		              
		        // Check for empty search
		        if (getSearch.isEmpty()||getSearch.equals("Search Book")) {
		             getQuery = "SELECT b.book_id, b.ISBN, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
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
		      String[] columnNames = new String[10];
	            columnNames[0] = "Book ID";
	            columnNames[1] = "ISBN";
	            columnNames[2] = "Title";
	            columnNames[3] = "Author name";
	            columnNames[4] = "Genre";
	            columnNames[5] = "Publisher";
	            columnNames[6] = "Publication Date";
	            columnNames[7] = "Status";
	            columnNames[8] = "Aisle No.";
	            columnNames[9] = "Shelf No.";

		      // Set the column names in the table model
		      tableModel.setColumnIdentifiers(columnNames);
		      table.setModel(tableModel);
		      
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
		    	 String query = "SELECT b.book_id, b.ISBN, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
		                 "JOIN location l ON b.location_id = l.location_id " +
		                 "WHERE book_status = 'Available' AND b.book_title LIKE '" + search + "%' OR " +
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
		            String getQuery = "SELECT b.book_id, b.ISBN, b.book_title, b.author_name, b.genre_name, b.book_publisher, b.book_publication_date, b.book_status, l.aisle_number, l.shelf_number FROM book b " +
		                    "JOIN location l ON b.location_id = l.location_id ORDER BY book_title ASC;";

		            // Execute the SQL query
		            Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery(getQuery);

		            // Get the metadata for column information
		            ResultSetMetaData metaData = resultSet.getMetaData();
		            int columnCount = metaData.getColumnCount();

		            // Create an array to store column names
		            String[] columnNames = new String[10];
		            columnNames[0] = "Book ID";
		            columnNames[1] = "ISBN";
		            columnNames[2] = "Title";
		            columnNames[3] = "Author name";
		            columnNames[4] = "Genre";
		            columnNames[5] = "Publisher";
		            columnNames[6] = "Publication Date";
		            columnNames[7] = "Status";
		            columnNames[8] = "Aisle No.";
		            columnNames[9] = "Shelf No.";

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