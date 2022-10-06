package com.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vid;
	
	@Column(length=10)
	private String fuel ;
	
	@Column(length=10)
	private String enginePower;
	
	@Column(length=4)
	private int speed;

	@Column(length=10)
	private String vtype;
	
	@Column(length=4)
	private int price;
}
