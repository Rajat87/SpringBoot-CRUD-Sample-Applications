package com.springboot.rest.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;

@Entity

public class Student {
	@Id
	int studentid;
	String studentName;
	int studentMarks;

	public Student() {
		super();
	}
	public Student(int studentid, String studentName, int studentMarks) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ "]";
	}
	
}
