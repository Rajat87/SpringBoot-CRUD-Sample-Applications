package com.springAspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectsMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);  
		
		Comment comment = new Comment();
		comment.setAuthor("Rajat");
		comment.setText("Completed All the Tasks");
		CommentAspectService commentService = context.getBean(CommentAspectService.class);
		commentService.publishComment(comment); // Now rather than calling the method directly we want the aspect with it's own logic to execute
		
		/*
		 * To create an aspect, you follow these steps (figure 6.5):
			1. Enable the aspect mechanism in your Spring app by annotating the configuration class
			with the @EnableAspectJAutoProxy annotation.
			2. Create a new class, and annotate it with the @Aspect annotation. Using either @Bean
			or stereotype annotations, add a bean for this class in the Spring context.
			3. Define a method that will implement the aspect logic and tell Spring when and which
			methods to intercept using an advice annotation.
			4. Implement the aspect logic.
		 */

	}

}
