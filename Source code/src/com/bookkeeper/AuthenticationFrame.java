package com.bookkeeper;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.time.LocalDate;
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
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
// Frame for user authentication

public class AuthenticationFrame extends JFrame{
	//panel
	private JPanel mainPanel;
	private RoleSelectionPanel RoleSelectionPanel;
	private AdminLogInPanel AdminLogInPanel;
	private PatronLogInPanel PatronLogInPanel;
	private SignUpPanel SignUpPanel;
	private StartUpPanel StartUpPanel;
	
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
	
	public static void main(String[] args) {
		/*updateOverdueBooks();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
//    	setResizable(false); 

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
        RoleSelectionPanel = new RoleSelectionPanel(); //panel to select whether you are a patron or a staff
        AdminLogInPanel = new AdminLogInPanel(); //panel for admin to log in 
        PatronLogInPanel = new PatronLogInPanel(); //panel for patron to log in 
        SignUpPanel = new SignUpPanel(); //panel for admin to register a user
        StartUpPanel = new StartUpPanel(); //panel the user will first see when app is opened

    	// Set the layout of main panel to switch between the panels
    	cardLayout = new CardLayout();
    	mainPanel.setLayout(cardLayout);

    	// Add all Panels to main panel
    	mainPanel.add(StartUpPanel, "panel1");
    	mainPanel.add(RoleSelectionPanel, "panel2");
    	mainPanel.add(AdminLogInPanel, "panel3");
    	mainPanel.add(PatronLogInPanel,"panel4");
    	mainPanel.add(SignUpPanel, "panel5");

    	// Set mainPanel as the content pane of the JFrame
    	setContentPane(mainPanel);
    	cardLayout.show(mainPanel, "panel1");

    	// Action listeners
    	StartUpPanel.getStart().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel, "panel2");
        	}
        });
    	
    	// Center the frame on the screen
    	setLocationRelativeTo(null);

    	// Make the frame visible
    	setVisible(true);
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
  		public void signUp(String fName, String lName, String userEmail, String userContact, String userAddress, int forQuery) throws Exception {
  			Connection conn = null;
  		    String url = "jdbc:mysql://localhost/book_keeper";
  		    String user = "root";
  		    String password = "";
  		    boolean condition = true;
  		    boolean con1 = true;
  		    String encrypted = ""; 
  		    String status = "active";
  		    String id ="";
  		    String position = "Employee";

  		    do {
  		    	id = generateRandomID();
  		    	con1 = checkId(id);
  		    }while(con1);
  		    
  		    PreparedStatement stmt = null;
  		    try {
  	   		 	//Connect to book_keeper Database
  	  	      	 Class.forName("com.mysql.cj.jdbc.Driver");
  	  	         conn = DriverManager.getConnection(url, user, password);
  	  	         
  	  	         //Check email Existence
  	  	         condition = checkEmailExistence(userEmail, forQuery);
  	  	         if(condition)
  	  	        	 JOptionPane.showMessageDialog(null, "Email Already taken", "Error", JOptionPane.ERROR_MESSAGE);
  	  	         else {
  	  	        	 if(forQuery == 1) {
  	  	        		encrypted = encryption(id);
  		  	        	//prepare query
  			  	         String query = "INSERT INTO patron VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  			  	         stmt = conn.prepareStatement(query);
  			  	         stmt.setString(1, id);
  						 stmt.setString(2, fName);
  						 stmt.setString(3, lName); 
  						 stmt.setString(4, userEmail); 
  						 stmt.setString(5, userContact); 
  						 stmt.setString(6, userAddress); 
  						 stmt.setString(7, encrypted); 
  						 stmt.setString(8, status); 
  			  	         stmt.executeUpdate();

  			  	         JOptionPane.showMessageDialog(null, "Signup successfull!", "Signup", JOptionPane.PLAIN_MESSAGE);
  	  	        	 }
  	  	        	 else{
  	  	        		 encrypted = encryption(id);
  	  	        		 //prepare query
  	  	        		 String query = "INSERT INTO admin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  			  	         stmt = conn.prepareStatement(query);
  			  	         stmt.setString(1, id);
  						 stmt.setString(2, fName);
  						 stmt.setString(3, lName); 
  						 stmt.setString(4, userEmail); 
  						 stmt.setString(5, position); 
  						 stmt.setString(6, encrypted); 
  						 stmt.setString(7, status); 
  						 stmt.setString(8, userContact); 
  						 stmt.setString(9, userAddress); 
  			  	         stmt.executeUpdate();
  			  	         
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
  		public Object loginMethod(String email, String pass, String table, String colEmail, String colPass, String colStatus, String status) throws Exception{
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
  		   	             System.out.println("Login successful!");
  		   	             if(table.equals("patron")) {
  		   	            	 String userID = rs.getString("patron_id");
  			   	             String userFname = rs.getString("patron_fname");
  			   	             String userLname = rs.getString("patron_lname");
  			   	             String userEmail1 = rs.getString("patron_email");
  			   	             String userContact = rs.getString("patron_contact");
  			   	             String userAddress = rs.getString("patron_address");
  			   	             String userPass = rs.getString("patron_password");
  			   	             String userStatus = rs.getString("patron_status");
  			   	             
  			   	             User onlineUser = new User(userID, userFname, userLname, userEmail1, userContact, userAddress, userPass, userStatus);
  			   	             //Close database
  			   	             conn.close();
  			   	             return onlineUser;
  		   	             }else {
  		   	            	 String userID = rs.getString("admin_id");
  			   	             String userFname = rs.getString("admin_fname");
  			   	             String userLname = rs.getString("admin_lname");
  			   	             String userEmail1 = rs.getString("admin_email");
  			   	             String userPosition = rs.getString("admin_position");
  			   	             String userPass = rs.getString("admin_password");
  			   	             String userContact = rs.getString("admin_contact");
  			   	             String userAddress = rs.getString("admin_address");
  			   	             String userStatus = rs.getString("admin_status");
  			   	             
  			   	             
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
  		    public static String generateRandomID() {
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
  		public boolean checkId(String id) {
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