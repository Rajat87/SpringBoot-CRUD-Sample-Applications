package com.hibernate.scratch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private String laptod_id;
	private String Brand;
	@ManyToOne
	private Student student;
	public Laptop() {
		super();
	}
	public Laptop(String laptod_id, String brand, Student student) {
		super();
		this.laptod_id = laptod_id;
		Brand = brand;
		this.student=student;
	}
	public String getLaptod_id() {
		return laptod_id;
	}
	public void setLaptod_id(String laptod_id) {
		this.laptod_id = laptod_id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [laptod_id=" + laptod_id + ", Brand=" + Brand + ", student=" + student + "]";
	}
	
	
	
}
