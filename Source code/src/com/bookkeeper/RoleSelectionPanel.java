package com.bookkeeper;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
//dun touch d ko pa toh naaayos fr fr

public class RoleSelectionPanel extends JPanel {
	private JPanel mainPanel;
	private JPanel headingPanel;
	private JPanel logoPanel;
	private JPanel subtitlePanel;
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
	
public  RoleSelectionPanel() {
	setBackground(new Color(250, 251, 255));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout(0, 0));

    //create panels
    mainPanel = new JPanel();//panel to hold all panels
    headingPanel = new JPanel(new BorderLayout());
    logoPanel = new JPanel();
    subtitlePanel = new JPanel();
    buttonPanel = new JPanel(new GridLayout(0, 2, 40, 0));

    headingPanel.setOpaque(false);
    logoPanel.setOpaque(false);
    subtitlePanel.setOpaque(false);
    buttonPanel.setOpaque(false);
    mainPanel.setBorder(null);
    mainPanel.setBackground(new Color(250, 251, 255));
    
    lblHeading = new JLabel("pili ka dyan pre");
    lblHeading.setFont(new Font("Montserrat", Font.ITALIC, 25));
    lblHeading.setForeground(new Color(23, 21, 147));
    lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
    
    icon = new ImageIcon("/Users/PANPAN/eclipse-workspace/Fixed_Book_Keeper/img/Logo_Blue.png");
    image = icon.getImage();
    scaledImage = image.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
    scaledIcon = new ImageIcon(scaledImage);

    btnClose = new JButton("x");
    btnClose.setFocusPainted(false);
    btnClose.setForeground(new Color(23, 21, 147));
    btnClose.setFont(new Font("Montserrat", Font.PLAIN, 20));
    btnClose.setBorderPainted(false);
    btnClose.setBorder(new EmptyBorder(5, 5, 5, 5));

    btnAdmin = new JButton();
    btnAdmin.setFocusPainted(false);
    btnAdmin.setBorder(new EmptyBorder(160, 250, 160, 250));
    btnAdmin.setOpaque(true);
    btnAdmin.setBorderPainted(false);
    btnAdmin.setBackground(new Color(3, 0, 93));
    
    btnPatron = new JButton();
    btnPatron.setFocusPainted(false);
    btnPatron.setBorder(new EmptyBorder(120, 300, 120, 200));
    btnPatron.setBackground(new Color(3, 0, 91));
    btnPatron.setBorderPainted(false);
    btnPatron.setOpaque(true);
    
    GridBagLayout gbl_mainPanel = new GridBagLayout();
    gbl_mainPanel.columnWidths = new int[]{180, 26, 0};
    gbl_mainPanel.rowHeights = new int[]{46, 311, 483};
    gbl_mainPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0};
    
    mainPanel.setLayout(gbl_mainPanel);
    
    GridBagConstraints gbc_headingPanel = new GridBagConstraints();
    gbc_headingPanel.anchor = GridBagConstraints.NORTH;
    gbc_headingPanel.fill = GridBagConstraints.HORIZONTAL;
    gbc_headingPanel.gridwidth = 2;
    gbc_headingPanel.insets = new Insets(0, 0, 5, 0);
    gbc_headingPanel.gridx = 0;
    gbc_headingPanel.gridy = 0;
    

    
    
    GridBagConstraints gbc_subtitlePanel = new GridBagConstraints();
    gbc_subtitlePanel.anchor = GridBagConstraints.NORTH;
    gbc_subtitlePanel.gridwidth = 2;
    gbc_subtitlePanel.insets = new Insets(0, 0, 5, 0);
    gbc_subtitlePanel.gridx = 0;
    gbc_subtitlePanel.gridy = 1;    
    
    GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
    gbc_buttonPanel.fill = GridBagConstraints.VERTICAL;
    gbc_buttonPanel.gridwidth = 2;
    gbc_buttonPanel.gridx = 0;
    gbc_buttonPanel.gridy = 2;
    
       lblLogo = new JLabel();
       lblLogo.setIconTextGap(20);
       lblLogo.setFocusable(false);
       lblLogo.setForeground(new Color(23, 21, 147));
       lblLogo.setFont(new Font("Montserrat", Font.PLAIN, 15));
       lblLogo.setText("Book Keeper");
       headingPanel.add(lblLogo, BorderLayout.WEST);
       lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
       lblLogo.setIcon(scaledIcon);
    
    //Add all to main panel
    
    headingPanel.add(btnClose, BorderLayout.EAST);
    subtitlePanel.add(lblHeading);
    buttonPanel.add(btnPatron);
    buttonPanel.add(btnAdmin);
    mainPanel.add(headingPanel, gbc_headingPanel);
    mainPanel.add(subtitlePanel, gbc_subtitlePanel);
    mainPanel.add(buttonPanel, gbc_buttonPanel);

    
    add(mainPanel);
}
}