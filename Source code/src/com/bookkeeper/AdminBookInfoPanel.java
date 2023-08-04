package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class AdminBookInfoPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel detailPanel;
	private JPanel buttonPanel;
	
	private JPanel bookTitlePanel;
	private JPanel authorPanel;
	private JPanel isbnPanel;
	private JPanel publisherPanel;
	private JPanel publicationPanel;
	private JPanel genrePanel;
	private JPanel shelfNoPanel;
	private JPanel aisleNoPanel;
	private JPanel availabilityPanel;
	
	private JPanel bookLocationPanel;
	
	private JPanel borrowerInfoPanel;
	private JPanel patronIdPanel;
	private JPanel dateLoanedPanel;
	private JPanel dateDuePanel;
	private JPanel contactNumberPanel;
	private JPanel emailAssPanel;

	//icon
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private int iconHeight; 
	private int iconWidth;
	
	//label
	private JLabel lblHeading;
	
	private JLabel lblBookAuthor;
	private JLabel lblBookTitle;
	private JLabel lblBookISBN;
	private JLabel lblBookPublisher;
	private JLabel lblBookPublicationDate;
	private JLabel lblBookGenre;
	private JLabel lblBookShelfNo;
	private JLabel lblBookAisleNo;
	private JLabel lblBookAvail;
	
	private JLabel lblBorrowerInfo;
	private JLabel lblPatronID;
	private JLabel lblDateLoaned;
	private JLabel lblDateDue;
	private JLabel lblContactNumber;
	private JLabel lblEmailAdd;
	
	//textfield
	private PlaceholderTextField txtBookTitle;
	private PlaceholderTextField txtBookAuthor;
	private PlaceholderTextField txtBookISBN;
	private PlaceholderTextField txtBookPublisher;
	private PlaceholderTextField txtBookPublicationDate;
	private PlaceholderTextField txtBookGenre;
	private PlaceholderTextField txtBookShelfNo;
	private PlaceholderTextField txtBookAisleNo;
	private PlaceholderTextField txtBookAvail;

	private PlaceholderTextField txtPatronID;
	private PlaceholderTextField txtDateLoaned;
	private PlaceholderTextField txtDateDue;
	private PlaceholderTextField txtContactNumber;
	private PlaceholderTextField txtEmailAdd;
	
	//button
	private JButton btnBorrow;
	private JButton btnReturn;
	private JButton btnEdit;
	private JButton btnBack;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagConstraints gbc_detailPanel;
	
	private GridBagLayout gbl_bookLocationPanel;
	private GridBagConstraints gbc_shelfNoPanel;
	private GridBagConstraints gbc_aisleNoPanel;
	private GridBagConstraints gbc_availabilityPanel;

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

	public AdminBookInfoPanel(Book selectedBook) {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    detailPanel = new JPanel();
	    buttonPanel = new JPanel();
	    
	    bookTitlePanel = new JPanel();
		authorPanel = new JPanel();
		isbnPanel = new JPanel();
		genrePanel = new JPanel();
		publisherPanel = new JPanel();
		publicationPanel = new JPanel();
		availabilityPanel = new JPanel();
		shelfNoPanel = new JPanel();
		aisleNoPanel = new JPanel();
		
		bookLocationPanel = new JPanel();
		
		borrowerInfoPanel = new JPanel();
		patronIdPanel = new JPanel();
		dateLoanedPanel = new JPanel();
		dateDuePanel = new JPanel();
		contactNumberPanel = new JPanel();
		emailAssPanel = new JPanel();

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    detailPanel.setOpaque(false);
	    bookTitlePanel.setOpaque(false);
		authorPanel.setOpaque(false);;
		isbnPanel.setOpaque(false);
		genrePanel.setOpaque(false);
		publisherPanel.setOpaque(false);
		publicationPanel.setOpaque(false);
		availabilityPanel.setOpaque(false);
		shelfNoPanel.setOpaque(false);
		aisleNoPanel.setOpaque(false);
		bookLocationPanel.setOpaque(false);;
		borrowerInfoPanel.setOpaque(false);
		patronIdPanel.setOpaque(false);
		dateLoanedPanel.setOpaque(false);
		dateDuePanel.setOpaque(false);
		contactNumberPanel.setOpaque(false);
		emailAssPanel.setOpaque(false);
	    
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

	    lblBookTitle = new JLabel("Title:");
	    lblBookTitle.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookTitle.setBorder(null);
	    lblBookTitle.setForeground(headerColor);
	    
	    txtBookTitle = new PlaceholderTextField("Title of the Book");
	    txtBookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookTitle.setForeground(headerColor);
	    txtBookTitle.setOpaque(false);
	    txtBookTitle.setFocusable(false);
	    txtBookTitle.setBorder(null);
	    txtBookTitle.setEditable(false);
	    txtBookTitle.setDragEnabled(false);
	    
	    lblBookAuthor = new JLabel("Author:");
	    lblBookAuthor.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAuthor.setBorder(null);
	    lblBookAuthor.setForeground(darkplainColor);
	    
	    txtBookAuthor = new PlaceholderTextField("First Name Last Name");
	    txtBookAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAuthor.setForeground(darkplainColor);
	    txtBookAuthor.setOpaque(false);
	    txtBookAuthor.setFocusable(false);
	    txtBookAuthor.setBorder(null);
	    txtBookAuthor.setEditable(false);
	    txtBookAuthor.setDragEnabled(false);
	    
	    lblBookISBN = new JLabel("ISBN:");
	    lblBookISBN.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookISBN.setBorder(null);
	    lblBookISBN.setForeground(darkplainColor);
	    
	    txtBookISBN = new PlaceholderTextField("ISBN Number");
	    txtBookISBN.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookISBN.setForeground(darkplainColor);
	    txtBookISBN.setOpaque(false);
	    txtBookISBN.setFocusable(false);
	    txtBookISBN.setBorder(null);
	    txtBookISBN.setEditable(false);
	    txtBookISBN.setDragEnabled(false);
	    
	    lblBookPublisher = new JLabel("Publisher:");
	    lblBookPublisher.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookPublisher.setBorder(null);
	    lblBookPublisher.setForeground(darkplainColor);
	    
	    txtBookPublisher = new PlaceholderTextField("Name");
	    txtBookPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookPublisher.setForeground(darkplainColor);
	    txtBookPublisher.setOpaque(false);
	    txtBookPublisher.setFocusable(false);
	    txtBookPublisher.setBorder(null);
	    txtBookPublisher.setEditable(false);
	    txtBookPublisher.setDragEnabled(false);
	    
	    lblBookPublicationDate = new JLabel("Publication Date:");
	    lblBookPublicationDate.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookPublicationDate.setBorder(null);
	    lblBookPublicationDate.setForeground(darkplainColor);
	    
	    txtBookPublicationDate = new PlaceholderTextField("yyyy-mm-dd");
	    txtBookPublicationDate.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookPublicationDate.setForeground(darkplainColor);
	    txtBookPublicationDate.setOpaque(false);
	    txtBookPublicationDate.setFocusable(false);
	    txtBookPublicationDate.setBorder(null);
	    txtBookPublicationDate.setEditable(false);
	    txtBookPublicationDate.setDragEnabled(false);
	    
	    lblBookGenre = new JLabel("Genre:");
	    lblBookGenre.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookGenre.setBorder(null);
	    lblBookGenre.setForeground(darkplainColor);
	    
	    txtBookGenre = new PlaceholderTextField("Book Genre");
	    txtBookGenre.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookGenre.setForeground(darkplainColor);
	    txtBookGenre.setOpaque(false);
	    txtBookGenre.setFocusable(false);
	    txtBookGenre.setBorder(null);
	    txtBookGenre.setEditable(false);
	    txtBookGenre.setDragEnabled(false);
	    
	    lblBookShelfNo = new JLabel("Shelf Number:");
	    lblBookShelfNo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookShelfNo.setBorder(null);
	    lblBookShelfNo.setForeground(darkplainColor);
	    
	    txtBookShelfNo = new PlaceholderTextField("000");
	    txtBookShelfNo.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookShelfNo.setForeground(darkplainColor);
	    txtBookShelfNo.setOpaque(false);
	    txtBookShelfNo.setFocusable(false);
	    txtBookShelfNo.setBorder(null);
	    txtBookShelfNo.setEditable(false);
	    txtBookShelfNo.setDragEnabled(false);
	    
	    lblBookAisleNo = new JLabel("Aisle Number:");
	    lblBookAisleNo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAisleNo.setBorder(null);
	    lblBookAisleNo.setForeground(darkplainColor);
	    
	    txtBookAisleNo  = new PlaceholderTextField("000");
	    txtBookAisleNo.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAisleNo.setForeground(darkplainColor);
	    txtBookAisleNo.setOpaque(false);
	    txtBookAisleNo.setFocusable(false);
	    txtBookAisleNo.setBorder(null);
	    txtBookAisleNo.setEditable(false);
	    txtBookAisleNo.setDragEnabled(false);
	    
	    lblBookAvail = new JLabel("Availability:");
	    lblBookAvail.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBookAvail.setBorder(null);
	    lblBookAvail.setForeground(darkplainColor);
	    
	    txtBookAvail = new PlaceholderTextField("status");
	    txtBookAvail.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAvail.setForeground(darkplainColor);
	    txtBookAvail.setOpaque(false);
	    txtBookAvail.setFocusable(false);
	    txtBookAvail.setBorder(null);
	    txtBookAvail.setEditable(false);
	    txtBookAvail.setDragEnabled(false);
	    
	    lblBorrowerInfo = new JLabel("Borrower's Information:");
	    lblBorrowerInfo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBorrowerInfo.setBorder(null);
	    lblBorrowerInfo.setForeground(headerColor);
	    
	    lblPatronID = new JLabel("Patron ID:");
	    lblPatronID.setHorizontalAlignment(SwingConstants.LEFT);
	    lblPatronID.setBorder(null);
	    lblPatronID.setForeground(darkplainColor);
	    
	    txtPatronID = new PlaceholderTextField("AAAAAAA");
	    txtPatronID.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtPatronID.setForeground(darkplainColor);
	    txtPatronID.setOpaque(false);
	    txtPatronID.setFocusable(false);
	    txtPatronID.setBorder(null);
	    txtPatronID.setEditable(false);
	    txtPatronID.setDragEnabled(false);
	    
	    lblDateLoaned = new JLabel("Date Loaned:");
	    lblDateLoaned.setHorizontalAlignment(SwingConstants.LEFT);
	    lblDateLoaned.setBorder(null);
	    lblDateLoaned.setForeground(darkplainColor);
	    
	    txtDateLoaned = new PlaceholderTextField("yyyy-mm-dd");
	    txtDateLoaned.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtDateLoaned.setForeground(darkplainColor);
	    txtDateLoaned.setOpaque(false);
	    txtDateLoaned.setFocusable(false);
	    txtDateLoaned.setBorder(null);
	    txtDateLoaned.setEditable(false);
	    txtDateLoaned.setDragEnabled(false);
	    
	    lblDateDue = new JLabel("Due Date:");
	    lblDateDue.setHorizontalAlignment(SwingConstants.LEFT);
	    lblDateDue.setBorder(null);
	    lblDateDue.setForeground(darkplainColor);
	    
	    txtDateDue = new PlaceholderTextField("yyyy-mm-dd");
	    txtDateDue.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtDateDue.setForeground(darkplainColor);
	    txtDateDue.setOpaque(false);
	    txtDateDue.setFocusable(false);
	    txtDateDue.setBorder(null);
	    txtDateDue.setEditable(false);
	    txtDateDue.setDragEnabled(false);
	    
	    lblContactNumber = new JLabel("Contact Number:");
	    lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
	    lblContactNumber.setBorder(null);
	    lblContactNumber.setForeground(darkplainColor);
	    
	    txtContactNumber = new PlaceholderTextField("0000000000000");
	    txtContactNumber.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtContactNumber.setForeground(darkplainColor);
	    txtContactNumber.setOpaque(false);
	    txtContactNumber.setFocusable(false);
	    txtContactNumber.setBorder(null);
	    txtContactNumber.setEditable(false);
	    txtContactNumber.setDragEnabled(false);
	    
	    lblEmailAdd = new JLabel("Email Addresss:");
	    lblEmailAdd.setHorizontalAlignment(SwingConstants.LEFT);
	    lblEmailAdd.setBorder(null);
	    lblEmailAdd.setForeground(darkplainColor);
	    
	    txtEmailAdd = new PlaceholderTextField("sample@email.com");
	    txtEmailAdd.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtEmailAdd.setForeground(darkplainColor);
	    txtEmailAdd.setOpaque(false);
	    txtEmailAdd.setFocusable(false);
	    txtEmailAdd.setBorder(null);
	    txtEmailAdd.setEditable(false);
	    txtEmailAdd.setDragEnabled(false);
	    
	    btnBorrow = new JButton();
	    btnBorrow.setText("Borrow");
	    btnBorrow.setForeground(lightplainColor);
	    btnBorrow.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnBorrow.setOpaque(true);
	    btnBorrow.setFocusPainted(false);
	    btnBorrow.setBorderPainted(false);
	    btnBorrow.setBackground(headerColor);
	    
	    btnReturn = new JButton();
	    btnReturn.setText("Return");
	    btnReturn.setForeground(lightplainColor);
	    btnReturn.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnReturn.setOpaque(true);
	    btnReturn.setFocusPainted(false);
	    btnReturn.setBorderPainted(false);
	    btnReturn.setBackground(headerColor);
	    
	    btnEdit = new JButton();
	    btnEdit.setText("Edit");
	    btnEdit.setForeground(lightplainColor);
	    btnEdit.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnEdit.setOpaque(true);
	    btnEdit.setFocusPainted(false);
	    btnEdit.setBorderPainted(false);
	    btnEdit.setBackground(headerColor);

	    
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
	    gbl_mainPanel.rowHeights = new int[]{35, 150, 0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_headingPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;
	    
	    gbc_detailPanel = new GridBagConstraints();
	    gbc_detailPanel.anchor = GridBagConstraints.NORTH;
	    gbc_detailPanel.fill = GridBagConstraints.HORIZONTAL;
	    gbc_detailPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_detailPanel.gridx = 0;
	    gbc_detailPanel.gridy = 1;
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_buttonPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 2;
	    
	    //
	    
	    gbl_bookLocationPanel = new GridBagLayout();
	    gbl_bookLocationPanel.columnWidths = new int[]{0, 0, 0};
	    gbl_bookLocationPanel.rowHeights = new int[]{0};
	    gbl_bookLocationPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
	    gbl_bookLocationPanel.rowWeights = new double[]{0.0};
	    
	    gbc_shelfNoPanel = new GridBagConstraints();
	    gbc_shelfNoPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_shelfNoPanel.insets = new Insets(0, 0, 0, 30);
	    gbc_shelfNoPanel.gridx = 0;
	    gbc_shelfNoPanel.gridy = 0;
	    
	    gbc_aisleNoPanel = new GridBagConstraints();
	    gbc_aisleNoPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_aisleNoPanel.insets = new Insets(0, 30, 0, 30);
	    gbc_aisleNoPanel.gridx = 1;
	    gbc_aisleNoPanel.gridy = 0;
	    
	    gbc_availabilityPanel = new GridBagConstraints();
	    gbc_availabilityPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_availabilityPanel.insets = new Insets(0,35,0,0);
	    gbc_availabilityPanel.gridx = 2;
	    gbc_availabilityPanel.gridy = 0;
	    
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    buttonPanel.setLayout(new GridLayout(0, 3, 15, 0));
	    detailPanel.setLayout(new GridLayout(13, 0, 0, 5));
	    
	    bookTitlePanel.setLayout(new BorderLayout(0,0)); 
	    authorPanel.setLayout(new BorderLayout(0,0));
	    isbnPanel.setLayout(new BorderLayout(0,0));
	    genrePanel.setLayout(new BorderLayout(0,0));
		publisherPanel.setLayout(new BorderLayout(0,0));
		publicationPanel.setLayout(new BorderLayout(0,0));
		shelfNoPanel.setLayout(new BorderLayout(0,0));
		aisleNoPanel.setLayout(new BorderLayout(0,0));
		availabilityPanel.setLayout(new BorderLayout(0,0));		
		
		bookLocationPanel.setLayout(gbl_bookLocationPanel);
		
		borrowerInfoPanel.setLayout(new BorderLayout(0,0));	
		patronIdPanel.setLayout(new BorderLayout(0,0));	
		dateLoanedPanel.setLayout(new BorderLayout(0,0));	
		dateDuePanel.setLayout(new BorderLayout(0,0));	
		contactNumberPanel.setLayout(new BorderLayout(0,0));	
		emailAssPanel.setLayout(new BorderLayout(0,0));	


	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);
	    
	    bookTitlePanel.add(lblBookTitle, BorderLayout.WEST);
	    bookTitlePanel.add(txtBookTitle, BorderLayout.EAST);   
	    authorPanel.add(lblBookAuthor, BorderLayout.WEST);
	    authorPanel.add(txtBookAuthor, BorderLayout.EAST);
	    isbnPanel.add(lblBookISBN, BorderLayout.WEST);
	    isbnPanel.add(txtBookISBN, BorderLayout.CENTER);
	    publisherPanel.add(lblBookPublisher, BorderLayout.WEST);
	    publisherPanel.add(txtBookPublisher, BorderLayout.CENTER);
		publicationPanel.add(lblBookPublicationDate, BorderLayout.WEST);
	    publicationPanel.add(txtBookPublicationDate, BorderLayout.CENTER);
	    genrePanel.add(lblBookGenre, BorderLayout.WEST);
	    genrePanel.add(txtBookGenre, BorderLayout.EAST);
		shelfNoPanel.add(lblBookShelfNo, BorderLayout.WEST);
	    shelfNoPanel.add(txtBookShelfNo, BorderLayout.CENTER);
		aisleNoPanel.add(lblBookAisleNo, BorderLayout.WEST);
	    aisleNoPanel.add(txtBookAisleNo, BorderLayout.CENTER);
	    availabilityPanel.add(lblBookAvail, BorderLayout.WEST);
	    availabilityPanel.add(txtBookAvail, BorderLayout.CENTER);
	    borrowerInfoPanel.add(lblBorrowerInfo, BorderLayout.WEST);
		patronIdPanel.add(lblPatronID, BorderLayout.WEST);
		patronIdPanel.add(txtPatronID, BorderLayout.EAST);
		dateLoanedPanel.add(lblDateLoaned, BorderLayout.WEST);
		dateLoanedPanel.add(txtDateLoaned, BorderLayout.EAST);
		dateDuePanel.add(lblDateDue, BorderLayout.WEST);
		dateDuePanel.add(txtDateDue, BorderLayout.EAST);
		contactNumberPanel.add(lblContactNumber, BorderLayout.WEST);
		contactNumberPanel.add(txtContactNumber, BorderLayout.EAST);
		emailAssPanel.add(lblEmailAdd, BorderLayout.WEST);
		emailAssPanel.add(txtEmailAdd, BorderLayout.EAST);
	    
	    bookLocationPanel.add(shelfNoPanel, gbc_shelfNoPanel);
	    bookLocationPanel.add(aisleNoPanel, gbc_aisleNoPanel);
	    bookLocationPanel.add(availabilityPanel, gbc_availabilityPanel);
	    
	    detailPanel.add(bookTitlePanel);
	    detailPanel.add(authorPanel);
	    detailPanel.add(isbnPanel);
	    detailPanel.add(publisherPanel);
	    detailPanel.add(publicationPanel);
	    detailPanel.add(genrePanel);
	    detailPanel.add(bookLocationPanel);
	    detailPanel.add(borrowerInfoPanel);
	    detailPanel.add(patronIdPanel);
	    detailPanel.add(dateLoanedPanel);
	    detailPanel.add(dateDuePanel);
	    detailPanel.add(contactNumberPanel);
	    detailPanel.add(emailAssPanel);
	    
	    buttonPanel.add(btnBorrow, BorderLayout.WEST);
	    buttonPanel.add(btnReturn, BorderLayout.CENTER);
	    buttonPanel.add(btnEdit, BorderLayout.EAST);
	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(detailPanel, gbc_detailPanel);
	    mainPanel.add(buttonPanel, gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	          	
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 15, getWidth()/ 30);
	  	            buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
	  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
	  	            
	  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);	  	            
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize); 	          
	  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);	  	          
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);	  	         
	  	            plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
	  	            
	  	            lblBookTitle.setFont(subtitleFont);
	  	            txtBookTitle.setFont(subtitleFont);
	  	            lblBorrowerInfo.setFont(subtitleFont);	  	            
	  	            btnBorrow.setFont(buttonFont);
	  	            btnReturn.setFont(buttonFont);
	  	            btnEdit.setFont(buttonFont);	  	            
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            lblBookAuthor.setFont(plainFont);
	  	            txtBookAuthor.setFont(plainFont);
	  	            lblBookISBN.setFont(plainFont);
	  	            txtBookISBN.setFont(plainFont);   
		  	        lblBookPublisher.setFont(plainFont);
	  	            txtBookPublisher.setFont(plainFont);
		  	    	lblBookPublicationDate.setFont(plainFont);
	  	            txtBookPublicationDate.setFont(plainFont);
	  	            lblBookGenre.setFont(plainFont); 
	  	            txtBookGenre.setFont(plainFont);
		  	    	lblBookShelfNo.setFont(plainFont);
	  	            txtBookShelfNo.setFont(plainFont);
		  	    	lblBookAisleNo.setFont(plainFont);
	  	            txtBookAisleNo.setFont(plainFont);  	          
	  	            lblBookAvail.setFont(plainFont);
	  	            txtBookAvail.setFont(plainFont);
		  			lblPatronID.setFont(plainFont);
		  			txtPatronID.setFont(plainFont);
		  			lblDateLoaned.setFont(plainFont);
		  			txtDateLoaned.setFont(plainFont);
		  			lblDateDue.setFont(plainFont);
		  			txtDateDue.setFont(plainFont);
		  			lblContactNumber.setFont(plainFont);
		  			txtContactNumber.setFont(plainFont);
		  			lblEmailAdd.setFont(plainFont);
		  			txtEmailAdd.setFont(plainFont);

	          }
	      });
	}
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
		    * ng mga components 
		*/
	    iconWidth = (int) (getWidth() * 0.029);
	    iconHeight = (int) (getHeight() * 0.035);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
	// Method 
		public JButton getBtnBack() {
			return btnBack;
		}
}