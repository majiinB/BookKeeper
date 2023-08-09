package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.bookkeeper.PatronLibraryPanel.headerRenderer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLibraryPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel topPanel;
	private RoundedPanel searchBarPanel;
	private RoundedPanel addBookPanel;
	private RoundedPanel searchResultsPanel;

	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	
	//textfield
	private PlaceholderTextField txtSearchBar;
	
	//icon
	private ImageIcon searchIcon;
	private int iconHeight; 
	private int iconWidth;
	//button
	private JButton btnSearch;
	private JButton btnAdd;

	//scroll
	private JScrollPane  searchScrollPane;
	
	//table
    private JTable table;
	private DefaultTableModel tableModel;
	
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_searchResultsPanel;

	private GridBagLayout gbl_topPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_searchBarPanel;
	private GridBagConstraints gbc_addBookPanel;
	
	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font buttonFont;
	private  Font headerFont;
	private  Font plainFont;
	
	private  int buttonTextSize;
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	
	//Object
	private Book selectedBook;

 public AdminLibraryPanel(Setting setting) {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(20, 20, 20, 20));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	topPanel = new JPanel();

	mainPanel = new JPanel();
	headingPanel = new JPanel();
    searchBarPanel =  new RoundedPanel(20);
    searchResultsPanel =  new RoundedPanel(20);
    addBookPanel =  new RoundedPanel(20);


    // Set panel properties
    headingPanel.setOpaque(false);
    mainPanel.setOpaque(false);
    searchBarPanel.setOpaque(true);
    addBookPanel.setOpaque(true);
    searchResultsPanel.setOpaque(true);
	topPanel.setOpaque(false);
	topPanel.setBorder(new EmptyBorder(20, 25, 0, 25));
	mainPanel.setBorder(new EmptyBorder(15, 25, 20, 25));
    searchBarPanel.setBorder(new EmptyBorder(5, 5, 5, 15));
    searchResultsPanel.setBorder(new EmptyBorder(10, 25, 10, 5));
    addBookPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	headingPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

    searchBarPanel.setBorderWidth(1);
    searchResultsPanel.setBorderWidth(2);
    addBookPanel.setBorderWidth(1);
    
    addBookPanel.setForeground(darkplainColor);
    searchBarPanel.setForeground(darkplainColor);
    searchResultsPanel.setForeground(darkplainColor);
    
    addBookPanel.setBackground(lightplainColor);
    searchBarPanel.setBackground(lightplainColor);
    searchResultsPanel.setBackground(lightplainColor);

    lblHeading1 = new JLabel("Dashboard ");
    lblHeading1.setOpaque(false);
    
    lblHeading2 = new JLabel("/ Library");
    lblHeading2.setOpaque(false);
    
    btnAdd = new JButton("Add Book");
    btnAdd.setBorderPainted(false);
    btnAdd.setFocusPainted(false);
    btnAdd.setContentAreaFilled(false);

    btnSearch = new JButton();
    btnSearch.setMnemonic(KeyEvent.VK_ENTER);
    btnSearch.setBorderPainted(false);
    btnSearch.setFocusPainted(false);
    btnSearch.setContentAreaFilled(false);
    
    searchIcon = new ImageIcon("img/DashboardFrame/Search.png");    
    iconHeight = (int) (btnSearch.getPreferredSize().getHeight() * 0.5);
    iconWidth = (int) (btnSearch.getPreferredSize().getHeight() * 0.5);
    searchIcon = new ImageIcon(searchIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
    btnSearch.setIcon(searchIcon);

    
    txtSearchBar = new PlaceholderTextField("Search Book");
    txtSearchBar.setBorder(null);
    txtSearchBar.setHorizontalAlignment(SwingConstants.RIGHT);
    txtSearchBar.setOpaque(false);

    // Create the scroll pane and add the table to it
    searchScrollPane = new JScrollPane(table);
    searchScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    searchScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    searchScrollPane.setOpaque(false);
    searchScrollPane.setBorder(new EmptyBorder(15, 10, 0, 0));
    searchScrollPane.setOpaque(false);
    searchScrollPane.getViewport().setOpaque(false);
    
    // Create the table with the tableModel
    tableModel = new DefaultTableModel();//add table
    
    table = new JTable(tableModel) {
    	
        // Override isCellEditable method to make cells not editable
    		@Override
    		public boolean isCellEditable(int row, int column) {
    		      return false;
    		}
         };    
    table.setBackground(new Color(0, 0, 0, 0));;
    table.setFillsViewportHeight(true);
    table.setOpaque(false);
    table.setShowVerticalLines(false);
    table.setRowHeight(45);
    table.getTableHeader().setOpaque(false);
    table.setGridColor(darkplainColor);
    table.getTableHeader().setDefaultRenderer(new headerRenderer());
  	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
		    
		    // Open the BookInfoFrame with the selected book
		    AdminBookInfoPanel panel = new AdminBookInfoPanel(selectedBook, setting);
		    showDialog(panel);
		    } 
		}
	});
	
	 /*
     * gamit ka ng gridbag layout for more control sa placement ng components  sa panel
     * ung gbc or grid bag constraints is para madetermine mo ung positioning ng mga components sa gridbag layout
     * x = column
     * y = row
     * gridheight/gridwidth = no. of cells occupied
     * anchor = alignment
     * insets = padding
     */
    
    //gridbag layouts
    
    gbl_topPanel = new GridBagLayout();
    gbl_topPanel.columnWidths = new int[]{30, 30, 0};
    gbl_topPanel.rowHeights = new int[]{30, 0};
    gbl_topPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_topPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.SOUTHWEST;
    gbc_headingPanel.insets = new Insets(0, 0, 0, 0);
	gbc_headingPanel.gridx = 0;
	gbc_headingPanel.gridy = 0;

	gbc_searchBarPanel = new GridBagConstraints();
	gbc_searchBarPanel.fill = GridBagConstraints.HORIZONTAL;
	gbc_searchBarPanel.insets = new Insets(0, 40, 0, 10);
	gbc_searchBarPanel.gridx = 1;
	gbc_searchBarPanel.gridy = 0;

	gbc_addBookPanel = new GridBagConstraints();
	gbc_addBookPanel.anchor = GridBagConstraints.EAST;
	gbc_addBookPanel.insets = new Insets(0, 15, 0, 0);
    gbc_addBookPanel.gridx = 2;
    gbc_addBookPanel.gridy = 0;
    
    
	// Set panel layouts
    mainPanel.setLayout(new BorderLayout(0,0));
    searchBarPanel.setLayout(new BorderLayout(0, 0));
    headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
    topPanel.setLayout(gbl_topPanel);
    
    //Add all to main panel
    headingPanel.add(lblHeading1);
    headingPanel.add(lblHeading2);

    searchBarPanel.add(btnSearch,BorderLayout.WEST);
    searchBarPanel.add(txtSearchBar,BorderLayout.CENTER);
    
    mainPanel.add(searchResultsPanel);
    displayAllBooks();
    searchResultsPanel.setLayout(new BorderLayout(0, 0));

    // Add the scroll pane to the searchResultsPanel
    searchResultsPanel.add(searchScrollPane);
 
    addBookPanel.setLayout(new BorderLayout(0, 0));
    addBookPanel.add(btnAdd);    
    topPanel.add(headingPanel,gbc_headingPanel);
    topPanel.add(searchBarPanel,gbc_searchBarPanel);
    topPanel.add(addBookPanel,gbc_addBookPanel);
    
    
	add(topPanel, BorderLayout.NORTH);
	add(mainPanel, BorderLayout.CENTER);
	
	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;
	        subtitleTextSize =  Math.min(getHeight() / 40, getWidth()/ 40);
	        buttonTextSize =  Math.min(getHeight() / 80, getWidth()/ 80);
	        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
	        plainTextsize=   Math.min(getHeight() / 75, getWidth()/ 75);
	            
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
			subtitleFont = new Font("Montserrat", Font.BOLD, subtitleTextSize);
	        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	     	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
			plainFont = new Font("Montserrat", Font.ITALIC, plainTextsize);
			
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));	            	            
	            
			btnAdd.setFont(buttonFont);
	     	table.setFont(plainFont);
	     	table.getTableHeader().setFont(new Font("Montserrat", Font.ITALIC  | Font.BOLD, plainTextsize));	            
	     	table.getTableHeader().setForeground(headerColor);
  	  	}
    });
	
	// Action Listener
	btnSearch.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		tableModel.setRowCount(0);
    		searchScrollPane.setViewportView(table);
 		    try {
 		        // Establish database connection
 		        String getSearch = txtSearchBar.getText().trim();
 		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
 		        String getQuery = "";
 		              
 		        // Check for empty search
 		        if (getSearch.isEmpty()||getSearch.equals("Search Book")) {
 		             getQuery = "SELECT book_id, ISBN, book_title, author_name, genre_name, book_publisher, book_publication_date, book_status, aisle_number, shelf_number FROM book " +
 		                                "ORDER BY book_title ASC;";
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
 		      
  		     table.getColumnModel().getColumn(0).setMinWidth(100);
  		     table.getColumnModel().getColumn(0).setMaxWidth(100);
  		     
  		     table.getColumnModel().getColumn(1).setMinWidth(130);
  		     table.getColumnModel().getColumn(1).setMaxWidth(145);
  		     
  		     table.getColumnModel().getColumn(4).setMinWidth(120);
  		     table.getColumnModel().getColumn(4).setMaxWidth(120); 
  		     
  		     table.getColumnModel().getColumn(6).setMinWidth(140);
  		     table.getColumnModel().getColumn(6).setMaxWidth(140); 
  		     
  		     table.getColumnModel().getColumn(7).setMinWidth(100);
  		     table.getColumnModel().getColumn(7).setMaxWidth(100); 
  		     
  		     table.getColumnModel().getColumn(8).setMinWidth(80);
  		     table.getColumnModel().getColumn(8).setMaxWidth(80); 
  		     
  		     table.getColumnModel().getColumn(9).setMinWidth(80);
  		     table.getColumnModel().getColumn(9).setMaxWidth(80);
 		      // Close the database connection
 		     resultSet.close();
 		     statement.close();
 		     connection.close();
 		     } catch (SQLException e1) {
 		              e1.printStackTrace();
 		     }
    	}
    });
	btnAdd.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		AdminAddBookPanel panel = new AdminAddBookPanel();
    		showDialog(panel);
    	}
    });
		
 }
 public class headerRenderer implements TableCellRenderer {
		@Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
		        JTableHeader header = table.getTableHeader();
		        JLabel label = new JLabel(value.toString());
		        label.setOpaque(false);
		        label.setFont(header.getFont());
		        label.setBackground(new Color(0, 0, 0, 0)); 
		        label.setForeground(header.getForeground());
		        label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		        return label;
		    }
		}

