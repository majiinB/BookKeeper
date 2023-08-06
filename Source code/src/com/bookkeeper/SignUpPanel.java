package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
	private PlaceholderTextField txtHouseNum; 
	private PlaceholderTextField txtBlockNum;
	private PlaceholderTextField txtStreet;
	private PlaceholderTextField txtBarangay;
	private PlaceholderTextField txtCity;
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
	
	private GridBagLayout  gbl_homeAddressPanel;
	private GridBagConstraints  gbc_lblHomeAddress;
	private GridBagConstraints  gbc_txtHouseNum;
	private GridBagConstraints  gbc_txtBlockNum;
	private GridBagConstraints  gbc_txtStreet;
	private GridBagConstraints  gbc_txtBarangay;
	private GridBagConstraints  gbc_txtCity;
	
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
    btnBack.setOpaque(false);

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
    
    txtFirstName  = new PlaceholderTextField("First name");
    txtFirstName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtFirstName.setBackground(middleplainColor);
    
    lblLastName = new JLabel("Last Name:");
    lblLastName.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 18));
    lblLastName.setForeground(darkplainColor);
    
    txtLastName  = new PlaceholderTextField("Last name");
    txtLastName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtLastName.setBackground(middleplainColor);

    lblEmailAddress = new JLabel("Email Address:");
    lblEmailAddress.setForeground(darkplainColor);
    
    txtEmailAddress = new PlaceholderTextField("sample@email.com");
    txtEmailAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtEmailAddress.setBackground(middleplainColor);
    
    lblHomeAddress = new JLabel("Home Address:");
    lblHomeAddress.setForeground(darkplainColor);
    
    txtHouseNum = new PlaceholderTextField("House No.");
    txtHouseNum.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtHouseNum.setBackground(middleplainColor);
    
    txtBlockNum = new PlaceholderTextField("Block No.");
    txtBlockNum.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtBlockNum.setBackground(middleplainColor);
    
    txtStreet = new PlaceholderTextField("Street");
    txtStreet.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtStreet.setBackground(middleplainColor);

    txtBarangay = new PlaceholderTextField("Barangay");
    txtBarangay.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtBarangay.setBackground(middleplainColor);

    txtCity = new PlaceholderTextField("City");
    txtCity.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtCity.setBackground(middleplainColor);
    
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
    gbl_mainPanel.rowHeights = new int[]{35, 0, 0, 0};
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
    gbl_inputPanel.columnWidths = new int[]{100, 543, 543, 0};
    gbl_inputPanel.rowHeights = new int[] {80, 80, 80, 0, 0, 0};
    gbl_inputPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    
    gbc_firstNamePanel = new GridBagConstraints();
    gbc_firstNamePanel.gridwidth = 2;
    gbc_firstNamePanel.fill = GridBagConstraints.BOTH;
    gbc_firstNamePanel.insets = new Insets(0, 0, 0, 35);
    gbc_firstNamePanel.gridx = 0;
    gbc_firstNamePanel.gridy = 0;
    
    gbc_lastNamePanel = new GridBagConstraints();
    gbc_firstNamePanel.gridwidth = 2;
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
    
    // Home Address Layouts
    gbl_homeAddressPanel = new GridBagLayout();
    gbl_homeAddressPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
    gbl_homeAddressPanel.rowHeights = new int[]{1, 0};
    gbl_homeAddressPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
    gbl_homeAddressPanel.rowWeights = new double[]{0.0, 0.0};
    
    gbc_lblHomeAddress = new GridBagConstraints();
    gbc_lblHomeAddress.fill = GridBagConstraints.BOTH;
    gbc_lblHomeAddress.insets = new Insets(5, 0, 0, 0);
    gbc_lblHomeAddress.gridx = 0;
    gbc_lblHomeAddress.gridy = 0;
    
    gbc_txtHouseNum = new GridBagConstraints();
    gbc_txtHouseNum.fill = GridBagConstraints.BOTH;
    gbc_txtHouseNum.insets = new Insets(5, 0, 0, 15);
    gbc_txtHouseNum.gridx = 0;
    gbc_txtHouseNum.gridy = 1;
    
    gbc_txtBlockNum = new GridBagConstraints();
    gbc_txtBlockNum.fill = GridBagConstraints.BOTH;
    gbc_txtBlockNum.insets = new Insets(5, 15, 0, 15);
    gbc_txtBlockNum.gridx = 1;
    gbc_txtBlockNum.gridy = 1;
    
    gbc_txtStreet = new GridBagConstraints();
    gbc_txtStreet.fill = GridBagConstraints.BOTH;
    gbc_txtStreet.insets = new Insets(5, 15, 0, 15);
    gbc_txtStreet.gridx = 2;
    gbc_txtStreet.gridy = 1;
    
    gbc_txtBarangay = new GridBagConstraints();
    gbc_txtBarangay.fill = GridBagConstraints.BOTH;
    gbc_txtBarangay.insets = new Insets(5, 15, 0, 15);
    gbc_txtBarangay.gridx = 3;
    gbc_txtBarangay.gridy = 1;
    
    gbc_txtCity = new GridBagConstraints();
    gbc_txtCity.fill = GridBagConstraints.BOTH;
    gbc_txtCity.insets = new Insets(5, 0, 0, 0);
    gbc_txtCity.gridx = 4;
    gbc_txtCity.gridy = 1;
    //
    
    // Set panel layout
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BorderLayout(0,0));
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    buttonPanel.setLayout(new GridLayout(0, 2, 30, 0));
    contactNumberPanel.setLayout(new GridLayout(2, 1, 0, 0));
    homeAddressPanel.setLayout(gbl_homeAddressPanel);
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
    homeAddressPanel.add(lblHomeAddress, gbc_lblHomeAddress);

    homeAddressPanel.add(txtHouseNum,gbc_txtHouseNum);
    homeAddressPanel.add(txtBlockNum, gbc_txtBlockNum);
    homeAddressPanel.add(txtStreet, gbc_txtStreet);
    homeAddressPanel.add(txtBarangay,gbc_txtBarangay);
    homeAddressPanel.add(txtCity, gbc_txtCity);
    
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
          	
    		  titleTextSize = Math.min(getHeight() / 10, getWidth()/ 15) ;
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
    btnClear.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		txtFirstName.clearInputAndGetPlaceholder();
    		txtLastName.clearInputAndGetPlaceholder();
    		txtEmailAddress.clearInputAndGetPlaceholder();
    		txtContactNumber.clearInputAndGetPlaceholder();
    		txtHouseNum.clearInputAndGetPlaceholder();
    		txtStreet.clearInputAndGetPlaceholder();
    		txtBarangay.clearInputAndGetPlaceholder();
    		txtCity.clearInputAndGetPlaceholder();
    	}
    });
    btnSignUp.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String fname = txtFirstName.getText().trim();
			String lname = txtLastName.getText().trim();
			String userEmail = txtEmailAddress.getText().trim();
			String userContact = txtContactNumber.getText().trim();
			String house = txtHouseNum.getText().trim();
			String street = txtStreet.getText().trim();
			String barangay = txtBarangay.getText().trim();
			String city = txtCity.getText().trim();
		
			String userAddress = house + ", " + street + ", " 
			+ barangay + ", " + city;
			
			// Check fname input
			if (fname.isBlank() || fname.length() < 3 || fname.equals("First name")) {
				MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Invalid input for First name");
				showDialog(mal);
				return;
			}

			// Check lname input
			if (lname.isEmpty() || lname.length() < 3 || lname.equals("Last name")) {
				MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Invalid input for Last name");
				showDialog(mal);
				return;
			}

			// Check email input
			if (userEmail.isBlank() || userEmail.length() < 12 || userEmail.equals("sample@email.com") || !isValidEmail(userEmail)) {
				MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Invalid input for Email");
				showDialog(mal);
				return;
			}

			// Check contact input
			if (userContact.isBlank() || userContact.length() != 11 || userContact.equals("00000000000") || !isNumeric(userContact)) {
				MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Invalid input for Contact number");
				showDialog(mal);
				return;
			}

			// Check address input
			
			if (house.isBlank() || house.length() < 3 || house.equals("Home No.") || street.isBlank() || street.length() < 3 || street.equals("Street") ||
				barangay.isBlank() || barangay.length() < 3 || barangay.equals("Barangay") || city.isBlank() || city.length() < 3 || city.equals("City")) {
				MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Invalid input for Address");
				showDialog(mal);
				return;
			}
			
			try {
				
				//Call signup method from the MainFrame
				signUp(fname, lname, userEmail, userContact, userAddress, 2);
				closeDialog(e);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	   iconWidth = (int) (getWidth() * 0.025);
	   iconHeight = (int) (getHeight() * 0.04);
	   scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
	   lblHeading.setIcon(new ImageIcon(scaledImage));
	
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public static boolean isNumeric(String str) {
        // Use regular expression to check if the string contains only numeric characters
        return str.matches("\\d+");
    }
	public void signUp(String fName, String lName, String userEmail, String userContact, String userAddress, int forQuery) throws Exception{
			Connection conn = null;
		    String url = "jdbc:mysql://localhost/book_keeper";
		    String user = "root";
		    String password = "";
		    String pass ="";
		    boolean condition = true;
		    boolean con1 = true;
		    String encrypted = ""; 
		    String status = "Active";
		    String position = "Employee";
		    int penalty = 0;

		    pass = generateRandomPass();
		    	
		    PreparedStatement stmt = null;
		    try {
	   		 	//Connect to book_keeper Database
	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	  	         conn = DriverManager.getConnection(url, user, password);
	  	         
	  	         //Check email Existence
	  	         condition = checkEmailExistence(userEmail, forQuery);
	  	         if(condition) {
	  	        	MalfunctionPanel mal = new MalfunctionPanel("SignUp Error", "Email Already taken");
					showDialog(mal);
	  	         }else {
	  	        	 if(forQuery == 1) {
	  	        		encrypted = AuthenticationFrame.encryption(pass);
		  	        	//prepare query
	  	  
			  	         String query = "INSERT INTO patron (patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_password, patron_status, penalty)"
			  	         		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			  	         stmt = conn.prepareStatement(query);
						 stmt.setString(1, fName);
						 stmt.setString(2, lName); 
						 stmt.setString(3, userEmail); 
						 stmt.setString(4, userContact); 
						 stmt.setString(5, userAddress); 
						 stmt.setString(6, encrypted); 
						 stmt.setString(7, status); 
						 stmt.setInt(8, penalty);
			  	         stmt.executeUpdate();
			  	         
			  	         // Show alert message
			  	         SuccessPanel success = new SuccessPanel("READ BEFORE CLOSING", "Please take note of the info that will be given before closing this pop-up\n"
			  	         		+ "After closing this pop-up no copy of the information that will be given will be saved\n"
			  	         		+ "Employee "+ fName +" has been added\n"
			  	         		+ "Employee Email: " + userEmail
			  	         		+ "\nEmployee Password: " + pass);
			  	         showDialog(success);
	  	        	 }
	  	        	 else{
	  	        		 encrypted = AuthenticationFrame.encryption(pass);
	  	        		 //prepare query
	  	        		 String query = "INSERT INTO admin (admin_fname, admin_lname, admin_email, admin_position, admin_password, admin_status, admin_contact, admin_address)" 
	  	        		 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			  	         stmt = conn.prepareStatement(query);
						 stmt.setString(1, fName);
						 stmt.setString(2, lName); 
						 stmt.setString(3, userEmail); 
						 stmt.setString(4, position); 
						 stmt.setString(5, encrypted); 
						 stmt.setString(6, status); 
						 stmt.setString(7, userContact); 
						 stmt.setString(8, userAddress); 
			  	         stmt.executeUpdate();
			  	         
			  	         // Show alert message
			  	         SuccessPanel success = new SuccessPanel("READ BEFORE CLOSING", "Please take note of the info that will be given before closing this pop-up\n"
			  	         		+ "After closing this pop-up no copy of the information that will be given will be saved\n"
			  	         		+ "Employee "+ fName +" has been added\n"
			  	         		+ "Employee Email: " + userEmail
			  	         		+ "\nEmployee Password: " + pass);
			  	         showDialog(success);

	  	        	 }
	  	         }  
	        } catch (ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	        } finally {
	             // Close the resources
	             try {
					if (stmt != null)
	                    stmt.close(); 
	                if (conn != null)
	                    conn.close();
	             } catch (SQLException se) {
	                se.printStackTrace();
	         }
	       }
		}
	public boolean checkEmailExistence(String userEmail, int con) {
			Connection conn = null;
			String url = "jdbc:mysql://localhost/book_keeper";
		    String user = "root";
		    String password = "";
		    boolean forReturn = false;
		    String query = "";
		    
		    try {
	   		 	//Connect to book_keeper Database
	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	  	         conn = DriverManager.getConnection(url, user, password);
	  	         //System.out.println("Connected to the database");
	  	         
	  	         //prepare query
	  	         if(con == 1) {
	  	        	query = "SELECT * FROM patron WHERE BINARY patron_email=?";
	  	         }else {
	  	        	query = "SELECT * FROM admin WHERE BINARY admin_email=?";
	  	         }
	  	         PreparedStatement stmt = conn.prepareStatement(query);
	  	         
				 stmt.setString(1, userEmail);
	  	         ResultSet rs = stmt.executeQuery();
	  	         
	  	         //Condition for return and loop continuation
	  	         if (rs.next()) {
	  	        	 forReturn = true;
	  	             conn.close();
	  	         } 
	  	         else {
	  	            forReturn = false;
	  	            conn.close();
	  	         }
	  	     //Exception Handling
	  	     } catch (SQLException e) {
	  	         System.out.println("Error connecting to the database: " + e.getMessage());
	  	     } catch (ClassNotFoundException e) {
	  	         System.out.println("JDBC driver not found");
	  	     } 
			return forReturn;
		}
	public static String generateRandomPass() {
    	final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    final int ID_LENGTH = 8;
    	StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
	// OVERLOADED METHOD -> showDialog()
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
		    
			JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Error", true);
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
		public static boolean isValidEmail(String email) {
	        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	        return Pattern.matches(emailRegex, email);
	    }
}