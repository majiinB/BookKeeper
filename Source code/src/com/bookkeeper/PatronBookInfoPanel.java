package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatronBookInfoPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel detailPanel;
	private JPanel buttonPanel;

	private JPanel bookTitlePanel;
	private JPanel authorPanel;
	private JPanel isbnPanel;
	private JPanel genrePanel;
	private JPanel publisherPanel;
	private JPanel publicationPanel;
	private JPanel availabilityPanel;
	private JPanel shelfNoPanel;
	private JPanel aisleNoPanel;
	
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
	private JLabel lblBookGenre;
	private JLabel lblBookPublisher;
	private JLabel lblBookPublicationDate;
	private JLabel lblBookAvail;
	private JLabel lblBookShelfNo;
	private JLabel lblBookAisleNo;
	
	//textfield
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;
	
	private PlaceholderTextField txtBookTitle;
	private PlaceholderTextField txtBookAuthor;
	private PlaceholderTextField txtBookISBN;
	private PlaceholderTextField txtBookGenre;
	private PlaceholderTextField txtBookPublisher;
	private PlaceholderTextField txtBookPublicationDate;
	private PlaceholderTextField txtBookAvail;
	private PlaceholderTextField txtBookShelfNo;
	private PlaceholderTextField txtBookAisleNo;
	
	
	//button
	private JButton btnReserve;
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
	private  int headerTextSize;
	private  int plainTextsize;
	private  int bookTitleTextSize;
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	private int selectedValue;

	public PatronBookInfoPanel(Book selectedBook, User patron) {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
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
		
		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
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

	    
	    txtTitle = new JTextArea("Book Information");
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    
	    txtDescription = new JTextArea("Browse and reserve books effortlessly so they'll be ready for your next reading.");
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
	    
	    btnReserve = new JButton();
	    btnReserve.setText("Reserve");
	    btnReserve.setMnemonic(KeyEvent.VK_ENTER);
	    btnReserve.setForeground(lightplainColor);
	    btnReserve.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnReserve.setOpaque(true);
	    btnReserve.setFocusPainted(false);
	    btnReserve.setBorderPainted(false);
	    btnReserve.setBackground(headerColor);
	    
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
	    
	    //
	   
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
	    
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(gbl_titlePanel); 
	    buttonPanel.setLayout(new BorderLayout(0,0));
	    detailPanel.setLayout(new GridLayout(9, 0, 0, 5));

	    
	    // Panels inside the detailPanel
	    bookTitlePanel.setLayout(new BorderLayout(0,0)); 
	    authorPanel.setLayout(new BorderLayout(0,0));
	    isbnPanel.setLayout(new BorderLayout(0,0));
	    genrePanel.setLayout(new BorderLayout(0,0));
		publisherPanel.setLayout(new BorderLayout(0,0));
		publicationPanel.setLayout(new BorderLayout(0,0));
		availabilityPanel.setLayout(new BorderLayout(0,0));
		shelfNoPanel.setLayout(new BorderLayout(0,0));
		aisleNoPanel.setLayout(new BorderLayout(0,0));
	    
	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);
	    
	    titlePanel.add(txtTitle,gbc_txtTitle);
	    titlePanel.add(txtDescription,gbc_txtDescription);
	    
	    bookTitlePanel.add(lblBookTitle, BorderLayout.WEST);
	    bookTitlePanel.add(txtBookTitle, BorderLayout.CENTER);   
	    authorPanel.add(lblBookAuthor, BorderLayout.WEST);
	    authorPanel.add(txtBookAuthor, BorderLayout.CENTER);
	    isbnPanel.add(lblBookISBN, BorderLayout.WEST);
	    isbnPanel.add(txtBookISBN, BorderLayout.CENTER);
	    genrePanel.add(lblBookGenre, BorderLayout.WEST);
	    genrePanel.add(txtBookGenre, BorderLayout.CENTER);
	    publisherPanel.add(lblBookPublisher, BorderLayout.WEST);
	    publisherPanel.add(txtBookPublisher, BorderLayout.CENTER);
		publicationPanel.add(lblBookPublicationDate, BorderLayout.WEST);
	    publicationPanel.add(txtBookPublicationDate, BorderLayout.CENTER);
		availabilityPanel.add(lblBookAvail, BorderLayout.WEST);
	    availabilityPanel.add(txtBookAvail, BorderLayout.CENTER);
		shelfNoPanel.add(lblBookShelfNo, BorderLayout.WEST);
	    shelfNoPanel.add(txtBookShelfNo, BorderLayout.CENTER);
		aisleNoPanel.add(lblBookAisleNo, BorderLayout.WEST);
	    aisleNoPanel.add(txtBookAisleNo, BorderLayout.CENTER);
	   
	    detailPanel.add(bookTitlePanel);
	    detailPanel.add(authorPanel);
	    detailPanel.add(isbnPanel);
	    detailPanel.add(genrePanel);
	    detailPanel.add(publisherPanel);
	    detailPanel.add(publicationPanel);
	    detailPanel.add(availabilityPanel);
	    detailPanel.add(shelfNoPanel);
	    detailPanel.add(aisleNoPanel);
	    
	    buttonPanel.add(btnReserve);	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(detailPanel, gbc_detailPanel);
	    mainPanel.add(buttonPanel, gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	    		  	titleTextSize = Math.min(getHeight() / 10, getWidth()/ 10) ;
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
	  	            txtBookTitle.setFont(bookTitleFont);
	  	            btnReserve.setFont(buttonFont);
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            lblBookAuthor.setFont(plainFont);
	  	            txtBookAuthor.setFont(plainFont);
	  	            lblBookISBN.setFont(plainFont);
	  	            txtBookISBN.setFont(plainFont);  
	  	            lblBookGenre.setFont(plainFont); 
	  	            txtBookGenre.setFont(plainFont); 
		  	        lblBookPublisher.setFont(plainFont);
	  	            txtBookPublisher.setFont(plainFont);
		  	    	lblBookPublicationDate.setFont(plainFont);
	  	            txtBookPublicationDate.setFont(plainFont);
		  	    	lblBookAvail.setFont(plainFont);
	  	            txtBookAvail.setFont(plainFont);
		  	    	lblBookShelfNo.setFont(plainFont);
	  	            txtBookShelfNo.setFont(plainFont);
		  	    	lblBookAisleNo.setFont(plainFont);
	  	            txtBookAisleNo.setFont(plainFont);
	  	        

	          }
	      });
	    // Action Listener
	    btnReserve.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
		    	
	    		int bookID = selectedBook.getBook_id();
				String patronID = patron.getUser_id();
				
				//Check if reservation already exists
				if(isReservationExisting(bookID, patronID)) {
					// Prompt a malfunction dialog
					MalfunctionPanel mal = new MalfunctionPanel("Reservation Error", "Reservation already exists!");
					showDialog(mal);
					return;
				}
				
				// Check if reservation is necessary
				if(selectedBook.getBook_status().equals("Checked out") || selectedBook.getBook_status().equals("Unavailable")) {
					// Prompt cofirmation panel
			    	ConfirmationPanel confirm =  new ConfirmationPanel("Confirm Reservation?", "You cannot cancel this after\nthe reservation has been made.");
			    	int con = showDialog(confirm);
			    	
			    	//Condition
			    	if(con == 2) return;
			    	else updateReservation(bookID, patronID);
				}
				else {
					MalfunctionPanel mal = new MalfunctionPanel("Reservation Error", "This book is still available");
					showDialog(mal);
				}
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
	// Methods
	public JButton getBtnBack() {
		return btnBack;
	}
	public void updateReservation(int bookId, String patronId) {
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "")) {
		            // Insert or update the reservation record
		                String query = "INSERT INTO reserved_book (book_id, reservation_date, reservation_status, patron_id, reservation_time) VALUES (?, CURDATE(), ?, ?,  CURRENT_TIME )";
		                try (PreparedStatement insertStmt = conn.prepareStatement(query)) {
		                    insertStmt.setInt(1, bookId);
		                    insertStmt.setString(2, "in que");
		                    insertStmt.setString(3, patronId);
		                    insertStmt.executeUpdate();
		                    
		                    SuccessPanel success = new SuccessPanel("Reservation Success", "Reservation Success!");
		                    showDialog(success);
		                } 
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	public boolean isReservationExisting(int bookId, String patronId) {
		boolean isExisting = false;
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "")) {
	        String query = "SELECT COUNT(*) AS count FROM reserved_book WHERE book_id = ? AND patron_id = ? AND reservation_status ='in que'";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, bookId);
	            stmt.setString(2, patronId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                int count = rs.getInt("count");
	                if (count > 0) {
	                    isExisting = true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isExisting;
	}
	//Method to show alert panel (Success Panel)
		public void showDialog(SuccessPanel panel) {
			
			panel.getBtnConfirm().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		            closeDialog(e);
		    	}
		    });
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Success", true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.getContentPane().add(panel);
			dialog.pack();
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);

		}
		
		//Method to show alert panel (Malfunction Panel)
	    public void showDialog(MalfunctionPanel panel) {
			
			panel.getBtnConfirm().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		            closeDialog(e);
		    	}
		    });
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this),"Error", true);
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.getContentPane().add(panel);
	        dialog.pack();
	        dialog.setLocationRelativeTo(null);
	        dialog.setVisible(true);
		}
	  //Method to show alert panel (Confirmation Panel)
		public int showDialog(ConfirmationPanel panel) {
			selectedValue = 0;
			
			panel.getBtnConfirm().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		selectedValue = 1; // Set selectedValue to 1 when "OK" is clicked
		            closeDialog(e);
		    	}
		    });
		    panel.getBtnCancel().addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		            selectedValue = 2; // Set selectedValue to2 when "Cancel" is clicked
		            closeDialog(e);
		    	}
		    });
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this),"Confirm Reservation", true);
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.add(panel);
	        dialog.pack();
	        dialog.setLocationRelativeTo(null);
	        dialog.setVisible(true);
			
			return selectedValue;
		}
	    
	    //Method used by showDialog to close the JDialog containing the alert panels
		private void closeDialog(ActionEvent e) {
	        Component component = (Component) e.getSource();
	        Window window = SwingUtilities.getWindowAncestor(component);
	        if (window != null) {
	            window.dispose();
	        }
	    }
}