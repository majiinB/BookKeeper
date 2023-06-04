package com.bookkeeper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pnlMenuBarAdmin extends JPanel {
	private JPanel pnlMenuBar;
	private JPanel pnlHeading;
	private JPanel pnlLibrary;
	private JPanel pnlReport;
	private JPanel pnlEmployee;
	private JPanel pnlUser;
	private JPanel pnlLogOut;
	private JButton btnLibrary;
	private JButton btnReport;
	private JButton btnEmployee;
	private JButton btnUsers;
	private JButton btnLogOut ;
	private JLabel lblBookKeeperName ;
	private JLabel lblDashboard ;
	private ImageIcon icnLibrary;
	private ImageIcon icnReport;
	private ImageIcon icnEmployee;
	private ImageIcon icnUsers;
	private ImageIcon icnLogOut;
	private Image imgLibrary;
	private Image rsdImgLibrary;
	private Image imgReport;
	private Image rsdImgReport;
	private Image imgEmployee;
	private Image rsdImgEmployee;
	private Image imgUsers;
	private Image rsdImgUsers;
	private Image imgLogOut;
	private Image rsdImgLogOut;
	
	public  pnlMenuBarAdmin() {
		setBackground(new Color(26, 24, 87));
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(5, 5, 20, 2));

		
		pnlLibrary = new JPanel();
		pnlLibrary.setBorder(new EmptyBorder(15, 0, 0, 5));
		pnlLibrary.setOpaque(false);

		pnlReport = new JPanel();
		pnlReport.setBorder(new EmptyBorder(5, 0, 0, 5));
		pnlReport.setOpaque(false);
		
		pnlEmployee = new JPanel();

		pnlEmployee.setBorder(new EmptyBorder(5, 0, 0, 5));
		pnlEmployee.setOpaque(false);
		
		pnlUser = new JPanel();
		pnlUser.setBorder(new EmptyBorder(5, 0, 0, 5));
		pnlUser.setOpaque(false);
		
		pnlLogOut = new JPanel();
		pnlLogOut.setBorder(new EmptyBorder(150, 0, 0, 5));
		pnlLogOut.setOpaque(false);
		
		pnlMenuBar = new JPanel();
		pnlMenuBar.setBorder(null);
		pnlMenuBar.setOpaque(false);
		
		pnlHeading = new JPanel();
		pnlHeading.setBorder(null);
		pnlHeading.setOpaque(false);
				
		GridBagLayout gbl_pnlHeading = new GridBagLayout();
		gbl_pnlHeading.columnWidths = new int[]{186, 0};
		gbl_pnlHeading.rowHeights = new int[]{31, 16, 0, 0};
		gbl_pnlHeading.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlHeading.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};	    
					    
		lblBookKeeperName = new JLabel("Book Keeper");
		lblBookKeeperName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookKeeperName.setForeground(new Color(255, 255, 255));
		lblBookKeeperName.setFont(new Font("Verdana", Font.BOLD, 20));
					    
		GridBagConstraints gbc_lblBookKeeperName = new GridBagConstraints();
		gbc_lblBookKeeperName.gridheight = 2;
		gbc_lblBookKeeperName.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblBookKeeperName.insets = new Insets(0, 0, 5, 0);
		gbc_lblBookKeeperName.gridx = 0;
		gbc_lblBookKeeperName.gridy = 0;
					    	    
		lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDashboard.setHorizontalAlignment(SwingConstants.LEFT);
					    	    
		GridBagConstraints gbc_lblDashboard = new GridBagConstraints();
		gbc_lblDashboard.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDashboard.gridx = 0;
		gbc_lblDashboard.gridy = 2;

		
		//icon for butttons 
		icnLibrary = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/libraryIcon.png");//files are in desktop
		//icnLibrary = new ImageIcon("D:\\documents\\Final_Project\\img\\libraryIcon.png");//files are in desktop
		imgLibrary = icnLibrary.getImage();
		rsdImgLibrary = imgLibrary.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		
		icnReport = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/statisticsIcon.png");
		//icnReport = new ImageIcon("D:\\documents\\Final_Project\\img\\statisticsIcon.png");
		imgReport = icnReport.getImage();
		rsdImgReport = imgReport.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		
		icnEmployee = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/userManagementIcont.png");
		//icnUsers = new ImageIcon("D:\\documents\\Final_Project\\img\\userManagementIcont.png");
		imgEmployee = icnEmployee.getImage();
		rsdImgEmployee = imgEmployee.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		
		icnUsers = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/userManagementIcont.png");
		//icnUsers = new ImageIcon("D:\\documents\\Final_Project\\img\\userManagementIcont.png");
		imgUsers = icnUsers.getImage();
		rsdImgUsers = imgUsers.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		
		icnLogOut = new ImageIcon("/Users/PANPAN/eclipse-workspace/Book_Keeper/img/logOutIcon.png");
		//icnLogOut = new ImageIcon("D:\\documents\\Final_Project\\img\\logOutIcon.png");
		imgLogOut = icnLogOut.getImage();
		rsdImgLogOut = imgLogOut.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		

		//Library
		btnLibrary = new JButton("  Library");
		btnLibrary.setBorder(new EmptyBorder(15, 5, 5, 90));
		btnLibrary.setIcon(new ImageIcon(rsdImgLibrary));
		btnLibrary.setSelectedIcon(new ImageIcon(rsdImgLibrary));  
		btnLibrary.setForeground(new Color(255, 255, 255));
		btnLibrary.setContentAreaFilled(false);
		btnLibrary.setOpaque(false);
		btnLibrary.setBorderPainted(false);
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
	    
	    //Reports
	    btnReport = new JButton("   Reports");
	    btnReport.setBorder(new EmptyBorder(15, 5, 5, 40));
	    btnReport.setIcon(new ImageIcon(rsdImgReport));
	    btnReport.setSelectedIcon(new ImageIcon(rsdImgReport));        
	    btnReport.setForeground(new Color(255, 255, 255));
	    btnReport.setContentAreaFilled(false);
	    btnReport.setOpaque(false);
	    btnReport.setBorderPainted(false);

	    
		
		//Employee Management
		btnEmployee = new JButton(" Manage Employees");
		btnEmployee.setBorder(new EmptyBorder(15, 5, 5, 5));
		btnEmployee.setIcon(new ImageIcon(rsdImgEmployee));
		btnEmployee.setSelectedIcon(new ImageIcon(rsdImgEmployee));        
		btnEmployee.setForeground(new Color(255, 255, 255));
		btnEmployee.setContentAreaFilled(false);
		btnEmployee.setOpaque(false);
		btnEmployee.setBorderPainted(false);

	    
	    
	    //Patron management 
	    btnUsers = new JButton(" Manage Patron");
	    btnUsers.setBorder(new EmptyBorder(15, 5, 5, 35));
	    btnUsers.setIcon(new ImageIcon(rsdImgUsers));
	    btnUsers.setSelectedIcon(new ImageIcon(rsdImgUsers));        
	    btnUsers.setForeground(new Color(255, 255, 255));
	    btnUsers.setContentAreaFilled(false);
	    btnUsers.setOpaque(false);
	    btnUsers.setBorderPainted(false);
	    btnUsers.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });

	    
	    //Logout button
	    btnLogOut = new JButton(" Log out");
	    btnLogOut.setBorder(new EmptyBorder(15, 5, 5, 90));
	    btnLogOut.setIcon(new ImageIcon(rsdImgLogOut));
	    btnLogOut.setSelectedIcon(new ImageIcon(rsdImgLogOut));
	    btnLogOut.setForeground(new Color(255, 255, 255));
	    btnLogOut.setContentAreaFilled(false);
	    btnLogOut.setOpaque(false);
	    btnLogOut.setBorderPainted(false);
	    
	    pnlMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
	    pnlHeading.setLayout(gbl_pnlHeading);				    
	    pnlHeading.add(lblBookKeeperName, gbc_lblBookKeeperName);
	    pnlMenuBar.add(pnlHeading);
	    pnlHeading.add(lblDashboard, gbc_lblDashboard);
	    
		pnlLibrary.add(btnLibrary);
		pnlReport.add(btnReport);
		pnlEmployee.add(btnEmployee);
		pnlUser.add(btnUsers);
		pnlLogOut.add(btnLogOut);
	    pnlMenuBar.add(pnlLibrary);
	    pnlMenuBar.add(pnlReport);
	    pnlMenuBar.add(pnlEmployee);
	    pnlMenuBar.add(pnlUser);
	    pnlMenuBar.add(pnlLogOut);
	    add(pnlMenuBar);
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
	public JButton getEmployeeBtn() {
		return btnEmployee;
	}
}