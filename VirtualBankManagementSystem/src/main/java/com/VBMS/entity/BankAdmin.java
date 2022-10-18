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
@Table(name = "Bank_Admin_Details")
@NoArgsConstructor
@AllArgsConstructor
public class BankAdmin {
	
	//bank admin properties
	
	@Id
	@Column(name="Admin_username", length=15, nullable=false, unique=true)
	private String username;
	
	@Column(name="First_name", length=10, nullable=false)
	private String fname;
	
	@Column(name="Last_name", length=10, nullable=false)
	private String lname;
	
	@Column(name="password", length=15, nullable=false)
	private String password;
	
}
