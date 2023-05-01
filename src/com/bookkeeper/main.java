package com.bookkeeper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
        Connection conn = null;
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
        }
    }
	
}
