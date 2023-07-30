package com.bookkeeper;

public class Employee {
	private String Employee_id;
	private String fname;
	private String lname;
	private String Position;
	private String Email;
	private String Employee_pass;
	private String status;
	private String contactNum;
	private String address;
	
	public Employee(String Employee_id, String fname, String lname,String Email, String Position, String Employee_pass, String status, String contactNum, String address ) {
		this.Employee_id = Employee_id;
		this.fname = fname;
		this.lname = lname;
		this.Position = Position;
		this.Email = Email;
		this.Employee_pass = Employee_pass;
		this.status = status;
		this.contactNum = contactNum;
		this.address = address;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}