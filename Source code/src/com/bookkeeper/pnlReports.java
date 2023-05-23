package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
public class pnlReports extends JPanel {
	private JPanel pnlCirculationReports;
	private JPanel pnlUserReports;
	private JPanel pnlInventoryReports;
	private JLabel lblNewLabel;
	private JLabel lblBorrowed;
	private JLabel lblReturned;
	private JScrollPane  scrlInventory;
	private JLabel lblInventoryReport;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	
	
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 652, 358);
		pnlCirculationReports.add(scrollPane);
		table = new JTable(new DefaultTableModel(
			new String[][] {
				{"    Total number of books borrowed:", null},
				{"    Total number of books returned:", null},
				{"    Total number of book copies:", null},
				{"    Number of users:", null},
			},
			new String[] {
				"Monthly Report", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(0, "Circulation");
		    
		 			  
		//user Tab (number of users)
		tbdReports.add(pnlUserReports);	
		pnlUserReports.setLayout(null);
		 
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 550, 389);
		pnlUserReports.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(1, "Users");
		 

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








