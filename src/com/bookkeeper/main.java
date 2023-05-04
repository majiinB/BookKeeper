package com.bookkeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		boolean loginCondition = false;
		loginCondition = loginMethod();
		
		if(loginCondition) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
    }
	//LoginMethod
	public static boolean loginMethod(){
		 //Declare variables
		 boolean loginCondition = true;
		 boolean forReturn = false;
		 Connection conn = null;
	     String url = "jdbc:mysql://localhost/library_management";
	     String user = "root";
	     String password = "";
	     String username ="", pwd ="";
	     Scanner sc = new Scanner(System.in);
	     
	     //Loop for input verification with database connection exception handling
	     while(loginCondition){
	    	 try {
	    		 //Connect to Library management Database
	   	      	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	         conn = DriverManager.getConnection(url, user, password);
	   	         //System.out.println("Connected to the database");
	   	         
	   	         //User input
	   	         System.out.print("Enter username: ");
	   	         username = sc.nextLine();
	   	         System.out.print("Enter password: ");
	   	         pwd = sc.nextLine();
	   	         
	   	         //prepare query
	   	         String query = "SELECT * FROM user WHERE BINARY User_name=? AND User_pass=?";
	   	         PreparedStatement stmt = conn.prepareStatement(query);
	   	         stmt.setString(1, username);
	   	         stmt.setString(2, pwd);
	   	         ResultSet rs = stmt.executeQuery();
	   	         
	   	         //Condition for return and loop continuation
	   	         if (rs.next()) {
	   	             System.out.println("Login successful!");
	   	         	 sc.close();
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
		return forReturn;
		
	}
	
}
