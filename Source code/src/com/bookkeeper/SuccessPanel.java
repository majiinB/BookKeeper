package com.bookkeeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SuccessPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel logoPanel;
	private JPanel alertPanel;
	
	//label
	private JLabel lblTitle;
	private JLabel lblLogo;
	
	//textarea
	private JTextArea txtDescription;
	private JTextArea txtTitle;

	//button
	private JButton btnConfirm;
	
	//icon
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private int iconHeight; 
	private int iconWidth;
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagLayout gbl_alertPanel;
	private GridBagConstraints gbc_logoPanel;
	private GridBagConstraints gbc_alertPanel;
	private GridBagConstraints gbc_txtTitle;
	private GridBagConstraints gbc_btnConfirm;
	private GridBagConstraints gbc_txtDescription;

	//text
	private Font titleFont;
	private Font subtitleFont;
	private Font buttonFont;
	private int buttonTextSize;
	private int titleTextSize;
	private int subtitleTextSize;

	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	
	public SuccessPanel(String title, String message) {
		
	setBackground(new Color(250, 251, 255));
	setBorder(new EmptyBorder(20, 20, 20, 20));
	setLayout(new BorderLayout(0, 0));
	
    //create panels
    mainPanel = new JPanel();
    logoPanel = new JPanel();
    alertPanel = new JPanel();
    // Set panel properties 
    alertPanel.setBorder(new EmptyBorder(0, 15, 0, 10));
    
    mainPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    alertPanel.setOpaque(false);
    

    icon = new ImageIcon("img/AlertFrame/Logo_Success.png");
    image = icon.getImage();
    
    lblLogo = new JLabel();
    lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
   
	txtTitle = new JTextArea(title);
	txtTitle.setForeground(headerColor);
	txtTitle.setLineWrap(true);
	txtTitle.setOpaque(false);
	txtTitle.setWrapStyleWord(true);
	txtTitle.setFocusable(false);
	txtTitle.setEditable(false);
	txtTitle.setDragEnabled(false);
	txtTitle.setAutoscrolls(false);
	txtTitle.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	
	txtDescription = new JTextArea(message);
	txtDescription.setForeground(darkplainColor);
	txtDescription.setLineWrap(true);
	txtDescription.setOpaque(false);
	txtDescription.setWrapStyleWord(true);
	txtDescription.setFocusable(false);
	txtDescription.setEditable(false);
	txtDescription.setDragEnabled(false);
	txtDescription.setAutoscrolls(false);
	txtDescription.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

	btnConfirm = new JButton("Ok");
	btnConfirm.setForeground(darkplainColor);
	btnConfirm.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	btnConfirm.setFocusPainted(false);
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
	gbl_mainPanel.columnWidths = new int[]{216, 119, 0};
	gbl_mainPanel.rowHeights = new int[]{97, 0};
	gbl_mainPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_mainPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	
	gbc_logoPanel = new GridBagConstraints();
	gbc_logoPanel.insets = new Insets(0, 0, 0, 5);
	gbc_logoPanel.gridx = 0;
	gbc_logoPanel.gridy = 0;
		
	gbc_alertPanel = new GridBagConstraints();
	gbc_alertPanel.fill = GridBagConstraints.HORIZONTAL;
	gbc_alertPanel.gridx = 1;
	gbc_alertPanel.gridy = 0;
	
	gbl_alertPanel = new GridBagLayout();
	gbl_alertPanel.columnWidths = new int[]{361, 0};
	gbl_alertPanel.rowHeights = new int[]{68, 80, 40, 0};
	gbl_alertPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_alertPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	
	gbc_txtTitle = new GridBagConstraints();
	gbc_txtTitle.fill = GridBagConstraints.BOTH;
	gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
	gbc_txtTitle.gridx = 0;
	gbc_txtTitle.gridy = 0;
	
	gbc_txtDescription = new GridBagConstraints();
	gbc_txtDescription.fill = GridBagConstraints.BOTH;
	gbc_txtDescription.insets = new Insets(0, 0, 5, 0);
	gbc_txtDescription.gridx = 0;
	gbc_txtDescription.gridy = 1;
	
	gbc_btnConfirm = new GridBagConstraints();
	gbc_btnConfirm.anchor = GridBagConstraints.EAST;
	gbc_btnConfirm.fill = GridBagConstraints.VERTICAL;
	gbc_btnConfirm.gridx = 0;
	gbc_btnConfirm.gridy = 2;
	

	mainPanel.setLayout(gbl_mainPanel);
	alertPanel.setLayout(gbl_alertPanel);
	logoPanel.setLayout(new BorderLayout(0, 0));
	
	//add components to each panel
	logoPanel.add(lblLogo, BorderLayout.CENTER);
	alertPanel.add(txtTitle, gbc_txtTitle);
	alertPanel.add(txtDescription, gbc_txtDescription);
	alertPanel.add(btnConfirm, gbc_btnConfirm);
	
	// Add all Panels to main panel
	mainPanel.add(logoPanel, gbc_logoPanel);
	mainPanel.add(alertPanel, gbc_alertPanel);
		
    add(mainPanel); 
	
    addComponentListener(new ComponentAdapter() {
    	  @Override
          public void componentResized(ComponentEvent e) {
          	
  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
  	            subtitleTextSize =  Math.min(getHeight() / 17, getWidth()/ 35);
  	            buttonTextSize =  Math.min(getHeight() / 20, getWidth()/ 38);
  	            
  	            
  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
  	            txtTitle.setFont(titleFont);
  	            
  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
  	            txtDescription.setFont(subtitleFont);
  	            
  	            buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
  	            btnConfirm.setFont(buttonFont);

          }
      });
    
  }
	// Methods
	public JButton getBtnConfirm() {
		return btnConfirm;
	}
  	 @Override
  	 protected void paintComponent(Graphics g) {
  	    super.paintComponent(g);
  	    /*
  		    * use super.paintComponent(g) for proper rendering 
  		    * ng mga components
  		*/
  	    iconWidth = (int) (getWidth() * 0.27);
  	    iconHeight = (int) (getHeight() * 0.6);
  	    scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
  	    lblLogo.setIcon(new ImageIcon(scaledImage));

  	 }
}
