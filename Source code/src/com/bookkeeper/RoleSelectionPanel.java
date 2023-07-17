package com.bookkeeper;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class RoleSelectionPanel extends JPanel {
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel buttonPanel;
	private JLabel lblHeading;
	private JLabel lblLogo;
	private JLabel lblSubTitle;
	private JButton btnAdmin;
	private JButton btnPatron;
	private ImageIcon icon;
	private Image image;
	private Image scaledImage;
	private Icon scaledIcon;
	private JButton btnClose;
	private GridBagLayout gbl_mainPanel;
	private GridBagConstraints gbc_headingPanel;
	private GridBagConstraints gbc_buttonPanel;
	private GridBagLayout gbl_buttonPanel;
	private GridBagConstraints gbc_btnPatron;
	private GridBagConstraints gbc_btnAdmin;
public  RoleSelectionPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel(new BorderLayout());
    logoPanel = new JPanel();
    buttonPanel = new JPanel();
    buttonPanel.setBorder(new EmptyBorder(0, 60, 0, 60));

    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    mainPanel.setBorder(null);
    mainPanel.setBackground(new Color(250, 251, 255));
   
    icon = new ImageIcon("img/Logo_Blue.png");
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
    btnClose.setFont(new Font("Montserrat", Font.PLAIN, 15));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));
    
    btnPatron = new JButton();
    btnPatron.setText("patron");
    btnPatron.setForeground(new Color(249, 250, 255));
    btnPatron.setFocusPainted(false);
    btnPatron.setBorder(new EmptyBorder(120, 300, 120, 200));
    btnPatron.setBackground(new Color(3, 0, 91));
 	btnPatron.setBorderPainted(false);
	btnPatron.setOpaque(true);

	btnAdmin = new JButton();
	btnAdmin.setText("admin");
	btnAdmin.setForeground(new Color(249, 250, 255));
	btnAdmin.setFocusPainted(false);
	btnAdmin.setBorder(new EmptyBorder(30, 100, 30, 100));
	btnAdmin.setOpaque(true);
	btnAdmin.setBorderPainted(false);
	btnAdmin.setBackground(new Color(3, 0, 93));

	gbl_mainPanel = new GridBagLayout();
    gbl_mainPanel.columnWidths = new int[]{180, 26, 0};
    gbl_mainPanel.rowHeights = new int[]{46, 483};
    gbl_mainPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 1.0};
       
    gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.gridwidth = 2;
    gbc_headingPanel.insets = new Insets(0, 0, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    
    gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_buttonPanel.gridwidth = 2;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 1;
    
    gbl_buttonPanel = new GridBagLayout();
    gbl_buttonPanel.columnWidths = new int[]{541, 0};
    gbl_buttonPanel.rowHeights = new int[]{254, 63, 262, 0};
    gbl_buttonPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    

    gbc_btnPatron = new GridBagConstraints();
    gbc_btnPatron.fill = GridBagConstraints.BOTH;
    gbc_btnPatron.insets = new Insets(0, 0, 5, 0);
    gbc_btnPatron.gridx = 0;
    gbc_btnPatron.gridy = 0;
    
    gbc_btnAdmin = new GridBagConstraints();
    gbc_btnAdmin.fill = GridBagConstraints.BOTH;
    gbc_btnAdmin.gridx = 0;
    gbc_btnAdmin.gridy = 2;
    
    mainPanel.setLayout(gbl_mainPanel);
    buttonPanel.setLayout(gbl_buttonPanel);
        
        
    //Add all to main panel
    headingPanel.add(lblLogo, BorderLayout.WEST);
    headingPanel.add(btnClose, BorderLayout.EAST);
    buttonPanel.add(btnPatron, gbc_btnPatron);
    buttonPanel.add(btnAdmin, gbc_btnAdmin);
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(buttonPanel, gbc_buttonPanel);

    
    add(mainPanel);
}
}