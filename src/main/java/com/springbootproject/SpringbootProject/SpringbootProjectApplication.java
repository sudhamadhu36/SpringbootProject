package com.springbootproject.SpringbootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EntityScan("com.springproject.springbootproject.model")
@EnableJpaRepositories("com.springproject.springbootproject.repository")
@ComponentScan("com.springproject.springbootproject.controller")
@ComponentScan("com.springbootproject.SpringbootProject.Service.EmployeeService")
public class SpringbootProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}
	
}
