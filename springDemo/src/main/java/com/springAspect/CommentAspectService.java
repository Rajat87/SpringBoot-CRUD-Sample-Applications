package com.springAspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentAspectService {
	private PersistenceImplementer persist;
	private SendImplementer send;
	
	@Autowired
	public CommentAspectService(PersistenceImplementer persist, SendImplementer send) {
		this.persist = persist;
		this.send = send;
	}

	public void publishComment(Comment comment) {
		persist.saveComment(comment);
		send.sendComment(comment);
		System.out.println(comment.getText());
	}
	
}
