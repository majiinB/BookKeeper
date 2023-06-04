package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
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
	private JLabel lblReporT;
	
	
	public pnlReports() {
		int returnedBooks = getCountOfReturnedRecordsForCurrentMonth();
		int countOfBorrowed = getCountOfRecordsForCurrentMonth();
		int getBookCount = getCountOfBooks();
		int getUserCount = getCountOfUser();
		
		String returnedBooksString = Integer.toString(returnedBooks);
		String countOfBorrowedString = Integer.toString(countOfBorrowed);
		String getBookCountString = Integer.toString(getBookCount);
		String getUserCountString = Integer.toString(getUserCount);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReport = new JLabel("Library Report");
		lblReport.setForeground(new Color(26, 24, 87));
		lblReport.setFont(new Font("Lucida Grande", Font.BOLD, 54));
		add(lblReport);
		
		JTabbedPane tbdReports = new JTabbedPane(JTabbedPane.LEFT);
		tbdReports.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
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
				{"    Total number of books borrowed:", countOfBorrowedString},
				{"    Total number of books returned:", returnedBooksString},
				{"    Total number of books:", getBookCountString},
				{"    Number of users:", getUserCountString},
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
	// Methods
	// Method to count returned books for the month
	public static int getCountOfReturnedRecordsForCurrentMonth() {
        Connection conn = null;
        int count = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            
            // Get the current month and year
            YearMonth currentMonth = YearMonth.now();
            int year = currentMonth.getYear();
            int month = currentMonth.getMonthValue();

            // Prepare the SQL query
            String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(returned_date) = ? AND YEAR(returned_date) = ? AND borrow_status = 'returned'";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, month);
            stmt.setInt(2, year);

            // Execute the query and get the count
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

            // Close the resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return count;
    }
	// Method to count borrowed books for the month
	public static int getCountOfRecordsForCurrentMonth() {
        Connection conn = null;
        int count = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            
            // Get the current month and year
            YearMonth currentMonth = YearMonth.now();
            int year = currentMonth.getYear();
            int month = currentMonth.getMonthValue();

            // Prepare the SQL query
            String query = "SELECT COUNT(*) FROM borrowed_book WHERE MONTH(borrowed_date) = ? AND YEAR(borrowed_date) = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, month);
            stmt.setInt(2, year);

            // Execute the query and get the count
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

            // Close the resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return count;
    }
	// Method that counts the number of books
	public static int getCountOfBooks() {
        Connection conn = null;
        int count = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
            
            // Prepare the SQL query
            String query = "SELECT COUNT(*) FROM book";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Execute the query and get the count
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

            // Close the resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return count;
    }
	// Method that counts the number of books
		public static int getCountOfUser() {
	        Connection conn = null;
	        int count = 0;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Prepare the SQL query
	            String query = "SELECT COUNT(*) FROM patron";
	            PreparedStatement stmt = conn.prepareStatement(query);

	            // Execute the query and get the count
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return count;
	    }
}









