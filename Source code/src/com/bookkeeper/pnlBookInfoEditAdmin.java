package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
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
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlBookInfoEditAdmin extends JPanel {
	private JTextField txtAuthorEdit;
	private JTextField txtPublisherEdit;
	private JTextField txtPublicationDateEdit;
	private JTextField txtGenreEdit;
	private JTextField txtShelfNumberEdit;
	private JTextField txtAisleNumberEdit;
	private JTextField txtTitleEdit;
	private JTextField txtAvailability;
	JButton btnCancelEdit;
	public  pnlBookInfoEditAdmin() {
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
		txtTitleEdit.setText("Enter Book Title:");
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
		txtAuthorEdit.setText("Book Author");
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
		txtPublisherEdit.setText("Book Publisher");
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
		txtPublicationDateEdit.setText("Publication Date");
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
		txtGenreEdit.setText("Genre");
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
		txtShelfNumberEdit.setText("Shelf Number");
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
		txtAisleNumberEdit.setText("Aisle Number");
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
		txtAvailability.setText("Availability");
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
				if (shelf.isEmpty() || aisle.isEmpty()) {
		            JOptionPane.showMessageDialog(pnlBookInfoEditAdmin.this, "Shelf Number and Aisle Number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            try {
		            	int aisleNum = Integer.parseInt(aisle);
						int shelfNum = Integer.parseInt(shelf);
						addBook(title, author, genre, publicationDate, publisher, status, shelfNum, aisleNum);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(pnlBookInfoEditAdmin.this, "Invalid Shelf Number or Aisle Number", "Error", JOptionPane.ERROR_MESSAGE);
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
        	JOptionPane.showMessageDialog(pnlBookInfoEditAdmin.this, "No id is found", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
        	if(title.isBlank() || title.equals("Book Author") || author.isBlank() || author.equals("Book Publiser") ||
            		genre.isBlank() || genre.equals("Genre") || publicationDate.isBlank() || publicationDate.equals("Publication Date")
            		|| publisher.isBlank() || publisher.equals("Book Publisher") || status.isBlank() || status.equals("Availability")) {
            	JOptionPane.showMessageDialog(pnlBookInfoEditAdmin.this, "Cannot have blank values", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
            	JOptionPane.showMessageDialog(pnlBookInfoEditAdmin.this, "Book sucessfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
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
	

