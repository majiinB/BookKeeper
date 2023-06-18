package com.bookkeeper;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyEvent;

//DATING LOGINADMIN

public class AdminLogInPanel extends JPanel {
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;

	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblEmailAddress;
	private JLabel lblPassword;
	private PlaceholderTextField txtEmailAddress;
	private PlaceholderPassword txtPassword;
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private Icon scaledIcon;
	private JButton btnClose;
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private JPanel subtitlePanel;
	private JLabel lblSubTitle;
	private JPanel buttonPanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;
	private JButton btnLogIn;
	
public  AdminLogInPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel();
    logoPanel = new JPanel();
    titlePanel = new JPanel();
    inputPanel = new JPanel();
    emailPanel = new JPanel();
    passwordPanel = new JPanel();
    subtitlePanel = new JPanel();
    buttonPanel = new JPanel();
    
    mainPanel.setBackground(new Color(250, 251, 255));

    mainPanel.setBorder(null);
    passwordPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
    titlePanel.setBorder(new EmptyBorder(50, 120, 0, 120));
    subtitlePanel.setBorder(new EmptyBorder(0, 120, 10, 120));
    inputPanel.setBorder(new EmptyBorder(20, 120, 0, 120));
    buttonPanel.setBorder(new EmptyBorder(25, 200, 25, 200));

    subtitlePanel.setOpaque(false);
    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    passwordPanel.setOpaque(false);
    inputPanel.setOpaque(false);
    emailPanel.setOpaque(false);
    buttonPanel.setOpaque(false);

    headingPanel.setLayout(new BorderLayout(0,0));
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    emailPanel.setLayout(new GridLayout(2, 1, 0, 0));
    passwordPanel.setLayout(new GridLayout(2, 1, 0, 0));
    inputPanel.setLayout(new GridLayout(3, 1, 5, 25));
    buttonPanel.setLayout(new BorderLayout(0, 0));

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
  
    btnClose = new JButton("Back");
    btnClose.setFocusPainted(false);
    btnClose.setForeground(new Color(23, 21, 147));
    btnClose.setFont(new Font("Montserrat", Font.ITALIC, 15));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));
    
    lblHeading = new JLabel("LOGIN");
    lblHeading.setBorder(null);
    lblHeading.setFont(new Font("Montserrat", lblHeading.getFont().getStyle() | Font.BOLD, lblHeading.getFont().getSize() + 110));
    lblHeading.setForeground(new Color(23, 21, 147));
    lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
    
    lblSubTitle = new JLabel("Welcome back! Please log in to your account to continue.");
    lblSubTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblSubTitle.setFont(new Font("Montserrat", Font.ITALIC, 30));
    lblSubTitle.setBorder(null);
    
    lblEmailAddress = new JLabel("Email Address:");
    lblEmailAddress.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblEmailAddress.setForeground(new Color(14, 14, 15));
    
    txtEmailAddress = new PlaceholderTextField("sample@email.com");
    txtEmailAddress.setBorder(new CompoundBorder(new LineBorder(null, 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtEmailAddress.setBackground(new Color(243, 243, 247));
    txtEmailAddress.setFont(new Font("Montserrat", Font.ITALIC, 18));
    
    lblPassword = new JLabel("Password:");
    lblPassword.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
    lblPassword.setForeground(new Color(14, 14, 15));
    
    txtPassword  = new PlaceholderPassword("password");
    txtPassword.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true), new EmptyBorder(10, 10, 10, 10)));
    txtPassword.setBackground(new Color(243, 243, 247));
    txtPassword.setFont(new Font("Montserrat", Font.ITALIC, 18));
    
    btnLogIn = new JButton("LOGIN");
    btnLogIn.setMnemonic(KeyEvent.VK_ENTER);
    btnLogIn.setForeground(new Color(250, 251, 255));
    btnLogIn.setBorder(new EmptyBorder(10, 10, 10, 10));
    btnLogIn.setFont(new Font("Montserrat", Font.ITALIC, 18));
    btnLogIn.setOpaque(true);
    btnLogIn.setFocusPainted(false);
    btnLogIn.setBorderPainted(false);
    btnLogIn.setBackground(new Color(3, 0, 94));
    
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
    
    mainPanel.setLayout(gbl_mainPanel);
    
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

    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
    gbc_buttonPanel.fill = GridBagConstraints.BOTH;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    //Add all to main panel
    
    headingPanel.add(lblLogo, BorderLayout.WEST);
    headingPanel.add(btnClose, BorderLayout.EAST);
    titlePanel.add(lblHeading);
    subtitlePanel.add(lblSubTitle);

    emailPanel.add(lblEmailAddress);
    emailPanel.add(txtEmailAddress);

    passwordPanel.add(lblPassword);
    passwordPanel.add(txtPassword);

    inputPanel.add(emailPanel);
    inputPanel.add(passwordPanel);
    inputPanel.add(buttonPanel);
    
    buttonPanel.add(btnLogIn);
    
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(titlePanel, gbc_titlePanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(inputPanel, gbc_inputPanel);

    
    add(mainPanel);
}
}