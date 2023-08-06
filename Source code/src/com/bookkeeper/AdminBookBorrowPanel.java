package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class AdminBookBorrowPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private RoundedPanel borrowPanel;
	private RoundedPanel cancelPanel;


	//label
	private JTextArea txtDescription;
	private JLabel lblPatronID;
	
	//textfield
	private PlaceholderTextField txtPatronID; 
	
	//button
	private JButton btnBorrow;
	private JButton btnCancel;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_txtDescription;
	private GridBagConstraints gbc_lblPatronID;	
	private GridBagConstraints gbc_txtPatronID;
	private GridBagConstraints gbc_borrowPanel;
	private GridBagConstraints gbc_cancelPanel;

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

	public AdminBookBorrowPanel() {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    borrowPanel = new RoundedPanel(20);
	    cancelPanel = new RoundedPanel(20);

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    lblPatronID.setOpaque(false);
	    borrowPanel.setOpaque(false);
	    cancelPanel.setOpaque(false);
	    
	    cancelPanel.setBorderWidth(2);
	    borrowPanel.setBorderWidth(2);

	    txtDescription = new JTextArea();
	    txtDescription.setForeground(headerColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("Please enter the User ID to confirm borrowing transaction.");
	    
	    lblPatronID = new JLabel("Patron ID"); 
	    lblPatronID.setHorizontalAlignment(SwingConstants.LEFT);
	    lblPatronID.setBorder(null);
	    lblPatronID.setForeground(darkplainColor);
	
	    txtPatronID = new PlaceholderTextField("Patron ID");
	    txtPatronID.setBackground(middleplainColor);
	    txtPatronID.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtPatronID.setOpaque(true);
	    txtPatronID.setFocusable(true);
	    txtPatronID.setEditable(true);
	    txtPatronID.setDragEnabled(false);
	
	    btnBorrow = new JButton();
	    btnBorrow.setText("Borrow");
	    btnBorrow.setForeground(darkplainColor);
	    btnBorrow.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnBorrow.setOpaque(false);
	    btnBorrow.setFocusPainted(false);
	    btnBorrow.setBorderPainted(false);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFocusPainted(false);
	    btnCancel.setForeground(darkplainColor);
	    btnCancel.setBorderPainted(false);
	    btnCancel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnCancel.setOpaque(false);

	    
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
	    gbl_mainPanel.columnWidths = new int[]{0,0};
	    gbl_mainPanel.rowHeights = new int[]{0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0,1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};

	    gbc_txtDescription = new GridBagConstraints();
	    gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_txtDescription.insets = new Insets(20, 20, 10, 20);
	    gbc_txtDescription.gridx = 0;
	    gbc_txtDescription.gridy = 0;
	    gbc_txtDescription.gridwidth = 2;

	    gbc_lblPatronID = new GridBagConstraints();
	    gbc_lblPatronID.fill = GridBagConstraints.BOTH;	    
	    gbc_lblPatronID.insets = new Insets(10, 20, 10, 20);
	    gbc_lblPatronID.gridx = 0;
	    gbc_lblPatronID.gridy = 1;
	    gbc_lblPatronID.gridwidth = 2;

	    gbc_txtPatronID = new GridBagConstraints();
	    gbc_txtPatronID.fill = GridBagConstraints.BOTH;	    
	    gbc_txtPatronID.insets = new Insets(5, 20, 10, 20);
	    gbc_txtPatronID.gridx = 0;
	    gbc_txtPatronID.gridy = 2;
	    gbc_txtPatronID.gridwidth = 2;
	    
	    gbc_borrowPanel = new GridBagConstraints();
	    gbc_borrowPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_borrowPanel.insets = new Insets(10, 20, 10, 20);
	    gbc_borrowPanel.gridx = 0;
	    gbc_borrowPanel.gridy = 3;    
	    
	    gbc_cancelPanel = new GridBagConstraints();
	    gbc_cancelPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_cancelPanel.insets = new Insets(10, 20, 10, 20);
	    gbc_cancelPanel.gridx = 1;
	    gbc_cancelPanel.gridy = 3;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    borrowPanel.setLayout(new BorderLayout(0, 0));
	    cancelPanel.setLayout(new BorderLayout(0, 0));

	    //Add all to main panel
	    borrowPanel.add(btnBorrow, BorderLayout.CENTER);
	    cancelPanel.add(btnCancel, BorderLayout.CENTER);
	    mainPanel.add(txtDescription,gbc_txtDescription);
	    mainPanel.add(lblPatronID,gbc_lblPatronID);
	    mainPanel.add(txtPatronID,gbc_txtPatronID);
	    mainPanel.add(borrowPanel,gbc_borrowPanel);
	    mainPanel.add(cancelPanel,gbc_cancelPanel);

	    
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 25);
	  	            buttonTextSize =  Math.min(getHeight() / 30, getWidth()/ 30);
	  	           	headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 30);
	  	           	plainTextsize=   Math.min(getHeight() / 25, getWidth()/ 25);
	  	          
	  	          titleFont = new Font("Montserrat", Font.ITALIC|Font.BOLD, titleTextSize);
	  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            plainFont = new Font("Montserrat", Font.BOLD | Font.BOLD, plainTextsize);

	  	           	txtDescription.setFont(titleFont);
	  	            btnBorrow.setFont(buttonFont);	  	            
	  	            btnCancel.setFont(buttonFont);
	  	            lblPatronID.setFont(plainFont);  	          
	  	          	          
	          }
	      });
	 // Action Listener
	}
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
		    * of components 
		*/
	 }
}