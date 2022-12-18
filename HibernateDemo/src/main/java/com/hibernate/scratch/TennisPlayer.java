package com.hibernate.scratch;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TennisPlayer {
	@Id
	private int id;
	private String name;
	private int grandSlams;
	public TennisPlayer() {
		super();
	}
	public TennisPlayer(int id , String name, int grandSlams) {
		super();
		this.id=id;
		this.name = name;
		this.grandSlams = grandSlams;
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
	public int getGrandSlams() {
		return grandSlams;
	}
	public void setGrandSlams(int grandSlams) {
		this.grandSlams = grandSlams;
	}
	@Override
	public String toString() {
		return "TennisPlayer [id=" + id + ", name=" + name + ", grandSlams=" + grandSlams + "]";
	}
	
	
	
}
