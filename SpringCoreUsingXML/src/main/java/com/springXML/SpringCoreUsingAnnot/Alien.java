package com.springXML.SpringCoreUsingAnnot;

import org.springframework.stereotype.Component;

@Component
public class Alien {

	private int age;
	Laptop laptop;
	
		
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	


	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	@Override
	public String toString() {
		return "Alien [age=" + age + ", laptop=" + laptop + "]";
	}

	public void coding() {
		System.out.println("Alien is coding");
	}
	
	
	
}
