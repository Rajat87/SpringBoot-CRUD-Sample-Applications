package com.springboot.mvc.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.mvc.practice.model.Student;


public interface RepositoryInterface  extends JpaRepository<Student, Integer> {

}
