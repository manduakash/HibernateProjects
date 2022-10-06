package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Citizen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	@Column(length=20, nullable=false)
	private String cname;
	@Column(length=20, nullable=false)
	private String surname;
	@Column(length=11, nullable=false, unique=true)
	private long phone;
	@Column(length=30, nullable=false, unique=true)
	private String email;
	@Column(length=20, nullable=false)
	private String dob;
	
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	private Address address;	//aggregration
	
	
}
