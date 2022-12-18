package com.springboot.course.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.course.model.Topic;
import com.springboot.course.repo.TopicRepository;


// Okay So I first need to configure Hibernate, the DB details in the application.properties. First I will try doing it using Spring Data JPA
// Once I get that I will try doing it using different ways which include Query DSl, and normal Hibernate
@RestController
@RequestMapping("/anotherCourseAPI")
public class HomeController {
	TopicRepository repository;
	
	@Autowired
	public HomeController(TopicRepository repository) {
		this.repository=repository;
	}
	
	// Passing absolutely nothing in the URL as request parameters using the query string or the Path variable
	
	@GetMapping("/getAllTopics")
	public ResponseEntity<?> getAllTopics() {
		System.out.println("Inside Get All Topics");
		//new ResponseEntity<>(HttpStatus.ACCEPTED);
		if(repository.getAllTopics().isEmpty()) {
			try {
				throw new RuntimeException();
			}catch(RuntimeException e) {
				return new ResponseEntity<String>("No Topics Found", HttpStatus.ACCEPTED);
			}
			
		}else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Sending some Info", "Sent By Rajat").body(repository.getAllTopics());
		}
		
		//Map<String, String> map = new HashMap<>();
		//map.put("Some Information", "Sent By Rajat");
		//return new ResponseEntity<List<Topic>>(repository.getAllTopics(), HttpStatus.ACCEPTED);
		//repository.getAllTopics();
	}
	// I'll first use a Path variable here. To do that I will have to pass all the three attributes
	// Then further I will have to use the @ModelAttribute
	@PostMapping("/addATopic")
	// Path variable is great but I will have to assign each value to a instance variable
	public Topic addATopic1(@RequestBody Topic topic) {
		return repository.addATopic(topic);
	}
	
	@PutMapping("/updateATopic")
	public Map<String, List<Topic>> updateATopic(@RequestParam("topicId") long topicId, @RequestBody Topic topic) {
		Map<String, List<Topic>> map = new HashMap<>();
		map.put("I retrieved a List of topics after updating it", repository.updateATopic(topicId, topic));
		
		// Here basically I am returning a String as a key
		// I can also return a accepted status code
		return map;
		
	}
	
	@DeleteMapping("/deleteATopic")
	public void deleteATopic(@RequestParam("topicId") long topicId) {
		repository.removeATopic(topicId);
	}
	
	// In Spring Data JPA the Table is created automatically as soon as the application executes
}
