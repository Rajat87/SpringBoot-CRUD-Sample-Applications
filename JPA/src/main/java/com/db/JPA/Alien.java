package com.db.JPA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Alien {
	@Id
	private String aid;
	private String name;
	
	public Alien() {
		super();
	}
	public Alien(String aid, String name) {
		super();
		this.aid = aid;
		this.name = name;
		
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + name + ", laptop="+"]";
	}
	
	
}
