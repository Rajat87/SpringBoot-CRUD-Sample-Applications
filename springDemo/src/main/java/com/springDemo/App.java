package com.springDemo;

import java.util.function.Supplier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.function.SingletonSupplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	// This is a programmatic way of putting and getting a Object from the Context
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Parrot parrot = new Parrot();
        parrot.setName("John");
        Supplier<Parrot> supplier = ()-> parrot;
        applicationContext.registerBean("parrot1",Parrot.class,supplier);
        */
    	
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    	Parrot parrotFromContext = applicationContext.getBean(Parrot.class); // If we have multiple classes we need to pass the method name
    	Person person = applicationContext.getBean(Person.class);
    	
        System.out.println(person);
        
       // SingletonSupplier<T> // Need to check how to object is created due to which the get method is called
       
    }
}
