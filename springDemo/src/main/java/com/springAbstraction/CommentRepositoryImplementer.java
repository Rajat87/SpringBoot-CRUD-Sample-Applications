package com.springAbstraction;

import org.springframework.stereotype.Component;

@Component
public class CommentRepositoryImplementer implements CommentRepository {

	@Override
	public void saveToRepository(Comment comment) {
		System.out.println(comment.getAuthor()+"'s Comment Saved to Repository");
		
	}

}
