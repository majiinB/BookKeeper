package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
public class pnlReports extends JPanel {
	private JPanel pnlCirculationReports;
	private JPanel pnlUserReports;
	private JPanel pnlInventoryReports;
	private JLabel lblNewLabel;
	private JLabel lblBorrowed;
	private JLabel lblReturned;
	private JScrollPane scrlCirculation;
	private JScrollPane scrlUsers;
	private JScrollPane  scrlInventory;
	private JLabel lblCirculationReport;
	private JLabel lblUserReport;
	private JLabel lblInventoryReport;
	
	public pnlReports() {
		setLayout(null);
		
		JLabel lblReport = new JLabel("Library Report");
		lblReport.setForeground(new Color(26, 24, 87));
		lblReport.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblReport.setBounds(21, 17, 341, 58);
		add(lblReport);
		
		JTabbedPane tbdReports = new JTabbedPane(JTabbedPane.LEFT);
		tbdReports.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tbdReports.setBounds(21, 125, 890, 385); 
		add(tbdReports);
		
		//create panels for each report category
		pnlCirculationReports = new JPanel();
		pnlUserReports= new JPanel();
		pnlInventoryReports = new JPanel(); 
		
		//circulation Tab (borrowed, returned,overdue Books)
		tbdReports.add(pnlCirculationReports);
		pnlCirculationReports.setLayout(null);
		
		scrlCirculation = new JScrollPane();
		scrlCirculation.setBounds(6, 6, 685, 363);  
		pnlCirculationReports.add(scrlCirculation);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(0, "Circulation");
		

		lblCirculationReport = new JLabel("Circulation Report");
		lblCirculationReport.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		scrlCirculation.setColumnHeaderView(lblCirculationReport);
		    
		    
		    
		 			  
		//user Tab (number of users)
		tbdReports.add(pnlUserReports);	
		pnlUserReports.setLayout(null);
		scrlUsers = new JScrollPane();
		scrlUsers.setBounds(6, 6, 685, 363);
		pnlUserReports.add(scrlUsers);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(1, "Users");
		lblUserReport = new JLabel("User Report");
		lblUserReport.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		scrlUsers.setColumnHeaderView(lblUserReport);
		

		//Inventory Tab (copies per category, book condition)
		tbdReports.add(pnlInventoryReports);
		pnlInventoryReports.setLayout(null);
		scrlInventory = new JScrollPane();
		scrlInventory.setBounds(6, 6, 832, 352);
		pnlInventoryReports.add(scrlInventory);
		tbdReports.setEnabledAt(0, true);		
		tbdReports.setTitleAt(2, "Inventory");
		lblInventoryReport = new JLabel("Inventory Report");
		lblInventoryReport.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		scrlInventory.setColumnHeaderView(lblInventoryReport);
 		
		

	}
}





