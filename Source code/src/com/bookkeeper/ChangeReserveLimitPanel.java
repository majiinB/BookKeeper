package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class ChangeReserveLimitPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;


	//label
	private JLabel lblHeading;
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;

	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblCurrentAddress;
	private JLabel lblNewAddress;
	private JLabel lblCurrentNumber;	
	private JLabel lblNewNumber;	
	private JLabel lblCurrentPass;	
	private JLabel lblNewPass;		
	private JLabel lblConfirmPass;
	private JLabel lblUserStatus;
	private JLabel lblBorrow;
	private JLabel lblReserve;

	//spinner
	private PlaceholderSpinner spinnerReserve;
	private PlaceholderSpinner spinnerBorrow;
	//textfield
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtCurrentAddress;
	private PlaceholderTextField txtNewAddress;
	private PlaceholderTextField txtCurrentNumber;
	private PlaceholderTextField txtNewNumber;
	private PlaceholderPassword txtCurrentPass;	
	private PlaceholderPassword txtNewPass;		
	private PlaceholderPassword txtConfirmPass;

	private PlaceholderComboBox comboBoxUserStatus;

	//button
	private JButton btnUpdate;
	private JButton btnCancel;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_buttonPanel;


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

	public ChangeReserveLimitPanel() {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
	    inputPanel = new JPanel();
	    buttonPanel = new JPanel();

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
	    inputPanel.setOpaque(false);
	    buttonPanel.setOpaque(false);

	    
	    lblHeading = new JLabel();
	    lblHeading.setIconTextGap(20);
	    lblHeading.setFocusable(false);
	    lblHeading.setForeground(headerColor);
	    lblHeading.setText("User Details");
	    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
	  
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFocusPainted(false);
	    btnCancel.setForeground(new Color(23, 21, 147));
	    btnCancel.setBorderPainted(false);
	    btnCancel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
	    txtTitle = new JTextArea();
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    txtTitle.setText("Reserve Limit");
	    
	    txtDescription = new JTextArea();
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("Manage how many books a patron can reserve simultaneously. To confirm please type in your password in the box below");
	    
	    btnUpdate = new JButton();
	    btnUpdate.setText("Update");
	    btnUpdate.setMnemonic(KeyEvent.VK_ENTER);
	    btnUpdate.setForeground(lightplainColor);
	    btnUpdate.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnUpdate.setOpaque(true);
	    btnUpdate.setFocusPainted(false);
	    btnUpdate.setBorderPainted(false);
	    btnUpdate.setBackground(headerColor);
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
	    gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_titlePanel.anchor = GridBagConstraints.NORTH;
	    gbc_titlePanel.insets = new Insets(5, 5, 5, 0);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;	    

	    gbc_inputPanel = new GridBagConstraints();
	    gbc_inputPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_inputPanel.anchor = GridBagConstraints.NORTH;
	    gbc_inputPanel.insets = new Insets(5, 5, 5, 0);
	    gbc_inputPanel.gridx = 0;
	    gbc_inputPanel.gridy = 2;	 
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
	    gbc_buttonPanel.insets = new Insets(5, 5, 5, 0);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 3;	   
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0,0));
	    titlePanel.setLayout(new GridLayout(2, 0, 0, 0));
	    buttonPanel.setLayout(new GridLayout(0, 3, 30, 0));
	    buttonPanel.setLayout(new BorderLayout(0, 0));

	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnCancel, BorderLayout.EAST);

	    titlePanel.add(txtTitle);
	    titlePanel.add(txtDescription);
//	    inputPanel.add(=);
	    buttonPanel.add(btnUpdate);
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(inputPanel, gbc_inputPanel);
	    mainPanel.add(buttonPanel,gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	          	
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 25);
	  	            buttonTextSize =  Math.min(getHeight() / 30, getWidth()/ 30);
	  	           	headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 30);
	  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
	  	            
	  	            titleFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, titleTextSize);
	  	            txtTitle.setFont(titleFont);
	  	            
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	  	            txtDescription.setFont(subtitleFont);
	  	            
	  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	  	            btnUpdate.setFont(buttonFont);
//	  	            .setFont(buttonFont);
	  	            
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            btnCancel.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            
	  	            plainFont = new Font("Montserrat", Font.PLAIN , plainTextsize);
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

	 }
}
