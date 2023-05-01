package com.bookkeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
        /*Connection conn = null;
        String url = "jdbc:mysql://localhost/library_management";
        String user = "root";
        String password = "";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Disconnected from database");
                }
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }*/
		loginMethod();
    }
	
	public static void loginMethod() {
		 	String url = "jdbc:mysql://localhost:3306/library_management";
	        String user = "root";
	        String password = "";
	        
	        try {
	            Connection con = DriverManager.getConnection(url, user, password);
	            
	            Scanner sc = new Scanner(System.in);
	            System.out.print("Enter username: ");
	            String username = sc.nextLine();
	            System.out.print("Enter password: ");
	            int pwd = sc.nextInt();
	            
	            String query = "SELECT * FROM user WHERE User_name=? AND User_pass=?";
	            PreparedStatement stmt = con.prepareStatement(query);
	            stmt.setString(1, username);
	            stmt.setLong(2, pwd);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                System.out.println("Login successful!");
	            } else {
	                System.out.println("Invalid username or password.");
	            }
	            
	            con.close();
	            
	        } catch (SQLException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
}
