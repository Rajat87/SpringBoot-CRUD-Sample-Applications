package com.springXML.SpringCoreUsingXML;

public class Alien {
	
	private int age;
	private Laptop laptop;
	public void setAge(int age) {
		this.age=age;
	}
	
	
	
	public Alien(int age, Laptop laptop) {
		super();
		this.age = age;
		this.laptop = laptop;
	}



	public void setLaptop(Laptop laptop) {
		this.laptop=laptop;
	}
	
	public void code(){
		System.out.println("I'm Coding");
		laptop.show();
	}

	@Override
	public String toString() {
		return "Alien [age=" + age + ", laptop=" + laptop + "]";
	}

	

	
}
