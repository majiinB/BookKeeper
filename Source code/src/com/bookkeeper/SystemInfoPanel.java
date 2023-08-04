package com.bookkeeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SystemInfoPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel detailPanel;
	private JPanel buttonPanel;
	private JPanel borrowingCapacityPanel;
	private JPanel borrowingDurationPanel;
	private JPanel reservationLimitPanel;
	private JPanel overdueLimitPanel;	

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
	private JLabel lblcapacity;
	private JLabel lblduration;
	private JLabel lblreservation;
	private JLabel lbloverdue;

	//textfield
	private JTextArea txtTitle;
	private JTextArea txtDescription;	
	
	//button
	private JButton btnCapacity;
	private JButton btnDuration;
	private JButton btnReservation;
	private JButton btnOverdue;
	private JButton btnSave;
	private JButton btnBack;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_detailPanel;
	private GridBagConstraints gbc_buttonPanel;
	
	private GridBagLayout gbl_detailPanel; 
	private GridBagConstraints gbc_borrowingCapacityPanel;
	private GridBagConstraints gbc_borrowingDurationPanel;
	private GridBagConstraints gbc_reservationLimitPanel;
	private GridBagConstraints gbc_overdueLimitPanel;
	
	private GridBagLayout gbl_titlePanel; 
	private GridBagConstraints gbc_txtTitle;
	private GridBagConstraints gbc_txtDescription;
	
	private GridBagLayout gbl_borrowingCapacityPanel;
	private GridBagConstraints gbc_lblcapacity;
	private GridBagConstraints gbc_btnCapacity;
	
	private GridBagLayout gbl_borrowingDurationPane;
	private GridBagConstraints gbc_lblduration;
	private GridBagConstraints gbc_btnDuration;
	
	private GridBagLayout gbl_reservationLimitPanel;
	private GridBagConstraints gbc_lblreservation;
	private GridBagConstraints gbc_btnReservation;
	
	private GridBagLayout gbl_overdueLimitPanel;
	private GridBagConstraints gbc_lbloverdue;
	private GridBagConstraints gbc_btnOverdue;


	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font headerFont;
	private  Font plainFont;
	private  Font buttonFont;
		
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int buttonTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white

	public SystemInfoPanel() {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
	    detailPanel = new JPanel();
	    borrowingCapacityPanel = new JPanel();
	    borrowingDurationPanel = new JPanel();
	    reservationLimitPanel = new JPanel();
	    overdueLimitPanel = new JPanel();
		buttonPanel = new JPanel();
	    
		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
	    detailPanel.setOpaque(false);

	    borrowingCapacityPanel.setBackground(middleplainColor);
	    reservationLimitPanel.setBackground(middleplainColor);
	    borrowingDurationPanel.setBackground(middleplainColor);
	    overdueLimitPanel.setBackground(middleplainColor);
	    
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

	    txtTitle = new JTextArea("System Details");
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    
	    txtDescription = new JTextArea(" Manage the library information system to your specific needs, and ensure a seamless and optimized experience for users.");
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
		
		lblcapacity = new JLabel("Borrowing Capacity Limit");
		lblcapacity.setEnabled(false);
		lblcapacity.setHorizontalAlignment(SwingConstants.LEFT);
		lblcapacity.setForeground(darkplainColor);
		lblcapacity.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblcapacity.setOpaque(false);
		lblcapacity.setFocusable(false);
		
		btnCapacity = new JButton();
		btnCapacity.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCapacity.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCapacity.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCapacity.setOpaque(false);
		btnCapacity.setFocusPainted(false);
		btnCapacity.setBorderPainted(false);
		btnCapacity.setBackground(new Color(0, 0, 0, 0));
		
		lblduration = new JLabel("Borrowing Duration Limit");
		lblduration.setEnabled(false);
		lblduration.setHorizontalAlignment(SwingConstants.LEFT);
		lblduration.setForeground(darkplainColor);
		lblduration.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblduration.setOpaque(false);
		lblduration.setFocusable(false);
		
		btnDuration = new JButton();
		btnDuration.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDuration.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnDuration.setOpaque(false);
		btnDuration.setFocusPainted(false);
		btnDuration.setBorderPainted(false);
		btnDuration.setBackground(new Color(0, 0, 0, 0));
		
		lblreservation = new JLabel("Reservation Limit");
		lblreservation.setEnabled(false);
		lblreservation.setHorizontalAlignment(SwingConstants.LEFT);
		lblreservation.setForeground(darkplainColor);
		lblreservation.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblreservation.setOpaque(false);
		lblreservation.setFocusable(false);
		
		btnReservation = new JButton();
		btnReservation.setHorizontalTextPosition(SwingConstants.LEFT);
		btnReservation.setHorizontalAlignment(SwingConstants.RIGHT);
		btnReservation.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnReservation.setOpaque(false);
		btnReservation.setFocusPainted(false);
		btnReservation.setBorderPainted(false);
		btnReservation.setBackground(new Color(0, 0, 0, 0));				
		
		lbloverdue = new JLabel("Overdue Penalty Limit");
		lbloverdue.setEnabled(false);
		lbloverdue.setHorizontalAlignment(SwingConstants.LEFT);
		lbloverdue.setForeground(darkplainColor);
		lbloverdue.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbloverdue.setOpaque(false);
		lbloverdue.setFocusable(false);
		
		btnOverdue = new JButton();
		btnOverdue.setHorizontalTextPosition(SwingConstants.LEFT);
		btnOverdue.setHorizontalAlignment(SwingConstants.RIGHT);
		btnOverdue.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnOverdue.setOpaque(false);
		btnOverdue.setFocusPainted(false);
		btnOverdue.setBorderPainted(false);
		btnOverdue.setBackground(new Color(0, 0, 0, 0));
		
		btnSave = new JButton();
		btnSave.setText("Save Changes");
		btnSave.setMnemonic(KeyEvent.VK_ENTER);
		btnSave.setForeground(lightplainColor);
		btnSave.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnSave.setOpaque(true);
		btnSave.setFocusPainted(false);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(headerColor);
	    
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
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
	    
	    gbc_headingPanel = new GridBagConstraints();
	    gbc_headingPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_headingPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;
	    
	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.anchor = GridBagConstraints.NORTH;
	    gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_titlePanel.insets = new Insets(30, 20, 20, 20);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;
	    
	    gbc_detailPanel = new GridBagConstraints();
	    gbc_detailPanel.anchor = GridBagConstraints.NORTH;
	    gbc_detailPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_detailPanel.insets = new Insets(30, 20, 20, 20);
	    gbc_detailPanel.gridx = 0;
	    gbc_detailPanel.gridy = 2;
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_buttonPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 3;	
	    
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
	    gbc_txtDescription.insets = new Insets(5,0,0,0);
	    gbc_txtDescription.gridx = 0;
	    gbc_txtDescription.gridy = 1;
	    
	    //
	    gbl_detailPanel = new GridBagLayout();
	    gbl_detailPanel.columnWidths = new int[]{0};
	    gbl_detailPanel.rowHeights = new int[]{0};
	    gbl_detailPanel.columnWeights = new double[]{1.0};
	    gbl_detailPanel.rowWeights = new double[]{0.0};
	    
	    gbc_borrowingCapacityPanel = new GridBagConstraints();
	    gbc_borrowingCapacityPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_borrowingCapacityPanel.insets = new Insets(0,0,30,0);
	    gbc_borrowingCapacityPanel.gridx = 0;
	    gbc_borrowingCapacityPanel.gridy = 0;
	    
	    gbc_borrowingDurationPanel = new GridBagConstraints();
	    gbc_borrowingDurationPanel.fill = GridBagConstraints.BOTH;		    
	    gbc_borrowingDurationPanel.insets = new Insets(0,0,30,0);
	    gbc_borrowingDurationPanel.gridx = 0;
	    gbc_borrowingDurationPanel.gridy = 1;
	    
	    gbc_reservationLimitPanel = new GridBagConstraints();
	    gbc_reservationLimitPanel.fill = GridBagConstraints.BOTH;		    
	    gbc_reservationLimitPanel.insets = new Insets(0,0,30,0);
	    gbc_reservationLimitPanel.gridx = 0;
	    gbc_reservationLimitPanel.gridy = 2;
	    
	    gbc_overdueLimitPanel = new GridBagConstraints();
	    gbc_overdueLimitPanel.fill = GridBagConstraints.BOTH;		    
	    gbc_overdueLimitPanel.insets = new Insets(0,0,20,0);
	    gbc_overdueLimitPanel.gridx = 0;
	    gbc_overdueLimitPanel.gridy = 3;
	    
	    // BORRIWING CAPACITY LAYOUT
	    gbl_borrowingCapacityPanel = new GridBagLayout();
	    gbl_borrowingCapacityPanel.columnWidths = new int[]{0};
	    gbl_borrowingCapacityPanel.rowHeights = new int[]{0};
	    gbl_borrowingCapacityPanel.columnWeights = new double[]{1.0};
	    gbl_borrowingCapacityPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lblcapacity = new GridBagConstraints();
	    gbc_lblcapacity.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblcapacity.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblcapacity.gridx = 0;
	    gbc_lblcapacity.gridy = 0;
	    
	    gbc_btnCapacity = new GridBagConstraints();
	    gbc_btnCapacity.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnCapacity.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnCapacity.gridx = 1;
	    gbc_btnCapacity.gridy = 0;
	    //
	    
	    // BORROWING DURATION LAYOUT
	    gbl_borrowingDurationPane = new GridBagLayout();
	    gbl_borrowingDurationPane.columnWidths = new int[]{0};
	    gbl_borrowingDurationPane.rowHeights = new int[]{0};
	    gbl_borrowingDurationPane.columnWeights = new double[]{1.0};
	    gbl_borrowingDurationPane.rowWeights = new double[]{0.0};
	    
	    gbc_lblduration = new GridBagConstraints();
	    gbc_lblduration.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblduration.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblduration.gridx = 0;
	    gbc_lblduration.gridy = 0;
	    
	    gbc_btnDuration = new GridBagConstraints();
	    gbc_btnDuration.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnDuration.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnDuration.gridx = 1;
	    gbc_btnDuration.gridy = 0;
	    //
	    
	    // RESERVATION LIMIT LAYOUT
	    gbl_reservationLimitPanel = new GridBagLayout();
	    gbl_reservationLimitPanel.columnWidths = new int[]{0};
	    gbl_reservationLimitPanel.rowHeights = new int[]{0};
	    gbl_reservationLimitPanel.columnWeights = new double[]{1.0};
	    gbl_reservationLimitPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lblreservation = new GridBagConstraints();
	    gbc_lblreservation.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lblreservation.insets = new Insets(0, 0, 0, 0); 
	    gbc_lblreservation.gridx = 0;
	    gbc_lblreservation.gridy = 0;
	    
	    gbc_btnReservation = new GridBagConstraints();
	    gbc_btnReservation.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnReservation.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnReservation.gridx = 1;
	    gbc_btnReservation.gridy = 0;
	    //
	    
	    // OVERDUE LIMIT LAYPUT
	    gbl_overdueLimitPanel = new GridBagLayout();
	    gbl_overdueLimitPanel.columnWidths = new int[]{0};
	    gbl_overdueLimitPanel.rowHeights = new int[]{0};
	    gbl_overdueLimitPanel.columnWeights = new double[]{1.0};
	    gbl_overdueLimitPanel.rowWeights = new double[]{0.0};
	    
	    gbc_lbloverdue = new GridBagConstraints();
	    gbc_lbloverdue.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_lbloverdue.insets = new Insets(0, 0, 0, 0); 
	    gbc_lbloverdue.gridx = 0;
	    gbc_lbloverdue.gridy = 0;
	    
	    gbc_btnOverdue = new GridBagConstraints();
	    gbc_btnOverdue.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_btnOverdue.insets = new Insets(0, 0, 0, 0); 
	    gbc_btnOverdue.gridx = 1;
	    gbc_btnOverdue.gridy = 0;
	    //
	    

	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout());
	    titlePanel.setLayout(gbl_titlePanel);
	    detailPanel.setLayout(gbl_detailPanel);
	    borrowingCapacityPanel.setLayout(gbl_borrowingCapacityPanel);
	    borrowingDurationPanel.setLayout(gbl_borrowingDurationPane);
	    reservationLimitPanel.setLayout(gbl_reservationLimitPanel);
	    overdueLimitPanel.setLayout(gbl_overdueLimitPanel);
	    buttonPanel.setLayout(new BorderLayout(0,0));


	    
	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnBack, BorderLayout.EAST);
	    
	    titlePanel.add(txtTitle,gbc_txtTitle);
	    titlePanel.add(txtDescription,gbc_txtDescription);
	    
	    borrowingCapacityPanel.add(lblcapacity, gbc_lblcapacity);
	    borrowingCapacityPanel.add(btnCapacity, gbc_btnCapacity);
	    borrowingDurationPanel.add(lblduration, gbc_lblduration);
	    borrowingDurationPanel.add(btnDuration, gbc_btnDuration);
	    reservationLimitPanel.add(lblreservation, gbc_lblreservation);
	    reservationLimitPanel.add(btnReservation, gbc_btnReservation);
	    overdueLimitPanel.add(lbloverdue, gbc_lbloverdue);
	    overdueLimitPanel.add(btnOverdue, gbc_btnOverdue);
	    
	    detailPanel.add(borrowingCapacityPanel, gbc_borrowingCapacityPanel);
	    detailPanel.add(borrowingDurationPanel, gbc_borrowingDurationPanel);
	    detailPanel.add(reservationLimitPanel, gbc_reservationLimitPanel);
	    detailPanel.add(overdueLimitPanel, gbc_overdueLimitPanel);
 
	    buttonPanel.add(btnSave);
	    
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(detailPanel, gbc_detailPanel);
	   	    mainPanel.add(buttonPanel, gbc_buttonPanel);
	    
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
		   			titleTextSize = Math.min(getHeight() / 10, getWidth()/ 15) ;
		   			subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 50);
//		   			bookTitleTextSize =  Math.min(getHeight() / 15, getWidth()/ 15);
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
	  	            btnSave.setFont(buttonFont);
	  	            btnBack.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);
	  	            lblcapacity.setFont(plainFont);
	  	            lblduration.setFont(plainFont);
	  	            lblreservation.setFont(plainFont);
	  	            lbloverdue.setFont(plainFont);	  	        
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
		iconHeight1 = (int) (getHeight() * 0.03);
		scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
		buttonscaledImage = buttonimage.getScaledInstance(iconWidth1, iconHeight1, Image.SCALE_SMOOTH);
		
	    lblHeading.setIcon(new ImageIcon(scaledImage));
	    btnCapacity.setIcon(new ImageIcon(buttonscaledImage));
	    btnDuration.setIcon(new ImageIcon(buttonscaledImage));
	    btnReservation.setIcon(new ImageIcon(buttonscaledImage));
	    btnOverdue.setIcon(new ImageIcon(buttonscaledImage));

	 }
}