@Override
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	    /*
	    * use super.paintComponent(g) for proper rendering 
	    * of components 
	    */
}

//Methods
	public String searchQuery(String search) {
		 String query = "SELECT book_id, ISBN, book_title, author_name, genre_name, book_publisher, book_publication_date, book_status, aisle_number, shelf_number FROM book " +
	            "WHERE book_title LIKE '" + search + "%' OR " +
	            "author_name LIKE '" + search + "%' OR " +
	            "genre_name LIKE '%" + search + "%' OR " +
	            "book_publisher LIKE '" + search + "%' OR " +
	            "ISBN LIKE '" + search + "%'";      
		return query;
	}
	//Methods
	// Overload Method showDialog
	public void showDialog(AdminAddBookPanel panel) {
		
		panel.getBtnBack().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	    	}
	    });
	    
		JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Success", true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

	}
	public void showDialog(AdminBookInfoPanel panel) {
		
		panel.getBtnBack().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	    	}
	    });
	    
		JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Success", true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

	}
	//Method used by showDialog to close the JDialog containing the alert panels
	private void closeDialog(ActionEvent e) {
        Component component = (Component) e.getSource();
        Window window = SwingUtilities.getWindowAncestor(component);
        if (window != null) {
            window.dispose();
        }
    }
	private void displayAllBooks() {
	    try {
	    	searchScrollPane.setViewportView(table);
	        // Establish database connection
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	        String getQuery = "SELECT book_id, ISBN, book_title, author_name, genre_name, book_publisher, book_publication_date, book_status, aisle_number, shelf_number FROM book " +
	                "ORDER BY book_title ASC;";

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
	        table.getColumnModel().getColumn(0).setMinWidth(100);
 		    table.getColumnModel().getColumn(0).setMaxWidth(100);
 		     
 		    table.getColumnModel().getColumn(1).setMinWidth(130);
 		    table.getColumnModel().getColumn(1).setMaxWidth(145);
 		     
 		    table.getColumnModel().getColumn(4).setMinWidth(120);
 		    table.getColumnModel().getColumn(4).setMaxWidth(120); 
 		     
 		    table.getColumnModel().getColumn(6).setMinWidth(140);
 		    table.getColumnModel().getColumn(6).setMaxWidth(140); 
 		     
 		    table.getColumnModel().getColumn(7).setMinWidth(100);
 		    table.getColumnModel().getColumn(7).setMaxWidth(100); 
 		     
 		    table.getColumnModel().getColumn(8).setMinWidth(80);
 		    table.getColumnModel().getColumn(8).setMaxWidth(80); 
 		     
 		    table.getColumnModel().getColumn(9).setMinWidth(80);
 		    table.getColumnModel().getColumn(9).setMaxWidth(80);

	        // Close the database connection
	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
//	public Book getBook() {
//		return selectedBook;
//	}
}