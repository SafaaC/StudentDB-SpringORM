package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//save student method
	@Transactional
	public int insert(Student std) {
		
		Integer i=(Integer) this.hibernateTemplate.save(std);
		System.out.println("data inserted successfully");
		return i;
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
	
}
