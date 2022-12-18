package com.springAspect;

import org.springframework.stereotype.Component;

@Component
public class SendImplementer implements SendContract {

	@Override
	public void sendComment(Comment comment) {
		System.out.println("Comment Sent");
		
	}
	
}
