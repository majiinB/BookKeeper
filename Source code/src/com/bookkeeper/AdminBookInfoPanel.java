package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AdminBookInfoPanel extends JPanel{
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
	private JLabel lblBookPublication;
	private JLabel lblBookShelfNo;
	private JLabel lblBookAisleNo;
	private JLabel lblBookAvail;
	
	private JLabel lblBorrowerInfo;
	private JLabel lbPatronID;
	private JLabel lblDateLoaned;
	private JLabel lblDateDue;
	private JLabel lblContactNumber;
	private JLabel lblEmailAdd;
	
	//textfield
	private PlaceholderTextField txtBookTitle;
	private PlaceholderTextField txtBookAuthor;
	private PlaceholderTextField txtBookISBN;
	private PlaceholderTextField txtBookPublication;
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
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_detailPanel;

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

	public AdminBookInfoPanel(Book book) {
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
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
	    
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
	    gbc_headingPanel.insets = new Insets(5, 5, 5, 0);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;

	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.fill = GridBagConstraints.BOTH;	    
	    gbc_titlePanel.insets = new Insets(0, 0, 0, 0);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;
	    
	    gbc_detailPanel = new GridBagConstraints();
	    gbc_detailPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_detailPanel.insets = new Insets(0, 0, 0, 0);
	    gbc_detailPanel.gridx = 0;
	    gbc_detailPanel.gridy = 2;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    buttonPanel.setLayout(new GridLayout(0, 3, 30, 0));

	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);

	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
//	    mainPanel.add();
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	          	
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
	  	            buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
	  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
	  	            
	  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
//	  	            .setFont(titleFont);
	  	            
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
//	  	            .setFont(subtitleFont);
	  	            
	  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
//	  	            .setFont(buttonFont);
//	  	            .setFont(buttonFont);
	  	            
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            
	  	            plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
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
		    * ng mga components 
		*/
	    iconWidth = (int) (getWidth() * 0.025);
	    iconHeight = (int) (getHeight() * 0.035);
	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	    lblHeading.setIcon(new ImageIcon(scaledImage));

	 }
	public JButton getBtnBack() {
		return btnBack;
	}
}