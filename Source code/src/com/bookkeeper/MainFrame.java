package com.bookkeeper;

import java.awt.EventQueue;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	private JPanel mainPane;
	private loginPanel loginPanel;
	private choosePanel choose;
	private signUpPanel signUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    public MainFrame() {
		setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPane = new JPanel();
        mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        CardLayout cardLayout = new CardLayout();
        mainPane.setLayout(cardLayout);
        
        //Create panels
        choose = new choosePanel();
        loginPanel = new loginPanel();
        signUp = new signUpPanel();
        
        //Add panels to main panel
        mainPane.add(choose, "panel1");
        mainPane.add(loginPanel, "panel2");
        mainPane.add(signUp,"panel3");
        cardLayout.show(mainPane, "panel1");
        
        //set what will be shown
        getContentPane().add(mainPane);
        pack();
        setSize(560, 365); // Set the size of the frame
        setVisible(true);
        
        //action Listener For choosePanel
        choose.getButtonPatron().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPane, "panel2");
			}
		});
        
        //action listener for back button login
        loginPanel.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPane, "panel1");
			}
		});
        
        
        //action listener for login panel signup
        loginPanel.getSignUpButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPane, "panel3");
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
		public static void signUp() throws Exception {
			Connection conn = null;
		    String url = "jdbc:mysql://localhost/book_keeper";
		    String user = "root";
		    String password = "";
		    Scanner scan = new Scanner(System.in);
		    boolean condition = true;
		    boolean conditionPass = true;
		    
		    String fName;
		    String lName;
		    String userEmail;
		    String userContact;
		    String userAddress;
		    String userPass;
		    String userPassConfirm;
		    String encrypted = ""; 
		    
		    PreparedStatement stmt = null;
		    try {
	   		 	//Connect to book_keeper Database
	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	  	         conn = DriverManager.getConnection(url, user, password);
	  	         //System.out.println("Connected to the database");
	  	         System.out.print("Enter User First Name: ");
	  	         fName = scan.nextLine();
	  	         System.out.print("Enter User Last Name: ");
	  	         lName = scan.nextLine();	
	  	         
				do {
	  	        	 System.out.print("Enter User Email: ");
	  	        	 userEmail = scan.nextLine();
	  	        	 condition = checkEmailExistence(userEmail);
	  	        	 if(condition)
	  	        		 System.out.println("Email Account already exists try again");
	  	         }while(condition);
	  	         System.out.print("Enter User Contact: ");
	  	         userContact = scan.nextLine();
	  	         System.out.print("Enter User Address: ");
		         userAddress = scan.nextLine();
	  	         do {
	  	        	 System.out.print("Enter User Password: ");
	  	        	 userPass = scan.nextLine();
	  	        	 System.out.print("Confirm Password: ");  
	  	        	 userPassConfirm = scan.nextLine();
	  	        	 if(userPass.equals(userPassConfirm)) {
	  	        		 encrypted = encryption(userPass);
	  	        		 conditionPass = false; 
	  	        	 }
	  	        	 else {
	  	        		 conditionPass = true;
	  	         		System.out.println("Password does not match!");
	  	        	 }
	  	         }while(conditionPass);
	  	         //prepare query
	  	         String query = "INSERT INTO patron VALUES (NULL, ?, ?, ?, ?, ?, ?)";
	  	         stmt = conn.prepareStatement(query);
	  	         
				 stmt.setString(1, fName);
				 stmt.setString(2, lName); 
				 stmt.setString(3, userEmail); 
				 stmt.setString(4, userContact); 
				 stmt.setString(5, userAddress); 
				 stmt.setString(6, encrypted); 
	  	         stmt.executeUpdate();
	  	         scan.close();
	  	         System.out.println("Record inserted successfully!");
	        	 } catch (ClassNotFoundException | SQLException e) {
	        		 e.printStackTrace();
	        	 } finally {
	             // Close the resources
	             try {
					if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	             } catch (SQLException se) {
	                se.printStackTrace();
	             }
	        	 }
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
