package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;


public class SignUpPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel emailPanel;
	private JPanel homeAddressPanel;
	private JPanel contactNumberPanel;
	private JPanel subtitlePanel;	
	private JPanel buttonPanel;
	//label
	private JLabel lblTitle;
	private JLabel lblSubTitle;
	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblEmailAddress;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblHomeAddress;
	private JLabel lblContactNumber;
	
	//textfield
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderTextField txtHomeAddress;
	private PlaceholderTextField txtContactNumber;
	
	//icon
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private int iconHeight; 
	private int iconWidth;
	
	//Button
	private JButton btnSignUp;
	private JButton btnClear;
	private JButton btnBack;
	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagConstraints gbc_emailPanel;
	private GridBagConstraints gbc_homeAddressPanel;
	private GridBagConstraints gbc_contactNumberPanel;
	private GridBagLayout gbl_inputPanel;
	private GridBagConstraints gbc_firstNamePanel;
	private GridBagConstraints gbc_lastNamePanel;
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
	private  Color headerColor = new Color(23, 21, 147);
	private  Color darkplainColor = new Color(14, 14, 15);
	private  Color lightplainColor = new Color(250, 251, 255);
	private  Color middleplainColor = new Color(243, 243, 247);

	

public  SignUpPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel();
    logoPanel = new JPanel();
    titlePanel = new JPanel();
    inputPanel = new JPanel();
    firstNamePanel = new JPanel();
    subtitlePanel = new JPanel();
    emailPanel = new JPanel();
    homeAddressPanel = new JPanel();    
    contactNumberPanel = new JPanel();
    buttonPanel = new JPanel();
    lastNamePanel = new JPanel();

    // Set panel properties
    mainPanel.setBorder(null);
    titlePanel.setBorder(new EmptyBorder(15, 100, 0, 100));
    subtitlePanel.setBorder(new EmptyBorder(0, 100, 10, 100));
    inputPanel.setBorder(new EmptyBorder(20, 100, 5, 100));
    buttonPanel.setBorder(new EmptyBorder(25, 0, 25, 0));

    mainPanel.setOpaque(false);
    subtitlePanel.setOpaque(false);
    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    inputPanel.setOpaque(false);
    firstNamePanel.setOpaque(false);
    emailPanel.setOpaque(false);
    homeAddressPanel.setOpaque(false);
    contactNumberPanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    lastNamePanel.setOpaque(false);

   
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
    
    lblTitle = new JLabel("SIGN UP");
    lblTitle.setBorder(null);
    lblTitle.setForeground(headerColor);
    lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
    
    lblSubTitle = new JLabel("Register a new account by filling in the details below. ");
    lblSubTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblSubTitle.setBorder(null);
    lblSubTitle.setForeground(darkplainColor);

    lblFirstName = new JLabel("First Name:");
    lblFirstName.setForeground(darkplainColor);
    
    txtFirstName  = new PlaceholderTextField("Juan ");
    txtFirstName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtFirstName.setBackground(middleplainColor);
    
    lblLastName = new JLabel("Last Name:");
    lblLastName.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 18));
    lblLastName.setForeground(darkplainColor);
    
    txtLastName  = new PlaceholderTextField("Dela Cruz");
    txtLastName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtLastName.setBackground(middleplainColor);

    lblEmailAddress = new JLabel("Email Address:");
    lblEmailAddress.setForeground(darkplainColor);
    
    txtEmailAddress = new PlaceholderTextField("sample@email.com");
    txtEmailAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtEmailAddress.setBackground(middleplainColor);
    
    lblHomeAddress = new JLabel("Home Address:");
    lblHomeAddress.setForeground(darkplainColor);
    
    txtHomeAddress = new PlaceholderTextField("House No. / Block No. / Street / Barangay / City");
    txtHomeAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtHomeAddress.setBackground(middleplainColor);
    
    lblContactNumber = new JLabel("Contact Number:");
    lblContactNumber.setForeground(darkplainColor);
    
    txtContactNumber = new PlaceholderTextField("00000000000");
    txtContactNumber.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtContactNumber.setBackground(middleplainColor);
    
    btnClear = new JButton("Clear");
    btnClear.setOpaque(true);
    btnClear.setForeground(new Color(250, 251, 255));
    btnClear.setFont(new Font("Montserrat", Font.ITALIC, 15));
    btnClear.setFocusPainted(false);
    btnClear.setBorderPainted(false);
    btnClear.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnClear.setBackground(headerColor);
    
    btnSignUp = new JButton("Sign Up");
    btnSignUp.setForeground(new Color(250, 251, 255));
    btnSignUp.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnSignUp.setFont(new Font("Montserrat", Font.ITALIC, 15));
    btnSignUp.setOpaque(true);
    btnSignUp.setFocusPainted(false);
    btnSignUp.setBorderPainted(false);
    btnSignUp.setBackground(headerColor);

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
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.insets = new Insets(5, 5, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    
    gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.insets = new Insets(0, 0, 5, 0);
    gbc_titlePanel.anchor = GridBagConstraints.SOUTHWEST;
    gbc_titlePanel.gridx = 0;
    gbc_titlePanel.gridy = 1;
    
    gbc_inputPanel = new GridBagConstraints();
    gbc_inputPanel.fill = GridBagConstraints.BOTH;
    gbc_inputPanel.gridx = 0;
    gbc_inputPanel.gridy = 3;

    gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.insets = new Insets(0, 0, 5, 0);
    gbc_subtitlePanel.fill = GridBagConstraints.BOTH;
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 2;

    gbl_inputPanel = new GridBagLayout();
    gbl_inputPanel.columnWidths = new int[]{120, 543, 543, 0};
    gbl_inputPanel.rowHeights = new int[] {80, 80, 80, 0, 0, 0};
    gbl_inputPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
    gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    
    gbc_firstNamePanel = new GridBagConstraints();
    gbc_firstNamePanel.gridwidth = 2;
    gbc_firstNamePanel.fill = GridBagConstraints.BOTH;
    gbc_firstNamePanel.insets = new Insets(0, 0, 0, 35);
    gbc_firstNamePanel.gridx = 0;
    gbc_firstNamePanel.gridy = 0;
    
    gbc_lastNamePanel = new GridBagConstraints();
    gbc_lastNamePanel.fill = GridBagConstraints.BOTH;
    gbc_lastNamePanel.gridx = 2;
    gbc_lastNamePanel.gridy = 0;
    
    gbc_emailPanel = new GridBagConstraints();
    gbc_emailPanel.insets = new Insets(5, 0, 0, 0);
    gbc_emailPanel.gridwidth = 3;
    gbc_emailPanel.fill = GridBagConstraints.BOTH;
    gbc_emailPanel.gridx = 0;
    gbc_emailPanel.gridy = 1;
    
    gbc_homeAddressPanel = new GridBagConstraints();
    gbc_homeAddressPanel.gridwidth = 3;
    gbc_homeAddressPanel.fill = GridBagConstraints.BOTH;
    gbc_homeAddressPanel.insets = new Insets(5, 0, 0, 0);
    gbc_homeAddressPanel.gridx = 0;
    gbc_homeAddressPanel.gridy = 2;
    
    gbc_contactNumberPanel = new GridBagConstraints();
    gbc_contactNumberPanel.insets = new Insets(5, 0, 0, 0);
    gbc_contactNumberPanel.gridwidth = 3;
    gbc_contactNumberPanel.fill = GridBagConstraints.BOTH;
    gbc_contactNumberPanel.gridx = 0;
    gbc_contactNumberPanel.gridy = 3;
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.gridwidth = 3;
    gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
    gbc_buttonPanel.fill = GridBagConstraints.BOTH;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    // Set panel layout
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BorderLayout(0,0));
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    buttonPanel.setLayout(new GridLayout(0, 2, 30, 0));
    contactNumberPanel.setLayout(new GridLayout(2, 1, 0, 0));
    homeAddressPanel.setLayout(new GridLayout(2, 1, 0, 0));
    emailPanel.setLayout(new GridLayout(2, 1, 0, 0));
    firstNamePanel.setLayout(new GridLayout(2, 1, 0, 0));
    inputPanel.setLayout(gbl_inputPanel);
    lastNamePanel.setLayout(new GridLayout(0, 1, 0, 0));
    subtitlePanel.setLayout(new BorderLayout(0, 0));

    //Add all to main panel
    headingPanel.add(lblHeading, BorderLayout.WEST);
    headingPanel.add(btnBack, BorderLayout.EAST);
    titlePanel.add(lblTitle);
    subtitlePanel.add(lblSubTitle);
    firstNamePanel.add(lblFirstName);
    firstNamePanel.add(txtFirstName);  
    lastNamePanel.add(lblLastName);
    lastNamePanel.add(txtLastName);
    emailPanel.add(lblEmailAddress);
    emailPanel.add(txtEmailAddress);     
    homeAddressPanel.add(lblHomeAddress);
    homeAddressPanel.add(txtHomeAddress);
    contactNumberPanel.add(lblContactNumber);
    contactNumberPanel.add(txtContactNumber);
    buttonPanel.add(btnSignUp);
    buttonPanel.add(btnClear);
    
    inputPanel.add(firstNamePanel, gbc_firstNamePanel);
    inputPanel.add(lastNamePanel, gbc_lastNamePanel);
    inputPanel.add(emailPanel, gbc_emailPanel);
    inputPanel.add(homeAddressPanel, gbc_homeAddressPanel);
    inputPanel.add(contactNumberPanel, gbc_contactNumberPanel);
    inputPanel.add(buttonPanel, gbc_buttonPanel);

    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(titlePanel, gbc_titlePanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(inputPanel, gbc_inputPanel);
    
    add(mainPanel);
    addComponentListener(new ComponentAdapter() {
    	  @Override
          public void componentResized(ComponentEvent e) {
          	
  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
  	            buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 60);
  	            
  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
  	            lblTitle.setFont(titleFont);
  	            
  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
  	            lblSubTitle.setFont(subtitleFont);
  	            
  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
  	            btnSignUp.setFont(buttonFont);
  	            btnClear.setFont(buttonFont);
  	            
  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
  	            btnBack.setFont(headerFont);
  	            lblHeading.setFont(headerFont);
  	            
  	            plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
  	            lblFirstName.setFont(plainFont);
  	            lblLastName.setFont(plainFont);
  	            lblEmailAddress.setFont(plainFont);
	  	        lblHomeAddress.setFont(plainFont);
  	            lblContactNumber.setFont(plainFont);
  	        

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
   iconHeight = (int) (getHeight() * 0.04);
   scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
   lblHeading.setIcon(new ImageIcon(scaledImage));

}
}