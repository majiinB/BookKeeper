package com.bookkeeper;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartUpPanel extends JPanel{
    private BackgroundPanel mainPanel;
    private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel titlePanel;
	private JPanel subtitlePanel;
	private JPanel buttonPanel;
	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblTitle;
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private Icon scaledIcon;
	private JButton btnClose;
	private JButton btnStart;
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_logoPanel;
	private GridBagConstraints gbc_titlePanel;
	private GridBagConstraints gbc_subtitlePanel;
	private GridBagConstraints gbc_buttonPanel;
    
	public  StartUpPanel() {
	setBackground(new Color(250, 251, 255));
	setBorder(new EmptyBorder(10, 10, 10, 10));
	setLayout(new BorderLayout(0, 0));
 
    //create panels
    mainPanel = new BackgroundPanel();//panel to hold all panels
    headingPanel = new JPanel(new BorderLayout()); 
    logoPanel = new JPanel();
    titlePanel = new JPanel();
    subtitlePanel = new JPanel();
    buttonPanel = new JPanel();
    
    mainPanel.setBorder(null);
    mainPanel.setBackground(new Color(250, 251, 255));
    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    titlePanel.setOpaque(false);
    subtitlePanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    
    lblHeading = new JLabel("Your ultimate companion for managing your literary world.");
    lblHeading.setIconTextGap(0);
    lblHeading.setFont(new Font("Montserrat", Font.ITALIC, 25));
    lblHeading.setForeground(new Color(23, 21, 147));
    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
    
    icon = new ImageIcon("../img/Logo_Blue.png");
    image = icon.getImage();
    scaledImage = image.getScaledInstance(250, 240, Image.SCALE_SMOOTH);
    scaledIcon = new ImageIcon(scaledImage);
 
    lblLogo = new JLabel();
    lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
    lblLogo.setIcon(scaledIcon);
    
    lblTitle = new JLabel("BOOK KEEPER");
    lblTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    lblTitle.setIconTextGap(0);
    lblTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
    lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
    lblTitle.setBorder(null);
    lblTitle.setFont(new Font("Montserrat", lblTitle.getFont().getStyle() | Font.BOLD, lblTitle.getFont().getSize() + 120));
    lblTitle.setForeground(new Color(23, 21, 147));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

    btnClose = new JButton("x");
    btnClose.setFocusPainted(false);
    btnClose.setForeground(new Color(23, 21, 147));
    btnClose.setFont(new Font("Montserrat", Font.PLAIN, 20));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));

    btnStart = new JButton("Start ");
    btnStart.setFocusPainted(false);
    btnStart.setForeground(new Color(21, 19, 136));
    btnStart.setFont(new Font("Montserrat", Font.ITALIC, 20));
    btnStart.setBackground(new Color(3, 0, 91));
    btnStart.setBorder(new EmptyBorder(20, 50, 20, 50));
    btnStart.setBorderPainted(false);
    
    
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
    gbl_mainPanel.rowHeights = new int[]{108, 305, 138, 108, 180};
    gbl_mainPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
    
    mainPanel.setLayout(gbl_mainPanel);
    
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.gridwidth = 2;
    gbc_headingPanel.insets = new Insets(0, 0, 5, 5);
    gbc_headingPanel.gridx = 0; 
    gbc_headingPanel.gridy = 0;
    
    gbc_logoPanel = new GridBagConstraints();
    gbc_logoPanel.gridwidth = 2;
    gbc_logoPanel.insets = new Insets(0, 0, 5, 5);
    gbc_logoPanel.gridx = 0;
    gbc_logoPanel.gridy = 1;
    
    gbc_titlePanel = new GridBagConstraints();
    gbc_titlePanel.fill = GridBagConstraints.VERTICAL;
    gbc_titlePanel.gridwidth = 2;
    gbc_titlePanel.insets = new Insets(0, 0, 0, 5);
    gbc_titlePanel.gridx = 0;
    gbc_titlePanel.gridy = 2;
    
    gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.anchor = GridBagConstraints.NORTH;
    gbc_subtitlePanel.gridwidth = 2;
    gbc_subtitlePanel.insets = new Insets(0, 0, 5, 5);
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 3;    
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
    gbc_buttonPanel.gridwidth = 2;
    gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 4;
    
    //Add all to main panel
    headingPanel.add(btnClose, BorderLayout.EAST);
    logoPanel.add(lblLogo);
    titlePanel.add(lblTitle);
    subtitlePanel.add(lblHeading);
    buttonPanel.setLayout(new BorderLayout(0, 0));
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
  
}
	
	//BACKGROUND NA TRIANGLES SHEESH DUNT TOUCH MALIBAN SA IMAGE PATH
	public class BackgroundPanel extends JPanel {
	    private Image backgroundImage;

	    public BackgroundPanel() {
	    	//change the image path!!!
	        backgroundImage = new ImageIcon("img/Triangles_StartUpPage.png").getImage();
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
