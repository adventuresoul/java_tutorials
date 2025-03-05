package com.spring.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jdbc.models.Student;
import com.spring.jdbc.repo.StudentRepo;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(JdbcApplication.class, args);

		Student stu1 = context.getBean(Student.class);
		stu1.setId(103);
		stu1.setName("Vinay");
		stu1.setTech("Java");

		StudentRepo repo = context.getBean(StudentRepo.class);
		repo.save(stu1);
		System.out.println(repo.findAll());
	}
}
