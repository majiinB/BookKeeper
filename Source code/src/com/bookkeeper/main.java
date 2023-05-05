package com.bookkeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class main {
	private static User onlineUser;

	public static void main(String[] args) {
		 //Declare variables
		 boolean loginCondition = true;
		 boolean forReturn = false;
		 Connection conn = null;
	     String url = "jdbc:mysql://localhost/library_management";
	     String user = "root";
	     String password = "";
	     String username ="", pwd ="";
	     Scanner scan = new Scanner(System.in);
	     
	     //Loop for input verification with database connection exception handling
	     while(loginCondition){
	    	 try {
	    		 //Connect to Library management Database
	   	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	         conn = DriverManager.getConnection(url, user, password);
	   	         //System.out.println("Connected to the database");
	   	         
	   	         //User input
	   	         System.out.print("Enter username: ");
	   	         username = scan.nextLine();
	   	         System.out.print("Enter password: ");
	   	         pwd = scan.nextLine();
	   	         
	   	         //prepare query
	   	         String query = "SELECT * FROM user WHERE BINARY User_name=? AND User_pass=?";
	   	         PreparedStatement stmt = conn.prepareStatement(query);
	   	         stmt.setString(1, username);
	   	         stmt.setString(2, pwd);
	   	         ResultSet rs = stmt.executeQuery();
	   	         
	   	         //Condition for return and loop continuation
	   	         if (rs.next()) {
	   	             System.out.println("Login successful!");
	   	             int userID = rs.getInt("user_id");
	   	             String userName = rs.getString("User_name");
	   	             String userEmail = rs.getString("User_email");
	   	             String userContact = rs.getString("User_contact");
	   	             String userAddress = rs.getString("User_address");
	   	             String userPass = rs.getString("User_pass");
	   	             onlineUser = new User(userID, userName, userEmail, userContact, userAddress, userPass);
	   	             System.out.println(onlineUser.toString());
	   	             scan.close();
	   	             conn.close();
	   	             forReturn = true;
	   	             loginCondition = false;
	   	         } else {
	   	             System.out.println("Invalid username or password.");
	   	             
	   	             loginCondition = true;
	   	         }
	   	     //Exception Handling
	   	     } catch (SQLException e) {
	   	         System.out.println("Error connecting to the database: " + e.getMessage());
	   	     } catch (ClassNotFoundException e) {
	   	         System.out.println("JDBC driver not found");
	   	     } 
	     }
	}
}
