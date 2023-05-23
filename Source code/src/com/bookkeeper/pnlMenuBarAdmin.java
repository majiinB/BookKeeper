package com.bookkeeper;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pnlMenuBarAdmin extends JPanel {

	public  pnlMenuBarAdmin() {
		setSize(new Dimension(200, 579));
		setBorder(null);
		setBackground(new Color(26, 24, 87));


	JButton btnLibrary = new JButton("  Library");
		ImageIcon icnLibrary = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/libraryIcon.png");//files are in desktop
		Image imgLibrary = icnLibrary.getImage();
		Image rsdImgLibrary = imgLibrary.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		setLayout(null);
		btnLibrary.setIcon(new ImageIcon("D:\\documents\\Final_Project\\img\\libraryIcon.png"));
		btnLibrary.setSelectedIcon(new ImageIcon(rsdImgLibrary));  
		btnLibrary.setForeground(new Color(255, 255, 255));
		btnLibrary.setContentAreaFilled(false);
	    btnLibrary.setOpaque(false);
	    btnLibrary.setBorderPainted(false);        
	    btnLibrary.setBounds(0, 75, 150, 37);
	    btnLibrary.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//panel Library

		    	}
		    });
	    add(btnLibrary);
    
    JButton btnReport = new JButton("   Reports");
	    btnReport.setBounds(0, 137, 150, 37);
		ImageIcon icnReport = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/reportsIcon.png");//files are in desktop
		Image imgReport = icnReport.getImage();
		Image rsdImgReport = imgReport.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnReport.setIcon(new ImageIcon("D:\\documents\\Final_Project\\img\\statisticsIcon.png"));
		btnReport.setSelectedIcon(new ImageIcon(rsdImgReport));        
		btnReport.setForeground(new Color(255, 255, 255));
		btnReport.setContentAreaFilled(false);
		btnReport.setOpaque(false);
		btnReport.setBorderPainted(false);    
			btnReport.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//panel Report

		    	}
		    });
	    add(btnReport);
    
    JButton btnUsers = new JButton("  Manage Users");
		ImageIcon icnUsers = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/userManagementIcont.png");//files are in desktop
		Image imgUsers = icnUsers.getImage();
		Image rsdImgUsers = imgUsers.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		btnUsers.setIcon(new ImageIcon("D:\\documents\\Final_Project\\img\\userManagementIcont.png"));
		btnUsers.setSelectedIcon(new ImageIcon(rsdImgUsers));        
		btnUsers.setForeground(new Color(255, 255, 255));
		btnUsers.setContentAreaFilled(false);
	    btnUsers.setOpaque(false);
	    btnUsers.setBorderPainted(false);        
	    btnUsers.setBounds(0, 202, 150, 37);
		    btnUsers.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		//panel Users
	
		    	}
		    });
	    add(btnUsers);
	    
	    JButton btnLogOut = new JButton("  Log out");
	    btnLogOut.setForeground(new Color(255, 255, 255));
	    btnLogOut.setIcon(new ImageIcon("D:\\documents\\Final_Project\\img\\logOutIcon.png"));
	    btnLogOut.setContentAreaFilled(false);
	    btnLogOut.setBorderPainted(false);
	    btnLogOut.setBounds(0, 486, 143, 37);
	    add(btnLogOut);
		ImageIcon icnLogOut = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/logOutIcon.png");//files are in desktop
		Image imgLogOut = icnLogOut.getImage();
		Image rsdImgLogOut = imgLogOut.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
    
}	
}
