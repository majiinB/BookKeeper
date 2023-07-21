package com.bookkeeper;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

//Frame for displaying the dashboard with menu bar and content panels
public class DashboardFrame extends JFrame {
	//panel
	private JPanel mainPanel;
	private JPanel menuBarPanel;
	private JPanel ContentPanel;
	private AdminMenuPanel AdminMenuPanel;
	private AdminLibraryPanel AdminLibraryPanel;
	private AdminReportPanel AdminReportPanel;
	private AdminManagePatronPanel AdminManagePatronPanel;
	private AdminManageEmployeePanel AdminManageEmployeePanel;
	private AdminSettingsPanel AdminSettingsPanel;
	private PatronMenuPanel PatronMenuPanel;
	private PatronLibraryPanel PatronLibraryPanel;
	private PatronSettingsPanel PatronSettingsPanel;
	
	//layout
	private CardLayout cardLayout1;
	private CardLayout cardLayout2;
	
	//icon
	private ImageIcon icon;
	private Image image;
	
	//Graphics environment and screen dimensions
	private GraphicsEnvironment environment;	
	private GraphicsDevice device;
//	private int width;
//	private int height;
	
	//admin
	public DashboardFrame(Employee employee) {
		setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(false); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
//    	width = (int)(device.getDisplayMode().getWidth() * (3.5/5.0));    	
//    	height = (int)(device.getDisplayMode().getHeight() * 0.9);    
//    	setSize(width, height);
    	device.setFullScreenWindow(this);

	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
		menuBarPanel = new JPanel();// panel to hold menu bar
		ContentPanel = new JPanel();// panel to hold dashboard contents
		//menu bar panels
		AdminMenuPanel = new AdminMenuPanel();//menu bar for admin and employees

		//dashboard panels
		AdminLibraryPanel = new AdminLibraryPanel();//panel for  book-related operations 
		AdminReportPanel  = new AdminReportPanel();//panel for showcasing reports regarding the library
		AdminManagePatronPanel  = new AdminManagePatronPanel();//panel for managing patrons
		AdminManageEmployeePanel  = new AdminManageEmployeePanel();//panel for managing employees
		AdminSettingsPanel  = new AdminSettingsPanel();//panel for the settings of admin and employees

		
		// Set the layout of panels
		cardLayout1 = new CardLayout(0, 0);
		cardLayout2 = new CardLayout(0, 0);
		ContentPanel.setLayout(cardLayout1);
		menuBarPanel.setLayout(cardLayout2);
		mainPanel.setLayout(new BorderLayout(0, 0)); 

		// Add Panels to Menu Bar panel
		menuBarPanel.add(AdminMenuPanel, "panel1");
		
		// Add Panels to Dashboard panel
		ContentPanel.add(AdminLibraryPanel, "panel1");
		ContentPanel.add(AdminReportPanel, "panel2");
		ContentPanel.add(AdminManagePatronPanel, "panel3");		    	
		ContentPanel.add(AdminManageEmployeePanel, "panel4");
		ContentPanel.add(AdminSettingsPanel, "panel5");
		
		cardLayout1.show(ContentPanel, "panel1");
    	cardLayout2.show(menuBarPanel, "panel1");

		// Add Panels to Main panel
		mainPanel.add(menuBarPanel,BorderLayout.WEST);
		mainPanel.add(ContentPanel,BorderLayout.CENTER);
		
    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);
		
    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setVisible(true);
    }
	
	//patron
	public DashboardFrame(User patron) {
		setTitle("Book Keeper");
    	
    	//Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(false); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	//width = (int)(device.getDisplayMode().getWidth() * (3.5/5.0));    	
    	//height = (int)(device.getDisplayMode().getHeight() * 0.9);    
    	//setSize(width, height);
    	device.setFullScreenWindow(this);

	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
		menuBarPanel = new JPanel();// panel to hold menu bar
		ContentPanel = new JPanel();// panel to hold dashboard contents
		//menu bar panels
		PatronMenuPanel = new PatronMenuPanel();//menu bar for patron
		//dashboard panels
		PatronLibraryPanel = new PatronLibraryPanel();//panel for  book-related operations 
		PatronSettingsPanel  = new PatronSettingsPanel();//panel for the settings of patron
		
		// Set the layout of panels
		cardLayout1 = new CardLayout(0, 0);
		cardLayout2 = new CardLayout(0, 0);
		ContentPanel.setLayout(cardLayout1);
		menuBarPanel.setLayout(cardLayout2);
		mainPanel.setLayout(new BorderLayout(0, 0)); 

		// Add Panels to Menu Bar panel
		menuBarPanel.add(PatronMenuPanel, "panel2");
		
		// Add Panels to Dashboard panel
		ContentPanel.add(PatronLibraryPanel, "panel6");
		ContentPanel.add(PatronSettingsPanel, "panel7");
		
		    	
    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);

    	cardLayout1.show(ContentPanel, "panel6");
    	cardLayout2.show(menuBarPanel, "panel2");


		// Add Panels to Main panel
		mainPanel.add(menuBarPanel,BorderLayout.WEST);
		mainPanel.add(ContentPanel,BorderLayout.CENTER);
		
    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setVisible(true);
    }	
}

