package com.springboot.courseapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	TopicService service;
	
	@Autowired
	public TopicController(TopicService service) {
		this.service=service;
	}
	
	// Okay So all the implemented functionalities are working fine as of now but I have used the path variable for adding the values to the 
	// Object of the topic everywhere. For example I used the request Attribute before in MVC to get the value of the Alien from the form
	//Also there is concept of Http request and response which I probably should not be using here
	
	// Always put a / after the url in postman otherwise I got a error that the put request is not supported. 
	/*@PostMapping("/addTopic/{topicId}/{topicName}")
	public List<Topic> addRequest(@PathVariable  int topicId,@PathVariable String topicName){
		Topic topic = new Topic();
		System.out.println(topicName);
		topic.setTopicId(topicId);
		topic.setTopicName(topicName);
		return service.addTopic(topic); // This returns me a list of Topics
	}*/
	
	/*@PostMapping("/addTopic/{topicId}/{topicName}")
	public String addRequest(@PathVariable  int topicId,@PathVariable String topicName){
		 // This returns me a list of Topics
		return service.addTopic(topicId, topicName);
	}*/
	
	@PostMapping("/addTopic/")
	public String addRequest(@RequestBody Topic topic){
		 // This returns me a list of Topics
		return service.addTopic(topic.getTopicId(), topic.getTopicName());
	}
	
	/*@GetMapping("/getAllTopics")
	public ResponseEntity<List<Topic>> fetchRequest(){
		Map<HttpStatus, List<Topic>> map = new HashMap<>();
		map.put(HttpStatus.ACCEPTED, service.getAllTopics());
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Returned By Rajat","800").body(service.getAllTopics());
		//return service.getAllTopics();
	}*/
	
	
	@GetMapping("/getAllTopics")
	public Map<HttpStatus, List<Topic>> fetchRequest(){
		Map<HttpStatus, List<Topic>> map = new HashMap<>();
		map.put(HttpStatus.ACCEPTED, service.getAllTopics());
		return map;
		//return ResponseEntity.status(HttpStatus.ACCEPTED).header("Returned By Rajat","800").body(service.getAllTopics());
		//return service.getAllTopics();
	}
	
	
	/*@GetMapping("/getSingleTopic/{topicId}")   // I am able to get a Single record here
	public Topic getSingleTopic(@PathVariable  int topicId) {
		for(Topic topic : service.topics) {
			if(topicId==topic.getTopicId()) {
				System.out.println(topic.getTopicId());
				return topic;
			}
		}
		return null;
	}
	*/
	// Okay so far I am specifying all the topics in the URL using the path variable
	// This is not a great way to do it.
	// First I will do it using the @RequestBody where I should be able to pass all the instance variable values.
	/*@GetMapping("/getSingleTopic/{topicId}")   // I am able to get a Single record here
	public Topic getSingleTopic(@PathVariable  int topicId) {
		return service.getSingleTopic(topicId);
	}*/
	
	// The problem with request body here is that I need to pass the whole JSON object from the Request Body
	// If i just send a instance variable value it is not working
	// So probably a better way is to use the @requestParam
	@GetMapping("/getSingleTopic/")   // I am able to get a Single record here
	public Topic getSingleTopic(@RequestParam("id")  int id2) {  // Best way to do it
		System.out.println("Executing Using the @RequestParam");// Should also use the String with the @PathVariable
		return service.getSingleTopic(id2);
	}
	// The key is whatever string you pass must map with the local variable so the string inside the annotation specifies that no matter what 
	// name you give to your local variable doesn't matter if you Specify the name inside the @RequestAttribute
	//
	
	
	@PutMapping("/updateSingleTopic/{topicId}/{topicName}")   // I am able to get a Single record here
	// Just like the @RequestParam Annotation the local variable name should match the instance variable name. To get rid
	//of this issue i need to mention the String explicitly
	public Topic updateSingleTopic(@PathVariable("topicId")  int Id, @PathVariable String topicName) {
		//System.out.println("Inside the Method");
		for(Topic topic : service.getAllTopics()) {
			if(Id==topic.getTopicId()) {
				//topic.setTopicName(topicName); // This should change the topic name of the topic that I have found
				service.addTopic(Id, topicName);
				return topic;
			}
		}
		return null;
	}
	
	/*@PostMapping("/deleteSingleTopic/{topicId}")
	public List<Topic> deleteSingleTopic(@PathVariable int topicId){
		return 	service.deleteTopic(topicId);
	}*/
	
	@DeleteMapping("/deleteSingleTopic/")
	public List<Topic> deleteSingleTopic(@RequestParam("id") int topicId){
		return 	service.deleteTopic(topicId);
		
	}
	
}
