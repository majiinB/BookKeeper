package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountInfoPanel extends JPanel{
	//panel			
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel detailPanel;
	private JPanel buttonPanel;
	private JPanel profilePanel;
	private JPanel namePanel;
	private JPanel contactPanel;
	private JPanel addressPanel;	
	private JPanel passwordSecurityPanel;
	private JPanel changePassPanel;
	
	//icon
	private ImageIcon icon;
	private ImageIcon buttonicon;
	private Image image;
	private Image buttonimage;
	private Image scaledImage;
	private Image buttonscaledImage;
	private int iconHeight; 
	private int iconWidth;
	private int iconWidth1;
	private int iconHeight1;
	//label
	private JLabel lblProfile;
	private JLabel lblHeading;
	private JLabel lblName;
	private JLabel lblContactNum;
	private JLabel lblAddress;
	private JLabel lblChangePass;
	
	//textfield
	private JTextArea txtTitle;
	private JTextArea txtDescription;
	private JTextArea txtSecurity;
	private JTextArea txtSecurityDescription;		
	
	//button
	private JButton btnName;
	private JButton btnContactNum;
	private JButton btnAddress;
	private JButton btnChangePass;
	private JButton btnDone;
	
	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_detailPanel;
	private GridBagConstraints gbc_buttonPanel;
	
	private GridBagLayout gbl_detailPanel;
	private GridBagConstraints gbc_namePanel;
	private GridBagConstraints gbc_contactPanel;
	private GridBagConstraints gbc_addressPanel;
	private GridBagConstraints gbc_passwordSecurityPanel;
	private GridBagConstraints gbc_changePassPanel;
	private GridBagConstraints gbc_lblProfile;

	
	private GridBagLayout gbl_titlePanel; 
	private GridBagConstraints gbc_txtTitle;
	private GridBagConstraints gbc_txtDescription;
	
	private GridBagLayout gbl_namePanel;
	private GridBagConstraints gbc_lblName;
	private GridBagConstraints gbc_btnName;
		
	private GridBagLayout gbl_contactPanel;
	private GridBagConstraints gbc_lblContactNum;
	private GridBagConstraints gbc_btnContactNum;
	
	private GridBagLayout gbl_addressPanel;
	private GridBagConstraints gbc_lblAddress;
	private GridBagConstraints gbc_btnAddress;
			
	private GridBagLayout gbl_passwordSecurityPanel; 
	private GridBagConstraints gbc_txtSecurityTitle;
	private GridBagConstraints gbc_txtSecurityDescription;
	
	private GridBagLayout gbl_changePassPanel;
	private GridBagConstraints gbc_lblChangePass;
	private GridBagConstraints gbc_btnChangePass;

	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font headerFont;
	private  Font plainFont;
	private  Font bookTitleFont;
	private  Font buttonFont;
		
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int bookTitleTextSize;
	private  int buttonTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	private int whoAccessed;
	Employee employee;
	User patron;
	
	public AccountInfoPanel(Object user, JFrame parent) {
		
		//Check what object was passed
		if (user instanceof Employee) {
            employee = (Employee) user;
            whoAccessed = 1;
        } else if (user instanceof User) {
            patron = (User) user;
            whoAccessed = 2;
        }
		
		setBackground(new Color(250, 251, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		//create panels
		mainPanel = new JPanel();//panel to hold all panels
		headingPanel = new JPanel();
		titlePanel = new JPanel();
		detailPanel = new JPanel();
		profilePanel = new JPanel();
		namePanel = new JPanel();
		contactPanel = new JPanel();
		addressPanel = new JPanel();
		buttonPanel = new JPanel();
		
		passwordSecurityPanel = new JPanel();
		changePassPanel = new JPanel();
		
		// Set panel properties
		mainPanel.setBorder(null);
		changePassPanel.setBorder(null);
		mainPanel.setOpaque(false);
		headingPanel.setOpaque(false);
		titlePanel.setOpaque(false);
		detailPanel.setOpaque(false);
		profilePanel.setOpaque(false);
		passwordSecurityPanel.setOpaque(false);
		
		namePanel.setOpaque(false);
		contactPanel.setOpaque(false);
		addressPanel.setOpaque(false);
		passwordSecurityPanel.setOpaque(false);
		changePassPanel.setOpaque(false);
		
		//added an arrow icon for the disable button
		icon = new ImageIcon("img/Logo_Blue.png");
		buttonicon = new ImageIcon("img/DashboardFrame/Arrow.png");
		
		image = icon.getImage();
		buttonimage = buttonicon.getImage();
		
		lblHeading = new JLabel();
		lblHeading.setIconTextGap(20);
		lblHeading.setFocusable(false);
		lblHeading.setForeground(headerColor);
		lblHeading.setText("Book Keeper");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
	    txtTitle = new JTextArea("Personal Details");
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
			    
	    txtDescription = new JTextArea("Manage your account information to keep it up to date.");
	    txtDescription.setForeground(darkplainColor);
	    txtDescription.setLineWrap(true);
	    txtDescription.setOpaque(false);
	    txtDescription.setWrapStyleWord(true);
	    txtDescription.setFocusable(false);
	    txtDescription.setEditable(false);
	    txtDescription.setDragEnabled(false);
	    txtDescription.setAutoscrolls(false);
	    
	    lblProfile = new JLabel("Profile");
	    lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
	    lblProfile.setBorder(null);
	    lblProfile.setOpaque(false);
	    lblProfile.setForeground(headerColor);
	    
	    lblName = new JLabel("Name");
	    lblName.setEnabled(false);
	    lblName.setHorizontalAlignment(SwingConstants.LEFT);
	    lblName.setForeground(darkplainColor);
	    lblName.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lblName.setOpaque(false);
	    lblName.setFocusable(false);
	    
	    btnName = new JButton();
	    btnName.setHorizontalTextPosition(SwingConstants.LEFT);
	    btnName.setHorizontalAlignment(SwingConstants.RIGHT);
	    btnName.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnName.setOpaque(false);
	    btnName.setFocusPainted(false);
	    btnName.setBorderPainted(false);
	    btnName.setBackground(new Color(0, 0, 0, 0));
	    
	    lblContactNum = new JLabel("Contact Number");
	    lblContactNum.setEnabled(false);
	    lblContactNum.setHorizontalAlignment(SwingConstants.LEFT);
	    lblContactNum.setForeground(darkplainColor);
	    lblContactNum.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lblContactNum.setOpaque(false);
	    lblContactNum.setFocusable(false);
	    
	    btnContactNum = new JButton();
	    btnContactNum.setHorizontalTextPosition(SwingConstants.LEFT);
	    btnContactNum.setHorizontalAlignment(SwingConstants.RIGHT);
	    btnContactNum.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnContactNum.setOpaque(false);
	    btnContactNum.setFocusPainted(false);
	    btnContactNum.setBorderPainted(false);
	    btnContactNum.setBackground(new Color(0, 0, 0, 0));
	    
	    lblAddress = new JLabel("Home Address");
	    lblAddress.setEnabled(false);
	    lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
	    lblAddress.setForeground(darkplainColor);
	    lblAddress.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lblAddress.setOpaque(false);
	    lblAddress.setFocusable(false);
	    
	    btnAddress = new JButton();
	    btnAddress.setHorizontalTextPosition(SwingConstants.LEFT);
	    btnAddress.setHorizontalAlignment(SwingConstants.RIGHT);
	    btnAddress.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnAddress.setOpaque(false);
	    btnAddress.setFocusPainted(false);
	    btnAddress.setBorderPainted(false);
	    btnAddress.setBackground(new Color(0, 0, 0, 0));
	    
	    txtSecurity = new JTextArea("Password and Security");
	    txtSecurity.setForeground(headerColor);
	    txtSecurity.setLineWrap(true);
	    txtSecurity.setOpaque(false);
	    txtSecurity.setWrapStyleWord(true);
	    txtSecurity.setFocusable(false);
	    txtSecurity.setEditable(false);
	    txtSecurity.setDragEnabled(false);
	    txtSecurity.setAutoscrolls(false);
	    
	    txtSecurityDescription = new JTextArea("Keep your account secure by updating your password.");
	    txtSecurityDescription.setForeground(darkplainColor);
	    txtSecurityDescription.setLineWrap(true);
	    txtSecurityDescription.setOpaque(false);
	    txtSecurityDescription.setWrapStyleWord(true);
	    txtSecurityDescription.setFocusable(false);
	    txtSecurityDescription.setEditable(false);
	    txtSecurityDescription.setDragEnabled(false);
	    txtSecurityDescription.setAutoscrolls(false);
	    
	    lblChangePass = new JLabel("Change Password");
	    lblChangePass.setEnabled(false);
	    lblChangePass.setHorizontalAlignment(SwingConstants.LEFT);
	    lblChangePass.setForeground(darkplainColor);
	    lblChangePass.setBorder(new EmptyBorder(10, 10, 10, 10));
	    lblChangePass.setOpaque(false);
	    lblChangePass.setFocusable(false);
	    
	    btnChangePass = new JButton();
	    btnChangePass.setHorizontalTextPosition(SwingConstants.LEFT);
	    btnChangePass.setHorizontalAlignment(SwingConstants.RIGHT);
	    btnChangePass.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnChangePass.setOpaque(false);
	    btnChangePass.setFocusPainted(false);
	    btnChangePass.setBorderPainted(false);
	    btnChangePass.setBackground(new Color(0, 0, 0, 0));
	    
	    btnDone = new JButton();
	    btnDone.setText("Done");
	    btnDone.setMnemonic(KeyEvent.VK_ENTER);
	    btnDone.setForeground(lightplainColor);
	    btnDone.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnDone.setOpaque(true);
	    btnDone.setFocusPainted(false);
	    btnDone.setBorderPainted(false);
	    btnDone.setBackground(headerColor);
	    
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
	    gbl_mainPanel.rowHeights = new int[]{35, 0, 0, 0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0};
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_headingPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;
	    
	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.anchor = GridBagConstraints.NORTH;
	    gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;	    
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
	    gbl_detailPanel = new GridBagLayout();
	    gbl_detailPanel.columnWidths = new int[]{0};
	    gbl_detailPanel.rowHeights = new int[]{0};
	    gbl_detailPanel.columnWeights = new double[]{1.0};
	    gbl_detailPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lblProfile = new GridBagConstraints();
	    gbc_lblProfile.anchor = GridBagConstraints.NORTH;
	    gbc_lblProfile.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblProfile.insets = new Insets(0,0,0,0);
	    gbc_lblProfile.gridx = 0;
	    gbc_lblProfile.gridy = 0;
	    
	    gbc_namePanel = new GridBagConstraints();
	    gbc_namePanel.anchor = GridBagConstraints.NORTH;
	    gbc_namePanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_namePanel.insets = new Insets(0,0,20,0);
	    gbc_namePanel.gridx = 0;
	    gbc_namePanel.gridy = 1;
			    
	    gbc_contactPanel = new GridBagConstraints();
	    gbc_contactPanel.anchor = GridBagConstraints.NORTH;
	    gbc_contactPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_contactPanel.insets = new Insets(0,0,20,0);
	    gbc_contactPanel.gridx = 0;
	    gbc_contactPanel.gridy = 2;
	    
	    gbc_addressPanel = new GridBagConstraints();
	    gbc_addressPanel.anchor = GridBagConstraints.NORTH;
	    gbc_addressPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_addressPanel.insets = new Insets(0,0,20,0);
	    gbc_addressPanel.gridx = 0;
	    gbc_addressPanel.gridy = 3;
			    
	    gbc_passwordSecurityPanel = new GridBagConstraints();
	    gbc_passwordSecurityPanel.anchor = GridBagConstraints.SOUTH;
	    gbc_passwordSecurityPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_passwordSecurityPanel.insets = new Insets(0,0,20,0);
	    gbc_passwordSecurityPanel.gridx = 0;
	    gbc_passwordSecurityPanel.gridy = 4;
			    
	    gbc_changePassPanel = new GridBagConstraints();
	    gbc_changePassPanel.anchor = GridBagConstraints.NORTH;
	    gbc_changePassPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_changePassPanel.insets = new Insets(0,0,0,0);
	    gbc_changePassPanel.gridx = 0;
	    gbc_changePassPanel.gridy = 5;
	    
	    // User Details and subtitle
	    gbl_titlePanel = new GridBagLayout();
	    gbl_titlePanel.columnWidths = new int[]{865};
	    gbl_titlePanel.rowHeights = new int[]{0, 0};
	    gbl_titlePanel.columnWeights = new double[]{1.0};
	    gbl_titlePanel.rowWeights = new double[]{0.0, 0.0,};
	    
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
			    
	    // NAME PANEL LAYOUT
	    gbl_namePanel = new GridBagLayout();
	    gbl_namePanel.columnWidths = new int[]{0};
	    gbl_namePanel.rowHeights = new int[]{0};
	    gbl_namePanel.columnWeights = new double[]{1.0};
	    gbl_namePanel.rowWeights = new double[]{0.0};
			    
	    gbc_lblName = new GridBagConstraints();
	    gbc_lblName.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblName.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblName.gridx = 0;
	    gbc_lblName.gridy = 0;
			    
	    gbc_btnName = new GridBagConstraints();
	    gbc_btnName.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnName.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnName.gridx = 1;
	    gbc_btnName.gridy = 0;
			    
	    // CONTACT PANEL LAYOUT
	    gbl_contactPanel = new GridBagLayout();
	    gbl_contactPanel.columnWidths = new int[]{0};
	    gbl_contactPanel.rowHeights = new int[]{0};
	    gbl_contactPanel.columnWeights = new double[]{1.0};
	    gbl_contactPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lblContactNum = new GridBagConstraints();
	    gbc_lblContactNum.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblContactNum.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblContactNum.gridx = 0;
	    gbc_lblContactNum.gridy = 0;
	    
	    gbc_btnContactNum = new GridBagConstraints();
	    gbc_btnContactNum.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnContactNum.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnContactNum.gridx = 1;
	    gbc_btnContactNum.gridy = 0;
	    
	    // ADDRESS PANEL LAYOUT
	    gbl_addressPanel = new GridBagLayout();
	    gbl_addressPanel.columnWidths = new int[]{0};
	    gbl_addressPanel.rowHeights = new int[]{0};
	    gbl_addressPanel.columnWeights = new double[]{1.0};
	    gbl_addressPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lblAddress = new GridBagConstraints();
	    gbc_lblAddress.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblAddress.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblAddress.gridx = 0;
	    gbc_lblAddress.gridy = 0;
	    
	    gbc_btnAddress = new GridBagConstraints();
	    gbc_btnAddress.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnAddress.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnAddress.gridx = 1;
	    gbc_btnAddress.gridy = 0;
	    //
	    
	    // Security and subtitle
	    gbl_passwordSecurityPanel = new GridBagLayout();
	   	gbl_passwordSecurityPanel.columnWidths = new int[]{865};
	   	gbl_passwordSecurityPanel.rowHeights = new int[]{0};
	    gbl_passwordSecurityPanel.columnWeights = new double[]{1.0};
	   	gbl_passwordSecurityPanel.rowWeights = new double[]{0.0, 0.0,};
			    
	   	gbc_txtSecurityTitle = new GridBagConstraints();
	   	gbc_txtSecurityTitle.fill = GridBagConstraints.HORIZONTAL;	    
	   	gbc_txtSecurityTitle.insets = new Insets(10, 0, 0, 0);
	   	gbc_txtSecurityTitle.gridx = 0;
	   	gbc_txtSecurityTitle.gridy = 0;
	   	
	   	gbc_txtSecurityDescription = new GridBagConstraints();
	   	gbc_txtSecurityDescription.fill = GridBagConstraints.BOTH;	    
	   	gbc_txtSecurityDescription.insets = new Insets(0,0,0,0);
	   	gbc_txtSecurityDescription.gridx = 0;
	   	gbc_txtSecurityDescription.gridy = 1;
	   	
	   	// ADDRESS PANEL LAYOUT
	   	gbl_changePassPanel = new GridBagLayout();
	   	gbl_changePassPanel.columnWidths = new int[]{0};
	   	gbl_changePassPanel.rowHeights = new int[]{0};
	   	gbl_changePassPanel.columnWeights = new double[]{1.0};
	   	gbl_changePassPanel.rowWeights = new double[]{0.0};
			    
	   	gbc_lblChangePass = new GridBagConstraints();
	   	gbc_lblChangePass.fill = GridBagConstraints.HORIZONTAL;	    
	   	gbc_lblChangePass.insets = new Insets(0, 0, 0, 0); 
	   	gbc_lblChangePass.gridx = 0;
	   	gbc_lblChangePass.gridy = 0;
	   	
	   	gbc_btnChangePass = new GridBagConstraints();
	   	gbc_btnChangePass.fill = GridBagConstraints.HORIZONTAL;	    
	   	gbc_btnChangePass.insets = new Insets(0, 0, 0, 0); 
	   	gbc_btnChangePass.gridx = 1;
	   	gbc_btnChangePass.gridy = 0;
	   
	   	// Set panel layout
	   	mainPanel.setLayout(gbl_mainPanel);
	   	headingPanel.setLayout(new BorderLayout());
	   	titlePanel.setLayout(gbl_titlePanel);
	   	detailPanel.setLayout(gbl_detailPanel);
	   	profilePanel.setLayout(new BorderLayout(0,0));
	   	namePanel.setLayout(gbl_namePanel);
	   	contactPanel.setLayout(gbl_contactPanel);
	   	addressPanel.setLayout(gbl_addressPanel);
	   	passwordSecurityPanel.setLayout(gbl_passwordSecurityPanel);
	   	changePassPanel.setLayout(gbl_changePassPanel);
	   	buttonPanel.setLayout(new BorderLayout(0,0));
			    
	   	//Add all to main panel
	   	headingPanel.add(lblHeading, BorderLayout.WEST);
	   	
	   	titlePanel.add(txtTitle,gbc_txtTitle);
	   	titlePanel.add(txtDescription,gbc_txtDescription);
	   	
	   	namePanel.add(lblName, gbc_lblName);
	   	namePanel.add(btnName, gbc_btnName);
	   	contactPanel.add(lblContactNum, gbc_lblContactNum);
	   	contactPanel.add(btnContactNum, gbc_btnContactNum);	
	   	addressPanel.add(lblAddress, gbc_lblAddress);
	   	addressPanel.add(btnAddress, gbc_btnAddress);
	   	changePassPanel.add(lblChangePass, gbc_lblChangePass);
	   	changePassPanel.add(btnChangePass, gbc_btnChangePass);
	   	
	   	passwordSecurityPanel.add(txtSecurity, gbc_txtSecurityTitle);
	   	passwordSecurityPanel.add(txtSecurityDescription, gbc_txtSecurityDescription);    
	   	
	   	detailPanel.add(lblProfile, gbc_lblProfile);
	   	detailPanel.add(namePanel, gbc_namePanel);
	   	detailPanel.add(contactPanel, gbc_contactPanel);
	   	detailPanel.add(addressPanel, gbc_addressPanel);
	   	detailPanel.add(passwordSecurityPanel, gbc_passwordSecurityPanel);
	   	detailPanel.add(changePassPanel, gbc_changePassPanel);

	   	buttonPanel.add(btnDone);
	   	
	   	mainPanel.add(headingPanel, gbc_headingPanel);
	   	mainPanel.add(titlePanel, gbc_titlePanel);
	   	mainPanel.add(detailPanel, gbc_detailPanel);
	   	mainPanel.add(buttonPanel, gbc_buttonPanel);  	   	
	   	add(mainPanel);
	   	
	   	// Action Listeners
	   	addComponentListener(new ComponentAdapter() {
	   		@Override
	   		public void componentResized(ComponentEvent e) {
	   			titleTextSize = Math.min(getHeight() / 10, getWidth()/ 15) ;
	   			subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 50);
	   			bookTitleTextSize =  Math.min(getHeight() / 15, getWidth()/ 15);
	   			buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	   			headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
	   			plainTextsize =   Math.min(getHeight() / 20, getWidth()/ 50);
	  	        
	   			titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);	  	            
  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize); 	          
  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);	  	          
  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);	  	         
  	            plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
  	            
  	            txtTitle.setFont(titleFont);
  	            txtDescription.setFont(subtitleFont);
  	            txtSecurityDescription.setFont(subtitleFont);
	   			 
	   			txtSecurity.setFont(new Font("Montserrat", Font.BOLD, bookTitleTextSize));   			
	   			lblProfile.setFont(new Font("Montserrat", Font.BOLD, bookTitleTextSize));

	   			btnDone.setFont(buttonFont);
	   			lblHeading.setFont(headerFont);
	   			lblName.setFont(plainFont);
	   			lblContactNum.setFont(plainFont);
	   			lblAddress.setFont(plainFont);
	   			lblChangePass.setFont(plainFont);
	   			
	   		}
	   	});
	   	btnName.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
		    	if(whoAccessed == 2) {
		    		ChangeNamePanel panel = new ChangeNamePanel(patron);
		    		showDialog(panel);
		    	}else {
		    		ChangeNamePanel panel = new ChangeNamePanel(employee);
		    		showDialog(panel);
		    	}
	    	}
	    });
	   	btnChangePass.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(whoAccessed == 2) {
	    			ChangePassPanel panel = new ChangePassPanel(patron);
		    		showDialog(panel);
	    		}else {
	    			ChangePassPanel panel = new ChangePassPanel(employee);
		    		showDialog(panel);
	    		}
	    	}
	    });
	   	btnContactNum.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(whoAccessed == 2) {
	    			ChangeNumPanel panel = new ChangeNumPanel(patron);
		    		showDialog(panel);
	    		}else {
	    			ChangeNumPanel panel = new ChangeNumPanel(employee);
	    			showDialog(panel);
	    		}
	    	}
	    });
	   	btnAddress.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(whoAccessed == 2) {
	    			ChangeAddPanel panel = new ChangeAddPanel(patron);
		    		showDialog(panel);
	    		}else{
	    			ChangeAddPanel panel = new ChangeAddPanel(employee);
		    		showDialog(panel);
	    		}
	    	}
	    });
	}
	
	//constructor for admin
	
	// Methods
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * use super.paintComponent(g) for proper rendering 
		 * of components 
		 */
		iconWidth = (int) (getWidth() * 0.029);
	    iconHeight = (int) (getHeight() * 0.035);
		iconWidth1 = (int) (getWidth() * 0.015);
		iconHeight1 = (int) (getHeight() * 0.03);
		scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
		buttonscaledImage = buttonimage.getScaledInstance(iconWidth1, iconHeight1, Image.SCALE_SMOOTH);
		
		lblHeading.setIcon(new ImageIcon(scaledImage));
		btnName.setIcon(new ImageIcon(buttonscaledImage));
		btnContactNum.setIcon(new ImageIcon(buttonscaledImage));
		btnAddress.setIcon(new ImageIcon(buttonscaledImage));
		btnChangePass.setIcon(new ImageIcon(buttonscaledImage));
	}
	public JButton getBtnSave() {
		return btnDone;
	}
	public void showDialog(ChangeNamePanel panel) {
	    panel.getBtnBack().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	        }
	    });

	    JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Change Information", true);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.getContentPane().add(panel);
	    dialog.pack();
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	}
	public void showDialog(ChangePassPanel panel) {
	    panel.getBtnBack().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	        }
	    });

	    JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Change Information", true);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.getContentPane().add(panel);
	    dialog.pack();
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	}
	public void showDialog(ChangeNumPanel panel) {
	    panel.getBtnBack().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	        }
	    });

	    JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Change Information", true);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.getContentPane().add(panel);
	    dialog.pack();
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	}
	public void showDialog(ChangeAddPanel panel) {
	    panel.getBtnBack().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            closeDialog(e);
	        }
	    });

	    JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Change Information", true);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.getContentPane().add(panel);
	    dialog.pack();
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
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