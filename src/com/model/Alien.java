package com.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	int id;
	String name;
	String color;
	
	public Alien() {}
	
	public Alien(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
