package com.springboot.rest.practice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.rest.practice.model.Student;
import com.springboot.rest.practice.repository.MyRepoInterface;

@Service

public class RepoService {
	MyRepoInterface repo;
	
	// We get a Object of the class which implements this interface. The class is located in the proxy package
	@Autowired
	public RepoService(MyRepoInterface repo) {
		this.repo=repo;
	}
	@Transactional
	public List<Student> addAStudent(Student student){
		if(student.getStudentid()<101) {
			throw new RuntimeException();
		}else {
			repo.save(student);
			
			return getAllStudents();
		}
		
	}
	
	public List<Student> getAllStudents(){
		return repo.findAll(Sort.by("studentid"));
	}
	@Transactional
	public List<Student> updateAStudent(Student student){
		boolean isStudenIdPresent=false;
		for(Student s : getAllStudents()) {
			if(s.getStudentid()==student.getStudentid()) {
				isStudenIdPresent=true;
			}
		}
		if(!isStudenIdPresent) {
			throw new RuntimeException();
		}
		
		for(Student s: getAllStudents()) {
			if(s.getStudentid()==s.getStudentid()) {
				repo.save(student);
				
			}
		}
		return getAllStudents();
	}
	
	@Transactional
	public List<Student> deleteAStudent(int studentId){
		boolean isStudenIdPresent=false;
		for(Student s : getAllStudents()) {
			if(s.getStudentid()==studentId) {
				isStudenIdPresent=true;
			}
		}
		
		if(!isStudenIdPresent) {
			throw new RuntimeException();
		}
		repo.deleteById(studentId);
		return getAllStudents();
	}
}
