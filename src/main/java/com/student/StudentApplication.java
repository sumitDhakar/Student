package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.been.Role;
import com.student.repo.RoleRepository;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner  {
	@Autowired
	private  RoleRepository roleRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	public   void createRole() {
		// TODO Auto-generated method stub
		Role role = new Role(1l, "STUDENT");
		Role role2 = new Role(2l, "ADMIN");
		Role role3 = new Role(3l, "USER");
		

		if (!roleRepository.existsById(1l)) {
		   roleRepository.save(role);
		   roleRepository.save(role2);
		   roleRepository.save(role3);
		}
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.createRole();
	}

}
