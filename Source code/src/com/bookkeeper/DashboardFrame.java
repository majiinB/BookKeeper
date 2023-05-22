package com.bookkeeper;
import javax.swing.*;
import java.awt.*;

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

    public DashboardFrame() {
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


        getContentPane().add(pnlMenuBar);
        
     	// Create Card Layout panels of the menu bar
        pnlMenuBarPatron = new pnlMenuBarPatron();
        pnlMenuBar.add(pnlMenuBarPatron, "panel1");
        pnlMenuBarAdmin = new pnlMenuBarAdmin();
        pnlMenuBar.add(pnlMenuBarAdmin, "panel2");
                
        pnlMenuBarPatron.setLayout(null);                
        pnlMenuBarAdmin.setLayout(null);
                
                
        pnlUser = new pnlUser();
        pnlHome = new pnlHome(); 
        pnlReports = new pnlReports();
        pnlLibraryAdmin = new pnlLibraryAdmin();
        pnlLibraryUser = new pnlLibraryUser();
        pnlAccount = new pnlAccount();


        // Create dashboard panel
        pnlDashboardDisplay = new JPanel();
        pnlDashboardDisplay.setBorder(null);
        pnlDashboardDisplay.setBounds(148, 0, 989, 578);
        pnlDashboardDisplay.setLayout(new CardLayout(0, 0));
        
        pnlDashboardDisplay.add(pnlLibraryAdmin, "panel3");
        pnlDashboardDisplay.add(pnlReports, "panel4");
        pnlDashboardDisplay.add(pnlUser, "panel5");
        
        
        pnlDashboardDisplay.add(pnlHome, "panel6");
        pnlDashboardDisplay.add(pnlLibraryUser, "oanel7");
        pnlDashboardDisplay.add(pnlAccount, "panel8");
        

        getContentPane().add(pnlDashboardDisplay);

        // Show the appropriate panel based on user type
        //showAdminPanel();
        //showPatronPanel();

        setVisible(true);
    }

    private void showAdminPanel() {
    	//paayos nlng

    	// Show the patron-specific panel
    	cardLayout.show(pnlMenuBar, "panel2");
        cardLayout.show(pnlDashboardDisplay, "panel3");
    }

    private void showPatronPanel() {
    	//paayos nlng
    	// Show the patron-specific panel
        cardLayout.show(pnlMenuBar, "panel1");
        cardLayout.show(pnlDashboardDisplay, "panel6");
    }
}