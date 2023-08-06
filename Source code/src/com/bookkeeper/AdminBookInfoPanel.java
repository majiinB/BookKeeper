package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
	    
	    txtBookTitle = new PlaceholderTextField(selectedBook.getBook_title());
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
	    
	    txtBookAuthor = new PlaceholderTextField(selectedBook.getBook_author());
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
	    
	    txtBookISBN = new PlaceholderTextField(selectedBook.getISBN());
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
	    
	    txtBookPublisher = new PlaceholderTextField(selectedBook.getBook_publisher());
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
	    
	    txtBookPublicationDate = new PlaceholderTextField(selectedBook.getBook_publication_date());
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
	    
	    txtBookGenre = new PlaceholderTextField(selectedBook.getBook_genre());
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
	    
	    txtBookShelfNo = new PlaceholderTextField(selectedBook.getShelf());
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
	    
	    txtBookAisleNo  = new PlaceholderTextField(selectedBook.getAisle());
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
	    
	    txtBookAvail = new PlaceholderTextField(selectedBook.getBook_status());
	    txtBookAvail.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookAvail.setForeground(darkplainColor);
	    txtBookAvail.setOpaque(false);
	    txtBookAvail.setFocusable(false);
	    txtBookAvail.setBorder(null);
	    txtBookAvail.setEditable(false);
	    txtBookAvail.setDragEnabled(false);
	    
	    User patron = getRecentBorrowedPatron(selectedBook.getBook_id()); // get patron who recently borrowed the book
	    
	    lblBorrowerInfo = new JLabel("Borrower's Information:");
	    lblBorrowerInfo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblBorrowerInfo.setBorder(null);
	    lblBorrowerInfo.setForeground(headerColor);
	   
	    lblPatronID = new JLabel("Patron ID");
	    lblPatronID.setHorizontalAlignment(SwingConstants.LEFT);
	    lblPatronID.setBorder(null);
	    lblPatronID.setForeground(darkplainColor);
	    
	    String resultID = (patron != null && patron.getUser_id() != null && !patron.getUser_id().isEmpty())
                ? patron.getUser_id()
                : "Patron ID";
	    txtPatronID = new PlaceholderTextField(resultID);
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
	    
	    txtDateLoaned = new PlaceholderTextField(getMostRecentBorrowedDate(selectedBook.getBook_id()));
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
	    
	    txtDateDue = new PlaceholderTextField(getMostRecentDueDate(selectedBook.getBook_id()));
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
	    
	    String resultContact = (patron != null && patron.getUser_contact() != null && !patron.getUser_contact().isEmpty())
                ? patron.getUser_contact()
                : "00000000000";
	    txtContactNumber = new PlaceholderTextField(resultContact);
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
	    
	    String resultEmail = (patron != null && patron.getUser_email() != null && !patron.getUser_email().isEmpty())
                ? patron.getUser_email()
                : "Patron Email";
	    txtEmailAdd = new PlaceholderTextField(resultEmail);
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
	   // Action listener
	    btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedBook.getBook_status().equals("Checked out")) {
					updateBookStatusAndBorrowStatus(selectedBook.getBook_id());
					//JOptionPane.showMessageDialog(pnlBookInfoDisplayAdmin.this, "Book successfully returned", "Success", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					//JOptionPane.showMessageDialog(pnlBookInfoDisplayAdmin.this, "Book is still available", "Fail to return", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
//	    btnSaveChangesEdit.addActionListener(new ActionListener() {
//			pnlBookInfoDisplayUser bookInfoUser = new pnlBookInfoDisplayUser();
//			public void actionPerformed(ActionEvent e) {
//				String patronID = txtEnterPatronID.getText();
//				int bookID = book.getBook_id();
//				
//				//Check if the user ID entered exists
//				if(checkUserExistence(patronID)) {
//					//Check if the book is Available 
//					if(isBookAvailable(bookID)) {
//						insertBorrowedBook(bookID, patronID);
//						//Check if there is a reservation 
//						if(bookInfoUser.isReservationExisting(bookID, patronID)) {
//							updateReservationStatus(bookID, patronID);
//						}
//						//Prompt the successful borrowing
//						JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "Successfully borrowed", "Success", JOptionPane.PLAIN_MESSAGE);
//					}
//					else {
//						JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "The book is still unavailable for borrow", "Fail", JOptionPane.ERROR_MESSAGE);
//					}
//				}else {
//					JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "Patron ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
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
		public void updateBookStatusAndBorrowStatus(int bookId) {
		    Connection conn = null;
		    try {
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

		        // Update book_status in the book table
		        String updateBookStatusQuery = "UPDATE book SET book_status = 'Available' WHERE book_id = ?";
		        PreparedStatement updateBookStatusStmt = conn.prepareStatement(updateBookStatusQuery);
		        updateBookStatusStmt.setInt(1, bookId);
		        updateBookStatusStmt.executeUpdate();

		        // Update borrow_status and returned_date in the borrowed_book table for the latest borrowed record with the given book_id
		        String updateBorrowStatusQuery = "UPDATE borrowed_book SET borrow_status = 'returned', returned_date = ? WHERE book_id = ? " +
		                                         "AND borrow_id = (SELECT borrow_id FROM borrowed_book WHERE book_id = ? ORDER BY borrowed_date DESC LIMIT 1)";
		        PreparedStatement updateBorrowStatusStmt = conn.prepareStatement(updateBorrowStatusQuery);

		        // Set the current date as the returned_date
		        LocalDate currentDate = LocalDate.now();
		        Date returnedDate = Date.valueOf(currentDate);
		        updateBorrowStatusStmt.setDate(1, returnedDate);
		        updateBorrowStatusStmt.setInt(2, bookId);
		        updateBorrowStatusStmt.setInt(3, bookId);
		        updateBorrowStatusStmt.executeUpdate();

		        System.out.println("Book status and borrow status updated successfully.");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		public User getRecentBorrowedPatron(int bookId) {
		    User patron = null;
		    Connection conn = null;
		    PreparedStatement stmt1 = null;
		    PreparedStatement stmt2 = null;
		    ResultSet rs1 = null;
		    ResultSet rs2 = null;

		    try {
		        // Connect to the MySQL database
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

		        // Query to retrieve the most recent record from borrowed_book table for the given bookId
		        String query1 = "SELECT patron_id FROM borrowed_book WHERE book_id = ? ORDER BY borrowed_date DESC, borrow_time DESC LIMIT 1";

		        // Create a prepared statement with the query
		        stmt1 = conn.prepareStatement(query1);
		        stmt1.setInt(1, bookId);

		        // Execute the query
		        rs1 = stmt1.executeQuery();

		        // Check if a patronId was found
		        if (rs1.next()) {
		            String patronId = rs1.getString("patron_id");
		            System.out.println("patronId: " + patronId);

		            // Query to retrieve the patron details based on the patronId
		            String query2 = "SELECT * FROM patron WHERE formatted_id = ?";

		            // Create a new prepared statement with the patron query
		            stmt2 = conn.prepareStatement(query2);
		            stmt2.setString(1, patronId);

		            // Execute the patron query
		            rs2 = stmt2.executeQuery();

		            // Fetch the patron details
		            if (rs2.next()) {
		                String patronId1 = rs2.getString("formatted_id");
		                String firstName = rs2.getString("patron_fname");
		                String lastName = rs2.getString("patron_lname");
		                String email = rs2.getString("patron_email");
		                String contact = rs2.getString("patron_contact");
		                String address = rs2.getString("patron_address");
		                String password = rs2.getString("patron_password");
		                String status = rs2.getString("patron_status");
		                int penalty = rs2.getInt("penalty");

		                // Create a new User object
		                patron = new User(patronId1, firstName, lastName, email, contact, address, password, status, penalty);
		               
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            // Close the result sets and statements
		            if (rs1 != null) {
		                rs1.close();
		            }
		            if (rs2 != null) {
		                rs2.close();
		            }
		            if (stmt1 != null) {
		                stmt1.close();
		            }
		            if (stmt2 != null) {
		                stmt2.close();
		            }
		            if (conn != null) {
		                conn.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return patron;
		}

		public String getMostRecentDueDate(int bookId) {
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        String mostRecentDueDate = "YYYY-MM-DD";

	        try {
	            // Establish a connection to the database
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	            // Prepare the SQL query
	            String query = "SELECT borrowed_due_date FROM borrowed_book WHERE book_id = ? ORDER BY borrowed_date DESC LIMIT 1";
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, bookId);

	            // Execute the query
	            resultSet = statement.executeQuery();

	            // Retrieve the result
	            if (resultSet.next()) {
	                mostRecentDueDate = resultSet.getString("borrowed_due_date");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the result set, statement, and connection
	            if (resultSet != null) {
	                try {
	                    resultSet.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return mostRecentDueDate;
	    }

		public String getMostRecentBorrowedDate(int bookId) {
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        String mostRecentBorrowDate ="YYYY-MM-DD";

	        try {
	            // Establish a connection to the database
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	            // Prepare the SQL query
	            String query = "SELECT borrowed_date FROM borrowed_book WHERE book_id = ? ORDER BY borrowed_date DESC LIMIT 1";
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, bookId);

	            // Execute the query
	            resultSet = statement.executeQuery();

	            // Retrieve the result
	            if (resultSet.next()) {
	                mostRecentBorrowDate = resultSet.getString("borrowed_date");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the result set, statement, and connection
	            if (resultSet != null) {
	                try {
	                    resultSet.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return mostRecentBorrowDate;
	    }
		public boolean checkUserExistence(String patronId) {
		    boolean userExists = false;

		    try {
		        // Establish database connection
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

		        // Prepare the SQL statement
		        String query = "SELECT COUNT(*) FROM patron WHERE BINARY patron_id = ?";
		        PreparedStatement statement = connection.prepareStatement(query);
		        statement.setString(1, patronId);

		        // Execute the query and check the result
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		            int count = resultSet.getInt(1);
		            userExists = (count > 0);
		        }

		        // Close the database connection
		        resultSet.close();
		        statement.close();
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return userExists;
		}
		
		//Method to insert the borrowed books info in the database
		public void insertBorrowedBook(int bookId, String patronId) {
		    try {
		        // Establish database connection
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

		        // Prepare the SQL statement for inserting the borrowed book
		        String insertQuery = "INSERT INTO borrowed_book (book_id, patron_id, borrowed_date, borrowed_due_date, borrow_status) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
		        insertStatement.setInt(1, bookId); 
		        insertStatement.setString(2, patronId);
		        
		        // Get the current date
		        LocalDate currentDate = LocalDate.now();
		        insertStatement.setDate(3, java.sql.Date.valueOf(currentDate));

		        // Calculate the due date (current date + 3 weeks)
		        LocalDate dueDate = currentDate.plusWeeks(3);
		        insertStatement.setDate(4, java.sql.Date.valueOf(dueDate));
		        
		        // Set status
		        insertStatement.setString(5, "out");

		        // Execute the insert query
		        insertStatement.executeUpdate();

		        // Prepare the SQL statement for updating the book status
		        String updateQuery = "UPDATE book SET book_status = 'Checked out' WHERE book_id = ?";
		        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
		        updateStatement.setInt(1, bookId);

		        // Execute the update query
		        updateStatement.executeUpdate();

		        // Close the database connection and statements
		        updateStatement.close();
		        insertStatement.close();
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		//Book status checker method
		    public boolean isBookAvailable(int bookId) {
		        boolean isAvailable = false;
		        
		        try {
		            // Establish the database connection
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		            
		            // Create the SQL query
		            String query = "SELECT book_status FROM book WHERE book_id = ?";
		            
		            // Prepare the statement
		            PreparedStatement statement = conn.prepareStatement(query);
		            
		            // Set the parameter
		            statement.setInt(1, bookId);
		            
		            // Execute the query
		            ResultSet resultSet = statement.executeQuery();
		            
		            // Check if the book status is "Available"
		            if (resultSet.next()) {
		                String bookStatus = resultSet.getString("book_status");
		                if (bookStatus.equals("Available")) {
		                    isAvailable = true;
		                }
		            }
		            
		            // Close the resources
		            resultSet.close();
		            statement.close();
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		        return isAvailable;
		    }
		    public void updateReservationStatus(int bookId, String patronId) {
		        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "")) {
		            // Check if the reservation exists
		            String selectQuery = "SELECT reservation_id FROM reserved_book WHERE book_id = ? AND patron_id = ?";
		            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
		                selectStmt.setInt(1, bookId);
		                selectStmt.setString(2, patronId);
		                ResultSet rs = selectStmt.executeQuery();

		                if (rs.next()) {
		                    int reservationId = rs.getInt("reservation_id");

		                    // Update the reservation status to 'done'
		                    String updateQuery = "UPDATE reserved_book SET reservation_status = 'done' WHERE reservation_id = ?";
		                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
		                        updateStmt.setInt(1, reservationId);
		                        updateStmt.executeUpdate();
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
}