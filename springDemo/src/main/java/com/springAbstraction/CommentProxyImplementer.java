package com.springAbstraction;

import org.springframework.stereotype.Component;

@Component
public class CommentProxyImplementer implements CommentProxy {

	@Override
	public void send(Comment comment) {
		System.out.println(comment.getAuthor()+"'s Comment Sent Via Email");
		
	}

}
