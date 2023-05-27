package com.springorm.dao;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {
	static Scanner sc = new Scanner(System.in);
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//save student method
	@Transactional
	public void insert(Student std) {
		
		this.hibernateTemplate.save(std);
		System.out.println("data inserted successfully");
		
	}
	
	//get single data/object
	public Student getStudent(int stdId) {
		Student std =hibernateTemplate.get(Student.class, getClass());
		return std;
	}
	
	//get all students/all row
	public List<Student> getallStudents(){
		List<Student> stds=hibernateTemplate.loadAll(Student.class);
		return stds;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int stdId) {
		Student student=hibernateTemplate.get(Student.class, stdId);
		hibernateTemplate.delete(student);
		System.out.println("Student data deleted successfully");
	}
	
	//update data
	@Transactional
	public void updateStudent(Student std) {
		hibernateTemplate.update(std);
	}
	public static Student readInput() {
		System.out.println("Enter Id ");
		int id = sc.nextInt();
		System.out.println("Enter Name ");
		String name = sc.next();
		System.out.println("Enter email ");
		String mail = sc.next();
		Student std = new Student(id, name, mail);
		return std;
	}
	
}
