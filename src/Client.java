package com.cebem.model;

public class Client {
	int id;
	String name;
	String surname;
	long telephone;
	String email;
	String address;
	String password;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Client(int id, String name, String surname, long telephone, String email, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public Client() {
		super();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
