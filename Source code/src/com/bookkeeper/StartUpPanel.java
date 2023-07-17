package com.bookkeeper;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class StartUpPanel extends JPanel{
	//panel
//  private JPanel mainPanel;
    private BackgroundPanel mainPanel;
    private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel titlePanel;
	private JPanel subtitlePanel;
	private JPanel buttonPanel;
	
	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblTitle;
	
	//icon
	private ImageIcon icon;
	private Image image;
	
	//button
	private JButton btnClose;
	private JButton btnStart;
	
	//layout
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_logoPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;
	
	//text
	Font titleFont;
	Font subtitleFont;
	int titleTextSize;
	int subtitleTextSize;
	
	public  StartUpPanel() {
	setBackground(new Color(250, 251, 255));
	setBorder(new EmptyBorder(10, 10, 10, 10));
	setLayout(new BorderLayout(0, 0));
 
    //create panels
    mainPanel = new BackgroundPanel();//panel to hold all panels
    headingPanel = new JPanel(); 
    logoPanel = new JPanel();
    titlePanel = new JPanel();
    subtitlePanel = new JPanel();
    buttonPanel = new JPanel();
    
    // Set panel properties 
    mainPanel.setBorder(null);
    mainPanel.setBackground(new Color(250, 251, 255));
    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    subtitlePanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    
    btnClose = new JButton("x");
    btnClose.setFocusPainted(false);
    btnClose.setForeground(new Color(23, 21, 147));
    btnClose.setFont(new Font("Montserrat", Font.PLAIN, 20));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));
    btnClose.setContentAreaFilled(false);
    
    icon = new ImageIcon("img/Logo_Blue.png");
    image = icon.getImage();

    lblLogo = new JLabel();
    lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
    
    lblTitle = new JLabel("BOOK KEEPER");
    lblTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    lblTitle.setIconTextGap(0);
    lblTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
    lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
    lblTitle.setBorder(null);
    lblTitle.setForeground(new Color(23, 21, 147));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    
    lblHeading = new JLabel("Your ultimate companion for managing your literary world.");
    lblHeading.setForeground(new Color(23, 21, 147));
    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
    
    btnStart = new JButton("Start");
    btnStart.setFocusPainted(false);
    btnStart.setForeground(new Color(21, 19, 136));
    btnStart.setFont(new Font("Montserrat", Font.ITALIC, 15));
    btnStart.setBorder(new EmptyBorder(20, 50, 20, 50));
    btnStart.setBorderPainted(false);
    btnStart.setContentAreaFilled(false);
    
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
    gbl_mainPanel.rowHeights = new int[]{108, 239, 56, 53, 68};
    gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
    
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.gridwidth = 2;
    gbc_headingPanel.insets = new Insets(0, 0, 5, 5);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    gbc_logoPanel = new GridBagConstraints();
    gbc_logoPanel.insets = new Insets(0, 0, 5, 0);
    gbc_logoPanel.gridx = 0;
    gbc_logoPanel.gridy = 1;
    gbc_logoPanel.fill = GridBagConstraints.BOTH;
    
    gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.anchor = GridBagConstraints.SOUTH;
    gbc_titlePanel.insets = new Insets(0, 0, 0, 0);
    gbc_titlePanel.gridx = 0;
    gbc_titlePanel.gridy = 2;
    
    gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.anchor = GridBagConstraints.NORTH;
    gbc_subtitlePanel.insets = new Insets(0, 0, 0, 0);
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 3;    
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    // Set panel layouts 
    mainPanel.setLayout(gbl_mainPanel);
    headingPanel.setLayout(new BorderLayout(0, 0));
    buttonPanel.setLayout(new BorderLayout(0, 0));
    
    //Add all to main panel
    headingPanel.add(btnClose, BorderLayout.EAST);
    logoPanel.add(lblLogo);
    titlePanel.add(lblTitle);
    subtitlePanel.add(lblHeading);
    buttonPanel.add(btnStart);
    
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(logoPanel, gbc_logoPanel);
    mainPanel.add(titlePanel, gbc_titlePanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(buttonPanel, gbc_buttonPanel);
    
    
    add(mainPanel);
    
    // Action listener
    btnClose.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    });
  
    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            titleTextSize = Math.min(getHeight() / 9, getWidth() / 20);
            subtitleTextSize = Math.min(getHeight() / 35, getWidth() / 40);
           
            titleFont = new Font("Montserrat", Font.BOLD, titleTextSize);
            lblTitle.setFont(titleFont);
            
            subtitleFont = new Font("Montserrat", Font.ITALIC, subtitleTextSize);
            lblHeading.setFont(subtitleFont);
        }
    });
}


	
public class BackgroundPanel extends JPanel {
	//background
	private Image backgroundImage;
	
	//icon
	private int iconWidth;
	private int iconHeight;
	private Icon scaledIcon;
	
	public BackgroundPanel() {
		backgroundImage = new ImageIcon("img/Triangles_StartUp.png").getImage();
	}
	
//put image over panel
	 @Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
	    * use super.paintComponent(g) for proper rendering 
	    * ng mga components sa taas ng bg image 
	    * ng d nasisira ni custom drawing 
	    */
	    int iconWidth = (int) (getWidth() * 0.17);
        int iconHeight = (int) (getHeight() * 0.27);
        Image scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(scaledImage));
        
	    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
	    /* dis ^^ da custom drawing, s-start nya ilagay si bg from coordinate 0,0 
	    * hanggang sa ma-cover nya  buong panel
	    */
	 }
	    
}  

//Methods 
	public JButton getStart() {
		return btnStart;
	}
}