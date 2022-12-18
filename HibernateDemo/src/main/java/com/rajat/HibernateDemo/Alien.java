package com.rajat.HibernateDemo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//Bean
@Entity
public class Alien {
	@Id
	private int aId;
	private Name name;
	private String color;
	@OneToMany(mappedBy = "alien",fetch = FetchType.EAGER)
	List<Laptop> laptops;
	
	
	public Alien() {
		super();
	}


	public Alien(int aId, Name name, String color, List<Laptop> laptops) {
		super();
		this.aId = aId;
		this.name = name;
		this.color = color;
		this.laptops = laptops;
	}

	

	public int getaId() {
		return aId;
	}


	public void setaId(int aId) {
		this.aId = aId;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public List<Laptop> getLaptops() {
		return laptops;
	}


	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}


	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", name=" + name + ", color=" + color + ", laptops=" + laptops + "]";
	}


	
	
	
	
	
	
}
