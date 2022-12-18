package com.rajat.HibernateDemo;

import javax.persistence.Embeddable;


//We can either mark a class as Entity to store it as a table or Embeddable to store it as columns in another table.
//But if you mark a class as Entity and make it a attribute in some other class directly it will not work.
//We will need to define a relationship between them.
@Embeddable
public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	
	
	public Name() {
		super();
	}
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
	
	
}
