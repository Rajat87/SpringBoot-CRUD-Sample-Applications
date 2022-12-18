package com.springboot.rest.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.practice.model.Student;

public interface MyRepoInterface extends JpaRepository<Student, Integer>{

}
