package com.rajat.HibernateDemo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Laptop {
	@Id
	int lid;
	@ManyToOne
	Alien alien;
	String laptopName;
	
	public Laptop() {
		super();
	}

	public Laptop(int lid, Alien alien, String laptopName) {
		super();
		this.lid = lid;
		this.alien = alien;
		this.laptopName = laptopName;
	}
	
	

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public Alien getAlien() {
		return alien;
	}

	public void setAlien(Alien alien) {
		this.alien = alien;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	

	

	

	


	
	
	
}
