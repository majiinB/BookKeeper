package com.bookkeeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenuPanel extends JPanel {
	//panel
	private GradientBackgroundPanel mainPanel;
//	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JPanel LibraryPanel;
	private JPanel ReportPanel;
	private JPanel EmployeePanel;
	private JPanel PatronPanel;
	private JPanel AccPanel;
	private JPanel LogoutPanel;
	private JPanel topSeparatorPanel;
	private JPanel bottomSeparatorPanel;

	//icon
	private ImageIcon logoIcon;
	private ImageIcon libraryIcon;
	private ImageIcon reportIcon;
	private ImageIcon employeeIcon;
	private ImageIcon patronIcon;
	private ImageIcon accIcon;
	private ImageIcon logoutIcon;
	
	private Image logoImage;
	private Image libraryImage;
	private Image reportImage;
	private Image employeeImage;
	private Image patronImage;
	private Image accImage;
	private Image logoutImage;
	
	private Image  logoScaledImage;
	private Image  libraryScaledImage;
	private Image reportScaledImage;
	private Image employeeScaledImage ;   
	private Image patronScaledImage;
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
	private JButton btnReport;
	private JButton btnEmployee;
	private JButton btnPatron;
	private JButton btnAcc;
	
	//seperator
	private JSeparator topSeparator;
	private JSeparator bottomSeparator;
	
	//layout
	private GridBagLayout gbl_middlePanel;
	private GridBagConstraints gbc_LibraryPanel;
	private GridBagConstraints gbc_ReportPanel;
	private GridBagConstraints gbc_EmployeePanel;
	private GridBagConstraints gbc_PatronPanel;
	private GridBagConstraints gbc_AccPanel;
	
	//text
	private  Font plainFont;
	private  int plainTextsize;
	private  Color darkplainColor = new Color(14, 14, 15);
	private  Color lightplainColor = new Color(250, 251, 255);
	
 public AdminMenuPanel() {
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
	 ReportPanel = new JPanel();
	 EmployeePanel = new JPanel();
	 PatronPanel = new JPanel();
	 AccPanel = new JPanel();
	    

	 // Set panel properties
	 mainPanel.setColor1(new Color(0,66,166));
	 mainPanel.setColor2(new Color(12,1,76));
	 
	 LibraryPanel.setBackground(new Color(0, 115, 221));
	 ReportPanel.setBackground(new Color(0, 115, 221));
	 EmployeePanel.setBackground(new Color(0, 115, 221));
	 PatronPanel.setBackground(new Color(0, 115, 221));
	 AccPanel.setBackground(new Color(0, 115, 221));
	 
	 LibraryPanel.setOpaque(true);//set to true as library is shown at start
	 ReportPanel.setOpaque(false);
	 EmployeePanel.setOpaque(false);
	 PatronPanel.setOpaque(false);
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
	 ReportPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
	 EmployeePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
	 PatronPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
	 AccPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

    logoIcon = new ImageIcon("img/DashboardFrame/Logo_White.png");    
    libraryIcon = new ImageIcon("img/DashboardFrame/Library_Solid.png");    
    reportIcon = new ImageIcon("img/DashboardFrame/Report_Outline.png");    
    employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Outline.png");    
    patronIcon = new ImageIcon("img/DashboardFrame/Patron_Outline.png");    
    accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
    logoutIcon = new ImageIcon("img/DashboardFrame/Logout.png");    
 
    logoImage = logoIcon.getImage();
    libraryImage = libraryIcon.getImage();
    reportImage = reportIcon.getImage();
    employeeImage = employeeIcon.getImage();
    patronImage = patronIcon.getImage();
    accImage = accIcon.getImage();
    logoutImage = logoutIcon.getImage();

    //baka baguhin ko if malaki sa inyo masyado ung icons
    logoWidth = 40;
    logoHeight = 35;
    iconWidth = 38;
    iconHeight = 37;
    
    logoScaledImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
    libraryScaledImage = libraryImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    reportScaledImage = reportImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    employeeScaledImage = employeeImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    patronScaledImage = patronImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
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

    btnReport = new JButton();
    btnReport.setMnemonic(KeyEvent.VK_R);
    btnReport.setToolTipText("Report");
    btnReport.setFocusPainted(false);
    btnReport.setBorderPainted(false);
    btnReport.setBorder(new EmptyBorder(5, 5, 5, 5));
    btnReport.setIcon(new ImageIcon(reportScaledImage));

    btnEmployee = new JButton();
    btnEmployee.setMnemonic(KeyEvent.VK_E);
    btnEmployee.setToolTipText("Manage Employees");
    btnEmployee.setFocusPainted(false);
    btnEmployee.setBorderPainted(false);
    btnEmployee.setIcon(new ImageIcon(employeeScaledImage));

    btnPatron = new JButton();
    btnPatron.setMnemonic(KeyEvent.VK_P);
    btnPatron.setToolTipText("Manage Patrons");
    btnPatron.setFocusPainted(false);
    btnPatron.setBorderPainted(false);
    btnPatron.setIcon(new ImageIcon(patronScaledImage));

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
    
    ToolTipManager.sharedInstance().setInitialDelay(0);
    ToolTipManager.sharedInstance().setDismissDelay(4000);
    ToolTipManager.sharedInstance().setReshowDelay(0);
    ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);

    UIManager.put("ToolTip.background", lightplainColor); 
    UIManager.put("ToolTip.foreground", darkplainColor); 
    UIManager.put("ToolTip.font", plainFont);

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
    
    gbc_ReportPanel = new GridBagConstraints();
    gbc_ReportPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_ReportPanel.insets = new Insets(0, 0, 10, 0);
    gbc_ReportPanel.gridx = 0;
    gbc_ReportPanel.gridy = 1;
    
    gbc_EmployeePanel = new GridBagConstraints();
    gbc_EmployeePanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_EmployeePanel.insets = new Insets(0, 0, 10, 0);
    gbc_EmployeePanel.gridx = 0;
    gbc_EmployeePanel.gridy = 2;
    
    gbc_PatronPanel = new GridBagConstraints();
    gbc_PatronPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_PatronPanel.insets = new Insets(0, 0, 10, 0);
    gbc_PatronPanel.gridx = 0;
    gbc_PatronPanel.gridy = 3;
    
    gbc_AccPanel = new GridBagConstraints();
    gbc_AccPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_AccPanel.gridx = 0;
    gbc_AccPanel.gridy = 4;
    
    // Set panel layouts
    mainPanel.setLayout(new BorderLayout(0, 0));
    topPanel.setLayout(new BorderLayout(0, 0));
    middlePanel.setLayout(gbl_middlePanel);
    bottomPanel.setLayout(new BorderLayout(0, 0));
    LibraryPanel.setLayout(new BorderLayout(0, 0));
    ReportPanel.setLayout(new BorderLayout(0, 0));
    EmployeePanel.setLayout(new BorderLayout(0, 0));
    PatronPanel.setLayout(new BorderLayout(0, 0));
    AccPanel.setLayout(new BorderLayout(0, 0));

    
    //add components to panels
    LibraryPanel.add(btnLibrary);
    ReportPanel.add(btnReport);
    EmployeePanel.add(btnEmployee);
    PatronPanel.add(btnPatron);
    AccPanel.add(btnAcc);
    LogoutPanel.add(btnLogout);
    bottomSeparatorPanel.add(topSeparator);
    bottomSeparatorPanel.add(bottomSeparator);
    topPanel.add(lblLogo, BorderLayout.CENTER);
    topPanel.add(topSeparatorPanel, BorderLayout.SOUTH);
    
    middlePanel.add(LibraryPanel, gbc_LibraryPanel);
    middlePanel.add(ReportPanel, gbc_ReportPanel);
    middlePanel.add(EmployeePanel, gbc_EmployeePanel);
    middlePanel.add(PatronPanel, gbc_PatronPanel);
    middlePanel.add(AccPanel, gbc_AccPanel);
    
    bottomPanel.add(bottomSeparatorPanel,BorderLayout.NORTH);
    bottomPanel.add(LogoutPanel,BorderLayout.CENTER);
    
    //add panels to main panel
    mainPanel.add(topPanel,BorderLayout.NORTH);
    mainPanel.add(middlePanel,BorderLayout.CENTER);
    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
	add(mainPanel);
	
 }
 // Methods
 public JButton getBtnAcc() {
	 return btnAcc;
 }
 public JButton getBtnLibrary() {
	 return btnLibrary;
 }
 public JButton getBtnLogOut() {
	 return btnLogout;
 }
 public JButton getBtnReport() {
	 return btnReport;
 }
 public JButton getBtnEmployee() {
	 return btnEmployee;
 }
 public JButton getBtnPatron() {
	 return btnPatron;
 }
 public void setBtnLibrary(){
	 libraryIcon = new ImageIcon("img/DashboardFrame/Library_Solid.png");    
	 reportIcon = new ImageIcon("img/DashboardFrame/Report_Outline.png");  
	 employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Outline.png");    
	 patronIcon = new ImageIcon("img/DashboardFrame/Patron_Outline.png");    
	 accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
	 
	 btnLibrary.setIcon(new ImageIcon(libraryIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnReport.setIcon(new ImageIcon(reportIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnEmployee.setIcon(new ImageIcon(employeeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnPatron.setIcon(new ImageIcon(patronIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnAcc.setIcon(new ImageIcon(accIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));

	 LibraryPanel.setOpaque(true);
     AccPanel.setOpaque(false);
     ReportPanel.setOpaque(false);
     EmployeePanel.setOpaque(false);
     PatronPanel.setOpaque(false);
     LibraryPanel.repaint();
     AccPanel.repaint();
     ReportPanel.repaint();
     EmployeePanel.repaint();
     PatronPanel.repaint();
 }
 public void setBtnAcc(){
	libraryIcon = new ImageIcon("img/DashboardFrame/Library_Outline.png");    
	reportIcon = new ImageIcon("img/DashboardFrame/Report_Outline.png");    
	employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Outline.png");    
	patronIcon = new ImageIcon("img/DashboardFrame/Patron_Outline.png");    
	accIcon = new ImageIcon("img/DashboardFrame/Account_Solid.png");    
	 
	btnLibrary.setIcon(new ImageIcon(libraryIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	btnReport.setIcon(new ImageIcon(reportIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	btnEmployee.setIcon(new ImageIcon(employeeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	btnPatron.setIcon(new ImageIcon(patronIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	btnAcc.setIcon(new ImageIcon(accIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));

	LibraryPanel.setOpaque(false);
	AccPanel.setOpaque(true);
	ReportPanel.setOpaque(false);
	EmployeePanel.setOpaque(false);
	PatronPanel.setOpaque(false);
	LibraryPanel.repaint();
	AccPanel.repaint();
	ReportPanel.repaint();
    EmployeePanel.repaint();
    PatronPanel.repaint();
 }
 public void setBtnReport() {    
	 libraryIcon = new ImageIcon("img/DashboardFrame/Library_Outline.png");    
	 reportIcon = new ImageIcon("img/DashboardFrame/Report_Solid.png");    
	 employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Outline.png");    
	 patronIcon = new ImageIcon("img/DashboardFrame/Patron_Outline.png");    
	 accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
	 
	 btnLibrary.setIcon(new ImageIcon(libraryIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnReport.setIcon(new ImageIcon(reportIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnEmployee.setIcon(new ImageIcon(employeeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnPatron.setIcon(new ImageIcon(patronIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnAcc.setIcon(new ImageIcon(accIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));

	 LibraryPanel.setOpaque(false);
     AccPanel.setOpaque(false);
     ReportPanel.setOpaque(true);
     EmployeePanel.setOpaque(false);
     PatronPanel.setOpaque(false);
     
     LibraryPanel.repaint();
     AccPanel.repaint();
     ReportPanel.repaint();
     EmployeePanel.repaint();
     PatronPanel.repaint();
 }
 public void setBtnEmployee() {    
	 libraryIcon = new ImageIcon("img/DashboardFrame/Library_Outline.png");    
	 reportIcon = new ImageIcon("img/DashboardFrame/Report_Outline.png");    
	 employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Solid.png");    
	 patronIcon = new ImageIcon("img/DashboardFrame/Patron_Outline.png");    
	 accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
	 btnLibrary.setIcon(new ImageIcon(libraryIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnReport.setIcon(new ImageIcon(reportIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnEmployee.setIcon(new ImageIcon(employeeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnPatron.setIcon(new ImageIcon(patronIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnAcc.setIcon(new ImageIcon(accIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));

	 LibraryPanel.setOpaque(false);
     AccPanel.setOpaque(false);
     ReportPanel.setOpaque(false);
     EmployeePanel.setOpaque(true);
     PatronPanel.setOpaque(false);
     LibraryPanel.repaint();
     AccPanel.repaint();
     ReportPanel.repaint();
     EmployeePanel.repaint();
     PatronPanel.repaint();
}
public void setBtnPatron() {    
	libraryIcon = new ImageIcon("img/DashboardFrame/Library_Outline.png");    
	reportIcon = new ImageIcon("img/DashboardFrame/Report_Outline.png");    
	employeeIcon = new ImageIcon("img/DashboardFrame/Employee_Outline.png");    
	patronIcon = new ImageIcon("img/DashboardFrame/Patron_Solid.png");    
	accIcon = new ImageIcon("img/DashboardFrame/Account_Outline.png");    
	 btnLibrary.setIcon(new ImageIcon(libraryIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnReport.setIcon(new ImageIcon(reportIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnEmployee.setIcon(new ImageIcon(employeeIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnPatron.setIcon(new ImageIcon(patronIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));
	 btnAcc.setIcon(new ImageIcon(accIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH)));

	 LibraryPanel.setOpaque(false);
    AccPanel.setOpaque(false);
    ReportPanel.setOpaque(false);
    EmployeePanel.setOpaque(false);
    PatronPanel.setOpaque(true);
    LibraryPanel.repaint();
    AccPanel.repaint();
    ReportPanel.repaint();
    EmployeePanel.repaint();
    PatronPanel.repaint();
}
	@Override
	protected void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   /*
		    * use super.paintComponent(g) for proper rendering 
			    * of components 
		*/
	  	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 2);
	    plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
	}
}