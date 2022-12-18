package com.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private Parrot parrot;

	@Autowired
	public Person(Parrot parrot) {
		super();
		System.out.println("Parameterized constructor called and initialized with the parrot in the spring context");
		this.parrot=parrot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parrot getParrot() {
		return parrot;
	}
	public void setParrot(Parrot parrot) {
		this.parrot = parrot;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", parrot=" + parrot + "]";
	}
	
	
	
	
}
