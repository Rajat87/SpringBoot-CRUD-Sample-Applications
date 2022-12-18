package com.hibernate.scratch;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private String student_id;
	private Name name;
	private int age;
	@OneToMany(mappedBy = "student")  // No foreign key will be created in the student table. But a foreign key of type student will be created in the Laptop table.
	private List<Laptop> laptop;
	
	public Student() {
		super();
	}
	
	
	public Student(String student_id, Name name, int age, List<Laptop> laptop) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.age = age;
		this.laptop = laptop;
	}

	
	
	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<Laptop> getLaptop() {
		return laptop;
	}


	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}


	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", age=" + age + ", laptop=" + laptop + "]";
	}


	


	
	
	
	
	
}
