package com.vehicle.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverrides({
	@AttributeOverride(name="vid", column=@Column(name="vid")),
	@AttributeOverride(name="fuel", column=@Column(name="fuel")),
	@AttributeOverride(name="engine", column=@Column(name="engine")),
	@AttributeOverride(name="vtype", column=@Column(name="vtype")),
	@AttributeOverride(name="price", column=@Column(name="price")),
	@AttributeOverride(name="speed", column=@Column(name="speed"))
})
public class FourWheels extends Vehicle{
	private int modelno;
	private String modelname;
	private boolean musicSystem;
	private String etype;
	private boolean ac;
	
}
