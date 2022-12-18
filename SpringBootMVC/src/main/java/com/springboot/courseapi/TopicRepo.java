package com.springboot.courseapi;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

// Implementing this interface gives me all the methods that I need to perform CRUD operations
@Service
public interface TopicRepo extends JpaRepository<Topic, Integer> {

}
