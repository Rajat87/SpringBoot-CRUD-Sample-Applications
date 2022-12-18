package com.anotheraspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnotherAspectMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
		
		AspectService aspectService = context.getBean(AspectService.class);// Will get the Proxy object of this class
		
		System.out.println(aspectService.add(5, 8));
	}

}
