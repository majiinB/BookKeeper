package com.bookkeeper;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class main {

	public static void main(String[] args) {
		
		
		User newUser;
		newUser = loginMethod();
		System.out.println(newUser.toString());
		
		

    }
	public void signUp() {
		Connection conn = null;
	    String url = "jdbc:mysql://localhost/library_management";
	    String user = "root";
	    String password = "";
	    String username ="", pwd ="";
	    Scanner scan = new Scanner(System.in);
	    
	    
	}
	//LoginMethod
	public static User loginMethod(){
		 //Declare variables
		 int tries = 0;
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
	   	         String query = "SELECT * FROM user WHERE BINARY User_name=? AND BINARY User_pass=?";
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
	   	             User onlineUser = new User(userID, userName, userEmail, userContact, userAddress, userPass);
	   	         	 
	   	             scan.close();
	   	             conn.close();
	   	             forReturn = true;
	   	             return onlineUser;
	   	         } else {
	   	             System.out.println("Invalid username or password.");
	   	             tries++;
	   	             if(tries>=3) {
		   	        	 System.out.println("Login limit reached! Will now exit program");
		   	        	 System.exit(0);
		   	         }
	   	             loginCondition = true;
	   	         }
	   	     //Exception Handling
	   	     } catch (SQLException e) {
	   	         System.out.println("Error connecting to the database: " + e.getMessage());
	   	     } catch (ClassNotFoundException e) {
	   	         System.out.println("JDBC driver not found");
	   	     } 
	     }
		return null;
	}
	
}
