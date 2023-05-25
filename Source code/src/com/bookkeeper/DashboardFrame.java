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
    private pnlHome pnlHome;
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
        pnlMenuBarPatron = new pnlMenuBarPatron();
        pnlMenuBarAdmin = new pnlMenuBarAdmin();

        pnlMenuBarPatron.setLayout(null);
        pnlMenuBarAdmin.setLayout(null);

        pnlMenuBar.add(pnlMenuBarPatron, "panel1");
        pnlMenuBar.add(pnlMenuBarAdmin, "panel2");

        pnlUser = new pnlUser();
        pnlHome = new pnlHome();
        pnlReports = new pnlReports();
        pnlLibraryAdmin = new pnlLibraryAdmin();
        pnlLibraryUser = new pnlLibraryUser();
      
        // Create dash board panel
        pnlDashboardDisplay = new JPanel(); 
        pnlDashboardDisplay.setBorder(null);
        pnlDashboardDisplay.setBounds(148, 0, 989, 578);
        pnlDashboardDisplay.setLayout(new CardLayout(0, 0));

        pnlDashboardDisplay.add(pnlLibraryAdmin, "panel3");
        pnlDashboardDisplay.add(pnlReports, "panel4");
        pnlDashboardDisplay.add(pnlUser, "panel5");
        pnlDashboardDisplay.add(pnlLibraryUser, "panel7");
        

        // Show the appropriate panel based on user type
        if (toKnowPanel == 1) {
        	cardLayout = (CardLayout) pnlMenuBar.getLayout();
            cardLayout.show(pnlMenuBar, "panel2");

            cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
            cardLayout.show(pnlDashboardDisplay, "panel3");

            getContentPane().add(pnlMenuBar);
            getContentPane().add(pnlDashboardDisplay);
        } else {
        	cardLayout = (CardLayout) pnlMenuBar.getLayout();
            cardLayout.show(pnlMenuBar, "panel1");
 
            cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
            cardLayout.show(pnlDashboardDisplay, "panel7");

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
        pnlMenuBarAdmin = new pnlMenuBarAdmin();

        pnlMenuBarPatron.setLayout(null);
        pnlMenuBarAdmin.setLayout(null);

        pnlMenuBar.add(pnlMenuBarPatron, "panel1");
        pnlMenuBar.add(pnlMenuBarAdmin, "panel2");

        pnlUser = new pnlUser();
        pnlHome = new pnlHome();
        pnlReports = new pnlReports();
        pnlLibraryAdmin = new pnlLibraryAdmin();
        pnlLibraryUser = new pnlLibraryUser();
        pnlAccount = new pnlAccount(user);

        // Create dash board panel
        pnlDashboardDisplay = new JPanel(); 
        pnlDashboardDisplay.setBorder(null);
        pnlDashboardDisplay.setBounds(148, 0, 989, 578);
        pnlDashboardDisplay.setLayout(new CardLayout(0, 0));

        pnlDashboardDisplay.add(pnlLibraryAdmin, "panel3");
        pnlDashboardDisplay.add(pnlReports, "panel4");
        pnlDashboardDisplay.add(pnlUser, "panel5");
        pnlDashboardDisplay.add(pnlLibraryUser, "panel7");
        pnlDashboardDisplay.add(pnlAccount, "panel8");

        // Show the appropriate panel based on user type
        if (toKnowPanel == 1) {
        	cardLayout = (CardLayout) pnlMenuBar.getLayout();
            cardLayout.show(pnlMenuBar, "panel2");

            cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
            cardLayout.show(pnlDashboardDisplay, "panel3");

            getContentPane().add(pnlMenuBar);
            getContentPane().add(pnlDashboardDisplay);
        } else {
        	cardLayout = (CardLayout) pnlMenuBar.getLayout();
            cardLayout.show(pnlMenuBar, "panel1");
 
            cardLayout = (CardLayout) pnlDashboardDisplay.getLayout();
            cardLayout.show(pnlDashboardDisplay, "panel7");

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
