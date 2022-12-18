package com.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration  //Part of Bean Way
@ComponentScan(basePackages = "com.springDemo")  // Using stereotype Configuration
public class Config {
/*	@Bean
	Parrot parrot() {
		Parrot parrot = new Parrot();
		parrot.setName("Jack");
		return parrot;
	}
*/	
/*	@Bean
	Person person() {
		Person person = new Person();
		person.setName("Rajat");
		person.setParrot(parrot());
		return person;
	}
*/	
	
	// Now to avoid all this configuration we can use the stereotype configuration along with the @autowired annotation which will map them. The only down side is that we will not be able to initialize.
	
/*	
	@Bean
	Person person(Parrot pRef) {
		Person person = new Person();
		person.setName("Rajat");
		person.setParrot(pRef);
		return person;
	}
*/	
}

