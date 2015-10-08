package com.netbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import com.netbuilder.entities.Role;
import com.netbuilder.entityrepository.RoleRepository;

@Configuration
@SpringBootApplication
public class Application{
	
	@Autowired
	private RoleRepository repo;

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

}
