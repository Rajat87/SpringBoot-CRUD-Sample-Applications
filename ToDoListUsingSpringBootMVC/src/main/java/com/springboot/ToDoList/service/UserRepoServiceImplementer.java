package com.springboot.ToDoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ToDoList.Model.User;
import com.springboot.ToDoList.repository.UserRepo;

@Service
public class UserRepoServiceImplementer implements UserRepoService {
	// The object needs to be created for this and for that will be done by spring
	// I have provided the @Service annotation so Spring will create the object of this class and now when I create a constructor with the
	// @Autowire annotation will map the object of the UserRepo with this reference variable
	// But the thing is that is also a Interface so when we add the @Repository annotation above it it's the subclass which implements those
	// methods that class's object will be created by Spring
	@Autowired
	UserRepo repo;
	List<User> users =  new ArrayList<>();
	@Override
	public List<User> addAUser(User user) {
		 
		users.add(repo.save(user));
		return users;
	}

	@Override
	public List<User> returnAllUsers() {
		users = repo.findAll();
		return users;
	}

	@Override
	public List<User> removeAUser(Long userID) {
		repo.deleteById(userID);
		users = returnAllUsers();
		return users;
	}

	@Override
	public List<User> updateAUser(User user) {
		// User that I pass here will have the same Id as the already existing one
		// So the save here should basically replace the already present record there
		repo.save(user);
		users = returnAllUsers();
		return users;
	}

}
