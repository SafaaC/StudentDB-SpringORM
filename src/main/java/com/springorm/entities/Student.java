package com.springorm.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

//table of student
@javax.persistence.Entity
@Table(name="student_details")
public class Student {
	@Id
	@Column(name="student_id")
	private int stdId;
	@Column(name="student_name")
	private String stdName;
	@Column(name="student_mail")
	private String stdMail;
	public Student(int stdId, String stdName, String stdMail) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdMail = stdMail;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdMail() {
		return stdMail;
	}
	public void setStdMail(String stdMail) {
		this.stdMail = stdMail;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdMail=" + stdMail + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
