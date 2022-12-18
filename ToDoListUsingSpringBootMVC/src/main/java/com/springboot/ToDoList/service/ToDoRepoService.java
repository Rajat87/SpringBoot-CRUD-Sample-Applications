package com.springboot.ToDoList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ToDoList.Model.ToDo;

@Service
public interface ToDoRepoService {
	
	List<ToDo> returnAllToDo();
	List<ToDo> addToDo(ToDo toDo);
	List<ToDo> updateToDo(ToDo toDo);
	List<ToDo> removeToDo(long toDoId);
	
	
}
