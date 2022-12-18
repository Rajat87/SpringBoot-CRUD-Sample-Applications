package com.springboot.ToDoList.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboot.ToDoList.Model.ToDo;

/**
 * 
 */

/**
 * @author Rajat
 *
 */
@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
