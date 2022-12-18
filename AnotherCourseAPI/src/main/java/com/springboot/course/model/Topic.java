package com.springboot.course.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	private long topicId;
	private String topicName;
	private String topicDescription;
	
	public Topic() {
		
	}
	
	public Topic(long topicId, String topicName, String topicDescription) {
		this.topicId=topicId;
		this.topicName=topicName;
		this.topicDescription=topicDescription;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ "]";
	}
	
	
}
