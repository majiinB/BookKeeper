package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
public class RoleSelectionPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel buttonPanel;
	private RoundedPanel btnAdminPanel;
	private RoundedPanel btnPatronPanel;
	
	//label
	private JLabel lblHeading;
	private JLabel lblSubTitle;

	//button
	private JButton btnAdmin;
	private JButton btnPatron;
	private JButton btnBack;

	//icon
	private ImageIcon logoIcon;
	private ImageIcon adminIcon;
	private ImageIcon patronIcon;
	private Image logoImage;
	private Image adminImage;
	private Image patronImage;
	private Image logoScaledImage;
//	private Image iconScaledImage;
	private Image adminScaledImage;
	private Image patronScaledImage;
	private int logoHeight; 
	private int logoWidth;
	private int iconHeight; 
	private int iconWidth;
	
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagLayout gbl_buttonPanel;
	private GridBagConstraints gbc_btnPatronPanel;
	private GridBagConstraints gbc_btnAdminPanel;
	
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

		
public  RoleSelectionPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel();
    buttonPanel = new JPanel();
    btnAdminPanel =  new RoundedPanel(150);
    btnPatronPanel = new RoundedPanel(150);
    
    // Set panel properties
    btnPatronPanel.setForeground(new Color(23, 21, 147));
    btnAdminPanel.setForeground(new Color(23, 21, 147));
    btnAdminPanel.setBorderWidth(4);
    btnPatronPanel.setBorderWidth(4);
    
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    btnAdminPanel.setOpaque(false);
    btnPatronPanel.setOpaque(false);
    mainPanel.setBorder(null);
    buttonPanel.setBorder(new EmptyBorder(0, 60, 0, 60));
    mainPanel.setBackground(new Color(250, 251, 255));
   

    logoIcon = new ImageIcon("img/Logo_Blue.png");    
    adminIcon = new ImageIcon("img/AuthenticationFrame/Admin_Default.png");
    patronIcon = new ImageIcon("img/AuthenticationFrame/Patron_Default.png");
    
    logoImage = logoIcon.getImage();
    patronImage = patronIcon.getImage();
    adminImage = adminIcon.getImage();
    
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
    
    btnPatron = new JButton();
    btnPatron.setIconTextGap(20);
    btnPatron.setBorder(null);
    btnPatron.setBorderPainted(false);
    btnPatron.setText("Patron");
    btnPatron.setForeground(new Color(23, 21, 147));
    btnPatron.setFocusPainted(false);
    btnPatron.setContentAreaFilled(false);

	btnAdmin = new JButton();
	btnAdmin.setIconTextGap(20);
	btnAdmin.setBorder(null);
	btnAdmin.setBorderPainted(false);
	btnAdmin.setText("Admin");
	btnAdmin.setForeground(new Color(23, 21, 147));
	btnAdmin.setFocusPainted(false);
	btnAdmin.setContentAreaFilled(false);
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
    gbl_mainPanel.columnWidths = new int[]{180, 0};
    gbl_mainPanel.rowHeights = new int[]{35, 483};
    gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 1.0};
       
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.insets = new Insets(5, 5, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 1;
    
    gbl_buttonPanel = new GridBagLayout();
    gbl_buttonPanel.columnWidths = new int[]{541, 0};
    gbl_buttonPanel.rowHeights = new int[]{160, 63, 160, 0};
    gbl_buttonPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    

    gbc_btnPatronPanel = new GridBagConstraints();
    gbc_btnPatronPanel.fill = GridBagConstraints.BOTH;
    gbc_btnPatronPanel.insets = new Insets(0, 0, 5, 0);
    gbc_btnPatronPanel.gridx = 0;
    gbc_btnPatronPanel.gridy = 2;
    
    gbc_btnAdminPanel = new GridBagConstraints();
    gbc_btnAdminPanel.fill = GridBagConstraints.BOTH;
    gbc_btnAdminPanel.gridx = 0;
    gbc_btnAdminPanel.gridy = 0;
    
    // Set panel layouts
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BorderLayout(0,0));
    btnAdminPanel.setLayout(new BorderLayout(0, 0));
    btnPatronPanel.setLayout(new BorderLayout(0, 0));
    buttonPanel.setLayout(gbl_buttonPanel);

        
    //Add all to main panel
    headingPanel.add(lblHeading, BorderLayout.WEST);
    headingPanel.add(btnBack, BorderLayout.EAST);
    btnAdminPanel.add(btnAdmin);
    btnPatronPanel.add(btnPatron);
    buttonPanel.add(btnAdminPanel, gbc_btnAdminPanel);
    buttonPanel.add(btnPatronPanel, gbc_btnPatronPanel);
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(buttonPanel, gbc_buttonPanel);

    
    add(mainPanel);
    
    addComponentListener(new ComponentAdapter() {
    	  @Override
          public void componentResized(ComponentEvent e) {
          	
  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
//  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
  	            buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
  	           	headerTextSize =   Math.min(getHeight() / 50, getWidth()/ 65);
//  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 60);
  	            
  	            titleFont = new Font("Montserrat", Font.PLAIN, titleTextSize);
  	            btnPatron.setFont(titleFont);
  	            btnAdmin.setFont(titleFont);
  	            
//  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
  	            
//  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
  	            
  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
  	            btnBack.setFont(headerFont);
  	            lblHeading.setFont(headerFont);
  	            
//  	            plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);

          }
      });
}
//Methods
public JButton getBtnAdmin() {
	return btnAdmin;
}
public JButton getBtnPatron(){
	return btnPatron;
}
public JButton getBtnBack() {
	return btnBack;
}
@Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   /*
	    * use super.paintComponent(g) for proper rendering 
	    * ng mga components 
	*/
   logoWidth = (int) (getWidth() * 0.025);
   logoHeight = (int) (getHeight() * 0.04);
   
   iconWidth = (int) (getWidth()* 0.1);
   iconHeight = (int) (getHeight()* 0.1);
   
   logoScaledImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
   lblHeading.setIcon(new ImageIcon(logoScaledImage));

   patronScaledImage = patronImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
   adminScaledImage = adminImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
   btnPatron.setIcon(new ImageIcon(patronScaledImage));
   btnAdmin.setIcon(new ImageIcon(adminScaledImage));
}

}