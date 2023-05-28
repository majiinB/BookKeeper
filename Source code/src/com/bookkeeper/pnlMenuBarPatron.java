package com.bookkeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pnlMenuBarPatron extends JPanel {
	private JButton btnLibrary;
	private JButton btnUsers;
	private JButton btnLogOut;
	
	public pnlMenuBarPatron() {
		
	setSize(new Dimension(200, 900));
	setBorder(null);
    
	JLabel lblLogo = new JLabel(" ");
	lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogo.setBounds(-11, 37, 180, 124);
	add(lblLogo);
	ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
	Image imgLogos = icnLogo.getImage();
	Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	lblLogo.setIcon(new ImageIcon(rsdImgLogo));
	
	//create library button
	this.setBackground(new Color(26, 24, 87));
	ImageIcon icnLibrary = new ImageIcon("D:\\documents\\Final_Project\\img\\homeIcon.png");//files are in desktop
	Image imgLibrary = icnLibrary.getImage();
	Image rsdImgLibrary = imgLibrary.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	setLayout(null);
    
    //Create button for library
    btnLibrary = new JButton("  library");
    btnLibrary.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
    btnLibrary.setBounds(-11, 192, 168, 37);
	ImageIcon icnReport = new ImageIcon("D:\\documents\\Final_Project\\img\\libraryIcon.png");//files are in desktop
	Image imgReport = icnReport.getImage();
	Image rsdImgReport = imgReport.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	btnLibrary.setIcon(new ImageIcon(rsdImgReport));
	btnLibrary.setSelectedIcon(new ImageIcon(rsdImgReport));        
	btnLibrary.setForeground(new Color(255, 255, 255));
	btnLibrary.setContentAreaFilled(false);
	btnLibrary.setOpaque(false);
	btnLibrary.setBorderPainted(false);
	btnLibrary.setFocusPainted(false);  
    add(btnLibrary);
    
    //Create User account button
    btnUsers = new JButton("  Account");
	ImageIcon icnUsers = new ImageIcon("D:\\documents\\Final_Project\\img\\accountIcon.png");//files are in desktop
	Image imgUsers = icnUsers.getImage();
	Image rsdImgUsers = imgUsers.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	btnUsers.setIcon(new ImageIcon(rsdImgUsers));
	btnUsers.setSelectedIcon(new ImageIcon(rsdImgUsers));        
	btnUsers.setForeground(new Color(255, 255, 255));
	btnUsers.setContentAreaFilled(false);
    btnUsers.setOpaque(false);
    btnUsers.setBorderPainted(false);        
    btnUsers.setBounds(-11, 240, 168, 55);
    btnUsers.setFocusPainted(false);  
    add(btnUsers);     
    
    //Create log out button
    btnLogOut = new JButton("Log-Out");
    btnLogOut.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
	ImageIcon icnLogOut = new ImageIcon("D:\\documents\\Final_Project\\img\\logOutIcon.png");//files are in desktop
	Image imgLogOut = icnLogOut.getImage();
	Image rsdImgLogOut = imgLogOut.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	btnLogOut.setIcon(new ImageIcon(rsdImgLogOut));
	btnLogOut.setSelectedIcon(new ImageIcon(rsdImgLogOut));        
	btnLogOut.setForeground(new Color(255, 255, 255));
    btnLogOut.setContentAreaFilled(false);
    btnLogOut.setOpaque(false);
    btnLogOut.setBorderPainted(false);
    btnLogOut.setBounds(-11, 490, 159, 55);
    btnLogOut.setFocusPainted(false); 
    add(btnLogOut);
     
	}
	public JButton getLibraryBtn() {
		return btnLibrary;
	}
	public JButton getUsersBtn() {
		return btnUsers;
	}
	public JButton getLogOut() {
		return btnLogOut;
	}
}
