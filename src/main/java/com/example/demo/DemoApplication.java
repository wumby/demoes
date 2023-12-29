package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repo.findById(10001L);
		System.out.println(course.getId());
		repo.deleteById(10001L);
	}
}
