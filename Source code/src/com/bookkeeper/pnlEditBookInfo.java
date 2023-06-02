package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class pnlEditBookInfo extends JPanel {

	private JTextField txtAuthorEdit;
	private JTextField txtPublisherEdit;
	private JTextField txtPublicationDateEdit;
	private JTextField txtGenreEdit;
	private JTextField txtShelfNumberEdit;
	private JTextField txtAisleNumberEdit;
	private JTextField txtTitleEdit;
	private JTextField txtAvailability;
	private static pnlBookAddAdmin forCheck;
	JButton btnCancelEdit;
	
	public pnlEditBookInfo(Book book) {
		
		//create this to use its methods
		forCheck = new pnlBookAddAdmin();
		setLayout(null);
		
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(31, 42, 138, 124);
		add(lblLogo);
		ImageIcon icnLogo = new ImageIcon("D:\\documents\\Final_Project\\img\\bookKeeperLogo.png");//files are in desktop
		Image imgLogos = icnLogo.getImage();
		Image rsdImgLogo = imgLogos.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		lblLogo.setIcon(new ImageIcon(rsdImgLogo));
		txtTitleEdit = new JTextField();
		txtTitleEdit.setText(book.getBook_title());
		txtTitleEdit.setOpaque(false);
		txtTitleEdit.setForeground(new Color(23, 21, 77));
		txtTitleEdit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		txtTitleEdit.setEditable(true);
		txtTitleEdit.setColumns(10);
		txtTitleEdit.setBorder(null);
		txtTitleEdit.setBounds(195, 84, 383, 52);
		add(txtTitleEdit);

		JPanel pnlBookDetailsEdit = new JPanel();
		pnlBookDetailsEdit.setLayout(null);
		pnlBookDetailsEdit.setBounds(31, 171, 528, 247);
		add(pnlBookDetailsEdit);
		
		JPanel pnlBookAuthorEdit = new JPanel();
		pnlBookAuthorEdit.setLayout(null);
		pnlBookAuthorEdit.setBounds(0, 0, 528, 30);
		pnlBookDetailsEdit.add(pnlBookAuthorEdit);
		
		JLabel lblAuthorEdit = new JLabel("Book Author:");
		lblAuthorEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAuthorEdit.setBounds(0, 0, 116, 30);
		pnlBookAuthorEdit.add(lblAuthorEdit);
		
		txtAuthorEdit = new JTextField();
		txtAuthorEdit.setText(book.getBook_author());
		txtAuthorEdit.setOpaque(false);
		txtAuthorEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtAuthorEdit.setColumns(10);
		txtAuthorEdit.setBounds(128, 1, 400, 30);
		pnlBookAuthorEdit.add(txtAuthorEdit);
		
		JPanel pnlPublisherEdit = new JPanel();
		pnlPublisherEdit.setLayout(null);
		pnlPublisherEdit.setBounds(0, 34, 528, 30);
		pnlBookDetailsEdit.add(pnlPublisherEdit);
		
		JLabel lblPublisherEdit = new JLabel("Publisher:");
		lblPublisherEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublisherEdit.setBounds(0, 0, 116, 30);
		pnlPublisherEdit.add(lblPublisherEdit);
		
		txtPublisherEdit = new JTextField();
		txtPublisherEdit.setText(book.getBook_publisher());
		txtPublisherEdit.setOpaque(false);
		txtPublisherEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtPublisherEdit.setColumns(10);
		txtPublisherEdit.setBounds(128, 1, 400, 30);
		pnlPublisherEdit.add(txtPublisherEdit);
		
		JPanel pnlPublicationDateEdit = new JPanel();
		pnlPublicationDateEdit.setLayout(null);
		pnlPublicationDateEdit.setBounds(0, 67, 528, 30);
		pnlBookDetailsEdit.add(pnlPublicationDateEdit);
		
		JLabel lblPublicationDateEdit = new JLabel("Publication Date:");
		lblPublicationDateEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublicationDateEdit.setBounds(0, 0, 117, 30);
		pnlPublicationDateEdit.add(lblPublicationDateEdit);
		
		txtPublicationDateEdit = new JTextField();
		txtPublicationDateEdit.setText(book.getBook_publication_date());
		txtPublicationDateEdit.setOpaque(false);
		txtPublicationDateEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtPublicationDateEdit.setColumns(10);
		txtPublicationDateEdit.setBounds(128, 1, 400, 30);
		pnlPublicationDateEdit.add(txtPublicationDateEdit);
		
		JPanel pnlISBNEdit = new JPanel();
		pnlISBNEdit.setLayout(null);
		pnlISBNEdit.setBounds(0, 100, 528, 30);
		pnlBookDetailsEdit.add(pnlISBNEdit);
		
		JLabel lblGenreEdit = new JLabel("Genre:");
		lblGenreEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblGenreEdit.setBounds(0, 0, 117, 30);
		pnlISBNEdit.add(lblGenreEdit);
		
		txtGenreEdit = new JTextField();
		txtGenreEdit.setText(book.getBook_genre());
		txtGenreEdit.setOpaque(false);
		txtGenreEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtGenreEdit.setColumns(10);
		txtGenreEdit.setBounds(128, 1, 400, 30);
		pnlISBNEdit.add(txtGenreEdit);
		
		JPanel pnlShelfNumberEdit = new JPanel();
		pnlShelfNumberEdit.setLayout(null);
		pnlShelfNumberEdit.setBounds(0, 134, 528, 30);
		pnlBookDetailsEdit.add(pnlShelfNumberEdit);
		
		JLabel lblShelfNumberEdit = new JLabel("Shelf Number:");
		lblShelfNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblShelfNumberEdit.setBounds(0, 0, 117, 30);
		pnlShelfNumberEdit.add(lblShelfNumberEdit);
		
		txtShelfNumberEdit = new JTextField();
		txtShelfNumberEdit.setText(book.getShelf());
		txtShelfNumberEdit.setOpaque(false);
		txtShelfNumberEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtShelfNumberEdit.setColumns(10);
		txtShelfNumberEdit.setBounds(128, 1, 400, 30);
		pnlShelfNumberEdit.add(txtShelfNumberEdit);
		
		JPanel pnlAisleNumberEdit = new JPanel();
		pnlAisleNumberEdit.setLayout(null);
		pnlAisleNumberEdit.setBounds(0, 168, 528, 30);
		pnlBookDetailsEdit.add(pnlAisleNumberEdit);
		
		JLabel lblAisleNumberEdit = new JLabel("Aisle Number:");
		lblAisleNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAisleNumberEdit.setBounds(0, 0, 117, 30);
		pnlAisleNumberEdit.add(lblAisleNumberEdit);
		
		txtAisleNumberEdit = new JTextField();
		txtAisleNumberEdit.setText(book.getAisle());
		txtAisleNumberEdit.setOpaque(false);
		txtAisleNumberEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtAisleNumberEdit.setColumns(10);
		txtAisleNumberEdit.setBounds(128, 1, 400, 30);
		pnlAisleNumberEdit.add(txtAisleNumberEdit);
		
		JPanel pnlAvailabilityEdit = new JPanel();
		pnlAvailabilityEdit.setLayout(null);
		pnlAvailabilityEdit.setBounds(0, 205, 528, 31);
		pnlBookDetailsEdit.add(pnlAvailabilityEdit);
		
		JLabel lblAvailabilityEdit = new JLabel("Availability:");
		lblAvailabilityEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAvailabilityEdit.setBounds(0, 0, 117, 30);
		pnlAvailabilityEdit.add(lblAvailabilityEdit);
		
		txtAvailability = new JTextField();
		txtAvailability.setText(book.getBook_status());
		txtAvailability.setOpaque(false);
		txtAvailability.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtAvailability.setColumns(10);
		txtAvailability.setBounds(127, 0, 400, 30);
		pnlAvailabilityEdit.add(txtAvailability);
		
		JSeparator separatorEdit = new JSeparator();
		separatorEdit.setOpaque(true);
		separatorEdit.setBackground(new Color(23, 21, 77));
		separatorEdit.setBounds(31, 433, 528, 12);
		add(separatorEdit);
		
		btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.setOpaque(true);
		btnCancelEdit.setForeground(Color.WHITE);
		btnCancelEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnCancelEdit.setBackground(new Color(23, 22, 77));
		btnCancelEdit.setBounds(309, 470, 250, 29);
		add(btnCancelEdit);
		
		JButton btnSaveChangesEdit = new JButton("Save Changes");
		btnSaveChangesEdit.setOpaque(true);
		btnSaveChangesEdit.setForeground(Color.WHITE);
		btnSaveChangesEdit.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnSaveChangesEdit.setBackground(new Color(23, 22, 77));
		btnSaveChangesEdit.setBounds(31, 470, 250, 29);
		add(btnSaveChangesEdit);
		
		btnSaveChangesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = txtTitleEdit.getText();
				String author = txtAuthorEdit.getText();
				String genre = txtGenreEdit.getText();
				String publicationDate = txtPublicationDateEdit.getText();
				String publisher = txtPublisherEdit.getText();
				String status = txtAvailability.getText();
				String shelf = txtShelfNumberEdit.getText();
				String aisle = txtAisleNumberEdit.getText(); 
				int bookId = book.getBook_id();
				
				if (shelf.isEmpty() || aisle.isEmpty()) {
		            JOptionPane.showMessageDialog(pnlEditBookInfo.this, "Shelf Number and Aisle Number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            try {
		            	int aisleNum = Integer.parseInt(aisle);
						int shelfNum = Integer.parseInt(shelf);
						updateBookInfo(bookId, title, author, genre, publicationDate, publisher, status, aisleNum, shelfNum);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(pnlEditBookInfo.this, "Invalid Shelf Number or Aisle Number", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		            
		            
		            
		        }
				
			}
		});

	}
	//Methods
	public JButton getCancelBtn() {
		return btnCancelEdit;
	}
	 
	//Update the book
	public void updateBookInfo(int bookid, String booktitle, String authorname, String genrename, String bookpublicationdate, String bookpublisher, String bookstatus, int aisle, int shelf) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String DB_URL = "jdbc:mysql://localhost/book_keeper";
		String USERNAME = "root";
		String PASSWORD = "";
		int locationid = forCheck.getLocationID(shelf, aisle);
        try {
            // Establish the database connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            //Condition to handle blank values
            if(booktitle.isBlank() || booktitle.equals("Book Author") || authorname.isBlank() || authorname.equals("Book Publiser") ||
            		genrename.isBlank() || genrename.equals("Genre") || bookpublicationdate.isBlank() || bookpublicationdate.equals("Publication Date")
            		|| bookpublisher.isBlank() || bookpublisher.equals("Book Publisher") || bookstatus.isBlank() || bookstatus.equals("Availability")) {
            	JOptionPane.showMessageDialog(pnlEditBookInfo.this, "Cannot have blank values", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
            	String sql = "UPDATE book SET book_title = ?, author_name = ?, genre_name = ?, book_publication_date = ?, book_publisher = ?, book_status = ?, location_id = ? WHERE book_id = ?";

                // Prepare the statement
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, booktitle);
                stmt.setString(2, authorname);
                stmt.setString(3, genrename);
                stmt.setString(4, bookpublicationdate);
                stmt.setString(5, bookpublisher);
                stmt.setString(6, bookstatus);
                stmt.setInt(7, locationid);
                stmt.setInt(8, bookid);

                // Execute the update
                int rowsUpdated = stmt.executeUpdate();
            	
                if (rowsUpdated > 0) {
                	JOptionPane.showMessageDialog(pnlEditBookInfo.this, "Book Info Updated Successfully", "Error", JOptionPane.PLAIN_MESSAGE);
                } else {
                	JOptionPane.showMessageDialog(pnlEditBookInfo.this, "Book did not update", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error updating row: " + e.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("Database connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}