package com.springAbstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
	private final CommentRepository commentRepository;
	private final CommentProxy commentProxy;
	
	@Autowired  // This is optional because we have only one constructor
	public CommentService(CommentRepository commentRepository, CommentProxy commentProxy ) {
		this.commentRepository=commentRepository;
		this.commentProxy=commentProxy;
	}
	
	public void publishMessage(Comment comment) {
		commentRepository.saveToRepository(comment);
		commentProxy.send(comment);
	}

}
