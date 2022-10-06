package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	private long id;
	@Column(length=10, nullable=false)
	private String idType;
	@Column(length=50, nullable=false)
	private String address;
	@Column(length=20, nullable=false)
	private String city;
	@Column(length=20, nullable=false)
	private String state;
	@Column(length=10, nullable=false)
	private int pincode;
	
	@OneToOne(targetEntity=Citizen.class)
	private Citizen citizen;	//aggregration
}
