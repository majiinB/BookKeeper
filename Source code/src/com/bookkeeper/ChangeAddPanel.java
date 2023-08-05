package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class ChangeAddPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;


	//label
	private JLabel lblHeading;
	private JTextArea txtTitle;//title of panel "Book Information"
	private JTextArea txtDescription;

	private JLabel lblCurrentAdd;
	private JLabel lblNewAdd;


	
	//textfield
	private PlaceholderTextField txtCurrentAdd;
	private PlaceholderTextField txtNewAdd;


	//button
	private JButton btnUpdate;
	private JButton btnCancel;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_inputPanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagLayout gbl_titlePanel; 
    private GridBagConstraints gbc_txtTitle;
    private GridBagConstraints gbc_txtDescription;
    
    private GridBagLayout gbl_inputPanel;
    private GridBagConstraints gbc_lblCurrentAdd;
    private GridBagConstraints gbc_txtCurrentAdd;
    private GridBagConstraints gbc_lblNewAdd;
    private GridBagConstraints gbc_txtNewAdd;

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
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white

	public ChangeAddPanel() {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    headingPanel = new JPanel();
	    titlePanel = new JPanel();
	    inputPanel = new JPanel();
	    buttonPanel = new JPanel();

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    headingPanel.setOpaque(false);
	    titlePanel.setOpaque(false);
	    inputPanel.setOpaque(false);
	    buttonPanel.setOpaque(false);

	    
	    lblHeading = new JLabel();
	    lblHeading.setIconTextGap(20);
	    lblHeading.setFocusable(false);
	    lblHeading.setForeground(headerColor);
	    lblHeading.setText("User Details");
	    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
	  
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFocusPainted(false);
	    btnCancel.setForeground(new Color(23, 21, 147));
	    btnCancel.setBorderPainted(false);
	    btnCancel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    btnCancel.setOpaque(false);
	    
	    txtTitle = new JTextArea();
	    txtTitle.setForeground(headerColor);
	    txtTitle.setLineWrap(true);
	    txtTitle.setOpaque(false);
	    txtTitle.setWrapStyleWord(true);
	    txtTitle.setFocusable(false);
	    txtTitle.setEditable(false);
	    txtTitle.setDragEnabled(false);
	    txtTitle.setAutoscrolls(false);
	    txtTitle.setText("Home Address");
	    
	    txtDescription = new JTextArea();
	    txtDescription.setForeground(darkplainColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("Manage your address to make sure your info is accurate and up to date.");
	    
	    lblCurrentAdd = new JLabel("Current Address");
	    lblCurrentAdd.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCurrentAdd.setBorder(null);
	    lblCurrentAdd.setForeground(darkplainColor);
	    
	    txtCurrentAdd = new PlaceholderTextField("Enter Current Address");
	    txtCurrentAdd.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtCurrentAdd.setForeground(darkplainColor);
	    txtCurrentAdd.setBackground(middleplainColor);
	    txtCurrentAdd.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtCurrentAdd.setOpaque(true);
	    txtCurrentAdd.setFocusable(true);
	    txtCurrentAdd.setEditable(true);
	    txtCurrentAdd.setDragEnabled(false);
	    
	    lblNewAdd = new JLabel("New Address");
	    lblNewAdd.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewAdd.setBorder(null);
	    lblNewAdd.setForeground(darkplainColor);
	    
	    txtNewAdd = new PlaceholderTextField("Enter New Address");
	    txtNewAdd.setHorizontalAlignment(SwingConstants.RIGHT);
	    txtNewAdd.setForeground(darkplainColor);
	    txtNewAdd.setBackground(middleplainColor);
	    txtNewAdd.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtNewAdd.setOpaque(true);
	    txtNewAdd.setFocusable(true);
	    txtNewAdd.setEditable(true);
	    txtNewAdd.setDragEnabled(false);
	    
	    btnUpdate = new JButton();
	    btnUpdate.setText("Update");
	    btnUpdate.setMnemonic(KeyEvent.VK_ENTER);
	    btnUpdate.setForeground(lightplainColor);
	    btnUpdate.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnUpdate.setOpaque(true);
	    btnUpdate.setFocusPainted(false);
	    btnUpdate.setBorderPainted(false);
	    btnUpdate.setBackground(headerColor);
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
	    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
	    gbc_headingPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_headingPanel.gridx = 0;
	    gbc_headingPanel.gridy = 0;

	    gbc_titlePanel = new GridBagConstraints();
	    gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_titlePanel.anchor = GridBagConstraints.NORTH;
	    gbc_titlePanel.insets = new Insets(20, 20, 20, 20);
	    gbc_titlePanel.gridx = 0;
	    gbc_titlePanel.gridy = 1;	    

	    gbc_inputPanel = new GridBagConstraints();
	    gbc_inputPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_inputPanel.anchor = GridBagConstraints.NORTH;
	    gbc_inputPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_inputPanel.gridx = 0;
	    gbc_inputPanel.gridy = 2;	 
	    
	    gbc_buttonPanel = new GridBagConstraints();
	    gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
	    gbc_buttonPanel.insets = new Insets(20, 20, 20, 20);
	    gbc_buttonPanel.gridx = 0;
	    gbc_buttonPanel.gridy = 3;
	    
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
        gbc_txtDescription.insets = new Insets(0, 0, 0, 0);
        gbc_txtDescription.gridx = 0;
        gbc_txtDescription.gridy = 1;
	    
	    gbl_inputPanel = new GridBagLayout();
        gbl_inputPanel.columnWidths = new int[]{865};
        gbl_inputPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_inputPanel.columnWeights = new double[]{1.0};
        gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        
//      CURRENT ADDRESS
        gbc_lblCurrentAdd = new GridBagConstraints();
        gbc_lblCurrentAdd.fill = GridBagConstraints.BOTH;
        gbc_lblCurrentAdd.insets = new Insets(0, 0, 0, 0);
        gbc_lblCurrentAdd.gridx = 0;
        gbc_lblCurrentAdd.gridy = 0;
     
        gbc_txtCurrentAdd = new GridBagConstraints();
        gbc_txtCurrentAdd.fill = GridBagConstraints.BOTH;
        gbc_txtCurrentAdd.insets = new Insets(5, 0, 0, 0);
        gbc_txtCurrentAdd.gridx = 0;
        gbc_txtCurrentAdd.gridy = 1;
      
//      NEW ADDRESS
        gbc_lblNewAdd = new GridBagConstraints();
        gbc_lblNewAdd.fill = GridBagConstraints.BOTH;
        gbc_lblNewAdd.insets = new Insets(20, 0, 0, 0);
        gbc_lblNewAdd.gridx = 0;
        gbc_lblNewAdd.gridy = 2;
      
      	gbc_txtNewAdd = new GridBagConstraints();
      	gbc_txtNewAdd.fill = GridBagConstraints.BOTH;
      	gbc_txtNewAdd.insets = new Insets(5, 0, 0, 0);
      	gbc_txtNewAdd.gridx = 0;
      	gbc_txtNewAdd.gridy = 3;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    headingPanel.setLayout(new BorderLayout(0, 0));
	    titlePanel.setLayout(gbl_titlePanel);
	    inputPanel.setLayout(gbl_inputPanel);
	    buttonPanel.setLayout(new BorderLayout(0, 0));

	    //Add all to main panel
	    headingPanel.add(lblHeading, BorderLayout.WEST);
	    headingPanel.add(btnCancel, BorderLayout.EAST);

	    titlePanel.add(txtTitle, gbc_txtTitle);
	    titlePanel.add(txtDescription, gbc_txtDescription);
//	    inputPanel.add(=);
	    inputPanel.add(lblCurrentAdd, gbc_lblCurrentAdd);
	    inputPanel.add(txtCurrentAdd, gbc_txtCurrentAdd);
	    inputPanel.add(lblNewAdd, gbc_lblNewAdd);
	    inputPanel.add(txtNewAdd, gbc_txtNewAdd);
	    
	    buttonPanel.add(btnUpdate);
	    mainPanel.add(headingPanel, gbc_headingPanel);
	    mainPanel.add(titlePanel, gbc_titlePanel);
	    mainPanel.add(inputPanel, gbc_inputPanel);
	    mainPanel.add(buttonPanel,gbc_buttonPanel);
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 25);
	  	            buttonTextSize =  Math.min(getHeight() / 30, getWidth()/ 30);
	  	           	headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 30);
	  	           	plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 50);
	  	          
	  	            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
	  	            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);

	  	            txtTitle.setFont(titleFont);
	  	           	txtDescription.setFont(subtitleFont);
	  	            btnUpdate.setFont(buttonFont);	  	            
	  	            btnCancel.setFont(headerFont);
	  	            lblHeading.setFont(headerFont);	  	            
//	  	          	.setFont(plainFont); 
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

	 }
	public JButton getBtnBack() {
		return btnCancel;
	}
}