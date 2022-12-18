package com.springboot.ToDoList.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {
	// I have a todo object 
	// No user Authentication is done right now
	// What I want is that the front controller it will direct me to the Home Page first
	// On the home page I display all the List items.
	// Next I let's say I add a button which will redirect me to the Add To do page
	//
	@Id
	private long topicId;
	private String subject;
	private String description;
	public ToDo() {
		super();
	}
	public ToDo(long topicId,String subject, String description) {
		super();
		this.topicId=topicId;
		this.subject = subject;
		this.description = description;
	}
	
	
	
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ToDo [topicId=" + topicId + ", subject=" + subject + ", description=" + description + "]";
	}
	
	
	// Let's say I create a homepage
	// Initially it will be empty
	// I will give a form which will handle all the post requests
	// In the form I will give a subject
	// Also in the form I will give a Description
	//
	
}
