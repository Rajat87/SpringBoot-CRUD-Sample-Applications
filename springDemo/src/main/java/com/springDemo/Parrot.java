package com.springDemo;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

	private String name;
//	private Person person;  // If we just declare a reference it is just given a value null
	
/*	public Parrot(Person person) {          // This will give an error because it is asking for a person present in the context which might have not been created because the person needs aparrot to be created.
		super();
		System.out.println("Parrot created and added in the context");
		this.person=person;
	}
*/
	public Parrot() {          // This will give an error because it is asking for a person present in the context which might have not been created because the person needs aparrot to be created.
		super();
		System.out.println("Parrot created and added in the context");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void postConstruct() {
		this.name="Harry";
	}

	@Override
	public String toString() {
		return "Parrot [name=" + name + "]";
	}
	
	
}
