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
@DiscriminatorValue(value = "2 wheel")
public class TwoWheels extends Vehicle{
	private int modelno;
	private String modelname;
	private boolean abs;
	private int tyretype;
	private String btype;
}
