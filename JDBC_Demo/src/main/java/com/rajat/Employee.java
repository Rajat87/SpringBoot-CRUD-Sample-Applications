package com.rajat;

public class Employee {
	int id;
	String name;
	int age;
	String email;
	String address;
	
	
	public Employee() {
		super();
	}


	public Employee(int id, String name, int age, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", address=" + address
				+ "]";
	}
	
	
	
}
