package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class AdminUserInfoPanel extends JPanel{
		//panel
		private JPanel mainPanel;
		private JPanel headingPanel;
		private JPanel titlePanel;
		private JPanel detailPanel;
		
		private JPanel namePanel;
		private JPanel idAndContactPanel;
		private JPanel emailAddPanel;
		private JPanel addressPanel;
		
		private JPanel securitytTitlePanel;
		private JPanel disablePanel;

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
		private JLabel lblHeading;
		private JLabel lblDisable;

		//textfield
		private JTextArea txtTitle;
		private JTextArea txtDescription;
		
		private PlaceholderTextField txtFirstName;
		private PlaceholderTextField txtLastName;
		private PlaceholderTextField txtPatronID; 
		private PlaceholderTextField txtContactNumber;
		private PlaceholderTextField txtEmailAdd;
		private PlaceholderTextField txtAddress;
		
		private JTextArea txtSecurity;
		private JTextArea txtSecurityDescription;
		
		
		//button
		private JButton btnDisable;
		private JButton btnBack;

		//layout
		private GridBagLayout gbl_mainPanel; 
		private GridBagConstraints gbc_headingPanel;
		private GridBagConstraints gbc_titlePanel;
		private GridBagConstraints gbc_detailPanel;
		private GridBagConstraints gbc_securityPanel;
		private GridBagConstraints gbc_disablePanel;
		
		private GridBagLayout gbl_titlePanel; 
		private GridBagConstraints gbc_txtTitle;
		private GridBagConstraints gbc_txtDescription;
		
		private GridBagLayout gbl_securityPanel; 
		private GridBagConstraints gbc_txtSecurityTitle;
		private GridBagConstraints gbc_txtSecurityDescription;
		
		private GridBagLayout gbl_disablePanel;
		private GridBagConstraints gbc_lblDisable;
		private GridBagConstraints gbc_btnDisable;

		//text
		private  Font titleFont;
		private  Font subtitleFont;
		private  Font headerFont;
		private  Font plainFont;
			
		private  int titleTextSize;
		private  int subtitleTextSize;
		private  int headerTextSize;
		private  int plainTextsize;
		private  Color headerColor = new Color(23, 21, 147);//blue
		private  Color darkplainColor = new Color(14, 14, 15);//black
		private  Color lightplainColor = new Color(250, 251, 255);//white
		private  Color middleplainColor = new Color(243, 243, 247);//dirty white

		public AdminUserInfoPanel() {
			setBackground(new Color(250, 251, 255));
		    setBorder(new EmptyBorder(10, 10, 10, 10));
		    setLayout(new BorderLayout(0, 0));
			
		    //create panels
			mainPanel = new JPanel();//panel to hold all panels
		    headingPanel = new JPanel();
		    titlePanel = new JPanel();
		    detailPanel = new JPanel();
		    
		    namePanel = new JPanel();
			idAndContactPanel = new JPanel();
			emailAddPanel = new JPanel();
			addressPanel = new JPanel();
			
			securitytTitlePanel = new JPanel();
			disablePanel = new JPanel();
		    
			// Set panel properties
		    mainPanel.setBorder(null);
		    disablePanel.setBorder(null);
		    
		    mainPanel.setOpaque(false);
		    headingPanel.setOpaque(false);
		    titlePanel.setOpaque(false);
		    detailPanel.setOpaque(false);
		    namePanel.setOpaque(false);
			idAndContactPanel.setOpaque(false);
			emailAddPanel.setOpaque(false);
			addressPanel.setOpaque(false);
			securitytTitlePanel.setOpaque(false);
			disablePanel.setBackground(middleplainColor);
		    
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
		  
		    btnBack = new JButton("Back");
		    btnBack.setFocusPainted(false);
		    btnBack.setForeground(new Color(23, 21, 147));
		    btnBack.setBorderPainted(false);
		    btnBack.setBorder(new EmptyBorder(5, 5, 5, 5));
		    btnBack.setOpaque(false);

		    txtTitle = new JTextArea("User Details");
		    txtTitle.setForeground(headerColor);
		    txtTitle.setLineWrap(true);
		    txtTitle.setOpaque(false);
		    txtTitle.setWrapStyleWord(true);
		    txtTitle.setFocusable(false);
		    txtTitle.setEditable(false);
		    txtTitle.setDragEnabled(false);
		    txtTitle.setAutoscrolls(false);
		    
		    txtDescription = new JTextArea("View and manage user information to gain insight and maintain accurate records.");
		    txtDescription.setForeground(darkplainColor);
			txtDescription.setLineWrap(true);
			txtDescription.setOpaque(false);
			txtDescription.setWrapStyleWord(true);
			txtDescription.setFocusable(false);
			txtDescription.setEditable(false);
			txtDescription.setDragEnabled(false);
			txtDescription.setAutoscrolls(false);
			
			txtFirstName = new PlaceholderTextField("First Name");
			txtFirstName.setHorizontalAlignment(SwingConstants.LEFT);
			txtFirstName.setForeground(darkplainColor);
			txtFirstName.setBackground(middleplainColor);
			txtFirstName.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtFirstName.setOpaque(true);
			txtFirstName.setFocusable(false);
			txtFirstName.setEditable(false);
			txtFirstName.setDragEnabled(false);
			
			txtLastName = new PlaceholderTextField("Last Name");
			txtLastName.setHorizontalAlignment(SwingConstants.LEFT);
			txtLastName.setForeground(darkplainColor);
			txtLastName.setBackground(middleplainColor);
			txtLastName.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtLastName.setOpaque(true);
			txtLastName.setFocusable(false);
			txtLastName.setEditable(false);
			txtLastName.setDragEnabled(false);
			
			txtPatronID = new PlaceholderTextField("AAAAAAAAAAA");
			txtPatronID.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtPatronID.setHorizontalAlignment(SwingConstants.LEFT);
			txtPatronID.setForeground(darkplainColor);
			txtPatronID.setBackground(middleplainColor);
			txtPatronID.setOpaque(true);
			txtPatronID.setFocusable(false);
			txtPatronID.setEditable(false);
			txtPatronID.setDragEnabled(false);
			
			txtContactNumber = new PlaceholderTextField("000000000000");
			txtContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
			txtContactNumber.setForeground(darkplainColor);
			txtContactNumber.setBackground(middleplainColor);
			txtContactNumber.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtContactNumber.setOpaque(true);
			txtContactNumber.setFocusable(false);
			txtContactNumber.setEditable(false);
			txtContactNumber.setDragEnabled(false);
			
			txtEmailAdd = new PlaceholderTextField("sample@gmail.com");
			txtEmailAdd.setHorizontalAlignment(SwingConstants.LEFT);
			txtEmailAdd.setForeground(darkplainColor);
			txtEmailAdd.setBackground(middleplainColor);
			txtEmailAdd.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtEmailAdd.setOpaque(true);
			txtEmailAdd.setFocusable(false);
			txtEmailAdd.setEditable(false);
			txtEmailAdd.setDragEnabled(false);
			
			txtAddress = new PlaceholderTextField("House No. / Block No / Street / Brgy. / City");
			txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
			txtAddress.setForeground(darkplainColor);
			txtAddress.setBackground(middleplainColor);
			txtAddress.setBorder(new EmptyBorder(10, 10, 10, 10));
			txtAddress.setOpaque(true);
			txtAddress.setFocusable(false);
			txtAddress.setEditable(false);
			txtAddress.setDragEnabled(false);
			
			txtSecurity = new JTextArea("Security");
			txtSecurity.setForeground(headerColor);
			txtSecurity.setLineWrap(true);
			txtSecurity.setOpaque(false);
		    txtSecurity.setWrapStyleWord(true);
		    txtSecurity.setFocusable(false);
		    txtSecurity.setEditable(false);
		    txtSecurity.setDragEnabled(false);
		    txtSecurity.setAutoscrolls(false);
		    
		    txtSecurityDescription = new JTextArea("Keep the system secure by monitoring control over user access.");
		    txtSecurityDescription.setForeground(darkplainColor);
		    txtSecurityDescription.setLineWrap(true);
		    txtSecurityDescription.setOpaque(false);
		    txtSecurityDescription.setWrapStyleWord(true);
		    txtSecurityDescription.setFocusable(false);
		    txtSecurityDescription.setEditable(false);
			txtSecurityDescription.setDragEnabled(false);
			txtSecurityDescription.setAutoscrolls(false);

		
			lblDisable = new JLabel("Disable User");
			lblDisable.setEnabled(false);
			lblDisable.setHorizontalAlignment(SwingConstants.LEFT);
			lblDisable.setForeground(darkplainColor);
			lblDisable.setBorder(new EmptyBorder(10, 10, 10, 10));
			lblDisable.setOpaque(false);
			lblDisable.setFocusable(false);

			
			btnDisable = new JButton();
			btnDisable.setHorizontalTextPosition(SwingConstants.LEFT);
			btnDisable.setHorizontalAlignment(SwingConstants.RIGHT);
			btnDisable.setBorder(new EmptyBorder(10, 10, 10, 10));
			btnDisable.setOpaque(false);
			btnDisable.setFocusPainted(false);
			btnDisable.setBorderPainted(false);
		    
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
		    gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		    gbl_mainPanel.columnWeights = new double[]{1.0};
		    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		      
		    gbc_headingPanel = new GridBagConstraints();
		    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
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
		    gbc_detailPanel.fill = GridBagConstraints.BOTH;	    
		    gbc_detailPanel.insets = new Insets(20, 20, 20, 20);
		    gbc_detailPanel.gridx = 0;
		    gbc_detailPanel.gridy = 2;
		    
		    gbc_securityPanel = new GridBagConstraints();
		    gbc_securityPanel.fill = GridBagConstraints.HORIZONTAL;	    
		    gbc_securityPanel.insets = new Insets(20, 20, 20, 20);
		    gbc_securityPanel.gridx = 0;
		    gbc_securityPanel.gridy = 3;
		    
		    gbc_disablePanel = new GridBagConstraints();
		    gbc_disablePanel.anchor = GridBagConstraints.NORTH;
		    gbc_disablePanel.fill = GridBagConstraints.HORIZONTAL;	    
		    gbc_disablePanel.insets = new Insets(20, 20, 20, 20);
		    gbc_disablePanel.gridx = 0;
		    gbc_disablePanel.gridy = 4;
		    
		    // User Details and subtitle
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
		    		    
		    // Security and subtitle
			gbl_securityPanel = new GridBagLayout();
			gbl_securityPanel.columnWidths = new int[]{865};
			gbl_securityPanel.rowHeights = new int[]{35, 0};
			gbl_securityPanel.columnWeights = new double[]{1.0};
			gbl_securityPanel.rowWeights = new double[]{0.0, 0.0,};
		    
		    gbc_txtSecurityTitle = new GridBagConstraints();
		    gbc_txtSecurityTitle.fill = GridBagConstraints.HORIZONTAL;	    
		    gbc_txtSecurityTitle.insets = new Insets(0, 0, 0, 0);
		    gbc_txtSecurityTitle.gridx = 0;
		    gbc_txtSecurityTitle.gridy = 0;
		    
		    gbc_txtSecurityDescription = new GridBagConstraints();
		    gbc_txtSecurityDescription.fill = GridBagConstraints.BOTH;	    
		    gbc_txtSecurityDescription.insets = new Insets(0,0,0,0);
		    gbc_txtSecurityDescription.gridx = 0;
		    gbc_txtSecurityDescription.gridy = 1;
		    
		    // Disable Panel
		    gbl_disablePanel = new GridBagLayout();
		    gbl_disablePanel.columnWidths = new int[]{0};
		    gbl_disablePanel.rowHeights = new int[]{0};
		    gbl_disablePanel.columnWeights = new double[]{1.0};
		    gbl_disablePanel.rowWeights = new double[]{0.0};
		    
		    gbc_lblDisable = new GridBagConstraints();
		    gbc_lblDisable.fill = GridBagConstraints.HORIZONTAL;	    
		    gbc_lblDisable.insets = new Insets(0, 0, 0, 0); 
		    gbc_lblDisable.gridx = 0;
		    gbc_lblDisable.gridy = 0;
		    
		    gbc_btnDisable = new GridBagConstraints();
		    gbc_btnDisable.fill = GridBagConstraints.HORIZONTAL;	    
		    gbc_btnDisable.insets = new Insets(0, 20, 0, 0); 
		    gbc_btnDisable.gridx = 1;
		    gbc_btnDisable.gridy = 0;
		   
		    // Set panel layout
		    mainPanel.setLayout(gbl_mainPanel);
		    headingPanel.setLayout(new BorderLayout(0,0));
		    titlePanel.setLayout(gbl_titlePanel);
		    detailPanel.setLayout(new GridLayout(4, 0, 0, 30)); 
		    securitytTitlePanel.setLayout(gbl_securityPanel);
		    disablePanel.setLayout(gbl_disablePanel);

			emailAddPanel.setLayout(new BorderLayout(0,0));
			addressPanel.setLayout(new BorderLayout(0,0));
		    namePanel.setLayout(new GridLayout(0, 2, 15, 0));
		    idAndContactPanel.setLayout(new GridLayout(0, 2, 15, 0));
		    
		    //Add all to main panel
		    headingPanel.add(lblHeading, BorderLayout.WEST);
		    headingPanel.add(btnBack, BorderLayout.EAST);
		    titlePanel.add(txtTitle,gbc_txtTitle);
		    titlePanel.add(txtDescription,gbc_txtDescription);
		    namePanel.add(txtFirstName);
		    namePanel.add(txtLastName);
		    idAndContactPanel.add(txtPatronID);
		    idAndContactPanel.add(txtContactNumber);
		    emailAddPanel.add(txtEmailAdd, BorderLayout.CENTER);
		    addressPanel.add(txtAddress, BorderLayout.CENTER);
		    securitytTitlePanel.add(txtSecurity, gbc_txtSecurityTitle);
		    securitytTitlePanel.add(txtSecurityDescription, gbc_txtSecurityDescription);
		    disablePanel.add(lblDisable, gbc_lblDisable);
		    disablePanel.add(btnDisable, gbc_btnDisable);
		    detailPanel.add(namePanel);
		    detailPanel.add(idAndContactPanel);
		    detailPanel.add(emailAddPanel);
		    detailPanel.add(addressPanel);
		    mainPanel.add(headingPanel, gbc_headingPanel);
		    mainPanel.add(titlePanel, gbc_titlePanel);
		    mainPanel.add(detailPanel, gbc_detailPanel);
		    mainPanel.add(securitytTitlePanel, gbc_securityPanel);
		    mainPanel.add(disablePanel, gbc_disablePanel);
		    
		    add(mainPanel);
		    
		    addComponentListener(new ComponentAdapter() {
		    	  @Override
		          public void componentResized(ComponentEvent e) {
		    		  titleTextSize = Math.min(getHeight() / 10, getWidth()/ 15) ;
		  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 50);
		  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
		  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
		 
		  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
		  	            txtTitle.setFont(titleFont);
		  	            txtSecurity.setFont(titleFont);
		  	            
		  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
		  	            txtDescription.setFont(subtitleFont);
		  	            txtSecurityDescription.setFont(subtitleFont);
		  	            
		  	            
		  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
		  	            btnBack.setFont(headerFont);
		  	            lblHeading.setFont(headerFont);
		  	            
		  	            plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
		  	            txtFirstName.setFont(plainFont);
		  	            txtLastName.setFont(plainFont);
		  	            txtPatronID.setFont(plainFont);
		  	            txtContactNumber.setFont(plainFont);
		  	            txtEmailAdd.setFont(plainFont);
		  	            txtAddress.setFont(plainFont);
		  	            lblDisable.setFont(plainFont);		  	        

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
		    iconWidth1 = (int) (getWidth() * 0.015);
		    iconHeight1 = (int) (getHeight() * 0.02);
		    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
		    buttonscaledImage = buttonimage.getScaledInstance(iconWidth1, iconHeight1, Image.SCALE_SMOOTH);

		    lblHeading.setIcon(new ImageIcon(scaledImage));
			btnDisable.setIcon(new ImageIcon(buttonscaledImage));

		 }
	}