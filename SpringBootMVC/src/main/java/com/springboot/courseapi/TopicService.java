package com.springboot.courseapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// So this should act as my repository where I have added all the methods that Interact with the DB
// Instead of a list I will need a session object which will save the value of the object in DB.
@Service
public class TopicService {
	List<Topic> topics = new ArrayList<Topic>(); // I am directly Initializing it otherwise I might need getters and setters
	@Autowired
	TopicRepo repo;
	public String addTopic(int topicId,String topicName) {
		Topic topic = new Topic();
		System.out.println(topicName);
		topic.setTopicId(topicId);
		topic.setTopicName(topicName);
		
		repo.save(topic); // Using the give interface to execute CRUD operations
		// All this is done using Spring Boot which is why I do not need to implement logics of these standard operations
		return "added";
	}
	
	public List<Topic> deleteTopic(int topicId) {
		//topics.remove(topic); 
		repo.deleteById( topicId);
		return topics;
	}
	
	public List<Topic> updateTopic(Topic topic, int topicId, String topicName) {
		int index = topics.indexOf(topic);// I have got the Index
		topics.get(index).setTopicId(topicId);
		topics.get(index).setTopicName(topicName);
		return repo.findAll();
	}
	
	public List<Topic> getAllTopics(){
		System.out.println(repo.getClass());
		return repo.findAll();  // This function of the JPA gives me a list of type myObject
	}
	
	public Topic getSingleTopic(int topicId) {
		return repo.findById(topicId).get();
	}
}
