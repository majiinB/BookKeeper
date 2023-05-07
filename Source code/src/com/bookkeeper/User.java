package com.bookkeeper;

public class User {
	private int User_id;
	private String User_fname;
	private String User_lname;
	private String User_email;
	private String User_contact;
	private String User_address;
	private String User_pass;
	
	//Mutators and accessor 
	public User(int User_id, String User_fname,String User_lname, String User_email, String User_contact, String User_address, String User_pass) {
		this.User_id = User_id;
		this.setUser_fname(User_fname);
		this.setUser_lname(User_lname);
		this.User_contact = User_contact;
		this.User_address = User_address;
		this.User_pass = User_pass;
	}

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	public String getUser_email() {
		return User_email;
	}

	public void setUser_email(String user_email) {
		User_email = user_email;
	}

	public String getUser_contact() {
		return User_contact;
	}

	public void setUser_contact(String user_contact) {
		User_contact = user_contact;
	}

	public String getUser_address() {
		return User_address;
	}

	public void setUser_address(String user_address) {
		User_address = user_address;
	}

	public String getUser_pass() {
		return User_pass;
	}

	public void setUser_pass(String user_pass) {
		User_pass = user_pass;
	}
	
	//Method 
	public void addUser() {
		
	}
	public void disableUser() {
		
	}
	
	public String toString() {
		String str = "User ID: " + User_id + "\nUser Name: " + User_fname +" "+ User_lname + "\nUser contact: " + User_contact + "\nUser address: " + User_address;
		return str;
		
	}

	public String getUser_fname() {
		return User_fname;
	}

	public void setUser_fname(String user_fname) {
		User_fname = user_fname;
	}

	public String getUser_lname() {
		return User_lname;
	}

	public void setUser_lname(String user_lname) {
		User_lname = user_lname;
	}
}
