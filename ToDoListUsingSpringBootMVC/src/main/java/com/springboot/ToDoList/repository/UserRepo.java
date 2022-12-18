package com.springboot.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ToDoList.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
}
