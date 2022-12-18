package com.springboot.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboot.course.model.Topic;

@Repository // This will ensure that the object will be created in the Application Context
public interface TopicRepo extends JpaRepository<Topic, Long> {

}
