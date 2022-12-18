package com.springboot.ToDoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ToDoList.Model.ToDo;
import com.springboot.ToDoList.Model.User;
import com.springboot.ToDoList.repository.ToDoRepo;

@Service
public class ToDoRepoServiceImplementer implements ToDoRepoService{
	@Autowired
	ToDoRepo doRepo;
	@Override
	public List<ToDo> returnAllToDo() {
		return doRepo.findAll(); // List of all the ToDo's
	}

	@Override
	public List<ToDo> addToDo(ToDo toDo) {
		doRepo.save(toDo);
		return doRepo.findAll();
	}

	@Override
	public List<ToDo> updateToDo(ToDo toDo) {
		for(ToDo do1 : doRepo.findAll()) {
			if(do1.getTopicId()==toDo.getTopicId()) {
				doRepo.save(toDo);
			}
		}
		return doRepo.findAll();
	}

	@Override
	public List<ToDo> removeToDo(long toDoId) {
		doRepo.deleteById(toDoId);
		return doRepo.findAll();
	}
	
	

}
