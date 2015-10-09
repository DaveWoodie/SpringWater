package com.netbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netbuilder.entities.Role;
import com.netbuilder.entityrepository.RoleRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private RoleRepository repo;

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		repo.deleteAll();
		repo.save(new Role(0, "Warehouse Manager"));
		
		for(Role r : repo.findAll()){
			System.out.println(r);
		}
	}
}