package com.rajat.HibernateDemo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	int rollNo;
	String name;
	int marks;
	@ManyToMany(mappedBy = "student")
	List <Laptop> laptops;
	
	
	public Student() {
		super();
	}
	public Student(int rollNo, String name, int marks, List <Laptop> laptops) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.laptops = laptops;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + ", laptop=" + laptops + "]";
	}
	
	
	
}
