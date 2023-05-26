package com.bookkeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFrame extends JFrame {
    private JPanel pnlMenuBar;
    private pnlMenuBarAdmin pnlMenuBarAdmin;
    private pnlMenuBarPatron pnlMenuBarPatron;
    private pnlLibraryAdmin pnlLibraryAdmin;
    private pnlReports pnlReports;
    private pnlUser pnlUser;
    private pnlLibraryUser pnlLibraryUser;
    private pnlAccount pnlAccount;
    private CardLayout cardLayout;
    private JPanel pnlDashboardDisplay;
 
    public DashboardFrame(int toKnowPanel) { 
        setResizable(false);
        setTitle("Book Keeper");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        cardLayout = new CardLayout(); // Create a CardLayout

        // Create menu bar panel
        pnlMenuBar = new JPanel();
        pnlMenuBar.setBounds(0, 0, 149, 578);
        pnlMenuBar.setLayout(new CardLayout(0, 0));

        // Create Card Layout panels of the menu bar
        pnlMenuBarAdmin = new pnlMenuBarAdmin();
        pnlMenuBarAdmin.setLayout(null);
        
        //Add Menu bar panel
        pnlMenuBar.add(pnlMenuBarAdmin, "panel2");
        
        //Initialize panels
        pnlReports = new pnlReports();
        pnlLibraryAdmin = new pnlLibraryAdmin();
        pnlUser = new pnlUser();
        // Create dash board panel
        pnlDashboardDisplay = new JPanel(); 
        pnlDashboardDisplay.setBorder(null);
        pnlDashboardDisplay.setBounds(148, 0, 989, 578);
        pnlDashboardDisplay.setLayout(new CardLayout(0, 0));
        
        //Add panels that will show on menu bar action listener
        pnlDashboardDisplay.add(pnlLibraryAdmin, "panel3");
        pnlDashboardDisplay.add(pnlReports, "panel4");
        pnlDashboardDisplay.add(pnlUser, "panel5");

        // Show the appropriate panel based on user type
        if (toKnowPanel == 1) {
        	cardLayout = (CardLayout) pnlMenuBar.getLayout();
            cardLayout.show(pnlMenuBar, "panel2");

            cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
            cardLayout.show(pnlDashboardDisplay, "panel3");

            getContentPane().add(pnlMenuBar);
            getContentPane().add(pnlDashboardDisplay);
        } 

        //Event listeners
        //Menu bar admin buttons
        pnlMenuBarAdmin.getLibraryBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            cardLayout.show(pnlDashboardDisplay, "panel3");
			}
		});
        pnlMenuBarAdmin.getReportBtn().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cardLayout.show(pnlDashboardDisplay, "panel4");
	    	}
	    });
        pnlMenuBarAdmin.getUserBtn().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cardLayout.show(pnlDashboardDisplay, "panel5");
	    	}
	    });
        pnlMenuBarAdmin.getLogOutBtn().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		DashboardFrame frame = (DashboardFrame) SwingUtilities.getWindowAncestor(pnlMenuBarAdmin);
	    		frame.dispose();
	    	
	    		MainFrame mainFrame = new MainFrame();
	    		mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);
	    	}
	    });
    }
    
    //Constructor with User class arguments
    public DashboardFrame(int toKnowPanel, User user) {
    	setResizable(false);
        setTitle("Book Keeper");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        cardLayout = new CardLayout(); // Create a CardLayout

        // Create menu bar panel
        pnlMenuBar = new JPanel();
        pnlMenuBar.setBounds(0, 0, 149, 578);
        pnlMenuBar.setLayout(new CardLayout(0, 0));

        // Create Card Layout panels of the menu bar
        pnlMenuBarPatron = new pnlMenuBarPatron();
        pnlMenuBarPatron.setLayout(null);

        pnlMenuBar.add(pnlMenuBarPatron, "panel1");
        pnlLibraryUser = new pnlLibraryUser();
        pnlAccount = new pnlAccount(user);

        // Create dash board panel
        pnlDashboardDisplay = new JPanel(); 
        pnlDashboardDisplay.setBorder(null);
        pnlDashboardDisplay.setBounds(148, 0, 989, 578);
        pnlDashboardDisplay.setLayout(new CardLayout(0, 0));
        
        //Add panels that will be shown in menu bar listener
        pnlDashboardDisplay.add(pnlLibraryUser, "panel7");
        pnlDashboardDisplay.add(pnlAccount, "panel8");

        // Show the appropriate panel based on user type
        cardLayout = (CardLayout) pnlMenuBar.getLayout();
        cardLayout.show(pnlMenuBar, "panel1");
        cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
        cardLayout.show(pnlDashboardDisplay, "panel7");
        getContentPane().add(pnlMenuBar);
        getContentPane().add(pnlDashboardDisplay);
        
        //Event listeners
        //Menu bar for patron
        pnlMenuBarPatron.getLibraryBtn().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(pnlDashboardDisplay, "panel7");
        	}
        });
        pnlMenuBarPatron.getUsersBtn().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(pnlDashboardDisplay, "panel8");
        	}
        });
        pnlMenuBarPatron.getLogOut().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DashboardFrame frame_1 = (DashboardFrame) SwingUtilities.getWindowAncestor(pnlMenuBarPatron);
	    		frame_1.dispose();
	    	
	    		MainFrame mainFrame = new MainFrame();
	    		mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);
        	}
        });
    }
}
