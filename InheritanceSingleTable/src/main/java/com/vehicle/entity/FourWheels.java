package com.vehicle.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "4 wheel")
public class FourWheels extends Vehicle{
	private int modelno;
	private String modelname;
	private boolean musicSystem;
	private String etype;
	private boolean ac;
	
}
