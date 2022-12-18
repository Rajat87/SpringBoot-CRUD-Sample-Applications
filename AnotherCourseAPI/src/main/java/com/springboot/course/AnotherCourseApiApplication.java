package com.springboot.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.course.*"})
public class AnotherCourseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotherCourseApiApplication.class, args);
		System.out.println("Hello World");
	}

}
