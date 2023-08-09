package com.bookkeeper;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminBookBorrowPanel extends JPanel{
	//panel
	private JPanel mainPanel;
	private RoundedPanel borrowPanel;
	private RoundedPanel cancelPanel;


	//label
	private JTextArea txtDescription;
	private JLabel lblPatronID;
	
	//textfield
	private PlaceholderTextField txtPatronID; 
	
	//button
	private JButton btnBorrow;
	private JButton btnCancel;

	//layout
	private GridBagLayout gbl_mainPanel; 
	private GridBagConstraints gbc_txtDescription;
	private GridBagConstraints gbc_lblPatronID;	
	private GridBagConstraints gbc_txtPatronID;
	private GridBagConstraints gbc_borrowPanel;
	private GridBagConstraints gbc_cancelPanel;

	//text
	private  Font titleFont;
	private  Font subtitleFont;
	private  Font buttonFont;
	private  Font headerFont;
	private  Font plainFont;
		
	private  int buttonTextSize;
	private  int titleTextSize;
	private  int subtitleTextSize;
	private  int headerTextSize;
	private  int plainTextsize;
	private  Color headerColor = new Color(23, 21, 147);//blue
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color middleplainColor = new Color(243, 243, 247);//dirty white
	private int selectedValue;

	public AdminBookBorrowPanel(Book selectedBook, Setting setting) {
		setBackground(new Color(250, 251, 255));
	    setBorder(new EmptyBorder(10, 10, 10, 10));
	    setLayout(new BorderLayout(0, 0));
		
	    //create panels
		mainPanel = new JPanel();//panel to hold all panels
	    borrowPanel = new RoundedPanel(20);
	    cancelPanel = new RoundedPanel(20);

		// Set panel properties
	    mainPanel.setBorder(null);
	    mainPanel.setOpaque(false);
	    
	    borrowPanel.setOpaque(false);
	    cancelPanel.setOpaque(false);
	    
	    cancelPanel.setBorderWidth(2);
	    borrowPanel.setBorderWidth(2);

	    txtDescription = new JTextArea();
	    txtDescription.setForeground(headerColor);
		txtDescription.setLineWrap(true);
		txtDescription.setOpaque(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFocusable(false);
		txtDescription.setEditable(false);
		txtDescription.setDragEnabled(false);
		txtDescription.setAutoscrolls(false);
	    txtDescription.setText("Please enter the User ID to confirm borrowing transaction.");
	    
	    lblPatronID = new JLabel("Patron ID"); 
	    lblPatronID.setHorizontalAlignment(SwingConstants.LEFT);
	    lblPatronID.setBorder(null);
	    lblPatronID.setOpaque(false);
	    lblPatronID.setForeground(darkplainColor);
	
	    txtPatronID = new PlaceholderTextField("Patron ID");
	    txtPatronID.setBackground(middleplainColor);
	    txtPatronID.setBorder(new EmptyBorder(10, 10, 10, 10));
	    txtPatronID.setOpaque(true);
	    txtPatronID.setFocusable(true);
	    txtPatronID.setEditable(true);
	    txtPatronID.setDragEnabled(false);
	
	    btnBorrow = new JButton();
	    btnBorrow.setText("Borrow");
	    btnBorrow.setForeground(darkplainColor);
	    btnBorrow.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnBorrow.setOpaque(false);
	    btnBorrow.setFocusPainted(false);
	    btnBorrow.setBorderPainted(false);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setFocusPainted(false);
	    btnCancel.setForeground(darkplainColor);
	    btnCancel.setBorderPainted(false);
	    btnCancel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    btnCancel.setOpaque(false);

	    
	    /*
	     * gamit ka ng gridbag layout for more control sa placement ng components  sa panel
	     * ung gbc or grid bag constraints is para madetermine mo ung positioning ng mga components sa gridbag layout
	     * x = column
	     * y = row
	     * gridheight/gridwidth = no. of cells occupied
	     * anchor = alignment
	     * insets = padding
	     */
	    
	    //gridbag layouts
	    gbl_mainPanel = new GridBagLayout();
	    gbl_mainPanel.columnWidths = new int[]{0,0};
	    gbl_mainPanel.rowHeights = new int[]{0, 0};
	    gbl_mainPanel.columnWeights = new double[]{1.0,1.0};
	    gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};

	    gbc_txtDescription = new GridBagConstraints();
	    gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;	    
	    gbc_txtDescription.insets = new Insets(20, 20, 10, 20);
	    gbc_txtDescription.gridx = 0;
	    gbc_txtDescription.gridy = 0;
	    gbc_txtDescription.gridwidth = 2;

	    gbc_lblPatronID = new GridBagConstraints();
	    gbc_lblPatronID.fill = GridBagConstraints.BOTH;	    
	    gbc_lblPatronID.insets = new Insets(10, 20, 10, 20);
	    gbc_lblPatronID.gridx = 0;
	    gbc_lblPatronID.gridy = 1;
	    gbc_lblPatronID.gridwidth = 2;

	    gbc_txtPatronID = new GridBagConstraints();
	    gbc_txtPatronID.fill = GridBagConstraints.BOTH;	    
	    gbc_txtPatronID.insets = new Insets(5, 20, 10, 20);
	    gbc_txtPatronID.gridx = 0;
	    gbc_txtPatronID.gridy = 2;
	    gbc_txtPatronID.gridwidth = 2;
	    
	    gbc_borrowPanel = new GridBagConstraints();
	    gbc_borrowPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_borrowPanel.insets = new Insets(10, 20, 10, 20);
	    gbc_borrowPanel.gridx = 0;
	    gbc_borrowPanel.gridy = 3;    
	    
	    gbc_cancelPanel = new GridBagConstraints();
	    gbc_cancelPanel.fill = GridBagConstraints.BOTH;	    
	    gbc_cancelPanel.insets = new Insets(10, 20, 10, 20);
	    gbc_cancelPanel.gridx = 1;
	    gbc_cancelPanel.gridy = 3;
	    
	    // Set panel layout
	    mainPanel.setLayout(gbl_mainPanel);
	    borrowPanel.setLayout(new BorderLayout(0, 0));
	    cancelPanel.setLayout(new BorderLayout(0, 0));

	    //Add all to main panel
	    borrowPanel.add(btnBorrow, BorderLayout.CENTER);
	    cancelPanel.add(btnCancel, BorderLayout.CENTER);
	    mainPanel.add(txtDescription,gbc_txtDescription);
	    mainPanel.add(lblPatronID,gbc_lblPatronID);
	    mainPanel.add(txtPatronID,gbc_txtPatronID);
	    mainPanel.add(borrowPanel,gbc_borrowPanel);
	    mainPanel.add(cancelPanel,gbc_cancelPanel);

	    
	    
	    add(mainPanel);
	    
	    addComponentListener(new ComponentAdapter() {
	    	  @Override
	          public void componentResized(ComponentEvent e) {
	  	        	titleTextSize = Math.min(getHeight() / 7, getWidth()/ 10) ;
	  	            subtitleTextSize =  Math.min(getHeight() / 20, getWidth()/ 25);
	  	            buttonTextSize =  Math.min(getHeight() / 30, getWidth()/ 30);
	  	           	headerTextSize =   Math.min(getHeight() / 20, getWidth()/ 30);
	  	           	plainTextsize=   Math.min(getHeight() / 25, getWidth()/ 25);
	  	          
	  	          titleFont = new Font("Montserrat", Font.ITALIC|Font.BOLD, titleTextSize);
	  	            buttonFont = new Font("Montserrat", Font.BOLD, buttonTextSize);
	  	            headerFont = new Font("Montserrat", Font.PLAIN, headerTextSize);
	  	            plainFont = new Font("Montserrat", Font.BOLD | Font.BOLD, plainTextsize);

	  	           	txtDescription.setFont(titleFont);
	  	            btnBorrow.setFont(buttonFont);	  	            
	  	            btnCancel.setFont(buttonFont);
	  	            lblPatronID.setFont(plainFont);  	          
	  	          	          
	          }
	      });
	 // Action Listener
    btnBorrow.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String patronID = txtPatronID.getText();
			int bookID = selectedBook.getBook_id();
			User borrowerPatron = getFirstPatronForBookBorrow(patronID);
			
			//Check if the user ID entered exists
			if(checkUserExistence(patronID)) {
				//Check if the book is Available 
				if(borrowerPatron.getUser_num_borrowed() >= setting.getBorrow_lim()) {
					MalfunctionPanel mal = new MalfunctionPanel("User Reached Borrow Limit", "Apologies, but "+ borrowerPatron.getUser_fname()+" "+borrowerPatron.getUser_lname()+" have already reached the maximum limit for reserving books");
					showDialog(mal);
					return;
				}
				if(isBookAvailable(bookID)) {
					User withReservation = getFirstPatronForBookReservation(selectedBook.getBook_id());
					int flag = -1;
					
					//Shield to check if the one borrowing is not the same with the one who has a reservation with the book
					if(withReservation!=null) {
						if(!withReservation.getUser_id().equals(patronID)) {
							ConfirmationPanel mal = new ConfirmationPanel("Warning Book is Reserved", "Are you sure you want this book to be borrowed\nBook is currently reserved by:\n"
									+ "Patron ID: "+ withReservation.getUser_id() +"\nPatron Name: " + withReservation.getUser_fname() + " " + withReservation.getUser_lname());
							flag = showDialog(mal);
						}
						
					}
					// Action canceled when flag returns 2
					if(flag == 2) {
						MalfunctionPanel mal = new MalfunctionPanel("Action Canceled", "Action has been canceled");
						showDialog(mal);
						return;
					}else {
						//Execute query to borrow book
						insertBorrowedBook(bookID, patronID, setting);
						
						//Increment the object
						borrowerPatron.setUser_num_borrowed(borrowerPatron.getUser_num_borrowed() + 1);
						
						//Check if there is a reservation made by the borrower
						if(isReservationExisting(bookID, patronID)) {
							//Update reservation table if book was reserved by the borrower
							updateReservationStatus(bookID, patronID);
							
							//Check first if the reservation limit is still not zero to avoid a negative value in the database
							if(withReservation.getUser_num_reserved() != 0) updateNumOfReserved(patronID);
							
						}
						closeDialog(e);
					}
					
				}
				else {
					MalfunctionPanel mal = new MalfunctionPanel("Book Borrow Error", "Sorry but the book cannot be borrowed");
					showDialog(mal);
				}
			}else {
				MalfunctionPanel mal = new MalfunctionPanel("Book Borrow Error", "Sorry but the Patron ID you have entered may be invalid or does not exist");
				showDialog(mal);
			}
    	}
    });
	}
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    /*
		    * use super.paintComponent(g) for proper rendering 
		    * of components 
		*/
	 }
	public JButton getBtnBack() {
		return btnCancel;
	}
	public boolean checkUserExistence(String patronId) {
	    boolean userExists = false;

	    try {
	        // Establish database connection
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Prepare the SQL statement
	        String query = "SELECT COUNT(*) FROM patron WHERE BINARY formatted_id = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, patronId);

	        // Execute the query and check the result
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            userExists = (count > 0);
	        }

	        // Close the database connection
	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userExists;
	}
	public static User getFirstPatronForBookReservation(int bookId) {
        User user = null;

        // Database connection objects
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

            // SQL query to retrieve the first patron for the given bookId
            String sqlQuery = "SELECT p.formatted_id, p.patron_fname, p.patron_lname, p.patron_email, p.patron_contact, p.patron_address, p.patron_password, p.patron_status, p.penalty, p.num_of_reserved, p.num_of_borrowed " +
                    "FROM patron p " +
                    "JOIN reserved_book r ON p.formatted_id = r.patron_id " +
                    "WHERE r.book_id = ? AND r.reservation_status = 'in que' " +
                    "ORDER BY r.reservation_date, r.reservation_time ASC " +
                    "LIMIT 1";
            

            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, bookId);

            // Execute the query and get the result set
            resultSet = preparedStatement.executeQuery();

            // If there's a result, create a User object with the retrieved data
            if (resultSet.next()) {
            	String formattedId = resultSet.getString("formatted_id");
                String patronFirstName = resultSet.getString("patron_fname");
                String patronLastName = resultSet.getString("patron_lname");
                String email = resultSet.getString("patron_email");
                String contact = resultSet.getString("patron_contact");
                String address = resultSet.getString("patron_address");
                String patronPass = resultSet.getString("patron_password");
                String status = resultSet.getString("patron_status");
                int penalty = resultSet.getInt("penalty");
                int numOfReserve = resultSet.getInt("num_of_reserved");
                int numOfBorrowed = resultSet.getInt("num_of_borrowed");

                user = new User(formattedId, patronFirstName,patronLastName, email, contact, address, patronPass, status, penalty, numOfReserve, numOfBorrowed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
	public static User getFirstPatronForBookBorrow(String patronID) {
        User user = null;

        // Database connection objects
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

            // SQL query to retrieve the first patron for the given bookId
            String sqlQuery = "SELECT * FROM patron WHERE formatted_id = ?";

            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, patronID);

            // Execute the query and get the result set
            resultSet = preparedStatement.executeQuery();

            // If there's a result, create a User object with the retrieved data
            if (resultSet.next()) {
            	String formattedId = resultSet.getString("formatted_id");
                String patronFirstName = resultSet.getString("patron_fname");
                String patronLastName = resultSet.getString("patron_lname");
                String email = resultSet.getString("patron_email");
                String contact = resultSet.getString("patron_contact");
                String address = resultSet.getString("patron_address");
                String patronPass = resultSet.getString("patron_password");
                String status = resultSet.getString("patron_status");
                int penalty = resultSet.getInt("penalty");
                int numOfReserve = resultSet.getInt("num_of_reserved");
                int numOfBorrowed = resultSet.getInt("num_of_borrowed");

                user = new User(formattedId, patronFirstName,patronLastName, email, contact, address, patronPass, status, penalty, numOfReserve, numOfBorrowed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
	public static void updateNumOfReserved(String patronID) {
        String updateQuery = "UPDATE patron SET num_of_reserved = num_of_reserved - 1 WHERE formatted_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
             PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, patronID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Number of reservations updated successfully!");
            } else {
                System.out.println("No matching patron found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update the number of reservations.");
        }
    }
	public static void updateNumOfBorrowed(String patronID) {
        String updateQuery = "UPDATE patron SET num_of_borrowed = num_of_borrowed + 1 WHERE formatted_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
             PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, patronID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Number of reservations updated successfully!");
            } else {
                System.out.println("No matching patron found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update the number of reservations.");
        }
    }
	public boolean isReservationExisting(int bookId, String patronId) {
		boolean isExisting = false;
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "")) {
	        String query = "SELECT COUNT(*) AS count FROM reserved_book WHERE book_id = ? AND patron_id = ? AND reservation_status ='in que'";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, bookId);
	            stmt.setString(2, patronId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                int count = rs.getInt("count");
	                if (count > 0) {
	                    isExisting = true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isExisting;
	}
	
	//Method to insert the borrowed books info in the database
	public void insertBorrowedBook(int bookId, String patronId, Setting setting) {
	    try {
	        // Establish database connection
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Prepare the SQL statement for inserting the borrowed book
	        String insertQuery = "INSERT INTO borrowed_book (book_id, patron_id, borrowed_date, borrowed_due_date, borrow_status, borrow_time, penalizedOrNot) VALUES (?, ?, ?, ?, ?, CURRENT_TIME, ?)";
	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setInt(1, bookId); 
	        insertStatement.setString(2, patronId);
	        
	        // Get the current date
	        LocalDate currentDate = LocalDate.now();
	        insertStatement.setDate(3, java.sql.Date.valueOf(currentDate));

	        // Calculate the due date (current date + 3 weeks)
	        LocalDate dueDate = currentDate.plusDays(setting.getBorrow_duration_lim());
	        insertStatement.setDate(4, java.sql.Date.valueOf(dueDate));
	        
	        // Set status
	        insertStatement.setString(5, "Out");
	        insertStatement.setString(6, "No");

	        // Execute the insert query
	        insertStatement.executeUpdate();

	        // Prepare the SQL statement for updating the book status
	        String updateQuery = "UPDATE book SET book_status = 'Borrowed' WHERE book_id = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setInt(1, bookId);

	        // Execute the update query
	        updateStatement.executeUpdate();
	        
	        // Prompt success
	        SuccessPanel success = new SuccessPanel("Book Borrow Success", "Book has been successfuly borrowed\nBook must be returned on the given date: "+ dueDate);
	        showDialog(success);
	        updateNumOfBorrowed(patronId);
	        
	        // Close the database connection and statements
	        updateStatement.close();
	        insertStatement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//Book status checker method
	    public boolean isBookAvailable(int bookId) {
	        boolean isAvailable = false;
	        
	        try {
	            // Establish the database connection
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");
	            
	            // Create the SQL query
	            String query = "SELECT book_status FROM book WHERE book_id = ?";
	            
	            // Prepare the statement
	            PreparedStatement statement = conn.prepareStatement(query);
	            
	            // Set the parameter
	            statement.setInt(1, bookId);
	            
	            // Execute the query
	            ResultSet resultSet = statement.executeQuery();
	            
	            // Check if the book status is "Available"
	            if (resultSet.next()) {
	                String bookStatus = resultSet.getString("book_status");
	                if (bookStatus.equals("Available")) {
	                    isAvailable = true;
	                }
	            }
	            
	            // Close the resources
	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return isAvailable;
	    }
	    public void updateReservationStatus(int bookId, String patronId) {
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "")) {
	            // Check if the reservation exists
	            String selectQuery = "SELECT reservation_id FROM reserved_book WHERE book_id = ? AND patron_id = ?";
	            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
	                selectStmt.setInt(1, bookId);
	                selectStmt.setString(2, patronId);
	                ResultSet rs = selectStmt.executeQuery();

	                if (rs.next()) {
	                    int reservationId = rs.getInt("reservation_id");

	                    // Update the reservation status to 'done'
	                    String updateQuery = "UPDATE reserved_book SET reservation_status = 'done' WHERE reservation_id = ?";
	                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	                        updateStmt.setInt(1, reservationId);
	                        updateStmt.executeUpdate();
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 // OVERLOADED METHOD -> showDialog()
	 	//Method to show alert panel (Success Panel)
	 	public void showDialog(SuccessPanel panel) {
	 		
	 		panel.getBtnConfirm().addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	            closeDialog(e);
	 	    	}
	 	    });
	 	    
	 		JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Success", true);
	 		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 		dialog.getContentPane().add(panel);
	 		dialog.pack();
	 		dialog.setLocationRelativeTo(null);
	 		dialog.setVisible(true);

	 	}
	 	
	 	//Method to show alert panel (Malfunction Panel)
	     public void showDialog(MalfunctionPanel panel) {
	 		
	 		panel.getBtnConfirm().addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	            closeDialog(e);
	 	    	}
	 	    });
	 	    
	 		JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Error", true);
	         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	         dialog.getContentPane().add(panel);
	         dialog.pack();
	         dialog.setLocationRelativeTo(null);
	         dialog.setVisible(true);
	 	}
	     public int showDialog(ConfirmationPanel panel) {
	 		selectedValue = 0;
	 		
	 		panel.getBtnConfirm().addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	    		selectedValue = 1; // Set selectedValue to 1 when "OK" is clicked
	 	            closeDialog(e);
	 	    	}
	 	    });
	 	    panel.getBtnCancel().addActionListener(new ActionListener() {
	 	    	public void actionPerformed(ActionEvent e) {
	 	            selectedValue = 2; // Set selectedValue to2 when "Cancel" is clicked
	 	            closeDialog(e);
	 	    	}
	 	    });
	 	    
	 		JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Confirm Log Out", true);
	         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	         dialog.add(panel);
	         dialog.pack();
	         dialog.setLocationRelativeTo(null);
	         dialog.setVisible(true);
	 		
	 		return selectedValue;
	 	}
	     
	     //Method used by showDialog to close the JDialog containing the alert panels
	 	private void closeDialog(ActionEvent e) {
	         Component component = (Component) e.getSource();
	         Window window = SwingUtilities.getWindowAncestor(component);
	         if (window != null) {
	             window.dispose();
	         }
	     }
}