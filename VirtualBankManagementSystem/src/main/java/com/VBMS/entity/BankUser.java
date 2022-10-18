package com.VBMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User_Details")
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {
	
	//bank properties
	
	@Id
	@Column(name="account_number", length=10, nullable=false, unique=true)
	private int accountNo;
	
	@Column(name="account_holder", length=25, nullable=false)
	private String accountHolder;
	
	@Column(name="account_type", length=7, nullable=false)
	private String accountType;
	
	@Column(name="branch_name", length=15, nullable=false)
	private String branch;
	
	@Column(name="pin", length=4, nullable=false)
	private int pin;
	
	@Column(name="email", length=25, nullable=false, unique=true)
	private String email;
	
	@Column(name="contact_no", length=10, nullable=false ,unique=true)
	private long contact ;
	
	@Column(name="account_balance", length=10, nullable=false)
	private double balance ;
}
