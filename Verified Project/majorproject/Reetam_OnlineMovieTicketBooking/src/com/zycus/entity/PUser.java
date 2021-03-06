package com.zycus.entity;

import java.util.ArrayList;
import java.util.List;

public class PUser {

	private int id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String phoneNo;
	
	private List<PBooking> booking=new ArrayList<PBooking>();
	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<PBooking> getBooking() {
		return booking;
	}

	public void setBooking(List<PBooking> booking) {
		this.booking = booking;
	}
	
	
	
	
}
