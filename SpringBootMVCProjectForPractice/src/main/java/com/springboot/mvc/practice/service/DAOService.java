package com.springboot.mvc.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.mvc.practice.model.Student;
import com.springboot.mvc.practice.repo.RepositoryInterface;

@Service
public class DAOService {
	RepositoryInterface repo;
	
	@Autowired
	public DAOService(RepositoryInterface repo) {
		this.repo=repo;
	}
	
	public List<Student> addAStudent(Student student) {
		repo.save(student);
		return getAllStudents();
	}
	
	public List<Student> getAllStudents() {
		return repo.findAll(Sort.by("studentid"));
	}
	
	public List<Student> updateAStudent(int student_id, Student student){
		for(Student s : getAllStudents()) {
			if(s.getStudentid()==student_id) {
				addAStudent(student);
			}
		}
		return getAllStudents();
	}
	
	
	public List<Student> deleteAStudent(int studentid){
		repo.deleteById(studentid);
		return getAllStudents();
	}
}
