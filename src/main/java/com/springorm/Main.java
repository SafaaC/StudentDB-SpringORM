package com.springorm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao=context.getBean("stdDao",StudentDao.class);
		Student std= new Student(1, "safaa", "safaa@gmail.com");
		int r=studentDao.insert(std);
		System.out.println("done" +r);
	}

}
