package com.springBeanScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		CommentService commentService = context.getBean(CommentService.class);
		UserService service = context.getBean(UserService.class);
		boolean b = commentService.getRepository()==service.getRepository();
		System.out.println(commentService.getRepository());
		System.out.println(b);
	}

}
