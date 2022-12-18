package com.springboot.course.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.course.model.Topic;

@Service
public class TopicRepository {
	@Autowired
	TopicRepo repo;	
	
	public List<Topic> getAllTopics() {
		return repo.findAll(Sort.by(Sort.Direction.ASC,"topicId"));
	}
	
	public Topic addATopic(Topic topic) {
		return repo.save(topic);
	}
	
	public List<Topic> updateATopic(long topicId, Topic topic) {
		for(Topic topic2 : getAllTopics()) {
			if(topic2.getTopicId()==topicId) {
				repo.save(topic);
			}
		}
		return getAllTopics();
	}
	
	public void removeATopic(long topicId) {
		repo.deleteById(topicId);
	}
}
