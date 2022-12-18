package com.springAbstraction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Requirement
		/*Say you are implementing an app a team uses to manage their tasks. One of the app’s
		features is allowing the users to leave comments for the tasks. When a user publishes a
		comment, it is stored somewhere (e.g., in a database), and the app sends an email to a
		specific address configured in the app.
		*/
		
		
		Comment comment = new Comment();
		comment.setAuthor("Rajat");
		comment.setText("Task Completed");
		/*
		//Conventional Way to complete the message save and email Task without using any spring
		CommentService commentService = new CommentService(new CommentRepositoryImplementer(), new CommentProxyImplementer());
		
		commentService.publishMessage(comment);
		*/
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommentConfiguration.class);
		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishMessage(comment);
	}

}
