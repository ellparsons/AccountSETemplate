package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length = 40)
	private String firstName;
	
	@Column(length = 40)
	private String lastName;
	
	@Column(length = 10)
	private long accountNumber;
	
	public Account(String firstName, String lastName, long accountNumber) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.accountNumber=accountNumber;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
