package com.zycus.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "user")

public class UserEntity {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	//@Column(name = "email",columnDefinition="NOT NULL UNIQUE")
	@Column(name="email",nullable = false,unique =true )
	
	private String email;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "mobile_number")
	private long mobileNumber;
	
	@Column(name = "registration_time")
	private Time registrationTime;
	
	@Column(name = "password")
	private String password;
	
	/**
	 * Only 2 roles, ROLE_USER and ROLE_ADMIN
	 */
	@Column(name = "user_role")
	private String role;
	
	
	public UserEntity(String firstName, String lastName, String email,
			Date dob, long mobileNumber, Time registrationTime,
			String password, String role) {
		super();
		//this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.registrationTime = registrationTime;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Time getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Time registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", mobileNumber=" + mobileNumber
				+ ", registrationTime=" + registrationTime + ", password="
				+ password + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int userId2) {
		this.userId = userId2;
	}
	
	
	
	
	
}
