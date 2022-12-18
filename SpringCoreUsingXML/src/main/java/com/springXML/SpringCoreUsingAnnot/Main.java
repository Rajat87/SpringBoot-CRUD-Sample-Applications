package com.springXML.SpringCoreUsingAnnot;

import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// Done using both Stereotype and normal Bean Annotation
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AlienConfig.class);
		Alien alien = context.getBean(Alien.class);
		Laptop laptop = context.getBean(Laptop.class);
		System.out.println(alien);
		System.out.println(laptop);
		alien.coding();
		
		
		// Programmatic Way
		
		
		
	}

}
