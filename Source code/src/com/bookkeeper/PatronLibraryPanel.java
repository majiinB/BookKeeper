package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;

public class PatronLibraryPanel extends JPanel {
	//panel
	private JPanel mainPanel;
//	private BackgroundPanel mainPanel;
//	private BackgroundPanel triangleBackground;
	private JPanel contentPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private RoundedPanel searchBarPanel;
	private RoundedPanel searchResultsPanel;

	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	private JTextArea txtTitle;
	
	//textfield
	private PlaceholderTextField txtSearchBar;
	
	//icon
	private ImageIcon searchIcon;
	private Image searchImage;
	private int iconHeight; 
	private int iconWidth;
	//button
	private JButton btnSearch;
	
	//scroll
	private JScrollPane  searchScrollPane;
	
	//table
	private PlaceholderTable bookListTable;
	
	//layout
	private GridBagLayout gbl_contentPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_searchBarPanel;
	private GridBagConstraints gbc_searchResultsPanel;
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
	
	private  Color headerColor = new Color(23, 21, 147);
	private  Color darkplainColor = new Color(14, 14, 15);
	private  Color lightplainColor = new Color(250, 251, 255);
 public PatronLibraryPanel() {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(10, 10, 10, 10));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();
	mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
//	mainPanel = new BackgroundPanel();
	contentPanel = new JPanel();
	headingPanel = new JPanel();
    titlePanel = new JPanel();
    searchBarPanel =  new RoundedPanel(20);
    searchBarPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
    searchResultsPanel =  new RoundedPanel(20);

    // Set panel properties
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    contentPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    searchBarPanel.setOpaque(true);
    searchResultsPanel.setOpaque(true);

    searchBarPanel.setBorderWidth(2);
    searchResultsPanel.setBorderWidth(2);
    searchBarPanel.setForeground(darkplainColor);
    searchResultsPanel.setForeground(darkplainColor);
    searchBarPanel.setBackground(lightplainColor);
    searchResultsPanel.setBackground(lightplainColor);

    lblHeading1 = new JLabel("Dashboard ");
    lblHeading1.setOpaque(false);
    
    lblHeading2 = new JLabel("/ Library");
    lblHeading2.setOpaque(false);
    
    txtTitle = new JTextArea("Explore the World of Books with Book Keeper.");
    txtTitle.setForeground(headerColor);
    txtTitle.setLineWrap(true);
    txtTitle.setOpaque(false);
    txtTitle.setWrapStyleWord(true);
    txtTitle.setFocusable(false);
    txtTitle.setEditable(false);
    txtTitle.setDragEnabled(false);
    txtTitle.setAutoscrolls(false);

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


    bookListTable = new PlaceholderTable();
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
    gbl_contentPanel = new GridBagLayout();
    gbl_contentPanel.columnWidths = new int[]{380, 0};
    gbl_contentPanel.rowHeights = new int[]{33, 30, 46, 0};
    gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
   
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.WEST;
    gbc_headingPanel.insets = new Insets(0, 0, 0, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;    
	
	gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_titlePanel.insets = new Insets(15, 0, 25, 0);
    gbc_titlePanel.gridx = 0;
	gbc_titlePanel.gridy = 1;
	
    gbc_searchBarPanel = new GridBagConstraints();
    gbc_searchBarPanel.fill = GridBagConstraints.BOTH;
    gbc_searchBarPanel.insets = new Insets(0, 0, 10, 0);
    gbc_searchBarPanel.gridx = 0;
    gbc_searchBarPanel.gridy = 2;
    
    gbc_searchResultsPanel = new GridBagConstraints();
    gbc_searchResultsPanel.fill = GridBagConstraints.BOTH;
    gbc_searchResultsPanel.gridx = 0;
    gbc_searchResultsPanel.gridy = 3;
    
	
	// Set panel layouts
    mainPanel.setLayout(new BorderLayout(0,0));
    contentPanel.setLayout(gbl_contentPanel);
    titlePanel.setLayout(new BorderLayout(0, 0));
    searchBarPanel.setLayout(new BorderLayout(0, 0));
    headingPanel.setLayout(new FlowLayout());

    //Add all to main panel
    headingPanel.add(lblHeading1);
    headingPanel.add(lblHeading2);
    titlePanel.add(txtTitle);
    searchBarPanel.add(btnSearch,BorderLayout.WEST);
    searchBarPanel.add(txtSearchBar,BorderLayout.CENTER);

    contentPanel.add(headingPanel,gbc_headingPanel);
    contentPanel.add(titlePanel,gbc_titlePanel);
    contentPanel.add(searchBarPanel,gbc_searchBarPanel);
    contentPanel.add(searchResultsPanel,gbc_searchResultsPanel);
    
    mainPanel.add(contentPanel, BorderLayout.CENTER);

	add(mainPanel, BorderLayout.CENTER);
	
	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;//Size after search button is pressed
	    	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;//Size after search button is pressed
//	        subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
	        buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
//			plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 60);
	            
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
	        txtTitle.setFont(titleFont);
//			.setFont(titleFont);
	            
//			subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	            
//	        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	            
//	     	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
//			btnBack.setFont(headerFont);
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
	            
//			plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
        }
    });
 }
	
public class BackgroundPanel extends JPanel {
	//background
	private Image backgroundImage;
	
	
	public BackgroundPanel() {
		backgroundImage = new ImageIcon("img/DashboardFrame/Triangles_Library.png").getImage();
	}
	
//put image over panel
	 @Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
	    * use super.paintComponent(g) for proper rendering 
	    * ng mga components sa taas ng bg image 
	    * ng d nasisira ni custom drawing 
	    */
	    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
	    /* dis ^^ da custom drawing, s-start nya ilagay si bg from coordinate 0,0 
	    * hanggang sa ma-cover nya  buong panel
	    */
	 }
	    
}  
}
