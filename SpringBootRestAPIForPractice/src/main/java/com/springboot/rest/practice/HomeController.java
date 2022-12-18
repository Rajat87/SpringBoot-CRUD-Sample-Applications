package com.springboot.rest.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.practice.model.Student;
import com.springboot.rest.practice.service.RepoService;

@RestController
public class HomeController {
	/* Okay again I a creating a Student REST API. SO what I am supposed to do is to create 4 CRUD operation methods again using JPA
	 * So the first step will be to add all the dependencies in maven
	 * I have added that now the next step is to create a Rest controller which I have created. 
	 * Now I have to create a Model object in which I will store all the information.
	 * Model is created. Now I should add all the configuration in the application.properties file
	 * Once I do that I can create a CRUD repository and then continue building from there
	 * Today after creating a normal REST API I will explore validations and @Transactional annotations
	 * Once I do that then again the focus moves back to Core Java
	 */
	
	RepoService repoService;
	@Autowired
	public HomeController(RepoService repoService) {
		this.repoService = repoService;
	}
	@GetMapping("/home/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Sent By Rajat", "Request was successfull").body(repoService.getAllStudents()) ;
	}
	@PostMapping("/home/addAStudent")
	public HashMap<String, List<Student>> addAStudent(@RequestBody Student student){
		HashMap<String, List<Student>> map = new HashMap<>();
		try {
			repoService.addAStudent(student);
		} catch (Exception e) {
			map.put("One of the values entered was invalid. Transaction rolled back", repoService.getAllStudents());
			return map;
		}
		
		map.put("Returned By Rajat's REST API and the the sent Object was successfully saved", repoService.getAllStudents());
		return map;
	}
	@PutMapping("/home/updateAStudent")
	public HashMap<HttpStatus, List<Student>> updateAStudent(@RequestBody Student student){
		HashMap<HttpStatus, List<Student>> map = new HashMap<>();
		try {
			repoService.updateAStudent(student);
		} catch (Exception e) {
			map.put(HttpStatus.BAD_REQUEST, repoService.getAllStudents());
			return map;
		}
		
		map.put(HttpStatus.ACCEPTED, repoService.getAllStudents());
		return map;
	}
	@DeleteMapping("/home/deleteAStudent")
	public HashMap<HttpStatus, List<Student>> deleteAStudent(@RequestParam("student_id") int id){
		HashMap<HttpStatus, List<Student>> map = new HashMap<>();
		try {
			repoService.deleteAStudent(id);
		} catch (Exception e) {
			map.put(HttpStatus.BAD_REQUEST, repoService.getAllStudents());
			return map;
		}
		map.put(HttpStatus.ACCEPTED, repoService.getAllStudents());
		return map;
	}
	
}
