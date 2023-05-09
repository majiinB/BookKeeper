package com.bookkeeper;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Book_keeper_main_interface extends JFrame {

	private JPanel mainPanel;
	loginPanel loginPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_keeper_main_interface frame = new Book_keeper_main_interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//Create the frame.
	public Book_keeper_main_interface() {
		setTitle("Book keeper");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel RoleLabel = new JLabel("Choose Role");
		RoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RoleLabel.setBounds(183, 43, 82, 29);
		mainPanel.add(RoleLabel);
		
		JButton PatronButton = new JButton("Patron");
		PatronButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPane = new loginPanel();
				remove(mainPanel);
				setContentPane(loginPane);
				revalidate();
				repaint();
			}
		});
		PatronButton.setBounds(79, 103, 126, 77);
		mainPanel.add(PatronButton);
		
		JButton AdminButton_1 = new JButton("Admin");
		AdminButton_1.setBounds(239, 103, 126, 77);
		mainPanel.add(AdminButton_1);
		AdminButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Wala pa
			}
		});
	}
	
	//Methods
	public static String encryption(String pass) throws Exception{
		String UserPass = pass;
        String passphrase = "Book_KeeperSecretPassphrase";

        byte[] iv = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };
        byte[] key = Arrays.copyOf(passphrase.getBytes(StandardCharsets.UTF_8), 16);

        // Create the AES cipher object
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Encrypt the message
        byte[] ciphertext = cipher.doFinal(UserPass.getBytes(StandardCharsets.UTF_8));

        // Combine the initialization vector and the ciphertext
        byte[] ivAndCiphertext = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, ivAndCiphertext, 0, iv.length);
        System.arraycopy(ciphertext, 0, ivAndCiphertext, iv.length, ciphertext.length);

        // Encode the result in base64
        String encryptedMessage = Base64.getEncoder().encodeToString(ivAndCiphertext);
		return encryptedMessage;
	}
	
	public static boolean checkEmailExistence(String userEmail) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost/book_keeper";
	    String user = "root";
	    String password = "";
	    boolean forReturn = false;
	    
	    try {
   		 	//Connect to book_keeper Database
  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
  	         conn = DriverManager.getConnection(url, user, password);
  	         //System.out.println("Connected to the database");
  	         
  	         //prepare query
  	         String query = "SELECT * FROM patron WHERE BINARY patron_email=?";
  	         PreparedStatement stmt = conn.prepareStatement(query);
  	         
			 stmt.setString(1, userEmail);
  	         ResultSet rs = stmt.executeQuery();
  	         
  	         //Condition for return and loop continuation
  	         if (rs.next()) {
  	        	 forReturn = true;
  	             conn.close();
  	         } 
  	         else {
  	            forReturn = false;
  	            conn.close();
  	         }
  	     //Exception Handling
  	     } catch (SQLException e) {
  	         System.out.println("Error connecting to the database: " + e.getMessage());
  	     } catch (ClassNotFoundException e) {
  	         System.out.println("JDBC driver not found");
  	     } 
		return forReturn;
	}
	public void signUp() {
		Connection conn = null;
	    String url = "jdbc:mysql://localhost/book_keeper";
	    String user = "root";
	    String password = "";
	    String username ="", pwd ="";
	    Scanner scan = new Scanner(System.in);
	    
	    String userName;
	    String userEmail;
	    String userContact;
	    String userAddress;
	    String userPass;
	    String userPassConfirm;
	    String query;
	    
	    System.out.println("Enter User First Name: ");
	    System.out.println("Enter User Last Name: ");
	    System.out.println("Enter User name");
	    System.out.println("Enter User Email");
	    System.out.println("Enter User Address");
	    System.out.println("Enter User Password");
	    System.out.println("Confirm Password: ");  
	}
	//LoginMethod
	public User loginMethod(String email, String pass, String table, String colEmail, String colPass) throws Exception{
		 //Declare variables
		 Connection conn = null;
	     String url = "jdbc:mysql://localhost/book_keeper";
	     String user = "root";
	     String password = "";
	     String userEmail ="", pwd ="", encryptedpass = "";
	     Scanner scan = new Scanner(System.in);
	     
	     //Loop for input verification with database connection exception handling
	     
	    	 try {
	    		 //Connect to Library management Database
	   	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	         conn = DriverManager.getConnection(url, user, password);
	   	         //System.out.println("Connected to the database");
	   	         
	   	         //User input
	   	         userEmail = email;
	   	         pwd = pass;
	   	         encryptedpass = encryption(pwd);
	   	         //prepare query
	   	         String query = "SELECT * FROM " + table + " WHERE BINARY " + colEmail +"=? AND BINARY " + colPass + "=?";
	   	         PreparedStatement stmt = conn.prepareStatement(query);
	   	         stmt.setString(1, userEmail);
	   	         stmt.setString(2, encryptedpass);
	   	         ResultSet rs = stmt.executeQuery();
	   	         
	   	         //Condition for return and loop continuation
	   	         if (rs.next()) {
	   	             System.out.println("Login successful!");
	   	             int userID = rs.getInt("patron_id");
	   	             String userFname = rs.getString("patron_fname");
	   	             String userLname = rs.getString("patron_lname");
	   	             String userEmail1 = rs.getString("patron_email");
	   	             String userContact = rs.getString("patron_contact");
	   	             String userAddress = rs.getString("patron_address");
	   	             String userPass = rs.getString("patron_password");
	   	             User onlineUser = new User(userID, userFname, userLname, userEmail1, userContact, userAddress, userPass);
	   	             //Close database
	   	             conn.close();
	   	             return onlineUser;
	   	         } else {	
	   	        	 conn.close();
	   	        	 return null;
	   	         }
	   	     //Exception Handling
	   	     } catch (SQLException e) {
	   	         System.out.println("Error connecting to the database: " + e.getMessage());
	   	     } catch (ClassNotFoundException e) {
	   	         System.out.println("JDBC driver not found");
	   	     } 
	     
		return null;
	}
}
