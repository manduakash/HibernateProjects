package com.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "vid")
public class FourWheels extends Vehicle{
	private int modelno;
	private String modelname;
	private boolean musicSystem;
	private String etype;
	private boolean ac;
	
}
