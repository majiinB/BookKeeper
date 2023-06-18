package com.bookkeeper;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;


public class DashboardFrame extends JFrame {
	
	JPanel mainPanel;
	JPanel menuBarPanel;
	JPanel DashboardPanel;
	//AdminMenuPanel AdminMenuPanel;
	//PatronMenuPanel PatronMenuPanel;
	//AdminLibraryPanel AdminLibraryPanel;
	//PatronLibraryPanel PatronLibraryPanel;
	//LibraryReportPanel LibraryReportPanel;
	//ManagePatronPanel ManagePatronPanel;
	//ManageEmployeePanel ManageEmployeePanel;
	//ManageAccountPanel ManageAccountPanel;
	public DashboardFrame() {
		setTitle("Book Keeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(1500, 1000);
		//setResizable(false); 
		setUndecorated(true);//to remove the frame	
		setLocationRelativeTo(null);//to put frame at the center 
	    setVisible(true);

	    //create pane;s
		mainPanel = new JPanel();//panel to hold all panels
		menuBarPanel = new JPanel();// panel to hold menu bar
		DashboardPanel = new JPanel();// panel to hold dasboard content
	     
		//menu bar
		//AdminMenuPanel = new AdminMenuPanel();//menu bar for admin and staffs
		//PatronMenuPanel = new PatronMenuPanel();//menu bar for patron

		
		//dashboard contents
	    //AdminLibraryPanel = new AdminLibraryPanel();
	    //PatronLibraryPanel = new PatronLibraryPanel();
		//LibraryReportPanel  = new LibraryReportPanel();
		//ManagePatronPanel  = new ManagePatronPanel();
		//ManageEmployeePanel  = new ManageEmployeePanel();
		//ManageAccountPanel  = new ManageAccountPanel();
		
		add(mainPanel);
	}
}


