package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminManageEmployeePanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel headingPanel;
	private JPanel topPanel;
	private RoundedPanel searchBarPanel;
	private RoundedPanel addBookPanel;
	private RoundedPanel searchResultsPanel;

	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	private JTextArea txtTitle;
	
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
	private GridBagLayout gbl_contentPanel;
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

 public AdminManageEmployeePanel() {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(20, 20, 20, 20));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();
	topPanel = new JPanel();

	contentPanel = new JPanel();
	headingPanel = new JPanel();
    searchBarPanel =  new RoundedPanel(20);
    searchResultsPanel =  new RoundedPanel(20);
    addBookPanel =  new RoundedPanel(20);


    // Set panel properties
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    contentPanel.setOpaque(false);
    searchBarPanel.setOpaque(true);
    addBookPanel.setOpaque(true);
    searchResultsPanel.setOpaque(true);
	topPanel.setOpaque(false);
	topPanel.setBorder(new EmptyBorder(20, 25, 0, 25));
	contentPanel.setBorder(new EmptyBorder(15, 25, 20, 25));
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
    
    lblHeading2 = new JLabel("/ Manage Employees");
    lblHeading2.setOpaque(false);
    
    btnAdd = new JButton("Add User");
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

    
    txtSearchBar = new PlaceholderTextField("Search User");
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
    
    //listener for clicking cells in table  
	table.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) { 
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
		    // Get the values from the selected row
//		    int bookId = (int) table.getValueAt(selectedRow, 0);
//		    String ISBN = (String) table.getValueAt(selectedRow, 1);
//		    String bookTitle = (String) table.getValueAt(selectedRow, 2);
//		    String authorName = (String) table.getValueAt(selectedRow, 3);
//		    String genreName = (String) table.getValueAt(selectedRow, 4);
//		    String bookPublisher = (String) table.getValueAt(selectedRow, 5);
//		    java.sql.Date date = (java.sql.Date) table.getValueAt(selectedRow, 6);
//		    String bookPublishDate = date.toString();
//		    String bookStatus = (String) table.getValueAt(selectedRow, 7);
//		    int aisleNumber = (int) table.getValueAt(selectedRow, 8);
//		    int shelfNumber = (int) table.getValueAt(selectedRow, 9);
		    //Create a Book object with the retrieved values
		    //selectedBook = new Book(bookId, bookTitle, genreName, authorName, bookPublishDate , bookPublisher, bookStatus, aisleNumber, shelfNumber, ISBN);

		    //Use the selectedBook object as needed
		    // ...

		    // Open the BookInfoFrame with the selected book
		    //BookInfoFrame frame = new BookInfoFrame(3, selectedBook, user);
		    //frame.setVisible(true);
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
    contentPanel.setLayout(new BorderLayout(0,0));
    searchBarPanel.setLayout(new BorderLayout(0, 0));
    headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.X_AXIS));
    topPanel.setLayout(gbl_topPanel);
    
    //Add all to main panel
    headingPanel.add(lblHeading1);
    headingPanel.add(lblHeading2);

    searchBarPanel.add(btnSearch,BorderLayout.WEST);
    searchBarPanel.add(txtSearchBar,BorderLayout.CENTER);

    contentPanel.add(searchResultsPanel);
    searchResultsPanel.setLayout(new BorderLayout(0, 0));

    // Add the scroll pane to the searchResultsPanel
    searchResultsPanel.add(searchScrollPane);
    addBookPanel.setLayout(new BorderLayout(0, 0));
    
   
//	displayAllBooks();
    
    addBookPanel.add(btnAdd);    
    topPanel.add(headingPanel,gbc_headingPanel);
    topPanel.add(searchBarPanel,gbc_searchBarPanel);
    topPanel.add(addBookPanel,gbc_addBookPanel);
    
    mainPanel.add(contentPanel, BorderLayout.CENTER);
    
	add(topPanel, BorderLayout.NORTH);
	add(mainPanel, BorderLayout.CENTER);
	
	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;
	        subtitleTextSize =  Math.min(getHeight() / 40, getWidth()/ 40);
	        buttonTextSize =  Math.min(getHeight() / 80, getWidth()/ 80);
	        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
	        plainTextsize=   Math.min(getHeight() / 70, getWidth()/ 70);
	            
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
			subtitleFont = new Font("Montserrat", Font.BOLD, subtitleTextSize);
	        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	     	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
			plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
			
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));	            	            
	            
			btnAdd.setFont(buttonFont);
	     	table.setFont(plainFont);

	            
        }
    });
	
	// Action Listener
	btnSearch.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
	btnAdd.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
		
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


}