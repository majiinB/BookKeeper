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
            cardLayout.show(pnlDashboardDisplay, "panel6");

            getContentPane().add(pnlMenuBar);
            getContentPane().add(pnlDashboardDisplay);
        }

        
    }
}
