package com.db.JPA;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Laptop {
	//@Id
	private String lid;
	private String Brand;
	public Laptop() {
		super();
	}
	public Laptop(String lid, String brand) {
		super();
		this.lid = lid;
		Brand = brand;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", Brand=" + Brand + "]";
	}
	
	
}
