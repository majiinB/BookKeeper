package com.bookkeeper;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

//DATING LOGINADMIN

public class signUpPanel extends JPanel {
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

	private JLabel lblSubTitle;
	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblEmailAddress;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblHomeAddress;
	private JLabel lblContactNumber;
	
	private PlaceholderTextField txtFirstName;
	private PlaceholderTextField txtLastName;
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderTextField txtHomeAddress;
	private PlaceholderTextField txtContactNumber;

	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private Icon scaledIcon;
	
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagConstraints gbc_emailPanel;
	private GridBagConstraints gbc_homeAddressPanel;
	private GridBagConstraints gbc_contactNumberPanel;
    GridBagLayout gbl_inputPanel;
    GridBagConstraints gbc_firstNamePanel;
	private JButton btnSignUp;
	private JButton btnClear;
	private JButton btnClose;

public  signUpPanel() {
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

    
    mainPanel.setBackground(new Color(250, 251, 255));

    mainPanel.setBorder(null);
    titlePanel.setBorder(new EmptyBorder(50, 120, 0, 120));
    subtitlePanel.setBorder(new EmptyBorder(0, 120, 10, 120));
    inputPanel.setBorder(new EmptyBorder(20, 100, 0, 100));

    subtitlePanel.setOpaque(false);
    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    inputPanel.setOpaque(false);
    firstNamePanel.setOpaque(false);
    emailPanel.setOpaque(false);
    homeAddressPanel.setOpaque(false);
    contactNumberPanel.setOpaque(false);
    
    contactNumberPanel.setLayout(new GridLayout(2, 1, 0, 0));
    homeAddressPanel.setLayout(new GridLayout(2, 1, 0, 0));
    emailPanel.setLayout(new GridLayout(2, 1, 0, 0));
    firstNamePanel.setLayout(new GridLayout(2, 1, 0, 0));
    headingPanel.setLayout(new BorderLayout(0,0));
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    
    icon = new ImageIcon("/Users/PANPAN/eclipse-workspace/Fixed_Book_Keeper/img/Logo_Blue.png");
    image = icon.getImage();
    scaledImage = image.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
    scaledIcon = new ImageIcon(scaledImage);
    
    lblLogo = new JLabel();
    lblLogo.setIconTextGap(20);
    lblLogo.setFocusable(false);
    lblLogo.setForeground(new Color(23, 21, 147));
    lblLogo.setFont(new Font("Montserrat", Font.PLAIN, 15));
    lblLogo.setText("Book Keeper");
    lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
    lblLogo.setIcon(scaledIcon);
  
    btnClose = new JButton("Cancel");
    btnClose.setFocusPainted(false);
    btnClose.setForeground(new Color(23, 21, 147));
    btnClose.setFont(new Font("Montserrat", Font.ITALIC, 15));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));
    
    lblHeading = new JLabel("SIGN UP");
    lblHeading.setBorder(null);
    lblHeading.setFont(new Font("Montserrat", lblHeading.getFont().getStyle() | Font.BOLD, lblHeading.getFont().getSize() + 110));
    lblHeading.setForeground(new Color(23, 21, 147));
    lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
    
    lblSubTitle = new JLabel("Register a new account by filling in the details below. ");
    lblSubTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblSubTitle.setFont(new Font("Montserrat", Font.ITALIC, 30));
    lblSubTitle.setBorder(null);
    
    lblFirstName = new JLabel("First Name:");
    lblFirstName.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblFirstName.setForeground(new Color(14, 14, 15));
    
    txtFirstName  = new PlaceholderTextField("Juan ");
    txtFirstName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtFirstName.setBackground(new Color(243, 243, 247));
    txtFirstName.setFont(new Font("Montserrat", Font.ITALIC, 18));
    
    lastNamePanel = new JPanel();
    lastNamePanel.setOpaque(false);
    lastNamePanel.setLayout(new GridLayout(0, 1, 0, 0));
    
    lblLastName = new JLabel("Last Name:");
    lblLastName.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblLastName.setForeground(new Color(14, 14, 15));
    
    txtLastName  = new PlaceholderTextField("Dela Cruz");
    txtLastName.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtLastName.setBackground(new Color(243, 243, 247));
    txtLastName.setFont(new Font("Montserrat", Font.ITALIC, 18));
    

    lblEmailAddress = new JLabel("Email Address:");
    lblEmailAddress.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblEmailAddress.setForeground(new Color(14, 14, 15));
    
    txtEmailAddress = new PlaceholderTextField("sample@email.com");
    txtEmailAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtEmailAddress.setBackground(new Color(243, 243, 247));
    txtEmailAddress.setFont(new Font("Montserrat", Font.ITALIC, 18));
    
    lblHomeAddress = new JLabel("Home Address:");
    lblHomeAddress.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblHomeAddress.setForeground(new Color(14, 14, 15));
    
    txtHomeAddress = new PlaceholderTextField("House No. / Block No. / Street / Barangay / City");
    txtHomeAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtHomeAddress.setBackground(new Color(243, 243, 247));
    txtHomeAddress.setFont(new Font("Montserrat", Font.ITALIC, 18));
    
    lblContactNumber = new JLabel("Contact Number:");
    lblContactNumber.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblContactNumber.setForeground(new Color(14, 14, 15));
    
    txtContactNumber = new PlaceholderTextField("00000000000");
    txtContactNumber.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtContactNumber.setBackground(new Color(243, 243, 247));
    txtContactNumber.setFont(new Font("Montserrat", Font.ITALIC, 18));

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
    gbl_mainPanel.columnWidths = new int[]{180, 26, 0};
    gbl_mainPanel.rowHeights = new int[]{40, 203, 0, 0};
    gbl_mainPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
    
    
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.gridwidth = 2;
    gbc_headingPanel.insets = new Insets(0, 0, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    
    gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.insets = new Insets(0, 0, 5, 5);
    gbc_titlePanel.anchor = GridBagConstraints.NORTHWEST;
    gbc_titlePanel.gridx = 0;
    gbc_titlePanel.gridy = 1;
    
    gbc_inputPanel = new GridBagConstraints();
    gbc_inputPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_inputPanel.anchor = GridBagConstraints.NORTH;
    gbc_inputPanel.gridwidth = 2;
    gbc_inputPanel.gridx = 0;
    gbc_inputPanel.gridy = 3;

    gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.insets = new Insets(0, 0, 5, 5);
    gbc_subtitlePanel.fill = GridBagConstraints.BOTH;
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 2;


    
    gbl_inputPanel = new GridBagLayout();
    gbl_inputPanel.columnWidths = new int[]{120, 543, 543, 0};
    gbl_inputPanel.rowHeights = new int[]{90, 90, 90, 0, 0, 0};
    gbl_inputPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
    gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    
    gbc_firstNamePanel = new GridBagConstraints();
    gbc_firstNamePanel.gridwidth = 2;
    gbc_firstNamePanel.fill = GridBagConstraints.BOTH;
    gbc_firstNamePanel.insets = new Insets(0, 0, 0, 35);
    gbc_firstNamePanel.gridx = 0;
    gbc_firstNamePanel.gridy = 0;
    
    GridBagConstraints gbc_lastNamePanel = new GridBagConstraints();
    gbc_lastNamePanel.fill = GridBagConstraints.BOTH;
    gbc_lastNamePanel.gridx = 2;
    gbc_lastNamePanel.gridy = 0;
    
    gbc_emailPanel = new GridBagConstraints();
    gbc_emailPanel.insets = new Insets(25, 0, 0, 0);
    gbc_emailPanel.gridwidth = 3;
    gbc_emailPanel.fill = GridBagConstraints.BOTH;
    gbc_emailPanel.gridx = 0;
    gbc_emailPanel.gridy = 1;
    
    gbc_homeAddressPanel = new GridBagConstraints();
    gbc_homeAddressPanel.gridwidth = 3;
    gbc_homeAddressPanel.fill = GridBagConstraints.BOTH;
    gbc_homeAddressPanel.insets = new Insets(25, 0, 0, 0);
    gbc_homeAddressPanel.gridx = 0;
    gbc_homeAddressPanel.gridy = 2;
    
    
    gbc_contactNumberPanel = new GridBagConstraints();
    gbc_contactNumberPanel.insets = new Insets(25, 0, 0, 0);
    gbc_contactNumberPanel.gridwidth = 3;
    gbc_contactNumberPanel.fill = GridBagConstraints.BOTH;
    gbc_contactNumberPanel.gridx = 0;
    gbc_contactNumberPanel.gridy = 3;
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.insets = new Insets(25, 0, 0, 0);
    gbc_buttonPanel.gridwidth = 3;
    gbc_buttonPanel.fill = GridBagConstraints.BOTH;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    //Add all to main panel
    mainPanel.setLayout(gbl_mainPanel);
    inputPanel.setLayout(gbl_inputPanel);

    headingPanel.add(lblLogo, BorderLayout.WEST);
    headingPanel.add(btnClose, BorderLayout.EAST);
    
    titlePanel.add(lblHeading);
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
    
    inputPanel.add(firstNamePanel, gbc_firstNamePanel);
    inputPanel.add(lastNamePanel, gbc_lastNamePanel);
    inputPanel.add(emailPanel, gbc_emailPanel);
    inputPanel.add(homeAddressPanel, gbc_homeAddressPanel);
    inputPanel.add(contactNumberPanel, gbc_contactNumberPanel);
    
    
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(titlePanel, gbc_titlePanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(inputPanel, gbc_inputPanel);
    buttonPanel = new JPanel();
    buttonPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
    buttonPanel.setOpaque(false);
    buttonPanel.setLayout(new GridLayout(0, 2, 30, 0));
    btnClear = new JButton("CLEAR");
    btnClear.setOpaque(true);
    btnClear.setForeground(new Color(250, 251, 255));
    btnClear.setFont(new Font("Montserrat", Font.ITALIC, 18));
    btnClear.setFocusPainted(false);
    btnClear.setBorderPainted(false);
    btnClear.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnClear.setBackground(new Color(3, 0, 94));
    
    btnSignUp = new JButton("SIGN UP");
    btnSignUp.setForeground(new Color(250, 251, 255));
    btnSignUp.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnSignUp.setFont(new Font("Montserrat", Font.ITALIC, 18));
    btnSignUp.setOpaque(true);
    btnSignUp.setFocusPainted(false);
    btnSignUp.setBorderPainted(false);
    btnSignUp.setBackground(new Color(3, 0, 94));
    //inputPanel.add();
    
    
    
    inputPanel.add(buttonPanel, gbc_buttonPanel);
    
    buttonPanel.add(btnSignUp);
    buttonPanel.add(btnClear);

    
    add(mainPanel);
}
}