package com.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao=context.getBean("stdDao",StudentDao.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		while (true) {
			System.out.println("1-Insert \n2-Update \n3-Delete \n4-Get Student By Id \n5-Dispaly All Students \n6-Exit");
			System.out.println("Enter your choice :");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Student std1=StudentDao.readInput();
				studentDao.insert(std1);
				break;
			case 2:
				Student std=StudentDao.readInput();
				studentDao.updateStudent(std);;
				break;

			case 3:
				int stdId=sc.nextInt();
				studentDao.deleteStudent(stdId);
				break;

			case 4:
				int studId=sc.nextInt();
				Student student2 = studentDao.getStudent(studId);
				System.out.println(student2);
				break;

			case 5:
				List<Student> stds = studentDao.getallStudents();
				for (Student student : stds) {
					System.out.println(student);
				}
				break;

			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
		} 
	}

}
