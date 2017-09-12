package com.rafalzdzieborski.spring.model;

public class Student {
	
	private int id;
	private String name;
	private String address;
	private String email;
	private String telephone;
	private String comment;
	
	public Student() {
	}

	public Student(int id, String name, String address, String email, String telephone, String comment) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}