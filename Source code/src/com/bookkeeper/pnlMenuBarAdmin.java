package com.bookkeeper;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pnlMenuBarAdmin extends JPanel {
	private JButton btnLibrary;
	private JButton btnReport;
	private JButton btnUsers;
	private JButton btnLogOut ;
	
	public  pnlMenuBarAdmin() {
		setSize(new Dimension(200, 579));
		setBorder(null);
		setBackground(new Color(26, 24, 87));
		setLayout(null);
		
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(-19, 45, 180, 124);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		
		//Library
		btnLibrary = new JButton("  Library");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon icnLibrary = new ImageIcon("D:\\documents\\Final_Project\\img\\libraryIcon.png");//files are in desktop
		Image imgLibrary = icnLibrary.getImage();
		Image rsdImgLibrary = imgLibrary.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnLibrary.setIcon(new ImageIcon(rsdImgLibrary));
		btnLibrary.setSelectedIcon(new ImageIcon(rsdImgLibrary));  
		btnLibrary.setForeground(new Color(255, 255, 255));
		btnLibrary.setContentAreaFilled(false);
	    btnLibrary.setOpaque(false);
	    btnLibrary.setBorderPainted(false);        
	    btnLibrary.setBounds(-11, 207, 150, 37);
	    add(btnLibrary);
	    
	    //Reports
	    btnReport = new JButton("   Reports");
		ImageIcon icnReport = new ImageIcon("D:\\documents\\Final_Project\\img\\statisticsIcon.png");//files are in desktop
		Image imgReport = icnReport.getImage();
		Image rsdImgReport = imgReport.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnReport.setIcon(new ImageIcon(rsdImgReport));
		btnReport.setSelectedIcon(new ImageIcon(rsdImgReport));        
		btnReport.setForeground(new Color(255, 255, 255));
		btnReport.setContentAreaFilled(false);
		btnReport.setOpaque(false);
		btnReport.setBorderPainted(false);   
		btnReport.setBounds(-11, 268, 150, 37);
	    add(btnReport);
	    
	    //User management 
	    btnUsers = new JButton(" Manage Users");
	    btnUsers.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
		ImageIcon icnUsers = new ImageIcon("D:\\documents\\Final_Project\\img\\userManagementIcont.png");//files are in desktop
		Image imgUsers = icnUsers.getImage();
		Image rsdImgUsers = imgUsers.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnUsers.setIcon(new ImageIcon(rsdImgUsers));
		btnUsers.setSelectedIcon(new ImageIcon(rsdImgUsers));        
		btnUsers.setForeground(new Color(255, 255, 255));
		btnUsers.setContentAreaFilled(false);
	    btnUsers.setOpaque(false);
	    btnUsers.setBorderPainted(false);        
	    btnUsers.setBounds(-11, 331, 172, 37);
	    add(btnUsers);
	    
	    //Logout button
	    btnLogOut = new JButton(" Log out");
		ImageIcon icnUsers1 = new ImageIcon("D:\\documents\\Final_Project\\img\\logOutIcon.png");//files are in desktop
		Image imgUsers1 = icnUsers1.getImage();
		Image rsdImgUsers1 = imgUsers1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnLogOut.setIcon(new ImageIcon(rsdImgUsers1));
		btnLogOut.setSelectedIcon(new ImageIcon(rsdImgUsers1));
		btnLogOut.setForeground(new Color(255, 255, 255));
	    btnLogOut.setContentAreaFilled(false);
	    btnLogOut.setOpaque(false);
	    btnLogOut.setBorderPainted(false);
	    btnLogOut.setBounds(-11, 508, 143, 37);
	    add(btnLogOut);
    
	}	
	//methods
	public JButton getLibraryBtn() {
		return btnLibrary;
	}
	public JButton getReportBtn() {
		return btnReport;
	}
	public JButton getUserBtn() {
		return btnUsers;
	}
	public JButton getLogOutBtn() {
		return btnLogOut;
	}
}
