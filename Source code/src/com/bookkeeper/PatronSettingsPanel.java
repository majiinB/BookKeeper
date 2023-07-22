package com.bookkeeper;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.KeyEvent;

public class PatronSettingsPanel extends JPanel {
	//panel
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel headingPanel;
	private RoundedPanel accDetailPanel;
	private RoundedPanel reserveBookPanel;
	private RoundedPanel activeLoanPanel;
	private RoundedPanel historyLoanPanel;

	//label
	private JLabel lblHeading1;
	private JLabel lblHeading2;
	
	//textfield
	
	//icon
	private ImageIcon searchIcon;
	private Image searchImage;
	private int iconHeight; 
	private int iconWidth;
	//button
	private JButton btnDetail;
	
	//scroll
	private JScrollPane  settingScrollPane;
	
	//table
	private PlaceholderTable reserveListTable;
	private PlaceholderTable activeLoanListTable;
	private PlaceholderTable historyLoanListTable;
	
	//layout
	private GridBagLayout gbl_contentPanel;
	private GridBagConstraints gbc_headingPanel;

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

 public PatronSettingsPanel() {
	setBackground(lightplainColor);
	setBorder(new EmptyBorder(10, 10, 10, 10));
	setLayout(new BorderLayout(0, 0));
	 
	//create panels
	mainPanel = new JPanel();
	mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
//	mainPanel = new BackgroundPanel();
	contentPanel = new JPanel();
	headingPanel = new JPanel();
	
    accDetailPanel =  new RoundedPanel(20);
    reserveBookPanel =  new RoundedPanel(20);
    activeLoanPanel =  new RoundedPanel(20);
    historyLoanPanel =  new RoundedPanel(20);

    // Set panel properties
    mainPanel.setOpaque(false);
    headingPanel.setOpaque(false);
    contentPanel.setOpaque(false);
    


    lblHeading1 = new JLabel("Dashboard ");
    lblHeading1.setOpaque(false);
    
    lblHeading2 = new JLabel("/ Settings");
    lblHeading2.setOpaque(false);
    


	reserveListTable = new PlaceholderTable();
	activeLoanListTable = new PlaceholderTable();
	historyLoanListTable = new PlaceholderTable();
	
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
    gbl_contentPanel = new GridBagLayout();
    gbl_contentPanel.columnWidths = new int[]{380, 0};
    gbl_contentPanel.rowHeights = new int[]{33, 30, 46, 0};
    gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
   
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.WEST;
    gbc_headingPanel.insets = new Insets(0, 0, 0, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;    
	
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.WEST;
    gbc_headingPanel.insets = new Insets(0, 0, 0, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;  	
    
	
	// Set panel layouts
    mainPanel.setLayout(new BorderLayout(0,0));
    contentPanel.setLayout(gbl_contentPanel);
    headingPanel.setLayout(new FlowLayout());

    //Add all to main panel
    headingPanel.add(lblHeading1);
    headingPanel.add(lblHeading2);


    contentPanel.add(headingPanel,gbc_headingPanel);

    
    mainPanel.add(contentPanel, BorderLayout.CENTER);

	add(mainPanel, BorderLayout.CENTER);
	
	addComponentListener(new ComponentAdapter() {
  	  @Override
        public void componentResized(ComponentEvent e) {
	      	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;//Size after search button is pressed
	    	titleTextSize = Math.min(getHeight() / 12, getWidth()/ 14) ;//Size after search button is pressed
//	        subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 45);
	        buttonTextSize =  Math.min(getHeight() / 40, getWidth()/ 58);
	        headerTextSize =   Math.min(getHeight() / 30, getWidth()/ 35);
//			plainTextsize=   Math.min(getHeight() / 20, getWidth()/ 60);
	            
	        titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
//	        txtTitle.setFont(titleFont);
//			.setFont(titleFont);
	            
//			subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
	            
//	        buttonFont = new Font("Montserrat", Font.ITALIC, buttonTextSize);
	            
//	     	headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
//			btnBack.setFont(headerFont);
	     	lblHeading1.setFont(new Font("Montserrat", Font.BOLD, headerTextSize));
	     	lblHeading2.setFont(new Font("Montserrat", Font.PLAIN, headerTextSize));
	            
//			plainFont = new Font("Montserrat", Font.ITALIC | Font.BOLD, plainTextsize);
        }
    });
 }
}
