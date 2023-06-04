package com.bookkeeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class pnlBookAddAdmin extends JPanel {
	private JPanel pnlBookAuthorEdit ;
	private JPanel pnlBookDetailsEdit ;
	private JPanel pnlPublisherEdit;
	private JPanel pnlBookInformationEdit;
	private JPanel pnlISBNEdit;
	private JPanel pnlPublicationDateEdit;
	private JPanel pnlShelfNumberEdit;
	private JPanel pnlAisleNumberEdit;
	private JPanel pnlAvailabilityEdit;
	private JPanel pnlButtons;
	private PlaceholderTextField txtAuthorEdit;
	private PlaceholderTextField txtPublisherEdit;
	private PlaceholderTextField txtPublicationDateEdit;
	private PlaceholderTextField txtGenreEdit;
	private PlaceholderTextField txtShelfNumberEdit;
	private PlaceholderTextField txtAisleNumberEdit;
	private JTextField txtTitleEdit;
	private PlaceholderTextField txtAvailability;
	private JLabel lblAuthorEdit;
	private JLabel lblPublicationDateEdit;
	private JLabel lblPublisherEdit;
	private JLabel lblGenreEdit;
	private JLabel lblAisleNumberEdit;
	private JLabel lblShelfNumberEdit;
	private JLabel lblAvailabilityEdit;
	private JButton btnCancelEdit;
	private JButton btnSaveChangesEdit;
	private JComboBox cmbAvailability;
	private JSeparator sprtrLocAndDetails;



	
	public  pnlBookAddAdmin() {
		setLayout(new BorderLayout(0, 0));        
		setBorder(new EmptyBorder(40, 60, 130, 60));
		
		txtTitleEdit = new JTextField("Enter Book Title");
		txtTitleEdit.setOpaque(false);
		txtTitleEdit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		txtTitleEdit.setForeground(new Color(23, 21, 77));
		txtTitleEdit.setColumns(15);
		txtTitleEdit.setBorder(null);

		pnlBookDetailsEdit = new JPanel();
		pnlBookAuthorEdit = new JPanel();
		pnlPublisherEdit = new JPanel();
		pnlISBNEdit = new JPanel();
		pnlAisleNumberEdit = new JPanel();
		pnlPublicationDateEdit = new JPanel();
		pnlShelfNumberEdit = new JPanel();
		pnlAvailabilityEdit = new JPanel();
		pnlButtons = new JPanel();
		pnlBookInformationEdit = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		lblAuthorEdit = new JLabel("Book Author:");
		lblAuthorEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAuthorEdit.setBounds(0, 0, 116, 30);
		
		txtAuthorEdit = new PlaceholderTextField("Book Author");
		txtAuthorEdit.setColumns(15);
		txtAuthorEdit.setBounds(128, 1, 400, 30);
		

		lblPublisherEdit = new JLabel("Publisher:");
		lblPublisherEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublisherEdit.setBounds(0, 0, 116, 30);

		
		txtPublisherEdit = new PlaceholderTextField("Book Publisher");
		txtPublisherEdit.setColumns(15);
		txtPublisherEdit.setBounds(128, 1, 400, 30);
		
		
		lblPublicationDateEdit = new JLabel("Publication Date:");
		lblPublicationDateEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPublicationDateEdit.setBounds(0, 0, 117, 30);
		
		txtPublicationDateEdit = new PlaceholderTextField("Publication Date");
		txtPublicationDateEdit.setColumns(15);
		txtPublicationDateEdit.setBounds(128, 1, 400, 30);
		
		lblGenreEdit = new JLabel("Genre:");
		lblGenreEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblGenreEdit.setBounds(0, 0, 117, 30);
		
		txtGenreEdit = new PlaceholderTextField("Genre");
		txtGenreEdit.setColumns(15);
		txtGenreEdit.setBounds(128, 1, 400, 30);
		
		
		sprtrLocAndDetails = new JSeparator();
		sprtrLocAndDetails.setOpaque(true);

		lblShelfNumberEdit = new JLabel("Shelf Number:");
		lblShelfNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblShelfNumberEdit.setBounds(0, 0, 117, 30);

		
		txtShelfNumberEdit = new PlaceholderTextField("Shelf Number");
		txtShelfNumberEdit.setColumns(15);
		txtShelfNumberEdit.setBounds(128, 1, 400, 30);

		
		lblAisleNumberEdit = new JLabel("Aisle Number:");
		lblAisleNumberEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAisleNumberEdit.setBounds(0, 0, 117, 30);


		txtAisleNumberEdit = new PlaceholderTextField("Aisle Number");
		txtAisleNumberEdit.setColumns(15);
		txtAisleNumberEdit.setBounds(128, 1, 400, 30);
	    

		
		lblAvailabilityEdit = new JLabel("Availability:");
		lblAvailabilityEdit.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAvailabilityEdit.setBounds(0, 0, 117, 30);
		
		cmbAvailability = new JComboBox<String>();
		cmbAvailability.setBounds(129, 4, 149, 27);
	    cmbAvailability.addItem("Available");
	    cmbAvailability.addItem("Unavailable");

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

		
		pnlBookAuthorEdit.add(lblAuthorEdit);
		pnlBookAuthorEdit.add(txtAuthorEdit);
		pnlPublisherEdit.add(lblPublisherEdit);
		pnlPublisherEdit.add(txtPublisherEdit);
		pnlISBNEdit.add(lblGenreEdit);
		pnlISBNEdit.add(txtGenreEdit);
		pnlShelfNumberEdit.add(lblShelfNumberEdit);
		pnlShelfNumberEdit.add(txtShelfNumberEdit);
		pnlPublicationDateEdit.add(lblPublicationDateEdit);
		pnlPublicationDateEdit.add(txtPublicationDateEdit);
		pnlAisleNumberEdit.add(lblAisleNumberEdit);
		pnlAisleNumberEdit.add(txtAisleNumberEdit);
		pnlAvailabilityEdit.add(lblAvailabilityEdit);
	    pnlAvailabilityEdit.add(cmbAvailability);

		pnlButtons.add(btnSaveChangesEdit);
		pnlButtons.add(btnCancelEdit);
		pnlBookInformationEdit.add(txtTitleEdit);
		pnlBookInformationEdit.add(pnlBookAuthorEdit);
		pnlBookInformationEdit.add(pnlPublisherEdit);
		pnlBookInformationEdit.add(pnlPublicationDateEdit);
		pnlBookInformationEdit.add(pnlISBNEdit);
		pnlBookInformationEdit.add(pnlShelfNumberEdit);
		pnlBookInformationEdit.add(pnlAisleNumberEdit);
		pnlBookInformationEdit.add(pnlAvailabilityEdit);
		pnlBookInformationEdit.add(pnlButtons);
		
		pnlBookInformationEdit.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		add(pnlBookInformationEdit);

		btnSaveChangesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = txtTitleEdit.getText();
				String author = txtAuthorEdit.getText();
				String genre = txtGenreEdit.getText();
				String publicationDate = txtPublicationDateEdit.getText();
				String publisher = txtPublisherEdit.getText();
				String status = (String) cmbAvailability.getSelectedItem();
				String shelf = txtShelfNumberEdit.getText();
				String aisle = txtAisleNumberEdit.getText();
				if (shelf.isEmpty() || aisle.isEmpty()) {
		            JOptionPane.showMessageDialog(pnlBookAddAdmin.this, "Shelf Number and Aisle Number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            try {
		            	int aisleNum = Integer.parseInt(aisle);
						int shelfNum = Integer.parseInt(shelf);
						addBook(title, author, genre, publicationDate, publisher, status, shelfNum, aisleNum);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(pnlBookAddAdmin.this, "Invalid Shelf Number or Aisle Number", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
				
			}
		});

}	
	public JButton getCancel() {
		return btnCancelEdit;
	}
	public int getLocationID(int shelfNumber, int aisleNumber) {
        Connection conn = null;
        Statement stmt = null;
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/book_keeper";

        // Database credentials
        String USERNAME = "root";
        String PASSWORD = "";
        int locationID = -1; // Default value if no match is found

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Execute SQL query
            stmt = conn.createStatement();
            String sql = "SELECT location_id FROM location " +
                         "WHERE shelf_number = " + shelfNumber +
                         " AND aisle_number = " + aisleNumber;
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result
            if (rs.next()) {
                locationID = rs.getInt("location_id");
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return locationID;
    }
	
		public void addBook(String title, String author, String genre, String publicationDate, String publisher, String status, int shelf, int aisle) {
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/book_keeper";
		String USERNAME = "root";
		String PASSWORD = "";
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        int locId = getLocationID(shelf, aisle);
        
        if(locId == -1) {
        	JOptionPane.showMessageDialog(pnlBookAddAdmin.this, "No id is found", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
        	if(title.isBlank() || title.equals("Enter Book Title") || author.isBlank() || author.equals("Book Author") ||
            		genre.isBlank() || genre.equals("Genre") || publicationDate.isBlank() || publicationDate.equals("Publication Date")
            		|| publisher.isBlank() || publisher.equals("Book Publisher") || status.isBlank()) {
            	JOptionPane.showMessageDialog(pnlBookAddAdmin.this, "Cannot have blank values", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
            	JOptionPane.showMessageDialog(pnlBookAddAdmin.this, "Book sucessfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
            	try {
                    // Register JDBC driver
                    Class.forName(JDBC_DRIVER);

                    // Open a connection
                    conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    // Create the SQL statement
                    String sql = "INSERT INTO book (book_title, author_name, genre_name, book_publication_date, book_publisher, book_status, location_id) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    // Create a prepared statement
                    pstmt = conn.prepareStatement(sql);

                    // Set the parameter values
                    pstmt.setString(1, title);
                    pstmt.setString(2, author); 
                    pstmt.setString(3, genre);
                    pstmt.setString(4, publicationDate);
                    pstmt.setString(5, publisher);
                    pstmt.setString(6, status);
                    pstmt.setInt(7, locId);

                    // Execute the statement
                    pstmt.executeUpdate();

                    System.out.println("Book added successfully!");

                    // Close the prepared statement
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Close resources
                    try {
                        if (pstmt != null) pstmt.close();
                    } catch (SQLException se2) {
                    } // nothing we can do
                    try {
                        if (conn != null) conn.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }
            	
            }
        }
        
    }
}