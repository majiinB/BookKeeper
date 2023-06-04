package com.bookkeeper;

public class Employee {
	private String Employee_id;
	private String fname;
	private String lname;
	private String Position;
	private String Email;
	private String Employee_pass;
	
	public Employee(String Employee_id, String fname, String lname,String Position, String Email, String Employee_pass ) {
		this.Employee_id = Employee_id;
		this.fname = fname;
		this.lname = lname;
		this.Position = Position;
		this.Email = Email;
		this.Employee_pass = Employee_pass;
	}

	public String getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(String employee_id) {
		Employee_id = employee_id;
	}


	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmployee_pass() {
		return Employee_pass;
	}

	public void setEmployee_pass(String employee_pass) {
		Employee_pass = employee_pass;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

}