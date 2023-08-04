package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class AdminUpdateBookPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel detailPanel;
	private JPanel buttonPanel;

	//icon
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private int iconHeight; 
	private int iconWidth;
	
	//label
	private JLabel lblHeading;
	private JLabel lblBookTitle;
	private JLabel lblBookAuthor;
	private JLabel lblBookISBN;
	private JLabel lblBookPublisher;
	private JLabel lblBookGenre;
	private JLabel lblBookAvail;
	private JLabel lblBookPublication;
	private JLabel lblBookAisleNo;
	private JLabel lblBookShelfNo;

	
	//textfield
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;
	
	private PlaceholderTextField txtBookTitle;
	private PlaceholderTextField txtBookAuthor;
	private PlaceholderTextField txtBookISBN;
	private PlaceholderTextField txtBookPublisher;
	private PlaceholderTextField txtBookPublication;
	private PlaceholderTextField txtBookShelfNo;
	private PlaceholderTextField txtBookAisleNo;

	//Drop list
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxAvail;
	
	//button
	private JButton btnAdd;
	private JButton btnBack;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_detailPanel;
	private GridBagConstraints gbc_buttonPanel;
	
	private GridBagLayout gbl_titlePanel; 
	private GridBagConstraints gbc_txtTitle;
	private GridBagConstraints gbc_txtDescription;
	
	private GridBagLayout gbl_detailPanel;
	private GridBagConstraints gbc_lblBookTitle;
	private GridBagConstraints gbc_txtBookTitle;
	private GridBagConstraints gbc_lblBookAuthor;
	private GridBagConstraints gbc_txtBookAuthor;
	private GridBagConstraints gbc_lblBookISBN;
	private GridBagConstraints gbc_txtBookISBN;
	private GridBagConstraints gbc_lblBookPublisher;
	private GridBagConstraints gbc_txtBookPublisher;
	private GridBagConstraints gbc_lblBookGenre;
	private GridBagConstraints gbc_comboBoxGenre;
	private GridBagConstraints gbc_lblBookAvail;
	private GridBagConstraints gbc_comboBoxAvail;
	private GridBagConstraints gbc_lblBookPublication;
	private GridBagConstraints gbc_txtBookPublication;
	private GridBagConstraints gbc_lblBookAisleNo;
	private GridBagConstraints gbc_txtBookAisleNo;
	private GridBagConstraints gbc_lblBookShelfNo;
	private GridBagConstraints gbc_txtBookShelfNo;

	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font bookTitleFont;
	private  Font buttonFont;
	private  Font headerFont;
	private  Font plainFont;
		
	private  int buttonTextSize;
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int bookTitleTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white

	public AdminUpdateBookPanel() {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
	    detailPanel = new JPanel();
	    buttonPanel = new JPanel();

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
	    detailPanel.setOpaque(false);
 
	    icon = new ImageIcon("img/Logo_Blue.png");
	    image = icon.getImage();
	    
	    lblHeading = new JLabel();
	    lblHeading.setIconTextGap(20);
	    lblHeading.setFocusable(false);
	    lblHeading.setForeground(headerColor);
	    lblHeading.setText("Book Keeper");
	    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
	  
	    btnBack = new JButton("Back");
	    btnBack.setFocusPainted(false);
	    btnBack.setForeground(new Color(23, 21, 147));
	    btnBack.setBorderPainted(false);
	    btnBack.setBorder(new EmptyBorder(5, 5, 5, 5));
	    btnBack.setOpaque(false);

	    txtTitle = new JTextArea("Update Book Information");
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    
	    txtDescription = new JTextArea("To modify the book details, please provide the necessary information.");
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
		
		lblBookTitle = new JLabel("Title:");
	    lblBookTitle.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookTitle.setBorder(null);
	    lblBookTitle.setOpaque(false);
	    lblBookTitle.setForeground(headerColor);
	    
	    txtBookTitle = new PlaceholderTextField("Title of the Book");
	    txtBookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookTitle.setForeground(darkplainColor);
	    txtBookTitle.setBackground(middleplainColor);
	    txtBookTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookTitle.setOpaque(true);
	    txtBookTitle.setFocusable(true);
	    txtBookTitle.setEditable(true);
	    txtBookTitle.setDragEnabled(false);
	    
	    lblBookAuthor = new JLabel("Author:");
	    lblBookAuthor.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAuthor.setForeground(darkplainColor);
	    
	    txtBookAuthor = new PlaceholderTextField("First Name Last Name");
	    txtBookAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAuthor.setForeground(darkplainColor);
	    txtBookAuthor.setBackground(middleplainColor);
	    txtBookAuthor.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookAuthor.setOpaque(true);
	    txtBookAuthor.setFocusable(true);
	    txtBookAuthor.setEditable(true);
	    txtBookAuthor.setDragEnabled(false);
	    
	    lblBookISBN = new JLabel("ISBN:");
	    lblBookISBN.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookISBN.setForeground(darkplainColor);
	    
	    txtBookISBN = new PlaceholderTextField("ISBN Number");
	    txtBookISBN.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookISBN.setForeground(darkplainColor);
	    txtBookISBN.setBackground(middleplainColor);
	    txtBookISBN.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookISBN.setOpaque(true);
	    txtBookISBN.setFocusable(true);
	    txtBookISBN.setEditable(true);
	    txtBookISBN.setDragEnabled(false);
	    
	    lblBookPublisher = new JLabel("Publisher:");
	    lblBookPublisher.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookPublisher.setForeground(darkplainColor);
	    
	    txtBookPublisher = new PlaceholderTextField("Name");
	    txtBookPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookPublisher.setForeground(darkplainColor);
	    txtBookPublisher.setBackground(middleplainColor);
	    txtBookPublisher.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookPublisher.setOpaque(true);
	    txtBookPublisher.setFocusable(true);
	    txtBookPublisher.setEditable(true);
	    txtBookPublisher.setDragEnabled(false);
	    
	    lblBookGenre = new JLabel("Genre:");
	    lblBookGenre.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookGenre.setForeground(darkplainColor);
	    lblBookGenre.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lblBookGenre = new JLabel("Genre:");
	    lblBookGenre.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookGenre.setForeground(darkplainColor);
	    lblBookGenre.setBorder(new EmptyBorder(10, 10, 10, 10));

	    String genre[]={"Fiction","Mystery","Fantasy","Science Fiction","Horror", "Romance", "Non-Fiction"};   
	    comboBoxGenre = new JComboBox(genre);
	    comboBoxGenre.setBackground(middleplainColor);
	    comboBoxGenre.setOpaque(true);
	    comboBoxGenre.setFocusable(false);
	    comboBoxGenre.setBorder(null);
	    comboBoxGenre.setEditable(false);
	    
	    lblBookAvail = new JLabel("Availability:");
	    lblBookAvail.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAvail.setBorder(null);
	    lblBookAvail.setForeground(darkplainColor);
	    lblBookAvail.setBorder(new EmptyBorder(10, 10, 10, 10));

	    String avail[]={"Available", "Unavailable", "Borrowed"};   
	    comboBoxAvail = new JComboBox(avail);
	    comboBoxAvail.setBackground(middleplainColor);
	    comboBoxAvail.setOpaque(true);
	    comboBoxAvail.setFocusable(false);
	    comboBoxAvail.setBorder(null);
	    comboBoxAvail.setEditable(false);
	    
	    lblBookPublication = new JLabel("Publication Date:");
	    lblBookPublication.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookPublication.setBorder(null);
	    lblBookPublication.setForeground(darkplainColor);
	    
	    txtBookPublication = new PlaceholderTextField("yyyy-mm-dd");
	    txtBookPublication.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookPublication.setForeground(darkplainColor);
	    txtBookPublication.setBackground(middleplainColor);
	    txtBookPublication.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookPublication.setOpaque(true);
	    txtBookPublication.setFocusable(true);
	    txtBookPublication.setEditable(true);
	    txtBookPublication.setDragEnabled(false);
	    
	    lblBookAisleNo = new JLabel("Aisle Number:");
	    lblBookAisleNo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAisleNo.setForeground(darkplainColor);

	    txtBookAisleNo = new PlaceholderTextField("000");
	    txtBookAisleNo.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAisleNo.setForeground(darkplainColor);
	    txtBookAisleNo.setBackground(middleplainColor);
	    txtBookAisleNo.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookAisleNo.setOpaque(true);
	    txtBookAisleNo.setFocusable(true);
	    txtBookAisleNo.setEditable(true);
	    txtBookAisleNo.setDragEnabled(false);

	    lblBookShelfNo = new JLabel("Shelf Number:");
	    lblBookShelfNo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookShelfNo.setForeground(darkplainColor);

	    txtBookShelfNo = new PlaceholderTextField("000");
	    txtBookShelfNo.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookShelfNo.setForeground(darkplainColor);
	    txtBookShelfNo.setBackground(middleplainColor);
	    txtBookShelfNo.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtBookShelfNo.setOpaque(true);
	    txtBookShelfNo.setFocusable(true);
	    txtBookShelfNo.setEditable(true);
	    txtBookShelfNo.setDragEnabled(false);
	    
	    btnAdd = new JButton();
	    btnAdd.setText("Save Changes");
	    btnAdd.setMnemonic(KeyEvent.VK_ENTER);
	    btnAdd.setForeground(lightplainColor);
	    btnAdd.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnAdd.setOpaque(true);
	    btnAdd.setFocusPainted(false);
	    btnAdd.setBorderPainted(false);
	    btnAdd.setBackground(headerColor);
	    
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
	    gbl_mainPanel = new GridBagLayout();
	    gbl_mainPanel.columnWidths = new int[]{865};
	    gbl_mainPanel.rowHeights = new int[]{35, 0, 0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_headingPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;
	    
	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.anchor = GridBagConstraints.SOUTH;
	    gbc_titlePanel.fill = GridBagConstraints.BOTH;	    
	    gbc_titlePanel.insets = new Insets(20, 20, 20, 20);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;
	    
	    gbc_detailPanel = new GridBagConstraints();
	    gbc_detailPanel.anchor = GridBagConstraints.NORTH;
	    gbc_detailPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_detailPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_detailPanel.gridx = 0;
	    gbc_detailPanel.gridy = 2;
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_buttonPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 3;	 
	    
	    // TITLE AND DESCRIPTION
	    gbl_titlePanel = new GridBagLayout();
	    gbl_titlePanel.columnWidths = new int[]{865};
	    gbl_titlePanel.rowHeights = new int[]{35, 0};
	    gbl_titlePanel.columnWeights = new double[]{1.0};
	    gbl_titlePanel.rowWeights = new double[]{0.0, 1.0,};
	    
	    gbc_txtTitle = new GridBagConstraints();
	    gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_txtTitle.insets = new Insets(0, 0, 0, 0);
	    gbc_txtTitle.gridx = 0;
	    gbc_txtTitle.gridy = 0;
	    
	    gbc_txtDescription = new GridBagConstraints();
	    gbc_txtDescription.fill = GridBagConstraints.BOTH;	    
	    gbc_txtDescription.insets = new Insets(0,0,0,0);
	    gbc_txtDescription.gridx = 0;
	    gbc_txtDescription.gridy = 1;
	    
	    
	    // LAYOUT FOR THE COMPONENTS INSIDE DETAIL PANEL
	    gbl_detailPanel = new GridBagLayout();
	    gbl_detailPanel.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_detailPanel.rowHeights = new int[]{0, 0, 0, 0, 0 ,0, 0};
	    gbl_detailPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0};
	    gbl_detailPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	    
	    gbc_lblBookTitle = new GridBagConstraints();
	    gbc_lblBookTitle.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblBookTitle.insets = new Insets(0,0,20,10);
	    gbc_lblBookTitle.gridx = 0; //columns
	    gbc_lblBookTitle.gridy = 0; //rows
	    gbc_lblBookTitle.gridwidth = 1;
	    
	    gbc_txtBookTitle = new GridBagConstraints();
	    gbc_txtBookTitle.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookTitle.insets = new Insets(0,0,20,0);
	    gbc_txtBookTitle.gridx = 1;
	    gbc_txtBookTitle.gridy = 0;
	    gbc_txtBookTitle.gridwidth = 3;

	    gbc_lblBookAuthor = new GridBagConstraints();
	    gbc_lblBookAuthor.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookAuthor.insets = new Insets(0,0,20,10);
	    gbc_lblBookAuthor.gridx = 0; //columns
	    gbc_lblBookAuthor.gridy = 1; //rows
	    gbc_lblBookAuthor.gridwidth = 1;
	    
	    gbc_txtBookAuthor = new GridBagConstraints();
	    gbc_txtBookAuthor.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookAuthor.insets = new Insets(0,0,20,0);
	    gbc_txtBookAuthor.gridx = 1;
	    gbc_txtBookAuthor.gridy = 1;
	    gbc_txtBookAuthor.gridwidth = 3;
	    
	    gbc_lblBookISBN = new GridBagConstraints();
	    gbc_lblBookISBN.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookISBN.insets = new Insets(0,0,20,10);
	    gbc_lblBookISBN.gridx = 0; //columns
	    gbc_lblBookISBN.gridy = 2; //rows
	    gbc_lblBookISBN.gridwidth = 1;
	    
	    gbc_txtBookISBN = new GridBagConstraints();
	    gbc_txtBookISBN.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookISBN.insets = new Insets(0,0,20,0);
	    gbc_txtBookISBN.gridx = 1;
	    gbc_txtBookISBN.gridy = 2;
	    gbc_txtBookISBN.gridwidth = 3;
	    
	    gbc_lblBookPublisher = new GridBagConstraints();
	    gbc_lblBookPublisher.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookPublisher.insets = new Insets(0,0,20,10);
	    gbc_lblBookPublisher.gridx = 0; //columns
	    gbc_lblBookPublisher.gridy = 3; //rows
	    gbc_lblBookPublisher.gridwidth = 1;
	    
	    gbc_txtBookPublisher = new GridBagConstraints();
	    gbc_txtBookPublisher.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookPublisher.insets = new Insets(0,0,20,0);
	    gbc_txtBookPublisher.gridx = 1; 
	    gbc_txtBookPublisher.gridy = 3;
	    gbc_txtBookPublisher.gridwidth = 3;
	    
	    gbc_lblBookGenre = new GridBagConstraints();
	    gbc_lblBookGenre.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookGenre.insets = new Insets(0,0,20,10);
	    gbc_lblBookGenre.gridx = 0; //columns
	    gbc_lblBookGenre.gridy = 4; //rows
	    
	    gbc_comboBoxGenre = new GridBagConstraints();
	    gbc_comboBoxGenre.fill = GridBagConstraints.BOTH;	    
	    gbc_comboBoxGenre.insets = new Insets(0,0,20,0);
	    gbc_comboBoxGenre.gridx = 1;
	    gbc_comboBoxGenre.gridy = 4;
	    
	    gbc_lblBookAvail = new GridBagConstraints();
	    gbc_lblBookAvail.anchor = GridBagConstraints.EAST;
	    gbc_lblBookAvail.fill = GridBagConstraints.VERTICAL;	    
	    gbc_lblBookAvail.insets = new Insets(0,20,20,10);
	    gbc_lblBookAvail.gridx = 2; //columns
	    gbc_lblBookAvail.gridy = 4; //rows
	    
	    gbc_comboBoxAvail = new GridBagConstraints();
	    gbc_comboBoxAvail.fill = GridBagConstraints.BOTH;	    
	    gbc_comboBoxAvail.insets = new Insets(0,0,20,0);
	    gbc_comboBoxAvail.gridx = 3;
	    gbc_comboBoxAvail.gridy = 4;
	    
	    gbc_lblBookPublication = new GridBagConstraints();
	    gbc_lblBookPublication.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookPublication.insets = new Insets(0,0,20,10);
	    gbc_lblBookPublication.gridx = 0; //columns
	    gbc_lblBookPublication.gridy = 5; //rows
	    
	    gbc_txtBookPublication = new GridBagConstraints();
	    gbc_txtBookPublication.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookPublication.insets = new Insets(0,0,20,0);
	    gbc_txtBookPublication.gridx = 1;
	    gbc_txtBookPublication.gridy = 5;
	    gbc_txtBookPublication.gridwidth = 3;
	    
	    gbc_lblBookAisleNo = new GridBagConstraints();
	    gbc_lblBookAisleNo.fill = GridBagConstraints.BOTH;	    
	    gbc_lblBookAisleNo.insets = new Insets(0,0,0,10);
	    gbc_lblBookAisleNo.gridx = 0; //columns
	    gbc_lblBookAisleNo.gridy = 6; //rows
	    
	    gbc_txtBookAisleNo = new GridBagConstraints();
	    gbc_txtBookAisleNo.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookAisleNo.insets = new Insets(0,0,0,0);
	    gbc_txtBookAisleNo.gridx = 1;
	    gbc_txtBookAisleNo.gridy = 6;
	    
	    gbc_lblBookShelfNo = new GridBagConstraints();
	    gbc_lblBookShelfNo.anchor = GridBagConstraints.EAST;
	    gbc_lblBookShelfNo.fill = GridBagConstraints.VERTICAL;	    
	    gbc_lblBookShelfNo.insets = new Insets(0,20,0,10);
	    gbc_lblBookShelfNo.gridx = 2; //columns
	    gbc_lblBookShelfNo.gridy = 6; //rows
	    
	    gbc_txtBookShelfNo = new GridBagConstraints();
	    gbc_txtBookShelfNo.fill = GridBagConstraints.BOTH;	    
	    gbc_txtBookShelfNo.insets = new Insets(0,0,0,0);
	    gbc_txtBookShelfNo.gridx = 3;
	    gbc_txtBookShelfNo.gridy = 6;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(gbl_titlePanel); 
	    buttonPanel.setLayout(new BorderLayout(0,0));
	    detailPanel.setLayout(gbl_detailPanel);

	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);
	    
	    titlePanel.add(txtTitle,gbc_txtTitle);
	    titlePanel.add(txtDescription,gbc_txtDescription);
	    
	    detailPanel.add(lblBookTitle,gbc_lblBookTitle);
	    detailPanel.add(txtBookTitle, gbc_txtBookTitle);
	    detailPanel.add(lblBookAuthor, gbc_lblBookAuthor);
	    detailPanel.add(txtBookAuthor, gbc_txtBookAuthor);
	    detailPanel.add(lblBookISBN, gbc_lblBookISBN);
	    detailPanel.add(txtBookISBN, gbc_txtBookISBN);
	    detailPanel.add(lblBookPublisher, gbc_lblBookPublisher);
	    detailPanel.add(txtBookPublisher, gbc_txtBookPublisher);
	    detailPanel.add(lblBookGenre, gbc_lblBookGenre);
	    detailPanel.add(comboBoxGenre, gbc_comboBoxGenre);
	    detailPanel.add(lblBookAvail, gbc_lblBookAvail);
	    detailPanel.add(comboBoxAvail, gbc_comboBoxAvail);
	    detailPanel.add(lblBookPublication, gbc_lblBookPublication);
	    detailPanel.add(txtBookPublication, gbc_txtBookPublication);
	    detailPanel.add(lblBookAisleNo, gbc_lblBookAisleNo);
	    detailPanel.add(txtBookAisleNo, gbc_txtBookAisleNo);
	    detailPanel.add(lblBookShelfNo, gbc_lblBookShelfNo);
	    detailPanel.add(txtBookShelfNo, gbc_txtBookShelfNo);    
	    
	    buttonPanel.add(btnAdd);
	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(detailPanel, gbc_detailPanel);
	    mainPanel.add(buttonPanel, gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	          	
	    		  	titleTextSize = Math.min(getHeight() / 10, getWidth()/ 15) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 50);
	  	            bookTitleTextSize =  Math.min(getHeight() / 15, getWidth()/ 30);
	  	            buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
	  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
	  	            
	  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);	  	            
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize); 	          
	  	            bookTitleFont = new Font("Montserrat", Font.BOLD, bookTitleTextSize);
	  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);	  	          
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);	  	         
	  	            plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
	  	            
	  	            txtTitle.setFont(titleFont);
	  	            txtDescription.setFont(subtitleFont);
	  	           	lblBookTitle.setFont(bookTitleFont);
	  	           	btnAdd.setFont(buttonFont);
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);  	            
	  	            lblBookAuthor.setFont(plainFont);
	  	            lblBookISBN.setFont(plainFont);
		  	        lblBookPublisher.setFont(plainFont);
	  	            lblBookGenre.setFont(plainFont);
		  	        comboBoxGenre.setFont(plainFont);
		  	        lblBookAvail .setFont(plainFont);
		  	        comboBoxAvail.setFont(plainFont);
		  	        lblBookPublication.setFont(plainFont);
		  	        lblBookAisleNo.setFont(plainFont);
	  	            lblBookShelfNo.setFont(plainFont);


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
	    iconWidth = (int) (getWidth() * 0.029);
	    iconHeight = (int) (getHeight() * 0.035);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
}