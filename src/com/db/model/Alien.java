package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="alien_table")
public class Alien {
	
	@Id
	int id;
	AlienName name;
	String color;
	
	public Alien() {}
	
	public Alien(int id, AlienName name,String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public AlienName getName() {
		return name;
	}

	public void setName(AlienName name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
