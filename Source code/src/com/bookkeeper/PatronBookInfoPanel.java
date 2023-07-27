package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	private JLabel lblBookPublication;
	private JLabel lblBookShelfNo;
	private JLabel lblBookAisleNo;
	private JLabel lblBookAvail;
	
	private JLabel lbPatronID;
	private JLabel lblDateLoaned;
	private JLabel lblDateDue;
	private JLabel lblContactNumber;
	private JLabel lblEmailAdd;
	
	//textfield
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;
	
	private PlaceholderTextField txtBookTitle;
	private PlaceholderTextField txtBookAuthor;
	private PlaceholderTextField txtBookISBN;
	private PlaceholderTextField txtBookPublication;
	private PlaceholderTextField txtBookShelfNo;
	private PlaceholderTextField txtBookAisleNo;
	private PlaceholderTextField txtBookAvail;
	
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

	public PatronBookInfoPanel() {
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
	    
	    txtBookTitle = new PlaceholderTextField("Title of the Book");
	    txtBookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtBookTitle.setForeground(headerColor);
	    txtBookTitle.setOpaque(false);
	    txtBookTitle.setFocusable(false);
	    txtBookTitle.setBorder(null);
	    txtBookTitle.setEditable(false);
	    txtBookTitle.setDragEnabled(false);
	    
	    
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
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
	       
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
	    gbc_headingPanel.insets = new Insets(5, 5, 5, 0);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;

	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.anchor = GridBagConstraints.SOUTH;
	    gbc_titlePanel.fill = GridBagConstraints.BOTH;	    
	    gbc_titlePanel.insets = new Insets(5,5,5,5);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;
	    
	    gbc_detailPanel = new GridBagConstraints();
	    gbc_detailPanel.anchor = GridBagConstraints.NORTH;
	    gbc_detailPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_detailPanel.insets = new Insets(5,5,5,5);
	    gbc_detailPanel.gridx = 0;
	    gbc_detailPanel.gridy = 2;
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_buttonPanel.insets = new Insets(5,5,5,5);
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
	    //
	    
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(gbl_titlePanel); 
	    buttonPanel.setLayout(new BorderLayout(0,0));
	    detailPanel.setLayout(new GridLayout(1, 0, 0, 0));
	    /*
	     * change number of rows depending 
	     * on how many details there are
	    */
	    bookTitlePanel.setLayout(new BorderLayout(0,0)); 
	    
	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);
	    
	    titlePanel.add(txtTitle,gbc_txtTitle);
	    titlePanel.add(txtDescription,gbc_txtDescription);
	    
	    bookTitlePanel.add(lblBookTitle, BorderLayout.WEST);
	    bookTitlePanel.add(txtBookTitle, BorderLayout.CENTER);
	   
	    detailPanel.add(bookTitlePanel);
//	    detailPanel.add();
//	    detailPanel.add();
//	    detailPanel.add();
	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(detailPanel, gbc_detailPanel);
	    mainPanel.add(buttonPanel, gbc_buttonPanel);
//	    mainPanel.add();
	    
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
	  	            txtTitle.setFont(titleFont);
	  	            
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	  	            txtDescription.setFont(subtitleFont);
	  	            
	  	            bookTitleFont = new Font("Montserrat", Font.BOLD, bookTitleTextSize);

	  	            
	  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
//	  	            .setFont(buttonFont);
//	  	            .setFont(buttonFont);
	  	            
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            
	  	            
	  	            plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
	  	            lblBookTitle.setFont(plainFont);
	  	            txtBookTitle.setFont(plainFont);
//	  	            .setFont(plainFont);
//	  	            .setFont(plainFont);
//	  	            .setFont(plainFont);
//	  	          	.setFont(plainFont);  	          
	  	        

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
	    iconWidth = (int) (getWidth() * 0.025);
	    iconHeight = (int) (getHeight() * 0.035);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
}
