package com.bookkeeper;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PatronMenuPanel extends JPanel {
	//panel
	private GradientBackgroundPanel mainPanel;
//	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JPanel LibraryPanel;
	private JPanel AccPanel;
	private JPanel LogoutPanel;
	private JPanel topSeparatorPanel;
	private JPanel bottomSeparatorPanel;

	//icon
	private ImageIcon logoIcon;
	private ImageIcon libraryIcon;
	private ImageIcon accIcon;
	private ImageIcon logoutIcon;
	
	private Image logoImage;
	private Image libraryImage;
	private Image accImage;
	private Image logoutImage;
	
	private Image  logoScaledImage;
	private Image  libraryScaledImage;
	private Image accScaledImage;
	private Image logoutScaledImage;
	
	private int logoHeight; 
	private int logoWidth;
	private int iconHeight; 
	private int iconWidth;
	
	//label
	private JLabel lblLogo;
	
	//button
	private JButton btnLibrary;
	private JButton btnLogout;
	private JButton btnAcc;
	
	//seperator
	private JSeparator topSeparator;
	private JSeparator bottomSeparator;
	
	//layout
	private GridBagLayout gbl_middlePanel;
	private GridBagConstraints gbc_LibraryPanel;

	private GridBagConstraints gbc_AccPanel;
	
 public PatronMenuPanel() {
	 setLayout(new BorderLayout(0, 0));
	 
	 //create panels
	 mainPanel = new GradientBackgroundPanel();
//	 mainPanel = new JPanel();
	 topPanel = new JPanel();
	 middlePanel = new JPanel();
	 bottomPanel = new JPanel();
	 bottomPanel = new JPanel();
	 topSeparatorPanel = new JPanel();


	 bottomSeparatorPanel = new JPanel();

	 LogoutPanel = new JPanel();
	 LibraryPanel = new JPanel();	 
	 AccPanel = new JPanel();
	    

	 // Set panel properties
	 mainPanel.setColor1(new Color(0,66,166));
	 mainPanel.setColor2(new Color(12,1,76));
	 
	 LibraryPanel.setBackground(new Color(0, 115, 221, 115));
	 AccPanel.setBackground(new Color(0, 115, 221, 115));
	 
	 LibraryPanel.setOpaque(true);//set to true as library is shown at start;
	 AccPanel.setOpaque(false);
	 topPanel.setOpaque(false);
	 middlePanel.setOpaque(false);
	 bottomPanel.setOpaque(false);
	 LogoutPanel.setOpaque(false);
	 
	 topSeparatorPanel.setPreferredSize(new Dimension(3, 3));
	 bottomSeparatorPanel.setPreferredSize(new Dimension(3, 3));
	 
	 bottomPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
	 middlePanel.setBorder(new EmptyBorder(20, 0, 0, 0));
	 topPanel.setBorder(new EmptyBorder(29, 0, 0, 0));
	 LogoutPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
	 LibraryPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
	 AccPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

    logoIcon = new ImageIcon("img/DashboardFrame/Logo_White.png");    
    libraryIcon = new ImageIcon("img/DashboardFrame/Library_Solid.png");    
    accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
    logoutIcon = new ImageIcon("img/DashboardFrame/Logout.png");    
 
    logoImage = logoIcon.getImage();
    libraryImage = libraryIcon.getImage();
    accImage = accIcon.getImage();
    logoutImage = logoutIcon.getImage();

    logoWidth = 40;
    logoHeight = 35;
    iconWidth = 38;
    iconHeight = 37;
    
    logoScaledImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
    libraryScaledImage = libraryImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    accScaledImage = accImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    logoutScaledImage = logoutImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

    lblLogo = new JLabel();
    lblLogo.setBorder(new EmptyBorder(0, 0, 20, 0));
    lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
    lblLogo.setFocusable(false);
    lblLogo.setIcon(new ImageIcon(logoScaledImage));

    topSeparator = new JSeparator();
    topSeparator.setBorder(new EmptyBorder(0, 10, 0, 10));
    topSeparator.setForeground(new Color(250, 251, 255));
    topSeparator.setBorder(new EmptyBorder(0, 10, 0, 10));
    
    btnLibrary = new JButton();
    btnLibrary.setMnemonic(KeyEvent.VK_L);
    btnLibrary.setToolTipText("Library");
    btnLibrary.setFocusPainted(false);
    btnLibrary.setBorderPainted(false);
    btnLibrary.setIcon(new ImageIcon(libraryScaledImage));


    btnAcc = new JButton();
    btnAcc.setMnemonic(KeyEvent.VK_A);
    btnAcc.setToolTipText("Manage Account");
    btnAcc.setFocusPainted(false);
    btnAcc.setBorderPainted(false);
    btnAcc.setIcon(new ImageIcon(accScaledImage));
    
    bottomSeparator = new JSeparator();
    bottomSeparator.setBorder(new EmptyBorder(0, 10, 0, 10));
    bottomSeparator.setForeground(new Color(250, 251, 255));
    bottomSeparator.setBorder(new EmptyBorder(0, 10, 0, 10));
    btnLogout = new JButton();
    btnLogout.setFocusPainted(false);
    btnLogout.setBorderPainted(false);
    btnLogout.setIcon(new ImageIcon(logoutScaledImage));
    /*
     * gamit ka ng gridbag layout for more control sa placement ng components  sa panel
     * ung gbc or grid bag constraints is para madetermine mo ung positioning ng mga components sa gridbag layout
     * x = column
     * y = row
     * gridheight/gridwidth = no. of cells occupied
     * anchor = alignment
     * insets = padding
     */
    
    //gridbaglayout

    gbl_middlePanel = new GridBagLayout();
    gbl_middlePanel.columnWidths = new int[]{82, 0};
    gbl_middlePanel.rowHeights = new int[]{30, 30, 30, 30, 30, 0};
    gbl_middlePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
    gbl_middlePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    
    gbc_LibraryPanel = new GridBagConstraints();
    gbc_LibraryPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_LibraryPanel.insets = new Insets(10, 0, 10, 0);
    gbc_LibraryPanel.gridx = 0;
    gbc_LibraryPanel.gridy = 0;
    
 
    gbc_AccPanel = new GridBagConstraints();
    gbc_AccPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_AccPanel.gridx = 0;
    gbc_AccPanel.gridy = 1;
    
    // Set panel layouts
    mainPanel.setLayout(new BorderLayout(0, 0));
    topPanel.setLayout(new BorderLayout(0, 0));
    middlePanel.setLayout(gbl_middlePanel);
    bottomPanel.setLayout(new BorderLayout(0, 0));
    LibraryPanel.setLayout(new BorderLayout(0, 0));
    AccPanel.setLayout(new BorderLayout(0, 0));

    
    //add components to panels
    LibraryPanel.add(btnLibrary);
    AccPanel.add(btnAcc);
    LogoutPanel.add(btnLogout);
    bottomSeparatorPanel.add(topSeparator);
    bottomSeparatorPanel.add(bottomSeparator);
    topPanel.add(lblLogo, BorderLayout.CENTER);
    topPanel.add(topSeparatorPanel, BorderLayout.SOUTH);
    
    middlePanel.add(LibraryPanel, gbc_LibraryPanel);
    middlePanel.add(AccPanel, gbc_AccPanel);
    
    bottomPanel.add(bottomSeparatorPanel,BorderLayout.NORTH);
    bottomPanel.add(LogoutPanel,BorderLayout.CENTER);
    
    //add panels to main panel
    mainPanel.add(topPanel,BorderLayout.NORTH);
    mainPanel.add(middlePanel,BorderLayout.CENTER);
    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
	add(mainPanel);
	
 }
 //Methods
 public JButton getBtnLibrary() {
	 return btnLibrary;
 }
 public JButton getBtnLogOut() {
	 return btnLogout;
 }
 public JButton getBtnAcc() {
	 return btnAcc;
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
