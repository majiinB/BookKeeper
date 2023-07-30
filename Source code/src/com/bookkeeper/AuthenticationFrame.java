package com.bookkeeper;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AuthenticationFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//panel
	private JPanel mainPanel;
	private RoleSelectionPanel roleSelectionPanel;
	private AdminLogInPanel adminLogInPanel;
	private PatronLogInPanel patronLogInPanel;
	private SignUpPanel signUpPanel;
	private StartUpPanel startUpPanel;
	
	//layout
	private CardLayout cardLayout;
	
	//icon
	private ImageIcon icon;
	private Image image;
	
	//Graphics environment and screen dimensions
	private GraphicsEnvironment environment;	
	private GraphicsDevice device;
	private int width;
	private int height;
	private int selectedValue;
	
	public static void main(String[] args) {
		/*updateOverdueBooks();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					AuthenticationFrame frame = new AuthenticationFrame();	
					
					//need ko lng makita marun ung frame mehe
//					AlertFrame frame = new AlertFrame();	
//					DashboardFrame frame = new DashboardFrame();	
//					InfoDisplayFrame frame = new InfoDisplayFrame();	
//					ChangeInfoFrame frame = new ChangeInfoFrame();	

				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}
	
    public AuthenticationFrame() {
    	setTitle("Book Keeper");
    	
    	// Set the Icon
    	icon = new ImageIcon("img/Logo_Original.png"); 
    	image = icon.getImage();
    	setIconImage(image);
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// Remove window decorations (title bar, borders)
//    	setUndecorated(true); 
    	
    	// Prevent resizing
    	setResizable(true); 

    	// Set the frame size based on the screen dimensions
    	environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	device = environment.getDefaultScreenDevice();
    	width = (int) (device.getDisplayMode().getWidth() * 0.6);    	
    	height = (int) (device.getDisplayMode().getHeight() * (2.0 / 3.0));  
    	setSize(width, height);

    	//print sizes( wala lng toh :> )
    	System.out.println("Device Width = " + device.getDisplayMode().getWidth());
    	System.out.println("Device Height = " + device.getDisplayMode().getHeight());
    	System.out.println("Frame Width = " + width);
    	System.out.println("Frame Height = " + height);
    	

    	// Create panels
    	mainPanel = new JPanel();//panel to hold all panels
        roleSelectionPanel = new RoleSelectionPanel(); //panel to select whether you are a patron or a staff
        adminLogInPanel = new AdminLogInPanel(); //panel for admin to log in 
        patronLogInPanel = new PatronLogInPanel(); //panel for patron to log in 
        signUpPanel = new SignUpPanel(); //panel for admin to register a user
        startUpPanel = new StartUpPanel(); //panel the user will first see when app is opened

    	// Set the layout of main panel to switch between the panels
    	cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

    	// Add all Panels to main panel
    	mainPanel.add(startUpPanel, "panel1");
    	mainPanel.add(roleSelectionPanel, "panel2");
    	mainPanel.add(adminLogInPanel, "panel3");
    	mainPanel.add(patronLogInPanel,"panel4");
    	mainPanel.add(signUpPanel, "panel5");

    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);
    	cardLayout.show(mainPanel, "panel1");

    	// Action listeners
    	startUpPanel.getStart().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel, "panel2");
        	}
        });
    	roleSelectionPanel.getBtnAdmin().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel, "panel3");
        	}
        });
    	roleSelectionPanel.getBtnPatron().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel,"panel4");
        	}
        });
    	roleSelectionPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel,"panel1");
        	}
        });
    	adminLogInPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel,"panel2");
        		adminLogInPanel.clear();
        	}
        });
    	patronLogInPanel.getBtnBack().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel,"panel2");
        		patronLogInPanel.clear();
        	}
        });
    	
    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setVisible(true);
    }
   
  //Methods
    //Alert Frame Methods
    
    //Validation Methods
	    public static boolean isValidEmail(String email) {
	        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	        return Pattern.matches(emailRegex, email);
	    }
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
  		
  		public static boolean checkEmailExistence(String userEmail, int con) {
  			Connection conn = null;
  			String url = "jdbc:mysql://localhost/book_keeper";
  		    String user = "root";
  		    String password = "";
  		    boolean forReturn = false;
  		    String query = "";
  		    
  		    try {
  	   		 	//Connect to book_keeper Database
  	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
  	  	         conn = DriverManager.getConnection(url, user, password);
  	  	         //System.out.println("Connected to the database");
  	  	         
  	  	         //prepare query
  	  	         if(con == 1) {
  	  	        	query = "SELECT * FROM patron WHERE BINARY patron_email=?";
  	  	         }else {
  	  	        	query = "SELECT * FROM admin WHERE BINARY admin_email=?";
  	  	         }
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
  		public static void signUp(String fName, String lName, String userEmail, String userContact, String userAddress, int forQuery) throws Exception {
  			Connection conn = null;
  		    String url = "jdbc:mysql://localhost/book_keeper";
  		    String user = "root";
  		    String password = "";
  		    String pass ="";
  		    boolean condition = true;
  		    boolean con1 = true;
  		    String encrypted = ""; 
  		    String status = "active";
  		    String position = "Employee";
  		    int penalty = 0;

  		    do {
  		    	pass = generateRandomPass();
  		    	con1 = checkId(pass);
  		    }while(con1);
  		    
  		    PreparedStatement stmt = null;
  		    try {
  	   		 	//Connect to book_keeper Database
  	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
  	  	         conn = DriverManager.getConnection(url, user, password);
  	  	         
  	  	         //Check email Existence
  	  	         condition = checkEmailExistence(userEmail, forQuery);
  	  	         if(condition)
 	            	// Show alert message
         			/* 
         			 * Alert Title: Sign Up Failed
         			 * Alert Description: The email you provided is already taken.
         			 * Please try using a different email address.
         			 */
  	  	        	 
  	  	        	 JOptionPane.showMessageDialog(null, "Email Already taken", "Error", JOptionPane.ERROR_MESSAGE);
  	  	         else {
  	  	        	 if(forQuery == 1) {
  	  	        		encrypted = encryption(pass);
  		  	        	//prepare query
  	  	  
  			  	         String query = "INSERT INTO patron (patron_fname, patron_lname, patron_email, patron_contact, patron_address, patron_password, patron_status, penalty)"
  			  	         		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  			  	         stmt = conn.prepareStatement(query);
  						 stmt.setString(1, fName);
  						 stmt.setString(2, lName); 
  						 stmt.setString(3, userEmail); 
  						 stmt.setString(4, userContact); 
  						 stmt.setString(5, userAddress); 
  						 stmt.setString(6, encrypted); 
  						 stmt.setString(7, status); 
  						 stmt.setInt(8, penalty);
  			  	         stmt.executeUpdate();
  	 	            	// Show alert message
  	         			/* 
  	         			 * Alert Title: Added Successfully
  	         			 * Alert Description: User account is successfully added! The user ID 
  	         			 * has been set as the temporary password. Welcome to Book Keeper!
  	         			 */
  			  	         JOptionPane.showMessageDialog(null, "Signup successfull!", "Signup", JOptionPane.PLAIN_MESSAGE);
  	  	        	 }
  	  	        	 else{
  	  	        		 encrypted = encryption(pass);
  	  	        		 //prepare query
  	  	        		 String query = "INSERT INTO admin (admin_fname, admin_lname, admin_email, admin_position, admin_password, admin_status, admin_contact, admin_address)" 
  	  	        		 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  			  	         stmt = conn.prepareStatement(query);
  						 stmt.setString(1, fName);
  						 stmt.setString(2, lName); 
  						 stmt.setString(3, userEmail); 
  						 stmt.setString(4, position); 
  						 stmt.setString(5, encrypted); 
  						 stmt.setString(6, status); 
  						 stmt.setString(7, userContact); 
  						 stmt.setString(8, userAddress); 
  			  	         stmt.executeUpdate();
  			  	         
   	 	            	// Show alert message
   	         			/* 
   	         			 * Alert Title: Added Successfully
   	         			 * Alert Description: User account is successfully added! The user ID 
   	         			 * has been set as the temporary password. Welcome to Book Keeper!
   	         			 */
  			  	         JOptionPane.showMessageDialog(null, "Signup successfull!", "Signup", JOptionPane.PLAIN_MESSAGE);
  	  	        	 }
  	  	         }  
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
  		public static Object loginMethod(String email, String pass, String table, String colEmail, String colPass, String colStatus, String status) throws Exception{
  			 //Declare variables
  			 Connection conn = null;
  		     String url = "jdbc:mysql://localhost/book_keeper";
  		     String user = "root";
  		     String password = "";
  		     String userEmail ="", pwd ="", encryptedpass = "";
  		
  		     
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
  		   	         String query = "SELECT * FROM " + table + " WHERE BINARY " + colEmail +"=? AND BINARY " + colPass + "=? AND " + colStatus + "=?";
  		   	         PreparedStatement stmt = conn.prepareStatement(query);
  		   	         stmt.setString(1, userEmail);
  		   	         stmt.setString(2, encryptedpass);
  		   	         stmt.setString(3, status);
  		   	         ResultSet rs = stmt.executeQuery();
  		   	         
  		   	         //Condition for return and loop continuation
  		   	         if (rs.next()) {
   	 	            	// Show alert message
   	         			/* 
   	         			 * Alert Title: Log In Successful
   	         			 * Alert Description: Welcome Back, <name> ! Happy Browsing!
   	         			 */
  		   	             System.out.println("Login successful!");
  		   	             if(table.equals("patron")) {
  		   	            	 String userID = rs.getString("formatted_id");
  			   	             String userFname = rs.getString("patron_fname");
  			   	             String userLname = rs.getString("patron_lname");
  			   	             String userEmail1 = rs.getString("patron_email");
  			   	             String userContact = rs.getString("patron_contact");
  			   	             String userAddress = rs.getString("patron_address");
  			   	             String userPass = rs.getString("patron_password");
  			   	             String userStatus = rs.getString("patron_status");
  			   	             int userPenalty = rs.getInt("penalty");
  			   	             
  			   	             // Create User object
  			   	             User onlineUser = new User(userID, userFname, userLname, userEmail1, userContact, userAddress, userPass, userStatus, userPenalty);
  			   	             //Close database
  			   	             conn.close();
  			   	             return onlineUser;
  		   	             }else {
  		   	            	 String userID = rs.getString("admin_formatted_id");
  			   	             String userFname = rs.getString("admin_fname");
  			   	             String userLname = rs.getString("admin_lname");
  			   	             String userEmail1 = rs.getString("admin_email");
  			   	             String userPosition = rs.getString("admin_position");
  			   	             String userPass = rs.getString("admin_password");
  			   	             String userContact = rs.getString("admin_contact");
  			   	             String userAddress = rs.getString("admin_address");
  			   	             String userStatus = rs.getString("admin_status");
  			   	             
  			   	             // Create employee object
  			   	             Employee onlineUser = new Employee(userID, userFname, userLname, userEmail1, userPosition, userPass, userStatus, userContact, userAddress);
  			   	          
  			   	             //Close database
  			   	             conn.close();
  			   	             return onlineUser;
  		   	             }
  		   	             
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
  		
  		//create random id
  		    public static String generateRandomPass() {
  		    	final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  			    final int ID_LENGTH = 8;
  		    	StringBuilder sb = new StringBuilder();
  		        Random random = new Random();

  		        for (int i = 0; i < ID_LENGTH; i++) {
  		            int randomIndex = random.nextInt(CHARACTERS.length());
  		            char randomChar = CHARACTERS.charAt(randomIndex);
  		            sb.append(randomChar);
  		        }

  		        return sb.toString();
  		    }
  		public static boolean checkId(String id) {
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
  	  	         String query = "SELECT * FROM patron WHERE BINARY patron_id=?";
  	  	         PreparedStatement stmt = conn.prepareStatement(query);
  	  	         
  				 stmt.setString(1, id);
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
  		public static void updateOverdueBooks() {
  	        try {
  	            // Establish database connection
  	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_keeper", "root", "");

  	            // Get the current date
  	            LocalDate currentDate = LocalDate.now();

  	            // Prepare the SQL statement
  	            String query = "UPDATE book " +
  	                           "SET book_status = 'Overdue' " +
  	                           "WHERE book_status = 'Checked out' " +
  	                           "AND book_id IN ( " +
  	                           "    SELECT book_id " +
  	                           "    FROM borrowed_book " +
  	                           "    WHERE borrowed_due_date < ? " +
  	                           ")";

  	            // Prepare the statement
  	            PreparedStatement statement = connection.prepareStatement(query);
  	            statement.setDate(1, java.sql.Date.valueOf(currentDate));

  	            // Execute the query
  	            statement.executeUpdate();

  	            // Close the database connection
  	            statement.close();
  	            connection.close();

  	            System.out.println("Updated overdue books successfully.");
  	        } catch (SQLException e) {
  	            e.printStackTrace();
  	        }
  	    }

  	//Methods to get layout and panel
  	public CardLayout getLayout() {
  		return cardLayout;
  	}
  	public JPanel getPanel() {
  		return mainPanel;
  	}
 
}