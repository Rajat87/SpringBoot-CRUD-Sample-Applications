package com.springAspect;

import org.springframework.stereotype.Component;

@Component
public class PersistenceImplementer implements PersistenceContract {

	@Override
	public void saveComment(Comment comment) {
		System.out.println("Comment Persisted");	
	}

}
