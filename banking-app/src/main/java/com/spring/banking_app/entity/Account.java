package com.spring.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@Table(name = "accounts")
@Entity
public class Account {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "account_holder_name")
	private String acoountHolderName;
	
	@Column(name = "balance")
	private double balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcoountHolderName() {
		return acoountHolderName;
	}

	public void setAcoountHolderName(String acoountHolderName) {
		this.acoountHolderName = acoountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, String acoountHolderName, double balance) {
		super();
		this.id = id;
		this.acoountHolderName = acoountHolderName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", acoountHolderName=" + acoountHolderName + ", balance=" + balance + "]";
	}
	
	
	
}
