package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
public class pnlReports extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlCirculationReports;
	private JPanel pnlUserReports;
	private JPanel pnlInventoryReports;
	private JLabel lblNewLabel;
	private JLabel lblBorrowed;
	private JLabel lblReturned;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblReporT;
	private DefaultTableModel tableModel_1;
	private JTable table_1;
	private JTable table_2;
	
	
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
		
	
		
		//circulation Tab (borrowed, returned,overdue Books)
		pnlCirculationReports = new JPanel();
		tbdReports.add(pnlCirculationReports);
		pnlCirculationReports.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 725, 512);
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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			 @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // Make all cells uneditable
	            }
	        
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(0, "General Report");
		    
		 			  
		//user Tab (number of users)
		pnlUserReports= new JPanel();
		tbdReports.add(pnlUserReports);	
		pnlUserReports.setLayout(null);
		
		// Create the table model
		DefaultTableModel tableModel_1 = new DefaultTableModel() {
			 @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // Make all cells uneditable
	            }
	     };
		
		pnlUserReports.setLayout(null);
		
		// Add your table to the panel
		JTable table = new JTable(tableModel_1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(350, 523);
		scrollPane.setLocation(10, 11);
		pnlUserReports.add(scrollPane);
		tbdReports.setEnabledAt(0, true);
		tbdReports.setTitleAt(1, "Circulation");
		
		

		// Set the column names in the table model
		tableModel_1.addColumn("Book ID");
		tableModel_1.addColumn("Book Name");
		tableModel_1.addColumn("Borrowed Due Date");
		tableModel_1.addColumn("Borrow Status");

		try {
		    // Establish database connection
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		    String getQuery = "SELECT b.book_id, b.book_title, bb.borrowed_due_date, bb.borrow_status " +
		            "FROM borrowed_book AS bb " +
		            "JOIN book AS b ON bb.book_id = b.book_id " +
		            "ORDER BY bb.borrowed_date DESC";

		    // Execute the SQL query
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(getQuery);

		    // Retrieve data and populate the table model
		    while (resultSet.next()) {
		        Object[] rowData = new Object[5];
		        rowData[0] = resultSet.getInt("book_id");
		        rowData[1] = resultSet.getString("book_title");
		        rowData[2] = resultSet.getDate("borrowed_due_date");
		        rowData[3] = resultSet.getString("borrow_status");
		        tableModel_1.addRow(rowData);
		    }

		    // Close the database connection
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		//Isa pang table 
		// Create the table model
		DefaultTableModel tableModelUsers = new DefaultTableModel() {
			 @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // Make all cells uneditable
	            }
	        };

		pnlUserReports.setLayout(null);

		// Add the table to the panel
		JTable tableUsers = new JTable(tableModelUsers);
		JScrollPane scrollPaneUsers = new JScrollPane(tableUsers);
		scrollPaneUsers.setSize(350, 523);
		scrollPaneUsers.setLocation(385, 11);
		pnlUserReports.add(scrollPaneUsers);

		// Set the tab title
		tbdReports.setTitleAt(1, "Users");

		// Set the column names in the table model
		tableModelUsers.addColumn("Book ID");
		tableModelUsers.addColumn("Book Name");
		tableModelUsers.addColumn("Reservation Status");
		tableModelUsers.addColumn("Patron ID");
		tableModelUsers.addColumn("Patron Name");
		tableModelUsers.addColumn("Patron Email");

		try {
		    // Establish database connection
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		    String getQuery = "SELECT b.book_id, b.book_title, rb.reservation_status, rb.patron_id, p.patron_email, p.patron_fname\r\n"
		    		+ "FROM reserved_book AS rb\r\n"
		    		+ "JOIN book AS b ON b.book_id = rb.book_id\r\n"
		    		+ "JOIN patron AS p ON p.patron_id = rb.patron_id\r\n"
		    		+ "ORDER BY rb.reservation_date DESC;\r\n"
		    		+ "";

		    // Execute the SQL query
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(getQuery);

		    // Retrieve data and populate the table model
		    while (resultSet.next()) {
		        Object[] rowData = new Object[6];
		        rowData[0] = resultSet.getInt("book_id");
		        rowData[1] = resultSet.getString("book_title");
		        rowData[2] = resultSet.getString("reservation_status");
		        rowData[3] = resultSet.getString("patron_id");
		        rowData[4] = resultSet.getString("patron_fname");
		        rowData[5] = resultSet.getString("patron_email");
		        tableModelUsers.addRow(rowData);
		    }

		    // Close the database connection
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}


		//Inventory Tab (copies per category, book condition)
		pnlInventoryReports = new JPanel(); 
		tbdReports.add(pnlInventoryReports);
		pnlInventoryReports.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 350, 501);
		pnlInventoryReports.add(scrollPane_1);
		
		//Call method to count each genre
		String horror = Integer.toString(countGenreInTable("Horror"));
		String comedy = Integer.toString(countGenreInTable("comedy"));
		String slice = Integer.toString(countGenreInTable("Slice of Life"));
		String adventure = Integer.toString(countGenreInTable("Adventure"));
		String romance = Integer.toString(countGenreInTable("Romance"));
		String drama = Integer.toString(countGenreInTable("Drama"));
		String scifi = Integer.toString(countGenreInTable("Science Fiction"));
		String trueStory = Integer.toString(countGenreInTable("True Story"));
		String mystery = Integer.toString(countGenreInTable("Mystery"));
		String childrens = Integer.toString(countGenreInTable("Childrens"));
		String dystopian = Integer.toString(countGenreInTable("Dystopian"));
		String fantasy = Integer.toString(countGenreInTable("Fantasy"));
		String fiction = Integer.toString(countGenreInTable("Fiction"));
		String classic = Integer.toString(countGenreInTable("Classic"));
		String poetry = Integer.toString(countGenreInTable("Poetry"));
		String survival = Integer.toString(countGenreInTable("Survival"));
		String thriller = Integer.toString(countGenreInTable("Thriller"));
		String history = Integer.toString(countGenreInTable("History"));
		String historical = Integer.toString(countGenreInTable("Historical Fiction"));
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Horror", horror},
				{"Comedy", comedy},
				{"Slice of Life", slice},
				{"Adventure", adventure},
				{"Romance", romance},
				{"Drama", drama},
				{"Scifi", scifi},
				{"True Story", trueStory },
				{"Mystery", mystery},
				{"Childrens", childrens},
				{"Dystopian", dystopian},
				{"Fantasy", fantasy},
				{"Fiction", fiction},
				{"Classic", classic},
				{"Poetry", poetry},
				{"Survival", survival},
				{"Thriller", thriller},
				{"History", history},
				{"Histrorical Fiction", historical},
			},
			new String[] {
				"Categories", "Number of Books"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(87);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.setRowHeight(30);
		scrollPane_1.setViewportView(table_2);
		tbdReports.setEnabledAt(0, true);		
		tbdReports.setTitleAt(2, "Book Inventory");
 		
		
		//ISA PA YAWA

		String[] columnNames = {"Book Title", "Author", "Genre", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable bookTable = new JTable(model);
        JScrollPane scrollPane1 = new JScrollPane(bookTable);
        pnlInventoryReports.add(scrollPane1, BorderLayout.CENTER);

        scrollPane1.setBounds(370, 11, 350, 501);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT book_title, author_name, genre_name, book_status FROM book WHERE book_status = 'unavailable'")) {

            while (resultSet.next()) {
                String bookTitle = resultSet.getString("book_title");
                String authorName = resultSet.getString("author_name");
                String genreName = resultSet.getString("genre_name");
                String bookStatus = resultSet.getString("book_status");

                Object[] rowData = {bookTitle, authorName, genreName, bookStatus};
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    
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
		    public static int countGenreInTable(String genre) {
		        // SQL query
		        String query = "SELECT COUNT(*) AS genre_count " +
		                "FROM book" +
		                " WHERE genre_name LIKE ?";

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
		             PreparedStatement statement = connection.prepareStatement(query)) {

		            statement.setString(1, genre); // Set the genre as a parameter in the query
		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                return resultSet.getInt("genre_count");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return 0; // Return 0 if an error occurs or no result is found
		    }

}









