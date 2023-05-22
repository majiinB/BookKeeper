package com.bookkeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pnlMenuBarPatron extends JPanel {
	
	public pnlMenuBarPatron() {
		
	setSize(new Dimension(200, 900));
	setBorder(null);
    
	this.setBackground(new Color(26, 24, 87));
    JButton btnLibrary = new JButton("Home");
	ImageIcon icnLibrary = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/homeIcon.png");//files are in desktop
	Image imgLibrary = icnLibrary.getImage();
	Image rsdImgLibrary = imgLibrary.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	setLayout(null);
	btnLibrary.setIcon(new ImageIcon(rsdImgLibrary));
	btnLibrary.setSelectedIcon(new ImageIcon(rsdImgLibrary));  
	btnLibrary.setForeground(new Color(255, 255, 255));
	btnLibrary.setContentAreaFilled(false);
    btnLibrary.setOpaque(false);
    btnLibrary.setBorderPainted(false);        
    btnLibrary.setBounds(0, 75, 200, 37);
    add(btnLibrary);
    
    JButton btnReport = new JButton("libraryIcon");

    btnReport.setBounds(0, 137, 200, 37);
	ImageIcon icnReport = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/reportsIcon.png");//files are in desktop
	Image imgReport = icnReport.getImage();
	Image rsdImgReport = imgReport.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	btnReport.setIcon(new ImageIcon(rsdImgReport));
	btnReport.setSelectedIcon(new ImageIcon(rsdImgReport));        
	
	btnReport.setForeground(new Color(255, 255, 255));
	btnReport.setContentAreaFilled(false);
	btnReport.setOpaque(false);
	btnReport.setBorderPainted(false);        
    add(btnReport);
    
    JButton btnUsers = new JButton("Account");
	ImageIcon icnUsers = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/accountIcon.png");//files are in desktop
	Image imgUsers = icnUsers.getImage();
	Image rsdImgUsers = imgUsers.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	btnUsers.setIcon(new ImageIcon(rsdImgUsers));
	btnUsers.setSelectedIcon(new ImageIcon(rsdImgUsers));        
	
	btnUsers.setForeground(new Color(255, 255, 255));
	btnUsers.setContentAreaFilled(false);
    btnUsers.setOpaque(false);
    btnUsers.setBorderPainted(false);        
    btnUsers.setBounds(0, 202, 200, 37);
    add(btnUsers);     
    
    JButton btnLogOut = new JButton("Log-Out");
    btnLogOut.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		//back to main frame choose role
    	}
    });
	ImageIcon icnLogOut = new ImageIcon("/Users/PANPAN/Desktop/Bookkeeeper/Final_Project/img/logOutIcon.png");//files are in desktop
	Image imgLogOut = icnLogOut.getImage();
	Image rsdImgLogOut = imgLogOut.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	btnLogOut.setIcon(new ImageIcon(rsdImgLogOut));
	btnLogOut.setSelectedIcon(new ImageIcon(rsdImgLogOut));        
	
	btnLogOut.setForeground(new Color(255, 255, 255));
    btnLogOut.setContentAreaFilled(false);
    btnLogOut.setOpaque(false);
    btnLogOut.setBorderPainted(false);
    btnLogOut.setBounds(6, 857, 188, 37);
    add(btnLogOut);
    
	}
}
