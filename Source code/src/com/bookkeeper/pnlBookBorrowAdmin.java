package com.bookkeeper;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class pnlBookBorrowAdmin extends JPanel {
	private JPanel pnlButtons;
	private JPanel  pnlPatron;
	private JPanel pnlBorrowerInfo;
	private JPanel pnlHeader;
	private JPanel pnlPublisher;
	private JPanel pnlPublicationDate;
	private JPanel pnlAuthor;
	private JPanel pnlGenreAdmin;
	private JPanel pnlAvailability ;
	private JPanel pnlBorrowBook;
	private JButton btnSaveChangesEdit;
	private JButton btnCancelEdit;
	private JLabel lblEnterPatronID;
	private JLabel lblBorrow;
	private JLabel lblAuthor;
	private JLabel lblPublicationDate;
	private JLabel lblPublisher;
	private JLabel lblGenre;
	private JLabel lblAvailability;
	private PlaceholderTextField txtEnterPatronID;
	private PlaceholderTextField txtTitle;
	private PlaceholderTextField txtAuthor;
	private PlaceholderTextField txtBookPublisher;
	private PlaceholderTextField txtPublicationDate;
	private PlaceholderTextField txtGenre;
	private PlaceholderTextField txtAvail;
	
	public pnlBookBorrowAdmin(Book book) {
		setBorder(new EmptyBorder(20, 20, 20, 60));

		pnlBorrowerInfo = new JPanel();
		//pnlButtons = new JPanel();
		pnlButtons = new JPanel();
		pnlPatron = new JPanel();
		pnlHeader = new JPanel();
		pnlPublisher = new JPanel();
		pnlAuthor = new JPanel();
		pnlPublicationDate = new JPanel();
		pnlGenreAdmin = new JPanel();
		pnlAvailability = new JPanel();
		pnlBorrowBook = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		lblBorrow = new JLabel("Borrow Books");
		lblBorrow.setForeground(new Color(26, 24, 87));
		lblBorrow.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 40));
		lblBorrow.setBounds(0, 0, 116, 30);
		
		txtTitle = new PlaceholderTextField(book.getBook_title());
		txtTitle.setEditable(false);
		txtTitle.setOpaque(true);
		txtTitle.setColumns(10);
		
		lblEnterPatronID = new JLabel("Enter Patron ID:");
		lblEnterPatronID.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEnterPatronID.setBounds(0, 0, 116, 30);
		
		txtEnterPatronID = new PlaceholderTextField("Patron ID");
		txtEnterPatronID.setColumns(15);
		txtEnterPatronID.setBounds(128, 1, 400, 30);
		
		
		
		//book info		
		pnlAuthor.setBounds(0, 11, 528, 30);
		pnlAuthor.setLayout(null);
		
		lblAuthor = new JLabel("Book Author:");
		lblAuthor.setBounds(0, 0, 116, 30);
		lblAuthor.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		txtAuthor = new PlaceholderTextField(book.getBook_author());
		txtAuthor.setEditable(false);
		txtAuthor.setBounds(92, 1, 167, 30);
		txtAuthor.setOpaque(false);
		txtAuthor.setColumns(10);
		txtAuthor.setBorder(null);
		
		pnlPublisher.setLayout(null);
		
		lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublisher.setBounds(0, 0, 116, 30);
		
		txtBookPublisher = new PlaceholderTextField(book.getBook_publisher());
		txtBookPublisher.setEditable(false);
		txtBookPublisher.setOpaque(false);
		txtBookPublisher.setColumns(10);
		txtBookPublisher.setBorder(null);
		txtBookPublisher.setBounds(128, 1, 400, 30);
		
		pnlPublicationDate.setBounds(0, 93, 528, 30);
		pnlPublicationDate.setLayout(null);
		
		lblPublicationDate = new JLabel("Publication Date:");
		lblPublicationDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublicationDate.setBounds(0, 0, 117, 30);
		
		txtPublicationDate = new PlaceholderTextField(book.getBook_publication_date());
		txtPublicationDate.setOpaque(false);
		txtPublicationDate.setEditable(false);
		txtPublicationDate.setColumns(10);
		txtPublicationDate.setBorder(null);
		txtPublicationDate.setBounds(128, 0, 400, 30);

		
		pnlGenreAdmin.setLayout(null);
		pnlGenreAdmin.setBounds(0, 209, 528, 30);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblGenre.setBounds(0, 0, 117, 30);
		
		txtGenre = new PlaceholderTextField("");
		txtGenre.setText(book.getBook_genre());
		txtGenre.setOpaque(false);
		txtGenre.setEditable(false);
		txtGenre.setColumns(10);
		txtGenre.setBorder(null);
		txtGenre.setBounds(62, 2, 197, 38);
		
		pnlAvailability.setLayout(null);
		pnlAvailability.setBounds(0, 250, 528, 30);

		
		lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAvailability.setBounds(0, 0, 117, 30);

		
		txtAvail = new PlaceholderTextField("");
		txtAvail.setText(book.getBook_status());
		txtAvail.setOpaque(false);
		txtAvail.setEditable(false);
		txtAvail.setColumns(10);
		txtAvail.setBorder(null);
		txtAvail.setBounds(82, 2, 177, 38);
		
		btnSaveChangesEdit = new JButton("Save Changes");
		btnSaveChangesEdit.setOpaque(true);
		btnSaveChangesEdit.setBorderPainted(false);
		btnSaveChangesEdit.setForeground(Color.WHITE);
		btnSaveChangesEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnSaveChangesEdit.setBackground(new Color(23, 22, 77));
		
		btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.setOpaque(true);
		btnCancelEdit.setBorderPainted(false);
		btnCancelEdit.setForeground(Color.WHITE);
		btnCancelEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancelEdit.setBackground(new Color(23, 22, 77));

		
		pnlButtons.add(btnSaveChangesEdit);
		pnlButtons.add(btnCancelEdit);
		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlBorrowBook.setLayout(new GridLayout(5, 2, 0, 0));
		pnlHeader.setLayout(new GridLayout(2, 1, 0, 0));
		

		pnlPatron.add(lblEnterPatronID);
		pnlPatron.add(txtEnterPatronID);
		
		pnlBorrowerInfo.add(pnlPatron);
		pnlAuthor.add(lblAuthor);
		pnlAuthor.add(txtAuthor);
		pnlPublisher.add(lblPublisher);
		pnlPublisher.add(txtBookPublisher);
		pnlPublicationDate.add(lblPublicationDate);
		pnlGenreAdmin.add(lblGenre);
		pnlGenreAdmin.add(txtGenre);
		pnlAvailability.add(lblAvailability);
		pnlAvailability.add(txtAvail);
		
		pnlBorrowBook.add(pnlBorrowerInfo);
		pnlBorrowBook.add(pnlAuthor);
		pnlBorrowBook.add(pnlPublicationDate);
		
		PlaceholderTextField txtPublication = new PlaceholderTextField((String) null);
		txtPublication.setText(book.getBook_publication_date());
		txtPublication.setOpaque(false);
		txtPublication.setEditable(false);
		txtPublication.setColumns(10);
		txtPublication.setBorder(null);
		txtPublication.setBounds(114, 0, 145, 37);
		pnlPublicationDate.add(txtPublication);
		pnlBorrowBook.add(pnlGenreAdmin);
		pnlBorrowBook.add(pnlAvailability);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnlHeader.add(lblBorrow);
		pnlHeader.add(txtTitle);
		add(pnlHeader);
		add(pnlBorrowBook);
		add(pnlButtons);
		
		//Listeners
		btnSaveChangesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patronID = txtEnterPatronID.getText();
				int bookID = book.getBook_id();
				
				//Check if the user ID entered exists
				if(checkUserExistence(patronID)) {
					//Check if the book is Available 
					if(isBookAvailable(bookID)) {
						insertBorrowedBook(bookID, patronID);
						JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "Successfully borrowed", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "The book is still unavailable for borrow", "Fail", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(pnlBookBorrowAdmin.this, "Patron ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	//Methods
	public boolean checkUserExistence(String patronId) {
	    boolean userExists = false;

	    try {
	        // Establish database connection
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Prepare the SQL statement
	        String query = "SELECT COUNT(*) FROM patron WHERE BINARY patron_id = ?";
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
	
	//Method to insert the borrowed books info in the database
	public void insertBorrowedBook(int bookId, String patronId) {
	    try {
	        // Establish database connection
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

	        // Prepare the SQL statement for inserting the borrowed book
	        String insertQuery = "INSERT INTO borrowed_book (book_id, patron_id, borrowed_date, borrowed_due_date) VALUES (?, ?, ?, ?)";
	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setInt(1, bookId); 
	        insertStatement.setString(2, patronId);
	        
	        // Get the current date
	        LocalDate currentDate = LocalDate.now();
	        insertStatement.setDate(3, java.sql.Date.valueOf(currentDate));

	        // Calculate the due date (current date + 3 weeks)
	        LocalDate dueDate = currentDate.plusWeeks(3);
	        insertStatement.setDate(4, java.sql.Date.valueOf(dueDate));

	        // Execute the insert query
	        insertStatement.executeUpdate();

	        // Prepare the SQL statement for updating the book status
	        String updateQuery = "UPDATE book SET book_status = 'Checked out' WHERE book_id = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setInt(1, bookId);

	        // Execute the update query
	        updateStatement.executeUpdate();

	        // Close the database connection and statements
	        updateStatement.close();
	        insertStatement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//Method to get the cancel button
	public JButton getCancelBorrow() {
		return btnCancelEdit;
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
	
}
