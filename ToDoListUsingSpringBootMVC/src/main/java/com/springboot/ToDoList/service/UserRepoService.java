package com.springboot.ToDoList.service;

import java.util.List;

import com.springboot.ToDoList.Model.User;

	// It is nothing just a interface which defines the methods that I need to have in my repository class.
	public interface UserRepoService  {
	public List<User> addAUser(User user);  // This will take a User object and persist it in the DB
	public List<User> returnAllUsers(); // This will fetch all the Users from the DB
	public List<User> removeAUser(Long userID); //This will remove the user whose Id i will pass in the method
	public List<User> updateAUser(User user); //I will pass the object and basically replace the old object with the new object
}
